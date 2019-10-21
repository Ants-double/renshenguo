package com.antsdouble.singles;

/**
 * @ClassName ThreadSingle
 * @Description 多线程安全
 * @date 4/3/2019
 * @Author liyy
 * @Version 1.0
 */
public class ThreadSingle {
    //阻止指令优化，禁用缓存
    private  static volatile  ThreadSingle instance;

    private  ThreadSingle(){}

    public  static  ThreadSingle getInstance(){
        if (null==instance){
            //避免已有实例时还要进行线程同步的浪费
            synchronized (ThreadSingle.class){
                //双重检查提高了代码效率和安全性
                if (null==instance){
                    instance=new ThreadSingle();
                }
            }
        }
        return instance;
    }
}
