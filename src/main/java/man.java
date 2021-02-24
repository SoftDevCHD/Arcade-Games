/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Corey
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.text.DateFormat;
import java.util.Date;
import javax.imageio.*;
import javax.swing.*;
import java.util.Random;

public class man implements ActionListener {
    
    public void actionPerformed(ActionEvent e) {
        ;
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                loadingFrame(); //Loads the first frame
            }
        });
    }
    
    private static Timer timer;
    
    public static void loadingFrame() { //This is the loading frame
        JFrame loading = new JFrame("Loading Hangman...");
        loading.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loading.setLocationRelativeTo(null);

        //Creates load time
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.menuFrame();
                loading.dispose();
            }
        });
        
        timer.setInitialDelay(3000);
        timer.start();

        //Creates background
        JPanel g = new basic();
        
        //Creates labels and set fonts
        JLabel title = new JLabel("CS 2450: HANGMAN");
        JLabel team = new JLabel("Team: Void");
        title.setFont(new Font("Verdana", Font.BOLD, 18));
        team.setFont(new Font("Verdana", Font.BOLD, 14));
        title.setForeground(Color.BLACK);
        team.setForeground(Color.BLACK);
        
        //Sets position of labels
        title.setBounds(200, 10, 900, 100);
        team.setBounds(250, 30, 300, 100);
        
        //Adds elements of frame
        loading.add(title);
        loading.add(team);
        loading.add(g);
        loading.pack();
        loading.setVisible(true);
        loading.setLocationRelativeTo(null);
    }
    
    public static Timer getTimer() {
        return timer;
    }
}

class MyPanel extends JPanel {  //Background for menu
    private BufferedImage pic = null;
    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
        
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);   //1880, 1000
    }
        
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        try{
            pic = ImageIO.read(new File("src\\test.jpg"));  //Background image
        }catch(IOException e){}
        g.drawImage(pic, 1, 1, 600, 400, this);
        
        Font font = new Font("Verdana", Font.BOLD, 18);   //Text font
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(font);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            //Text that appears at top of frame
        g2.drawString("Team VOID presents", 200, 20);
        g2.drawString("HANGMAN", 255, 40);
    }
}


class basic extends JPanel {    //Background for every other frame
    private BufferedImage pic = null;
    public basic() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
        
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }
        
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        try{
            pic = ImageIO.read(new File("src\\test.jpg"));  //Background image
        }catch(IOException e){}
        g.drawImage(pic, 1, 1, 600, 400, this);
        
        Font font = new Font("TimesNewRoman", Font.BOLD, 69);  //Text font
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(font);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
     }
}
