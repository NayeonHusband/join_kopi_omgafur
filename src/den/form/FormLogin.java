package den.form;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;
import den.DAO.KaryawanDAO;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import den.main.FormMenuUtama;
import den.menu.LightDarkMode;
import den.model.ModelKaryawan;
import den.service.ServiceKaryawan;
import javax.swing.JOptionPane;
import den.koneksi.koneksi;
import den.menu.Menu;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import raven.glasspanepopup.GlassPanePopup;
import utils.ForgotPassword;
import utils.RFID;
import utils.RFIDFP;

/**
 *
 * @author den asjdakjdlajsd kajdksajdlkjsaldajs
 */
public class FormLogin extends javax.swing.JPanel {

    private ServiceKaryawan servis = new KaryawanDAO();
    private JButton button;

    public FormLogin() {
                AbsButton();
        initComponents();
        setLayoutForm();
        
        
    }

    private void resetForm() {
        txtUser.setText("");
        txtPass.setText("");
    }

    private boolean validasiInput() {
        boolean valid = false;
        if (txtUser.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "username tidak boleh kosong");
        } else if (txtPass.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password tidk boleh koong");
        } else {
            valid = true;
        }
        return valid;
    }

    private void prosesLogin() {
        if (validasiInput() == true) {
            String user = txtUser.getText();
            String pass = txtPass.getText();

            ModelKaryawan model = new ModelKaryawan();
            model.setUsername(user);
            model.setPassword(pass);

            ModelKaryawan modelKar = servis.prosesLogin(model);
            if (modelKar != null) {
                FormMenuUtama.login(modelKar);

                resetForm();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Username dan Password salah", "Pesan",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        cmdLogin = new javax.swing.JButton();
        lbTitle = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        lbPass = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        FP = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        cmdLogin.setText("Login");
        cmdLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoginActionPerformed(evt);
            }
        });

        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Login Akun  ");

        lbUser.setText("Username");

        txtUser.setText("reo123");
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        lbPass.setText("Password");

        txtPass.setText("reo123");
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassKeyPressed(evt);
            }
        });

        FP.setText("forgot password?");
        FP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FPMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(loginLayout.createSequentialGroup()
                                .addComponent(lbPass)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtPass)))
                    .addGroup(loginLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lbUser))
                    .addGroup(loginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
            .addGroup(loginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdLogin)
                    .addComponent(FP, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle)
                .addGap(10, 10, 10)
                .addComponent(lbUser)
                .addGap(5, 5, 5)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lbPass)
                .addGap(5, 5, 5)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FP)
                .addGap(53, 53, 53)
                .addComponent(cmdLogin)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoginActionPerformed
        prosesLogin();
    }//GEN-LAST:event_cmdLoginActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed

    }//GEN-LAST:event_txtPassActionPerformed

    private void txtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            prosesLogin();
        }
    }//GEN-LAST:event_txtPassKeyPressed

    private void FPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FPMouseClicked
      GlassPanePopup.showPopup(new RFIDFP());
    }//GEN-LAST:event_FPMouseClicked

    private void AbsButton(){
       Dimension size = getSize();
       int width = size.width;
       int height  = size.width;
       
    button = new JButton("Rfid");
    button.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               GlassPanePopup.showPopup(new RFID());

           }
        
    });
    
        
        add(button);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Cast the Graphics object to Graphics2D
        Graphics2D g2d = (Graphics2D) g;

        Font font =null;
        
        try{
            File fontStyle = new File("src/utils/Kontora-ExtraBlack.otf");
             font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(40f);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        // Get the size of the panel
        Dimension size = getSize();
        int width = size.width;
        int height = size.height;

        // Set rendering hints for better graphics quality
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw a filled rectangle that fits the panel
        // Draw the white oval
        g2d.setColor(new Color(139, 69, 19));  // Coffee color
        g2d.fillOval(5 + width / 10, height / 2 - width / 10, width / 4, width / 4);

        // Draw a smaller white oval on top to represent the foam
        g2d.setColor(Color.WHITE);
        int foamWidth = width / 4 - 20;
        int foamHeight = width / 4 - 20;
        g2d.fillOval(5 + width / 10 + 10, height / 2 - width / 10 + 10, foamWidth, foamHeight);

        AffineTransform reset = g2d.getTransform();
// Set the font and color for the text
//        Font font = new Font("Serif", Font.PLAIN, 100);
        g2d.setFont(font);
        g2d.setColor(Color.BLACK);

        // Calculate the middle y-coordinate to align with the middle of the text
        FontMetrics metrics = g2d.getFontMetrics(font);
        int textHeight = metrics.getAscent() + metrics.getDescent();
        int yMiddle = height / 2 - textHeight / 2;

        // Draw the text at the calculated y-coordinate
        String text = "Joinin Kopi";
        int textX = 20 + width / 10;
        g2d.translate(-70,  height / 2 - width / 10 + 10+metrics.getAscent());
        g2d.drawString(text, 5 + width / 10, 0);

        g2d.setTransform(reset);

        g2d.setColor(Color.red);
        g2d.drawLine(width / 2, 0, width / 2, height);

        g2d.setColor(Color.red);
        g2d.drawLine(0, height / 2, width, height / 2);

//        // Draw a border around the rectangle
//        g2d.setColor(Color.BLACK);
//        g2d.drawRect(0, 0, width - 1, height - 1);
    }

    private void setLayoutForm() {
        setLayout(new LoginFormLayout());
        login.setLayout(new LoginLayout());
        lbTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        login.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Login.background;"
                + "arc:20;"
                + "border:30,40,50,30");

        txtPass.putClientProperty(FlatClientProperties.STYLE, ""
                + "showRevealButton:true;"
                + "showCapsLock:true");
        cmdLogin.putClientProperty(FlatClientProperties.STYLE, ""
                + "borderWidth:0;"
                + "focusWidth:0");
        txtUser.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Username");
        txtPass.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Password");
    }

    private class LoginFormLayout implements LayoutManager {

        @Override
        public void addLayoutComponent(String name, Component comp) {
        }

        @Override
        public void removeLayoutComponent(Component comp) {
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(0, 0);
            }
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(0, 0);
            }
        }

        @Override
        public void layoutContainer(Container parent) {
            synchronized (parent.getTreeLock()) {
                int width = parent.getWidth();
                int height = parent.getHeight();
                int loginWidth = UIScale.scale(400);
                int loginHeight = login.getPreferredSize().height;
                int x = (width - loginWidth) / 10 * 9;
                int y = (height - loginHeight) / 10 * 5;
                login.setBounds(x, y, loginWidth, loginHeight);
               button.setBounds(5 + width / 10, height / 2 + width / 10, (int) (width / 4*.5), (int) (width/4*.1));
               
            }
        }
    }

    private class LoginLayout implements LayoutManager {

        private final int titleGap = 50;
        private final int textGap = 10;
        private final int labelGap = 5;
        private final int buttonGap = 50;

        @Override
        public void addLayoutComponent(String name, Component comp) {
        }

        @Override
        public void removeLayoutComponent(Component comp) {
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                Insets insets = parent.getInsets();
                int height = insets.top + insets.bottom;

                height += lbTitle.getPreferredSize().height;
                height += UIScale.scale(titleGap);
                height += lbUser.getPreferredSize().height;
                height += UIScale.scale(labelGap);
                height += txtUser.getPreferredSize().height;
                height += UIScale.scale(textGap);

                height += lbPass.getPreferredSize().height;
                height += UIScale.scale(labelGap);
                height += txtPass.getPreferredSize().height;
                height += UIScale.scale(buttonGap);
                height += cmdLogin.getPreferredSize().height;
                 height += UIScale.scale(buttonGap);
                height += FP.getPreferredSize().height;
                return new Dimension(0, height);
            }
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(0, 0);
            }
        }

        @Override
        public void layoutContainer(Container parent) {
            synchronized (parent.getTreeLock()) {
                Insets insets = parent.getInsets();
                int x = insets.left;
                int y = insets.top;
                int width = parent.getWidth() - (insets.left + insets.right);

                lbTitle.setBounds(x, y, width, lbTitle.getPreferredSize().height);
                y += lbTitle.getPreferredSize().height + UIScale.scale(titleGap);

                lbUser.setBounds(x, y, width, lbUser.getPreferredSize().height);
                y += lbUser.getPreferredSize().height + UIScale.scale(labelGap);
                txtUser.setBounds(x, y, width, txtUser.getPreferredSize().height);
                y += txtUser.getPreferredSize().height + UIScale.scale(textGap);

                lbPass.setBounds(x, y, width, lbPass.getPreferredSize().height);
                y += lbPass.getPreferredSize().height + UIScale.scale(labelGap);
                txtPass.setBounds(x, y, width, txtPass.getPreferredSize().height);
                y += txtPass.getPreferredSize().height + UIScale.scale(buttonGap);

                cmdLogin.setBounds(x, y, width, cmdLogin.getPreferredSize().height);
                 y += cmdLogin.getPreferredSize().height + UIScale.scale(buttonGap);
                FP.setBounds(x, y, width, FP.getPreferredSize().height);

            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FP;
    private javax.swing.JButton cmdLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbPass;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbUser;
    private javax.swing.JPanel login;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
