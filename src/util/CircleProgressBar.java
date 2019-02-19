package util;

import javax.swing.*;
import java.awt.*;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/19
 * @Description: util
 * @version: 1.0
 */
public class CircleProgressBar extends JPanel{
    public Color backgroundcolor;
    public Color pregroundcolor;
    public int progress;
    private String pro;
    public CircleProgressBar(int progress, Color backgroundcolor, Color pregroundcolor)
    {
        if(progress > 100)
        {
            progress = 100;
        }
        this.progress = progress;
        this.backgroundcolor = backgroundcolor;
        this.pregroundcolor = pregroundcolor;
        this.pro = progress + "%";
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        pregroundcolor = ColorUtil.getByPercent(progress);
        backgroundcolor = ColorUtil.blueColor;
        int width = getWidth();
        int height = getHeight();
//        System.out.println(width);
//        System.out.println(height);
        int d1 = Math.min(width, height);

//        int r1 = d;

        int d2 = d1 * 6 / 7;

        Color c = g.getColor();

        g.setColor(backgroundcolor);

        g.fillOval(0, 0, d1, d1);

        g.setColor(pregroundcolor);

        g.fillArc(0, 0, d1, d1, 0, (int)(360 * progress / 100.0));

        g.setColor(ColorUtil.backgroundColor);

        g.fillOval((d1 - d2) / 2, (d1 - d2) / 2, d2, d2);

        g.setColor(pregroundcolor);

        g.setFont(new Font("TimesRoman", Font.PLAIN, d1 / 4));
        if(progress < 10)
        {
            g.drawString(progress + "%",d1 / 2 - d1 * 1 / 8, d1 / 2 + d1 / 10);
        }
        else
        {
            g.drawString(progress + "%",d1 / 2 - d1 * 1 / 5, d1 / 2 + d1 / 10);
        }

        g.setColor(c);


    }

    public static void main(String[] args)
    {
        GUIUtil.initGlobalFont();
        CircleProgressBar circleProgressBar = new CircleProgressBar(0, ColorUtil.blueColor, ColorUtil.getByPercent(0));
        GUIUtil.showPanel(circleProgressBar);
        new Thread(() -> {
            while (true)
            {
                try {
                    Thread.sleep(300);
                    circleProgressBar.progress++;
                    if(circleProgressBar.progress == 100)
                    {
                        JOptionPane.showMessageDialog(null, "过了过了");
                        circleProgressBar.progress = 0;
                    }
                    circleProgressBar.repaint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
