package den.tablemodel;

import den.model.ModelPenjualan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


public class TableModelPenjualan extends AbstractTableModel {
    
    private List<ModelPenjualan> list = new ArrayList<>();
    
    public ModelPenjualan getData(int index) {
        return list.get(index);
    }
    public void clear() {
        list.clear();
        fireTableDataChanged();
    }
    public void setData (List<ModelPenjualan> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    //peringatan data berhasil di tambahkan
    public void insertData(ModelPenjualan produk) {
        list.add(produk);
        fireTableRowsInserted(list.size() -1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    //peringatan data berhasil di perbarui
    public void updateData(int row, ModelPenjualan model) {
        list.set(row,model);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data Berhasil Diperbarui");
    }
    //peringatan data berhasil di hapus
    public void deleteData(int row) {
        list.remove(row);
        fireTableRowsDeleted(row, row);
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
    }
    
    private final String[] ColumnNames = {"NO","ID Transaksi", "ID Pelanggan", "Nama Pelanggan","Tanggal" ,"Total Harga","Bayar","Diskon","Kembali","ID Karyawan","Nama Karyawan"};
    

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return ColumnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModelPenjualan model = list.get(rowIndex);
        if(columnIndex == 0){
        return "  "+(rowIndex + 1);
        }else {
                    switch (columnIndex) {
            case 0:
            return model.getIdPenjualan();
            case 1:
            return model.getModelPelanggan().getIdpelanggan();
            case 2:
            return model.getModelPelanggan().getNamapelanggan();
            case 3:
            return model.getTanggal();
            case 4:
            return model.getTotalHarga();
            case 5:
            return model.getBayar();
            case 6:
            return model.getDiskon();
            case 7:
            return model.getKembali();
            case 8:
            return model.getModelKaryawan().getIdKaryawan();
            case 9:
            return model.getModelKaryawan().getNamaKaryawan();
            default :
                return null;
                
        }
        }
    }

    @Override
    public String getColumnName(int column) {
        return ColumnNames[column];
    }
    
}