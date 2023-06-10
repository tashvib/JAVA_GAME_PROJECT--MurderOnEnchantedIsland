/* Tashvi Bansal
 * Period 5
 * May 7
 * This class contains all the code for the first level of my game. In the first level there are two mini games. 
 */


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.Timer;

//This class contains all the JPanels, methods, classes, logic needed to play Level1
public class Level1Panel extends JPanel {
    JPanel containerPanel;
    static CardLayout mainCL;
    DeathScreen deathScreen;
    IntroLevelClass introToLevel;
    Challenge2 challenge2;
    MiddleStoryBoard2 msb2;
    Font customFont;

    // This constructor contains the cardlayout for level1
    public Level1Panel() {
        customFont=null;
        mainCL = new CardLayout();
        setLayout(mainCL);
        introToLevel = new IntroLevelClass();
        add(introToLevel, "panel1");
        Challenge1 challenge1 = new Challenge1();
        //Challenge3 challenge3 = new Challenge3();
        MiddleStoryBoard msb = new MiddleStoryBoard();
        deathScreen = new DeathScreen();
        
        this.add(challenge1, "panel2");
        this.add(deathScreen, "panel3");
        this.add(msb, "panel4");
        //this.add(challenge3, "panel7");
        mainCL.show(this, "panel1");
        // mainCL.show(Level1Panel.this, "panel2");
        // mainCL.show(Level1Panel.this, "panel5");
    }

    // This class introduces the player to the "scenario"/game
    class IntroLevelClass extends JPanel implements MouseListener {
        boolean drawHauntedLibrary;
        boolean drawStrobe;
        CardLayout introLevelCL;
        //MapPanel mapPanel;

        // This constructor simply sets the layout and adds the corresponding panels to
        // itself
        // It also sets some boolean values that determine whether or not to paint stuff
        // in paintComponent
        public IntroLevelClass() {
            containerPanel = new JPanel();
            containerPanel.setPreferredSize(new Dimension(1400, 900));
            introLevelCL = new CardLayout();
            containerPanel.setLayout(introLevelCL);
            containerPanel.add(new HauntedLibraryPanel(), "hauntedLibrary");
            containerPanel.add(new HauntedLibraryPanel1(), "hauntedLibrary1");
            containerPanel.add(new HauntedLibraryPanel2(), "hauntedLibrary2");
            containerPanel.add(new HauntedLibraryPanel3(), "hauntedLibrary3");
            containerPanel.add(new HauntedLibraryPanel4(), "hauntedLibrary4");
            containerPanel.add(new HauntedLibraryPanel5(), "hauntedLibrary5");
            containerPanel.add(new HauntedLibraryPanel6(), "hauntedLibrary6");
            containerPanel.add(new Forest1(), "forest1");
            containerPanel.add(new Forest2(), "forest2");
            containerPanel.add(new Forest3(), "forest3");
            containerPanel.add(new Forest4(), "forest4");
            containerPanel.add(new Forest5(), "forest5");
            containerPanel.add(new Forest5(), "forest6");
            containerPanel.add(new Forest6(), "forest7");
            //containerPanel.add(new StrobeEffectPanel(), "strobe");
            //mapPanel = new MapPanel();
            //containerPanel.add(mapPanel, "map");
            containerPanel.add(new CemeteryPanels(), "cemeteryPanels");

            add(containerPanel);
            // introLevelCL.show(containerPanel, "map");
            introLevelCL.show(containerPanel, "hauntedLibrary");
            // introToLevel.add(centerPanel(), BorderLayout.CENTER);
        }

        // To set the "situation" up for the user, there are siz story panels, the
        // first of which is the HauntedLibraryPanel
        class HauntedLibraryPanel extends JPanel {
            // The HauntedLibraryPanel constructor does 3 things:
            // set's layout of panel,
            // add's northpanel which contains the quit button
            // and add's ButtonPanel which contains the next arrow button
            public HauntedLibraryPanel() {
                setLayout(new BorderLayout());
                add(northPanel(), BorderLayout.NORTH);
                // JPanel gridLayout = new JPanel(new GridLayout(2, 1));
                // gridLayout.add(new JPanel());
                // JPanel panel = new JPanel();
                // panel.setBackground(Color.BLUE);
                // gridLayout.add(panel);
                // //gridLayout.add(new ButtonPanel());
                // add(gridLayout);
                add(new ButtonPanel(), BorderLayout.SOUTH);
                /// add(HomePage.countdownPanel); //for some reason this isn't working
            }

            // paintComponent draws bg of hauntedlibrary
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image hauntedLibrary = new ImageIcon("res/BobDiesInHauntedHouse.gif").getImage();
                g.drawImage(hauntedLibrary, 0, 0, 1400, getHeight() - 50, this);
                 

            }
        }
         // second "story" panel
        class HauntedLibraryPanel1 extends JPanel {
            // The HauntedLibraryPanel constructor does 3 things:
            // set's layout of panel,
            // add's northpanel which contains the quit button
            // and add's ButtonPanel which contains the next arrow button
            public HauntedLibraryPanel1() {
                setLayout(new BorderLayout());
                add(northPanel(), BorderLayout.NORTH);
                add(new ButtonPanel(), BorderLayout.SOUTH);
                /// add(HomePage.countdownPanel); //for some reason this isn't working
            }

            // paintComponent draws bg of hauntedlibrary
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image hauntedLibrary = new ImageIcon("res/BobDiesInHauntedHouse.gif").getImage();
                 //g.drawImage(hauntedLibrary, 0, 0, 1400, getHeight() - 50, this);
                Image speech1 = new ImageIcon("res/Speech1.png").getImage();
                g.drawImage(speech1, 0, 0, 1400, getHeight() - 50, this);
                Image hauntedLibraryText = new ImageIcon("res/HauntedLibraryText.png").getImage();
                g.drawImage(hauntedLibraryText, 670, 200, 270, 100, this);
                 
            }
        }

         // third "story" panel
        class HauntedLibraryPanel2 extends JPanel{
            //constructs the quit button via the northPanel() method and adds the next button
            public HauntedLibraryPanel2() {
                setLayout(new BorderLayout());
                add(northPanel(), BorderLayout.NORTH);
                add(new ButtonPanel(), BorderLayout.SOUTH);
                /// add(HomePage.countdownPanel); //for some reason this isn't working
            }

            // paintComponent draws bg of hauntedlibrary
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image speech2 = new ImageIcon("res/Speech2.png").getImage();
                g.drawImage(speech2, 0, 0, 1400, getHeight() - 50, this);
                Image hauntedLibraryText = new ImageIcon("res/HauntedLibraryText.png").getImage();
                g.drawImage(hauntedLibraryText, 670, 200, 270, 100, this);
                 
            }
        }

         // fourth "story" panel
        class HauntedLibraryPanel3 extends JPanel{
            //constructs the quit button and next button
            public HauntedLibraryPanel3() {
                //constructs the quit button via the northPanel() method and adds the next button
                setLayout(new BorderLayout());
                add(northPanel(), BorderLayout.NORTH);
                add(new ButtonPanel(), BorderLayout.SOUTH);
                /// add(HomePage.countdownPanel); //for some reason this isn't working
            }

            // paintComponent draws bg of hauntedlibrary
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image speech3 = new ImageIcon("res/Speech3.gif").getImage();
                g.drawImage(speech3, 0, 0, 1400, getHeight() - 50, this);
                Image hauntedLibraryText = new ImageIcon("res/HauntedLibraryText.png").getImage();
                g.drawImage(hauntedLibraryText, 670, 200, 270, 100, this);
                 
            }
        }

         // fifth "story" panel
        class HauntedLibraryPanel4 extends JPanel {
            //constructs the quit button and next button
            public HauntedLibraryPanel4() {
                //constructs the quit button via the northPanel() method and adds the next button
               setLayout(new BorderLayout());
                add(northPanel(), BorderLayout.NORTH);
                add(new ButtonPanel(), BorderLayout.SOUTH);
                /// add(HomePage.countdownPanel); //for some reason this isn't working
            }

            // paintComponent draws bg of hauntedlibrary
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image speech4 = new ImageIcon("res/Speech4.png").getImage();
                g.drawImage(speech4, 0, 0, 1400, getHeight() - 50, this);
                Image hauntedLibraryText = new ImageIcon("res/HauntedLibraryText.png").getImage();
                g.drawImage(hauntedLibraryText, 670, 200, 270, 100, this);
                 
            }
        }
        // sixth "story" panel
        class HauntedLibraryPanel5 extends JPanel{
            //constructs the quit button via the northPanel() method and adds the next button
            public HauntedLibraryPanel5() {
                setLayout(new BorderLayout());
                add(northPanel(), BorderLayout.NORTH);
                add(new ButtonPanel(), BorderLayout.SOUTH);
                /// add(HomePage.countdownPanel); //for some reason this isn't working
            }

            // paintComponent draws bg of hauntedlibrary
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image speech5= new ImageIcon("res/Speech5.png").getImage();
                g.drawImage(speech5, 0, 0, 1400, getHeight() - 50, this);
                Image hauntedLibraryText = new ImageIcon("res/HauntedLibraryText.png").getImage();
                g.drawImage(hauntedLibraryText, 670, 200, 270, 100, this);
                 
            }
        }
        // seventh "story" panel
        class HauntedLibraryPanel6 extends JPanel{
            //constructs the quit button via the northPanel() method and adds the next button
            public HauntedLibraryPanel6() {
                //constructs the quit button via the northPanel() method and adds the next button
                setLayout(new BorderLayout());
                add(northPanel(), BorderLayout.NORTH);
                add(new ButtonPanel(), BorderLayout.SOUTH);
                // try {
                //     // Load the sound clip from a file
                //     Clip clip = AudioSystem.getClip();
                //     clip.open(AudioSystem.getAudioInputStream(new File("res/Teleport.wav")));
    
                //     // Play the sound clip
                //     clip.start();
                // } catch (Exception ex) {
                //     ex.printStackTrace();
                // }
                /// add(HomePage.countdownPanel); //for some reason this isn't working
            }

            // paintComponent draws bg of hauntedlibrary
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image speech6= new ImageIcon("res/Speech6.png").getImage();
                g.drawImage(speech6, 0, 0, 1400, getHeight() - 50, this);
                Image hauntedLibraryText = new ImageIcon("res/HauntedLibraryText.png").getImage();
                g.drawImage(hauntedLibraryText, 670, 200, 270, 100, this);
                 
            }
        }
        
        // eight "story" panel
        class Forest1 extends JPanel{
            //constructs the quit button and next button
            public Forest1() {
                setLayout(new BorderLayout());
                add(northPanel(), BorderLayout.NORTH);
                add(new ButtonPanel(), BorderLayout.SOUTH);
            }

            // paintComponent draws bg of hauntedlibrary
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image waw= new ImageIcon("res/wherearewe.png").getImage();
                g.drawImage(waw, 0, 0, 1400, getHeight() - 50, this);
                 
            }
        }
        // ninth "story" panel
        class Forest2 extends JPanel{
            //constructs the quit button and next button
            public Forest2() {
                setLayout(new BorderLayout());
                add(northPanel(), BorderLayout.NORTH);
                add(new ButtonPanel(), BorderLayout.SOUTH);
            }

            // paintComponent draws bg of hauntedlibrary
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image waw= new ImageIcon("res/lookatthesign.png").getImage();
                g.drawImage(waw, 0, 0, 1400, getHeight() - 50, this);
                 
            }
        }
        // tenth "story" panel
        class Forest3 extends JPanel{

            //constructs the quit button and next button
            public Forest3() {
                setLayout(new BorderLayout());
                add(northPanel(), BorderLayout.NORTH);
                add(new ButtonPanel(), BorderLayout.SOUTH);
            }

            // paintComponent draws bg of hauntedlibrary
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image waw= new ImageIcon("res/webetterleave.png").getImage();
                g.drawImage(waw, 0, 0, 1400, getHeight() - 50, this);
                 
            }
        }
        // eleventh "story" panel
        class Forest4 extends JPanel{

            //constructs the quit button and next button
            public Forest4() {
                setLayout(new BorderLayout());
                add(northPanel(), BorderLayout.NORTH);
                add(new ButtonPanel(), BorderLayout.SOUTH);
            }

            // paintComponent draws bg of hauntedlibrary
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image waw= new ImageIcon("res/whataboutbob.png").getImage();
                g.drawImage(waw, 0, 0, 1400, getHeight() - 50, this);
                 
            }
        }
        // 12th "story" panel
        class Forest5 extends JPanel{

            //constructs the quit button and next button
            public Forest5() {
                setLayout(new BorderLayout());
                add(northPanel(), BorderLayout.NORTH);
                add(new ButtonPanel(), BorderLayout.SOUTH);
            }

            // paintComponent draws bg of hauntedlibrary
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image waw= new ImageIcon("res/ifwehavetime.png").getImage();
                g.drawImage(waw, 0, 0, 1400, getHeight() - 50, this);
                 
            }
        }
        // 13th "story" panel
        class Forest6 extends JPanel{
            //constructs the quit button and next button
            public Forest6() {
                setLayout(new BorderLayout());
                add(northPanel(), BorderLayout.NORTH);
                add(new ButtonPanel(), BorderLayout.SOUTH);
            }

            // paintComponent draws bg of hauntedlibrary
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image waw= new ImageIcon("res/search.png").getImage();
                g.drawImage(waw, 0, 0, 1400, getHeight() - 50, this);
                 
            }
        }

        //IGNORE THIS CLASS, I DECIDED TO DELETE IT BUT WANTED TO KEEP THE CODE
        //!IGNORE!
        // class MapPanel extends JPanel implements KeyListener {
        //     int x;
        //     int y;
        //     boolean drawCircle;
        //     boolean spacePressed;

            
            // The MapPanel constructer adds the neccesary listeners, layouts, and panels
            // needed to create MapPanel
            // it also initiliazes all the variables
        //     public MapPanel() {
        //         setLayout(new BorderLayout());
        //         addKeyListener(this);
        //         add(northPanel(), BorderLayout.NORTH);
        //         add(new ButtonPanel(), BorderLayout.SOUTH);
        //         x = 885;
        //         y = 305;
        //         drawCircle = false;
        //         spacePressed = false;
        //     }

        //     // this paintComponent method draws the glowing circle (which acts as a hint to
        //     // the user as to where to go next)
        //     // this paintComponent method also draws a map bg and an icon of the avatar that
        //     // represents the user
        //     // it also determines what to do if the user manages to correctly explore the
        //     // map
        //     @Override
        //     public void paintComponent(Graphics g) {
        //         super.paintComponent(g);
        //         if (x >= 630 && x <= 670 && y >= 345 && y <= 390 && spacePressed) {
        //             // System.out.println("all conditions met");
        //             // mainCL.show(Level1Panel.this, "panel2");
        //             introLevelCL.show(containerPanel, "cemeteryPanels");
        //         }
        //         Image map = new ImageIcon("res/map2.png").getImage();
        //         g.drawImage(map, 0, 0, 1400, 900, this);
        //         Image icon = new ImageIcon("res/girlIcon.png").getImage();
        //         g.drawImage(icon, x, y, 40, 40, this);
        //         if (drawCircle) {
        //             Image glowingCircle = new ImageIcon("res/glowingCircle.png").getImage();
        //             g.drawImage(glowingCircle, 630, 350, 40, 40, this);
        //         }
        //         drawCircle = !drawCircle;
        //         requestFocus();
        //     }

        //     // determines what happens if key is presed
        //     public void keyPressed(KeyEvent e) {
        //         requestFocus();

        //         if (e.getKeyCode() == KeyEvent.VK_SPACE) {
        //             spacePressed = true;
        //             System.out.println("space was pressed");
        //         }
        //         if (e.getKeyCode() == KeyEvent.VK_LEFT)
        //             x = x - 5; // if left arrow is pressed then the icon moves 5 to the left
        //         if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        //             x = x + 5; // if left arrow is pressed then the icon moves 5 to the right
        //         if (e.getKeyCode() == KeyEvent.VK_DOWN)
        //             y = y + 5; // if up arrow is pressed then the icon moves 5 up
        //         if (e.getKeyCode() == KeyEvent.VK_UP)
        //             y = y - 5;// if down arrow is pressed then the icon moves 5 down
        //         if (x < 0)
        //             x = 0; // resets x if the user tries to go too far left
        //         if (y < 0)
        //             y = 0; // resets y if the user tries to go too far up
        //         if (x >= 1375)
        //             x = 1375; // resets x if the user tries to go too far right
        //         if (y > 800)
        //             y = 800; // resets y if the user tries to go too far down
        //         repaint();
        //     }

        //     // determines what to do if key is typed
        //     public void keyTyped(KeyEvent e) {
        //     }

        //     // determines what to do if key is released
        //     public void keyReleased(KeyEvent e) {
        //     }
        // }

        //these are also "story" panels but they have their own class because the CemeteryButton is custom
        class CemeteryPanels extends JPanel {
            CardLayout cpCL;
            //this constructor initalizes the cardlayout and adds the appropriate panels to the card layout
            public CemeteryPanels(){
                cpCL = new CardLayout();
                setLayout(cpCL);
                //add(new Panel1(), "p1");
                add(new Panel2(), "p2");

            }
            //Panel 1 class displays the "cemetery1.png" image
            class Panel1 extends JPanel{
                //sets layout, adds quit button, adds the next button
                public Panel1(){
                    setLayout(new BorderLayout());
                    add(northPanel(), BorderLayout.NORTH);
                    add(new CemeteryButton(), BorderLayout.SOUTH);
                }
                //draws the "cemetery1.png" image
                @Override
                public void paintComponent(Graphics g) {
                    Image cemetery1 = new ImageIcon("res/cemetery1.png").getImage();
                    g.drawImage(cemetery1, 0, 0, 1400, 900, this);
                }
            }
            //Panel 1 class displays the "Cemetery2.png" image
            class Panel2 extends JPanel{
                //sets layout, adds quit button, adds the next button
                public Panel2(){
                    setLayout(new BorderLayout());
                    add(northPanel(), BorderLayout.NORTH);
                    add(new CemeteryButton(), BorderLayout.SOUTH);
                }
                //draws the "Cemetery2.png" image
                @Override
                public void paintComponent(Graphics g) {
                    Image cemetery2 = new ImageIcon("res/Cemetery2.png").getImage();
                    g.drawImage(cemetery2, 0, 0, 1400, 900, this);
                }
            }

            //CemeteryButton class contains the code for the cemetery button
            class CemeteryButton extends JPanel implements MouseListener {
                int countNextPressed;
                // Constructor constructs ButtonPanel (e.g. layout, background color)
                public CemeteryButton() {
                    countNextPressed=0;
                    setLayout(new BorderLayout());
                    setPreferredSize(new Dimension(1400, 250));
                    setBackground(new Color(0, 0, 0, 0));
                    addMouseListener(this);
                }
    
                // this paintComponent method draws the next arrow button
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Image nextArrButton = new ImageIcon("res/NextArrowButton.png").getImage();
                    g.drawImage(nextArrButton, 1250, 100, 150, 100, this);
                }
    
                // mousePressed determines what to do if mouse is pressed
                public void mousePressed(MouseEvent e) {
                    
                }
    
                // mouseClicked determines what to do if mouse is clicked
                public void mouseClicked(MouseEvent e) {
                    //if next button is pressed, it will display the first challenge
                    if (e.getX() >= 1250 && e.getX() <= 1400 && e.getY() <= 200 && e.getY() >= 100) {
                        mainCL.show(Level1Panel.this, "panel2");
                    }
                }
    
                // mouseReleased determines what to do if mouse is released
                public void mouseReleased(MouseEvent e) {}
    
                // mouseExited determines what to do if mouse exits frame
                public void mouseExited(MouseEvent e) {}
    
                // mouseEntered determines what to do if mouse enters frame
                public void mouseEntered(MouseEvent e) {}
    
            }
        }
        // this method returns the jpanel that contains quit button (goes back to
        // homescreen)
        public JPanel northPanel() {
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            panel.setBackground(new Color(0, 0, 0, 0));
            Image img = Toolkit.getDefaultToolkit().getImage("res/QuitButton.png");
            Image img2 = img.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
            ImageIcon buttonIcon = new ImageIcon(img2);
            JLabel quit = new JLabel(buttonIcon);
            quit.setPreferredSize(new Dimension(200, 40));
            quit.setOpaque(true);
            quit.setBackground(new Color(0, 0, 0, 0));
            quit.addMouseListener(IntroLevelClass.this);
            panel.add(quit);
            //panel.add(HomePage.countdownPanel);
            return panel;
        }

        // mouseClicked determines what to do if mouse is clicked
        // this mouseClicked method contains the code for what should happen if the quit
        // button is pressed
        public void mouseClicked(MouseEvent e) {
            HomePage.cl.show(HomePage.mainPanel, "homePagePanel");
            try {
                // Load the sound clip from a file
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File("res/ButtonClick.wav")));

                // Play the sound clip
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        // mouseReleased determines what to do if mouse is released
        public void mouseReleased(MouseEvent e) {
        }

        // mouseReleased determines what to do if mouse is pressed
        public void mousePressed(MouseEvent e) {
        }

        // mouseExited determines what to do if mouse exits frame
        public void mouseExited(MouseEvent e) {
        }

        // mouseEntered determines what to do if mouse enters frame
        public void mouseEntered(MouseEvent e) {
        }

        // this class draws and contains the logic for what to do when the next "button"
        // is clicked
        class ButtonPanel extends JPanel implements MouseListener {

            // Constructor constructs ButtonPanel (e.g. layout, background color)
            public ButtonPanel() {
                setLayout(new BorderLayout());
                setPreferredSize(new Dimension(1400, 250));
                setBackground(new Color(0, 0, 0, 0));
                addMouseListener(this);
            }

            // this paintComponent method draws the next arrow button
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image nextArrButton = new ImageIcon("res/NextArrowButton.png").getImage();
                g.drawImage(nextArrButton, 1250, 100, 150, 100, this);
            }

            // mousePressed determines what to do if mouse is pressed
            public void mousePressed(MouseEvent e) {
                if (e.getX() >= 1250 && e.getX() <= 1400 && e.getY() <= 200 && e.getY() >= 100) {
                    introLevelCL.next(containerPanel);
                }
            }

            // mouseClicked determines what to do if mouse is clicked
            public void mouseClicked(MouseEvent e) {}

            // mouseReleased determines what to do if mouse is released
            public void mouseReleased(MouseEvent e) {}

            // mouseExited determines what to do if mouse exits frame
            public void mouseExited(MouseEvent e) {}

            // mouseEntered determines what to do if mouse enters frame
            public void mouseEntered(MouseEvent e) {}

        }
    }

    // The first challenge is a maze challenge and this class contains the code for
    // the maze challenge
    // mouselistener is implemented for the start button
    class Challenge1 extends JPanel implements MouseListener {
        // Challenge1 constructor constructs the layout for the main screen for the
        // first challenge
        boolean startMiniMazeGame;

        // inside the Challenge1 constructor all the "filler" panels are initliazed +
        // start button for challenge1
        public Challenge1() {
            setLayout(new BorderLayout());
            addMouseListener(this);
            startMiniMazeGame = false;
            JPanel eastFiller = new JPanel(); // space filler panel that has no logical purpose, purely for aesthetics
            eastFiller.setBackground(new Color(0, 0, 0, 0));
            eastFiller.setPreferredSize(new Dimension(30, 900));
            add(eastFiller, BorderLayout.EAST);
            JPanel northFiller = new JPanel(); // space filler panel that has no logical purpose, purely for aesthetics
            northFiller.setBackground(new Color(0, 0, 0, 0));
            northFiller.setPreferredSize(new Dimension(1400, 277));
            northFiller.setLayout(new BorderLayout());
            Image startButtonImage = new ImageIcon("res/StartButton.png").getImage().getScaledInstance(562 / 4, 234 / 4,
                    Image.SCALE_SMOOTH);
            // startButtonImage.setPreferredSize(new Dimension(562/4,234/4));
            ImageIcon startButtonIcon = new ImageIcon(startButtonImage);
            JLabel startButton = new JLabel(startButtonIcon);
            northFiller.add(startButton, BorderLayout.SOUTH);
            add(northFiller, BorderLayout.NORTH);
            JPanel westFiller = new JPanel(); // space filler panel that has no logical purpose, purely for aesthetics
            westFiller.setBackground(new Color(0, 0, 0, 0));
            westFiller.setPreferredSize(new Dimension(30, 900));
            add(westFiller, BorderLayout.WEST);
            JPanel southFiller = new JPanel(); // space filler panel that has no logical purpose, purely for aesthetics
            southFiller.setBackground(new Color(0, 0, 0, 0));
            southFiller.setPreferredSize(new Dimension(1400, 30));
            add(southFiller, BorderLayout.SOUTH);

            
            MazeChallenge mc = new MazeChallenge(); // contains actual logic for the 1st Challenge
            Challenge1.this.add(mc, BorderLayout.CENTER);
        }

        // determines what to do if mouse is clicked
        public void mouseClicked(MouseEvent e) {
            if (e.getX() <= 757 && e.getX() >= 636 && e.getY() <= 265 && e.getY() >= 227) {
                startMiniMazeGame = true;
                try {
                    // Load the sound clip from a file
                    Clip clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(new File("res/ButtonClick.wav")));
                    // Play the sound clip
                    clip.start();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

        // determines what to do if mouse is pressed
        public void mousePressed(MouseEvent e) {
        }

        // determines what to do if mouse is released
        public void mouseReleased(MouseEvent e) {
        }

        // determines what to do if mouse enters jpanel
        public void mouseEntered(MouseEvent e) {
        }

        // determines what to do if mouse exits jpanel
        public void mouseExited(MouseEvent e) {
        }

        // paintComponent paints the cemetery bg of the first challenge
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Image cemetery = new ImageIcon("res/Level1CemeteryMaze.png").getImage();
            g.drawImage(cemetery, 0, 0, 1400, 850, this);
        }

        // contains majority the logic and display for the first challenge
        class MazeChallenge extends JPanel implements KeyListener, ActionListener {
            // 1=fill in with color, 0=no color
            int[][] maze = {
                    // 4 8 12 16
                    { 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0}, // 1
                    { 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0 }, // 2
                    { 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0 }, // 3
                    { 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, // 4
                    { 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1}, // 5
                    { 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0 }, // 6
                    { 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0 }, // 7
                    { 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0 }, // 7
                    { 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1 }, // 7
                    { 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1 }, // 7
                    { 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0 }, // 8
                    { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1 }, // 8
                    { 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1 }, // 8
            };

            int playerX; // starting X pos on maze
            int playerY; // starting Y pos on maze
            int    deadBobX; // starting X pos of     deadBob on maze
            int    deadBobY; // starting Y pos on     deadBob maze
            int    deadBobX2; // starting X pos of     deadBob on maze
            int    deadBobY2; // starting Y pos on     deadBob maze
            int    deadBobX3; // starting X pos of     deadBob on maze
            int    deadBobY3; // starting Y pos on     deadBob maze
            int    deadBobX4; // starting X pos of     deadBob on maze
            int    deadBobY4; // starting Y pos on     deadBob maze
            int    deadBobX5; // starting X pos of     deadBob on maze
            int    deadBobY5; // starting Y pos on     deadBob maze
            int    deadBobX6; // starting X pos of     deadBob on maze
            int    deadBobY6; // starting Y pos on     deadBob maze

            int  ArrPos;
            int  ArrPos2;

            int count;

            boolean callRepaintForPlayer;

            boolean playerDied;

            ArrayList<int[]> playerPositions;


            Timer  Timer;
            boolean draw ;

            boolean moveUp;
            boolean moveRight;
            boolean moveRight6;
            boolean moveUp2;
            boolean moveUp5;
            boolean switchUpAndDown;

            int mazeRows;
            int mazeCols;

            // MazeChallenge constructor initializes some of the values
            // I also used an arraylist instead of an array because otherwise it would be
            // super hard since
            // the lengths of array's are not adjustable
            public MazeChallenge() {
                callRepaintForPlayer = false;
                count = 0;
                switchUpAndDown=false;
                moveUp=false;
                moveUp2=false;
                moveUp5=false;
                moveRight6=false;
                moveRight=false;
                mazeRows=13;
                mazeCols=25;
                 ArrPos = 0;
                 ArrPos2 = 0;
                playerX = 3;
                playerY =5;
                   deadBobX = 0;
                   deadBobY = 6;
                   deadBobX2 = 5;
                   deadBobY2 = 7;
                   deadBobX3 = 20;
                   deadBobY3 = 4;
                   deadBobX4 = 22;
                   deadBobY4 = 10;
                   deadBobX5 = 9;
                   deadBobY5 = 7;
                   deadBobX6 = 14;
                   deadBobY6 = 9;
                 Timer = new Timer(300, this);
                 Timer.start();
                addKeyListener(this);
                playerDied = false;
                setOpaque(false);

                playerPositions = new ArrayList<int[]>();
                playerPositions.add(new int[] { 0, 6 });
                playerPositions.add(new int[] { 1, 6 });
                playerPositions.add(new int[] { 2, 6 });
                playerPositions.add(new int[] { 3, 6 });
                playerPositions.add(new int[] { 3, 5 });
                playerPositions.add(new int[] { 3, 4 });
            }

            // actionperformed controls the moves of the   character
            public void actionPerformed(ActionEvent e) {
                // System.out.println("inside actionperformed of mazechallenge");
                if(startMiniMazeGame){

                    //The  deadBob can also follow the exact steps of the player
                    //This is done using an ArrayList
                       deadBobX = playerPositions.get( ArrPos)[0];
                       deadBobY = playerPositions.get( ArrPos)[1];
                    if (playerPositions.size() >  ArrPos + 1)
                    {
                         ArrPos++;
                        draw  = true;
                    }

                    if (!moveUp)
                           deadBobY2 ++;
                    else
                           deadBobY2--;
                    if (   deadBobY2 == 9) {
                        moveUp = true;
                    }
                    if (   deadBobY2 == 4) {
                        moveUp = false;
                    }

                    if (!moveRight)
                           deadBobX3 --;
                    else
                       deadBobX3++;
                    if (   deadBobX3 == 17) {
                        moveRight = true;
                    }
                    if (   deadBobX3 == 22) {
                        moveRight = false;
                    }

                    if (!moveUp2)    deadBobY4 --;
                    else    deadBobY4++;
                    if (   deadBobY4 == 8) {
                        moveUp2 = true;
                    }
                    if (   deadBobY4 == 12) {
                        moveUp2 = false;
                    }

                    if (!moveUp5)    deadBobY5 --;
                    else    deadBobY5++;
                    if (   deadBobY5 == 3) {
                        moveUp5 = true;
                    }
                    if (   deadBobY5 == 7) {
                        moveUp5 = false;
                    }
                    if (!moveRight6)
                       deadBobX6 --;
                    else
                       deadBobX6++;
                    if (   deadBobX6 == 13) {
                        moveRight6 = true;
                    }
                    if (   deadBobX6 == 15) {
                        moveRight6 = false;
                    }

                    
                
                    

                }

                //    deadBobX2 = playerPositions2.get( ArrPos2)[0];
                //    deadBobY2 = playerPositions2.get( ArrPos2)[1];
                // if (playerPositions2.size() >  ArrPos2 + 1 && startMiniMazeGame)
                // {
                //      ArrPos2++;
                //     draw  = true;
                // }
                repaint();
            }

            // this keypressed method determines what to do if any of the arrow keys are
            // pressed
            public void keyPressed(KeyEvent e) {
                if (!startMiniMazeGame)
                    return;

                
                requestFocusInWindow();
                requestFocus();
                // Move the player based on the arrow key pressed
                if (e.getKeyCode() == KeyEvent.VK_UP && playerY > 0 && maze[playerY - 1][playerX] == 0) { // if the square above is
                                                                                           // empty (i.e. value in maze
                                                                                           // arr is zero)
                        playerY--; // playerY position moves up
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN && playerY<12 && maze[playerY + 1][playerX] == 0) { // if the square below is
                                                                                             // empty (i.e. value in
                                                                                             // maze arr is zero)
                     playerY++; // playerY position moves down
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT && playerX > 0 && maze[playerY][playerX - 1] == 0) { // if the square to the
                                                                                             // left (i.e. value in maze
                                                                                             // arr is zero)
                    
                     playerX--; // playerY position moves left
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT && playerX < 24 && maze[playerY][playerX + 1] == 0) { // if the square to the
                                                                                              // right (i.e. value in
                                                                                              // maze arr is zero)
                     playerX++; // playerY position moves right
                }
                playerPositions.add(new int[] { playerX, playerY });
                //playerPositions2.add(new int[] { playerX, playerY });
                //System.out.println(playerPositions.get(playerPositions.size() - 1)[0] + " " + playerPositions.get(playerPositions.size() - 1)[1]);
                repaint();
                callRepaintForPlayer = true;
            }

            // determines what happens if key is released
            public void keyReleased(KeyEvent e) {
            }

            // determines what happens if key is typed
            public void keyTyped(KeyEvent e) {
            }

            // this paintcomponent draws the grid and changes the x and y values so that
            // when repaint is called the icons are shifted
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image rip = new ImageIcon("res/rip.png").getImage();
                count++;
                for (int x = 0; x < mazeCols; x++) {
                    for (int y = 0; y < mazeRows; y++) {
                        Color color;
                        if (maze[y][x] == 1) {
                            g.setColor(new Color(193, 198, 105));
                            // g.setColor(new Color(0,0,0,0));
                            g.fillRect(x * (1340 / mazeCols), y * (540 / mazeRows), 1340 / mazeCols, 540 / mazeRows);
                            g.drawImage(rip, x * (1340 / mazeCols), y * (540 / mazeRows), 1340 / mazeCols, 540 / mazeRows, null);
                        } 
                        else if(y==10 && x==24){
                            g.setColor(Color.RED);
                            g.fillRect(x * (1340 / mazeCols), y * (540 / mazeRows), 1340 / mazeCols, 540 / mazeRows);
                        }
                        else {
                            g.setColor(new Color(193, 198, 105));
                            g.fillRect(x * (1340 / mazeCols), y * (540 / mazeRows), 1340 / mazeCols, 540 / mazeRows);
                        }
                    }
                }

                //draws grid lines
                // g.setColor(Color.PINK);
                // for (int xx = 1; xx <= mazeCols; xx++) {
                //     g.drawLine(xx * (1340 / mazeCols), 0, xx * (1340 / mazeCols), 540);
                // }
                // for (int yy = 1; yy <= mazeRows; yy++) {
                //     g.drawLine(0, yy * (540 / mazeRows), 1340, yy * (540 / mazeRows));
                // }

                g.setColor(Color.RED);
                Image girlIcon = new ImageIcon("res/girlIcon.png").getImage();
                g.drawImage(girlIcon, playerX * (1340 / mazeCols), playerY * (540 / mazeRows), 1340 / mazeCols, 540 / mazeRows, this);

                Image    deadBobIcon = new ImageIcon("res/chaser.png").getImage();
                g.drawImage(   deadBobIcon,    deadBobX * (1340 / mazeCols),    deadBobY * (540 / mazeRows), 1340 / mazeCols, 540 / mazeRows, this);
                g.drawImage(   deadBobIcon,    deadBobX2 * (1340 / mazeCols),    deadBobY2 * (540 / mazeRows), 1340 / mazeCols, 540 / mazeRows, this);
                g.drawImage(   deadBobIcon,    deadBobX3 * (1340 / mazeCols),    deadBobY3 * (540 / mazeRows), 1340 / mazeCols, 540 / mazeRows, this);
                g.drawImage(   deadBobIcon,    deadBobX4 * (1340 / mazeCols),    deadBobY4 * (540 / mazeRows), 1340 / mazeCols, 540 / mazeRows, this);
                g.drawImage(   deadBobIcon,    deadBobX5 * (1340 / mazeCols),    deadBobY5 * (540 / mazeRows), 1340 / mazeCols, 540 / mazeRows, this);
                g.drawImage(   deadBobIcon,    deadBobX6 * (1340 / mazeCols),    deadBobY6 * (540 / mazeRows), 1340 / mazeCols, 540 / mazeRows, this);
                if (draw ){
                     Timer.start();
                    draw  = false;
                }

                if ((playerX ==    deadBobX && playerY ==    deadBobY) || (playerX ==    deadBobX2 && playerY ==    deadBobY2) || (playerX ==    deadBobX3 && playerY ==    deadBobY3) || (playerX ==    deadBobX4 && playerY ==    deadBobY4) || (playerX ==    deadBobX5 && playerY ==    deadBobY5) || (playerX ==    deadBobX6 && playerY ==    deadBobY6)) {
                    mainCL.show(Level1Panel.this, "panel3");
                }
                if (playerX == 24 && playerY == 10) {
                    mainCL.show(Level1Panel.this, "panel4");
                }
                requestFocus();
            }
        }
    }

    //MiddleStoryBoard contains the "story" panels to explain the game between Challenge 1 and Challenge 2
    class MiddleStoryBoard extends JPanel{
        CardLayout msbCL;
        // constructor adds some panels to the middle story board's cardlayout
        public MiddleStoryBoard() {
            msbCL = new CardLayout();
            setLayout(msbCL);
            add(new EscapeCemetery1(), "pan1");
            add(new EscapeCemetery2(), "pan2");
            add(new EscapeCemetery3(), "pan3");
            // add(new EscapeCemetery5(), "pan5");
            add(new EscapeCemetery6(), "pan6");
            add(new EscapeCemetery7(), "pan7");
            add(new EscapeCemetery8(), "pan8");
        }
        //EscapeCemetery1 is the 1st story panel
         class EscapeCemetery1 extends JPanel{
            //adds the quit button and the next button
            public EscapeCemetery1(){
                setLayout(new BorderLayout());
                add(northPanel(), BorderLayout.NORTH);
                add(new ButtonPanel(), BorderLayout.SOUTH);
            }
            //this paintComponent simply draws bg for EscapeCemetery1 class
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image escapeC1 = new ImageIcon("res/EscapeCemetery.png").getImage();
                g.drawImage(escapeC1, 0, 0, 1400, 900, this);
            }
         }
         //EscapeCemetery2 is the 2nd story panel
         class EscapeCemetery2 extends JPanel{
            //adds the quit button and the next button
            public EscapeCemetery2(){
                setLayout(new BorderLayout());
                add(northPanel(), BorderLayout.NORTH);
                add(new ButtonPanel(), BorderLayout.SOUTH);
            }
            //this paintComponent simply draws bg for EscapeCemetery2 class
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image escapeC1 = new ImageIcon("res/EscapeCemetery2.png").getImage();
                g.drawImage(escapeC1, 0, 0, 1400, 900, this);
            }
         }
         //EscapeCemetery3 is the 3rd story panel
         class EscapeCemetery3 extends JPanel{
            //adds the quit button and the next button
            public EscapeCemetery3(){
                setLayout(new BorderLayout());
                add(northPanel(), BorderLayout.NORTH);
                add(new ButtonPanel(), BorderLayout.SOUTH);
            }
            //this paintComponent simply draws bg for EscapeCemetery3 class
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image escapeC1 = new ImageIcon("res/EscapeCemetery3(1).png").getImage();
                g.drawImage(escapeC1, 0, 0, 1400, 900, this);
            }
         }
         
        //EscapeCemetery5 is the 5th story panel
         class EscapeCemetery5 extends JPanel{
            //adds the quit button and the next button
            public EscapeCemetery5(){
                setLayout(new BorderLayout());
                add(northPanel(), BorderLayout.NORTH);
                add(new ButtonPanel(), BorderLayout.SOUTH);
            }
            //this paintComponent simply draws bg for EscapeCemetery5 class
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image escapeC1 = new ImageIcon("res/EscapeCemetery5.png").getImage();
                g.drawImage(escapeC1, 0, 0, 1400, 900, this);
            }
         }
         //EscapeCemetery6 is the 6th story panel
         class EscapeCemetery6 extends JPanel{
            //adds the quit button and the next button
            public EscapeCemetery6(){
                setLayout(new BorderLayout());
                add(northPanel(), BorderLayout.NORTH);
                add(new ButtonPanel(), BorderLayout.SOUTH);
            }
            //this paintComponent simply draws bg for EscapeCemetery6 class
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image escapeC1 = new ImageIcon("res/EscapeCemetery6.gif").getImage();
                g.drawImage(escapeC1, 0, 0, 1400, 900, this);
            }
         }
         //EscapeCemetery7 is the 7th story panel
         class EscapeCemetery7 extends JPanel{
            //adds the quit button and the next button
            public EscapeCemetery7(){
                setLayout(new BorderLayout());
                add(northPanel(), BorderLayout.NORTH);
                add(new ButtonPanel(), BorderLayout.SOUTH);
            }
            //this paintComponent simply draws bg for EscapeCemetery7 class
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image escapeC1 = new ImageIcon("res/EscapeCemetery7.png").getImage();
                g.drawImage(escapeC1, 0, 0, 1400, 900, this);
            }
         }
         //EscapeCemetery8 is the 8th story panel
         class EscapeCemetery8 extends JPanel implements MouseListener{
            //adds the quit button and the next button
            public EscapeCemetery8(){
                setLayout(new BorderLayout());
                add(northPanel(), BorderLayout.NORTH);
                addMouseListener(this);
                //add(new ButtonPanel(), BorderLayout.SOUTH);
            }
            //this paintComponent simply draws bg and adds a button for EscapeCemetery8 class
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image escapeC1 = new ImageIcon("res/EscapeCemetery7.png").getImage();
                g.drawImage(escapeC1, 0, 0, 1400, 900, this);
                
                Image StartButton = new ImageIcon("res/StartButton.png").getImage();
                g.drawImage(StartButton, 1100, 700, 300, 130, this);
            }
            //determines what to do if mouse is clicked
            @Override
            public void mouseClicked(MouseEvent e) {
                //determines what to do if mouse is clicked on the region where the start button falls
                if(e.getX()<=1356 && e.getX()<=1380 && e.getY()<=809 && e.getY()>=730){
                    try {
                        // Load the sound clip from a file
                        Clip clip = AudioSystem.getClip();
                        clip.open(AudioSystem.getAudioInputStream(new File("res/ButtonClick.wav")));
    
                        // Play the sound clip
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    challenge2=new Challenge2();
                    Level1Panel.this.add(challenge2, "panel5");
                    mainCL.show(Level1Panel.this, "panel5");
                }
            }
            //determines what to do if mouse enters the frame
            public void mouseEntered(MouseEvent e) {}

            //determines what to do if mouse exits the frame
            public void mouseExited(MouseEvent e) {}

            //determines what to do if mouse is released
            public void mouseReleased(MouseEvent e) {}

            //determines what to do if mouse is presses
            public void mousePressed(MouseEvent e) {}
         }
         //This class contains the functionality and graphics for the next button
         class ButtonPanel extends JPanel implements MouseListener {

            // Constructor constructs ButtonPanel (e.g. layout, background color)
            public ButtonPanel() {
                setLayout(new BorderLayout());
                setPreferredSize(new Dimension(1400, 250));
                setBackground(new Color(0, 0, 0, 0));
                addMouseListener(this);
            }

            // this paintComponent method draws the next arrow button
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image nextArrButton = new ImageIcon("res/NextArrowButton.png").getImage();
                g.drawImage(nextArrButton, 1250, 100, 150, 100, this);
            }

            // mousePressed determines what to do if mouse is pressed
            public void mousePressed(MouseEvent e) {
                if (e.getX() >= 1250 && e.getX() <= 1400 && e.getY() <= 200 && e.getY() >= 100) {
                    msbCL.next(MiddleStoryBoard.this);
                }
            }

            // mouseClicked determines what to do if mouse is clicked
            public void mouseClicked(MouseEvent e) {}

            // mouseReleased determines what to do if mouse is released
            public void mouseReleased(MouseEvent e) {}

            // mouseExited determines what to do if mouse exits frame
            public void mouseExited(MouseEvent e) {}

            // mouseEntered determines what to do if mouse enters frame
            public void mouseEntered(MouseEvent e) {}

         }
         //This class contains the functionality and graphics for the quit button
        public JPanel northPanel() {
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            panel.setBackground(new Color(0, 0, 0, 0));
            Image img = Toolkit.getDefaultToolkit().getImage("res/QuitButton.png");
            Image img2 = img.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
            ImageIcon buttonIcon = new ImageIcon(img2);
            JLabel quit = new JLabel(buttonIcon);
            quit.setPreferredSize(new Dimension(200, 40));
            quit.setOpaque(true);
            quit.setBackground(new Color(0, 0, 0, 0));
            //quit.addMouseListener(IntroLevelClass.this);
            panel.add(quit);
            //panel.add(HomePage.countdownPanel);
            return panel;
        }
    }


    //Challenge2 contains all the logic and visual effects for the second challenge in level 1
    class Challenge2 extends JPanel implements KeyListener, MouseListener, ActionListener {

    int audioCount;
        //Character class defines the properties of ALL the characters (e.g. ogres + player(girl))
        class Character{
            int X;
            int Y;
            int steps;
            int count;
            boolean attackerAttack;
            double health;
            boolean faceLeft;

            //the character constructor initializes the properties of the character
            public Character(int _X, int _Y, int _count, int _steps, double _health){
                X = _X; //an x pos is passed into the constructor and sets the x value of the character to that value
                Y = _Y; //an y pos is passed into the constructor and sets the y value of the character to that value
                steps = _steps; //how many pixels the character moves for each step
                count = _count; //animation frame count (so like for the "warrior" ogre there are 4 animation panels)
                attackerAttack = false;
                health = _health;
                faceLeft = false;
            }
        }

        int girlIconWidth = 200; //width of ANY character icon
        int girlIconHeight = 200;//height of ANY character icon
        int iconWidth = 200; //width of ANY character icon
        int iconHeight = 200;//height of ANY character icon
        int windowWidth = 0; //Challenge 2 panel width (currently assigned to an incorrect value but in the paintcomponet it will be assigned to the proper width)
        int windowHeight = 0;//Challenge 2 panel height (currently assigned to an incorrect value but in the paintcomponet it will be assigned to the proper height)
        Character girl = new Character(0, 0, 0, 20, 6);
        Character attacker1 = new Character(0, 0, 0, 5 ,6);
        Character attacker2 = new Character(0, 0, 0, 5, 6);
        Character attacker3 = new Character(0, 0, 0, 7, 6);
        private Timer timer;
        int numTimesBloodSpatter;
        int numTimesBloodSpatter2;
        int numTimesBloodSpatter3;
        boolean drawImage = false;
        boolean firstPaint = true;
        boolean spacePressed = false;
        boolean stationary = true;
        boolean attacker1Dead = false;
        boolean attacker2Dead = false;
        boolean attacker3Dead = false;
        ArrayList<Heart> heartArr = new ArrayList<Heart>();
        boolean drawPressSpaceToAttack = true;
        int waitCounter=0;
        int powerUpCount = 0;
        int xPosPowerUp=700;
        boolean obtained = false;
        int yPosPowerUp=400;
        int bloodSpatterCounter=0;
        int bloodSpatterCounter2=0;
        int bloodSpatterCounter3=0;
        boolean earthSwordSelected = false;
        boolean flameSwordSelected = false;
        boolean redSwordSelected = false;
         boolean girlFacingRight = false;
        int healthBarScaleFactor = 5;
        int spacePressedCounter = 0;
        //Challenge 2 constructor adds the mouselistener, keylistener, sets the layout, and adds timer
        public Challenge2() {
            setBackground(Color.PINK);
            addMouseListener(this);
            addKeyListener(this);
            setLayout(null); // TODO why we need null layout?

            timer = new Timer(100, this); // call actionPerformed() every 50 milliseconds
            timer.start();
        }

        //the UpdateAttacker method updates the attacker (the ogres) positions by literally returning a Character obj to place on the panel
        public Character UpdateAttacker(Character _attacker)
        {
            bloodSpatterCounter++;
            bloodSpatterCounter2++;
            bloodSpatterCounter3++;
            
            // System.out.println("Timer event");
            double dx = girl.X - _attacker.X;
            double dy = girl.Y - _attacker.Y;
            double distance = Math.sqrt(dx*dx + dy*dy); //hypotenuse using pythagorean theorem 

            //trigonometry to calculate how the ogre should move to attack the player 
            double direction = Math.atan2(dy, dx); //inverse tan to calculate the angle of elevation from attacker to player 
            double dxNew = _attacker.steps * Math.cos(direction);
            double dyNew = _attacker.steps * Math.sin(direction);

            if (dxNew < 0) _attacker.faceLeft = true;
            else _attacker.faceLeft = false;

            //  System.out.println("dxNew " + dxNew + " dyNew " + dyNew);
            //  System.out.println("girl (" + girl.X + ", "+girl.Y + ") " + "attack (" + _attacker.X + ", " + _attacker.Y+ ")");

            // Update character position
            if (distance > 30.0){
                _attacker.X += dxNew;
                _attacker.Y += dyNew;
            }

            //if (distance > 120.0 && girl.health<6) girl.health+=0.005;
            for(int i = 0; i<heartArr.size(); i++){
                if (Math.abs(heartArr.get(i).xPosPowerUp - (girl.X + 80)) < 20 && Math.abs(heartArr.get(i).yPosPowerUp - (girl.Y + 137)) < 20 && girl.health<6) {
                    girl.health+=0.1;
                    heartArr.get(i).obtained=true;
                }
            }

            //this is saying that if the distance between any one of the ogre's and the player is less than 30
            //the player's lives will decrease
            if ((distance <= 30.0) && !firstPaint){
                audioCount++;
                boolean playAudio=false;
                _attacker.attackerAttack=true;
                if (_attacker.health>0){
                    girl.health-=0.10; //only decrease the player's health if the attacker is still "alive"
                    // if(audioCount%3==0) {
                    //         try {
                    //         // Load the sound clip from a file
                    //         Clip clip = AudioSystem.getClip();
                    //         clip.open(AudioSystem.getAudioInputStream(new File("res/playerGrunt.wav")));
        
                    //         // Play the sound clip
                    //         clip.start();
                    //     } catch (Exception ex) {
                    //         ex.printStackTrace();
                    //     }
                    // }
                }
                //if(spacePressed && earthSwordSelected && _attacker == attacker1) _attacker.health-=1;
                if(spacePressed && earthSwordSelected && _attacker == attacker1)
                { 
                    //System.out.println("Space pressed" + spacePressedCounter++);
                    _attacker.health-=0.15;
                    playAudio=true;

                }
                if(spacePressed && redSwordSelected && _attacker == attacker2)
                { 
                    _attacker.health-=0.15;
                    playAudio=true;

                }
                if(spacePressed && flameSwordSelected && _attacker == attacker3)
                { 
                    _attacker.health-=0.15;
                    playAudio=true;
                }

                if(audioCount%3==0 && playAudio){
                    // try {
                    //     // Load the sound clip from a file
                    //     Clip clip = AudioSystem.getClip();
                    //     clip.open(AudioSystem.getAudioInputStream(new File("res/oof.wav")));

                    //     // Play the sound clip
                    //     clip.start();
                    // } catch (Exception ex) {
                    //     ex.printStackTrace();
                    // }
                }
                //if(_attacker.health==24) drawHB1 = true;
            }
            else _attacker.attackerAttack = false;

            if(girl.health<=0){
                mainCL.show(Level1Panel.this, "panel3");
                try {
                    // Load the sound clip from a file
                    Clip clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(new File("res/girlScream.wav")));

                    // Play the sound clip
                    clip.start();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            return _attacker;

        }

        //this actionPerformed method calls update attacker every 100 milliseconds (bc of the timer)
        @Override
        public void actionPerformed(ActionEvent e) {
            timer.stop();
            attacker1 = UpdateAttacker(attacker1);
            attacker2 = UpdateAttacker(attacker2);
            attacker3 = UpdateAttacker(attacker3);
            powerUpCount++;
            // if(powerUpCount==60) powerUpCount=0;
            drawImage = true;
            repaint();
        }

//defines how the power up count heart should behave
//i.e. the random interval + when its produced
class Heart {
    public boolean obtained;
    int xPosPowerUp=0;
    int yPosPowerUp=0;
    boolean alive=true;
    int counter=0;
    Image heart;
    //constructs the random position of the heart
    public Heart(){
        heart = new ImageIcon("res/powerUpHeart.png").getImage();
        xPosPowerUp = (int)(Math.random()*1000+100);
        yPosPowerUp = (int)(Math.random()*500+100);
    }
    //draws the heart
    public void drawHeart(Graphics g){
        if(alive){
            g.drawImage(heart, xPosPowerUp, yPosPowerUp, 30, 30, null);
        }
        counter++;
        if(counter>=50) alive=false;
        if(counter>=40 && counter<=50) {
            alive=!alive;
        }
        
    }
    //  public Heart(Graphics g){
    //     Image heart = new ImageIcon("res/powerUpHeart.png").getImage();
    //     if(powerUpCount==0){
    //         xPosPowerUp = (int)(Math.random()*1000+100);
    //         yPosPowerUp = (int)(Math.random()*500+100);
    //     }
    //     if(powerUpCount<=90 && powerUpCount>=0) {
    //         if(!obtained) g.drawImage(heart, xPosPowerUp, yPosPowerUp, 30, 30, null);
    //     }
    //     if(powerUpCount<=110 && powerUpCount>=90) {
    //         if(powerUpCount%4==0) g.drawImage(heart, xPosPowerUp, yPosPowerUp, 30, 30, null);
    //     }
    // }
}
     // This method flips the img 
    public static BufferedImage flipImage(Image image) {
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Get the Graphics2D object from the BufferedImage
        Graphics2D g2d = bufferedImage.createGraphics();

        // Flip the image using AffineTransform
        AffineTransform transform = new AffineTransform();
        transform.translate(image.getWidth(null), 0);
        transform.scale(-1, 1);

        g2d.drawImage(image, transform, null);

        // Dispose the Graphics2D object
        g2d.dispose();

        return bufferedImage;
    }


        // paintcomponent draws the visual components of the challenge
        public void paintComponent(Graphics g){
            mainCL.show(Level1Panel.this, "panel6");
            Image forestEnchanted = new ImageIcon("res/ForestLevel1Bg.png").getImage();
            Image pressSpaceToAttack = new ImageIcon("res/PressSpaceToAttack.png").getImage();
            g.drawImage(forestEnchanted, 0, 0, 1400, 870, this);
            
            if(drawPressSpaceToAttack) g.drawImage(pressSpaceToAttack, 0,0,300, 100, this);

            // System.out.println("Paint event");
            if (firstPaint)
            {
                firstPaint = false;
                windowWidth = getWidth();
                windowHeight = getHeight();
                girl.X = (windowWidth)/2-iconWidth;
                girl.Y = (windowHeight)/2-iconHeight;
                attacker2.X = windowWidth-iconWidth;
                attacker2.Y = windowHeight-iconHeight;
                attacker3.X = (windowWidth)/2-iconWidth;
                attacker3.Y = windowHeight-iconHeight;
            }

            if (drawImage){
                Image healthbar; 
                Image girlImage;

                healthbar = new ImageIcon("res/0" + (int)(7-girl.health -1)+ "_healthbar.png").getImage();
                g.drawImage(healthbar, 1100, 0, 300, 100, this);
                

                Image swordSelectedImg = new ImageIcon("res/swordSelectedImg.png").getImage();
                Image earthSwordSelectedImg = new ImageIcon("res/earthSwordSelectedImg.png").getImage();
                Image flameSwordSelectedImg = new ImageIcon("res/flameSwordSelectedImg.png").getImage();
                Image redSwordSelectedImg = new ImageIcon("res/redSwordSelectedImg.png").getImage();
                if(!earthSwordSelected && !redSwordSelected && !flameSwordSelected) g.drawImage(swordSelectedImg, 1150, 100, 250, 250, this); 
                if(earthSwordSelected && !redSwordSelected && !flameSwordSelected) g.drawImage(earthSwordSelectedImg, 1150, 100, 250, 250, this); 
                if(!earthSwordSelected && redSwordSelected && !flameSwordSelected) g.drawImage(redSwordSelectedImg, 1150, 100, 250, 250, this); 
                if(!earthSwordSelected && !redSwordSelected && flameSwordSelected) g.drawImage(flameSwordSelectedImg, 1150, 100, 250, 250, this); 
                //if the space key is pressed draw the cast sequence 
                if(spacePressed) {
                    
                    if(earthSwordSelected) girlImage = new ImageIcon("res/cast"+girl.count+"EarthSword.png").getImage();
                    else if(redSwordSelected) girlImage = new ImageIcon("res/cast"+girl.count+"RedSword.png").getImage();
                    else if(flameSwordSelected) girlImage = new ImageIcon("res/cast"+girl.count+"FlameSword.png").getImage();
                    else girlImage = new ImageIcon("res/cast"+girl.count+".png").getImage();
                    if(girl.count==6)spacePressed=false;
                }

                //if the girl is not stationary (i.e. the user pressed the arrow keys so she should be walking)
                else if(!stationary){ 
                    girlImage = new ImageIcon("res/0"+girl.count+"_Walk.png").getImage();
                    stationary=true;
                }
                else  girlImage = new ImageIcon("res/00_Walk.png").getImage();
                //g.drawImage(girlImage, girl.X, girl.Y, 300, 300, this);
      
                if (girlFacingRight){
                    BufferedImage flippedImage = flipImage(girlImage);
                    g.drawImage(flippedImage, girl.X, girl.Y, iconWidth, iconHeight, this);
                }
                else
                {
                    g.drawImage(girlImage, girl.X, girl.Y, iconWidth, iconHeight, this);
                }


                Image attackImage;


                if(attacker1.health>0){ //if the attacker is still alive
                    //if the "attackerAttack" of the attacker1 obj is true then draw the attack sequence 
                    if(attacker1.attackerAttack) attackImage = new ImageIcon("res/0" + attacker1.count+ "_Warrior_1.png").getImage();
                    //otherwise draw the running sequence 
                    else attackImage = new ImageIcon("res/0" + attacker1.count+ "_WarriorRun.png").getImage();

                    Image healthImage = new ImageIcon("res/0" + (int)(7-attacker1.health -1)+ "_healthbar2.png").getImage();
                    g.drawImage(healthImage, attacker1.X+10, attacker1.Y-10, iconWidth-40, iconHeight-70, this);

                    if (attacker1.faceLeft){
                        BufferedImage attackFlippedImage = flipImage(attackImage);
                        g.drawImage(attackFlippedImage, attacker1.X, attacker1.Y, iconWidth, iconHeight, this);
                    }
                    else
                    g.drawImage(attackImage, attacker1.X, attacker1.Y, iconWidth, iconHeight, this);
                }
                else {
                    Image bloodSpatter = new ImageIcon("res/bloodspatter.png").getImage();
                    if(bloodSpatterCounter%2==0 && numTimesBloodSpatter<=3) {
                        numTimesBloodSpatter++;
                        g.drawImage(bloodSpatter, attacker1.X, attacker1.Y, iconWidth, iconHeight, this);
                    }
                    
                    attacker1Dead=true;
                }

                if(attacker2.health>0){
                    //if the "attackerAttack" of the attacker2 obj is true then draw the attack sequence 
                    if(attacker2.attackerAttack) attackImage = new ImageIcon("res/0" + attacker2.count+ "_Berserk_1.png").getImage();
                    //otherwise draw the running sequence 
                    else attackImage = new ImageIcon("res/0" + attacker2.count+ "_OgreRun.png").getImage();

                    Image healthImage = new ImageIcon("res/0" + (int)(7-attacker2.health -1)+ "_healthbar2.png").getImage();
                    g.drawImage(healthImage, attacker2.X+10, attacker2.Y-10, iconWidth-40, iconHeight-70, this);

                    if (attacker2.faceLeft){
                        BufferedImage attackFlippedImage = flipImage(attackImage);
                        g.drawImage(attackFlippedImage, attacker2.X, attacker2.Y, iconWidth, iconHeight, this);

                    }
                    else
                        g.drawImage(attackImage, attacker2.X, attacker2.Y, iconWidth, iconHeight, this);
                }
                else{
                    Image bloodSpatter = new ImageIcon("res/bloodspatter.png").getImage();
                    if(bloodSpatterCounter2%2==0 && numTimesBloodSpatter2<=3) {
                        numTimesBloodSpatter2++;
                        g.drawImage(bloodSpatter, attacker2.X, attacker2.Y, iconWidth, iconHeight, this);
                    }
                    
                    attacker2Dead=true;
                    
                }

                if(attacker3.health>0){


                    Image healthImage = new ImageIcon("res/0" + (int)(7-attacker3.health -1)+ "_healthbar2.png").getImage();
                    g.drawImage(healthImage, attacker3.X+10, attacker3.Y-10, iconWidth-40, iconHeight-70, this);

                    //if the "attackerAttack" of the attacker3 obj is true then draw the attack sequence 
                    if(attacker3.attackerAttack) attackImage = new ImageIcon("res/0" + attacker3.count+ "_Shaman_1.png").getImage();
                    //otherwise draw the running sequence 
                    else attackImage = new ImageIcon("res/0" + attacker3.count+ "_ShamanRun.png").getImage();
                    if (attacker3.faceLeft){
                        BufferedImage attackFlippedImage = flipImage(attackImage);
                        g.drawImage(attackFlippedImage, attacker3.X, attacker3.Y, iconWidth, iconHeight, this);
                    }
                    else{
                        g.drawImage(attackImage, attacker3.X, attacker3.Y, iconWidth, iconHeight, this);
                    }
                }
                else {
                    Image bloodSpatter = new ImageIcon("res/bloodspatter.png").getImage();
                    if(bloodSpatterCounter%2==0 && numTimesBloodSpatter3<=3) {
                        numTimesBloodSpatter3++;
                        g.drawImage(bloodSpatter, attacker3.X, attacker3.Y, iconWidth, iconHeight, this);
                    }

                    attacker3Dead=true;
                }

                //if all the ogres are dead 
                if(attacker1Dead && attacker2Dead && attacker3Dead) {  
                    waitCounter++;
                    if(waitCounter==15){ //wait a little bit
                        msb2 = new MiddleStoryBoard2();
                        Level1Panel.this.add(msb2, "panel6");
                        mainCL.show(Level1Panel.this, "panel6");
                    }
                }

                drawImage = false;
                //if(girl.count<=7) girl.count++;
                //else girl.count=0;
                girl.count = (girl.count + 1) % 7; // cycle through frames
                attacker1.count = (attacker1.count + 1) % 4; // cycle through frames
                attacker2.count = (attacker2.count + 1) % 4; // cycle through frames
                attacker3.count = (attacker3.count + 1) % 4; // cycle through frames
                
                timer.start();
            }
            if(powerUpCount%60 == 0) {
                Heart hh = new Heart();
                heartArr.add(hh);
            }
            for(int i = 0; i<heartArr.size(); i++){
                if(!heartArr.get(i).obtained) heartArr.get(i).drawHeart(g);
            }
            requestFocus();
           
        }
        //determines what to do if mouse is clicked
        @Override
        public void mouseClicked(MouseEvent e) {
            
        }
        //determines what to do if mouse enters the panel
        @Override
        public void mouseEntered(MouseEvent e) {}
        //determines what to do if mouse exits the panel
        @Override
        public void mouseExited(MouseEvent e) {}
        //determines what to do if mouse is released
        @Override
        public void mouseReleased(MouseEvent e) {}
        //determines what to do if mouse is pressed
        @Override
        public void mousePressed(MouseEvent e) {}

        // this keypressed method determines what to do if any of the arrow keys are
        // pressed
        public void keyPressed(KeyEvent e) {
            drawPressSpaceToAttack=false;
            if(e.getKeyCode()==KeyEvent.VK_A){
                earthSwordSelected=true;
                flameSwordSelected=false;
                redSwordSelected=false;
            }
            else if(e.getKeyCode()==KeyEvent.VK_S){
                redSwordSelected=true;
                earthSwordSelected=false;
                flameSwordSelected=false;
            }
            else if(e.getKeyCode()==KeyEvent.VK_D){
                redSwordSelected=false;
                earthSwordSelected=false;
                flameSwordSelected=true;
            }
            if(e.getKeyCode()== KeyEvent.VK_SPACE){
                girl.count = 0;
                spacePressed=true;
            }

            if (e.getKeyCode() == KeyEvent.VK_LEFT){
                girl.X -= girl.steps; //minus the amount of pixels to the girl's x pos to move left
                stationary=false;
                girlFacingRight = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                girl.X += girl.steps; //add the amount of pixels to the girl's x pos to move left
                stationary=false;
                girlFacingRight = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN){
                girl.Y += girl.steps;
                stationary=false;
            }
            if (e.getKeyCode() == KeyEvent.VK_UP){
                girl.Y -= girl.steps; 
                stationary=false;
            }

            girl.X = Math.min(windowWidth-iconWidth, Math.max(0, girl.X)); 
            girl.Y = Math.min(windowHeight-iconHeight, Math.max(0, girl.Y));
            // System.out.println("keyPressed " + girl.X + " " + girl.Y);
        }

        // determines what happens if a key is released
        public void keyReleased(KeyEvent e) { }

        // determines what happens if a key is typed
        public void keyTyped(KeyEvent e) { }

    }

    // similar to the first middlestoryboard
    class MiddleStoryBoard2 extends JPanel implements MouseListener{
        // constructor adds some componets to the middle story board
        public MiddleStoryBoard2() {
            addMouseListener(this);
            HomePage.level12Unlocked=true;
            HomePage.level123Unlocked=false;
            //HomePage.cl.show(HomePage.mainPanel, "homePagePanel");
        }

        // determines what to do if the next button is clicked
        public void paintComponent(Graphics g){
            Image congrats = new ImageIcon("res/CongratsLevel1.png").getImage();
            g.drawImage(congrats, 0, 0, 1400, 900, this);
            Image proceed = new ImageIcon("res/Proceed.png").getImage();
            g.drawImage(proceed, 1100, 600, 300, 100, this);

        }
        //determines what to do if mouse is clicked
        @Override
        public void mouseClicked(MouseEvent e) {
           if(e.getX()>=1115 && e.getX()<=1374 && e.getY()>=616 && e.getY()<=682){
            HomePage.cl.show(HomePage.mainPanel, "homePagePanel");
           }
            
        }
        //determines what to do if mouse enters the panel
        @Override
        public void mouseEntered(MouseEvent e) {}
        //determines what to do if mouse exits the panel
        @Override
        public void mouseExited(MouseEvent e) {}
        //determines what to do if mouse is released
        @Override
        public void mouseReleased(MouseEvent e) {}
        //determines what to do if mouse is pressed
        @Override
        public void mousePressed(MouseEvent e) {}
    }

       // this panel is shown if the player dies
       class DeathScreen extends JPanel implements MouseListener{

        //constructor just adds mouselistener
        public DeathScreen(){
            addMouseListener(this);
        }
        // paintcomponent draws all the visual components of deathscreen
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Image bg = new ImageIcon("res/red.gif").getImage();
            g.drawImage(bg, 0, 0, 1400, 900, this);
            Image youdied = new ImageIcon("res/YouDied.png").getImage();
            g.drawImage(youdied, 0, 0, 1400, 900, this);
        }
        // mousePRessed determines what to do if mouse is pressed
        public void mousePressed(MouseEvent e) {
            
        }
         // mouseClicked determines what to do if mouse is clicked
         public void mouseClicked(MouseEvent e) {
            if(e.getX()>=395 && e.getX()<=1054 && e.getY()>=465 && e.getY()<=692){
                Main.mainFrame.setVisible(false);
                Main.mainFrame.remove(Main.hp);
                Main.mainFrame.revalidate();
                try {
                    Main.mainFrame.add(new HomePage());
                } catch (UnsupportedAudioFileException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (LineUnavailableException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (FontFormatException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                Main.mainFrame.setVisible(true);
              // HomePage.cl.show(HomePage.mainPanel, "homePagePanel");
        // try {
        //     Main.createNewMain("Murder On Enchanted Island");
        // } catch (UnsupportedAudioFileException e1) {
        //     // TODO Auto-generated catch block
        //     e1.printStackTrace();
        // } catch (IOException e1) {
        //     // TODO Auto-generated catch block
        //     e1.printStackTrace();
        // } catch (LineUnavailableException e1) {
        //     // TODO Auto-generated catch block
        //     e1.printStackTrace();
        // } catch (FontFormatException e1) {
        //     // TODO Auto-generated catch block
        //     e1.printStackTrace();
        // }
        try {
            // Load the sound clip from a file
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("res/ButtonClick.wav")));

            // Play the sound clip
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
            }
        }

        // mouseReleased determines what to do if mouse is released
        public void mouseReleased(MouseEvent e) {
        }

        // mouseExited determines what to do if mouse exits frame
        public void mouseExited(MouseEvent e) {
        }

        // mouseEntered determines what to do if mouse enters frame
        public void mouseEntered(MouseEvent e) {
        }
    }
}