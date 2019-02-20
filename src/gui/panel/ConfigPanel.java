package gui.panel;

import gui.listener.ConfigListener;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/20
 * @Description: gui.panel
 * @version: 1.0
 */
public class ConfigPanel extends JPanel {
    static {
        GUIUtil.userLNF();
        GUIUtil.initGlobalFont();
    }

    public JLabel byys = new JLabel("本月预算(￥)");
    public JTextField ysT = new JTextField("0");
    public JLabel sqlml = new JLabel("Mysql安装目录");
    public JTextField sqlT = new JTextField();
    public JPanel panel = new JPanel();
    public JButton gx = new JButton("更新");
    public static ConfigPanel configPanel = new ConfigPanel();


    private ConfigPanel()
    {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4, 1, 40, 40));
        center.add(byys);
        center.add(ysT);
        center.add(sqlml);
        center.add(sqlT);
        setLayout(new BorderLayout());
        add(center, BorderLayout.NORTH);
//        add(new JPanel());
        gx.addActionListener(new ConfigListener());
        panel.add(gx);
        add(panel, BorderLayout.CENTER);
    }
    public static void main(String[] args)
    {
        GUIUtil.showPanel(ConfigPanel.configPanel);
    }
}
