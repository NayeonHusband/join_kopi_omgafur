package den.DAO;

import java.sql.*;
import den.koneksi.koneksi;
import den.model.ModelProduk;
import den.service.ServiceProduk;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class produkDAO implements ServiceProduk {

    private Connection conn;

    public produkDAO() {
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(ModelProduk model) {
        PreparedStatement st = null;
        try {

            String sql = "INSERT INTO product(nama_produk,id_kategori, harga, stok, id_supplier, barcode )"
                    + " VALUES (?,?,?,?,?,?)";
            st = conn.prepareStatement(sql);
            st.setString(1, model.getNamaProduk());
            st.setString(2, model.getIdKategori());
            st.setLong(3, model.getHarga());
            st.setInt(4, model.getStok());
            st.setString(5, model.getIdSupplier());
            st.setString(6, model.getBarcode());

            st.executeQuery();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void perbaruiData(ModelProduk model) {
        PreparedStatement st = null;
        try {

            String sql = "UPDATE product SET nama_produk=?,id_kategori=?,"
                    + " harga=?, stok=?, id_supplier=?, barcode=? WHERE id_produk=?";
            st = conn.prepareStatement(sql);
            st.setString(1, model.getNamaProduk());
            st.setString(2, model.getIdKategori());
            st.setLong(3, model.getHarga());
            st.setInt(4, model.getStok());
            st.setString(5, model.getIdSupplier());
            st.setString(6, model.getBarcode());
            st.setInt(7, model.getIdproduk());

            st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hapusData(ModelProduk model) {
        PreparedStatement st = null;
        String sql = "DELETE FROM product WHERE id_produk=?";
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, model.getIdproduk());
            st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ModelProduk> tampilData() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT * FROM product";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                ModelProduk produk = new ModelProduk();
                produk.setIdProduk (rs.getInt("id_produk"));
                produk.setNamaProduk (rs.getString("nama_produk"));
                produk.setIdKategori (rs.getString("id_kategori"));
                produk.setHarga (rs.getLong("harga"));
                produk.setStok (rs.getInt("stok"));
                produk.setIdSupplier (rs.getString("id_supplier"));
                produk.setBarcode (rs.getString("Barcode"));
                
                list.add(produk);
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ModelProduk> pencarianData(String id) {
                PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT * FROM product WHERE nama_produk LIKE '%"+id+"%' "
                + "OR id_kategori LIKE '%"+id+"%'"
                + "OR id_supplier LIKE '%"+id+"%'"
                + "OR barcode LIKE '%"+id+"%'";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                ModelProduk produk = new ModelProduk();
                produk.setIdProduk (rs.getInt("id_produk"));
                produk.setNamaProduk (rs.getString("nama_produk"));
                produk.setIdKategori (rs.getString("id_kategori"));
                produk.setHarga (rs.getLong("harga"));
                produk.setStok (rs.getInt("stok"));
                produk.setIdSupplier (rs.getString("id_supplier"));
                produk.setBarcode (rs.getString("Barcode"));
                
                list.add(produk);
            } 
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
