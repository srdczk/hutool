package gui.model;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/20
 * @Description: gui.model
 * @version: 1.0
 */
public class ThisTable implements TableModel {

    public String[] label = new String[]{"分类名称","消费次数"};
    public List<String> list = new ArrayList<>();

    public ThisTable()
    {
        list.add("餐饮");
        list.add("交通");
        list.add("住宿");
        list.add("话费");
    }
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return label.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return label[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(0==columnIndex)
            return list.get(rowIndex);
        if(1==columnIndex)
            return 0;
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
