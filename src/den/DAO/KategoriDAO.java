package den.DAO;

import java.sql.*;
import den.koneksi.koneksi;
import den.model.ModelKategori;
import den.service.ServiceKategori;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class KategoriDAO implements ServiceKategori {

    private Connection conn;

    public KategoriDAO() {
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(ModelKategori model) {
        PreparedStatement st = null;
        try {

            String sql = "INSERT INTO kategori(nama_kategori) VALUES (?)";
            st = conn.prepareStatement(sql);
            st.setString(1, model.getNamaKategori());

            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void perbaruiData(ModelKategori model) {
        PreparedStatement st = null;
        try {

            String sql = "UPDATE kategori SET nama_kategori =? WHERE id_kategori=?";
            st = conn.prepareStatement(sql);
            st.setString(1, model.getNamaKategori());
            st.setInt(2, model.getIdKategori());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hapusData(ModelKategori model) {
        PreparedStatement st = null;
        String sql = "DELETE FROM kategori WHERE id_kategori=?";
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, model.getIdKategori());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ModelKategori> tampilData() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT * FROM kategori";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                ModelKategori kategori = new ModelKategori();
                kategori.setIdKategori(rs.getInt("id_kategori"));
                kategori.setNamaKategori(rs.getString("nama_kategori"));
                list.add(kategori);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ModelKategori> pencarianData(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT * FROM kategori WHERE nama_kategori LIKE '%" + id + "%' "
                + "OR id_kategori LIKE '%" + id + "%' ";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                ModelKategori kategori
                        = new ModelKategori();
                kategori.setIdKategori(rs.getInt("id_kategori"));
                kategori.setNamaKategori(rs.getString("nama_kategori"));

                list.add(kategori);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean validasiNamaKategori(ModelKategori model) {
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean valid = false;

        String sql = "SELECT nama_kategori FROM kategori WHERE nama_kategori LIKE BINARY ?";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, model.getNamaKategori());
            rs = st.executeQuery();

            if (rs.next()) {
                valid = false;
            } else {
                valid = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return valid;
    }
}
