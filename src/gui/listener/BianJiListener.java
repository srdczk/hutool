package gui.listener;

import gui.panel.CategoryPanel;
import gui.panel.ReportPanel;
import gui.panel.SpendPanel;
import service.CategoryService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/21
 * @Description: gui.listener
 * @version: 1.0
 */
public class BianJiListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = CategoryPanel.categoryPanel.getSelect();
//        System.out.println(s);

        String name = JOptionPane.showInputDialog(null);
        if(name.length() == 0)
        {
            JOptionPane.showMessageDialog(null, "不能为空");
            return;
        }
        new CategoryService().update(s, name);
        JOptionPane.showMessageDialog(null, "更新成功");
        SpendPanel.spendPanel.updateData();
        CategoryPanel.categoryPanel.update();
        ReportPanel.reportPanel.updateData();
    }
}
