package pojo;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/20
 * @Description: pojo
 * @version: 1.0
 *
 * 实体类包名----pojo,然后是配置的表,以键值对的形式存储,Config类对应config表,配置基础的信息,如预算,数据库位置等等
 *
 *
 */
public class Config {
    private int id;//每个表都应该有一个自增的id
    private String key;//键值对形式存储,例如--key 预算 - value 500
    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Config(int id, String key, String value) {
        this.id = id;
        this.key = key;
        this.value = value;
    }
}
