package pojo;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/20
 * @Description: pojo
 * @version: 1.0
 */
public class Category {
    private int id;
    private String name;//消费类型的名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category(int id, String name) {

        this.id = id;
        this.name = name;
    }
}
