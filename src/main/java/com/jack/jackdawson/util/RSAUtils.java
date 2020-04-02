package com.jack.jackdawson.util;

import lombok.extern.slf4j.Slf4j;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Slf4j
public class RSAUtils {

    /**
     * 得到产生的私钥/公钥对
     * @return KeyPair
     */
    public static KeyPair getKeypair(){
        //产生RSA密钥对(myKeyPair)
        KeyPairGenerator myKeyGen = null;
        try {
            myKeyGen = KeyPairGenerator.getInstance("RSA");
            myKeyGen.initialize(1024);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        KeyPair myKeyPair = myKeyGen.generateKeyPair();
        return myKeyPair;
    }

    /**
     * 根据私钥和信息生成签名
     * @param privateKey
     * @param data
     * @return 签名的Base64编码
     */
    public static String sign(String privateKey, String data) {
        Signature sign;
        String res = "";
        try {
            sign = Signature.getInstance("MD5WithRSA");
            sign.initSign(getPrivateKey(privateKey));
            sign.update(data.getBytes());
            byte[] signSequ = sign.sign();
            res = Base64.getEncoder().encodeToString(signSequ);
        } catch(NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            log.error("sign error", e);
        }

        return res;
    }

    /**
     * 验证签名
     * @param publicKey 公钥的Base64编码
     * @param sign 签名的Base64编码
     * @param data 生成签名的原数据
     * @return
     */
    public static boolean verifySign(String publicKey, String data, String sign) {
        boolean res = true;
        try {
            Signature signature = Signature.getInstance("MD5withRSA");
            signature.initVerify(getPublicKey(publicKey));
            signature.update(data.getBytes());
            res = signature.verify(Base64.getDecoder().decode(sign));
        } catch(NoSuchAlgorithmException | InvalidKeyException | SignatureException | InvalidKeySpecException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            log.error("sign error", e);
        }

        return res;
    }

    private static PrivateKey getPrivateKey(String key) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(key.getBytes("utf-8"));
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }

    private static PublicKey getPublicKey(String key) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(key.getBytes("utf-8"));
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    public static void main(String[] args) {
        /*(1)生成公钥和私钥对*/
        KeyPair keyPair = getKeypair();
        String publicKey = Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
        String privateKey = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());

//        System.out.println("公钥：" + keyPair.getPublic());
//        System.out.println("私钥：" + keyPair.getPrivate());
        System.out.println("公钥(base64)：" + publicKey);
        System.out.println("私钥(base64)：" + privateKey);

        String data = "给我签名吧！";
        /*(2)用私钥生成签名*/
        String signStr = sign(privateKey, data);
        System.out.println("签名是：" + signStr);

        /*(3)验证签名*/
        boolean verifyResult = verifySign(publicKey, data, signStr);
        System.out.println("验证签名的结果是：" + verifyResult);
    }

}
