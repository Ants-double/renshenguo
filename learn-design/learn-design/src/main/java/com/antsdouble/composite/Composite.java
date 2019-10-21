package com.antsdouble.composite;

import java.util.ArrayList;

/**
 * @ClassName Composite
 * @Description composite
 * @date 4/8/2019
 * @Author liyy
 * @Version 1.0
 */
public class Composite extends Component {
    private ArrayList<Component> list = new ArrayList<Component>();

    public void addComposite(Component c) {
        list.add(c);
    }

    public void removeComposite(Component c) {
        list.remove(c);
    }

    public Component getComposite(Integer i) {
        Component component = list.get(i);
        return component;
    }

    public void operation() {
        for (Object obj : list) {
            ((Component) obj).operation();
        }
    }
}
