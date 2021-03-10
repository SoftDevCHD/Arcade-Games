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
    private static JTextField q12;
    private static JTextField q13;
    private static JTextField q14;
    private static JTextField q15;
    private static JTextField q16;
    private static JTextField q17;
    private static JTextField q19;
    private static JTextField q22;
    private static JTextField q28;
    private static JTextField q24;
    private static JTextField q25;
    private static JTextField q26;
    private static JTextField q27;
    private static JTextField q29;
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
    
    private static boolean b12 = true;
    private static boolean b13 = true;
    private static boolean b14 = true;
    private static boolean b15 = true;
    private static boolean b16 = true;
    private static boolean b17 = true;
    private static boolean b19 = true;
    private static boolean b22 = true;
    private static boolean b24 = true;
    private static boolean b25 = true;
    private static boolean b26 = true;
    private static boolean b27 = true;
    private static boolean b28 = true;
    private static boolean b29 = true;
    private static boolean b31 = true;
    private static boolean b32 = true;
    private static boolean b35 = true;
    private static boolean b36 = true;
    private static boolean b39 = true;
    private static boolean b42 = true;
    private static boolean b44 = true;
    private static boolean b45 = true;
    private static boolean b46 = true;
    private static boolean b47 = true;
    private static boolean b51 = true;
    private static boolean b53 = true;
    private static boolean b54 = true;
    private static boolean b56 = true;
    private static boolean b57 = true;
    private static boolean b59 = true;
    private static boolean b63 = true;
    private static boolean b64 = true;
    private static boolean b65 = true;
    private static boolean b66 = true;
    private static boolean b68 = true;
    private static boolean b71 = true;
    private static boolean b74 = true;
    private static boolean b75 = true;
    private static boolean b78 = true;
    private static boolean b79 = true;
    private static boolean b81 = true;
    private static boolean b82 = true;
    private static boolean b83 = true;
    private static boolean b84 = true;
    private static boolean b85 = true;
    private static boolean b86 = true;
    private static boolean b88 = true;
    private static boolean b91 = true;
    private static boolean b93 = true;
    private static boolean b94 = true;
    private static boolean b95 = true;
    private static boolean b96 = true;
    private static boolean b97 = true;
    private static boolean b98 = true;
    
    private static boolean e12 = true;
    private static boolean e13 = true;
    private static boolean e14 = true;
    private static boolean e15 = true;
    private static boolean e16 = true;
    private static boolean e17 = true;
    private static boolean e19 = true;
    private static boolean e22 = true;
    private static boolean e24 = true;
    private static boolean e25 = true;
    private static boolean e26 = true;
    private static boolean e27 = true;
    private static boolean e28 = true;
    private static boolean e29 = true;
    private static boolean e31 = true;
    private static boolean e32 = true;
    private static boolean e35 = true;
    private static boolean e36 = true;
    private static boolean e39 = true;
    private static boolean e42 = true;
    private static boolean e44 = true;
    private static boolean e45 = true;
    private static boolean e46 = true;
    private static boolean e47 = true;
    private static boolean e51 = true;
    private static boolean e53 = true;
    private static boolean e54 = true;
    private static boolean e56 = true;
    private static boolean e57 = true;
    private static boolean e59 = true;
    private static boolean e63 = true;
    private static boolean e64 = true;
    private static boolean e65 = true;
    private static boolean e66 = true;
    private static boolean e68 = true;
    private static boolean e71 = true;
    private static boolean e74 = true;
    private static boolean e75 = true;
    private static boolean e78 = true;
    private static boolean e79 = true;
    private static boolean e81 = true;
    private static boolean e82 = true;
    private static boolean e83 = true;
    private static boolean e84 = true;
    private static boolean e85 = true;
    private static boolean e86 = true;
    private static boolean e88 = true;
    private static boolean e91 = true;
    private static boolean e93 = true;
    private static boolean e94 = true;
    private static boolean e95 = true;
    private static boolean e96 = true;
    private static boolean e97 = true;
    private static boolean e98 = true;


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
        
        //This is here so that the game can be replayed if you click retry from gameOverScreen
        error = 0;
        sudokuScore = 540;
        b12 = true;
        b13 = true;
        b14 = true;
        b15 = true;
        b16 = true;
        b17 = true;
        b19 = true;
        b22 = true;
        b24 = true;
        b25 = true;
        b26 = true;
        b27 = true;
        b28 = true;
        b29 = true;
        b31 = true;
        b32 = true;
        b35 = true;
        b36 = true;
        b39 = true;
        b42 = true;
        b44 = true;
        b45 = true;
        b46 = true;
        b47 = true;
        b51 = true;
        b53 = true;
        b54 = true;
        b56 = true;
        b57 = true;
        b59 = true;
        b63 = true;
        b64 = true;
        b65 = true;
        b66 = true;
        b68 = true;
        b71 = true;
        b74 = true;
        b75 = true;
        b78 = true;
        b79 = true;
        b81 = true;
        b82 = true;
        b83 = true;
        b84 = true;
        b85 = true;
        b86 = true;
        b88 = true;
        b91 = true;
        b93 = true;
        b94 = true;
        b95 = true;
        b96 = true;
        b97 = true;
        b98 = true;


        
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
        q12 = new JTextField(1);
        q13 = new JTextField(1);
        q14 = new JTextField(1);
        q15 = new JTextField(1);
        q16 = new JTextField(1);
        q17 = new JTextField(1);
        q19 = new JTextField(1);
        q22 = new JTextField(1);
        q28 = new JTextField(1);
        q24 = new JTextField(1);
        q25 = new JTextField(1);
        q26 = new JTextField(1);
        q27 = new JTextField(1);
        q29 = new JTextField(1);
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
        q12.setBounds(baseHori + lineOffset + textOffset, baseVert + textOffset, textboxSize, textboxSize);
        q13.setBounds(baseHori + 2*lineOffset + textOffset, baseVert + textOffset, textboxSize, textboxSize);
        q14.setBounds(baseHori + textOffset, baseVert + lineOffset + textOffset, textboxSize, textboxSize);
        q15.setBounds(baseHori + lineOffset + textOffset, baseVert + lineOffset + textOffset, textboxSize, textboxSize);
        q16.setBounds(baseHori + 2*lineOffset + textOffset, baseVert + lineOffset + textOffset, textboxSize, textboxSize);
        q17.setBounds(baseHori + textOffset, baseVert + 2*lineOffset + textOffset, textboxSize, textboxSize);
        q19.setBounds(baseHori + 2*lineOffset + textOffset, baseVert + 2*lineOffset + textOffset, textboxSize, textboxSize);
        q22.setBounds(baseHori + squareOffset + lineOffset + textOffset, baseVert + textOffset, textboxSize, textboxSize);
        q24.setBounds(baseHori + squareOffset + textOffset, baseVert + lineOffset + textOffset, textboxSize, textboxSize);
        q25.setBounds(baseHori + squareOffset + lineOffset + textOffset, baseVert + lineOffset + textOffset, textboxSize, textboxSize);
        q26.setBounds(baseHori + squareOffset + 2*lineOffset + textOffset, baseVert + lineOffset + textOffset, textboxSize, textboxSize);
        q27.setBounds(baseHori + squareOffset + textOffset, baseVert + 2*lineOffset + textOffset, textboxSize, textboxSize);
        q28.setBounds(baseHori + squareOffset + lineOffset + textOffset, baseVert + 2*lineOffset + textOffset, textboxSize, textboxSize);
        q29.setBounds(baseHori + squareOffset + 2*lineOffset + textOffset, baseVert + 2*lineOffset + textOffset, textboxSize, textboxSize);
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
        sudoku.add(q12);
        sudoku.add(q13);
        sudoku.add(q14);
        sudoku.add(q15);
        sudoku.add(q16);
        sudoku.add(q17);
        sudoku.add(q19);
        sudoku.add(q22);
        sudoku.add(q28);
        sudoku.add(q24);
        sudoku.add(q25);
        sudoku.add(q26);
        sudoku.add(q27);
        sudoku.add(q29);
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
                if (e12 && e13 && e14 && e15 && e16 && e17 && e19 && e22 && e24 && e25 && e26 && e27 && e28 && e29 && e31 && e32 && e35 && e36 && e39 && e42 && e44 && e45 && e46 && e47
                        && e51 && e53 && e54 && e56 && e57 && e59 && e63 && e64 && e65 && e66 && e68 && e71 && e74 && e75 && e78 && e79 && e81 && e82 && e83 && e84 && e85 && e86 
                        && e88 && e91 && e93 && e94 && e95 && e96 && e97 && e98) {
                    sudoku.dispose();
                    gameOverFrame.gameOverFrame(score + sudokuScore);
                }
                else if (!e12 && !e13 && !e14 && !e15 && !e16 && !e17 && !e19 && !e22 && !e24 && !e25 && !e26 && !e27 && !e28 && !e29 && !e31 && !e32 && !e35 && !e36 && !e39 && !e42 && !e44 
                        && !e45 && !e46 && !e47 && !e51 && !e53 && !e54 && !e56 && !e57 && !e59 && !e63 && !e64 && !e65 && !e66 && !e68 && !e71 && !e74 && !e75 && !e78 && !e79 && !e81 
                        && !e82 && !e83 && !e84 && !e85 && !e86 && !e88 && !e91 && !e93 && !e94 && !e95 && !e96 && !e97 && !e98) {
                    String[] options = {"Try again", "Submit"};
                    n = JOptionPane.showOptionDialog(sudoku,
                            "You have lost all of your points. Do you still want to submit?",
                            "Incorrect Solution",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[0]);
                    
                    if (n == JOptionPane.NO_OPTION) {
                    sudoku.dispose();
                    gameOverFrame.gameOverFrame(score + sudokuScore);
                    }
                    else if (n == JOptionPane.YES_OPTION) {
                        sudoku.dispose();
                        sudokuGameFrame(score);
                    }
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
        try {
            if (
            Integer.parseInt(q12.getText()) < 1 || Integer.parseInt(q12.getText()) > 9 ||
            Integer.parseInt(q13.getText()) < 1 || Integer.parseInt(q13.getText()) > 9 ||
            Integer.parseInt(q14.getText()) < 1 || Integer.parseInt(q14.getText()) > 9 ||
            Integer.parseInt(q15.getText()) < 1 || Integer.parseInt(q15.getText()) > 9 ||
            Integer.parseInt(q16.getText()) < 1 || Integer.parseInt(q16.getText()) > 9 ||
            Integer.parseInt(q17.getText()) < 1 || Integer.parseInt(q17.getText()) > 9 ||
            Integer.parseInt(q19.getText()) < 1 || Integer.parseInt(q19.getText()) > 9 ||
            Integer.parseInt(q22.getText()) < 1 || Integer.parseInt(q22.getText()) > 9 ||
            Integer.parseInt(q28.getText()) < 1 || Integer.parseInt(q28.getText()) > 9 ||
            Integer.parseInt(q24.getText()) < 1 || Integer.parseInt(q24.getText()) > 9 ||
            Integer.parseInt(q25.getText()) < 1 || Integer.parseInt(q25.getText()) > 9 ||
            Integer.parseInt(q26.getText()) < 1 || Integer.parseInt(q26.getText()) > 9 ||
            Integer.parseInt(q27.getText()) < 1 || Integer.parseInt(q27.getText()) > 9 ||
            Integer.parseInt(q29.getText()) < 1 || Integer.parseInt(q29.getText()) > 9 ||
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
                JOptionPane.showMessageDialog(f, "Some of your values aren't between 1 and 9...", "Input Error", JOptionPane.ERROR_MESSAGE);
                integrity = false;
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(f, "Some of your boxes have invalid data", "Input Error", JOptionPane.ERROR_MESSAGE);
            integrity = false;
            return;
        }
        integrity = true;
            if (!q12.getText().equals("3")) {if(b12) {sudokuScore -= 10; error++;} b12 = false; e12 = false;}
            else if (q12.getText().equals("3")) {if(!e12) {error--; e12 = true;} e12 = true;}
            if (!q13.getText().equals("5")) {if(b13) {sudokuScore -= 10; error++;} b13 = false; e13 = false;}
            else if (q13.getText().equals("5")) {if(!e13) {error--; e13 = true;} e13 = true;}
            if (!q14.getText().equals("2")) {if(b14) {sudokuScore -= 10; error++;} b14 = false; e14 = false;}
            else if (q14.getText().equals("2")) {if(!e14) {error--; e14 = true;} e14 = true;}
            if (!q15.getText().equals("9")) {if(b15) {sudokuScore -= 10; error++;} b15 = false; e15 = false;}
            else if (q15.getText().equals("9")) {if(!e15) {error--; e15 = true;} e15 = true;}
            if (!q16.getText().equals("6")) {if(b16) {sudokuScore -= 10; error++;} b16 = false; e16 = false;}
            else if (q16.getText().equals("6")) {if(!e16) {error--; e16 = true;} e16 = true;}
            if (!q17.getText().equals("4")) {if(b17) {sudokuScore -= 10; error++;} b17 = false; e17 = false;}
            else if (q17.getText().equals("4")) {if(!e17) {error--; e17 = true;} e17 = true;}
            if (!q19.getText().equals("7")) {if(b19) {sudokuScore -= 10; error++;} b19 = false; e19 = false;}
            else if (q19.getText().equals("7")) {if(!e19) {error--; e19 = true;} e19 = true;}
            if (!q22.getText().equals("1")) {if(b22) {sudokuScore -= 10; error++;} b22 = false; e22 = false;}
            else if (q22.getText().equals("1")) {if(!e22) {error--; e22 = true;} e22 = true;}
            if (!q24.getText().equals("8")) {if(b24) {sudokuScore -= 10; error++;} b24 = false; e24 = false;}
            else if (q24.getText().equals("8")) {if(!e24) {error--; e24 = true;} e24 = true;}
            if (!q25.getText().equals("5")) {if(b25) {sudokuScore -= 10; error++;} b25 = false; e25 = false;}
            else if (q25.getText().equals("5")) {if(!e25) {error--; e25 = true;} e25 = true;}
            if (!q26.getText().equals("7")) {if(b26) {sudokuScore -= 10; error++;} b26 = false; e26 = false;}
            else if (q26.getText().equals("7")) {if(!e26) {error--; e26 = true;} e26 = true;}
            if (!q27.getText().equals("2")) {if(b27) {sudokuScore -= 10; error++;} b27 = false; e27 = false;}
            else if (q27.getText().equals("2")) {if(!e27) {error--; e27 = true;} e27 = true;}
            if (!q28.getText().equals("9")) {if(b28) {sudokuScore -= 10; error++;} b28 = false; e28 = false;}
            else if (q28.getText().equals("9")) {if(!e28) {error--; e28 = true;} e28 = true;}
            if (!q29.getText().equals("3")) {if(b29) {sudokuScore -= 10; error++;} b29 = false; e29 = false;}
            else if (q29.getText().equals("3")) {if(!e29) {error--; e29 = true;} e29 = true;}
            if (!q31.getText().equals("9")) {if(b31) {sudokuScore -= 10; error++;} b31 = false; e31 = false;}
            else if (q31.getText().equals("9")) {if(!e31) {error--; e31 = true;} e31 = true;}
            if (!q32.getText().equals("2")) {if(b32) {sudokuScore -= 10; error++;} b32 = false; e32 = false;}
            else if (q32.getText().equals("2")) {if(!e32) {error--; e32 = true;} e32 = true;}
            if (!q35.getText().equals("3")) {if(b35) {sudokuScore -= 10; error++;} b35 = false; e35 = false;}
            else if (q35.getText().equals("3")) {if(!e35) {error--; e35 = true;} e35 = true;}
            if (!q36.getText().equals("1")) {if(b36) {sudokuScore -= 10; error++;} b36 = false; e36 = false;}
            else if (q36.getText().equals("1")) {if(!e36) {error--; e36 = true;} e36 = true;}
            if (!q39.getText().equals("8")) {if(b39) {sudokuScore -= 10; error++;} b39 = false; e39 = false;}
            else if (q39.getText().equals("8")) {if(!e39) {error--; e39 = true;} e39 = true;}
            if (!q42.getText().equals("6")) {if(b42) {sudokuScore -= 10; error++;} b42 = false; e42 = false;}
            else if (q42.getText().equals("6")) {if(!e42) {error--; e42 = true;} e42 = true;}
            if (!q44.getText().equals("1")) {if(b44) {sudokuScore -= 10; error++;} b44 = false; e44 = false;}
            else if (q44.getText().equals("1")) {if(!e44) {error--; e44 = true;} e44 = true;}
            if (!q45.getText().equals("2")) {if(b45) {sudokuScore -= 10; error++;} b45 = false; e45 = false;}
            else if (q45.getText().equals("2")) {if(!e45) {error--; e45 = true;} e45 = true;}
            if (!q46.getText().equals("3")) {if(b46) {sudokuScore -= 10; error++;} b46 = false; e46 = false;}
            else if (q46.getText().equals("3")) {if(!e46) {error--; e46 = true;} e46 = true;}
            if (!q47.getText().equals("7")) {if(b47) {sudokuScore -= 10; error++;} b47 = false; e47 = false;}
            else if (q47.getText().equals("7")) {if(!e47) {error--; e47 = true;} e47 = true;}
            if (!q51.getText().equals("1")) {if(b51) {sudokuScore -= 10; error++;} b51 = false; e51 = false;}
            else if (q51.getText().equals("1")) {if(!e51) {error--; e51 = true;} e51 = true;}
            if (!q53.getText().equals("4")) {if(b53) {sudokuScore -= 10; error++;} b53 = false; e53 = false;}
            else if (q53.getText().equals("4")) {if(!e53) {error--; e53 = true;} e53 = true;}
            if (!q54.getText().equals("6")) {if(b54) {sudokuScore -= 10; error++;} b54 = false; e54 = false;}
            else if (q54.getText().equals("6")) {if(!e54) {error--; e54 = true;} e54 = true;}
            if (!q56.getText().equals("8")) {if(b56) {sudokuScore -= 10; error++;} b56 = false; e56 = false;}
            else if (q56.getText().equals("8")) {if(!e56) {error--; e56 = true;} e56 = true;}
            if (!q57.getText().equals("5")) {if(b57) {sudokuScore -= 10; error++;} b57 = false; e57 = false;}
            else if (q57.getText().equals("5")) {if(!e57) {error--; e57 = true;} e57 = true;}
            if (!q59.getText().equals("9")) {if(b59) {sudokuScore -= 10; error++;} b59 = false; e59 = false;}
            else if (q59.getText().equals("9")) {if(!e59) {error--; e59 = true;} e59 = true;}
            if (!q63.getText().equals("2")) {if(b63) {sudokuScore -= 10; error++;} b63 = false; e63 = false;}
            else if (q63.getText().equals("2")) {if(!e63) {error--; e63 = true;} e63 = true;}
            if (!q64.getText().equals("5")) {if(b64) {sudokuScore -= 10; error++;} b64 = false; e64 = false;}
            else if (q64.getText().equals("5")) {if(!e64) {error--; e64 = true;} e64 = true;}
            if (!q65.getText().equals("4")) {if(b65) {sudokuScore -= 10; error++;} b65 = false; e65 = false;}
            else if (q65.getText().equals("4")) {if(!e65) {error--; e65 = true;} e65 = true;}
            if (!q66.getText().equals("9")) {if(b66) {sudokuScore -= 10; error++;} b66 = false; e66 = false;}
            else if (q66.getText().equals("9")) {if(!e66) {error--; e66 = true;} e66 = true;}
            if (!q68.getText().equals("6")) {if(b68) {sudokuScore -= 10; error++;} b68 = false; e68 = false;}
            else if (q68.getText().equals("6")) {if(!e68) {error--; e68 = true;} e68 = true;}
            if (!q71.getText().equals("6")) {if(b71) {sudokuScore -= 10; error++;} b71 = false; e71 = false;}
            else if (q71.getText().equals("6")) {if(!e71) {error--; e71 = true;} e71 = true;}
            if (!q74.getText().equals("9")) {if(b74) {sudokuScore -= 10; error++;} b74 = false; e74 = false;}
            else if (q74.getText().equals("9")) {if(!e74) {error--; e74 = true;} e64 = true;}
            if (!q75.getText().equals("8")) {if(b75) {sudokuScore -= 10; error++;} b75 = false; e75 = false;}
            else if (q75.getText().equals("8")) {if(!e75) {error--; e75 = true;} e75 = true;}
            if (!q78.getText().equals("7")) {if(b78) {sudokuScore -= 10; error++;} b78 = false; e78 = false;}
            else if (q78.getText().equals("7")) {if(!e78) {error--; e78 = true;} e78 = true;}
            if (!q79.getText().equals("4")) {if(b79) {sudokuScore -= 10; error++;} b79 = false; e79 = false;}
            else if (q79.getText().equals("4")) {if(!e79) {error--; e79 = true;} e79 = true;}
            if (!q81.getText().equals("7")) {if(b81) {sudokuScore -= 10; error++;} b81 = false; e81 = false;}
            else if (q81.getText().equals("7")) {if(!e81) {error--; e81 = true;} e81 = true;}
            if (!q82.getText().equals("8")) {if(b82) {sudokuScore -= 10; error++;} b82 = false; e82 = false;}
            else if (q82.getText().equals("8")) {if(!e82) {error--; e82 = true;} e82 = true;}
            if (!q83.getText().equals("1")) {if(b83) {sudokuScore -= 10; error++;} b83 = false; e83 = false;}
            else if (q83.getText().equals("1")) {if(!e83) {error--; e83 = true;} e83 = true;}
            if (!q84.getText().equals("3")) {if(b84) {sudokuScore -= 10; error++;} b84 = false; e84 = false;}
            else if (q84.getText().equals("3")) {if(!e84) {error--; e84 = true;} e84 = true;}
            if (!q85.getText().equals("4")) {if(b85) {sudokuScore -= 10; error++;} b85 = false; e85 = false;}
            else if (q85.getText().equals("4")) {if(!e85) {error--; e85 = true;} e85 = true;}
            if (!q86.getText().equals("5")) {if(b86) {sudokuScore -= 10; error++;} b86 = false; e86 = false;}
            else if (q86.getText().equals("5")) {if(!e86) {error--; e86 = true;} e86 = true;}
            if (!q88.getText().equals("6")) {if(b88) {sudokuScore -= 10; error++;} b88 = false; e88 = false;}
            else if (q88.getText().equals("6")) {if(!e88) {error--; e88 = true;} e88 = true;}
            if (!q91.getText().equals("3")) {if(b91) {sudokuScore -= 10; error++;} b91 = false; e91 = false;}
            else if (q91.getText().equals("3")) {if(!e91) {error--; e91 = true;} e91 = true;}
            if (!q93.getText().equals("4")) {if(b93) {sudokuScore -= 10; error++;} b93 = false; e93 = false;}
            else if (q93.getText().equals("4")) {if(!e93) {error--; e93 = true;} e93 = true;}
            if (!q94.getText().equals("2")) {if(b94) {sudokuScore -= 10; error++;} b94 = false; e94 = false;}
            else if (q94.getText().equals("2")) {if(!e94) {error--; e94 = true;} e94 = true;}
            if (!q95.getText().equals("7")) {if(b95) {sudokuScore -= 10; error++;} b95 = false; e95 = false;}
            else if (q95.getText().equals("7")) {if(!e95) {error--; e95 = true;} e95 = true;}
            if (!q96.getText().equals("6")) {if(b96) {sudokuScore -= 10; error++;} b96 = false; e96 = false;}
            else if (q96.getText().equals("6")) {if(!e96) {error--; e96 = true;} e96 = true;}
            if (!q97.getText().equals("8")) {if(b97) {sudokuScore -= 10; error++;} b97 = false; e97 = false;}
            else if (q97.getText().equals("8")) {if(!e97) {error--; e97 = true;} e97 = true;}
            if (!q98.getText().equals("1")) {if(b98) {sudokuScore -= 10; error++;} b98 = false; e98 = false;}
            else if (q98.getText().equals("1")) {if(!e98) {error--; e98 = true;} e98 = true;}

            //Format if statements as if (!q98.getText().equals("1")) {if(b98) {sudokuScore -= 10;} b98 = false; e98 = false; error++;}
            //Remember to reset booleans in main function so you can retry, and program "try again" button for if sudoku is completeley wrong (It will be easier to just reload the page)
        System.out.println(error);
        System.out.println(sudokuScore);
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
        
        //paints thicker lines for mini squares
        Graphics2D g2 = (Graphics2D) g;
        
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
        //Draw the 9 mini squares thicker
        g2.setStroke(new BasicStroke(2));
        g.setColor(Color.BLACK);
        g.drawRect(baseHori, baseVert, largeLength/3, largeLength/3);
        g.drawRect(baseHori + squareOffset, baseVert, largeLength/3, largeLength/3);
        g.drawRect(baseHori + 2*squareOffset, baseVert, largeLength/3, largeLength/3);
        g.drawRect(baseHori, baseVert + squareOffset, largeLength/3, largeLength/3);
        g.drawRect(baseHori + squareOffset, baseVert + squareOffset, largeLength/3, largeLength/3);
        g.drawRect(baseHori + 2*squareOffset, baseVert + squareOffset, largeLength/3, largeLength/3);
        g.drawRect(baseHori, baseVert + 2*squareOffset, largeLength/3, largeLength/3);
        g.drawRect(baseHori + squareOffset, baseVert + 2*squareOffset, largeLength/3, largeLength/3);
        g.drawRect(baseHori + 2*squareOffset, baseVert + 2*squareOffset, largeLength/3, largeLength/3);
    }
}