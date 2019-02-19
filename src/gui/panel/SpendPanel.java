package gui.panel;

import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/19
 * @Description: gui.panel
 * @version: 1.0
 */
public class SpendPanel extends JPanel{
    static {
        GUIUtil.userLNF();
        GUIUtil.initGlobalFont();
    }
    public static SpendPanel spendPanel = new SpendPanel();

    public CircleProgressBar circleProgressBar = new CircleProgressBar(0, ColorUtil.getByPercent(0), ColorUtil.backgroundColor);

    public JPanel center = new JPanel();
    public JPanel zuo = new JPanel();
    public JPanel xia = new JPanel();

    public JLabel byxf = new JLabel("本月消费");
    public JLabel xfze = new JLabel("￥2300");
    public JLabel jrxf = new JLabel("今日消费");
    public JLabel jrze = new JLabel("￥25");


    public JLabel rjxf = new JLabel("￥120");
    public JLabel bysy = new JLabel("￥2084");
    public JLabel rjky = new JLabel("￥389");
    public JLabel jlym = new JLabel("15天");

    private SpendPanel()
    {
        setLayout(new BorderLayout());
        center.setLayout(new BorderLayout());
        center.add(circleProgressBar, BorderLayout.CENTER);
        center.add(zuo, BorderLayout.WEST);
        zuo.setLayout(new GridLayout(4, 1));
        zuo.add(byxf);
        zuo.add(xfze);
        zuo.add(jrxf);
        zuo.add(jrze);
        Font f = new Font("宋体", Font.PLAIN, 34);
        xfze.setFont(f);
        xfze.setForeground(ColorUtil.blueColor);
        jrze.setFont(f);
        jrze.setForeground(ColorUtil.blueColor);

        xia.setLayout(new GridLayout(2, 4));

        xia.add(new JLabel("日均消费"));
        xia.add(new JLabel("本月剩余"));
        xia.add(new JLabel("日均可用"));
        xia.add(new JLabel("距离月末"));
        xia.add(rjxf);

        xia.add(bysy);

        xia.add(rjky);

        xia.add(jlym);
        add(center, BorderLayout.CENTER);
        add(xia, BorderLayout.SOUTH);
    }
    public static void main(String[] args)
    {
        GUIUtil.showPanel(SpendPanel.spendPanel);
    }
}
