package com.syb.aspect;

import com.syb.utils.TransactionUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;

/**
 * @author Abin
 * @date Created in 2021/5/5 0:03
 * @Modified By:
 * @Description
 */
@Aspect
@Component
@Slf4j
public class TransactionAspect {
    @Autowired
    TransactionUtil transactionUtil;

    @Around(value = "@annotation(com.syb.annotation.TransactionMyself)")
    public Object around(ProceedingJoinPoint joinPoint) {
        TransactionStatus begin = null;
        try {
            begin = transactionUtil.begin();
            Object proceed = joinPoint.proceed();
            transactionUtil.commit(begin);
            return proceed;
        } catch (Throwable throwable) {
            log.info("发生异常,事务回滚 error = {}",throwable.getMessage());
            transactionUtil.rollback(begin);
            return "发生异常,事务回滚!";
        }
    }
}
