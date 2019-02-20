package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/20
 * @Description: 工具类,获取数据库的一个Connection
 * @version: 1.0
 */
public class DBUtil {
    public static String ip = "127.0.0.1";
    public static int port = 3306;
    public static String db = "hutool";
    public static String encoding = "UTF-8";
    public static String loginName = "root";
    public static String password = "admin";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
//        String url = String.format("")
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, db, encoding);
        return DriverManager.getConnection(url, loginName, password);
    }
}
