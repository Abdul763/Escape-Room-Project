/**
 * Write a description of class MainMenu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class MainMenu 
{
    JFrame window;
     Container con;
    JPanel titleNamePanel, startButtonPanel, instrButtonPanel, mainInstrPanel, backButtonPanel; 
    JLabel titleNameLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 70);
    Font startFont = new Font("Times New Roman", Font.PLAIN, 20);
    Font instrFont = new Font("Times New Roman", Font.PLAIN, 20);
    Font backFont = new Font("Times New Roman", Font.PLAIN, 20);
    
    JButton startButton;
    JButton instrButton;
    JButton instrBackButton;
    JTextArea mainInstrTextArea, mainInstrTextArea2, mainInstrTextArea3, mainInstrTextArea4;
    
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    BackButtonHandler backButton = new BackButtonHandler();
    Image img = Toolkit.getDefaultToolkit().getImage("A:\\BlueJ\\EscapeRoomProject\\outside-pixilart.png");
    public static void main (String args[]){
        new MainMenu();
    }

    public MainMenu(){
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new JPanel(){
                @Override
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(img, 0, 0, 800, 600, this);
                }
            });
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 650, 150);
        titleNamePanel.setBackground(new Color(0,0,0,0));
        titleNameLabel = new JLabel("Murder House Escape");
        titleNameLabel.setForeground(Color.black);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(250, 400, 300, 200);
        startButtonPanel.setBackground(new Color(0,0,0,0));

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white); 
        startButton.setFont(startFont);

        instrButtonPanel = new JPanel();
        instrButtonPanel.setBounds(250, 500, 300, 200);
        instrButtonPanel.setBackground(new Color(0,0,0,0));

        instrButton = new JButton("INSTRUCTIONS");
        instrButton.setBackground(Color.black);
        instrButton.setForeground(Color.white); 
        instrButton.setFont(instrFont);
        instrButton.addActionListener(tsHandler);
        
        backButtonPanel = new JPanel();
        backButtonPanel.setBounds(250, 550, 300, 200);
        backButtonPanel.setBackground(new Color(0,0,0,0));

        instrBackButton = new JButton("< Back");
        instrBackButton.setBackground(Color.black);
        instrBackButton.setForeground(Color.white); 
        instrBackButton.setFont(backFont);
        instrBackButton.addActionListener(backButton);
        backButtonPanel.setVisible(false);


        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        instrButtonPanel.add(instrButton);
        backButtonPanel.add(instrBackButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);
        con.add(instrButtonPanel);
        con.add(backButtonPanel);
    }
    
    public void createInstructionScreen() {
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        instrButtonPanel.setVisible(false);
        backButtonPanel.setVisible(true);

        
        mainInstrPanel = new JPanel();
        mainInstrPanel.setBounds(100, 100, 600, 350);
        mainInstrPanel.setBackground(Color.black);
        con.add(mainInstrPanel);
        
        mainInstrTextArea = new JTextArea("Objective:");
        mainInstrTextArea.setBounds(100, 100, 600, 50);
        mainInstrTextArea.setBackground(Color.black);
        mainInstrTextArea.setForeground(Color.white);
        mainInstrTextArea.setFont(instrFont);
        mainInstrTextArea.setLineWrap(true);
        mainInstrPanel.add(mainInstrTextArea);
        
        mainInstrTextArea2 = new JTextArea("You are to investigate serial killings in a nearby residence");
        mainInstrTextArea2.setBounds(100, 250, 600, 50);
        mainInstrTextArea2.setBackground(Color.black);
        mainInstrTextArea2.setForeground(Color.white);
        mainInstrTextArea2.setFont(instrFont);
        mainInstrTextArea2.setLineWrap(true);
        mainInstrPanel.add(mainInstrTextArea2);
        
        mainInstrTextArea3 = new JTextArea("Controls:");
        mainInstrTextArea3.setBounds(100, 300, 600, 50);
        mainInstrTextArea3.setBackground(Color.black);
        mainInstrTextArea3.setForeground(Color.white);
        mainInstrTextArea3.setFont(instrFont);
        mainInstrTextArea3.setLineWrap(true);
        mainInstrPanel.add(mainInstrTextArea3);
        
        mainInstrTextArea4 = new JTextArea("Interact - LMB");
        mainInstrTextArea4.setBounds(100, 250, 600, 50);
        mainInstrTextArea4.setBackground(Color.black);
        mainInstrTextArea4.setForeground(Color.white);
        mainInstrTextArea4.setFont(instrFont);
        mainInstrTextArea4.setLineWrap(true);
        mainInstrPanel.add(mainInstrTextArea4);
        
        
        
    }
    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            createInstructionScreen();
        }
    }
    public void createBackButtonFromInstr() {
        titleNamePanel.setVisible(true);
        startButtonPanel.setVisible(true);
        instrButtonPanel.setVisible(true);
        mainInstrPanel.setVisible(false);
        backButtonPanel.setVisible(false);

        
    }
    public class BackButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            createBackButtonFromInstr();
        }
    }
    
}