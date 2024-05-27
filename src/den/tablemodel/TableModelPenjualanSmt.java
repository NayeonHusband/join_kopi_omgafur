package den.tablemodel;

import den.model.ModelPenjualanSmt;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class TableModelPenjualanSmt extends AbstractTableModel {

    private List<ModelPenjualanSmt> list = new ArrayList<>();

    public ModelPenjualanSmt getData(int index) {
        return list.get(index);
    }

    public void clear() {
        list.clear();
        fireTableDataChanged();
    }

    public void setData(List<ModelPenjualanSmt> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }

    //peringatan data berhasil di tambahkan
    public void insertData(ModelPenjualanSmt model) {
        list.add(model);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }

    //peringatan data berhasil di perbarui
    public void updateData(int row, ModelPenjualanSmt model) {
        list.set(row, model);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data Berhasil Diperbarui");
    }

    //peringatan data berhasil di hapus
    public void deleteData(int row) {
        list.remove(row);
        fireTableRowsDeleted(row, row);
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
    }

    private final String[] ColumnNames = {"ID","ID Produk", "Barcode", "Nama Produk", "Harga", "Stok", "Jumlah", "SubTotal"};

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
        ModelPenjualanSmt model = list.get(rowIndex);
        if (columnIndex == 0) {
            return "   " + (rowIndex + 1);
        } else {
            switch (columnIndex) {
                case 1:
                    return model.getModelProduk().getIdproduk();
                case 2:
                    return model.getModelProduk().getBarcode();
                case 3:
                    return model.getModelProduk().getNamaProduk();
                case 4:
                    return model.getModelProduk().getHarga();
                case 5:
                    return model.getModelProduk().getStok();
                case 6:
                    return model.getModelPenDet().getJumlah();
                case 7:
                    return model.getModelPenDet().getSubTotal();
                default:
                    return null;

            }
        }
    }

    @Override
    public String getColumnName(int column) {
        return ColumnNames[column];
    }

}
