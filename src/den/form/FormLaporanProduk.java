/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package den.form;

import com.mysql.cj.result.Row;
import den.koneksi.koneksi;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
//import javafx.scene.control.Cell;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Taufiqur Rahman
 */
public class FormLaporanProduk extends javax.swing.JPanel {

    String nmr;
    private Connection con;
    private Statement st;
    private String sql = "";
    private ResultSet rs;
    /**
     * Creates new form FormLaporanProduk
     */
    public FormLaporanProduk() {
                con = koneksi.getConnection();

        initComponents();
        tampildata();
    }
    
    private void tampildata(){
        
        
        DefaultTableModel data = new DefaultTableModel();
        data.addColumn("No");
        data.addColumn("Tanggal");
        data.addColumn("ID Pelanggan");
        data.addColumn("id_produk");
        data.addColumn("Nama Produk");
        data.addColumn("Jumlah");
        
        try{
            int i = 1;
            String sql;
            if (nmr != null){
                sql = "SELECT * FROM laporan_penjualan WHERE tanggal LIKE ?" ;
            } else {
                sql = "SELECT * FROM laporan_penjualan";
            }
            
            try{
                PreparedStatement pstmt = con.prepareStatement(sql);
                if (nmr != null){
                    pstmt.setString(1, "%" + nmr + "%");
                }
                
                try (ResultSet rs = pstmt.executeQuery()){
                    while (rs.next()) {
                        data.addRow(new Object[]{
                        i++,
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                    });
                    }
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            Table1.setModel(data);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, " ERROR \n Gagal Memuat ke Database \n Aktifkan Database Sebelum Memulai");
                e.printStackTrace();
            }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btncetak = new javax.swing.JButton();
        jdate = new com.toedter.calendar.JDateChooser();
        jdate1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(Table1);

        jPanel2.setBackground(new java.awt.Color(36, 104, 155));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MASTER > LAPORAN PRODUK");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("LAPORAN PRODUK");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addGap(0, 39, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setText("Tanggal");

        btncetak.setBackground(new java.awt.Color(36, 104, 155));
        btncetak.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btncetak.setForeground(new java.awt.Color(255, 255, 255));
        btncetak.setText("CETAK");
        btncetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncetakActionPerformed(evt);
            }
        });

        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jdate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jButton1)
                        .addGap(409, 409, 409)
                        .addComponent(btncetak, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(btncetak)
                        .addComponent(jButton1))
                    .addComponent(jdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btncetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncetakActionPerformed
        // TODO add your handling code here:
        String excelFilePath = "/Users/Taufiqur Rahman/Documents/NetBeansProjects/join_kopi_omgafur6/src/laporan/laporan-produk.xlsx";
        String tampilan1 = "yyyy-MM-dd";
        SimpleDateFormat tgl1 = new SimpleDateFormat(tampilan1);
        String tanggalawal = String.valueOf(tgl1.format(jdate.getDate()));

        String tampilan2 = "yyyy-MM-dd";
        SimpleDateFormat tgl2 = new SimpleDateFormat(tampilan2); // Fix: Use tampilan2 for tgl2
        String tanggalakhir = String.valueOf(tgl2.format(jdate1.getDate()));
        System.out.println(tanggalawal + tanggalakhir);


try {
    String url = "jdbc:mysql://localhost:3306/joininkopi1?serverTimezone=UTC";
    String user = "root";
    String pass = "";
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(url, user, pass);
    Statement st = con.createStatement();
    
    String sql = "SELECT * FROM laporan_penjualan WHERE tanggal BETWEEN'"+tanggalawal+"'AND '"+tanggalakhir+"'";
    ResultSet rs = st.executeQuery(sql);
    
    try (XSSFWorkbook workbook = new XSSFWorkbook()) {
        XSSFSheet sheet = workbook.createSheet("laporan");
        
        writeHeaderLine(sheet);
        
        writeDataLines(rs, workbook, sheet);
        
        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
        }
        
        st.close();
        con.close();
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Koneksi gagal");
    e.printStackTrace();
}
    }//GEN-LAST:event_btncetakActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                                 
        String tampilan1 = "yyyy-MM-dd";
        SimpleDateFormat tgl1 = new SimpleDateFormat(tampilan1);
        String tanggalawal = String.valueOf(tgl1.format(jdate1.getDate()));

        String tampilan2 = "yyyy-MM-dd";
        SimpleDateFormat tgl2 = new SimpleDateFormat(tampilan2); // Fix: Use tampilan2 for tgl2
        String tanggalakhir = String.valueOf(tgl2.format(jdate1.getDate()));
        System.out.println(tanggalawal + tanggalakhir);
        try {
            int No = 1;
            String sql = "SELECT * FROM laporan_penjualan WHERE  tanggal BETWEEN '" + tanggalawal + "' AND '" + tanggalakhir +"';";
            java.sql.Connection conn = (Connection)den.koneksi.koneksi.getConnection();
            // Create a Statement
            java.sql.Statement stm = conn.createStatement();

            java.sql.ResultSet res = stm.executeQuery(sql);// Fix: Add WHERE clause
            DefaultTableModel table = (DefaultTableModel) Table1.getModel();
            table.setRowCount(0);
            while (res.next()) {
                table.addRow(new Object[]{res.getString(1), res.getString(2), res.getDate(3), res.getString(4), res.getString(5), res.getString(6),
                    res.getString(7), res.getString(8), res.getString(9), res.getString(10)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error abangku"+e.getMessage());
        }    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table1;
    private javax.swing.JButton btncetak;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdate;
    private com.toedter.calendar.JDateChooser jdate1;
    // End of variables declaration//GEN-END:variables

    public void writeHeaderLine(XSSFSheet sheet) {
        XSSFRow headerRow = sheet.createRow(0);
        
        // Tanggal
        XSSFCell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("tanggal");
        
        // ID Pelanggan
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("id_pelanggan");
        
        // ID Produk
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("id_produk");
        
        // Nama Produk
        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("nama_produk");
        
        // Jumlah
        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("jumlah");
    }

    public void writeDataLines(ResultSet rs, XSSFWorkbook workbook, XSSFSheet sheet) throws SQLException {
        int rowCount = 1;
        
        while(rs.next()) {
            String tanggal = rs.getString("tanggal");
            String idpelanggan = rs.getString("id_pelanggan");
            String idproduk = rs.getString("id_produk");
            String namaproduk = rs.getString("nama_produk");
            String jumlah = rs.getString("jumlah");
            
            XSSFRow row = sheet.createRow(rowCount++);
            
            int columnCount = 0;
            
            XSSFCell cell = row.createCell(columnCount++);
            cell.setCellValue(tanggal);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(idpelanggan);
            
            cell = row.createCell(columnCount++);
            
            cell.setCellValue(idproduk);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(namaproduk);
            
            cell = row.createCell(columnCount);
            cell.setCellValue(jumlah);
            
            
        }
    }
}