package dao;

import pojo.Config;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/20
 * @Description: dao
 * @version: 1.0
 *
 *
 * 增加

public void add(Config config)



更新

public void update(Config config)



删除

public void delete(int id)



获取

public Config get(int id)



查询所有

public List<Config> list()



分页查询

public List<Config> list(int start, int count)



统计总数

public int getTotal()



通过键获取Config实例，比如预算对应的Config实例，就会通过这种方式获取： new ConfigDAO().getByKey("budget");

public Config getByKey(String key)
 */
public class ConfigDAO {

//    Connection connection = DBUtil.getConnection();


    public void add(Config config)
    {
        String sql = "insert into config values (null, ?, ?)";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement preparedStatement = c.prepareStatement(sql);
                )
        {
            preparedStatement.setString(1, config.getKey());
            preparedStatement.setString(2, config.getValue());
//            preparedStatement.setString(3, config.getValue());
            preparedStatement.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void update(Config config)
    {
        String sql = "UPDATE config set key_ = ?, value = ? WHERE id = ?";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement preparedStatement = c.prepareStatement(sql);
                )
        {
            preparedStatement.setString(1, config.getKey());
            preparedStatement.setString(2, config.getValue());
            preparedStatement.setInt(3, config.getId());
            preparedStatement.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void delete(Config config)
    {
        String sql = "delete from config where id = ?";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement preparedStatement = c.prepareStatement(sql);
                )
        {
            preparedStatement.setInt(1, config.getId());
            preparedStatement.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Config> list()
    {
        List<Config> list = new ArrayList<>();
        String sql = "select * from config";
        try(
                Connection c = DBUtil.getConnection();
                Statement statement = c.createStatement();
                )
        {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next())
            {
                list.add(new Config(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public Config get(int id)
    {
        Config config = null;
        String sql = "select * from config where id = " + id;
        try(
                Connection c = DBUtil.getConnection();
                Statement statement = c.createStatement();
                )
        {
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next())
            {
                config = new Config(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return config;
    }

    public List<Config> list(int start, int count)
    {
        List<Config> list = new ArrayList<>();
        String sql = "select * from config limit" + start + "," + count;
        try(
                Connection c = DBUtil.getConnection();
                Statement statement = c.createStatement();
                )
        {
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next())
            {
                list.add(new Config(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }
    public int getTotal()
    {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select count(*) from config";

            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }

            System.out.println("total:" + total);

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return total;
    }

    public Config getByKey(String key)
    {
        Config config = null;
        String sql = "select * from config where key_ = ?";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement preparedStatement = c.prepareStatement(sql);
                )
        {
            preparedStatement.setString(1, key);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
            {
                config = new Config(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return config;
    }
    public static void main(String[] args)
    {
        ConfigDAO configDAO = new ConfigDAO();
        List<Config> list = configDAO.list();

        for(Config config : list)
        {
            System.out.println(config.getValue());
        }
//        configDAO.add(new Config(1, "budget", "1000"));
        System.out.println("能够连接");

    }
}
