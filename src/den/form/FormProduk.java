package den.form;

import com.barcodelib.barcode.Linear;

import com.formdev.flatlaf.FlatClientProperties;
import den.DAO.produkDAO;
import den.model.ModelProduk;
import den.service.ServiceProduk;
import den.tablemodel.TableModelProduk;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JOptionPane;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.exception.QRGenerationException;
import net.glxn.qrgen.image.ImageType;


public class FormProduk extends javax.swing.JPanel {

    private final TableModelProduk tblModel = new TableModelProduk();
    private final ServiceProduk servis = new produkDAO();

    public FormProduk() {
        initComponents();
        tblData.setModel(tblModel);
        loadData();
        setlayout();
    }
    private void setlayout() {
        txtpencarian.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pencarian");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnhapus = new javax.swing.JButton();
        btnperbarui = new javax.swing.JButton();
        btntambah = new javax.swing.JButton();
        txtpencarian = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        test_generate = new javax.swing.JButton();
        generate_qr = new javax.swing.JButton();

        jPanel1.setPreferredSize(new java.awt.Dimension(1002, 759));

        jPanel2.setBackground(new java.awt.Color(36, 104, 155));
        jPanel2.setPreferredSize(new java.awt.Dimension(189, 91));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MASTER > PRODUK ");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DATA PRODUK");
        jLabel3.setFocusCycleRoot(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        btnhapus.setBackground(new java.awt.Color(36, 104, 155));
        btnhapus.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnhapus.setForeground(new java.awt.Color(255, 255, 255));
        btnhapus.setText("HAPUS");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btnperbarui.setBackground(new java.awt.Color(36, 104, 155));
        btnperbarui.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnperbarui.setForeground(new java.awt.Color(255, 255, 255));
        btnperbarui.setText("PERBARUI");
        btnperbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnperbaruiActionPerformed(evt);
            }
        });

        btntambah.setBackground(new java.awt.Color(36, 104, 155));
        btntambah.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btntambah.setForeground(new java.awt.Color(255, 255, 255));
        btntambah.setText("TAMBAH");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        txtpencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpencarianActionPerformed(evt);
            }
        });
        txtpencarian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpencarianKeyReleased(evt);
            }
        });

        tblData.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblData);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setText("Search :");

        test_generate.setBackground(new java.awt.Color(36, 104, 155));
        test_generate.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        test_generate.setForeground(new java.awt.Color(255, 255, 255));
        test_generate.setText("Test Generate");
        test_generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                test_generateActionPerformed(evt);
            }
        });

        generate_qr.setBackground(new java.awt.Color(36, 104, 155));
        generate_qr.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        generate_qr.setForeground(new java.awt.Color(255, 255, 255));
        generate_qr.setText("Generate qr");
        generate_qr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generate_qrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1043, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(test_generate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btntambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnperbarui, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnhapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(generate_qr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(198, 198, 198)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtpencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnperbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btntambah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(test_generate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(generate_qr, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        tambahData();
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnperbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnperbaruiActionPerformed
        perbaruiData();
    }//GEN-LAST:event_btnperbaruiActionPerformed

    private void txtpencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpencarianActionPerformed

    }//GEN-LAST:event_txtpencarianActionPerformed

    private void txtpencarianKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpencarianKeyReleased
        pencarianData();
    }//GEN-LAST:event_txtpencarianKeyReleased

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        hapusData();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void test_generateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_test_generateActionPerformed
        try{
            Linear barcode = new Linear();
        barcode.setType(Linear.CODE128);
        
        int row = tblData.getSelectedRow();
        if (row != -1) {
            ModelProduk produk = tblModel.getData(row);
            barcode.setData(produk.getBarcode());
            barcode.setI(11.0f);
            
            
            barcode.renderBarcode(System.getProperty("user.dir")+"/src/utils/"+produk.getIdproduk()+".png");
            
            JOptionPane.showMessageDialog(null, "Kode telahd igenerate");
         } else {
            JOptionPane.showMessageDialog(null, "Pilih Data Yang Ingin Diperbarui");
        }}
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_test_generateActionPerformed

    private void generate_qrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generate_qrActionPerformed
       try{
        
        int row = tblData.getSelectedRow();
        if (row != -1) {
            ModelProduk produk = tblModel.getData(row);
            ByteArrayOutputStream bOut = QRCode.from(produk.getBarcode()).to(ImageType.PNG).stream();
            
            String FileName = String.valueOf(produk.getIdproduk());
            
            FileOutputStream fOut = new FileOutputStream(new File(System.getProperty("user.dir")+"/src/utils/"+FileName+".png"));
            fOut.write(bOut.toByteArray());
            fOut.flush();
            
            JOptionPane.showMessageDialog(null, System.getProperty("user.dir")+"/src/utils/"+FileName+".png");
         } else {
            JOptionPane.showMessageDialog(null, "Pilih Data Yang Ingin Diperbarui");
        }}
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_generate_qrActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnperbarui;
    private javax.swing.JButton btntambah;
    private javax.swing.JButton generate_qr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblData;
    private javax.swing.JButton test_generate;
    private javax.swing.JTextField txtpencarian;
    // End of variables declaration//GEN-END:variables

    private void loadData() {
        List<ModelProduk> list = servis.tampilData();
        tblModel.setData(list);
    }

    private void pencarianData() {
        List<ModelProduk> list = servis.pencarianData(txtpencarian.getText());
        tblModel.setData(list);
    }

    private void tambahData() {
        Forminputproduk frominput = new Forminputproduk(null, true, 1, null, this);
        frominput.setVisible(true);
        loadData();
    }

    private void perbaruiData() {
        int row = tblData.getSelectedRow();
        if (row != -1) {
            ModelProduk produk = tblModel.getData(row);
            Forminputproduk formInput = new Forminputproduk(null, true, row, produk, this);
            formInput.setVisible(true);
            loadData();
        } else {
            JOptionPane.showMessageDialog(null, "Pilih Data Yang Ingin Diperbarui");
        }
    }

    private void hapusData() {
        int row = tblData.getSelectedRow();
        if (row != -1) {
            ModelProduk produk = tblModel.getData(row);
            if (JOptionPane.showConfirmDialog(null, "Yakin Ingin menghapus Data Ini ?",
                    "Konfirmasi", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                servis.hapusData(produk);
                tblModel.deleteData(row);
                loadData();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih dahulu data Yang Akan Di Hapus");
        }
    }

    public void refreshProduk() {
        loadData();
    }
}
