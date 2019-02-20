package util;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.File;
import java.util.Enumeration;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/19
 * @Description: util
 * @version: 1.0
 */
public class GUIUtil {
    private static String path = "d://sucai/hutool/img";
    public static void setImageIcon(String fileName, JButton b, String tip)
    {
        ImageIcon icon = new ImageIcon(new File(path, fileName).getAbsolutePath());
        b.setIcon(icon);
        b.setPreferredSize(new Dimension(61, 81));
        b.setToolTipText(tip);
        b.setVerticalTextPosition(JButton.BOTTOM);
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setText(tip);
    }

    public static boolean isEmpty(JTextField tf, String input)
    {
        String text = tf.getText().trim();
        if(0 == text.length())
        {
            JOptionPane.showMessageDialog(null, input + "不能为空");
            tf.grabFocus();
            return true;
        }
        return false;
    }
    public static boolean isNum(JTextField tf, String input)
    {
        if(isEmpty(tf, input))
        {
            return false;
        }

        String check = tf.getText().trim();
        try {
            Integer i = Integer.valueOf(check);
            return true;
        } catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, input + "需要输入整数");
            tf.grabFocus();
            return false;
        }
//        return false;
    }

    public static boolean isZero(JTextField tf, String input)
    {
        if(!isNum(tf, input))
        {
            return false;
        }

        String text = tf.getText().trim();
        if(0 == Integer.valueOf(text))
        {
            JOptionPane.showMessageDialog(null, input + " 不能为0");
            tf.grabFocus();
            return false;
        }
        return true;
    }

    public static void setColor(Color color, JComponent... cs)
    {
        for(JComponent c : cs)
        {
            c.setForeground(color);
        }
    }

    public static void userLNF()
    {
        try {
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void initGlobalFont(){

        FontUIResource fontUIResource = new FontUIResource(new Font("等线",Font.PLAIN, 15));

        for (Enumeration keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {

            Object key = keys.nextElement();

            Object value= UIManager.get(key);

            if (value instanceof FontUIResource) {

                UIManager.put(key, fontUIResource);

            }

        }

    }
    public static void showPanel(JPanel p, double rate)
    {
        GUIUtil.userLNF();
        JFrame f = new JFrame("数据都是大家sbdjk");
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        CenterPanel centerPanel = new CenterPanel(rate);
        f.setContentPane(centerPanel);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        centerPanel.show(p);
    }
    public static void showPanel(JPanel p)
    {
        showPanel(p, 0.85);
    }

    public static void main(String[] args)
    {
        initGlobalFont();
        JPanel jPanel = new JPanel();
        jPanel.add(new JButton("mian"));
        jPanel.add(new JButton("呵呵"));
        GUIUtil.showPanel(jPanel);
    }
}
