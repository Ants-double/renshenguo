package com.antsdouble.singles;

/**
 * @ClassName InsideClassSingle
 * @Description 内部类的实现（建议使用）
 * @date 4/3/2019
 * @Author liyy
 * @Version 1.0
 */
public class InsideClassSingle {

    //使用ClassLoader来保证同步
    private static  class SingleHolder{
        private static  final  InsideClassSingle INSTANCE=new InsideClassSingle();
    }

    private InsideClassSingle(){ }
    public static final  InsideClassSingle getInstance(){
        return SingleHolder.INSTANCE;
    }
}
