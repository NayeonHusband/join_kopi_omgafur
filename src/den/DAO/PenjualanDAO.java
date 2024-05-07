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
import java.sql.Date;

public class PenjualanDAO implements ServicePenjualan {

    private Connection conn;

    public PenjualanDAO() {
        conn = koneksi.getConnection();
    }

    @Override
    public void tambahData(ModelPenjualan model) {
        PreparedStatement st = null;
        try {

            String sql = "INSERT INTO penjualan(id_penjualan, id_pelanggan, tanggal, total_harga, bayar, diskon, kembali, id_karyawan) VALUES (?,?,?,?,?,?,?,?)";
            st = conn.prepareStatement(sql);
            st.setString                (1, model.getIdPenjualan());
            st.setInt                   (2, model.getModelPelanggan().getIdpelanggan());
            st.setString                (3, model.getTanggal());
            st.setDouble                (4, model.getTotalHarga());
            st.setDouble                (5, model.getBayar());
            st.setDouble                (6, model.getDiskon());
            st.setDouble                (7, model.getKembali());
            st.setInt                   (7, model.getModelKaryawan().getIdKaryawan());      
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ModelPenjualan> tampilData() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT pj.id_penjualan,pl.id_pelanggan,pl.nama_pelanggan,pj.tanggal,"
                +"pj.total_harga,pj.bayar,pj.diskon,pj.kembali,ky.id_karyawan,ky.nama_karyawan\n"
                +"From Penjualan pj\n"
                +"INNER JOIN pelanggan pl ON pl.id_pelanggan = pj.id_pelanggan\n"
                +"INNER JOIN karyawan ky ON ky.id_karyawan = ky.id_karyawan";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                ModelPenjualan pj = new ModelPenjualan();
                ModelPelanggan pl = new ModelPelanggan();
                ModelKaryawan  ky  = new ModelKaryawan();
                
                pj.setIdPenjualan       (rs.getString("id_penjualan"));
                pl.setIdPelanggan       (rs.getInt("id_pelanggan"));
                pl.setNamaPelanggan     (rs.getString("nama_pelanggan"));
                pj.setTanggal           (rs.getString("tanggal"));
                pj.setTotalHarga        (rs.getLong("total_harga"));
                pj.setBayar             (rs.getDouble("bayar"));
                pj.setDiskon            (rs.getDouble("diskon"));
                pj.setKembali           (rs.getDouble("kembali"));
                ky.setIdKaryawan        (rs.getInt("id_karyawan"));
                ky.setNamaKaryawan      (rs.getString("nama_karyawan"));
                
                pj.setModelPelanggan(pl);
                pj.setModelKaryawan(ky);
                
                list.add(pj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ModelPenjualan> pencarianData(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List list = new ArrayList();
         String sql = "SELECT pj.id_penjualan,pl.id_pelanggan,pl.nama_pelanggan,pj.tanggal,"
                +"pj.total_harga,pj.bayar,pj.diskon,pj.kembali,ky.id_karyawan,ky.nama_karyawan\n"
                +"From Penjualan pj\n"
                +"INNER JOIN pelanggan pl ON pl.id_pelanggan = pj.id_pelanggan\n"
                +"INNER JOIN karyawan ky ON ky.id_karyawan = ky.id_karyawan"
                +"WHERE pj.id_penjualan LIKE '%"+id+"%'"
                +"OR pl.id_pelanggan LIKE '%"+id+"%'"
                +"OR pl.nama_pelanggan LIKE '%"+id+"%'"
                +"OR pj.tanggal LIKE '%"+id+"%'" 
                +"OR ky.id_karyawan LIKE '%"+id+"%'"
                +"OR ky.nama_karyawan LIKE '%"+id+"%'"; 
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                ModelPenjualan pj = new ModelPenjualan();
                ModelPelanggan pl = new ModelPelanggan();
                ModelKaryawan ky = new ModelKaryawan();
                
                pj.setIdPenjualan       (rs.getString("id_penjualan"));
                pl.setIdPelanggan       (rs.getInt("id_pelanggan"));
                pl.setNamaPelanggan     (rs.getString("nama_pelanggan"));
                pj.setTanggal           (rs.getString("tanggal"));
                pj.setTotalHarga        (rs.getLong("total_harga"));
                pj.setBayar             (rs.getDouble("bayar"));
                pj.setDiskon            (rs.getDouble("diskon"));
                pj.setKembali           (rs.getDouble("kembali"));
                ky.setIdKaryawan        (rs.getInt("id_karyawan"));
                ky.setNamaKaryawan      (rs.getString("nama_karyawan"));
                
                pj.setModelPelanggan    (pl);
                pj.setModelKaryawan     (ky);
                
                lsi.add(pj);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String noTransaksi() {
     PreparedStatement st = null;
     String urutan = null;
     
     Date now = new Date();
     SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
     SimpleDateFormat noformat = new SimpleDateFormat("yyMMdd");    
     String tgl = tanggal.format(now);
     String no = noformat.format(now);
     
     String sql = "SELECT RIGHT(id_penjualan, 3) As Nomor"
                   +"FROM penjualan"
                   +"WHERE id_penjualan Like 'TRX"+ no +"%'"
                   +"ORDER BY id_penjualan DESC"
                   +"LIMIT 1";
     
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
          
            if(rs.next()){
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan ="TRX" + no + String.format("%03d", nomor);
            }else {
                urutan= "TRX"+ no + "001";
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            if(st != null){
                try {
                st.close();
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
        }
    return urutan;
    }
    
}
