
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.Timer;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Clare
 */
public class colorGameFrame extends javax.swing.JFrame{

    private static int rounds;
    private static int score = 0;
    
    private static int overlapCounter = 1;
    private static int noOverlap1 = -1;
    private static int noOverlap2 = -1;
    private static int noOverlap3 = -1;
    private static int noOverlap4 = -1;
    private static int noOverlap5 = -1;
    
    // Creating random number generator for text and buttons colors
    private static Random rand;
    private static int random_text_color;
    private static int random_button_color;
    
    /**
     * Creates new form colorGameFrame
     */
    public colorGameFrame() {
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
            java.util.logging.Logger.getLogger(colorGameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(colorGameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(colorGameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(colorGameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new colorGameFrame().setVisible(true);
            }
        });
    }
    

    public static void colorGameFrame(int oldScore) {
        JFrame colorGame = new JFrame("Color Game"); //Creates frame
        colorGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        overlapCounter = 1;
        
        rounds = 5;
        score = oldScore;
        rand = new Random();
        random_text_color = rand.nextInt(5) + 1;
        random_button_color = rand.nextInt(5) + 1;
        
        basic g = new basic();
        
        //Default button dimensions
        int width = 100;
        int height = 100;
        
        //Setting actual button and label positions
        int button1_position = getButtonPosition();
        int button2_position = getButtonPosition();
        int button3_position = getButtonPosition();
        int button4_position = getButtonPosition();
        int button5_position = getButtonPosition();
        int colorLabel_position = getButtonPosition();
        
        //Set label length
        int labelLength = 100;
        
        //Creating score label
        int score_horiOffset = 20;
        int score_vertOffset = 20;
        JLabel displayScore = new JLabel("Score: " + score);
        displayScore.setFont(new Font("Verdana", Font.BOLD, 14));
        displayScore.setForeground(Color.blue);
        displayScore.setBounds(10, 50, 90, 50);
        
        //Create killbind keybind
        colorGame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "EXIT");
        colorGame.getRootPane().getActionMap().put("EXIT", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
            colorGame.dispose();
            System.exit(0);
            }
        });
        
        //KeyBindings: Popup
        colorGame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"), "POPUP");
        colorGame.getRootPane().getActionMap().put("POPUP", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                popup.popWindow();
            }
        });
        
        //Get a random color for label
        JLabel color = new JLabel(setLabelText());
        switch(random_text_color) {
            case 1: color.setForeground(Color.BLUE);
            case 2: color.setForeground(Color.GREEN);
            case 3: color.setForeground(Color.RED);
            case 4: color.setForeground(Color.YELLOW);
            case 5: color.setForeground(Color.PINK);
        }

        color.setFont(new Font("Verdana", Font.BOLD, 18));
        Dimension size = color.getPreferredSize();
        color.setBounds(buttonPositionX(colorLabel_position), buttonPositionY(colorLabel_position), labelLength, size.height);
        
        //Size for all buttons
        int button_size_r = 50;
        
        JButton button1 = new JButton();
        JButton button2 = new JButton();
        JButton button3 = new JButton();
        JButton button4 = new JButton();
        JButton button5 = new JButton();
        
        button1.setToolTipText("Select this color");
        button2.setToolTipText("Select this color");
        button3.setToolTipText("Select this color");
        button4.setToolTipText("Select this color");
        button5.setToolTipText("Select this color");

        
        switch(random_button_color) {
            case 1: button1.setBackground(Color.BLUE);
                    button2.setBackground(Color.GREEN);
                    button3.setBackground(Color.RED);
                    button4.setBackground(Color.YELLOW);
                    button5.setBackground(Color.PINK);
            case 2: button1.setBackground(Color.GREEN);
                    button2.setBackground(Color.RED);
                    button3.setBackground(Color.YELLOW);
                    button4.setBackground(Color.PINK);
                    button5.setBackground(Color.BLUE);
            case 3: button1.setBackground(Color.RED);
                    button2.setBackground(Color.YELLOW);
                    button3.setBackground(Color.PINK);
                    button4.setBackground(Color.BLUE);
                    button5.setBackground(Color.GREEN);
            case 4: button1.setBackground(Color.YELLOW);
                    button2.setBackground(Color.PINK);
                    button3.setBackground(Color.BLUE);
                    button4.setBackground(Color.GREEN);
                    button5.setBackground(Color.RED);
            case 5: button1.setBackground(Color.PINK);
                    button2.setBackground(Color.BLUE);
                    button3.setBackground(Color.GREEN);
                    button4.setBackground(Color.RED);
                    button5.setBackground(Color.YELLOW);
        }
        
        button1.setBounds(buttonPositionX(button1_position), buttonPositionY(button1_position), button_size_r, button_size_r);
        button1.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button1.setBackground(button1.getBackground());
            }
            public void mouseExited(MouseEvent e) {
                button1.setBackground(button1.getBackground());
            }
        });
        button1.addActionListener(new ActionListener() {   //Adds action listeners to button
            public void actionPerformed(ActionEvent e) {
                if (button1.getBackground().equals(color.getForeground())) {
                    score += 100;
                    System.out.println("Sucess");
                }
                    
                if (--rounds == 0) {
                    sudokuGameFrame.sudokuGameFrame(score);
                    colorGame.dispose();
                }
                
                displayScore.setText("Score: " + score);
                
                overlapCounter = 1;
                random_text_color = rand.nextInt(5) + 1;
                random_button_color = rand.nextInt(5) + 1;
                
                color.setText(setLabelText());
        
                switch(random_text_color) {
                    case 1: color.setForeground(Color.BLUE);
                    break;
                    case 2: color.setForeground(Color.GREEN);
                    break;
                    case 3: color.setForeground(Color.RED);
                    break;
                    case 4: color.setForeground(Color.YELLOW);
                    break;
                    case 5: color.setForeground(Color.PINK);
                    break;
                }
                
                switch(random_button_color) {
                    case 1: button1.setBackground(Color.BLUE);
                            button2.setBackground(Color.GREEN);
                            button3.setBackground(Color.RED);
                            button4.setBackground(Color.YELLOW);
                            button5.setBackground(Color.PINK);
                    case 2: button1.setBackground(Color.GREEN);
                            button2.setBackground(Color.RED);
                            button3.setBackground(Color.YELLOW);
                            button4.setBackground(Color.PINK);
                            button5.setBackground(Color.BLUE);
                    case 3: button1.setBackground(Color.RED);
                            button2.setBackground(Color.YELLOW);
                            button3.setBackground(Color.PINK);
                            button4.setBackground(Color.BLUE);
                            button5.setBackground(Color.GREEN);
                    case 4: button1.setBackground(Color.YELLOW);
                            button2.setBackground(Color.PINK);
                            button3.setBackground(Color.BLUE);
                            button4.setBackground(Color.GREEN);
                            button5.setBackground(Color.RED);
                    case 5: button1.setBackground(Color.PINK);
                            button2.setBackground(Color.BLUE);
                            button3.setBackground(Color.GREEN);
                            button4.setBackground(Color.RED);
                            button5.setBackground(Color.YELLOW);
                }
                
                int button1_positionRedo = getButtonPosition();
                int button2_positionRedo = getButtonPosition();
                int button3_positionRedo = getButtonPosition();
                int button4_positionRedo = getButtonPosition();
                int button5_positionRedo = getButtonPosition();
                int colorLabel_positionRedo = getButtonPosition();
                
                button1.setBounds(buttonPositionX(button1_positionRedo), buttonPositionY(button1_positionRedo), button_size_r, button_size_r);
                button2.setBounds(buttonPositionX(button2_positionRedo), buttonPositionY(button2_positionRedo), button_size_r, button_size_r);
                button3.setBounds(buttonPositionX(button3_positionRedo), buttonPositionY(button3_positionRedo), button_size_r, button_size_r);
                button4.setBounds(buttonPositionX(button4_positionRedo), buttonPositionY(button4_positionRedo), button_size_r, button_size_r);
                button5.setBounds(buttonPositionX(button5_positionRedo), buttonPositionY(button5_positionRedo), button_size_r, button_size_r);
                color.setBounds(buttonPositionX(colorLabel_positionRedo), buttonPositionY(colorLabel_positionRedo), labelLength, size.height);
            }
        });
        
        
        button2.setBounds(buttonPositionX(button2_position), buttonPositionY(button2_position), button_size_r, button_size_r);
        button2.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button2.setBackground(button2.getBackground());
            }
            public void mouseExited(MouseEvent e) {
                button2.setBackground(button2.getBackground());
            }
        });
        button2.addActionListener(new ActionListener() {   //Adds action listeners to button
            public void actionPerformed(ActionEvent e) {
               if (button2.getBackground().equals(color.getForeground())) {
                    score += 100;
                    System.out.println("Success");
               }
               
                if (--rounds == 0) {
                    sudokuGameFrame.sudokuGameFrame(score);
                    colorGame.dispose();
                }
                
                displayScore.setText("Score: " + score);
                
                overlapCounter = 1;
                random_text_color = rand.nextInt(5) + 1;
                random_button_color = rand.nextInt(5) + 1;
                
                color.setText(setLabelText());
        
                switch(random_text_color) {
                    case 1: color.setForeground(Color.BLUE);
                    break;
                    case 2: color.setForeground(Color.GREEN);
                    break;
                    case 3: color.setForeground(Color.RED);
                    break;
                    case 4: color.setForeground(Color.YELLOW);
                    break;
                    case 5: color.setForeground(Color.PINK);
                    break;
                }
                
                switch(random_button_color) {
                    case 1: button1.setBackground(Color.BLUE);
                            button2.setBackground(Color.GREEN);
                            button3.setBackground(Color.RED);
                            button4.setBackground(Color.YELLOW);
                            button5.setBackground(Color.PINK);
                    case 2: button1.setBackground(Color.GREEN);
                            button2.setBackground(Color.RED);
                            button3.setBackground(Color.YELLOW);
                            button4.setBackground(Color.PINK);
                            button5.setBackground(Color.BLUE);
                    case 3: button1.setBackground(Color.RED);
                            button2.setBackground(Color.YELLOW);
                            button3.setBackground(Color.PINK);
                            button4.setBackground(Color.BLUE);
                            button5.setBackground(Color.GREEN);
                    case 4: button1.setBackground(Color.YELLOW);
                            button2.setBackground(Color.PINK);
                            button3.setBackground(Color.BLUE);
                            button4.setBackground(Color.GREEN);
                            button5.setBackground(Color.RED);
                    case 5: button1.setBackground(Color.PINK);
                            button2.setBackground(Color.BLUE);
                            button3.setBackground(Color.GREEN);
                            button4.setBackground(Color.RED);
                            button5.setBackground(Color.YELLOW);
                }
                
                int button1_positionRedo = getButtonPosition();
                int button2_positionRedo = getButtonPosition();
                int button3_positionRedo = getButtonPosition();
                int button4_positionRedo = getButtonPosition();
                int button5_positionRedo = getButtonPosition();
                int colorLabel_positionRedo = getButtonPosition();
                
                button1.setBounds(buttonPositionX(button1_positionRedo), buttonPositionY(button1_positionRedo), button_size_r, button_size_r);
                button2.setBounds(buttonPositionX(button2_positionRedo), buttonPositionY(button2_positionRedo), button_size_r, button_size_r);
                button3.setBounds(buttonPositionX(button3_positionRedo), buttonPositionY(button3_positionRedo), button_size_r, button_size_r);
                button4.setBounds(buttonPositionX(button4_positionRedo), buttonPositionY(button4_positionRedo), button_size_r, button_size_r);
                button5.setBounds(buttonPositionX(button5_positionRedo), buttonPositionY(button5_positionRedo), button_size_r, button_size_r);
                color.setBounds(buttonPositionX(colorLabel_positionRedo), buttonPositionY(colorLabel_positionRedo), labelLength, size.height);
            }
        });
        
        
        button3.setBounds(buttonPositionX(button3_position), buttonPositionY(button3_position), button_size_r, button_size_r);
        button3.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button3.setBackground(button3.getBackground());
            }
            public void mouseExited(MouseEvent e) {
                button3.setBackground(button3.getBackground());
            }
        });
        button3.addActionListener(new ActionListener() {   //Adds action listeners to button
            public void actionPerformed(ActionEvent e) {
                if (button3.getBackground().equals(color.getForeground())) {
                    score += 100;
                    System.out.println("Sucess");
                }
                
                if (--rounds == 0) {
                    sudokuGameFrame.sudokuGameFrame(score);
                    colorGame.dispose();
                }
                
                displayScore.setText("Score: " + score);
                
                overlapCounter = 1;
                random_text_color = rand.nextInt(5) + 1;
                random_button_color = rand.nextInt(5) + 1;
                
                color.setText(setLabelText());
        
                switch(random_text_color) {
                    case 1: color.setForeground(Color.BLUE);
                    break;
                    case 2: color.setForeground(Color.GREEN);
                    break;
                    case 3: color.setForeground(Color.RED);
                    break;
                    case 4: color.setForeground(Color.YELLOW);
                    break;
                    case 5: color.setForeground(Color.PINK);
                    break;
                }
                
                switch(random_button_color) {
                    case 1: button1.setBackground(Color.BLUE);
                            button2.setBackground(Color.GREEN);
                            button3.setBackground(Color.RED);
                            button4.setBackground(Color.YELLOW);
                            button5.setBackground(Color.PINK);
                    case 2: button1.setBackground(Color.GREEN);
                            button2.setBackground(Color.RED);
                            button3.setBackground(Color.YELLOW);
                            button4.setBackground(Color.PINK);
                            button5.setBackground(Color.BLUE);
                    case 3: button1.setBackground(Color.RED);
                            button2.setBackground(Color.YELLOW);
                            button3.setBackground(Color.PINK);
                            button4.setBackground(Color.BLUE);
                            button5.setBackground(Color.GREEN);
                    case 4: button1.setBackground(Color.YELLOW);
                            button2.setBackground(Color.PINK);
                            button3.setBackground(Color.BLUE);
                            button4.setBackground(Color.GREEN);
                            button5.setBackground(Color.RED);
                    case 5: button1.setBackground(Color.PINK);
                            button2.setBackground(Color.BLUE);
                            button3.setBackground(Color.GREEN);
                            button4.setBackground(Color.RED);
                            button5.setBackground(Color.YELLOW);
                }
                
                int button1_positionRedo = getButtonPosition();
                int button2_positionRedo = getButtonPosition();
                int button3_positionRedo = getButtonPosition();
                int button4_positionRedo = getButtonPosition();
                int button5_positionRedo = getButtonPosition();
                int colorLabel_positionRedo = getButtonPosition();
                
                button1.setBounds(buttonPositionX(button1_positionRedo), buttonPositionY(button1_positionRedo), button_size_r, button_size_r);
                button2.setBounds(buttonPositionX(button2_positionRedo), buttonPositionY(button2_positionRedo), button_size_r, button_size_r);
                button3.setBounds(buttonPositionX(button3_positionRedo), buttonPositionY(button3_positionRedo), button_size_r, button_size_r);
                button4.setBounds(buttonPositionX(button4_positionRedo), buttonPositionY(button4_positionRedo), button_size_r, button_size_r);
                button5.setBounds(buttonPositionX(button5_positionRedo), buttonPositionY(button5_positionRedo), button_size_r, button_size_r);
                color.setBounds(buttonPositionX(colorLabel_positionRedo), buttonPositionY(colorLabel_positionRedo), labelLength, size.height);
            }
        });
        
        
        button4.setBounds(buttonPositionX(button4_position), buttonPositionY(button4_position), button_size_r, button_size_r);
        button4.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button4.setBackground(button4.getBackground());
            }
            public void mouseExited(MouseEvent e) {
                button4.setBackground(button4.getBackground());
            }
        });
        button4.addActionListener(new ActionListener() {   //Adds action listeners to button
            public void actionPerformed(ActionEvent e) {
                if (button4.getBackground().equals(color.getForeground())) {
                    score += 100;
                    System.out.println("Success");
                }
                
                if (--rounds == 0) {
                    sudokuGameFrame.sudokuGameFrame(score);
                    colorGame.dispose();
                }
                
                displayScore.setText("Score: " + score);
                
                overlapCounter = 1;
                random_text_color = rand.nextInt(5) + 1;
                random_button_color = rand.nextInt(5) + 1;
                
                color.setText(setLabelText());
        
                switch(random_text_color) {
                    case 1: color.setForeground(Color.BLUE);
                    break;
                    case 2: color.setForeground(Color.GREEN);
                    break;
                    case 3: color.setForeground(Color.RED);
                    break;
                    case 4: color.setForeground(Color.YELLOW);
                    break;
                    case 5: color.setForeground(Color.PINK);
                    break;
                }
                
                switch(random_button_color) {
                    case 1: button1.setBackground(Color.BLUE);
                            button2.setBackground(Color.GREEN);
                            button3.setBackground(Color.RED);
                            button4.setBackground(Color.YELLOW);
                            button5.setBackground(Color.PINK);
                    case 2: button1.setBackground(Color.GREEN);
                            button2.setBackground(Color.RED);
                            button3.setBackground(Color.YELLOW);
                            button4.setBackground(Color.PINK);
                            button5.setBackground(Color.BLUE);
                    case 3: button1.setBackground(Color.RED);
                            button2.setBackground(Color.YELLOW);
                            button3.setBackground(Color.PINK);
                            button4.setBackground(Color.BLUE);
                            button5.setBackground(Color.GREEN);
                    case 4: button1.setBackground(Color.YELLOW);
                            button2.setBackground(Color.PINK);
                            button3.setBackground(Color.BLUE);
                            button4.setBackground(Color.GREEN);
                            button5.setBackground(Color.RED);
                    case 5: button1.setBackground(Color.PINK);
                            button2.setBackground(Color.BLUE);
                            button3.setBackground(Color.GREEN);
                            button4.setBackground(Color.RED);
                            button5.setBackground(Color.YELLOW);
                }
                
                int button1_positionRedo = getButtonPosition();
                int button2_positionRedo = getButtonPosition();
                int button3_positionRedo = getButtonPosition();
                int button4_positionRedo = getButtonPosition();
                int button5_positionRedo = getButtonPosition();
                int colorLabel_positionRedo = getButtonPosition();
                
                button1.setBounds(buttonPositionX(button1_positionRedo), buttonPositionY(button1_positionRedo), button_size_r, button_size_r);
                button2.setBounds(buttonPositionX(button2_positionRedo), buttonPositionY(button2_positionRedo), button_size_r, button_size_r);
                button3.setBounds(buttonPositionX(button3_positionRedo), buttonPositionY(button3_positionRedo), button_size_r, button_size_r);
                button4.setBounds(buttonPositionX(button4_positionRedo), buttonPositionY(button4_positionRedo), button_size_r, button_size_r);
                button5.setBounds(buttonPositionX(button5_positionRedo), buttonPositionY(button5_positionRedo), button_size_r, button_size_r);
                color.setBounds(buttonPositionX(colorLabel_positionRedo), buttonPositionY(colorLabel_positionRedo), labelLength, size.height);
            }
        });
        
        
        button5.setBounds(buttonPositionX(button5_position), buttonPositionY(button5_position), button_size_r, button_size_r);
        button5.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button5.setBackground(button5.getBackground());
            }
            public void mouseExited(MouseEvent e) {
                button5.setBackground(button5.getBackground());
            }
        });
        button5.addActionListener(new ActionListener() {   //Adds action listeners to button
            public void actionPerformed(ActionEvent e) {
                if (button5.getBackground().equals(color.getForeground())) {
                    score += 100;
                    System.out.println("Sucess");
                }
                
                if (--rounds == 0) {
                    sudokuGameFrame.sudokuGameFrame(score);
                    colorGame.dispose();
                }
                
                displayScore.setText("Score: " + score);
                
                overlapCounter = 1;
                random_text_color = rand.nextInt(5) + 1;
                random_button_color = rand.nextInt(5) + 1;
                
                color.setText(setLabelText());
        
                switch(random_text_color) {
                    case 1: color.setForeground(Color.BLUE);
                    break;
                    case 2: color.setForeground(Color.GREEN);
                    break;
                    case 3: color.setForeground(Color.RED);
                    break;
                    case 4: color.setForeground(Color.YELLOW);
                    break;
                    case 5: color.setForeground(Color.PINK);
                    break;
                }
                
                switch(random_button_color) {
                    case 1: button1.setBackground(Color.BLUE);
                            button2.setBackground(Color.GREEN);
                            button3.setBackground(Color.RED);
                            button4.setBackground(Color.YELLOW);
                            button5.setBackground(Color.PINK);
                    case 2: button1.setBackground(Color.GREEN);
                            button2.setBackground(Color.RED);
                            button3.setBackground(Color.YELLOW);
                            button4.setBackground(Color.PINK);
                            button5.setBackground(Color.BLUE);
                    case 3: button1.setBackground(Color.RED);
                            button2.setBackground(Color.YELLOW);
                            button3.setBackground(Color.PINK);
                            button4.setBackground(Color.BLUE);
                            button5.setBackground(Color.GREEN);
                    case 4: button1.setBackground(Color.YELLOW);
                            button2.setBackground(Color.PINK);
                            button3.setBackground(Color.BLUE);
                            button4.setBackground(Color.GREEN);
                            button5.setBackground(Color.RED);
                    case 5: button1.setBackground(Color.PINK);
                            button2.setBackground(Color.BLUE);
                            button3.setBackground(Color.GREEN);
                            button4.setBackground(Color.RED);
                            button5.setBackground(Color.YELLOW);
                }
                
                int button1_positionRedo = getButtonPosition();
                int button2_positionRedo = getButtonPosition();
                int button3_positionRedo = getButtonPosition();
                int button4_positionRedo = getButtonPosition();
                int button5_positionRedo = getButtonPosition();
                int colorLabel_positionRedo = getButtonPosition();
                
                button1.setBounds(buttonPositionX(button1_positionRedo), buttonPositionY(button1_positionRedo), button_size_r, button_size_r);
                button2.setBounds(buttonPositionX(button2_positionRedo), buttonPositionY(button2_positionRedo), button_size_r, button_size_r);
                button3.setBounds(buttonPositionX(button3_positionRedo), buttonPositionY(button3_positionRedo), button_size_r, button_size_r);
                button4.setBounds(buttonPositionX(button4_positionRedo), buttonPositionY(button4_positionRedo), button_size_r, button_size_r);
                button5.setBounds(buttonPositionX(button5_positionRedo), buttonPositionY(button5_positionRedo), button_size_r, button_size_r);
                color.setBounds(buttonPositionX(colorLabel_positionRedo), buttonPositionY(colorLabel_positionRedo), labelLength, size.height);
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
        
        //Adds elements to frame
        colorGame.add(clock);
        colorGame.add(button1);
        colorGame.add(button2);
        colorGame.add(button3);
        colorGame.add(button4);
        colorGame.add(button5);
        colorGame.add(color);
        colorGame.add(displayScore);
        
        //Draws background on frame and makes it visible
        colorGame.add(g);
        colorGame.pack();
        colorGame.setVisible(true);
        colorGame.setLocationRelativeTo(null);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
    public static String setLabelText() {
        int colorIndex = rand.nextInt(5) + 1;
        switch(colorIndex) {
            case 1: return "BLUE";
            case 2: return "GREEN";
            case 3: return "RED";
            case 4: return "YELLOW";
            case 5: return "PINK";
        }
        return "0";
    }
    
    public static int getButtonPosition() {
        int randomNum = rand.nextInt(20) + 1;
        boolean overlap = true;
        while (overlap) {
            if(randomNum != noOverlap1 && randomNum != noOverlap2 && randomNum != noOverlap3 && randomNum != noOverlap4 && randomNum !=noOverlap5) {
                overlap = false;
                switch (overlapCounter) {
                    case 1: 
                        noOverlap1 = randomNum;
                        break;
                    case 2: 
                        noOverlap2 = randomNum;
                        break;
                    case 3: 
                        noOverlap3 = randomNum;
                        break;
                    case 4: 
                        noOverlap4 = randomNum;
                        break;
                    case 5: 
                        noOverlap5 = randomNum;
                        break;
                }
                overlapCounter++;
                break;
            }
            else {
                randomNum = rand.nextInt(20) + 1;
            }
        }
        return randomNum;
    }
    
    public static int buttonPositionX(int index) {
        int horiInit = 50;
        int horiOffset = 101;
        switch(index) {
            case 1, 6, 11, 16:
                return horiInit;
            case 2, 7, 12, 17:
                return horiInit + horiOffset;
            case 3, 8, 13, 18:
                return horiInit + 2*horiOffset;
            case 4, 9, 14, 19:
                return horiInit + 3*horiOffset;
            case 5, 10, 15, 20:
                return horiInit + 4*horiOffset;
        }
        return -1;
    }
    
    public static int buttonPositionY(int index) {
        int vertInit = 100;
        int vertOffset = 80;
        switch(index) {
            case 1, 5, 9, 13, 17:
                return vertInit;
            case 2, 6, 10, 14, 18:
                return vertInit + vertOffset;
            case 3, 7, 11, 15, 19:
                return vertInit + 2*vertOffset;
            case 4, 8, 12, 16, 20:
                return vertInit + 3*vertOffset;
        }
        return -1;
    }
}