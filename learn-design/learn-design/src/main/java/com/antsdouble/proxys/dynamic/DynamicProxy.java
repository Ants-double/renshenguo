package com.antsdouble.proxys.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName DynamicProxy
 * @Description 动态代理
 * @date 4/2/2019
 * @Author liyy
 * @Version 1.0
 */
public class DynamicProxy<T> implements InvocationHandler {

    //持有的代理对象
    T target;

    public DynamicProxy(T target) {
        this.target = target;
    }

    /*
         *功能描述
         * @author liyy
         * @date 4/2/2019
         * @param
          [proxy, 代表动态代理对象 不要调用自身的方法容易循环调用
           method, 正在执行的方法
           args 代表调用目标方法时传入的参数
           ]
         * @return java.lang.Object
         */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行" + method.getName() + "方法");
        Object result = method.invoke(target, args);
        return result;
    }

}
