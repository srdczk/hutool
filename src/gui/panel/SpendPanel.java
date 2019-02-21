package gui.panel;

import dao.RecordDAO;
import pojo.Record;
import service.ConfigService;
import util.CircleProgressBar;
import util.ColorUtil;
import util.DateUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

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
    public JLabel xfze = new JLabel("￥0");
    public JLabel jrxf = new JLabel("今日消费");
    public JLabel jrze = new JLabel("￥0");


    public JLabel rjxf = new JLabel("￥0");
    public JLabel bysy = new JLabel("￥0");
    public JLabel rjky = new JLabel("￥0");
    public JLabel jlym = new JLabel((DateUtil.monthEnd().getDate() - DateUtil.toDay().getDate()) + "天");

    public void updateData()
    {
        RecordDAO r = new RecordDAO();
        int sum = Integer.valueOf(new ConfigService().get("budget"));
        List<Record> list = r.list(DateUtil.toDay());
        int jr = 0;
        for(int i = 0; i < list.size(); ++i)
        {
            jr += list.get(i).getSpend();
        }
        List<Record> list1 = r.list(DateUtil.monthBegin(), DateUtil.toDay());
        int alls = 0;
        for(Record record : list1)
        {
            alls += record.getSpend();
        }

        xfze.setText("￥" + sum);
        jrze.setText("￥" + jr);

//        ;


        rjxf.setText("￥" + (alls / (DateUtil.toDay().getDate() - DateUtil.monthBegin().getDate())));
        Font f = rjxf.getFont();
        if(sum - alls < 0)
        {

//            xfze.setFont(f);
            xfze.setForeground(ColorUtil.warningColor);
//            jrze.setFont(f);
            jrze.setForeground(ColorUtil.warningColor);

            bysy.setForeground(ColorUtil.warningColor);
            bysy.setText("本月超支￥" + (alls - sum));
            rjky.setText("￥" + 0);
        }
        else
        {
            xfze.setForeground(ColorUtil.blueColor);
            jrze.setForeground(ColorUtil.blueColor);
            bysy.setForeground(ColorUtil.grayColor);

            bysy.setText("￥" + (sum - alls));
            rjky.setText("￥" + ((sum - alls) / (DateUtil.monthEnd().getDate() - DateUtil.toDay().getDate())));
        }




        jlym.setText("￥" + (DateUtil.monthEnd().getDate() - DateUtil.toDay().getDate()) + "天");

        circleProgressBar.progress = alls * 100 / sum;

        repaint();
    }


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
        updateData();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
                updateData();

            }
        });
    }
    public static void main(String[] args)
    {
//        System.out.println(DateUtil.toDay().getDate());
//        );
        GUIUtil.showPanel(SpendPanel.spendPanel);

    }
}
