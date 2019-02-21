package service;

import dao.CategoryDAO;
import dao.RecordDAO;
import pojo.Category;

import java.util.List;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/20
 * @Description: service
 * @version: 1.0
 */
public class CategoryService {
    public static final String canY = "餐饮";
    public static final String jiaoT = "交通";
    public static final String zhuS = "住宿";
    public static final String huaF = "话费";
    public static CategoryDAO c = new CategoryDAO();
    static {
//        c.add(new Category(1, canY));
//        c.add(new Category(2, jiaoT));
//        c.add(new Category(3, zhuS));
//        c.add(new Category(4, huaF));
    }


    public void add(String s) {
        c.add(new Category(1, s));

    }


    public void update(String name, String newname)
    {
        List<Category> list = c.list();
        int j = 0;
        for(int i = 0; i < list.size(); ++i)
        {
            if(list.get(i).getName().equals(name))
            {
                j = i + 1;
                break;
            }
        }
        c.update(new Category(j, newname));
    }

//    RecordDAO r = new RecordDAO();

    public int getId(String name)
    {
        List<Category> list = c.list();
        for(int i = 0; i < list.size(); ++i)
        {
            if(list.get(i).getName().equals(name))
            {
                return list.get(i).getId();
            }
        }
        return 0;
    }
}
