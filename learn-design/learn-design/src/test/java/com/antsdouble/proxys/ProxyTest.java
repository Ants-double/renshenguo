package com.antsdouble.proxys;

import com.antsdouble.proxys.cglibs.HelloWorld;
import com.antsdouble.proxys.dynamic.DynamicProxy;
import com.antsdouble.proxys.dynamic.EarnMoneyImpl;
import com.antsdouble.proxys.dynamic.EarnMoneyInterface;
import com.antsdouble.proxys.staticsate.EarnMoneyProxy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName ProxyTest
 * @Description test
 * @date 4/2/2019
 * @Author liyy
 * @Version 1.0
 */
public class ProxyTest {

    //静态代理
    @Test
    public void staticSateTest() {
        EarnMoneyProxy earnMoneyProxy = new EarnMoneyProxy();
        earnMoneyProxy.changeMoneyWithLife();
    }

    @Test
    public void dynamicTest() {
        //java的单继承注定了只能对接口进行动态代理，因为代理类继承了Proxy类
        //被代理的对象
        EarnMoneyImpl earnMoney = new EarnMoneyImpl();

        //代理与被代理之音的关系
        InvocationHandler handler = new DynamicProxy<EarnMoneyInterface>(earnMoney);

        //创建代理，并强转
        EarnMoneyInterface proxyInstance = (EarnMoneyInterface) Proxy.newProxyInstance(EarnMoneyInterface.class.getClassLoader(), new Class<?>[]{EarnMoneyInterface.class}, handler);

        proxyInstance.changeMoneyWithLife();
    }

    @Test
    public void  cglibTest(){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(HelloWorld.class);
        //这个部门可以提取出一个类实现MethodInterceptor setCallback传入对应的实例对象会更灵活一点
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before run method...");
                Object result = methodProxy.invokeSuper(o, objects);
                System.out.println("after run method ...");
                return  result;
            }
        });

        HelloWorld helloWorld= (HelloWorld) enhancer.create();
        helloWorld.hello();

    }

}
