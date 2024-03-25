package den.join.dao;

import den.join.koneksi.koneksi;
import den.join.model.ModelSupplier;
import den.join.serviice.ServiceSupplier;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class SupplierDAO implements ServiceSupplier{

    private Connection conn;
    
    public SupplierDAO() {
        conn = koneksi.getConnection();
    }
    
    @Override
    public void tambahData(ModelSupplier model) {
        PreparedStatement st = null;
        try {
            String sql = "INSERT INTO supplier(nama_supplier, alamat, notelp) VALUES (?,?,?)";
            
            st = conn.prepareStatement(sql);
            st.setString(1, model.getNamaSupplier());
            st.setString(2, model.getAlamatSupplier());
            st.setString(3, model.getNotelpSupplier());
     
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void perbaruiData(ModelSupplier model) {
        PreparedStatement st = null;
        try {
            String sql = "UPDATE supplier Set nama_supplier=?, alamat=?, notelp=? WHERE id_supplier=?";
            
            st = conn.prepareStatement(sql);
            st.setString(1, model.getNamaSupplier());
            st.setString(2, model.getAlamatSupplier());
            st.setString(3, model.getNotelpSupplier());
            st.setInt   (4, model.getIdSupplier());
            
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }

    @Override
    public void hapusData(ModelSupplier model) {
       PreparedStatement st = null;
       String sql = "DELETE FROM supplier WHERE id_supplier=?";
       try {
           st = conn.prepareStatement(sql);
           st.setInt(1, model.getIdSupplier());
           st.executeUpdate();
       } catch (SQLException e) {
           e.printStackTrace();
       }
    }

    @Override
    public List<ModelSupplier> tampilData() {
      PreparedStatement st = null;
      ResultSet rs = null;
      List list = new ArrayList();
      String sql="SELECT * FROM supplier";
      
      try {
          st = conn.prepareStatement(sql);
          rs = st.executeQuery();
          while(rs.next());
              ModelSupplier model = new ModelSupplier();
              model.setIdSupplier     (rs.getInt("id_supplier"));
              model.setNamaSupplier   (rs.getString("nama_supplier"));
              model.setAlamatSupplier (rs.getString("alamat"));
              model.setNotelpSupplier (rs.getString("notelp")); 
          
          list.add(model);
      
    } catch (SQLException e) {
        e.printStackTrace();
      }
    return list ;
    }

    @Override
    public List<ModelSupplier> pencarianData(String id) {
        
    }

    @Override
    public boolean validasiNamaSupplier(ModelSupplier model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
