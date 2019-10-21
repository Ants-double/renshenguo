package com.antsdouble.composite;

/**
 * @ClassName Leaf
 * @Description leaf
 * @date 4/8/2019
 * @Author liyy
 * @Version 1.0
 */
public class Leaf extends Component {
    public void addComposite(Component c) {
        System.out.println("不是容器，不应该调用此方法");

    }

    public void removeComposite(Component c) {
        System.out.println("不是容器，不应该调用此方法");

    }

    public Component getComposite(Integer i) {
        System.out.println("不是容器，不应该调用此方法");
        return null;
    }

    public void operation() {
        System.out.println("业务方法");
    }
}
