package exer;

import java.io.Serializable;

/**
 * @Auther: Carl
 * @Date: 2021/02/20/20:47
 * @Description:
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath() {
        System.out.println("生物呼吸");
    }

    public void eat() {
        System.out.println("生物获取营养");
    }
}
