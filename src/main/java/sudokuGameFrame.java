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

public class sudokuGameFrame implements ActionListener{
    private static JTextField q11;
    private static JTextField q12;
    private static JTextField q13;
    private static JTextField q14;
    private static JTextField q15;
    private static JTextField q16;
    private static JTextField q17;
    private static JTextField q21;
    private static JTextField q22;
    private static JTextField q23;
    private static JTextField q24;
    private static JTextField q25;
    private static JTextField q26;
    private static JTextField q27;
    private static JTextField q31;
    private static JTextField q32;
    private static JTextField q35;
    private static JTextField q36;
    private static JTextField q39;
    private static JTextField q42;
    private static JTextField q44;
    private static JTextField q45;
    private static JTextField q46;
    private static JTextField q47;
    private static JTextField q51;
    private static JTextField q53;
    private static JTextField q54;
    private static JTextField q56;
    private static JTextField q57;
    private static JTextField q59;
    private static JTextField q63;
    private static JTextField q64;
    private static JTextField q65;
    private static JTextField q66;
    private static JTextField q68;
    private static JTextField q71;
    private static JTextField q74;
    private static JTextField q75;
    private static JTextField q78;
    private static JTextField q79;
    private static JTextField q81;
    private static JTextField q82;
    private static JTextField q83;
    private static JTextField q84;
    private static JTextField q85;
    private static JTextField q86;
    private static JTextField q88;
    private static JTextField q91;
    private static JTextField q93;
    private static JTextField q94;
    private static JTextField q95;
    private static JTextField q96;
    private static JTextField q97;
    private static JTextField q98;

    private static int sudokuScore = 540;
    static int attempts = 0;
    static int error = 0;
    static boolean integrity = true;


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

        
        //Create background and game board
        gameBoard g = new gameBoard();
        
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
        
        //Sudoku board variables
        int baseHori = 120;
        int baseVert = 30;
        int squareOffset = 120;
        int largeLength = 360;
        int lineOffset = 40;
        int charOffset = 5;
        int charSize = 30;
        int textOffset = 4;
        int textboxSize = 35;
        
        //Sudoku hint labels
        JLabel q1_1 = new JLabel("1");
        JLabel q1_8 = new JLabel("8");
        JLabel q2_4 = new JLabel("4");
        JLabel q2_6 = new JLabel("6");
        JLabel q3_4 = new JLabel("4");
        JLabel q3_5 = new JLabel("5");
        JLabel q3_6 = new JLabel("6");
        JLabel q3_7 = new JLabel("7");
        JLabel q4_4 = new JLabel("4");
        JLabel q4_5 = new JLabel("5");
        JLabel q4_8 = new JLabel("8");
        JLabel q4_9 = new JLabel("9");
        JLabel q5_2 = new JLabel("2");
        JLabel q5_3 = new JLabel("3");
        JLabel q5_7 = new JLabel("7");
        JLabel q6_1 = new JLabel("1");
        JLabel q6_3 = new JLabel("3");
        JLabel q6_7 = new JLabel("7");
        JLabel q6_8 = new JLabel("8");
        JLabel q7_1 = new JLabel("1");
        JLabel q7_2 = new JLabel("2");
        JLabel q7_3 = new JLabel("3");
        JLabel q7_5 = new JLabel("5");
        JLabel q8_2 = new JLabel("2");
        JLabel q8_9 = new JLabel("9");
        JLabel q9_5 = new JLabel("5");
        JLabel q9_9 = new JLabel("9");
        q1_8.setBounds(baseHori + charOffset, baseVert + charOffset, charSize, charSize);
        q1_1.setBounds(baseHori + lineOffset + charOffset, baseVert + 2*lineOffset + charOffset, charSize, charSize);
        q2_4.setBounds(baseHori + squareOffset + charOffset, baseVert + charOffset, charSize, charSize);
        q2_6.setBounds(baseHori + squareOffset + 2*lineOffset + charOffset, baseVert + charOffset, charSize, charSize);
        q3_4.setBounds(baseHori + 2*squareOffset + charOffset, baseVert + lineOffset + charOffset, charSize, charSize);
        q3_5.setBounds(baseHori + 2*squareOffset + lineOffset + charOffset, baseVert + 2*lineOffset + charOffset, charSize, charSize);
        q3_6.setBounds(baseHori + 2*squareOffset + charOffset, baseVert + 2*lineOffset + charOffset, charSize, charSize);
        q3_7.setBounds(baseHori + 2*squareOffset + 2*lineOffset + charOffset, baseVert + charOffset, charSize, charSize);
        q4_4.setBounds(baseHori + lineOffset + charOffset, baseVert + squareOffset + 2*lineOffset + charOffset, charSize, charSize);
        q4_5.setBounds(baseHori + charOffset, baseVert + squareOffset + charOffset, charSize, charSize);
        q4_8.setBounds(baseHori + 2*lineOffset + charOffset, baseVert + squareOffset + 2*lineOffset + charOffset, charSize, charSize);
        q4_9.setBounds(baseHori + 2*lineOffset + charOffset, baseVert + squareOffset + charOffset, charSize, charSize);
        q5_2.setBounds(baseHori + squareOffset + lineOffset + charOffset, baseVert + squareOffset + 2*lineOffset + charOffset, charSize, charSize);
        q5_3.setBounds(baseHori + squareOffset + lineOffset + charOffset, baseVert + squareOffset + charOffset, charSize, charSize);
        q5_7.setBounds(baseHori + squareOffset + lineOffset + charOffset, baseVert + squareOffset + lineOffset + charOffset, charSize, charSize);
        q6_1.setBounds(baseHori + 2*squareOffset + charOffset, baseVert + squareOffset + 2*lineOffset + charOffset, charSize, charSize);
        q6_3.setBounds(baseHori + 2*squareOffset + 2*lineOffset + charOffset, baseVert + squareOffset + 2*lineOffset + charOffset, charSize, charSize);
        q6_7.setBounds(baseHori + 2*squareOffset + charOffset, baseVert + squareOffset + charOffset, charSize, charSize);
        q6_8.setBounds(baseHori + 2*squareOffset + lineOffset + charOffset, baseVert + squareOffset + charOffset, charSize, charSize);
        q7_1.setBounds(baseHori + 2*lineOffset + charOffset, baseVert + 2*squareOffset + lineOffset + charOffset, charSize, charSize);
        q7_2.setBounds(baseHori + 2*lineOffset + charOffset, baseVert + 2*squareOffset + charOffset, charSize, charSize);
        q7_3.setBounds(baseHori + charOffset, baseVert + 2*squareOffset + 2*lineOffset + charOffset, charSize, charSize);
        q7_5.setBounds(baseHori + lineOffset + charOffset, baseVert + 2*squareOffset + charOffset, charSize, charSize);
        q8_2.setBounds(baseHori + squareOffset + 2*lineOffset + charOffset, baseVert + 2*squareOffset + 2*lineOffset + charOffset, charSize, charSize);
        q8_9.setBounds(baseHori + squareOffset + charOffset, baseVert + 2*squareOffset + 2*lineOffset + charOffset, charSize, charSize);
        q9_5.setBounds(baseHori + 2*squareOffset + 2*lineOffset + charOffset, baseVert + 2*squareOffset + 2*lineOffset + charOffset, charSize, charSize);
        q9_9.setBounds(baseHori + 2*squareOffset + lineOffset + charOffset, baseVert + 2*squareOffset + charOffset, charSize, charSize);
        //Adding 
        sudoku.add(q1_1);
        sudoku.add(q1_8);
        sudoku.add(q2_4);
        sudoku.add(q2_6);
        sudoku.add(q3_4);
        sudoku.add(q3_5);
        sudoku.add(q3_6);
        sudoku.add(q3_7);
        sudoku.add(q4_4);
        sudoku.add(q4_5);
        sudoku.add(q4_8);
        sudoku.add(q4_9);
        sudoku.add(q5_2);
        sudoku.add(q5_3);
        sudoku.add(q5_7);
        sudoku.add(q6_1);
        sudoku.add(q6_3);
        sudoku.add(q6_7);
        sudoku.add(q6_8);
        sudoku.add(q7_1);
        sudoku.add(q7_2);
        sudoku.add(q7_3);
        sudoku.add(q7_5);
        sudoku.add(q8_2);
        sudoku.add(q8_9);
        sudoku.add(q9_5);
        sudoku.add(q9_9);
        
        /*
        q11.setBounds(baseHori + textOffset, baseVert + textOffset, textboxSize, textboxSize);
        q12.setBounds(baseHori + lineOffset + textOffset, baseVert + textOffset, textboxSize, textboxSize);
        q13.setBounds(baseHori + 2*lineOffset + textOffset, baseVert + textOffset, textboxSize, textboxSize);
        q14.setBounds(baseHori + textOffset, baseVert + lineOffset + textOffset, textboxSize, textboxSize);
        q15.setBounds(baseHori + lineOffset + textOffset, baseVert + lineOffset + textOffset, textboxSize, textboxSize);
        q16.setBounds(baseHori + 2*lineOffset + textOffset, baseVert + lineOffset + textOffset, textboxSize, textboxSize);
        q17.setBounds(baseHori + textOffset, baseVert + 2*lineOffset + textOffset, textboxSize, textboxSize);
        q18.setBounds(baseHori + lineOffset + textOffset, baseVert + 2*lineOffset + textOffset, textboxSize, textboxSize);
        q19.setBounds(baseHori + 2*lineOffset + textOffset, baseVert + 2*lineOffset + textOffset, textboxSize, textboxSize);
        */
        
        //Creating textboxes
        q11 = new JTextField(1);
        q12 = new JTextField(1);
        q13 = new JTextField(1);
        q14 = new JTextField(1);
        q15 = new JTextField(1);
        q16 = new JTextField(1);
        q17 = new JTextField(1);
        q21 = new JTextField(1);
        q22 = new JTextField(1);
        q23 = new JTextField(1);
        q24 = new JTextField(1);
        q25 = new JTextField(1);
        q26 = new JTextField(1);
        q27 = new JTextField(1);
        q31 = new JTextField(1);
        q32 = new JTextField(1);
        q35 = new JTextField(1);
        q36 = new JTextField(1);
        q39 = new JTextField(1);
        q42 = new JTextField(1);
        q44 = new JTextField(1);
        q45 = new JTextField(1);
        q46 = new JTextField(1);
        q47 = new JTextField(1);
        q51 = new JTextField(1);
        q53 = new JTextField(1);
        q54 = new JTextField(1);
        q56 = new JTextField(1);
        q57 = new JTextField(1);
        q59 = new JTextField(1);
        q63 = new JTextField(1);
        q64 = new JTextField(1);
        q65 = new JTextField(1);
        q66 = new JTextField(1);
        q68 = new JTextField(1);
        q71 = new JTextField(1);
        q74 = new JTextField(1);
        q75 = new JTextField(1);
        q78 = new JTextField(1);
        q79 = new JTextField(1);
        q81 = new JTextField(1);
        q82 = new JTextField(1);
        q83 = new JTextField(1);
        q84 = new JTextField(1);
        q85 = new JTextField(1);
        q86 = new JTextField(1);
        q88 = new JTextField(1);
        q91 = new JTextField(1);
        q93 = new JTextField(1);
        q94 = new JTextField(1);
        q95 = new JTextField(1);
        q96 = new JTextField(1);
        q97 = new JTextField(1);
        q98 = new JTextField(1);
        q11.setBounds(baseHori + lineOffset + textOffset, baseVert + textOffset, textboxSize, textboxSize);
        q12.setBounds(baseHori + 2*lineOffset + textOffset, baseVert + textOffset, textboxSize, textboxSize);
        q13.setBounds(baseHori + textOffset, baseVert + lineOffset + textOffset, textboxSize, textboxSize);
        q14.setBounds(baseHori + lineOffset + textOffset, baseVert + lineOffset + textOffset, textboxSize, textboxSize);
        q15.setBounds(baseHori + 2*lineOffset + textOffset, baseVert + lineOffset + textOffset, textboxSize, textboxSize);
        q16.setBounds(baseHori + textOffset, baseVert + 2*lineOffset + textOffset, textboxSize, textboxSize);
        q17.setBounds(baseHori + 2*lineOffset + textOffset, baseVert + 2*lineOffset + textOffset, textboxSize, textboxSize);
        q21.setBounds(baseHori + squareOffset + lineOffset + textOffset, baseVert + textOffset, textboxSize, textboxSize);
        q22.setBounds(baseHori + squareOffset + lineOffset + textOffset, baseVert + 2*lineOffset + textOffset, textboxSize, textboxSize);
        q23.setBounds(baseHori + squareOffset + textOffset, baseVert + lineOffset + textOffset, textboxSize, textboxSize);
        q24.setBounds(baseHori + squareOffset + lineOffset + textOffset, baseVert + lineOffset + textOffset, textboxSize, textboxSize);
        q25.setBounds(baseHori + squareOffset + 2*lineOffset + textOffset, baseVert + lineOffset + textOffset, textboxSize, textboxSize);
        q26.setBounds(baseHori + squareOffset + textOffset, baseVert + 2*lineOffset + textOffset, textboxSize, textboxSize);
        q27.setBounds(baseHori + squareOffset + 2*lineOffset + textOffset, baseVert + 2*lineOffset + textOffset, textboxSize, textboxSize);
        q31.setBounds(baseHori + 2*squareOffset + textOffset, baseVert + textOffset, textboxSize, textboxSize);
        q32.setBounds(baseHori + 2*squareOffset + lineOffset + textOffset, baseVert + textOffset, textboxSize, textboxSize);
        q35.setBounds(baseHori + 2*squareOffset + lineOffset + textOffset, baseVert + lineOffset + textOffset, textboxSize, textboxSize);
        q36.setBounds(baseHori + 2*squareOffset + 2*lineOffset + textOffset, baseVert + lineOffset + textOffset, textboxSize, textboxSize);
        q39.setBounds(baseHori + 2*squareOffset + 2*lineOffset + textOffset, baseVert + 2*lineOffset + textOffset, textboxSize, textboxSize);
        q42.setBounds(baseHori + lineOffset + textOffset, baseVert + squareOffset + textOffset, textboxSize, textboxSize);
        q44.setBounds(baseHori + textOffset, baseVert + squareOffset + lineOffset + textOffset, textboxSize, textboxSize);
        q45.setBounds(baseHori + lineOffset + textOffset, baseVert + squareOffset + lineOffset + textOffset, textboxSize, textboxSize);
        q46.setBounds(baseHori + 2*lineOffset + textOffset, baseVert + squareOffset + lineOffset + textOffset, textboxSize, textboxSize);
        q47.setBounds(baseHori + textOffset, baseVert + 2*lineOffset + squareOffset + textOffset, textboxSize, textboxSize);
        q51.setBounds(baseHori + squareOffset + textOffset, baseVert + squareOffset + textOffset, textboxSize, textboxSize);
        q53.setBounds(baseHori + squareOffset + 2*lineOffset + textOffset, baseVert + squareOffset + textOffset, textboxSize, textboxSize);
        q54.setBounds(baseHori + squareOffset + textOffset, baseVert + squareOffset + lineOffset + textOffset, textboxSize, textboxSize);
        q56.setBounds(baseHori + squareOffset + 2*lineOffset + textOffset, baseVert + squareOffset + lineOffset + textOffset, textboxSize, textboxSize);
        q57.setBounds(baseHori + squareOffset + textOffset, baseVert + squareOffset + 2*lineOffset + textOffset, textboxSize, textboxSize);
        q59.setBounds(baseHori + squareOffset + 2*lineOffset + textOffset, baseVert + squareOffset + 2*lineOffset + textOffset, textboxSize, textboxSize);
        q63.setBounds(baseHori + 2*squareOffset + 2*lineOffset + textOffset, baseVert + squareOffset + textOffset, textboxSize, textboxSize);
        q64.setBounds(baseHori + 2*squareOffset + textOffset, baseVert + squareOffset + lineOffset + textOffset, textboxSize, textboxSize);
        q65.setBounds(baseHori + 2*squareOffset + lineOffset + textOffset, baseVert + squareOffset + lineOffset + textOffset, textboxSize, textboxSize);
        q66.setBounds(baseHori + 2*squareOffset + 2*lineOffset + textOffset, baseVert + squareOffset + lineOffset + textOffset, textboxSize, textboxSize);
        q68.setBounds(baseHori + 2*squareOffset + lineOffset + textOffset, baseVert + squareOffset + 2*lineOffset + textOffset, textboxSize, textboxSize);
        q71.setBounds(baseHori + textOffset, baseVert + 2*squareOffset + textOffset, textboxSize, textboxSize);
        q74.setBounds(baseHori + textOffset, baseVert + 2*squareOffset + lineOffset + textOffset, textboxSize, textboxSize);
        q75.setBounds(baseHori + lineOffset + textOffset, baseVert + 2*squareOffset + lineOffset + textOffset, textboxSize, textboxSize);
        q78.setBounds(baseHori + lineOffset + textOffset, baseVert + 2*squareOffset + 2*lineOffset + textOffset, textboxSize, textboxSize);
        q79.setBounds(baseHori + 2*lineOffset + textOffset, baseVert + 2*squareOffset + 2*lineOffset + textOffset, textboxSize, textboxSize);
        q81.setBounds(baseHori + squareOffset + textOffset, baseVert + 2*squareOffset + textOffset, textboxSize, textboxSize);
        q82.setBounds(baseHori + squareOffset + lineOffset + textOffset, baseVert + 2*squareOffset + textOffset, textboxSize, textboxSize);
        q83.setBounds(baseHori + squareOffset + 2*lineOffset + textOffset, baseVert + 2*squareOffset + textOffset, textboxSize, textboxSize);
        q84.setBounds(baseHori + squareOffset + textOffset, baseVert + 2*squareOffset + lineOffset + textOffset, textboxSize, textboxSize);
        q85.setBounds(baseHori + squareOffset + lineOffset + textOffset, baseVert + 2*squareOffset + lineOffset + textOffset, textboxSize, textboxSize);
        q86.setBounds(baseHori + squareOffset + 2*lineOffset + textOffset, baseVert + 2*squareOffset + lineOffset + textOffset, textboxSize, textboxSize);
        q88.setBounds(baseHori + squareOffset + lineOffset + textOffset, baseVert + 2*squareOffset + 2*lineOffset + textOffset, textboxSize, textboxSize);
        q91.setBounds(baseHori + 2*squareOffset + textOffset, baseVert + 2*squareOffset + textOffset, textboxSize, textboxSize);
        q93.setBounds(baseHori + 2*squareOffset + 2*lineOffset + textOffset, baseVert + 2*squareOffset + textOffset, textboxSize, textboxSize);
        q94.setBounds(baseHori + 2*squareOffset + textOffset, baseVert + 2*squareOffset + lineOffset + textOffset, textboxSize, textboxSize);
        q95.setBounds(baseHori + 2*squareOffset + lineOffset + textOffset, baseVert + 2*squareOffset + lineOffset + textOffset, textboxSize, textboxSize);
        q96.setBounds(baseHori + 2*squareOffset + 2*lineOffset + textOffset, baseVert + 2*squareOffset + lineOffset + textOffset, textboxSize, textboxSize);
        q97.setBounds(baseHori + 2*squareOffset + textOffset, baseVert + 2*lineOffset + 2*squareOffset + textOffset, textboxSize, textboxSize);
        q98.setBounds(baseHori + 2*squareOffset + lineOffset + textOffset, baseVert + 2*squareOffset + 2*lineOffset + textOffset, textboxSize, textboxSize);
        sudoku.add(q11);
        sudoku.add(q12);
        sudoku.add(q13);
        sudoku.add(q14);
        sudoku.add(q15);
        sudoku.add(q16);
        sudoku.add(q17);
        sudoku.add(q21);
        sudoku.add(q22);
        sudoku.add(q23);
        sudoku.add(q24);
        sudoku.add(q25);
        sudoku.add(q26);
        sudoku.add(q27);
        sudoku.add(q31);
        sudoku.add(q32);
        sudoku.add(q35);
        sudoku.add(q36);
        sudoku.add(q39);
        sudoku.add(q42);
        sudoku.add(q44);
        sudoku.add(q45);
        sudoku.add(q46);
        sudoku.add(q47);
        sudoku.add(q42);
        sudoku.add(q51);
        sudoku.add(q53);
        sudoku.add(q54);
        sudoku.add(q56);
        sudoku.add(q57);
        sudoku.add(q59);
        sudoku.add(q63);
        sudoku.add(q64);
        sudoku.add(q65);
        sudoku.add(q66);
        sudoku.add(q68);
        sudoku.add(q71);
        sudoku.add(q74);
        sudoku.add(q75);
        sudoku.add(q78);
        sudoku.add(q79);
        sudoku.add(q81);
        sudoku.add(q82);
        sudoku.add(q83);
        sudoku.add(q84);
        sudoku.add(q85);
        sudoku.add(q86);
        sudoku.add(q88);
        sudoku.add(q91);
        sudoku.add(q93);
        sudoku.add(q94);
        sudoku.add(q95);
        sudoku.add(q96);
        sudoku.add(q97);
        sudoku.add(q98);

        
        
        //Creating buttons
        JButton submit = new JButton("Submit");
        JButton quit = new JButton("Quit");
        submit.setToolTipText("Submit your answer");
        quit.setToolTipText("Quit this game");
        submit.setBounds(490, 350, Dhori, Dvert);
        quit.setBounds(30, 350, Dhori, Dvert);
        
        //Add 'Sudoku' label
        JLabel gameLabel = new JLabel("SUDOKU");
        gameLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        gameLabel.setForeground(Color.BLUE);
        Dimension size = gameLabel.getPreferredSize();
        gameLabel.setBounds(10, 10, size.width, size.height);
        
        
        //Add Listeners to buttons
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int n = 0;
                gameVerification(sudoku);
                if (!integrity) return;
                if (error == 0) {
                    sudoku.dispose();
                    gameOverFrame.gameOverFrame(score + sudokuScore);
                }
                else if (error == 1) {
                    String[] options = {"Try again", "Submit"};
                    n = JOptionPane.showOptionDialog(sudoku,
                            "Your board has mistakes. Do you still want to submit?",
                            "Incorrect Solution",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[0]);
                }
                if (n != JOptionPane.YES_OPTION) {
                    sudoku.dispose();
                    gameOverFrame.gameOverFrame(score + sudokuScore);
                }
            }
        });
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sudoku.dispose();
                gameOverFrame.gameOverFrame(score);
            }
        });
        
        //Adding buttons and labels
        sudoku.add(clock);
        sudoku.add(submit);
        sudoku.add(quit);
        sudoku.add(gameLabel);
        
        //Adding components to frame
        
        //sudoku.add(board);
        sudoku.add(g);
        sudoku.pack();
        sudoku.setVisible(true);
        sudoku.setLocationRelativeTo(null);
    }
    
    // Game logic
    static void gameVerification(JFrame f) {
        error = 0;
        try {
            if (
            Integer.parseInt(q11.getText()) < 1 || Integer.parseInt(q11.getText()) > 9 ||
            Integer.parseInt(q12.getText()) < 1 || Integer.parseInt(q12.getText()) > 9 ||
            Integer.parseInt(q13.getText()) < 1 || Integer.parseInt(q13.getText()) > 9 ||
            Integer.parseInt(q14.getText()) < 1 || Integer.parseInt(q14.getText()) > 9 ||
            Integer.parseInt(q15.getText()) < 1 || Integer.parseInt(q15.getText()) > 9 ||
            Integer.parseInt(q16.getText()) < 1 || Integer.parseInt(q16.getText()) > 9 ||
            Integer.parseInt(q17.getText()) < 1 || Integer.parseInt(q17.getText()) > 9 ||
            Integer.parseInt(q21.getText()) < 1 || Integer.parseInt(q21.getText()) > 9 ||
            Integer.parseInt(q22.getText()) < 1 || Integer.parseInt(q22.getText()) > 9 ||
            Integer.parseInt(q23.getText()) < 1 || Integer.parseInt(q23.getText()) > 9 ||
            Integer.parseInt(q24.getText()) < 1 || Integer.parseInt(q24.getText()) > 9 ||
            Integer.parseInt(q25.getText()) < 1 || Integer.parseInt(q25.getText()) > 9 ||
            Integer.parseInt(q26.getText()) < 1 || Integer.parseInt(q26.getText()) > 9 ||
            Integer.parseInt(q27.getText()) < 1 || Integer.parseInt(q27.getText()) > 9 ||
            Integer.parseInt(q31.getText()) < 1 || Integer.parseInt(q31.getText()) > 9 ||
            Integer.parseInt(q32.getText()) < 1 || Integer.parseInt(q32.getText()) > 9 ||
            Integer.parseInt(q35.getText()) < 1 || Integer.parseInt(q35.getText()) > 9 ||
            Integer.parseInt(q36.getText()) < 1 || Integer.parseInt(q36.getText()) > 9 ||
            Integer.parseInt(q39.getText()) < 1 || Integer.parseInt(q39.getText()) > 9 ||
            Integer.parseInt(q42.getText()) < 1 || Integer.parseInt(q42.getText()) > 9 ||
            Integer.parseInt(q44.getText()) < 1 || Integer.parseInt(q44.getText()) > 9 ||
            Integer.parseInt(q45.getText()) < 1 || Integer.parseInt(q45.getText()) > 9 ||
            Integer.parseInt(q46.getText()) < 1 || Integer.parseInt(q46.getText()) > 9 ||
            Integer.parseInt(q47.getText()) < 1 || Integer.parseInt(q47.getText()) > 9 ||
            Integer.parseInt(q51.getText()) < 1 || Integer.parseInt(q51.getText()) > 9 ||
            Integer.parseInt(q53.getText()) < 1 || Integer.parseInt(q53.getText()) > 9 ||
            Integer.parseInt(q54.getText()) < 1 || Integer.parseInt(q54.getText()) > 9 ||
            Integer.parseInt(q56.getText()) < 1 || Integer.parseInt(q56.getText()) > 9 ||
            Integer.parseInt(q57.getText()) < 1 || Integer.parseInt(q57.getText()) > 9 ||
            Integer.parseInt(q59.getText()) < 1 || Integer.parseInt(q59.getText()) > 9 ||
            Integer.parseInt(q63.getText()) < 1 || Integer.parseInt(q63.getText()) > 9 ||
            Integer.parseInt(q64.getText()) < 1 || Integer.parseInt(q64.getText()) > 9 ||
            Integer.parseInt(q65.getText()) < 1 || Integer.parseInt(q65.getText()) > 9 ||
            Integer.parseInt(q66.getText()) < 1 || Integer.parseInt(q66.getText()) > 9 ||
            Integer.parseInt(q68.getText()) < 1 || Integer.parseInt(q68.getText()) > 9 ||
            Integer.parseInt(q71.getText()) < 1 || Integer.parseInt(q71.getText()) > 9 ||
            Integer.parseInt(q74.getText()) < 1 || Integer.parseInt(q74.getText()) > 9 ||
            Integer.parseInt(q75.getText()) < 1 || Integer.parseInt(q75.getText()) > 9 ||
            Integer.parseInt(q78.getText()) < 1 || Integer.parseInt(q78.getText()) > 9 ||
            Integer.parseInt(q79.getText()) < 1 || Integer.parseInt(q79.getText()) > 9 ||
            Integer.parseInt(q81.getText()) < 1 || Integer.parseInt(q81.getText()) > 9 ||
            Integer.parseInt(q82.getText()) < 1 || Integer.parseInt(q82.getText()) > 9 ||
            Integer.parseInt(q83.getText()) < 1 || Integer.parseInt(q83.getText()) > 9 ||
            Integer.parseInt(q84.getText()) < 1 || Integer.parseInt(q84.getText()) > 9 ||
            Integer.parseInt(q85.getText()) < 1 || Integer.parseInt(q85.getText()) > 9 ||
            Integer.parseInt(q86.getText()) < 1 || Integer.parseInt(q86.getText()) > 9 ||
            Integer.parseInt(q88.getText()) < 1 || Integer.parseInt(q88.getText()) > 9 ||
            Integer.parseInt(q91.getText()) < 1 || Integer.parseInt(q91.getText()) > 9 ||
            Integer.parseInt(q93.getText()) < 1 || Integer.parseInt(q93.getText()) > 9 ||
            Integer.parseInt(q94.getText()) < 1 || Integer.parseInt(q94.getText()) > 9 ||
            Integer.parseInt(q95.getText()) < 1 || Integer.parseInt(q95.getText()) > 9 ||
            Integer.parseInt(q96.getText()) < 1 || Integer.parseInt(q96.getText()) > 9 ||
            Integer.parseInt(q97.getText()) < 1 || Integer.parseInt(q97.getText()) > 9 ||
            Integer.parseInt(q98.getText()) < 1 || Integer.parseInt(q98.getText()) > 9) {
                JOptionPane.showMessageDialog(f,
                    "Some of your values aren't between 1 and 9...",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
                integrity = false;
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(f,
                    "Some of your boxes have invalid data",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            integrity = false;
            return;
        }
        integrity = true;
        if (attempts == 0) {
            if (!q11.getText().equals("9")) {sudokuScore -= 10; error = 1;}
            if (!q12.getText().equals("2")) {sudokuScore -= 10; error = 1;}
            if (!q13.getText().equals("3")) {sudokuScore -= 10; error = 1;}
            if (!q14.getText().equals("4")) {sudokuScore -= 10; error = 1;}
            if (!q15.getText().equals("5")) {sudokuScore -= 10; error = 1;}
            if (!q16.getText().equals("6")) {sudokuScore -= 10; error = 1;}
            if (!q17.getText().equals("7")) {sudokuScore -= 10; error = 1;}
            if (!q21.getText().equals("1")) {sudokuScore -= 10; error = 1;}
            if (!q22.getText().equals("8")) {sudokuScore -= 10; error = 1;}
            if (!q23.getText().equals("5")) {sudokuScore -= 10; error = 1;}
            if (!q24.getText().equals("7")) {sudokuScore -= 10; error = 1;}
            if (!q25.getText().equals("2")) {sudokuScore -= 10; error = 1;}
            if (!q26.getText().equals("9")) {sudokuScore -= 10; error = 1;}
            if (!q27.getText().equals("3")) {sudokuScore -= 10; error = 1;}
            if (!q31.getText().equals("9")) {sudokuScore -= 10; error = 1;}
            if (!q32.getText().equals("2")) {sudokuScore -= 10; error = 1;}
            if (!q35.getText().equals("3")) {sudokuScore -= 10; error = 1;}
            if (!q36.getText().equals("1")) {sudokuScore -= 10; error = 1;}
            if (!q39.getText().equals("8")) {sudokuScore -= 10; error = 1;}
            if (!q42.getText().equals("6")) {sudokuScore -= 10; error = 1;}
            if (!q44.getText().equals("1")) {sudokuScore -= 10; error = 1;}
            if (!q45.getText().equals("2")) {sudokuScore -= 10; error = 1;}
            if (!q46.getText().equals("3")) {sudokuScore -= 10; error = 1;}
            if (!q47.getText().equals("7")) {sudokuScore -= 10; error = 1;}
            if (!q51.getText().equals("1")) {sudokuScore -= 10; error = 1;}
            if (!q53.getText().equals("4")) {sudokuScore -= 10; error = 1;}
            if (!q54.getText().equals("6")) {sudokuScore -= 10; error = 1;}
            if (!q56.getText().equals("8")) {sudokuScore -= 10; error = 1;}
            if (!q57.getText().equals("5")) {sudokuScore -= 10; error = 1;}
            if (!q59.getText().equals("9")) {sudokuScore -= 10; error = 1;}
            if (!q63.getText().equals("2")) {sudokuScore -= 10; error = 1;}
            if (!q64.getText().equals("5")) {sudokuScore -= 10; error = 1;}
            if (!q65.getText().equals("4")) {sudokuScore -= 10; error = 1;}
            if (!q66.getText().equals("9")) {sudokuScore -= 10; error = 1;}
            if (!q68.getText().equals("6")) {sudokuScore -= 10; error = 1;}
            if (!q71.getText().equals("6")) {sudokuScore -= 10; error = 1;}
            if (!q74.getText().equals("9")) {sudokuScore -= 10; error = 1;}
            if (!q75.getText().equals("8")) {sudokuScore -= 10; error = 1;}
            if (!q78.getText().equals("7")) {sudokuScore -= 10; error = 1;}
            if (!q79.getText().equals("4")) {sudokuScore -= 10; error = 1;}
            if (!q81.getText().equals("7")) {sudokuScore -= 10; error = 1;}
            if (!q82.getText().equals("8")) {sudokuScore -= 10; error = 1;}
            if (!q83.getText().equals("1")) {sudokuScore -= 10; error = 1;}
            if (!q84.getText().equals("3")) {sudokuScore -= 10; error = 1;}
            if (!q85.getText().equals("4")) {sudokuScore -= 10; error = 1;}
            if (!q86.getText().equals("5")) {sudokuScore -= 10; error = 1;}
            if (!q88.getText().equals("6")) {sudokuScore -= 10; error = 1;}
            if (!q91.getText().equals("3")) {sudokuScore -= 10; error = 1;}
            if (!q93.getText().equals("4")) {sudokuScore -= 10; error = 1;}
            if (!q94.getText().equals("2")) {sudokuScore -= 10; error = 1;}
            if (!q95.getText().equals("7")) {sudokuScore -= 10; error = 1;}
            if (!q96.getText().equals("6")) {sudokuScore -= 10; error = 1;}
            if (!q97.getText().equals("8")) {sudokuScore -= 10; error = 1;}
            if (!q98.getText().equals("1")) {sudokuScore -= 10; error = 1;}
        }
        else {
            if (!q11.getText().equals("3")) { error = 1;}
            if (!q12.getText().equals("5")) { error = 1;}
            if (!q13.getText().equals("2")) { error = 1;}
            if (!q14.getText().equals("9")) { error = 1;}
            if (!q15.getText().equals("6")) { error = 1;}
            if (!q16.getText().equals("4")) { error = 1;}
            if (!q17.getText().equals("7")) { error = 1;}
            if (!q21.getText().equals("1")) { error = 1;}
            if (!q22.getText().equals("8")) { error = 1;}
            if (!q23.getText().equals("5")) { error = 1;}
            if (!q24.getText().equals("7")) { error = 1;}
            if (!q25.getText().equals("2")) { error = 1;}
            if (!q26.getText().equals("9")) { error = 1;}
            if (!q27.getText().equals("3")) { error = 1;}
            if (!q31.getText().equals("9")) { error = 1;}
            if (!q32.getText().equals("2")) { error = 1;}
            if (!q35.getText().equals("3")) { error = 1;}
            if (!q36.getText().equals("1")) { error = 1;}
            if (!q39.getText().equals("8")) { error = 1;}
            if (!q42.getText().equals("6")) { error = 1;}
            if (!q44.getText().equals("1")) { error = 1;}
            if (!q45.getText().equals("2")) { error = 1;}
            if (!q46.getText().equals("3")) { error = 1;}
            if (!q47.getText().equals("7")) { error = 1;}
            if (!q51.getText().equals("1")) { error = 1;}
            if (!q53.getText().equals("4")) { error = 1;}
            if (!q54.getText().equals("6")) { error = 1;}
            if (!q56.getText().equals("8")) { error = 1;}
            if (!q57.getText().equals("5")) { error = 1;}
            if (!q59.getText().equals("9")) { error = 1;}
            if (!q63.getText().equals("2")) { error = 1;}
            if (!q64.getText().equals("5")) { error = 1;}
            if (!q65.getText().equals("4")) { error = 1;}
            if (!q66.getText().equals("9")) { error = 1;}
            if (!q68.getText().equals("6")) { error = 1;}
            if (!q71.getText().equals("6")) { error = 1;}
            if (!q74.getText().equals("9")) { error = 1;}
            if (!q75.getText().equals("8")) { error = 1;}
            if (!q78.getText().equals("7")) { error = 1;}
            if (!q79.getText().equals("4")) { error = 1;}
            if (!q81.getText().equals("7")) { error = 1;}
            if (!q82.getText().equals("8")) { error = 1;}
            if (!q83.getText().equals("1")) { error = 1;}
            if (!q84.getText().equals("3")) { error = 1;}
            if (!q85.getText().equals("4")) { error = 1;}
            if (!q86.getText().equals("5")) { error = 1;}
            if (!q88.getText().equals("6")) { error = 1;}
            if (!q91.getText().equals("3")) { error = 1;}
            if (!q93.getText().equals("4")) { error = 1;}
            if (!q94.getText().equals("2")) { error = 1;}
            if (!q95.getText().equals("7")) { error = 1;}
            if (!q96.getText().equals("6")) { error = 1;}
            if (!q97.getText().equals("8")) { error = 1;}
            if (!q98.getText().equals("1")) { error = 1;}
        }

        attempts = 1;
    }
}


class gameBoard extends JPanel {    //Background for every other frame
    private BufferedImage pic = null;
    public gameBoard() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
        
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //Sudoku board variables
        int baseHori = 120;
        int baseVert = 30;
        int squareOffset = 120;
        int largeLength = 360;
        int lineOffset = 40;
        
        //Create background
        try{
            pic = ImageIO.read(new File("src\\test.jpg"));  //Background image
        }catch(IOException e){}
        g.drawImage(pic, 1, 1, 600, 400, this);
        
        try{
            pic = ImageIO.read(new File("src\\white.png"));  //Background image
        }catch(IOException e){}
        g.drawImage(pic, baseHori, baseVert, 360, 360, this);
        
        //Draw the 9 mini squares
        g.setColor(Color.BLUE);
        g.drawRect(baseHori, baseVert, largeLength/3, largeLength/3);
        g.drawRect(baseHori + squareOffset, baseVert, largeLength/3, largeLength/3);
        g.drawRect(baseHori + 2*squareOffset, baseVert, largeLength/3, largeLength/3);
        g.drawRect(baseHori, baseVert + squareOffset, largeLength/3, largeLength/3);
        g.drawRect(baseHori + squareOffset, baseVert + squareOffset, largeLength/3, largeLength/3);
        g.drawRect(baseHori + 2*squareOffset, baseVert + squareOffset, largeLength/3, largeLength/3);
        g.drawRect(baseHori, baseVert + 2*squareOffset, largeLength/3, largeLength/3);
        g.drawRect(baseHori + squareOffset, baseVert + 2*squareOffset, largeLength/3, largeLength/3);
        g.drawRect(baseHori + 2*squareOffset, baseVert + 2*squareOffset, largeLength/3, largeLength/3);
        //Draw the large square
        g.setColor(Color.BLACK);
        g.drawRect(baseHori, baseVert, largeLength, largeLength);
        //Draw vertical lines
        g.drawLine(baseHori + lineOffset, baseVert, baseHori + lineOffset, largeLength + baseVert);
        g.drawLine(baseHori + 2*lineOffset, baseVert, baseHori + 2*lineOffset, largeLength + baseVert);
        g.drawLine(baseHori + 4*lineOffset, baseVert, baseHori + 4*lineOffset, largeLength + baseVert);
        g.drawLine(baseHori + 5*lineOffset, baseVert, baseHori + 5*lineOffset, largeLength + baseVert);
        g.drawLine(baseHori + 7*lineOffset, baseVert, baseHori + 7*lineOffset, largeLength + baseVert);
        g.drawLine(baseHori + 8*lineOffset, baseVert, baseHori + 8*lineOffset, largeLength + baseVert);
        //Draw horizontal Lines
        g.drawLine(baseHori, baseVert + lineOffset, largeLength + baseHori, baseVert + lineOffset);
        g.drawLine(baseHori, baseVert + 2*lineOffset, largeLength + baseHori, baseVert + 2*lineOffset);
        g.drawLine(baseHori, baseVert + 4*lineOffset, largeLength + baseHori, baseVert + 4*lineOffset);
        g.drawLine(baseHori, baseVert + 5*lineOffset, largeLength + baseHori, baseVert + 5*lineOffset);
        g.drawLine(baseHori, baseVert + 7*lineOffset, largeLength + baseHori, baseVert + 7*lineOffset);
        g.drawLine(baseHori, baseVert + 8*lineOffset, largeLength + baseHori, baseVert + 8*lineOffset);
    }
}