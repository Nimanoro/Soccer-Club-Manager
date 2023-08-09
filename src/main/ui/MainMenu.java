package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// citation: https://docs.oracle.com/javase/tutorial/uiswing/

// EFFECTS:Constructs MainMenu based on FirstMenu Class
public class MainMenu extends FirstMenu {

    private JFrame frame;

    //MODIFIES: this
    // EFFECTS: constructs new frame in JFrame
    public MainMenu() {
        frame = new JFrame();
        Image icon = Toolkit.getDefaultToolkit().getImage("data/Soccer.png");
        frame.setIconImage(icon);
        frame.setTitle("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 600));

        addButtons();

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: Add buttons to the frame
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void addButtons() {
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));

        ImageIcon img = imageProccesor("data/1.png");
        JButton button1 = new JButton();
        button1.setIcon(img);
        button1.setHorizontalTextPosition(SwingConstants.CENTER);

        Color background = new Color(2,90,40);
        button1.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent me) {
                button1.setIcon(null);
                button1.setText("Can");
                button1.setBackground(background);
                button1.setForeground(Color.white);
                button1.setBorderPainted(false);
                button1.setFont(new Font("Arial", Font.PLAIN, 40));
                button1.setOpaque(true);
            }

            public void mouseExited(MouseEvent me) {
                button1.setText(null);
                button1.setIcon(img);
                button1.setHorizontalTextPosition(SwingConstants.CENTER);

            }
        });
        button1.addActionListener(this::actionPerformed);
        button1.setActionCommand("Start");
        buttonPanel.add(button1);

        ImageIcon img1 = imageProccesor("data/3.png");
        JButton button2 = new JButton();
        button2.setIcon(img1);
        button2.setHorizontalTextPosition(SwingConstants.CENTER);
        button2.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent me) {
                button2.setIcon(null);
                button2.setText("You");
                button2.setBackground(background);
                button2.setForeground(Color.white);
                button2.setBorderPainted(false);
                button2.setFont(new Font("Arial", Font.PLAIN, 40));
                button2.setOpaque(true);// change the color to green when mouse over a button
            }

            public void mouseExited(MouseEvent me) {
                button2.setText(null);
                button2.setIcon(img1);
                button2.setHorizontalTextPosition(SwingConstants.CENTER);

            }
        });
        button2.addActionListener(this::actionPerformed);
        button2.setActionCommand("Squad");
        buttonPanel.add(button2);
        ImageIcon img2 = imageProccesor("data/2.png");
        JButton button3 = new JButton();
        button3.setIcon(img2);
        button3.setHorizontalTextPosition(SwingConstants.CENTER);

        button3.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent me) {
                button3.setIcon(null);
                button3.setText("win");
                button3.setBackground(background);
                button3.setForeground(Color.white);
                button3.setBorderPainted(false);
                button3.setFont(new Font("Arial", Font.PLAIN, 40));
                button3.setOpaque(true);
            }

            public void mouseExited(MouseEvent me) {
                button3.setText(null);
                button3.setHorizontalTextPosition(SwingConstants.CENTER);
                button3.setIcon(img2);
            }
        });
        button3.addActionListener(this::actionPerformed);
        button3.setActionCommand("Standing");
        buttonPanel.add(button3);
        ImageIcon img3 = imageProccesor("data/4.png");
        JButton button4 = new JButton();
        button4.setIcon(img3);
        button4.setHorizontalTextPosition(SwingConstants.CENTER);

        button4.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent me) {
                button4.setIcon(null);
                button4.setText("this");
                button4.setBackground(background);
                button4.setForeground(Color.white);
                button4.setBorderPainted(false);
                button4.setFont(new Font("Arial", Font.PLAIN, 40));
                button4.setOpaque(true);
            }

            public void mouseExited(MouseEvent me) {
                button4.setText(null);
                button4.setHorizontalTextPosition(SwingConstants.CENTER);

                button4.setIcon(img3);
            }
        });
        button4.addActionListener(this::actionPerformed);
        button4.setActionCommand("Save");
        buttonPanel.add(button4);
        ImageIcon img4 = imageProccesor("data/5.png");
        JButton button5 = new JButton();
        button5.setIcon(img4);
        button5.setHorizontalTextPosition(SwingConstants.CENTER);

        button5.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent me) {
                button5.setIcon(null);
                button5.setText("?");
                button5.setBackground(background);
                button5.setForeground(Color.white);
                button5.setBorderPainted(false);
                button5.setFont(new Font("Arial", Font.PLAIN, 40));
                button5.setOpaque(true);// change the color to green when mouse over a button
            }

            public void mouseExited(MouseEvent me) {
                button5.setText(null);
                button5.setHorizontalTextPosition(SwingConstants.CENTER);
                button5.setIcon(img4);
            }
        });
        button5.addActionListener(this::actionPerformed);
        button5.setActionCommand("Load");
        buttonPanel.add(button5);
        ImageIcon img5 = imageProccesor("data/6.png");
        JButton button6 = new JButton();
        button6.setIcon(img5);
        button6.setHorizontalTextPosition(SwingConstants.CENTER);
        button6.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent me) {
                button6.setIcon(null);
                button6.setText("!");
                button6.setBackground(background);
                button6.setForeground(Color.white);
                button6.setBorderPainted(false);
                button6.setFont(new Font("Arial", Font.PLAIN, 40));
                button6.setOpaque(true);// change the color to green when mouse over a button // change the color to green when mouse over a button
            }

            public void mouseExited(MouseEvent me) {
                button6.setText(null);
                button6.setHorizontalTextPosition(SwingConstants.CENTER);

                button6.setIcon(img5);
            }
        });
        button6.addActionListener(this::actionPerformed);
        button6.setActionCommand("Quit");
        buttonPanel.add(button6);
        frame.getContentPane().add(buttonPanel);
    }


    //EFFECTS: NAVIGATE THE BUTTONS TO DIFFERENT FRAMES
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals("Start")) {
            new GameMenu();
        } else if (action.equals("Squad")) {
            new TeamPanel();
        } else if (action.equals("Standing")) {
            new LeaguePanel();
        } else if (action.equals("Save")) {
            super.saveGame();
        } else if (action.equals("Load")) {
            super.loadGame();
        } else if (action.equals("Quit")) {
            System.exit(0);
        }
    }

    //EFFECTS: PREPROCESS IMAGE TO BE ADDED AS THE ICON OF Buttons
    private ImageIcon imageProccesor(String source) {
        ImageIcon img2 = new ImageIcon(source);
        Image image2 = img2.getImage();
        Image newImg2 = image2.getScaledInstance(220, 300,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        img2 = new ImageIcon(newImg2);
        return img2;

    }
}

