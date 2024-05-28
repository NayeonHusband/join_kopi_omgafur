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

/**
 *
 * @author User
 */
public class RFID extends javax.swing.JPanel {

    /**
     * Creates new form RFID
     */
    private StringBuilder inputBuffer;
    private KeyAdapter keyAdapter;

    private void processInput(String input) {
        if (input.length() == 10) {
//            textArea.append("RFID Input Detected: " + input + "\n");
            System.out.println("RFID: " + input + "\n");
        } else {
//            textArea.append("Keyboard Input Detected: " + input + "\n");
            System.out.println("Keyboard:  " + input + "\n");

        }
    }

    public RFID() {
        initComponents();
        setOpaque(false);
        txt.setForeground(Color.BLACK);
        area.setEditable(false);
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
                    System.out.println("Triggered");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(txt))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(txt)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel txt;
    // End of variables declaration//GEN-END:variables
}
