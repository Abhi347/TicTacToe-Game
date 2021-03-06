/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.swing;

import ticatactoe.managers.GUIManager;

/**
 *
 * @author abhi
 */
public class StartScreen extends javax.swing.JFrame {

    /**
     * Creates new form StartScreen
     */
    public StartScreen() {
        initComponents();
        setLocationRelativeTo(null);
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
        mPlayer1Label = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mPlayer2Label = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ready!!!");
        setBounds(new java.awt.Rectangle(67, 23, 400, 300));
        setMaximumSize(new java.awt.Dimension(400, 300));
        setMinimumSize(new java.awt.Dimension(400, 300));
        setPreferredSize(new java.awt.Dimension(100, 75));
        getContentPane().setLayout(new java.awt.GridLayout(2, 1));

        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        jLabel1.setText("Player 1:");
        jPanel1.add(jLabel1);

        mPlayer1Label.setText("Name1");
        jPanel1.add(mPlayer1Label);

        jLabel3.setText("Player 2:");
        jPanel1.add(jLabel3);

        mPlayer2Label.setText("Name2");
        jPanel1.add(mPlayer2Label);

        getContentPane().add(jPanel1);

        jButton1.setLabel("Start Game");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        GUIManager.getInstance().startGame();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel mPlayer1Label;
    private javax.swing.JLabel mPlayer2Label;
    // End of variables declaration//GEN-END:variables

    public void setPlayerNames(String player1Name, String player2Name) {
        mPlayer1Label.setText(player1Name);
        mPlayer2Label.setText(player2Name);
    }
}
