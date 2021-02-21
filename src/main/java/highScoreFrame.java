
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Clare
 */
public class highScoreFrame extends javax.swing.JFrame {

    /**
     * Creates new form highScoreFrame
     */
    public highScoreFrame() {
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
            java.util.logging.Logger.getLogger(highScoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(highScoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(highScoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(highScoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ;
            }
        });
    }
    
    public static void highScoreFrame() {  //This is the frame that contains the high score data
        JFrame highScore = new JFrame("HighScore"); //Creates frame
        highScore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        basic g = new basic();  //Creates background
        //Default buttons size
        int Dhori = 110;
        int Dvert = 30;
        int Lhori = 1000;
        int Lvert = 100;
        
        JButton back = new JButton("Back"); //Creates button
        back.addActionListener(new ActionListener() {   //Adds action listener to button
            public void actionPerformed(ActionEvent e) {
                menuFrame.getMenu().setVisible(true);
                highScore.dispose();
            }
        });
        
        //Ints to store the high scores
        int score1 = 420;
        int score2 = 385;
        int score3 = 100;
        int score4 = 69;
        
        //Strings to store names of high score holders
        String name1 = "John Doe";
        String name2 = "JarJar Binx";
        String name3 = "Papa Mario";
        String name4 = "Manama Jeff";
        
        //Labels to display name and score
        JLabel title = new JLabel("HIGH SCORES");
        JLabel display1 = new JLabel(name1 + " - " + score1);
        JLabel display2 = new JLabel(name2 + " - " + score2);
        JLabel display3 = new JLabel(name3 + " - " + score3);
        JLabel display4 = new JLabel(name4 + " - " + score4);
        
        //Sets fonts for labels
        title.setFont(new Font("Verdana", Font.BOLD, 18));
        display1.setFont(new Font("Verdana", Font.BOLD, 12));
        display2.setFont(new Font("Verdana", Font.BOLD, 12));
        display3.setFont(new Font("Verdana", Font.BOLD, 12));
        display4.setFont(new Font("Verdana", Font.BOLD, 12));
        
        //Set font colors
        title.setForeground(Color.BLACK);
        display1.setForeground(Color.BLACK);
        display2.setForeground(Color.BLACK);
        display3.setForeground(Color.BLACK);
        display4.setForeground(Color.BLACK);

        //Adds button and labels to frame
        highScore.add(back);
        highScore.add(title);
        highScore.add(display1);
        highScore.add(display2);
        highScore.add(display3);
        highScore.add(display4);
        
        //Determines the size and position of the labels and the button
        back.setBounds(30, 350, Dhori, Dvert); 
        title.setBounds(220, 10, 200, 20);
        display1.setBounds(220, 70, Lhori, Lvert);
        display2.setBounds(220, 120, Lhori, Lvert);
        display3.setBounds(220, 170, Lhori, Lvert);
        display4.setBounds(220, 220, Lhori, Lvert);
        
        //Draws background on frame and makes it visible
        highScore.add(g);
        highScore.pack();
        highScore.setVisible(true);
        highScore.setLocationRelativeTo(null);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}