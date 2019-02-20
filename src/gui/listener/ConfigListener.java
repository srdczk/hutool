package gui.listener;

import dao.ConfigDAO;
import gui.frame.MainFrame;
import gui.panel.CategoryPanel;
import gui.panel.ConfigPanel;
import gui.panel.SpendPanel;
import pojo.Config;
import service.ConfigService;
import util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/20
 * @Description: gui.listener
 * @version: 1.0
 */
public class ConfigListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        ConfigPanel p = ConfigPanel.configPanel;
//        ConfigPanel p = MainFrame.mainFrame.configPanel;
        if(!GUIUtil.isNum(p.ysT, "本月预算"))
            return;
        if(GUIUtil.isNum(p.ysT, "本月预算"))
        {
            if(Integer.valueOf(p.ysT.getText()) <= 800)
            {
                JOptionPane.showMessageDialog(null,"请设置一个有意义的");
//                        JOptionPane.showMessageDialog();
                p.ysT.grabFocus();
                return;
            }
        }
        String mysqlPath = p.sqlT.getText();

        if(0 != mysqlPath.length())
        {
            File file = new File(mysqlPath, "bin/mysql.exe");
            if(!file.exists())
            {
                JOptionPane.showMessageDialog(null, "路径错误");
                p.sqlT.grabFocus();
                return;
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "路径不能为空");
            p.sqlT.grabFocus();
            return;
        }
        ConfigService cs = new ConfigService();
        cs.update("budget", p.ysT.getText());
        cs.update("mysqlPath", mysqlPath);
        JOptionPane.showMessageDialog(null, "设置修改成功");
        p.sqlT.grabFocus();

        SpendPanel.spendPanel.updateData();
        CategoryPanel.categoryPanel.updateData();

    }
}
