package com.antsdouble.singles;

/**
 * @ClassName LazySingle
 * @Description 饿汉模式
 * @date 4/3/2019
 * @Author liyy
 * @Version 1.0
 */
public class LazySingle {
    //不论用不用，先初始化一个实例 但是类加载的时间由jvm来控制，很难把握
    private  static  LazySingle instance=new LazySingle();
    private LazySingle(){}
    public static LazySingle getInstance(){
        return instance;
    }
}
