//package den.join.DAO;
//
//import den.join.koneksi.koneksi;
//import den.join.model.ModelSupplier;
//import den.join.service.ServiceSupplier;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;
//import java.sql.Date;
//import java.util.List;
//import java.sql.*;
//import java.util.ArrayList;
//
//public class SupplierDAO implements ServiceSupplier{
//    
//    private Connection conn;
//    
//    public SupplierDAO() {
//        conn = koneksi.getConnection();
//    }
//
//    @Override
//    public void tambahData(ModelSupplier model) {
//        PreparedStatement st = null;
//        try {
//            String sql = "INSERT INTO supplier(nama_supplier, alamat, telepon, id_bahan, nama_bahan, jumlah, tanggal) VALUES (?,?,?,?,?,?,?)";
//            
//            st = conn.prepareStatement(sql);
//            st.setString   (1, model.getNamaSupplier());
//            st.setString   (2, model.getAlamatSupplier());
//            st.setString   (3, model.getNotelpSupplier());
//            st.setInt      (4, model.getIdbahan());
//            st.setString   (5, model.getNamabahan());
//            st.setInt      (6, model.getJumlah());
//        //    st.setDate     (7, model.getTanggal());
//            
//            st.executeUpdate();
//            st.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void perbaruiData(ModelSupplier model) {
//        PreparedStatement st = null;
//        try {
//            String sql = "UPDATE supplier SET nama_supplier=?, alamat=?, telepon=?, id_bahan=?, nama_bahan=?, jumlah=?, tanggal=? WHERE id_supplier=?";
//                    
//         st = conn.prepareStatement(sql);
//            st.setString   (1, model.getNamaSupplier());
//            st.setString   (2, model.getAlamatSupplier());
//            st.setString   (3, model.getNotelpSupplier());
//            st.setInt      (4, model.getIdbahan());
//            st.setString   (5, model.getNamabahan());
//            st.setInt      (6, model.getJumlah());
//   //         st.setDate   (7, model.getTanggal());
//            
//            st.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void hapusData(ModelSupplier model) {
//        PreparedStatement st = null;
//        String sql = "DELETE FROM supplier WHERE id_supplier=?";
//        try {
//            st = conn.prepareStatement(sql);
//            st.setInt(1, model.getIdSupplier());
//            st.executeUpdate();            
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public List<ModelSupplier> tampilData() {
//        PreparedStatement st = null;
//        ResultSet rs = null;
//        List list = new ArrayList();
//        String sql ="SELECT * FROM supplier";
//        
//        try {
//            st = conn.prepareStatement(sql);
//            rs = st.executeQuery();
//            while(rs.next()){
//                ModelSupplier model = new ModelSupplier();
//                model.setIdSupplier    (rs.getInt("id_supplier"));
//                model.setNamaSupplier  (rs.getString("nama_supplier"));
//                model.setAlamatSupplier(rs.getString("alamat"));
//                model.setNotelpSupplier(rs.getString("telepon"));
//                model.setIdbahan       (rs.getInt("id_bahan"));
//                model.setNamabahan     (rs.getString("nama_bahan"));
//                model.setJumlah        (rs.getInt("jumlah"));
//                model.setTanggal       (rs.getDate("tanggal"));
//                
//                list.add(model);
//            }
//            } catch (SQLException e){
//                 e.printStackTrace();
//                    }
//            return list;
//    }
//
//    @Override
//    public List<ModelSupplier> pencarianData(String id) {
//        PreparedStatement st = null;
//        ResultSet rs = null;
//        List list= new ArrayList();
//        String sql = "SELECT * FROM supplier WHERE nama_supplier LIKE '%"+id+"%' "
//                + "OR nama_supplier LIKE '%"+id+"%' "
//                + "OR alamat LIKE '%"+id+"%' "
//                + "OR telepon LIKE '%"+id+"%' "
//                + "OR id_bahan LIKE '%"+id+"%' "
//                + "OR nama_bahan LIKE '%"+id+"%' "
//                + "OR jumlah LIKE '%"+id+"%' "
//                + "OR tanggal LIKE '%"+id+"%' " ;
//        
//        try {
//            st = conn.prepareStatement(sql);
//            rs = st.executeQuery();
//            while(rs.next()){
//                 ModelSupplier model = new ModelSupplier();
//                model.setIdSupplier    (rs.getInt("id_supplier"));
//                model.setNamaSupplier  (rs.getString("nama_supplier"));
//                model.setAlamatSupplier(rs.getString("alamat"));
//                model.setNotelpSupplier(rs.getString("telepon"));
//                model.setIdbahan       (rs.getInt("id_bahan"));
//                model.setNamabahan     (rs.getString("nama_bahan"));
//                model.setJumlah        (rs.getInt("jumlah"));
//                model.setTanggal       (rs.getDate("tanggal"));
//                
//                list.add(model);
//            }
//            rs.close();
//            st.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    @Override
//    public boolean validasiNamaSupplier(ModelSupplier model) {
//        PreparedStatement st = null;
//        ResultSet rs = null;
//        boolean valid = false;
//        
//            String sql = "SELECT nama_supplier FROM supplier "
//                    + "WHERE nama_supplier LIKJE BINARY ? AND id_supplier 1=?";
//        try {
//            st = conn.prepareStatement(sql);
//            st.setString(1, model.getNamaSupplier());
//            st.setInt(2, model.getIdSupplier());
//            rs = st.executeQuery();
//            
//            if(rs.next()){
//                valid = false;
//            } else {
//                valid = true;
//            }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } finally {
//              try{
//                  if(rs != null){
//                      rs.close();
//                  }
//                  if(st != null){
//                      st.close();
//                  }
//              } catch (SQLException e) {
//                  e.printStackTrace();
//              }
//        }
//        return valid;
//}
//}
