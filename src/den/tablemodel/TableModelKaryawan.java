package den.tablemodel;

import den.model.ModelKaryawan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class TableModelKaryawan extends AbstractTableModel {

    private List<ModelKaryawan> list = new ArrayList<>();

    public ModelKaryawan getData(int index) {
        return list.get(index);
    }

    public void clear() {
        list.clear();
        fireTableDataChanged();
    }

    public void setData(List<ModelKaryawan> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }

    public void insertData(ModelKaryawan model) {
        list.add(model);
        this.list.addAll(list);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }

    public void updateData(int row, ModelKaryawan model) {
        list.set(row, model);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data Berhasil Diperbaharui");
    }

    public void insertData(int row) {
        list.remove(row);
        this.list.addAll(list);
        fireTableRowsDeleted(row, row);
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
    }

    private final String[] columnNames = {"ID", "Nama Karyawan", "Username", "Telepon", "Alamat", "Role"};

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModelKaryawan model = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return  model.getIdKaryawan();
            case 1:
                return model.getNamaKaryawan();
            case 2:
                return model.getUsername();
            case 3:
                return model.getTelepon();
            case 4:
                return model.getAlamat();
            case 5:
                return model.getRole();

            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    //public ModelKaryawan getData(int row) {
    //  }
    public void deleteData(int row) {

    }

}
