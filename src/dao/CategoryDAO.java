package dao;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/20
 * @Description: dao
 * @version: 1.0
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Category;
import util.DBUtil;
public class CategoryDAO {

    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select count(*) from category";

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

    public void add(Category category) {

        String sql = "insert into category values(?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            int n = getTotal();
            ps.setInt(1, n + 1);
            ps.setString(2, category.getName());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                category.setId(id);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void update(Category category) {

        String sql = "update category set name= ? where id = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setString(1, category.getName());
            ps.setInt(2, category.getId());

            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void delete(int id) {

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "delete from category where id = " + id;

            s.execute(sql);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public Category get(int id) {
        Category category = null;

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from category where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                category = new Category(rs.getInt(1), rs.getString(2));
//                String name = rs.getString(2);
//                category.name = name;
//                category.id = id;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return category;
    }

    public List<Category> list() {

        List<Category> list = new ArrayList<>();
        String sql = "select * from category";
        try(
                Connection c = DBUtil.getConnection();
                Statement s = c.createStatement();
                )
        {
            ResultSet rs = s.executeQuery(sql);

            while (rs.next())
            {
                list.add(new Category(rs.getInt(1), rs.getString(2)));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public List<Category> list(int start, int count) {
        List<Category> categorys = new ArrayList<Category>();

        String sql = "select * from category order by id desc limit ?,? ";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = new Category(rs.getInt(1), rs.getString(2));
                categorys.add(category);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return categorys;
    }

}