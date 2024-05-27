package den.DAO;

import java.sql.*;
import den.koneksi.koneksi;
import den.model.ModelPenjualan;
import den.model.ModelPelanggan;
import den.model.ModelKaryawan;
import den.service.ServicePenjualan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

public class PenjualanDAO implements ServicePenjualan {

    private Connection conn;

    public PenjualanDAO() {
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(ModelPenjualan model) {
        PreparedStatement st = null;
        try {
            String sql = "INSERT INTO penjualan(id_penjualan, id_pelanggan, tanggal, "
                    + "total_harga, bayar, diskon, kembali, id_karyawan) VALUES (?,?,?,?,?,?,?,?)";
            st = conn.prepareStatement(sql);
            st.setString(1, model.getIdPenjualan());
            st.setInt(2, model.getModelPelanggan().getIdpelanggan());
            st.setString(3, model.getTanggal());
            st.setDouble(4, model.getTotalHarga());
            st.setDouble(5, model.getBayar());
            st.setDouble(6, model.getDiskon());
            st.setDouble(7, model.getKembali());
            st.setInt(8, model.getModelKaryawan().getIdKaryawan());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ModelPenjualan> tampilData(Integer id_karyawan) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<ModelPenjualan> list = new ArrayList<>();
        String sql = "SELECT pj.id_penjualan, pl.id_pelanggan, pl.nama_pelanggan, pj.tanggal, "
                + "pj.total_harga, pj.bayar, pj.diskon, pj.kembali, ky.id_karyawan, ky.nama_karyawan "
                + "FROM penjualan pj "
                + "INNER JOIN pelanggan pl ON pl.id_pelanggan = pj.id_pelanggan "
                + "INNER JOIN karyawan ky ON ky.id_karyawan = pj.id_karyawan "
                + "WHERE ky.id_karyawan = ?";

        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, id_karyawan);
            rs = st.executeQuery();
            while (rs.next()) {
                ModelPenjualan pj = new ModelPenjualan();
                ModelPelanggan pl = new ModelPelanggan();
                ModelKaryawan ky = new ModelKaryawan();

                // Set nilai dari hasil set ke objek model
                pj.setIdPenjualan(rs.getString("id_penjualan"));
                pl.setIdpelanggan(rs.getInt("id_pelanggan"));
                pl.setNamapelanggan(rs.getString("nama_pelanggan"));
                pj.setTanggal(rs.getString("tanggal"));
                pj.setTotalHarga(rs.getLong("total_harga"));
                pj.setBayar(rs.getDouble("bayar"));
                pj.setDiskon(rs.getDouble("diskon"));
                pj.setKembali(rs.getDouble("kembali"));
                ky.setIdKaryawan(rs.getInt("id_karyawan"));
                ky.setNamaKaryawan(rs.getString("nama_karyawan"));

                // Menghubungkan pelanggan dan karyawan ke penjualan
                pj.setModelPelanggan(pl);
                pj.setModelKaryawan(ky);

                // Tambahkan ke daftar
                list.add(pj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Tutup sumber daya
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
        return list;
    }

    @Override
    public List<ModelPenjualan> pencarianData(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<ModelPenjualan> list = new ArrayList<>();
        String sql = "SELECT pj.id_penjualan, pl.id_pelanggan, pl.nama_pelanggan, pj.tanggal, "
                + "pj.total_harga, pj.bayar, pj.diskon, pj.kembali, ky.id_karyawan, ky.nama_karyawan "
                + "FROM penjualan pj "
                + "INNER JOIN pelanggan pl ON pl.id_pelanggan = pj.id_pelanggan "
                + "INNER JOIN karyawan ky ON ky.id_karyawan = pj.id_karyawan "
                + "WHERE pj.id_penjualan LIKE ? "
                + "OR pl.id_pelanggan LIKE ? "
                + "OR pl.nama_pelanggan LIKE ? "
                + "OR pj.tanggal LIKE ? "
                + "OR ky.id_karyawan LIKE ? "
                + "OR ky.nama_karyawan LIKE ?";
        try {
            st = conn.prepareStatement(sql);
            String queryParam = "%" + id + "%";
            st.setString(1, queryParam);
            st.setString(2, queryParam);
            st.setString(3, queryParam);
            st.setString(4, queryParam);
            st.setString(5, queryParam);
            st.setString(6, queryParam);

            rs = st.executeQuery();
            while (rs.next()) {
                ModelPenjualan pj = new ModelPenjualan();
                ModelPelanggan pl = new ModelPelanggan();
                ModelKaryawan ky = new ModelKaryawan();

                // Set nilai dari hasil set ke objek model
                pj.setIdPenjualan(rs.getString("id_penjualan"));
                pl.setIdpelanggan(rs.getInt("id_pelanggan"));
                pl.setNamapelanggan(rs.getString("nama_pelanggan"));
                pj.setTanggal(rs.getString("tanggal"));
                pj.setTotalHarga(rs.getLong("total_harga"));
                pj.setBayar(rs.getDouble("bayar"));
                pj.setDiskon(rs.getDouble("diskon"));
                pj.setKembali(rs.getDouble("kembali"));
                ky.setIdKaryawan(rs.getInt("id_karyawan"));
                ky.setNamaKaryawan(rs.getString("nama_karyawan"));

                // Menghubungkan pelanggan dan karyawan ke penjualan
                pj.setModelPelanggan(pl);
                pj.setModelKaryawan(ky);

                // Tambahkan ke daftar
                list.add(pj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Tutup sumber daya
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
        return list;
    }

    @Override
    public String noTransaksi() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String urutan = null;

        Date now = new Date();
        SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat noformat = new SimpleDateFormat("yyMMdd");
        String tgl = tanggal.format(now);
        String no = noformat.format(now);

        String sql = "SELECT RIGHT(id_penjualan, 3) AS Nomor "
                + "FROM penjualan "
                + "WHERE id_penjualan LIKE 'TRX" + no + "%' "
                + "ORDER BY id_penjualan DESC "
                + "LIMIT 1";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = "TRX" + no + String.format("%03d", nomor);
            } else {
                urutan = "TRX" + no + "001";
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
        return urutan;
    }

}
