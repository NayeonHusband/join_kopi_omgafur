package den.form;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import den.DAO.PelangganDAO;
import den.DAO.PenjualanDAO;
import den.DAO.PenjualanDetailDAO;
import den.DAO.PenjualanSmtDAO;
import den.DAO.produkDAO;
import den.model.ModelKaryawan;
import den.model.ModelPelanggan;
import den.model.ModelPenjualan;
import den.model.ModelPenjualanDetail;
import den.model.ModelPenjualanSmt;
import den.model.ModelProduk;
import den.service.ServicePelanggan;
import den.service.ServicePenjualan;
import den.service.ServicePenjualanDetail;
import den.service.ServicePenjualanSmt;
import den.service.ServiceProduk;
import den.tablemodel.TableModelPenjualan;
import den.tablemodel.TableModelPenjualanSmt;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.TableColumnModel;
import static org.omg.CORBA.ORB.init;

public class FormPenjualan extends javax.swing.JPanel {

    private TableModelPenjualan tblModelPen = new TableModelPenjualan();
    private TableModelPenjualanSmt tblModelSmt = new TableModelPenjualanSmt();

    private ServicePenjualan servis = new PenjualanDAO();
    private ServicePenjualanDetail servisDet = new PenjualanDetailDAO();
    private ServicePenjualanSmt servisSmt = new PenjualanSmtDAO();
    private ServicePelanggan servisPel = new PelangganDAO();
    private ServiceProduk servisProd = new produkDAO();

    private Integer idProduk;
    private Integer idPelanggan;
    private Integer idKaryawan;

    private final Map<String, Integer> hasMap;
    private Timer timer;

    public FormPenjualan(ModelKaryawan modelKar) {
        initComponents();

        this.idKaryawan = modelKar.getIdKaryawan();
        tblData.setModel(tblModelPen);
        tblDataSementara.setModel(tblModelPen);
        txtNamaKasir.setText(modelKar.getNamaKaryawan());

        hasMap = new HashMap<>();
        loadData();
        // loadDataSementara();

        setLebarKolom();
        setLayoutform();
        init();
    }

    private void setLebarKolom() {
        TableColumnModel kolom = tblData.getColumnModel();
        kolom.getColumn(0).setPreferredWidth(50);
        kolom.getColumn(0).setMaxWidth(50);
        kolom.getColumn(0).setMinWidth(50);

        TableColumnModel kolom2 = tblDataSementara.getColumnModel();
        kolom2.getColumn(0).setPreferredWidth(50);
        kolom2.getColumn(0).setMaxWidth(50);
        kolom2.getColumn(0).setMinWidth(50);
    }

    private void setLayoutform() {
        viewPanel.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$model.background");
        addPanel.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$model.background");
        btnTambahSmt.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$model.background");
        btnDetail.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$model.background");
        btnSimpanSmt.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$model.background");
        btnBatal.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$model.background");
        btnPerbaruiSmt.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$model.background");
        btnHapusSmt.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$model.background");
        btnBatalSmt.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$model.background");

        txtpencarian.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pencarian");
        btnAddSementara.setIcon(new FlatSVGIcon("den/menuicon/add_white.svg", 1f));
        txtBarcode.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pencarian");
        txtNamaproduk.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pencarian");
        txtHarga.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pencarian");
        txtStok.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pencarian");
        txtJumlah.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pencarian");
        txtSubtotal.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pencarian");
        txtPersen.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pencarian");
        txtDiskon.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pencarian");
        txtTotal.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pencarian");
        txtBayar.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pencarian");
        txtKembali.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pencarian");
    }

    private void setTanggal() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar calender = Calendar.getInstance();
                Date now = new Date();
                SimpleDateFormat formatHari = new SimpleDateFormat("EEEE", new Locale("in", "ID"));
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String hari = formatHari.format(calender.getTime());
                String dateTime = dateFormat.format(now);
                lblHari.setText(hari + ",");
                lblTanggal.setText(dateTime);
            }
        });
        timer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        viewPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnDetail = new javax.swing.JButton();
        btnTambahSmt = new javax.swing.JButton();
        txtpencarian = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        addPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblHari = new javax.swing.JLabel();
        lblTanggal = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnBatal = new javax.swing.JButton();
        btnSimpanSmt = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtNamaKasir = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        txtNoTransaksi = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        cbxPelanggan = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtBarcode = new javax.swing.JTextField();
        txtNamaproduk = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        txtStok = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDataSementara = new javax.swing.JTable();
        btnPerbaruiSmt = new javax.swing.JButton();
        btnHapusSmt = new javax.swing.JButton();
        btnBatalSmt = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnProduk = new javax.swing.JButton();
        btnAddSementara = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        txtDiskon = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtBayar = new javax.swing.JTextField();
        txtKembali = new javax.swing.JTextField();
        txtPersen = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(36, 104, 155));
        jPanel2.setPreferredSize(new java.awt.Dimension(189, 91));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TRANSAKSI> PENJUALAN ");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DATA PENJUALAN");
        jLabel3.setFocusCycleRoot(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        btnDetail.setBackground(new java.awt.Color(36, 104, 155));
        btnDetail.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnDetail.setForeground(new java.awt.Color(255, 255, 255));
        btnDetail.setText("DETAIL");
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });

        btnTambahSmt.setBackground(new java.awt.Color(36, 104, 155));
        btnTambahSmt.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnTambahSmt.setForeground(new java.awt.Color(255, 255, 255));
        btnTambahSmt.setText("TAMBAH");
        btnTambahSmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahSmtActionPerformed(evt);
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
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblData);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setText("Search :");

        javax.swing.GroupLayout viewPanelLayout = new javax.swing.GroupLayout(viewPanel);
        viewPanel.setLayout(viewPanelLayout);
        viewPanelLayout.setHorizontalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1242, Short.MAX_VALUE)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(btnTambahSmt, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnDetail, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addGap(531, 531, 531)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtpencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTambahSmt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE))
        );

        mainPanel.add(viewPanel, "card2");

        addPanel.setPreferredSize(new java.awt.Dimension(1211, 624));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(36, 104, 155));
        jPanel6.setPreferredSize(new java.awt.Dimension(189, 91));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TRANSAKSI > PENJUALAN > TAHBAH ");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("TAMBAH DATA PENJUALAN");
        jLabel5.setFocusCycleRoot(true);

        lblHari.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblHari.setForeground(new java.awt.Color(255, 255, 255));
        lblHari.setText("Hari");

        lblTanggal.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblTanggal.setForeground(new java.awt.Color(255, 255, 255));
        lblTanggal.setText("Tanggal");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblHari)
                .addGap(18, 18, 18)
                .addComponent(lblTanggal)
                .addGap(23, 23, 23))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblHari)
                        .addComponent(lblTanggal)))
                .addGap(36, 36, 36))
        );

        btnBatal.setBackground(new java.awt.Color(36, 104, 155));
        btnBatal.setForeground(new java.awt.Color(255, 255, 255));
        btnBatal.setText("BATAL");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnSimpanSmt.setBackground(new java.awt.Color(36, 104, 155));
        btnSimpanSmt.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpanSmt.setText("SIMPAN");
        btnSimpanSmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanSmtActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "KASIR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        jPanel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtNamaKasir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNamaKasir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TRANSAKSI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        jPanel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtNoTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNoTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PELANGGAN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        jPanel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        cbxPelanggan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cbxPelanggan, 0, 158, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxPelanggan)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        jPanel8.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblTotal.setText("0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotal)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(lblTotal)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TRANSAKSI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        jPanel7.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        txtBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBarcodeKeyReleased(evt);
            }
        });

        tblDataSementara.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDataSementara.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataSementaraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDataSementara);

        btnPerbaruiSmt.setText("Perbarui");
        btnPerbaruiSmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerbaruiSmtActionPerformed(evt);
            }
        });

        btnHapusSmt.setText("Hapus");
        btnHapusSmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusSmtActionPerformed(evt);
            }
        });

        btnBatalSmt.setText("Batal");
        btnBatalSmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalSmtActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel16.setText("Barcode");

        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel17.setText("Nama Produk");

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel18.setText("Harga");

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel19.setText("Stok");

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel20.setText("Jumlah");

        btnProduk.setText("jButton3");
        btnProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdukActionPerformed(evt);
            }
        });

        btnAddSementara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSementaraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtBarcode, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNamaproduk, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(34, 34, 34)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(39, 39, 39)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(37, 37, 37)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnAddSementara, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel20))
                .addGap(68, 68, 68))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnPerbaruiSmt)
                .addGap(18, 18, 18)
                .addComponent(btnHapusSmt)
                .addGap(18, 18, 18)
                .addComponent(btnBatalSmt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddSementara, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNamaproduk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnProduk)
                        .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPerbaruiSmt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapusSmt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBatalSmt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel11.setText("SubTotal");

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel12.setText("Diskon");

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel13.setText("Total Harga");

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel14.setText("Bayar");

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel15.setText("Kembalian");

        txtBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBayarActionPerformed(evt);
            }
        });

        txtPersen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPersenActionPerformed(evt);
            }
        });

        jLabel21.setText("%");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1242, Short.MAX_VALUE)
            .addComponent(jSeparator2)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtPersen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel21)
                        .addGap(14, 14, 14)
                        .addComponent(txtDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnSimpanSmt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpanSmt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPersen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout addPanelLayout = new javax.swing.GroupLayout(addPanel);
        addPanel.setLayout(addPanelLayout);
        addPanelLayout.setHorizontalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1242, Short.MAX_VALUE)
            .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addPanelLayout.setVerticalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
            .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(addPanel, "card3");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents
     //Form Penjualan--------------------------------------------------------------
    private void btnTambahSmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahSmtActionPerformed
        tambahData();
    }//GEN-LAST:event_btnTambahSmtActionPerformed

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        detailPenjualan();
    }//GEN-LAST:event_btnDetailActionPerformed

    private void txtpencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpencarianActionPerformed

    }//GEN-LAST:event_txtpencarianActionPerformed

    private void txtpencarianKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpencarianKeyReleased
        pencarianData();
    }//GEN-LAST:event_txtpencarianKeyReleased

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDataMouseClicked
// Form penjualan-----------------------------------------------------------------

// Form Tambah Data Penjualan-----------------------------------------------------------------
    private void btnSimpanSmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanSmtActionPerformed
        simpanData();
    }//GEN-LAST:event_btnSimpanSmtActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        loadDataSementara();
        resetProduk();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void txtBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarcodeKeyReleased
        pencarianProduk();
    }//GEN-LAST:event_txtBarcodeKeyReleased

    private void btnProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdukActionPerformed
        pencarianProdukFormDialog();
    }//GEN-LAST:event_btnProdukActionPerformed

    private void btnAddSementaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSementaraActionPerformed
        tambahDataSementara();
    }//GEN-LAST:event_btnAddSementaraActionPerformed

    private void tblDataSementaraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataSementaraMouseClicked
        dataTableSementara();
    }//GEN-LAST:event_tblDataSementaraMouseClicked

    private void btnPerbaruiSmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerbaruiSmtActionPerformed
        perbaruiDatasementara();
    }//GEN-LAST:event_btnPerbaruiSmtActionPerformed

    private void btnHapusSmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusSmtActionPerformed
        hapusDatasementara();
    }//GEN-LAST:event_btnHapusSmtActionPerformed

    private void btnBatalSmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalSmtActionPerformed
        btnBatal();
    }//GEN-LAST:event_btnBatalSmtActionPerformed

    private void txtPersenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPersenActionPerformed
        hitungDiskon();
    }//GEN-LAST:event_txtPersenActionPerformed

    private void txtBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBayarActionPerformed
        Pembayaran();
    }//GEN-LAST:event_txtBayarActionPerformed
// Form Tambah Data Penjualan-----------------------------------------------------------------


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addPanel;
    private javax.swing.JButton btnAddSementara;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnBatalSmt;
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton btnHapusSmt;
    private javax.swing.JButton btnPerbaruiSmt;
    private javax.swing.JButton btnProduk;
    private javax.swing.JButton btnSimpanSmt;
    private javax.swing.JButton btnTambahSmt;
    private javax.swing.JComboBox<String> cbxPelanggan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblHari;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable tblData;
    private javax.swing.JTable tblDataSementara;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtDiskon;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKembali;
    private javax.swing.JTextField txtNamaKasir;
    private javax.swing.JTextField txtNamaproduk;
    private javax.swing.JTextField txtNoTransaksi;
    private javax.swing.JTextField txtPersen;
    private javax.swing.JTextField txtStok;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtpencarian;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables

    private void showPanel() {
        mainPanel.removeAll();
        mainPanel.add(viewPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    private void tambahData() {
        mainPanel.removeAll();
        mainPanel.add(addPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    private void loadData() {
        txtNoTransaksi.setText(servis.noTransaksi());
        getPelanggan();
        btnDetail.setEnabled(false);
        List<ModelPenjualan> list = servis.tampilData();
        tblModelPen.setData(list);
    }

    private void loadDataSementara() {
        getPelanggan();

        List<ModelPenjualan> list = servis.tampilData();
        tblModelPen.setData(list);

        txtDiskon.setText("0");
        nonAktif();
        txtBarcode.requestFocus();
        btnProduk.setEnabled(true);
        btnTambahSmt.setEnabled(true);
    }

    private void pencarianData() {
        List<ModelPenjualan> list = servis.pencarianData(txtpencarian.getText());
        tblModelPen.setData(list);
    }

    private void detailPenjualan() {
        int row = tblData.getSelectedRow();
        String id = tblData.getValueAt(row, 1).toString();
//        DataPenjualanDetail dataDetail = new DataPenjualandetail(null, null, id);
//        dataDetail.setVisible(true);
        loadData();

    }

    private void aktif() {
        txtBarcode.setEnabled(true);
        txtNamaproduk.setEnabled(true);
        txtHarga.setEnabled(true);
        txtStok.setEnabled(true);
        txtJumlah.setEnabled(true);

        btnProduk.setEnabled(true);
        btnAddSementara.setEnabled(true);
        btnPerbaruiSmt.setEnabled(true);
        btnHapusSmt.setEnabled(true);
    }

    private void nonAktif() {
        txtBarcode.setEditable(false);
        txtNamaproduk.setEditable(false);
        txtHarga.setEditable(false);
        txtStok.setEditable(false);
        txtJumlah.setEditable(false);

        btnProduk.setEnabled(false);
        btnAddSementara.setEnabled(false);
        btnPerbaruiSmt.setEnabled(false);
        btnHapusSmt.setEnabled(false);
        btnBatal.setEnabled(false);
    }

    private void resetProduk() {
        txtBarcode.setText("");
        txtNamaproduk.setText("");
        txtStok.setText("");
        txtHarga.setText("");
        txtTotal.setText("");
    }

    private void resetPembayaran() {
        txtSubtotal.setText("");
        txtPersen.setText("");
        txtDiskon.setText("");
        txtTotal.setText("");
        txtBayar.setText("");
        txtKembali.setText("");
        lblTotal.setText("0");
    }

    private void getPelanggan() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("PilihPelanggan");

        List<ModelPelanggan> list = servisPel.ambilPelanggan();
        for (ModelPelanggan modelPel : list) {
            model.addElement(modelPel.getNamapelanggan());
            hasMap.put(modelPel.getNamapelanggan(), modelPel.getIdpelanggan());
        }

        cbxPelanggan.setModel(model);
        cbxPelanggan.addActionListener(e -> {
            String namaPelanggan = cbxPelanggan.getSelectedItem().toString();
            if (!"Pilih pelanggan".equals(namaPelanggan)) {
                idPelanggan = hasMap.get(namaPelanggan);
            }
        });

    }

    private void pencarianProduk() {
        List<ModelProduk> list = servisProd.pencarianDataByBarcode(txtBarcode.getText());

        if (!list.isEmpty()) {
            ModelProduk produk = list.get(0);

            //sek apakah produk sudah ada salam data sementara
            boolean produkSudahAda = false;
            for (int i = 0; i < tblModelSmt.getRowCount(); i++) {
                if (tblModelSmt.getData(i).getModelProduk().getBarcode().equals(produk.getBarcode())) {
                    produkSudahAda = true;
                    break;
                }
            }
            if (!produkSudahAda) {
                //persiapkan data untuk di tambahkan ke dalam servis penjualan
                int idproduk = produk.getIdKategori();
                String barcode = produk.getBarcode();
                String namaProduk = produk.getNamaProduk();
                Long harga = produk.getHarga();
                int stok = produk.getStok();
                int jumlah = 1;
                double subTotal = harga * jumlah;

                ModelPenjualanSmt smt = new ModelPenjualanSmt();
                ModelProduk pd = new ModelProduk();
                ModelPenjualanDetail det = new ModelPenjualanDetail;

                pd.setIdproduk(idProduk);
                pd.setBarcode(barcode);
                pd.setNamaProduk(namaProduk);
                pd.setHarga(harga);
                pd.setStok(stok);

                det.setJumlah(jumlah);
                det.setSubTotal(subTotal);

                smt.setModelProduk(pd);
                smt.setModelPenDet(det);

                servisSmt.tambahData(smt);
                servisDet.sumTotal(det);

                txtSubtotal.setText(String.valueOf(det.getSubTotal()));
                String total = txtSubtotal.getText();
                txtTotal.setText(total);
                lblTotal.setText("Rp. " + total);

                loadDataSementara();
            } else {
                JOptionPane.showMessageDialog(null, "Produk sudah di Tambahkan");
                resetProduk();
            }
        }
    }

    private void pencarianProdukFormDialog() {


    }
}
