package gui.listener;

import dao.CategoryDAO;
import gui.panel.CategoryPanel;
import gui.panel.ReportPanel;
import gui.panel.SpendPanel;
import pojo.Category;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/21
 * @Description: gui.listener
 * @version: 1.0
 */
public class AddListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = JOptionPane.showInputDialog(null);
        if(name.length() == 0)
        {
            JOptionPane.showMessageDialog(null, "分类名称不能为空");
            return;
        }
        CategoryDAO categoryDAO = new CategoryDAO();
//        categoryDAO.add(new Category(3, ));

        categoryDAO.add(new Category(0, name));
        SpendPanel.spendPanel.updateData();
        CategoryPanel.categoryPanel.update();
        ReportPanel.reportPanel.updateData();
    }
}
