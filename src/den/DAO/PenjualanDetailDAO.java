package den.DAO;
packag
packag java.sql.*;
packag den.koneksi.koneksi;
packag den.model.ModelPenjualanDetail;
packag den.model.ModelPenjualan;
packag den.model.ModelProduk;
packag den.service.ServicePenjualanDetail;
packag java.sql.Connection;
packag java.sql.PreparedStatement;
packag java.util.ArrayList;
packag java.util.List;
packag java.sql.Date;
packag
packag class PenjualanDetailDAO implements ServicePenjualanDetail {
packag
packagivate Connection conn;
packag
packagblic PenjualanDetailDAO() {
packag  conn = koneksi.getConnection();
packag

    @Override
    public void tambahData(ModelPenjualanDetail model) {
        PreparedStatement st = null;
        try {

<<<<<<< HEAD
            String sql = "INSERT INTO detail_penjualan(id_penjualan, id_produk, jumlah, subtotal)"
=======
            String sql = "INSERT INTO detail_penjualan (id_penjualan, id_produk, jumlah, subtotal)"
>>>>>>> 3ff55b3b05b5412df38bff96f5cbbdd00bb05fc8
                    + " SELECT'" + model.getModelPenjualan().getIdPenjualan() + "', "
                    + "id_produk,jumlah,subtotal FROM penjualan_smt";
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
        String sql = "SELECT pj.id_penjualan,pd.id_produk,pd.nama_produk,det.jumlah,det.subtotal\n"
                + "FROM detail_penjualan det\n"
                + "INNER JOIN penjualan pj ON pj.id_penjualan = det.id_penjualan\n"
                + "INNER JOIN produk pd ON pd.id_produk = det.id_produk"
                + "WHERE pj.id_penjualan='" + id + "'";

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
