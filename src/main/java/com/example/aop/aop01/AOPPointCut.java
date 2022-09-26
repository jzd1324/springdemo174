package com.example.aop.aop01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 实现一个切面类，用来对于主线执行内容的操作
 */
@Component
@Aspect
public class AOPPointCut {

    //1.我要绑定到哪里
    @Pointcut("execution(* com.example.aop.aop01.DoSth.*(..))")
    void point(){}

    //2.绑定后我要做什么
    //环绕通知
    @Around(value = "point()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
       //执行的操作时间
        //之前执行
        System.out.println("-----开始了-----");
        //Spring提供的一种用来统计前后时间的操作类
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        //调用方法（mult）  针对有返回值的情况下需要返回一个对象，如果你调用的方法无返回值，可以不需要定义
           Object obj =  pjp.proceed();
           //在这里我希望得到每次请求的内容参数是什么，类是什么，方法是什么等内容，一般用于日志处理
        Signature signature = pjp.getSignature();
        System.out.println("方法是:"+signature.getName());  //方法
        System.out.println("完整类是："+signature.getDeclaringTypeName());      //该方法所在的类
       // System.out.println(signature.getClass().getName());      //拿的是signature实现类
        //获得对应调用的方法中的参数
        Object[] args = pjp.getArgs();

        //另辟蹊径
        if(args.length>0){
            System.out.println("参数值是:");
            for(int i = 0 ; i < args.length ; i++){
                System.out.print(args[i]+"\t");
            }
            System.out.println();
            Method[] methods = signature.getDeclaringType().getMethods();
            List<Method> methodList = new ArrayList<>();
            for(int i = 0 ; i <methods.length ;i++){
                if(methods[i].getName().equals(signature.getName())){
                    methodList.add(methods[i]);
                }
            }
            Parameter[] parameters = null;
            for(Method method: methodList){
               parameters = method.getParameters();
            }

            MethodSignature methodSignature =  (MethodSignature)pjp.getSignature();
            Class[] parameterTypes = methodSignature.getParameterTypes();
            for(int i=0;i<parameterTypes.length;i++){
                System.out.println(parameterTypes[i].getName());
            }


            System.out.println("参数类型是:");
            for(int i = 0 ; i < parameters.length ; i++){
                System.out.print(parameters[i].getName() + " "+parameters[i].getParameterizedType().getTypeName()+"\t");
            }
            System.out.println();
        }

    //当前调用的类是xxx,方法xxx,参数是a = xxx b=xxxx

        //最后执行
        stopWatch.stop();
        System.out.println("执行时间是:"+stopWatch.getTotalTimeMillis()+"ms");
        return obj;
    }

}
