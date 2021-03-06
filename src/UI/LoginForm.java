package UI;

import bridge.Helper;
import internal.User;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

/**
 *
 * @author Sarthak
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public LoginForm() {
        initComponents();
        initUI();
        startupCode();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        scrollPane = new javax.swing.JPanel();
        signInPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        userTF = new javax.swing.JTextField();
        passPF = new javax.swing.JPasswordField();
        signInButton = new javax.swing.JButton();
        signUpLinkLabel = new javax.swing.JLabel();
        invalidCredErrorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EzyBook");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(216, 216, 216)));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Lato", 0, 48)); // NOI18N
        jLabel1.setText("EzyBook");
        jPanel1.add(jLabel1, new java.awt.GridBagConstraints());

        scrollPane.setBackground(new java.awt.Color(59, 35, 59));
        scrollPane.setLayout(new java.awt.GridBagLayout());

        signInPanel.setBackground(new java.awt.Color(204, 204, 204));
        signInPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(216, 216, 216)));

        jLabel2.setFont(new java.awt.Font("Lato Black", 0, 48)); // NOI18N
        jLabel2.setText("Sign In");

        jLabel3.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabel3.setText("Username");

        jLabel4.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabel4.setText("Password");

        userTF.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        userTF.setNextFocusableComponent(passPF);
        userTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userTFKeyPressed(evt);
            }
        });

        passPF.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        passPF.setNextFocusableComponent(signInButton);
        passPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passPFKeyPressed(evt);
            }
        });

        signInButton.setBackground(new java.awt.Color(255, 255, 255));
        signInButton.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        signInButton.setText("Sign In");
        signInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInButtonActionPerformed(evt);
            }
        });

        signUpLinkLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        signUpLinkLabel.setForeground(new java.awt.Color(51, 153, 255));
        signUpLinkLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signUpLinkLabel.setText("Don't have an account? Sign Up!");
        signUpLinkLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signUpLinkLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signUpLinkLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signUpLinkLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signUpLinkLabelMouseExited(evt);
            }
        });

        invalidCredErrorLabel.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        invalidCredErrorLabel.setForeground(new java.awt.Color(255, 61, 61));
        invalidCredErrorLabel.setText("Invalid Username or Password");

        javax.swing.GroupLayout signInPanelLayout = new javax.swing.GroupLayout(signInPanel);
        signInPanel.setLayout(signInPanelLayout);
        signInPanelLayout.setHorizontalGroup(
            signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signInPanelLayout.createSequentialGroup()
                .addGap(0, 61, Short.MAX_VALUE)
                .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(46, 46, 46)
                .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userTF, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(passPF))
                .addGap(64, 64, 64))
            .addGroup(signInPanelLayout.createSequentialGroup()
                .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(signInPanelLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(signUpLinkLabel))
                    .addGroup(signInPanelLayout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(signInButton))
                    .addGroup(signInPanelLayout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel2))
                    .addGroup(signInPanelLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(invalidCredErrorLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        signInPanelLayout.setVerticalGroup(
            signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signInPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(invalidCredErrorLabel)
                .addGap(42, 42, 42)
                .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(userTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(signInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(46, 46, 46)
                .addComponent(signInButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(signUpLinkLabel)
                .addGap(31, 31, 31))
        );

        scrollPane.add(signInPanel, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signUpLinkLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpLinkLabelMouseEntered
     
        UIMethods.underline(signUpLinkLabel);
    }//GEN-LAST:event_signUpLinkLabelMouseEntered

    private void signUpLinkLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpLinkLabelMouseExited
       
        UIMethods.removeUnderline(signUpLinkLabel);
    }//GEN-LAST:event_signUpLinkLabelMouseExited

    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInButtonActionPerformed
       
        
        String u = userTF.getText().trim();
        String p = new String(passPF.getPassword());
        passPF.setText("");
     
        User usr = Helper.verifyAndReturnUserInfo(u, p);
        
        if (usr != null) {
            invalidCredErrorLabel.setVisible(false);
            openPortal(usr);
        } else {
            invalidCredErrorLabel.setVisible(true);
        }
 
    }//GEN-LAST:event_signInButtonActionPerformed
    private void openPortal(User u){
        MainForm po = new MainForm(u,this);
        po.setLocationRelativeTo(null);
        po.setExtendedState(JFrame.MAXIMIZED_BOTH);
        po.setVisible(true);
        this.setVisible(false);
        this.setEnabled(false);//choose between setEnabled and .dispose(), threads ka chakkar rahega shaayad
                               //UPDATE: passing this as a parameter to the PortalForm, becareful of using dispose()           
    }
    private void signUpLinkLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpLinkLabelMouseClicked
        
        SignUpForm s = new SignUpForm();
        s.setLocationRelativeTo(null);//This command centers the window on the main monitor
        s.setExtendedState(JFrame.MAXIMIZED_BOTH);
        s.setVisible(true);   
    }//GEN-LAST:event_signUpLinkLabelMouseClicked

    private void userTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userTFKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            signInButton.doClick();
    }//GEN-LAST:event_userTFKeyPressed

    private void passPFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passPFKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            signInButton.doClick();
    }//GEN-LAST:event_passPFKeyPressed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginForm l = new LoginForm();
                l.setLocationRelativeTo(null);
                l.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel invalidCredErrorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passPF;
    private javax.swing.JPanel scrollPane;
    private javax.swing.JButton signInButton;
    private javax.swing.JPanel signInPanel;
    private javax.swing.JLabel signUpLinkLabel;
    private javax.swing.JTextField userTF;
    // End of variables declaration//GEN-END:variables

    private void initUI() {
        //merge with initComponents when moving out of netbeans
        invalidCredErrorLabel.setVisible(false);
    }

    private void startupCode() {
       // getRootPane().setDefaultButton(signInButton);
    }
}
