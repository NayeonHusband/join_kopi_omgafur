package den.form;

import com.formdev.flatlaf.FlatClientProperties;
import den.DAO.KategoriDAO;
import den.model.ModelKategori;
import den.service.ServiceKategori;
import den.tablemodel.TableModelKategori;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;

public class FormKategori extends javax.swing.JPanel {

    private final TableModelKategori tblModel = new TableModelKategori();
    private final ServiceKategori servis = new KategoriDAO();

    public FormKategori() {
        initComponents();
        tblData.setModel(tblModel);
        loadData();
        setLebarKolom();
    }
    private void setLebarKolom() {
        TableColumnModel kolom =tblData.getColumnModel();
        kolom.getColumn(0).setPreferredWidth(150);
        kolom.getColumn(0).setMaxWidth(50);
        kolom.getColumn(0).setMinWidth(50);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnhapus = new javax.swing.JButton();
        btnperbarui = new javax.swing.JButton();
        btntambah = new javax.swing.JButton();
        txtpencarian = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setText("MASTER > KATEGORI ");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DATA KATEGORI");
        jLabel3.setFocusCycleRoot(true);

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

        tblData.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
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

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Search :");
        jLabel4.setFocusCycleRoot(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(btntambah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnperbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(423, 423, 423)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtpencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addContainerGap(464, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnperbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btntambah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2))))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1112, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnperbarui;
    private javax.swing.JButton btntambah;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtpencarian;
    // End of variables declaration//GEN-END:variables

    private void loadData() {
        List<ModelKategori> list = servis.tampilData();
        tblModel.setData(list);
    }

    private void pencarianData() {
        List<ModelKategori> list = servis.pencarianData(txtpencarian.getText());
        tblModel.setData(list);
    }

    private void tambahData() {
        Frominputkategori frominput = new Frominputkategori(null, true, 1, null, this);
        frominput.setVisible(true);
        loadData();
    }

    private void perbaruiData() {
        int row = tblData.getSelectedRow();
        if (row != -1) {
            ModelKategori model = tblModel.getData(row);
            Frominputkategori formInput = new Frominputkategori(null, true, row, model, this);
            formInput.setVisible(true);
            loadData();
        } else {
            JOptionPane.showMessageDialog(null, "Pilih Data Yang Ingin Diperbarui");
        }
    }

    private void hapusData() {
        int row = tblData.getSelectedRow();
        if (row != -1) {
            ModelKategori model = tblModel.getData(row);
            if (JOptionPane.showConfirmDialog(null, "Yakin Ingin menghapus Data Ini ?",
                    "Konfirmasi", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                servis.hapusData(model);
                tblModel.deleteData(row);
                loadData();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih dahulu data Yang Akan Di Hapus");
        }
    }

    public void refreshTable() {
        loadData();
    }
}
