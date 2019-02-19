package util;

import javax.swing.*;
import java.awt.*;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/19
 * @Description: util
 * @version: 1.0
 */
public class CenterPanel extends JPanel{
    private double rate;
    private boolean pd;
    private JComponent c;
//    public CenterPanel(double r)
    public CenterPanel(double rate, boolean pd)
    {
        this.rate = rate;
        this.pd = pd;
        setLayout(null);
    }
    public CenterPanel(double rate)
    {
        this(rate, true);
    }

    @Override
    public void repaint()
    {
        if(c != null)
        {
            Dimension co = this.getSize();
            Dimension dp = c.getPreferredSize();

            if(pd)
            {
                c.setSize((int)(co.width * rate), (int)(co.height * rate));
            }
            else
            {
                c.setSize(dp);
            }

            c.setLocation(co.width / 2 - c.getWidth() / 2, co.height / 2 - c.getHeight() / 2);
        }
        super.repaint();
    }

    public void show(JComponent p)
    {
        this.c = p;
        Component[] cs = getComponents();
        for(Component c : cs)
        {
            remove(c);
        }
        add(p);
        this.repaint();
    }
    public static void main(String[] args)
    {
        JFrame jFrame = new JFrame("Test Center Panel");
        jFrame.setSize(200, 200);
        jFrame.setLocationRelativeTo(null);
        CenterPanel centerPanel = new CenterPanel(0.33);
        jFrame.setContentPane(centerPanel);



        jFrame.setVisible(true);
        JButton jButton = new JButton("更换界面");
//        centerPanel.show(new JButton("你们好"));
        jButton.addActionListener(e -> centerPanel.show(new JLabel(){
            @Override
            public void paint(Graphics g)
            {
                ImageIcon icon = new ImageIcon("d://1.jpg");
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), icon.getImageObserver());
            }
        }));
        centerPanel.show(jButton);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
