
package den.form;
import com.formdev.flatlaf.FlatClientProperties;
//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.dateTime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;


public class formabsensikeluar extends javax.swing.JPanel {
    Statement st;
    ResultSet rs;
     Connection cn = den.koneksi.koneksi.getConnection();
     static boolean isAbsenKeluar = false;
     String id;
    public formabsensikeluar() {
        initComponents();
        txtTanggalKeluar();
        setlayout();
    }
    
    private void setlayout() {
        txtrfid.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Tempelkan RFID");
        txtuser.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "username");
        txttanggal.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "tanggal");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnkirim = new javax.swing.JButton();
        txtrfid = new javax.swing.JTextField();
        txtuser = new javax.swing.JTextField();
        cmpilih = new javax.swing.JComboBox<>();
        txttanggal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(36, 104, 155));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(36, 104, 155));
        jLabel3.setText("ABSENSI KELUAR KARYAWAN");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText("RFID");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setText("Username");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setText("Keterangan");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setText("Tanggal");

        btnkirim.setBackground(new java.awt.Color(36, 104, 155));
        btnkirim.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnkirim.setText("Kirim");
        btnkirim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnkirimMouseClicked(evt);
            }
        });
        btnkirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkirimActionPerformed(evt);
            }
        });

        txtrfid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrfidActionPerformed(evt);
            }
        });
        txtrfid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtrfidKeyReleased(evt);
            }
        });

        txtuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuserActionPerformed(evt);
            }
        });

        cmpilih.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masuk", "izin", "sakit" }));
        cmpilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmpilihActionPerformed(evt);
            }
        });

        txttanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttanggalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtrfid, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(86, 86, 86)
                        .addComponent(cmpilih, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(174, 174, 174))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(490, 490, 490)
                .addComponent(btnkirim, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(112, 112, 112)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(txtrfid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmpilih, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addComponent(btnkirim, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MASTER > ABSENSI KELUAR");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ABSENSI KARYAWAN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtrfidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrfidActionPerformed
         try {
            String sql = "INSERT INTO absensi VALUES(NULL,'"+id+cmpilih.getSelectedItem()+"','"+txttanggal. getText()+"')";
            java.sql.PreparedStatement pst = cn.prepareStatement(sql);
            pst.execute();
             JOptionPane.showMessageDialog(null, "Absensi berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Absensi gagal");
        }
    }//GEN-LAST:event_txtrfidActionPerformed

    private void btnkirimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnkirimMouseClicked
   
    }//GEN-LAST:event_btnkirimMouseClicked

    private void txtrfidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrfidKeyReleased
    String rfid = txtrfid.getText();
        try {
            String sql = "select * from karyawan WHERE id_karyawan = ?";
            java.sql.Connection conn = (Connection) den.koneksi.koneksi.getConnection();
            java.sql.PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, rfid);
            java.sql.ResultSet res = stm.executeQuery();
            if (res.next()){
                txtrfid.setText(res.getString("id_karyawan"));
                txtuser.setText(res.getString("username"));
               
                absen();
              
                
            }
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }}
        private void txtTanggalKeluar(){
            LocalDateTime datetime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm", new Locale("id","ID"));
            String formattedDateTime = datetime.format(formatter);
            txttanggal.setText(formattedDateTime);
        }
        private void absen(){
           String Iduser = txtrfid.getText();
            try {
                String sqlCheck = "SELECT COUNT(*) FROM absensi WHERE id_karyawan = ? AND DATE(tgl_absenkeluar) = CURDATE()";
            PreparedStatement statementCheck = cn.prepareStatement(sqlCheck);
            statementCheck.setString(1, Iduser);
            ResultSet rsCheck = statementCheck.executeQuery();
            rsCheck.next();
            int count = rsCheck.getInt(1);
            
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "Anda sudah melakukan absensi keluar hari ini");
                }else{
                    String keterangan = (String) cmpilih.getSelectedItem();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = new Date();
                    String tanggalMasuk =  dateFormat.format(date);
                    
                    String sql ="SELECT INTO absensi (id_karyawan,keterangan,tgl_absenkeluar) VALUES (?, ?, ?)";
                    
                    PreparedStatement statement = cn.prepareStatement(sql);
                    statement.setString(1, Iduser);
                    statement.setString(2, keterangan);
                    statement.setString(3, tanggalMasuk);
                    
                    statement.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Absensi keluar berhasil pada tanggal");
                    isAbsenKeluar = true;
                    
                    statement.close();
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        
    }//GEN-LAST:event_txtrfidKeyReleased

    private void txtuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtuserActionPerformed

    private void cmpilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmpilihActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpilihActionPerformed

    private void txttanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttanggalActionPerformed

    private void btnkirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkirimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnkirimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnkirim;
    private javax.swing.JComboBox<String> cmpilih;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtrfid;
    private javax.swing.JTextField txttanggal;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
