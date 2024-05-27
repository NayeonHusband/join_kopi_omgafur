package den.DAO;

import java.sql.*;
import den.koneksi.koneksi;
import den.model.ModelPenjualanDetail;
import den.model.ModelPenjualan;
import den.model.ModelProduk;
import den.service.ServicePenjualanDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class PenjualanDetailDAO implements ServicePenjualanDetail {

    private Connection conn;

    public PenjualanDetailDAO() {
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(ModelPenjualanDetail model) {
        PreparedStatement st = null;
        try {

            String sql = "INSERT INTO detail_penjualan(id_penjualan, id_produk, jumlah, subtotal) "
                    + "SELECT '" +model.getModelPenjualan().getIdPenjualan()+"', "
                    + "id_produk, jumlah, subtotal FROM penjualan_smt";
            st = conn.prepareStatement(sql);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sumTotal(ModelPenjualanDetail model) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT SUM(subtotal) FROM penjualan_smt";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if (rs.next()) {
                model.setSubTotal(rs.getLong(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void hapusDataSementara() {
        PreparedStatement st = null;
        String sql = "DELETE FROM penjualan_smt";

        try {
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<ModelPenjualanDetail> tampilData(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT pj.id_penjualan, pd.id_produk, pd.nama_produk, det.jumlah, det.subtotal\n"
                + "FROM detail_penjualan det\n"
                + "INNER JOIN penjualan pj ON pj.id_penjualan = det.id_penjualan\n"
                + "INNER JOIN product pd ON pd.id_produk = det.id_produk "
                + "WHERE pj.id_penjualan='"+id+"'";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                ModelPenjualanDetail det = new ModelPenjualanDetail();
                ModelPenjualan pj = new ModelPenjualan();
                ModelProduk pd = new ModelProduk();

                pj.setIdPenjualan(rs.getString("id_penjualan"));
                pd.setIdproduk(rs.getInt("id_produk"));
                pd.setNamaProduk(rs.getString("nama_produk"));
                det.setJumlah(rs.getInt("jumlah"));
                det.setSubTotal(rs.getDouble("subtotal"));

                det.setModelPenjualan(pj);
                det.setModelProduk(pd);

                list.add(det);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
 @Override
    public List<ModelPenjualanDetail> pencarianData(String id,String kataKunci) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT pj.id_penjualan, pd.id_produk, pd.nama_produk, det.jumlah, det.subtotal\n"
                + "FROM detail_penjualan det\n"
                + "INNER JOIN penjualan pj ON pj.id_penjualan = det.id_penjualan\n"
                + "INNER JOIN produk pd ON pd.id_produk = det.id_produk "
                + "WHERE pj.id_penjualan='"+ id +"'"
                + "AND (pj.id_penjualan LIKE '%"+kataKunci+"%',"
                + "OR pd.id_produk LIKE '%"+kataKunci+"%'"
                + "OR pd.nama_produk LIKE '%"+kataKunci+"%')";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                ModelPenjualanDetail det = new ModelPenjualanDetail();
                ModelPenjualan pj = new ModelPenjualan();
                ModelProduk pd = new ModelProduk();

                pj.setIdPenjualan(rs.getString("id_penjualan"));
                pd.setIdproduk(rs.getInt("id_produk"));
                pd.setNamaProduk(rs.getString("nama_produk"));
                det.setJumlah(rs.getInt("jumlah"));
                det.setSubTotal(rs.getLong("subtotal"));

                det.setModelPenjualan(pj);
                det.setModelProduk(pd);

                list.add(det);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}