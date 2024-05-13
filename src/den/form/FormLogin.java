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
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author den asjdakjdlajsd kajdksajdlkjsaldajs
 */
public class FormLogin extends javax.swing.JPanel {

    private ServiceKaryawan servis = new KaryawanDAO();

    public FormLogin() {
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
        auto = new javax.swing.JButton();

        cmdLogin.setText("Login");
        cmdLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoginActionPerformed(evt);
            }
        });

        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Login Akun  ");

        lbUser.setText("Username");

        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        lbPass.setText("Password");

        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassKeyPressed(evt);
            }
        });

        auto.setText("auto");
        auto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginLayout.createSequentialGroup()
                        .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(loginLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(lbUser))
                            .addGroup(loginLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 42, Short.MAX_VALUE))
                    .addGroup(loginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(loginLayout.createSequentialGroup()
                                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbPass)
                                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(loginLayout.createSequentialGroup()
                                .addComponent(cmdLogin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(loginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(auto, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(11, 11, 11)
                .addComponent(auto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdLogin)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoginActionPerformed
        prosesLogin();
    }//GEN-LAST:event_cmdLoginActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void txtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            prosesLogin();
        }
    }//GEN-LAST:event_txtPassKeyPressed

    private void autoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoActionPerformed
        txtUser.setText("reo123");
        txtPass.setText("reo123");
        prosesLogin();
    }//GEN-LAST:event_autoActionPerformed

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
        auto.putClientProperty(FlatClientProperties.STYLE, ""
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
                int loginWidth = UIScale.scale(320);
                int loginHeight = login.getPreferredSize().height;
                int x = (width - loginWidth) / 2;
                int y = (height - loginHeight) / 2;
                login.setBounds(x, y, loginWidth, loginHeight);
            }
        }
    }

    private class LoginLayout implements LayoutManager {

        private final int titleGap = 10;
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
                auto.setBounds(x, y, width, auto.getPreferredSize().height);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton auto;
    private javax.swing.JButton cmdLogin;
    private javax.swing.JLabel lbPass;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbUser;
    private javax.swing.JPanel login;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
