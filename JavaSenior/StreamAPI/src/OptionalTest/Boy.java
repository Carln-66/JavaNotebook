package OptionalTest;

/**
 * @Auther: Carl
 * @Date: 2021/02/26/12:40
 * @Description:
 */
public class Boy {

    private Girl girl;

    public Boy(Girl girl) {
        this.girl = girl;
    }

    public Boy() {

    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }
}
