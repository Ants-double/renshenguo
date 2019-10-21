package com.antsdouble.composite;

/**
 * @ClassName Component
 * @Description 组件
 * @date 4/8/2019
 * @Author liyy
 * @Version 1.0
 */
public abstract class Component {
    public abstract  void  addComposite(Component c);
    public abstract  void  removeComposite(Component c);
    public abstract  Component getComposite(Integer i);
    public abstract  void operation();
}
