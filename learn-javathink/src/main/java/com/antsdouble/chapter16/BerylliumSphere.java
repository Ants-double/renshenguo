package com.antsdouble.chapter16;

/**
 * @ClassName BerylliumSphere
 * @Description sphere
 * @date 4/11/2019
 * @Author liyy
 * @Version 1.0
 */
public class BerylliumSphere {
    private static long counter;
    private final long id=counter++;
    @Override
    public String toString() {
        return "BerylliumSphere{" +
                "id=" + id +
                '}';
    }
}
