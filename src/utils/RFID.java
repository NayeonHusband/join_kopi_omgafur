/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.SwingUtilities;
import raven.glasspanepopup.GlassPanePopup;
import com.formdev.flatlaf.FlatClientProperties;
import den.koneksi.koneksi;
import den.main.FormMenuUtama;
import den.model.ModelKaryawan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JScrollPane;

/**
 *
 * @author User
 */
public class RFID extends javax.swing.JPanel {

    private StringBuilder inputBuffer;
    private KeyAdapter keyAdapter;
    private List<ModelKaryawan> model = new ArrayList<ModelKaryawan>() ;
    private Iterator<ModelKaryawan> iterate;

    private void processInput(String input) {
        while(iterate.hasNext()){
            ModelKaryawan mk = iterate.next();
        if (input.length() == 10 && input.equals(mk.getIdKaryawan())) {
            FormMenuUtama.login(mk);
            GlassPanePopup.closePopupAll();
            System.out.println("RFID: " + input + "\n");
            
        } else {
            System.out.println("Keyboard:  " + mk.getIdKaryawan() + "\n");

        }
    }}

    public RFID() {
        try {
            ResultSet rs = koneksi.getConnection().createStatement().executeQuery("select  id_karyawan, nama_karyawan,role from karyawan");
            while(rs.next()){
                ModelKaryawan mk = new ModelKaryawan();
                mk.setIdKaryawan(rs.getString(1));
                mk.setNamaKaryawan(rs.getString(2));
                mk.setRole(rs.getString(3));
            
                model.add(mk);
            }
           iterate = model.iterator();
            
            System.out.println("Model : "+model);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        initComponents();
        setOpaque(false);
        txt.setForeground(Color.BLACK);
        area.setEditable(false);

//        area.setBackground(new Color(0, 0, 0, 0));
//        JScrollPane scrollPane = new JScrollPane(area);
//        scrollPane.getViewport().setOpaque(false);
//        scrollPane.setOpaque(false);
        inputBuffer = new StringBuilder();

        keyAdapter = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (c == KeyEvent.VK_ENTER) {
                    processInput(inputBuffer.toString());
                    inputBuffer.setLength(0);  // Clear the buffer
                } else {
                    inputBuffer.append(c);
                }
            }
        };
        SwingUtilities.invokeLater(() -> {

            area.requestFocus();
            area.addKeyListener(keyAdapter);
//        area.setVisible(false);

        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
        g2d.dispose();

        super.paintComponent(g);

    }

//       @Override
//    public void addNotify() {
//        super.addNotify();
//        if (area != null && keyAdapter != null) {
//            area.addKeyListener(keyAdapter);
//        }
//    }
    @Override
    public void removeNotify() {
        if (area != null && keyAdapter != null) {
            area.removeKeyListener(keyAdapter);
            GlassPanePopup.closePopupAll();
//                    System.out.println("Triggered");
            inputBuffer.setLength(0);

        }
        super.removeNotify();

    }
//    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));

        txt.setText("Tempelkan ID CARD");

        area.setColumns(20);
        area.setRows(5);
        jScrollPane1.setViewportView(area);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt)
                .addGap(147, 147, 147))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(txt)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(214, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel txt;
    // End of variables declaration//GEN-END:variables
}
