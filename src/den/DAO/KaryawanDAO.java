package den.DAO;

import den.DAO.KaryawanDAO;
import den.koneksi.koneksi;
import den.model.ModelKaryawan;
import den.service.ServiceKaryawan;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class KaryawanDAO implements ServiceKaryawan {

    private Connection conn;

    public KaryawanDAO() {
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(ModelKaryawan model) {
        PreparedStatement st = null;
        try {
            String sql = "INSERT INTO karyawan(nama_karyawan, username, password, telepon, alamat, role) VALUES (?,?,?,?,?,?)";

            st = conn.prepareStatement(sql);
            st.setString(1, model.getNamaKaryawan());
            st.setString(2, model.getUsername());
            st.setString(3, generateSHA256(model.getPassword()));
            st.setString(4, model.getTelepon());
            st.setString(5, model.getAlamat());
            st.setString(6, model.getRole());

            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void perbaruiData(ModelKaryawan model) {
        PreparedStatement st = null;
        try {
            String sql = "UPDATE karyawan SET nama_karyawan=?, username=?, telepon=?, alamat=?, role=? WHERE id_karyawan=?";

           st = conn.prepareStatement(sql);
            st.setString(1, model.getNamaKaryawan());
            st.setString(2, model.getUsername());
          //  st.setString(3, model.getPassword());
            st.setString(3, model.getTelepon());
            st.setString(4, model.getAlamat());
            st.setString(5, model.getRole());
            st.setInt(6, model.getIdKaryawan());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hapusData(ModelKaryawan model) {
        PreparedStatement st = null;
        String sql = "DELETE FROM karyawan WHERE id_karyawan=?";
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, model.getIdKaryawan());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ModelKaryawan> tampilData() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT * FROM karyawan";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                ModelKaryawan model = new ModelKaryawan();
                model.setIdKaryawan(rs.getInt("id_karyawan"));
                model.setNamaKaryawan(rs.getString("nama_karyawan"));
                model.setUsername(rs.getString("username"));
             //   model.setPassword(rs.getString("password"));
                model.setTelepon(rs.getString("telepon"));
                model.setAlamat(rs.getString("alamat"));
                model.setRole(rs.getString("role"));


                list.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ModelKaryawan> pencarianData(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT * FROM karyawan WHERE id_karyawan LIKE '%" + id + "%' "
                + " OR nama_karyawan LIkE '%" + id + "%' "
                + " OR username LIKE '%" + id + "%' "
                + " OR telepon LIKE '%" + id + "%' "
                + " OR alamat LIKE '%" + id + "%' "
                + " OR role LIKE '%" + id + "%' ";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                ModelKaryawan model = new ModelKaryawan();
                model.setIdKaryawan(rs.getInt("id_karyawan"));
                model.setNamaKaryawan(rs.getString("nama_karyawan"));
                model.setUsername(rs.getString("username"));
                model.setTelepon(rs.getString("telepon"));
                model.setAlamat(rs.getString("alamat"));
                model.setRole(rs.getString("role"));


                list.add(model);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String generateSHA256(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodehash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder(2 * encodehash.length);
            
            for (byte b : encodehash) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
