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
import javax.swing.*;

public class popup {
    public static void main(String[] args) {
        popWindow();
    }
    
    public static void popWindow() {
        JFrame info = new JFrame("Group Info");
        //info.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel background = new basic();
        
        //Button Dimensions
        int Dhori = 110;
        int Dvert = 30;
        
        //Label Dimensions
        int Lhori = 400;
        int Lvert = 50;
        
        //Create labels
        JLabel title = new JLabel("Games GUI Project");
        JLabel title2 = new JLabel("Spring 2021");
        JLabel cn = new JLabel("Corey Nambu, Cgnambu");
        JLabel cd = new JLabel("Clarence Domond, Cdomond");
        JLabel ms = new JLabel("Michael Surma, Masurma");
        JLabel jc = new JLabel("Joshua Cervantes, Jecervantes");
        
        //Sets fonts for labels
        title.setFont(new Font("Verdana", Font.BOLD, 18));
        title2.setFont(new Font("Verdana", Font.BOLD, 18));
        cd.setFont(new Font("Verdana", Font.BOLD, 12));
        cn.setFont(new Font("Verdana", Font.BOLD, 12));
        ms.setFont(new Font("Verdana", Font.BOLD, 12));
        jc.setFont(new Font("Verdana", Font.BOLD, 12));
        
        //Set label colors
        title.setForeground(Color.BLUE);
        title2.setForeground(Color.BLUE);
        cn.setForeground(Color.BLACK);
        cd.setForeground(Color.BLACK);
        ms.setForeground(Color.BLACK);
        jc.setForeground(Color.BLACK);
        
        //Adds button and labels
        info.add(title);
        info.add(title2);
        info.add(cn);
        info.add(cd);
        info.add(ms);
        info.add(jc);
        
        //Set Label positions and sizes
        title.setBounds(200, 0, 200, 30);
        title2.setBounds(230, 0, 200, 90);
        cn.setBounds(200, 100, Lhori, Lvert);
        cd.setBounds(200, 150, Lhori, Lvert);
        ms.setBounds(200, 200, Lhori, Lvert);
        jc.setBounds(200, 250, Lhori, Lvert);
        
        //KeyBindings: Killbind
        info.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "EXIT");
        info.getRootPane().getActionMap().put("EXIT", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
            info.dispose();
            System.exit(0);
            }
        });
        
        //Create buttons
        JButton close = new JButton("Close");
        info.add(close);
        close.setBounds(250, 350, Dhori, Dvert);
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                info.dispose();
            }
        });
        close.setToolTipText("Close this window");
        
        //Add components
        info.add(background);
        info.setVisible(true);
        info.setLocationRelativeTo(null);
        info.pack();
    }
}
