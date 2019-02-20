package gui.panel;

import gui.model.ThisTable;
import util.GUIUtil;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
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
        xZeng.addActionListener(e -> System.out.println("ee"));
    }

    private CategoryPanel()
    {
        setLayout(new BorderLayout());
        setjTable();
        setjPanel();
        addListener();
        add(jScrollPane, BorderLayout.CENTER);
        add(jPanel, BorderLayout.SOUTH);
    }
    public static void main(String[] args)
    {
        GUIUtil.showPanel(CategoryPanel.categoryPanel);
    }
}
