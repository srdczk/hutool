package gui.model;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/20
 * @Description: gui.model
 * @version: 1.0
 */
public class flComboBox implements ComboBoxModel<String>
{
    public List<String> list = new ArrayList<>();

    String c;

    public flComboBox()
    {
        list.add("餐饮");
        list.add("交通");
        list.add("住宿");
        list.add("话费");
        c = list.get(0);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        c = (String) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return c;
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public String getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
