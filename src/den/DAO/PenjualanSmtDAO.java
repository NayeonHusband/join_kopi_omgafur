package den.DAO;

import den.koneksi.koneksi;
import den.model.ModelPenjualan;
import den.model.ModelPenjualanDetail;
import den.model.ModelPenjualanSmt;
import den.model.ModelProduk;
import den.service.ServicePenjualanSmt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PenjualanSmtDAO implements ServicePenjualanSmt {

    private Connection conn;

    public PenjualanSmtDAO() {
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(ModelPenjualanSmt model) {
         PreparedStatement st = null;
        try {

            String sql = "INSERT INTO penjualan_smt(id_produk, barcode, nama_produk, harga, stok, jumlah, subtotal) VALUES (?,?,?,?,?,?,?)";
            st = conn.prepareStatement(sql);
            st.setInt                   (1, model.getModelProduk().getIdproduk());
            st.setString                (2, model.getModelProduk().getBarcode());
            st.setString                (3, model.getModelProduk().getNamaProduk());
            st.setDouble                (4, model.getModelProduk().getHarga());
            st.setInt                   (5, model.getModelProduk().getStok());
            st.setInt                   (6, model.getModelPenDet().getJumlah());
            st.setDouble                (7, model.getModelPenDet().getSubTotal());      
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void perbaruiData(ModelPenjualanSmt model) {
        PreparedStatement st = null;
        try {
            String sql = "UPDATE penjualan_smt SET barcode=?,nama_produk=?,"
                    + " harga=?, stok=?, jumlah=? ,subtotal=? WHERE id_produk=?";
            st = conn.prepareStatement(sql);
            
            st.setString        (1, model.getModelProduk().getBarcode());
            st.setString        (2, model.getModelProduk().getNamaProduk());
            st.setDouble        (3, model.getModelProduk().getHarga());
            st.setInt           (4, model.getModelProduk().getStok());
            st.setInt           (5, model.getModelPenDet().getJumlah());
            st.setDouble        (6, model.getModelPenDet().getSubTotal());
            st.setInt           (7, model.getModelProduk().getIdproduk());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void hapusData(ModelPenjualanSmt model) {
        PreparedStatement st = null;
        String sql = "DELETE FROM penjualan WHERE id_produk=? AND barcode=? AND nama_produk=? AND harga=? AND stok=? AND jumlah=? AND subtotal=?" ;
        try {
            st = conn.prepareStatement(sql);
            
            st.setInt           (1, model.getModelProduk().getIdproduk());
            st.setString        (2, model.getModelProduk().getBarcode());
            st.setString        (3, model.getModelProduk().getNamaProduk());
            st.setDouble        (4, model.getModelProduk().getHarga());
            st.setInt           (5, model.getModelProduk().getStok());
            st.setInt           (6, model.getModelPenDet().getJumlah());
            st.setDouble        (7, model.getModelPenDet().getSubTotal());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ModelPenjualanSmt> tampilData() {
         PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT * FROM penjualan_smt";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                ModelPenjualanSmt smt = new ModelPenjualanSmt();
                ModelProduk pd = new ModelProduk();
                ModelPenjualanDetail det = new ModelPenjualanDetail();
                
                pd.setIdproduk(rs.getInt("id_produk"));
                pd.setBarcode(rs.getString("barcode"));
                pd.setNamaProduk(rs.getString("nama_produk"));
                pd.setHarga(rs.getDouble("harga"));
                pd.setStok(rs.getInt("stok"));

                det.setJumlah(rs.getInt("jumlah"));
                det.setSubTotal(rs.getLong("subtotal"));

                smt.setModelProduk((pd));
                smt.setModelPenDet(det);
                
                list.add(det);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    }

    
    

