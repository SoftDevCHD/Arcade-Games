import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.text.DateFormat;
import javax.imageio.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael Surma
 */
public class pongGameFrame extends JFrame {

    /**
     * Creates new form pongGameFrame
     */
    public pongGameFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(pongGameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pongGameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pongGameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pongGameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pongGameFrame().setVisible(true);
            }
        });
    }
    
    public static void pongGameFrame()  {   //frame that contains pong game
        //create frame
        JFrame pong = new JFrame("Pong");
        pong.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pong.setLocationRelativeTo(null);
        
        //Default button dimensions
        int Dhori = 80;
        int Dvert = 30;
        
        //Create gameboard background
        gameBoards g = new gameBoards();
        
        //Create killbind keybind
        pong.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "EXIT");
        pong.getRootPane().getActionMap().put("EXIT", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
            pong.dispose();
            System.exit(0);
            }
        });
        
       //KeyBindings: Popup
        pong.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"), "POPUP");
        pong.getRootPane().getActionMap().put("POPUP", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                popup.popWindow();
            }
        });
        
        //Add labels
        JLabel gameLabel = new JLabel("PONG");
        JLabel playerOneLabel = new JLabel("Player 1 Score:");
        JLabel playerTwoLabel = new JLabel("Player 2 Score:");
        gameLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        playerOneLabel.setFont(new Font("Verdana", Font.BOLD, 11));
        playerTwoLabel.setFont(new Font("Verdana", Font.BOLD, 11));
        gameLabel.setForeground(Color.RED);
        playerOneLabel.setForeground(Color.BLACK);
        playerTwoLabel.setForeground(Color.BLACK);
        Dimension size = gameLabel.getPreferredSize();
        gameLabel.setBounds(30, 10, size.width, size.height);
        playerOneLabel.setBounds(100, 25, 100, size.height);
        playerTwoLabel.setBounds(370, 25, 100, size.height);
        
        //Add textboxes
        JTextField playerOneScore = new JTextField(2);
        JTextField playerTwoScore = new JTextField(2);
        playerOneScore.setFont(new Font("Verdana",Font.BOLD, 11));
        playerTwoScore.setFont(new Font("Verdana",Font.BOLD, 11));
        playerOneScore.setBounds(205, 25, 30, size.height);
        playerTwoScore.setBounds(475, 25, 30, size.height);
        
        //Add button
        JButton quit = new JButton("Quit");
        quit.setToolTipText("Quit the game");
        quit.setBounds(510, 325, Dhori, Dvert);
        
        //Add action listener to button
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)  {
                pong.dispose();
                Game.scoreReset();
                menuFrame.menuFrame();
            }
        });
        
        Game game = new Game();
        Pong ponger = new Pong("Pong", game);
        
         //Creating clock
        JLabel clock = new JLabel();
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clock.setText(DateFormat.getDateTimeInstance().format(new Date()));
                playerOneScore.setText(String.valueOf(game.score1));
                playerTwoScore.setText(String.valueOf(game.score2));
            }
        });
        timer.setRepeats(true);
        timer.setInitialDelay(0);
        timer.start();
        clock.setFont(new Font("Verdana", Font.BOLD, 10));
        clock.setForeground(Color.BLACK);
        clock.setBounds(400, 0, 300, 20);
        
        //adding buttons and labels
        pong.add(clock);
        pong.add(quit);
        pong.add(gameLabel);
        pong.add(playerOneLabel);
        pong.add(playerTwoLabel);
        pong.add(playerOneScore);
        pong.add(playerTwoScore);
        
        //adding game and board
        pong.add(game);
        pong.pack();
        pong.setVisible(true);
        pong.setLocationRelativeTo(null);
        
        game.start();
    }    
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

class gameBoards extends JPanel {    //Background for every other frame
    private BufferedImage pic = null;
        
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }
}

