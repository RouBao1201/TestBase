package com.syb.aspect;

import com.syb.annotation.MaxValidMyself;
import com.syb.annotation.MinValidMyself;
import com.syb.annotation.ValidMyself;
import com.syb.pojo.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Abin
 * @date Created in 2021/5/5 0:42
 * @Modified By:
 * @Description 该切仅为了校验自定义注解@validMyself
 */
@Aspect
@Component
@Slf4j
public class ValidAspect {

    @Pointcut(value = "execution(public * com.syb.controller.*.*(..))")
    public void pointCut() {
    }

    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        //失败信息
        String errorMessage = "";
        //退出标志位
        Boolean breakFlag = false;

        Object[] params = joinPoint.getArgs();
        if (params.length == 0) {
            return "无参数";
        }
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        //参数注解，1维是参数，2维是注解
        Annotation[][] annotations = method.getParameterAnnotations();
        for (int i = 0; i < annotations.length && !breakFlag; i++) {
            //获取所有参数
            Object param = params[i];
            //获取改参数所有的注解
            Annotation[] paramAnn = annotations[i];
            //参数为空或者注解为空，直接下一个参数
            if (param == null || paramAnn.length == 0) {
                continue;
            }
            for (Annotation annotation : paramAnn) {
                //这里判断当前注解是否为ValidMyself.class
                if (ValidMyself.class.equals(annotation.annotationType())) {
                    log.info("注解是 <><> {}", ValidMyself.class);
                    Class<?> aClass = param.getClass();
                    //获取对象所有的参数
                    Field[] fields = aClass.getDeclaredFields();
                    for (int j = 0; j < fields.length; j++) {
                        fields[j].setAccessible(true);
                        /**
                         * 最大值校验
                         */
                        //判断对象中该参数是否为指定注解
                        boolean maxValid = fields[j].isAnnotationPresent(MaxValidMyself.class);
                        if (maxValid) {
                            log.info("开始校验注解 <><> {}", MaxValidMyself.class);
                            //获取注解中预设值
                            int value = fields[j].getAnnotation(MaxValidMyself.class).value();
                            String message = fields[j].getAnnotation(MaxValidMyself.class).message();
                            int buyCount = 0;
                            try {
                                buyCount = Integer.parseInt(fields[j].get(param).toString());
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                            if (value < buyCount) {
                                log.info(message + " <><><> 购买量为{" + buyCount + "} > 最多允许购买{" + value + "}");
                                errorMessage = message;
                                breakFlag = true;
                                break;
                            }
                        }
                        /**
                         * 最小值校验
                         */
                        boolean minValid = fields[j].isAnnotationPresent(MinValidMyself.class);
                        if (minValid) {
                            log.info("开始校验注解 <><> {}", MinValidMyself.class);
                            //获取注解中预设值
                            int value = fields[j].getAnnotation(MinValidMyself.class).value();
                            String message = fields[j].getAnnotation(MinValidMyself.class).message();
                            int buyCount = 0;
                            try {
                                buyCount = Integer.parseInt(fields[j].get(param).toString());
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                            if (value > buyCount) {
                                log.info(message + " <><><> 购买量为{" + buyCount + "} < 最少需购买{" + value + "}");
                                errorMessage = message;
                                breakFlag = true;
                                break;
                            }
                        }
                    }
                }
                if (breakFlag) {
                    break;
                }
            }
        }
        Object proceed = null;
        if (!breakFlag) {
            try {
                proceed = joinPoint.proceed();
                return ResponseResult.success("Go Buy Success", null);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return ResponseResult.error(errorMessage, null);
    }

}
