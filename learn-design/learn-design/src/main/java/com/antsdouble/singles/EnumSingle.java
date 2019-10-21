package com.antsdouble.singles;

/**
 * @ClassName EnumSingle
 * @Description 枚举单例，抗反射，抗序例化 （建议使用）
 * @date 4/3/2019
 * @Author liyy
 * @Version 1.0
 */
public class EnumSingle {

    private EnumSingle(){}
    public static  EnumSingle getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private static enum Singleton{
        INSTANCE;
        private  EnumSingle enumSingle;
        //jvm保证只初始化一次
        private Singleton(){
            enumSingle=new EnumSingle();
        }
        public EnumSingle getInstance(){
            return  enumSingle;
        }
    }
}
