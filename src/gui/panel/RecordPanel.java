package gui.panel;

import gui.model.flComboBox;
import org.jdesktop.swingx.JXDatePicker;
import util.GUIUtil;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/20
 * @Description: gui.panel
 * @version: 1.0
 */
public class RecordPanel extends JPanel{

    static {
        GUIUtil.userLNF();
        GUIUtil.initGlobalFont();
    }
    public static RecordPanel recordPanel = new RecordPanel();


    public flComboBox flComboBox = new flComboBox();
//    public flComboBox flComboBox = new flComboBox();
    public JLabel hf = new JLabel("花费(￥)");
    public JLabel fl = new JLabel("分类");
    public JLabel bz = new JLabel("备注");
    public JLabel rq = new JLabel("日期");

    public JTextField hfT = new JTextField("0");
    public JComboBox flC = new JComboBox(flComboBox);
    public JTextField bzT = new JTextField();
    public JXDatePicker rqC = new JXDatePicker(new Date());
    public JPanel shang = new JPanel();

    public JPanel center = new JPanel();
    JButton jyb = new JButton("记一笔");
//    public J
//    JCheckBoxMenuItem


    private RecordPanel()
    {
        setLayout(new GridLayout(3, 1));
        shang.setLayout(new GridLayout(4, 2, 10, 10));
        shang.add(hf);
        shang.add(hfT);
        shang.add(fl);
        shang.add(flC);
        shang.add(bz);
        shang.add(bzT);
        shang.add(rq);
        shang.add(rqC);
        center.add(jyb);
//        flC.addItem("餐饮");
//        jyb.setSize(100, 30);
        add(shang);
//        add(new JPanel());
        add(new JPanel());
        add(center);

    }
    public static void main(String[] args)
    {
        GUIUtil.showPanel(RecordPanel.recordPanel);
    }
}
