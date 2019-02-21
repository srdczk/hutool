package gui.listener;

import dao.RecordDAO;
import gui.panel.CategoryPanel;
import gui.panel.RecordPanel;
import gui.panel.ReportPanel;
import gui.panel.SpendPanel;
import pojo.Record;
import service.CategoryService;
import util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/20
 * @Description: gui.listener
 * @version: 1.0
 */
public class RecordListener implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        RecordPanel r = RecordPanel.recordPanel;

        if(!GUIUtil.isNum(r.hfT, "花费输入"))
        {
            return;
        }

        if(Integer.valueOf(r.hfT.getText()) <= 0)
        {
            JOptionPane.showMessageDialog(null, "花费输入必须要是正整数");
            r.hfT.grabFocus();
            return;
        }

        RecordDAO recordDAO = new RecordDAO();
        CategoryService c = new CategoryService();
        String bz = r.bzT.getText();
        String fl = (String)r.flC.getSelectedItem();
        Date date = r.rqC.getDate();
        int l = c.getId(fl);
        if(l == 0)
        {
            JOptionPane.showMessageDialog(null, "无此分类");
            return;
        }

        recordDAO.add(new Record(2, Integer.valueOf(r.hfT.getText()), l, bz, date));
        JOptionPane.showMessageDialog(null, "添加记录成功");

        r.bzT.setText("");
        r.hfT.setText("");

        SpendPanel.spendPanel.updateData();
        CategoryPanel.categoryPanel.update();
        ReportPanel.reportPanel.updateData();

    }
}
