package den.tablemodel;

import den.model.ModelPenjualanDetail;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class TableModelPenjualanDetail extends AbstractTableModel {

    private List<ModelPenjualanDetail> list = new ArrayList<>();

    public ModelPenjualanDetail getData(int index) {
        return list.get(index);
    }

    public void clear() {
        list.clear();
        fireTableDataChanged();
    }

    public void setData(List<ModelPenjualanDetail> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }

    //peringatan data berhasil di tambahkan
    public void insertData(ModelPenjualanDetail model) {
        list.add(model);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }

    //peringatan data berhasil di perbarui
    public void updateData(int row, ModelPenjualanDetail model) {
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

    private final String[] ColumnNames = {"NO", "ID Transaksi", "ID Produk", "Nama Produk", "Jumlah", "Subtotal"};

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
        ModelPenjualanDetail model = list.get(rowIndex);
        if (columnIndex == 0) {
            return "   " + (rowIndex + 1);
        } else {
            switch (columnIndex) {
                case 0:
                    return model.getModelPenjualan().getIdPenjualan();
                case 1:
                    return model.getModelProduk().getIdproduk();
                case 2:
                    return model.getModelProduk().getNamaProduk();
                case 3:
                    return model.getJumlah();
                case 4:
                    return model.getSubTotal();

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
