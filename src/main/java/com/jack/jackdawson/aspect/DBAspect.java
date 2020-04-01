package com.jack.jackdawson.aspect;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;
import java.util.List;
import com.google.common.collect.Lists;
import com.jack.jackdawson.common.database.DBContext;
import com.jack.jackdawson.common.database.Strategy;
import com.jack.jackdawson.common.database.UseMaster;

@Aspect
@Component
public class DBAspect {
    private static final Logger logger = LoggerFactory.getLogger(DBAspect.class);

    @Pointcut("execution(* com.jack.jackdawson.repository..*(..))) ")
    public void serviceLog() {
        //do nothing
    }

    private static List<String> methodPerfixList = Lists.newArrayList("select", "find", "get", "load", "count");

    @Around("serviceLog()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        DBContext.setDbType(Strategy.MASTER);
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        logger.debug("around method:{}", method);
        if (isMethodInPerfixList(method.getName())) {
            DBContext.setDbType(Strategy.SLAVE);
        }

        UseMaster masterAnnotation = method.getAnnotation(UseMaster.class);
        if (masterAnnotation != null) {
            DBContext.setDbType(Strategy.MASTER);
            result = joinPoint.proceed();
            DBContext.clearDbType();
        } else {
            result = joinPoint.proceed();
            DBContext.clearDbType();
            return result;
        }

        return result;

    }

    private boolean isMethodInPerfixList(String name) {
        if (StringUtils.isBlank(name)) return false;
        for (String perfix : methodPerfixList) {
            if (name.toLowerCase().startsWith(perfix)) {
                return true;
            }
        }
        return false;
    }


}
