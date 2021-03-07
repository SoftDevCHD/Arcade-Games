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

public class sudokuGameFrame implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        ;
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }
    
    public static void sudokuGameFrame(int score) {
        //Create Frame
        JFrame sudoku = new JFrame("Sudoku");
        sudoku.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sudoku.setLocationRelativeTo(null);
        
        //Create background
        JPanel g = new basic();
        
        //Create killbind keybind
        sudoku.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "EXIT");
        sudoku.getRootPane().getActionMap().put("EXIT", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
            sudoku.dispose();
            System.exit(0);
            }
        });
        
        //KeyBindings: Popup
        sudoku.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"), "POPUP");
        sudoku.getRootPane().getActionMap().put("POPUP", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                popup.popWindow();
            }
        });
        
        //Creating clock
        JLabel clock = new JLabel();
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clock.setText(DateFormat.getDateTimeInstance().format(new Date()));
            }
        });
        timer.setRepeats(true);
        timer.setInitialDelay(0);
        timer.start();
        clock.setFont(new Font("Verdana", Font.BOLD, 12));
        clock.setForeground(Color.BLACK);
        clock.setBounds(400, 5, 300, 30);
        
        //Default button dimensions
        int Dhori = 80;
        int Dvert = 30;
        
        //Creating buttons
        JButton submit = new JButton("Submit");
        JButton quit = new JButton("Quit");
        submit.setToolTipText("Submit your answer");
        quit.setToolTipText("Quit this game");
        submit.setBounds(490, 350, Dhori, Dvert);
        quit.setBounds(30, 350, Dhori, Dvert);
        
        //Add Listeners to buttons
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sudoku.setVisible(false);
                gameOverFrame.gameOverFrame(score);
            }
        });
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sudoku.setVisible(false);
                gameOverFrame.gameOverFrame(score);
            }
        });
        
        //Adding buttons and labels
        sudoku.add(clock);
        sudoku.add(submit);
        sudoku.add(quit);
        
        //Adding components to frame
        sudoku.add(g);
        sudoku.pack();
        sudoku.setVisible(true);
        sudoku.setLocationRelativeTo(null);
    }
}
