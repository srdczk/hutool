package service;

import dao.ConfigDAO;
import pojo.Config;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/20
 * @Description: service
 * @version: 1.0
 */
public class ConfigService {
    public static final String budget = "budget";

    public static final String mysqlPath = "mysqlPath";

    public static final String default_budget = "500";

    public static ConfigDAO configDAO = new ConfigDAO();

    static {
        init();
    }

    public static void init()
    {
        init(budget, default_budget);
        init(mysqlPath, "");
    }

    public static void init(String key, String value)
    {
        Config config = configDAO.getByKey(key);

    }

    public String get(String key)
    {
        Config config = configDAO.getByKey(key);
        return config.getValue();
    }

    public void update(String key, String value)
    {
        Config config = configDAO.getByKey(key);
        config.setValue(value);
        configDAO.update(config);
    }
    public int getIntBudget()
    {
        return Integer.valueOf(get(budget));
    }

}
