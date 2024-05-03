package den.DAO;

import den.DAO.PelangganDAO;
import den.koneksi.koneksi;
import den.model.ModelPelanggan;
import den.service.ServicePelanggan;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class PelangganDAO implements ServicePelanggan {

    private Connection conn;

    public PelangganDAO() {
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(ModelPelanggan model) {
        PreparedStatement st = null;
        try {
            String sql = "INSERT INTO pelanggan(nama_pelanggan, telepon, alamat) VALUES (?,?,?)";

            st = conn.prepareStatement(sql);
            st.setString(1, model.getNamapelanggan());
            st.setString(2, model.getNotelpelanggan());
            st.setString(3, model.getAlamatpelanggan());

            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void perbaruiData(ModelPelanggan model) {
        PreparedStatement st = null;
        try {
            String sql = "UPDATE pelanggan SET nama_pelanggan=?, telepon=?, alamat=? WHERE id_pelanggan=?";

            st = conn.prepareStatement(sql);
            st.setString(1, model.getNamapelanggan());
            st.setString(2, model.getNotelpelanggan());
            st.setString(3, model.getAlamatpelanggan());
            st.setInt(4, model.getIdpelanggan());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hapusData(ModelPelanggan model) {
        PreparedStatement st = null;
        String sql = "DELETE FROM pelanggan WHERE id_pelanggan=?";
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, model.getIdpelanggan());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ModelPelanggan> tampilData() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT * FROM pelanggan";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                ModelPelanggan model = new ModelPelanggan();
                model.setIdpelanggan(rs.getInt("id_pelanggan"));
                model.setNamapelanggan(rs.getString("nama_pelanggan"));
                model.setNotelpelanggan(rs.getString("telepon"));
                model.setAlamatpelanggan(rs.getString("alamat"));

                list.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ModelPelanggan> pencarianData(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT * FROM pelanggan WHERE id_pelanggan LIKE '%" + id + "%' "
                + " OR nama_pelanggan LIkE '%" + id + "%' "
                + " OR telepon LIKE '%" + id + "%' "
                + " OR alamat LIKE '%" + id + "%' ";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                ModelPelanggan model = new ModelPelanggan();
                model.setIdpelanggan(rs.getInt("id_pelanggan"));
                model.setNamapelanggan(rs.getString("nama_pelanggan"));
                model.setNotelpelanggan(rs.getString("telepon"));
                model.setAlamatpelanggan(rs.getString("alamat"));

                list.add(model);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
