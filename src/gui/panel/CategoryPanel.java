package gui.panel;

import dao.CategoryDAO;
import dao.RecordDAO;
import gui.listener.AddListener;
import gui.listener.BianJiListener;
import gui.listener.DeleteListener;
import gui.model.ThisTable;
import gui.model.flComboBox;
import pojo.Category;
import pojo.Record;
import util.GUIUtil;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/20
 * @Description: gui.panel
 * @version: 1.0
 */
public class CategoryPanel extends JPanel{
    static {
        GUIUtil.initGlobalFont();
        GUIUtil.userLNF();
    }

    public static CategoryPanel categoryPanel = new CategoryPanel();
    public ThisTable thisTable = new ThisTable();
    public JTable jTable = null;
    public JScrollPane jScrollPane = null;
    public JPanel jPanel = new JPanel();
    public JButton xZeng = new JButton("新增");
    public JButton bJi = new JButton("编辑");
    public JButton sChu = new JButton("删除");

    public List<String> rows = new ArrayList<>();

    public void updateData()
    {

        int n = new CategoryDAO().getTotal();
        RecordDAO r = new RecordDAO();
//         = r.list();
        int[] ints = new int[n];
        for(int i = 0; i < n; ++i)
        {
            List<Record> list = r.list(i + 1);
            for(Record record : list)
            {
                ints[i] += record.getSpend();
            }

        }

//        thisTable.list.add("sdsdd");
//        jTable.setValueAt(2, 3, 1);
        jTable.setModel(new ThisTable(){
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                if(0==columnIndex)
                    return list.get(rowIndex);
                if(1==columnIndex)
                    return ints[rowIndex];
                return null;
            }
        });
        repaint();
    }


    public void setjPanel()
    {
        jPanel.add(xZeng);
        jPanel.add(bJi);
        jPanel.add(sChu);
    }

    public void setjTable()
    {
        jTable = new JTable(thisTable);
        jScrollPane = new JScrollPane(jTable);
    }

    public void addListener()
    {
        xZeng.addActionListener(new AddListener());
        bJi.addActionListener(new BianJiListener());
        sChu.addActionListener(new DeleteListener());
    }

    public String getSelect()
    {
        int index = jTable.getSelectedRow();
        String s = null;
        try{
            s = rows.get(index);
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "未初始化");
        }
        return s;
    }

    public void update()
    {

        int n = new CategoryDAO().getTotal();
        CategoryDAO categoryDAO = new CategoryDAO();
        RecordDAO r = new RecordDAO();
//         = r.list();
        int[] ints = new int[n];
        for(int i = 0; i < n; ++i)
        {
            List<Record> list = r.list(i + 1);
            for(Record record : list)
            {
                ints[i] += record.getSpend();
            }

        }

        jTable.setModel(new ThisTable(){

            @Override
            public int getRowCount() {
                return categoryDAO.getTotal();
            }

            @Override
            public int getColumnCount() {
                return label.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                if(0==columnIndex)
                    return categoryDAO.get(rowIndex + 1).getName();
                if(1==columnIndex)
                    return ints[rowIndex];
                return null;
            }
        });
        class Nima extends flComboBox{
            public Nima()
            {
                list = new ArrayList<>();
                List<Category> categories = categoryDAO.list();
                for(Category category : categories)
                {
                    list.add(category.getName());
                    rows.add(category.getName());
                }
                c = list.get(0);
            }
        }
        RecordPanel.recordPanel.flC.setModel(new Nima());

        repaint();

    }

    private CategoryPanel()
    {

        setLayout(new BorderLayout());
        setjTable();
        setjPanel();
        addListener();
        add(jScrollPane, BorderLayout.CENTER);
        add(jPanel, BorderLayout.SOUTH);
        update();
    }
    public static void main(String[] args)
    {
        GUIUtil.showPanel(CategoryPanel.categoryPanel);
    }
}
