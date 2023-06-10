/* 
    Tashvi Bansal (Period 5)
    HomePage.java
    04/29/23
    This class contains the homepage itself as well as the cardlayout that can access other major panels of the game
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.sound.sampled.*;

//THIS CLASS IS NOT RUNNABLE, PLEASE RUN & COMPILE MAIN.JAVA

//The HomePage class contains ALL other panels via card layout (e.g. Level1Panel, Level2Panel, Level3Panel)
class HomePage extends JPanel {
    public static CardLayout cl;
    public static JPanel countdownPanel = new JPanel();
    public static JLabel countdownLabel = new JLabel("15:00");
    Image bg;
    public static JPanel homePagePanel;
    Level1Panel level1Pan;
    public static Clip clip;
    Level2Panel level2Pan;
    Level3Panel level3Pan;
    public static JPanel mainPanel;
    HomeScreenAudio hsa;
    LavaAnimation lavaAnimation;
    public static boolean level12Unlocked;
    public static boolean level123Unlocked;
    Map map;
    // New instance of HomePage
    public static void main(String[] args)
            throws UnsupportedAudioFileException, IOException, LineUnavailableException, FontFormatException {
        HomePage hp = new HomePage();
    }

    // Plays audio clip
    class HomeScreenAudio {

        // HomeScreenAudio constructor intiliatizes the clip variable and opens and
        // starts playing the clip
        public HomeScreenAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
            File audioFile = new File("res/HomeScreenAudio.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        }
    }

    // HomePage (which is a JPanel) acts as a container for the mainPanel JPanel
    public HomePage() throws UnsupportedAudioFileException, IOException, LineUnavailableException, FontFormatException {
        level123Unlocked=false;
        level12Unlocked=false;
        lavaAnimation = new LavaAnimation();
        System.out.println("inside homepage constructor");
        level3Pan = new Level3Panel();
        level2Pan = new Level2Panel();
        level1Pan = new Level1Panel();
        map = new Map();
        hsa = new HomeScreenAudio();
        setLayout(new BorderLayout());
        mainPanel = new JPanel(); // panel that holds all the level panels in a card layou
        add(mainPanel, BorderLayout.CENTER);
        mainPanel.setSize(900, 900);
        cl = new CardLayout();
        mainPanel.setLayout(cl); // mainPanel is the"main panel" that holds all the other panels this 
        //includes the lava animation panel, home screen panel, and level 1,2,3 panels
        mainPanel.add(lavaAnimation, "lavaAnimation");
         mainPanel.add(level1Pan, "level1"); //delete this later
        mainPanel.add(map, "mapPanel");
        mainPanel.add(level2Pan, "level2"); //delete this later
        mainPanel.add(level3Pan, "level3"); //delete this later
        cl.show(mainPanel, "lavaAnimation"); //delete this later

    }

    // Renders a lava animation (lava spews from the island )
    class LavaAnimation extends JPanel {
        int paintCount; // paintCount is to delay the lava animation screen
        // paintComponent method paints the background and the lava drip gifs and
        // explosion gif
        public void paintComponent(Graphics g) {
            paintCount++;

            // background of island
            Image HomePageBackground = new ImageIcon("res/HomePageBackground.jpg").getImage();
            g.drawImage(HomePageBackground, 0, 0, 1400, 890, this);

            // explosion gif
            Image explosion = new ImageIcon("res/Explosion.gif").getImage();
            g.drawImage(explosion, 580, -40, 290, 270, this);

            // lava drip at the mouth of the island/volcano
            Image lavaDrip = new ImageIcon("res/LavaDrip.gif").getImage();
            g.drawImage(lavaDrip, 640, 90, 180, 180, this);

            // lava driping down the island/volcano
            Image lavaDripDown = new ImageIcon("res/LavaDripDown2.gif").getImage();
            g.drawImage(lavaDripDown, 400, 170, 700, 600, this);
            if (paintCount == 35) { // waits for 50 paintComponent calls before switching panels
                                    // note that paintComponent is only called continuously in this case bc it is
                                    // drawing a gif
                try {
                    homePagePanel = new HomePagePanel();
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                }
                mainPanel.add(homePagePanel, "homePagePanel");
                cl.show(mainPanel, "homePagePanel");
            }

        }
    }


    //acts as a "key" or map for the user to get to know more about eEchanted Island
    class Map extends JPanel implements MouseListener{
        boolean drawCem;
        boolean drawForest;
        boolean drawOtherForest;

        //Map constructor initlizes variables and adds the mouse listener 
        public Map(){
            drawCem=false;
            drawForest=false;
            drawOtherForest=false;
            addMouseListener(this);

        }

        //paintcomponet draws the visual components of the map
        public void paintComponent(Graphics g){
            Image map = new ImageIcon("res/mapimg.png").getImage();
            g.drawImage(map, 0, 0, 1400, 860, this);

            if(drawCem){
                Image mapCem = new ImageIcon("res/mapimgcemetery.png").getImage();
                g.drawImage(mapCem, 0, 0, 1400, 860, this);
            }
            if(drawForest){
                Image mapFor = new ImageIcon("res/mapimgforest.png").getImage();
                g.drawImage(mapFor, 0, 0, 1400, 860, this);
            }
            if(drawOtherForest){
                Image mapFor = new ImageIcon("res/mapimgotherforest.png").getImage();
                g.drawImage(mapFor, 0, 0, 1400, 860, this);
            }

        }

        // mousePressed determines what to do if mouse is released
        public void mousePressed(MouseEvent e) {
                    
        }

        // mouseClicked determines what to do if mouse is clicked
        public void mouseClicked(MouseEvent e) {
            System.out.println("x: " + e.getX() + "     y: " + e.getY());
            if (e.getX() >= 1168 && e.getX() <= 1390 && e.getY() <= 96 && e.getY() >= 19) {
                cl.show(mainPanel, "homePagePanel");
            }
            if (e.getX() >= 678 && e.getX() <= 719 && e.getY() <= 446 && e.getY() >= 397) {
                drawCem=true;
                drawForest=false;
                drawOtherForest=false;
            }
            if (e.getX() >= 696 && e.getX() <= 740 && e.getY() <= 367 && e.getY() >= 316) {
                drawForest=true;
                drawCem=false;
                drawOtherForest=false;
            }
            if (e.getX() >= 932 && e.getX() <= 979 && e.getY() <= 236 && e.getY() >= 171) {
                drawOtherForest=true;
                drawCem=false;
                drawForest=false;
            }
            repaint();
        }

        // mouseReleased determines what to do if mouse is released
        public void mouseReleased(MouseEvent e) {}

        // mouseExited determines what to do if mouse exits frame
        public void mouseExited(MouseEvent e) {}

        // mouseEntered determines what to do if mouse enters frame
        public void mouseEntered(MouseEvent e) {}
    }

    // HomePagePanel holds all the visual components of the homescreen
    class HomePagePanel extends JPanel implements MouseListener{

        // HomePagePanel constructor instantiates all the visual componets of homescreen
        public HomePagePanel() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
            setLayout(new BorderLayout());
            addMouseListener(this);
            // Center panel holds all the level buttons
            CenterPanel centerPanel = new CenterPanel();
            add(centerPanel, BorderLayout.CENTER);

            // east and west are just space filler panels
            JPanel east = new JPanel();
            east.setPreferredSize(new Dimension(300, 700));
            east.setBackground(new Color(0, 0, 0, 0));
            JPanel west = new JPanel();
            west.setBackground(new Color(0, 0, 0, 0));
            west.setPreferredSize(new Dimension(300, 700));
            add(east, BorderLayout.EAST);
            add(west, BorderLayout.WEST);

            // Northpanel holds the title image
            NorthPanel northPanel = new NorthPanel();
            add(northPanel, BorderLayout.NORTH);
            add(new RunningMan(), BorderLayout.SOUTH); // animation of characters runinng
        }
        // mousePressed determines what to do if mouse is pressed
        public void mousePressed(MouseEvent e) {
                    
        }

        // mouseClicked determines what to do if mouse is clicked
        public void mouseClicked(MouseEvent e) {
            System.out.println("x: " + e.getX() + "     y: " + e.getY());
            if (e.getX() >= 1168 && e.getX() <= 1390 && e.getY() <= 96 && e.getY() >= 19) {
                cl.show(mainPanel, "mapPanel");
            }
        }

        // mouseReleased determines what to do if mouse is released
        public void mouseReleased(MouseEvent e) {}

        // mouseExited determines what to do if mouse exits frame
        public void mouseExited(MouseEvent e) {}

        // mouseEntered determines what to do if mouse enters frame
        public void mouseEntered(MouseEvent e) {}

        // paintComponent draws the background for the homepage and adds a lava drip gif
        // on top of the background
        public void paintComponent(Graphics g) {

            double thing = (getHeight() * ((double) ((double) (50) / (double) (getHeight()))));
            int thing2 = (int) (thing);
            Image HomePageBackground = new ImageIcon("res/HomePageBackground.jpg").getImage();
            g.drawImage(HomePageBackground, 0, 0, 1400, getHeight() + (thing2), this);

            Image lavaDrip = new ImageIcon("res/LavaDrip.gif").getImage();
            g.drawImage(lavaDrip, 640, 90, 180, 180, this);
        }
    }

    // CenterPanel holds all the level buttons and contains code for what to do if a
    // level button is clicked
    class CenterPanel extends JPanel implements MouseListener, MouseMotionListener {
        // All the level "buttons" (they're actually JLabels)
        JLabel level1Label, level2Label, level3Label;

        // boolean for if hovering over button, make button appear larger
        boolean makeLevel1ButtonBigger, makeLevel2ButtonBigger, makeLevel3ButtonBigger;

        // constructor for centerPanel, holds three buttons in a gridLayout
        // these buttons also have functions (hence the addition of MouseMotionListener
        // and MouseListener)
        public CenterPanel() {
            setLayout(new GridLayout(3, 1)); // 3 rows to hold three buttons
            addMouseMotionListener(this);
            addMouseListener(this);
            setBackground(new Color(0, 0, 0, 0));
        }

        // paintComponent method draws background of center panel and lava drip gif
        // also draws bigger buttons if the mouse is hovering over the button (uses
        // boolean)
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int screenWidth = (int) screenSize.getWidth();

            Image centerPanelBg = new ImageIcon("res/CenterPanelBg.png").getImage();
            g.drawImage(centerPanelBg, 0, 0, 800, getHeight(), this);

            Image lavaDripDown = new ImageIcon("res/LavaDripDown2.gif").getImage();
            g.drawImage(lavaDripDown, 30, 0, 850, 600, this);

            Image level1Image = new ImageIcon("res/Level1Button.png").getImage();
            if (makeLevel1ButtonBigger) {
                g.drawImage(level1Image, 260 - ((385 - 345) / 2), -90 - ((385 - 345) / 2), 385, 385, this);
            } else
                g.drawImage(level1Image, 260, -90, 345, 345, this);

                Image level2Image;
            if(level12Unlocked) level2Image = new ImageIcon("res/Level2Button.png").getImage();
            else level2Image = new ImageIcon("res/LockedLevel2Button.png").getImage();
            if (makeLevel2ButtonBigger) {
                g.drawImage(level2Image, 260 - ((385 - 345) / 2), 50 - ((385 - 345) / 2), 385, 385, this);
            } else
                g.drawImage(level2Image, 260, 50, 345, 345, this);

            Image level3Image;
            if(level123Unlocked) level3Image = new ImageIcon("res/Level3Button.png").getImage();
            else level3Image = new ImageIcon("res/LockedLevel3Button.png").getImage();
            if (makeLevel3ButtonBigger) {
                g.drawImage(level3Image, 260 - ((385 - 345) / 2), 190 - ((385 - 345) / 2), 385, 385, this);
            } else
                g.drawImage(level3Image, 260, 190, 345, 345, this);
        }

        // determines what happens if mouse is clicked
        @Override
        public void mouseClicked(MouseEvent e) {
            // if the mouse is clicked on the region that the level1 button covers
            // then a button click audio will play
            // and the user will be transferred to a different screen that holds the
            // gameplay for level1
            if (e.getX() <= 516 && e.getX() >= 342 && e.getY() <= 100 && e.getY() >= 24) {
                
                //level1Pan = new Level1Panel();
                //level1Pan.setPreferredSize(new Dimension(1400, 900));
                // mainPanel.add(level1Pan, "level1"); // comment this back in later
                cl.show(mainPanel, "level1");

                // audio for button click
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

            // if the mouse is clicked on the region that the level3 button covers
            // then a button click audio will play
            // and the user will be transferred to a different screen that holds the
            // gameplay for level2
            if (e.getX() <= 516 && e.getX() >= 342 && e.getY() <= 243 && e.getY() >= 164) {
                level2Pan.setPreferredSize(new Dimension(1400, 900));
                if(level12Unlocked){
                    mainPanel.add(level2Pan, "level2");
                    cl.show(mainPanel, "level2");
                }

                // audio for button click
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

            // if the mouse is clicked on the region that the level3 button covers
            // then a button click audio will play
            // and the user will be transferred to a different screen that holds the
            // gameplay for level3
            if (e.getX() <= 516 && e.getX() >= 342 && e.getY() <= 380 && e.getY() >= 305) {
                if(level123Unlocked){
                    mainPanel.add(level3Pan, "level3");
                    cl.show(mainPanel, "level3");
                }

                // audio for button click
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

        // the following have no purpose and are only present because interfaces require
        // one to implement all methods
        // determines what happens if mouse is pressed
        @Override
        public void mousePressed(MouseEvent e) {
        }

        // determines what happens if mouse is released
        @Override
        public void mouseReleased(MouseEvent e) {
        }

        // determines what happens if mouse enters frame
        @Override
        public void mouseEntered(MouseEvent e) {
        }

        // determines what happens if mouse exits frame
        @Override
        public void mouseExited(MouseEvent e) {
        }

        // determines what happens if mouse is dragged
        @Override
        public void mouseDragged(MouseEvent e) {
        }

        // determines what happens if mouse is moved (see code for further explanantion)
        @Override
        public void mouseMoved(MouseEvent e) {
            // if mouse is hovering over the region that level1 button covers
            if (e.getX() <= 516 && e.getX() >= 342 && e.getY() <= 100 && e.getY() >= 24) {
                makeLevel1ButtonBigger = true; // boolean to make the level1button bigger becomes true
                                               // so that when paintComponent is called it paints the button to be
                                               // bigger
            } else
                makeLevel1ButtonBigger = false;

            // if mouse is hovering over the region that level2 button covers
            if (e.getX() <= 516 && e.getX() >= 342 && e.getY() <= 243 && e.getY() >= 164) {
                makeLevel2ButtonBigger = true;// boolean to make the level2button bigger becomes true
                                              // so that when paintComponent is called it paints the button to be bigger
            } else
                makeLevel2ButtonBigger = false;

            // if mouse is hovering over the region that level3 button covers
            if (e.getX() <= 516 && e.getX() >= 342 && e.getY() <= 380 && e.getY() >= 305) {
                makeLevel3ButtonBigger = true;// boolean to make the level3button bigger becomes true
                                              // so that when paintComponent is called it paints the button to be bigger
            } else
                makeLevel3ButtonBigger = false;
            repaint();
        }
    }

    // NorthPanel just holds the title gif
    class NorthPanel extends JPanel {
        // sets size of northpanel to 1400x250
        public NorthPanel() {
            setPreferredSize(new Dimension(1400, 250));
        }

        // draws a gif of the gametitle
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Image gameTitleGif = new ImageIcon("res/GameTitle2.png").getImage();
            g.drawImage(gameTitleGif, -2, 0, 1405, 255, this);
        }
    }
    // Running animation in the south panel (done using paint component)
    class RunningMan extends JPanel {
        int dudeX;
        Timer dudetimer;
        boolean kill;
        boolean timerPaint;
        int switchPanelCount;
        int switchPanelCount2;

        // constructor for running man, initializes all values
        public RunningMan() {
            dudeX = 10; // starting x position of the running people
            kill = false; // boolean determines whether or not kill animation should be played
            DudeMover dm = new DudeMover(); // action listener
            dudetimer = new Timer(200, dm); // timer to control the speed of the running peole
            dudetimer.start(); // start timer
            switchPanelCount = 1;// switchPanelCount orders the switching of panels in the people running
                                 // animation
            switchPanelCount2 = 0; // switchPanelCount2 orders the switching of panels in the girl dying animation
            setPreferredSize(new Dimension(1400, 180));

        }

        // returnImage() returns an image in the sequence of the girl dying
        public Image returnImage() {
            switchPanelCount2++;
            if (switchPanelCount2 == 1) {
                Image dyingGirl = new ImageIcon("res/00_Dead.png").getImage();
                return (dyingGirl);
            } else if (switchPanelCount2 == 2) {
                Image dyingGirl = new ImageIcon("res/01_Dead.png").getImage();
                return (dyingGirl);
            } else if (switchPanelCount2 == 3) {
                Image dyingGirl = new ImageIcon("res/02_Dead.png").getImage();
                return (dyingGirl);
            } else if (switchPanelCount2 == 4) {
                Image dyingGirl = new ImageIcon("res/03_Dead.png").getImage();
                return (dyingGirl);
            } else if (switchPanelCount2 == 5) {
                Image dyingGirl = new ImageIcon("res/04_Dead.png").getImage();
                return (dyingGirl);
            } else if (switchPanelCount2 == 6) {
                Image dyingGirl = new ImageIcon("res/05_Dead.png").getImage();
                return (dyingGirl);
            } else if (switchPanelCount2 == 7) {
                Image dyingGirl = new ImageIcon("res/06_Dead.png").getImage();
                return (dyingGirl);
            } else if (switchPanelCount2 == 8) {
                Image dyingGirl = new ImageIcon("res/07_Dead.png").getImage();
                return (dyingGirl);
            } else if (switchPanelCount2 == 9) {
                Image dyingGirl = new ImageIcon("res/08_Dead.png").getImage();
                return (dyingGirl);
            } else if (switchPanelCount2 == 10) {
                Image dyingGirl = new ImageIcon("res/09_Dead.png").getImage();
                switchPanelCount2 = 0;
                return (dyingGirl);
            }
            return (bg);
        }

        // draws two images in sequence of the boy running (with knife) and girl running
        // away
        // BUT if the kill boolean is true, the paintComponet draws the animation of the
        // girl dying
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Image bg = new ImageIcon("res/BottomBackground.png").getImage();
            g.drawImage(bg, 0, 0, 1400, 180, this);

            if (kill == true)
                g.drawImage(returnImage(), dudeX, -45, 256, 256, this);

            else {
                if (switchPanelCount == 1) {
                    Image runningGirl = new ImageIcon("res/00_girlRun.png").getImage();
                    g.drawImage(runningGirl, dudeX, -45, 256, 256, this);
                    Image runningGuy = new ImageIcon("res/01_Run8.png").getImage();
                    g.drawImage(runningGuy, dudeX - 130, -45, 256, 256, this);
                }
                if (switchPanelCount == 2) {
                    Image runningGirl = new ImageIcon("res/01_girlRun.png").getImage();
                    g.drawImage(runningGirl, dudeX, -45, 256, 256, this);
                    Image runningGuy = new ImageIcon("res/02_Run8.png").getImage();
                    g.drawImage(runningGuy, dudeX - 130, -45, 256, 256, this);
                }
                if (switchPanelCount == 3) {
                    Image runningGirl = new ImageIcon("res/02_girlRun.png").getImage();
                    g.drawImage(runningGirl, dudeX, -45, 256, 256, this);
                    Image runningGuy = new ImageIcon("res/03_Run8.png").getImage();
                    g.drawImage(runningGuy, dudeX - 130, -45, 256, 256, this);
                }
                if (switchPanelCount == 4) {
                    Image runningGirl = new ImageIcon("res/03_girlRun.png").getImage();
                    g.drawImage(runningGirl, dudeX, -45, 256, 256, this);
                    Image runningGuy = new ImageIcon("res/04_Run8.png").getImage();
                    g.drawImage(runningGuy, dudeX - 130, -45, 256, 256, this);
                }
                if (switchPanelCount == 5) {
                    Image runningGirl = new ImageIcon("res/04_girlRun.png").getImage();
                    g.drawImage(runningGirl, dudeX, -45, 256, 256, this);
                    Image runningGuy = new ImageIcon("res/05_Run8.png").getImage();
                    g.drawImage(runningGuy, dudeX - 130, -45, 256, 256, this);
                }
                if (switchPanelCount == 6) {
                    Image runningGirl = new ImageIcon("res/05_girlRun.png").getImage();
                    g.drawImage(runningGirl, dudeX, -45, 256, 256, this);
                    Image runningGuy = new ImageIcon("res/06_Run8.png").getImage();
                    g.drawImage(runningGuy, dudeX - 130, -45, 256, 256, this);
                }
                if (switchPanelCount == 7) {
                    Image runningGirl = new ImageIcon("res/00_Run.png").getImage();
                    g.drawImage(runningGirl, dudeX, -45, 256, 256, this);
                    Image runningGuy = new ImageIcon("res/00_Attack_1.png").getImage();
                    g.drawImage(runningGuy, dudeX - 130, -45, 256, 256, this);
                }
                if (switchPanelCount == 8) {
                    Image runningGirl = new ImageIcon("res/01_Run.png").getImage();
                    g.drawImage(runningGirl, dudeX, -45, 256, 256, this);
                    Image runningGuy = new ImageIcon("res/01_Attack_1.png").getImage();
                    g.drawImage(runningGuy, dudeX - 130, -45, 256, 256, this);
                }
                if (switchPanelCount == 9) {
                    Image runningGirl = new ImageIcon("res/02_Run.png").getImage();
                    g.drawImage(runningGirl, dudeX, -45, 256, 256, this);
                    Image runningGuy = new ImageIcon("res/02_Attack_1.png").getImage();
                    g.drawImage(runningGuy, dudeX - 130, -45, 256, 256, this);
                }
                if (switchPanelCount == 10) {
                    Image runningGirl = new ImageIcon("res/03_Run.png").getImage();
                    g.drawImage(runningGirl, dudeX, -45, 256, 256, this);
                    Image runningGuy = new ImageIcon("res/03_Attack_1.png").getImage();
                    g.drawImage(runningGuy, dudeX - 130, -45, 256, 256, this);
                }
                if (switchPanelCount == 11) {
                    Image runningGirl = new ImageIcon("res/04_Run.png").getImage();
                    g.drawImage(runningGirl, dudeX, -45, 256, 256, this);
                    Image runningGuy = new ImageIcon("res/04_Attack_1.png").getImage();
                    g.drawImage(runningGuy, dudeX - 130, -45, 256, 256, this);
                }
                if (switchPanelCount == 12) {
                    Image runningGirl = new ImageIcon("res/05_Run.png").getImage();
                    g.drawImage(runningGirl, dudeX, -45, 256, 256, this);
                    Image runningGuy = new ImageIcon("res/04_Attack_1.png").getImage();
                    g.drawImage(runningGuy, dudeX - 130, -45, 256, 256, this);
                }
                if (timerPaint) {
                    switchPanelCount++;
                    if (switchPanelCount == 13)
                        switchPanelCount = 1;
                    timerPaint = false;
                }

            }
        }
        // DudeMover is the actionlistener that dudetimer uses
        class DudeMover implements ActionListener {
            // inside of action performed the characters' positions are incremented and
            // reset if needed
            // it also determines whether or not the kill sequence should play
            public void actionPerformed(ActionEvent e) {
                timerPaint = true;
                dudeX += 10;
                if (dudeX > 1400) {
                    dudeX = 20;
                }
                if (dudeX >= 500 && dudeX <= 540) {
                    kill = true;
                } else {
                    kill = false;
                    // dudetimer.setDelay(200);
                }
                repaint();
            }
        }
    }
}




    

