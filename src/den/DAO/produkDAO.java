package den.DAO;

import java.sql.*;
import den.koneksi.koneksi;
import den.model.ModelProduk;
import den.service.ServiceProduk;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class produkDAO implements ServiceProduk {

    private Connection conn;

    public produkDAO() {
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(ModelProduk model) {
        PreparedStatement st = null;
        try {

            String sql = "INSERT INTO product(nama_produk, id_kategori, harga, stok, gram, id_supplier, barcode, expired) VALUES (?,?,?,?,?,?,?,?)";
            st = conn.prepareStatement(sql);
            st.setString(1, model.getNamaProduk());
            st.setInt(2, model.getIdKategori());
            st.setDouble(3, model.getHarga());
            st.setInt(4, model.getStok());
            st.setInt(5, model.getGram());
            st.setInt(6, model.getIdSupplier());
            st.setString(7, model.getBarcode());
            st.setDate(8, new java.sql.Date(model.getExpired().getTime()));

            st.executeUpdate();
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
            st.setInt(2, model.getIdKategori());
            st.setDouble(3, model.getHarga());
            st.setInt(4, model.getStok());
            st.setInt(5, model.getIdSupplier());
            st.setString(6, model.getBarcode());
            st.setInt(7, model.getIdproduk());

            st.executeUpdate();
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
            st.executeUpdate();
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
            while (rs.next()) {
                ModelProduk produk = new ModelProduk();
                produk.setIdproduk(rs.getInt("id_produk"));
                produk.setNamaProduk(rs.getString("nama_produk"));
                produk.setIdKategori(rs.getInt("id_kategori"));
                produk.setHarga(rs.getDouble("harga"));
                produk.setStok(rs.getInt("stok"));
                produk.setGram(rs.getInt("gram"));
                produk.setIdSupplier(rs.getInt("id_supplier"));
                produk.setBarcode(rs.getString("Barcode"));
                produk.setExpired(rs.getDate("expired"));

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
        String sql = "SELECT * FROM product WHERE nama_produk LIKE '%" + id + "%' "
                + "OR id_kategori LIKE '%" + id + "%'"
                + "OR id_supplier LIKE '%" + id + "%'"
                + "OR barcode LIKE '%" + id + "%'";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                ModelProduk produk = new ModelProduk();
                produk.setIdproduk(rs.getInt("id_produk"));
                produk.setNamaProduk(rs.getString("nama_produk"));
                produk.setIdKategori(rs.getInt("id_kategori"));
                produk.setHarga(rs.getDouble("harga"));
                produk.setStok(rs.getInt("stok"));
                produk.setIdSupplier(rs.getInt("id_supplier"));
                produk.setBarcode(rs.getString("Barcode"));

                list.add(produk);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ModelProduk> pencarianDataByBarcode(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<ModelProduk> list = new ArrayList();
        String sql = "SELECT * FROM product WHERE barcode = ?";

        try {
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                ModelProduk produk = new ModelProduk();
                produk.setIdproduk(rs.getInt("id_produk"));
                produk.setNamaProduk(rs.getString("nama_produk"));
                produk.setIdKategori(rs.getInt("id_kategori"));
                produk.setHarga(rs.getDouble("harga"));
                produk.setStok(rs.getInt("stok"));
                produk.setIdSupplier(rs.getInt("id_supplier"));
                produk.setBarcode(rs.getString("Barcode"));

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
