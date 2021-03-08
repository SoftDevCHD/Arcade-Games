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
        JTextField q11 = new JTextField(1);
        JTextField q12 = new JTextField(1);
        JTextField q13 = new JTextField(1);
        JTextField q14 = new JTextField(1);
        JTextField q15 = new JTextField(1);
        JTextField q16 = new JTextField(1);
        JTextField q17 = new JTextField(1);
        JTextField q21 = new JTextField(1);
        JTextField q22 = new JTextField(1);
        JTextField q23 = new JTextField(1);
        JTextField q24 = new JTextField(1);
        JTextField q25 = new JTextField(1);
        JTextField q26 = new JTextField(1);
        JTextField q27 = new JTextField(1);
        JTextField q31 = new JTextField(1);
        JTextField q32 = new JTextField(1);
        JTextField q35 = new JTextField(1);
        JTextField q36 = new JTextField(1);
        JTextField q39 = new JTextField(1);
        JTextField q42 = new JTextField(1);
        JTextField q44 = new JTextField(1);
        JTextField q45 = new JTextField(1);
        JTextField q46 = new JTextField(1);
        JTextField q47 = new JTextField(1);
        JTextField q51 = new JTextField(1);
        JTextField q53 = new JTextField(1);
        JTextField q54 = new JTextField(1);
        JTextField q56 = new JTextField(1);
        JTextField q57 = new JTextField(1);
        JTextField q59 = new JTextField(1);
        JTextField q63 = new JTextField(1);
        JTextField q64 = new JTextField(1);
        JTextField q65 = new JTextField(1);
        JTextField q66 = new JTextField(1);
        JTextField q68 = new JTextField(1);
        JTextField q71 = new JTextField(1);
        JTextField q74 = new JTextField(1);
        JTextField q75 = new JTextField(1);
        JTextField q78 = new JTextField(1);
        JTextField q79 = new JTextField(1);
        JTextField q81 = new JTextField(1);
        JTextField q82 = new JTextField(1);
        JTextField q83 = new JTextField(1);
        JTextField q84 = new JTextField(1);
        JTextField q85 = new JTextField(1);
        JTextField q86 = new JTextField(1);
        JTextField q88 = new JTextField(1);
        JTextField q91 = new JTextField(1);
        JTextField q93 = new JTextField(1);
        JTextField q94 = new JTextField(1);
        JTextField q95 = new JTextField(1);
        JTextField q96 = new JTextField(1);
        JTextField q97 = new JTextField(1);
        JTextField q98 = new JTextField(1);
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
        
        //sudoku.add(board);
        sudoku.add(g);
        sudoku.pack();
        sudoku.setVisible(true);
        sudoku.setLocationRelativeTo(null);
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
        g.setColor(Color.RED);
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