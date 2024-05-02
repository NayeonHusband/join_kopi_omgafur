package den.tablemodel;

import den.model.ModelPelanggan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class TableModelPelanggan extends AbstractTableModel{
    
    private List<ModelPelanggan> list = new ArrayList<>();
    
    public void clear(){
        list.clear();
        fireTableDataChanged();
    } 
    
    public void setData(List<ModelPelanggan> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void insertData(ModelPelanggan model){
        list.add(model);
        this.list.addAll(list);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    
    public void UpdateData(int row, ModelPelanggan model){
        list.set(row, model);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data Berhasil Diperbaharui");
    }
    
    public void insertData(int row){
        list.remove(row);
        this.list.addAll(list);
        fireTableRowsDeleted(row, row);
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
    }
    
    private final String[] columnNames = {"ID", "Nama Pelanggan", "Alamat", "NoTelp"};
    
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
       ModelPelanggan model = list.get(rowIndex);
       switch (columnIndex) {
           case 0:
               return "     " + model.getIdpelanggan();
           case 1:
               return model.getNamapelanggan();
           case 2:
               return model.getNotelppelanggan();
           case 3:
               return model.getAlamatpelanggan();  
           default:
               return null;
       }
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public ModelPelanggan getData(int row) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteData(int row) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
