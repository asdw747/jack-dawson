package com.jack.jackdawson.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jack.jackdawson.annotation.ParamLog;

@Aspect
@Component
@Slf4j
public class LogAspect {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Pointcut("execution(* com.jack.jackdawson.biz.*.*(..))")
    public void serviceLog() {
    }

    @Around("serviceLog()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        StringBuilder classAndMethod = new StringBuilder();
        Class<?> targetClass = method.getDeclaringClass();
        ParamLog targetClassAnnotation = targetClass.getAnnotation(ParamLog.class);
        if (targetClassAnnotation != null) {
            if (targetClassAnnotation.ignore()) {
                return joinPoint.proceed();
            }

            classAndMethod.append(targetClassAnnotation.value()).append("-");
        }

        ParamLog methodAnnotation = method.getAnnotation(ParamLog.class);
        boolean ignoreResponse = false;
        if (methodAnnotation != null) {
            if (methodAnnotation.ignore()) {
                return joinPoint.proceed();
            }

            if (methodAnnotation.ignoreResponse()) {
                ignoreResponse = true;
            }

            classAndMethod.append(methodAnnotation.value());
        } else {
            return joinPoint.proceed();
        }


        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        String jsonResponse = JSONObject.toJSONStringWithDateFormat(result, DATE_FORMAT, SerializerFeature.WriteMapNullValue);
        long latency = endTime - startTime;

        log.info("[aspect log] {}", classAndMethod);
        return result;

    }

}
