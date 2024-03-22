package den.join.tablemodel;

import den.join.model.ModelProduk;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelProduk extends AbstractTableModel {
    
    private List<ModelProduk> list = new ArrayList<>();
    private final String[] ColumnNames = {"ID", "Nama Produk", "ID Kategori", "Harga","stok","ID supplier", "Barcode"};
    

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
        ModelProduk produk = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
            return produk.getIdproduk();
            case 1:
            return produk.getNamaProduk();
            case 2:
            return produk.getIdKategori();
            case 3:
            return produk.getHarga();
            case 4:
            return produk.getStok();
            case 5:
            return produk.getIdSupplier();
            case 6:
            return produk.getBarcode();
            default :
                return null;
                
        }
    }

    @Override
    public String getColumnName(int column) {
        return ColumnNames[column];
    }
    
}
