import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

//This class contains all the JPanels, methods, classes, logic needed to play Level2 (it's unfinished though)
public class Level2Panel extends JPanel implements MouseListener {
    static CardLayout level2mainCL;
    static JPanel level2MainPanel;
    DeathScreen2 deathScreen;
    public static boolean treasureChestGained=false;

    // constructor for this class sets the layout and adds the quit button to the
    // top using borderLayout
    public Level2Panel() {
        setLayout(new BorderLayout());
        // add(northPanel(), BorderLayout.NORTH);
        level2mainCL = new CardLayout();
        level2MainPanel = new JPanel();
        // level2MainPanel.setBackground(Color.RED);
        add(level2MainPanel, BorderLayout.CENTER);
        level2MainPanel.setLayout(level2mainCL);
        level2MainPanel.add(new Transition1(), "transition1");
        level2MainPanel.add(new Challenge1(), "challenge1");
        level2MainPanel.add(new Transition2(), "transition2");
        deathScreen = new DeathScreen2();
        level2MainPanel.add(deathScreen, "deathScreen");
        level2mainCL.show(level2MainPanel, "transition1");
    }

    // story explanation
    class Transition1 extends JPanel {
        CardLayout transition1CL;

        // constructs all the panels needed for the explanation
        public Transition1() {
            transition1CL = new CardLayout();
            setLayout(transition1CL);
            add(new Transition1Panel1(), "pan1");
            add(new Transition1Panel2(), "pan2");
            add(new Transition1Panel3(), "pan3");
            add(new Transition1Panel4(), "pan4");
            add(new Transition1Panel5(), "pan5");
            add(new Transition1Panel6(), "pan6");
            add(new Transition1Panel7(), "pan7");
            transition1CL.show(this, "pan1");

        }

        // first storyboard panel
        class Transition1Panel1 extends JPanel {
            // this constructor adds the "next" button
            public Transition1Panel1() {
                setLayout(new BorderLayout());
                add(new TransitionButtonPanel(), BorderLayout.SOUTH);
            }

            // this paintcomponent draws the image for the story explanation
            public void paintComponent(Graphics g) {
                Image bg = new ImageIcon("res/01_Transition.gif").getImage();
                g.drawImage(bg, 0, 0, 1400, 900, this);
            }
        }

        // second storyboard panel
        class Transition1Panel2 extends JPanel {

            // this constructor adds the "next" button
            public Transition1Panel2() {
                setLayout(new BorderLayout());
                add(new TransitionButtonPanel(), BorderLayout.SOUTH);
            }

            // this paintcomponent draws the image for the story explanation
            public void paintComponent(Graphics g) {
                Image bg = new ImageIcon("res/02_Transition.png").getImage();
                g.drawImage(bg, 0, 0, 1400, 900, this);
            }
        }

        // third storyboard panel
        class Transition1Panel3 extends JPanel {

            // this constructor adds the "next" button
            public Transition1Panel3() {
                setLayout(new BorderLayout());
                add(new TransitionButtonPanel(), BorderLayout.SOUTH);
            }

            // this paintcomponent draws the image for the story explanation
            public void paintComponent(Graphics g) {
                Image bg = new ImageIcon("res/03_Transition.png").getImage();
                g.drawImage(bg, 0, 0, 1400, 900, this);
            }
        }

        // fourth storyboard panel
        class Transition1Panel4 extends JPanel implements MouseListener {

            // this constructor adds the "next" button
            public Transition1Panel4() {
                addMouseListener(this);
            }

            // this paintcomponent draws the image for the story explanation
            public void paintComponent(Graphics g) {
                Image bg = new ImageIcon("res/04_Transition.gif").getImage();
                g.drawImage(bg, 0, 0, 1400, 900, this);
            }

            // mouseClicked determines what to do if mouse is clicked
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                if (x >= 1120 && x <= 1189 && y <= 464 && y >= 374) {
                    transition1CL.next(Transition1.this);
                }
            }

            // mousePressed determines what to do if mouse is pressed
            public void mousePressed(MouseEvent e) {
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

        // fifth storyboard panel
        class Transition1Panel5 extends JPanel implements MouseListener {

            // this constructor adds the "next" button
            public Transition1Panel5() {
                setLayout(new BorderLayout());
                addMouseListener(this);
                // add(new TransitionButtonPanel(), BorderLayout.SOUTH);
            }

            // this paintcomponent draws the image for the story explanation
            public void paintComponent(Graphics g) {
                Image bg = new ImageIcon("res/05_Transition.gif").getImage();
                g.drawImage(bg, 0, 0, 1400, 900, this);
            }

            // mousePressed determines what to do if mouse is clicked
            public void mousePressed(MouseEvent e) {
            }

            // mouseClicked determines what to do if mouse is clicked
            public void mouseClicked(MouseEvent e) {
                if (e.getX() <= 1000 && e.getX() >= 876 && e.getY() >= 669 && e.getY() <= 741) {
                    transition1CL.next(Transition1.this);
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

        // sixth storyboard panel
        class Transition1Panel6 extends JPanel implements MouseListener {

            // this constructor adds the "next" button
            public Transition1Panel6() {
                setLayout(new BorderLayout());
                addMouseListener(this);
                // add(new TransitionButtonPanel(), BorderLayout.SOUTH);
            }

            // this paintcomponent draws the image for the story explanation
            public void paintComponent(Graphics g) {
                Image bg = new ImageIcon("res/06_Transition.gif").getImage();
                g.drawImage(bg, 0, 0, 1400, 900, this);
            }

            // mousePressed determines what to do if mouse is clicked
            public void mousePressed(MouseEvent e) {
            }

            // mouseClicked determines what to do if mouse is clicked
            public void mouseClicked(MouseEvent e) {
                if (e.getX() >= 522 && e.getX() <= 837 && e.getY() >= 423 && e.getY() <= 587) {
                    transition1CL.next(Transition1.this);
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

        // seventh storyboard panel
        class Transition1Panel7 extends JPanel implements MouseListener {

            // this constructor adds the "next" button
            public Transition1Panel7() {
                setLayout(new BorderLayout());
                addMouseListener(this);
                // add(new TransitionButtonPanel(), BorderLayout.SOUTH);
            }

            // this paintcomponent draws the image for the story explanation
            public void paintComponent(Graphics g) {
                Image bg = new ImageIcon("res/07_Transition.gif").getImage();
                g.drawImage(bg, 0, 0, 1400, 900, this);
                Image nextArrButton = new ImageIcon("res/NextArrowButton.png").getImage();
                g.drawImage(nextArrButton, 1250, 760, 150, 100, this);
            }

            // mousePressed determines what to do if mouse is clicked
            public void mousePressed(MouseEvent e) {
            }

            // mouseClicked determines what to do if mouse is clicked
            public void mouseClicked(MouseEvent e) {
                if (e.getX() >= 1250 && e.getX() <= 1400 && e.getY() <= 820 && e.getY() >= 760) {
                    level2mainCL.show(level2MainPanel, "challenge1");
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

        // this class draws and contains the logic for what to do when the next "button"
        // is clicked
        class TransitionButtonPanel extends JPanel implements MouseListener {

            // Constructor constructs ButtonPanel (e.g. layout, background color)
            public TransitionButtonPanel() {
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
                    transition1CL.next(Transition1.this);
                }
            }

            // mouseClicked determines what to do if mouse is clicked
            public void mouseClicked(MouseEvent e) {
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

    // the story panel after the challenge is over
    class Transition2 extends JPanel {
        CardLayout transition2CL;
        boolean showingLastPanel;
        // so far this constructor is obsolete since i have NOT IMPLEMENTED transition 2
        public Transition2() {
            showingLastPanel=false;
            transition2CL = new CardLayout();
            setLayout(transition2CL);
            add(new Transition2Panel1(), "pan1");
            add(new Transition2Panel2(), "pan2");
            add(new Transition2Panel3(), "pan3");
            // add(new Transition2Panel4(), "pan4");
            transition2CL.show(this, "pan1");

        }

        //first story class after the user completes the challenge
        class Transition2Panel1 extends JPanel{
            //constructs the next button
            public Transition2Panel1(){
                setLayout(new BorderLayout());
                add(new Transition2ButtonPanel(), BorderLayout.SOUTH);
            }
            //paints the bg image that contains the graphics for plot explanantion
            public void paintComponent(Graphics g){
                Image foundMe = new ImageIcon("res/FoundMe.png").getImage();
                g.drawImage(foundMe, 0, 0, 1400, 860, this);
            }

        }
        //second story class after the user completes the challenge
        class Transition2Panel2 extends JPanel implements ActionListener{
            int girlCount;
            //constructs the next button
            public Transition2Panel2(){
                setLayout(new BorderLayout());
                Timer tt = new Timer(400, this);
                add(new Transition2ButtonPanel(), BorderLayout.SOUTH);
                girlCount=8;
                tt.start();

            }
            //paints the bg image that contains the graphics for plot explanantion
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                if(girlCount<=8) girlCount--;
                Image foundMe = new ImageIcon("res/EmptyFoundMe.png").getImage();
                g.drawImage(foundMe, 0, 0, 1400, 860, this);
                Image girlDying = new ImageIcon("res/0" + girlCount + "_GirlDead.png").getImage();
                g.drawImage(girlDying, 640, 500, 350, 350, this);
                Image guyDying = new ImageIcon("res/0" + girlCount + "_GuyDead.png").getImage();
                g.drawImage(guyDying, 500, 500, 350, 350, this);
                
               
            }
            public void actionPerformed(ActionEvent e){
                repaint();
            }

        }
        //third story class after the user completes the challenge
        class Transition2Panel3 extends JPanel{
            //constructor constructs the next button and the upcomoing panel
            public Transition2Panel3(){
                setLayout(new BorderLayout());
                add(new Transition2ButtonPanel(), BorderLayout.SOUTH);
                Transition2.this.add(new Transition2Panel4(), "pan4");
            }
            //paints the bg image that contains the graphics for plot explanantion
            public void paintComponent(Graphics g){
                Image foundMe = new ImageIcon("res/YOUMURDERER.png").getImage();
                g.drawImage(foundMe, 0, 0, 1400, 860, this);
            }

        }
        //fourth story class after the user completes the challenge
        class Transition2Panel4 extends JPanel{
            //constructs the next button
            public Transition2Panel4(){
                setLayout(new BorderLayout());
                add(new Transition2ButtonPanel(), BorderLayout.SOUTH);
                
            }
            //paints the bg image that contains the graphics for plot explanantion
            public void paintComponent(Graphics g){
                showingLastPanel=true;
                Image foundMe = new ImageIcon("res/CongratsPanel.png").getImage();
                g.drawImage(foundMe, 0, 0, 1400, 860, this);
            }

        }
        // this class draws and contains the logic for what to do when the next "button"
        // is clicked
        class Transition2ButtonPanel extends JPanel implements MouseListener {

            // Constructor constructs ButtonPanel (e.g. layout, background color)
            public Transition2ButtonPanel() {
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
                    if(showingLastPanel){
                        HomePage.level123Unlocked=true;
                        HomePage.cl.show(HomePage.mainPanel, "homePagePanel");
                    }
                    else transition2CL.next(Transition2.this);
                }
            }

            // mouseClicked determines what to do if mouse is clicked
            public void mouseClicked(MouseEvent e) {
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
    // northPanel method returns a JPanel
    // this JPanel contains the quit button
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
        quit.addMouseListener(Level2Panel.this);
        panel.add(quit);
        // HomePage.countdownPanel.setForeground(Color.WHITE);
        // panel.add(Level3Panel.countdownPanel);
        return panel;
    }

    // determines what happens if mouse is clicked within quit label's boundaries
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

    // the following have no purpose and are only present because interfaces require
    // one to implement all methods
    // determines what happens if mouse is released within quit label's boundaries
    public void mouseReleased(MouseEvent e) {
    }

    // determines what happens if mouse is pressed within quit label's boundaries
    public void mousePressed(MouseEvent e) {
    }

    // determines what happens if mouse is enters quit label's boundaries
    public void mouseEntered(MouseEvent e) {
    }

    // determines what happens if mouse is exits quit label's boundaries
    public void mouseExited(MouseEvent e) {
    }
}

// First challenge of Level2
class Challenge1 extends JPanel implements KeyListener, ActionListener, MouseListener {
    // the following have no purpose and are only present because interfaces require
    // one to implement all methods
    // determines what happens if mouse is released within quit label's boundaries
    public void mouseReleased(MouseEvent e) {
    }

    // determines what happens if mouse is pressed within quit label's boundaries
    public void mousePressed(MouseEvent e) {
    }

    // determines what happens if mouse is enters quit label's boundaries
    public void mouseEntered(MouseEvent e) {
    }

    // determines what happens if mouse is exits quit label's boundaries
    public void mouseExited(MouseEvent e) {}


    // determines what happens if mouse is exits quit label's boundaries
    public void mouseClicked(MouseEvent e) {
        
        if(player.outerBox.x1>=5400){
            if(e.getX()>=1221 && e.getX()<=1367&& e.getY()>=730 && e.getY()<=823){
                Level2Panel.level2mainCL.show(Level2Panel.level2MainPanel, "transition2");
            }
        }
    }
    // Defines the rectangle that makes up the hitbox or the outerbox
    public class Rectangle {
        int x1, y1; // top left point
        int x2, y2; // bottom right point

        // constructs a rectangle
        // this constructor and class might seem pointless (it's possible to do this
        // code w/o it)
        // but it helps in simplifying the code bc EACH gameobject(100+) will have 2
        // rectangles
        // so that leads to a bunch of rectangles and this constructor helps manage them
        // all
        Rectangle(int _x1, int _y1, int _x2, int _y2) {
            x1 = _x1;
            x2 = _x2;
            y1 = _y1;
            y2 = _y2;
        }

        public void move(int _x, int _y) // move method moves the rectangle to the new x or y position
                                         // that is passed into the method
        {
            int width = x2 - x1;
            int height = y2 - y1;
            x1 = _x;
            x2 = _x + width;
            y1 = _y;
            y2 = _y + height;
        }
    }

    // codes for ANY gameobject
    // this includes the player and obstacles
    public class GameObject {
        Rectangle hitBox; // hitbox is useful bc you don't want to detect collision with outerbox, you
                          // want to detect it with hitbox

        Rectangle outerBox; // outerBox's properties are useful for calculating the hitbox's properties
                            // outerBox itself is useful bc that's where you want to start drawing the
                            // player
        Image image;

        // This GameObject constructor constructs the hitbox for the player
        // and then saves this hitbox as Rectangle
        GameObject(Rectangle _outerBox, int spriteWidth, int spriteHeight) {
            outerBox = _outerBox;
            int outerBoxWidth = (_outerBox.x2 - _outerBox.x1);
            int outerBoxHeight = (_outerBox.y2 - _outerBox.y1);
            // int hitBoxX1 = _outerBox.x1 + (outerBoxWidth - spriteWidth)/2;
            int hitBoxX1 = (int) (_outerBox.x1 + ((outerBoxWidth) * 0.6));
            int hitBoxY1 =_outerBox.y1 + (outerBoxHeight - spriteHeight);
            hitBox = new Rectangle(hitBoxX1, hitBoxY1, hitBoxX1 + spriteWidth, hitBoxY1 + spriteHeight);

        }

        // This GameObject constructor makes the hitbox for the obstacles bc the hitbox
        // for the obstacles is also the outerbox
        // i.e. it's dimensions consume the whole image
        GameObject(Rectangle _hitBox, Image _image) {
            hitBox = _hitBox;
            outerBox = new Rectangle(hitBox.x1, hitBox.y1, hitBox.x2, hitBox.y2);
            image = _image;
        }
        // isXIntersect is a method that defines the collison logic for the
        // x-coordinates
        // returns true if the gameobj itself has colllided with the gameobj passed into
        // the method
        public boolean isXIntersect(GameObject _GameObject) {
            // Start position falls between second object
            if ((hitBox.x1 - _GameObject.hitBox.x1 > 0) && (hitBox.x1 - _GameObject.hitBox.x2 < 0)) {
                return true;
            }

            // End position falls between second object
            if ((hitBox.x2 - _GameObject.hitBox.x1 > 0) && (hitBox.x2 - _GameObject.hitBox.x2 < 0)) {
                return true;
            }

            return false;

        }

        // isYIntersect is a method that defines the collison logic for the
        // y-coordinates
        // returns true if the gameobj itself has colllided with the gameobj passed into
        // the method
        boolean isYIntersect(GameObject _GameObject) {
            // Start position falls between second object
            if ((hitBox.y1 > _GameObject.hitBox.y1) && (hitBox.y1 < _GameObject.hitBox.y2)) {
                //672 > 752
                return true;
            }

            // End position falls between second object
            if ((hitBox.y2 > _GameObject.hitBox.y1) &&
                    (hitBox.y2 < _GameObject.hitBox.y2)) {
                        //872 > 752 && 872 < 802 --> false
                return true;
            }

            return false;

        }

        // Check both overlap in X and Y dimension.
        boolean isIntersect(GameObject _GameObject) {
            if (!isXIntersect(_GameObject))
                return false;
            if (isXIntersect(_GameObject) && !isYIntersect(_GameObject))
                return false;
            return true;
        }

        // this move() method moves the gameobject itself
        // this move differs from the move in the rectangle class because it moves both
        // the outerbox
        // and the hitbox of the gameobj
        void move(int _x1, int _y1) {
            int hitBoxXDiff = hitBox.x1 - outerBox.x1;
            int hitBoxYDiff = hitBox.y1 - outerBox.y1;
            outerBox.move(_x1, _y1); // this calls the move method in the Rectangle class
            hitBox.move(_x1 + hitBoxXDiff, _y1 + hitBoxYDiff);
        }
    }

    final int LEVEL_WIDTH = 1024;
    final int LEVEL_HEIGHT = 1024;
    final int PLAYER_WIDTH = 300; // width of ANY character icon //drawing
    final int PLAYER_HEIGHT = 300;// height of ANY character icon //drawing
    int PLAYER_ICON_WIDTH = 30; // width of ANY character icon //used for collision
    int PLAYER_ICON_HEIGHT = 60;// height of ANY character icon //used for collision
    final int STONE_WIDTH = 100;
    final int STONE_HEIGHT = 100;
    final int treasureChest_WIDTH = 50;
    final int treasureChest_HEIGHT = 50;
    boolean flipPlayerImage;
int circleCount=0;
    int playerOuterBoxX1;

    GameObject player;
    GameObject obstacles[];

    int windowWidth = 0;
    int windowHeight = 0;

    int plusX = 0;
    BufferedImage bufferedImages[];
    int index = 0;
    private Timer timer;
    int count;
    boolean drawFrame = false;
    int playerSpeed = 20;
    int jumpSpeed = 20;
    final int frameLimit = 400;
    int movingFrameLimit = frameLimit; // where you want to start showing the new frame
    int surpassedPixels = 0;
    boolean jump = false;
    int jumpCount = 0;
    boolean rightKeyPressed = false;
    boolean upKeyPressed = false;
    boolean leftKeyPressed = false;
    boolean firstDrawImage = true;
    int visibleMinX = 0;
    int visibleMaxX = 0;
    boolean startCounter = false;
    int waitCounter = 0;

    Image playerImage;

    // this method is fairly simply
    // it returns an array of BufferedImages of the backgrounds
    // this is required so that the prog switches between the bg's and creates a
    // "moving"/platformer effect
    public BufferedImage[] buildLevelImages(int size, int width, int height) {

        BufferedImage bufferedImageArray[] = new BufferedImage[size];

        for (int i = 0; i < size; i++) {
            bufferedImageArray[i] = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            // Get the Graphics2D object from the BufferedImage
            Graphics2D g2d = bufferedImageArray[i].createGraphics();
            if(i==4){
                Image bg1 = new ImageIcon("res/platformerBg1.png").getImage();
                    g2d.drawImage(bg1, 0, 0, width, height, this);
                Image hostage = new ImageIcon("res/Hostage.png").getImage();
                    g2d.drawImage(hostage, 0, 300, 1000, 550, this);
                Image nextArrButton = new ImageIcon("res/NextArrowButton.png").getImage();
                    g2d.drawImage(nextArrButton, 1250, 730, 150, 100, this);
            }
            else{
                if (i % 2 == 0) {
                    // g2d.setColor(Color.BLUE);
                    // g2d.fillRect(0, 0, LEVEL_WIDTH, LEVEL_HEIGHT);
                    Image bg1 = new ImageIcon("res/platformerBg1.png").getImage();
                    g2d.drawImage(bg1, 0, 0, width, height, this);
                } else if (i % 2 == 1) {
                    // g2d.setColor(Color.YELLOW);

                    Image bg2 = new ImageIcon("res/platformerBg2.png").getImage();
                    g2d.drawImage(bg2, 0, 0, width, height, this);
                } else
                    g2d.setColor(Color.RED);
            }

            // g2d.fillRect(0, 0, LEVEL_WIDTH, LEVEL_HEIGHT);

            // Dispose the Graphics2D object
            g2d.dispose();
        }

        return bufferedImageArray;

    }

    // This method flips the img
    public static BufferedImage flipImage(Image image) {
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);

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

    // fills in the background of the img for testing, obsolete
    // DELETE LAter
    public static BufferedImage fillImageBackground(Image image, int imageWidth, int imageHeight) {
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);

        int borderSize = 10;

        int newWidth = imageWidth + 2 * borderSize;
        int newHeight = imageHeight + 2 * borderSize;

        // Get the Graphics2D object from the BufferedImage
        Graphics2D g2d = bufferedImage.createGraphics();

        g2d.setColor(Color.RED);
        g2d.fillRect(0, 0, newWidth, newHeight);

        g2d.drawImage(image, borderSize, borderSize, null);

        // Dispose the Graphics2D object
        g2d.dispose();

        return bufferedImage;

    }

    // since it's a platform game, certain parts of the game are not visible at
    // times
    // therefore we only want to draw the obstacle WHEN that frame is being
    // displayed
    // beacuse otherwsie the object would be drawn at its relative position to the
    // current frame
    private boolean isVisible(GameObject _Object) {
        if ((_Object.outerBox.x1 >= visibleMinX) &&
                (_Object.outerBox.x1 <= visibleMaxX))
            return true;

        if ((_Object.outerBox.x2 >= visibleMinX) &&
                (_Object.outerBox.x2 <= visibleMaxX))
            return true;

        return false;

    }

    // this method just draws all the obstacles
    private void drawObstacles(Graphics g) {

        for (int i = 0; i < obstacles.length; i++) {
            if (isVisible(obstacles[i])) {
                int drawPosition = obstacles[i].outerBox.x1 - visibleMinX;
                if(i!=66) g.drawImage(obstacles[i].image, drawPosition, obstacles[i].outerBox.y1, STONE_WIDTH, STONE_HEIGHT,
                        this);
                if(i==66 && !Level2Panel.treasureChestGained)g.drawImage(obstacles[66].image, drawPosition, obstacles[66].outerBox.y1, STONE_WIDTH, STONE_HEIGHT,
                this);
            }
        }

    }

    // Challenge1 constructor contains more logic for the challenge
    public Challenge1() {
        // addKeyListener(this);

        setLayout(new BorderLayout());
        addMouseListener(this);
        // add(new ButtonPanel(), BorderLayout.SOUTH);
        // setBackground(Color.PINK);
        addKeyListener(this);

        timer = new Timer(80, this); // call actionPerformed() every 80 milliseconds
        timer.start();
    }

    // starts and stops the timer
    @Override
    public void actionPerformed(ActionEvent e) {
        if (startCounter)
            waitCounter++;
        if (waitCounter == 10)
            Level2Panel.level2mainCL.show(Level2Panel.level2MainPanel, "deathScreen");
        timer.stop();
        drawFrame = true;
        repaint();
    }

    // paints the visual components for the challenge
    public void paintComponent(Graphics g) {

        // only when the first paintcomponent is called
        if (firstDrawImage) {
            // 20 imgs for the bg
            bufferedImages = buildLevelImages(5, getWidth(), getHeight());
            windowHeight = getHeight();
            visibleMinX = 0;
            visibleMaxX = getWidth();

            int playerOuterX1 = 0;
            int playerOuterY1 = getHeight() - PLAYER_HEIGHT;
            int playerOuterX2 = PLAYER_WIDTH;
            int playerOuterY2 = getHeight();

            player = new GameObject(new Rectangle(playerOuterX1, playerOuterY1, playerOuterX2, playerOuterY2),
                    PLAYER_ICON_WIDTH, PLAYER_ICON_HEIGHT);

            // creates obstacles
            obstacles = new GameObject[100];
            Image stoneImage = new ImageIcon("res/Tile_43.png").getImage();
            Image stoneTile= new ImageIcon("res/stoneTile.png").getImage();
            Image stoneImageFlip = new ImageIcon("res/triangleFlip.png").getImage();

            Image tileImage = new ImageIcon("res/Tile_39.png").getImage();
            Image spikeTileImage = new ImageIcon("res/spikeTile.png").getImage();
            Image otherimage = new ImageIcon("res/othertile.png").getImage();
            Image fill = new ImageIcon("res/scatteredBlueTile.png").getImage();
            // Image redtreasureChestUnscaled = new ImageIcon("res/RedtreasureChest.png").getImage();
            // Image redtreasureChest = redtreasureChestUnscaled.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            Image redtreasureChest = new ImageIcon("res/treasure1.png").getImage();

            Image greentreasureChest = new ImageIcon("res/GreentreasureChest.png").getImage();

            for (int i = 0; i < obstacles.length; i++) {
                obstacles[i] = new GameObject(new Rectangle((i + 1) * 11900, getHeight() - STONE_HEIGHT,
                        (i + 1) * 11900 + STONE_WIDTH, getHeight()), stoneImage);
            }
            obstacles[3] = new GameObject(
                    new Rectangle(1600, getHeight() - STONE_HEIGHT, 1600 + STONE_WIDTH, getHeight()), stoneImage);
            obstacles[4] = new GameObject(
                    new Rectangle(800, getHeight() - STONE_HEIGHT, 800 + STONE_WIDTH, getHeight()), stoneImage);

            obstacles[5] = new GameObject(
                    new Rectangle(900, getHeight() - STONE_HEIGHT, 900 + STONE_WIDTH, getHeight()), fill);
            obstacles[6] = new GameObject(
                    new Rectangle(1000, getHeight() - STONE_HEIGHT, 1000 + STONE_WIDTH, getHeight()), fill);

            obstacles[7] = new GameObject(
                    new Rectangle(1100, getHeight() - STONE_HEIGHT - 100, 1100 + STONE_WIDTH, getHeight() - 100), fill);
            obstacles[8] = new GameObject(
                    new Rectangle(1100, getHeight() - STONE_HEIGHT, 1100 + STONE_WIDTH, getHeight()), fill);
            obstacles[10] = new GameObject(
                    new Rectangle(1200, getHeight() - STONE_HEIGHT - 100, 1200 + STONE_WIDTH, getHeight() - 100),
                    tileImage);
            obstacles[9] = new GameObject(
                    new Rectangle(1200, getHeight() - STONE_HEIGHT, 1200 + STONE_WIDTH, getHeight()), fill);

            obstacles[11] = new GameObject(
                    new Rectangle(1700, getHeight() - STONE_HEIGHT, 1700 + STONE_WIDTH, getHeight()), fill);

            obstacles[12] = new GameObject(
                    new Rectangle(1800, getHeight() - STONE_HEIGHT, 1800 + STONE_WIDTH, getHeight()), fill);

            obstacles[13] = new GameObject(
                    new Rectangle(1900, getHeight() - STONE_HEIGHT - 100, 1900 + STONE_WIDTH, getHeight() - 100),
                    stoneImage);
            obstacles[14] = new GameObject(
                    new Rectangle(1900, getHeight() - STONE_HEIGHT, 1900 + STONE_WIDTH, getHeight()), fill);

            obstacles[15] = new GameObject(
                    new Rectangle(2000, getHeight() - STONE_HEIGHT - 100, 2000 + STONE_WIDTH, getHeight() - 100),
                    tileImage);
            obstacles[16] = new GameObject(
                    new Rectangle(2000, getHeight() - STONE_HEIGHT, 2000 + STONE_WIDTH, getHeight()), tileImage);
            // obstacles[17] = new GameObject(new Rectangle(2000, getHeight() -
            // STONE_HEIGHT-200, 2000+STONE_WIDTH, getHeight()-200), stoneImage);

            obstacles[18] = new GameObject(
                    new Rectangle(2100, getHeight() - STONE_HEIGHT - 100, 2100 + STONE_WIDTH, getHeight() - 100),
                    fill);
            obstacles[19] = new GameObject(
                    new Rectangle(2100, getHeight() - STONE_HEIGHT - 200, 2100 + STONE_WIDTH, getHeight() - 200),
                    stoneImage);
            obstacles[20] = new GameObject(
                    new Rectangle(2100, getHeight() - STONE_HEIGHT, 2100 + STONE_WIDTH, getHeight()), fill);

            obstacles[21] = new GameObject(
                    new Rectangle(2200, getHeight() - STONE_HEIGHT - 100, 2200 + STONE_WIDTH, getHeight() - 100), fill);
            obstacles[22] = new GameObject(
                    new Rectangle(2200, getHeight() - STONE_HEIGHT - 200, 2200 + STONE_WIDTH, getHeight() - 200), fill);
            obstacles[23] = new GameObject(
                    new Rectangle(2200, getHeight() - STONE_HEIGHT, 2200 + STONE_WIDTH, getHeight()), fill);

            obstacles[24] = new GameObject(
                    new Rectangle(2300, getHeight() - STONE_HEIGHT - 300, 2300 + STONE_WIDTH, getHeight() - 300),
                    stoneTile);
            obstacles[25] = new GameObject(
                    new Rectangle(2300, getHeight() - STONE_HEIGHT - 200, 2300 + STONE_WIDTH, getHeight() - 200), fill);
            obstacles[26] = new GameObject(
                    new Rectangle(2300, getHeight() - STONE_HEIGHT - 100, 2300 + STONE_WIDTH, getHeight() - 100), fill);
            obstacles[27] = new GameObject(
                    new Rectangle(2300, getHeight() - STONE_HEIGHT, 2300 + STONE_WIDTH, getHeight()), fill);

            obstacles[28] = new GameObject(
                    new Rectangle(2400, getHeight() - STONE_HEIGHT - 300, 2400 + STONE_WIDTH, getHeight() - 300),
                    stoneTile);
            obstacles[29] = new GameObject(
                    new Rectangle(2400, getHeight() - STONE_HEIGHT - 200, 2400 + STONE_WIDTH, getHeight() - 200), fill);
            obstacles[30] = new GameObject(
                    new Rectangle(2400, getHeight() - STONE_HEIGHT - 100, 2400 + STONE_WIDTH, getHeight() - 100), fill);
            obstacles[31] = new GameObject(
                    new Rectangle(2400, getHeight() - STONE_HEIGHT, 2400 + STONE_WIDTH, getHeight()), fill);

            obstacles[32] = new GameObject(
                    new Rectangle(2500, getHeight() - STONE_HEIGHT - 300, 2500 + STONE_WIDTH, getHeight() - 300),
                    stoneTile);
            obstacles[33] = new GameObject(
                    new Rectangle(2500, getHeight() - STONE_HEIGHT - 200, 2500 + STONE_WIDTH, getHeight() - 200),
                    tileImage);
            obstacles[34] = new GameObject(
                    new Rectangle(2500, getHeight() - STONE_HEIGHT - 100, 2500 + STONE_WIDTH, getHeight() - 100), fill);
            // obstacles[35] = new GameObject(new Rectangle(2500, getHeight() -
            // STONE_HEIGHT, 2500+STONE_WIDTH, getHeight()), fill);

            obstacles[36] = new GameObject(
                    new Rectangle(2600, getHeight() - STONE_HEIGHT - 300, 2600 + STONE_WIDTH, getHeight() - 300),
                    stoneTile);
            obstacles[37] = new GameObject(
                    new Rectangle(2600, getHeight() - STONE_HEIGHT - 200, 2600 + STONE_WIDTH, getHeight() - 200), fill);
            obstacles[38] = new GameObject(
                    new Rectangle(2600, getHeight() - STONE_HEIGHT - 100, 2600 + STONE_WIDTH, getHeight() - 100), fill);
            obstacles[39] = new GameObject(
                    new Rectangle(2600, getHeight() - STONE_HEIGHT, 2600 + STONE_WIDTH, getHeight()), fill);

            obstacles[40] = new GameObject(
                    new Rectangle(2700, getHeight() - STONE_HEIGHT - 300, 2700 + STONE_WIDTH, getHeight() - 300),
                    stoneTile);
            obstacles[41] = new GameObject(
                    new Rectangle(2700, getHeight() - STONE_HEIGHT - 200, 2700 + STONE_WIDTH, getHeight() - 200), fill);
            obstacles[42] = new GameObject(
                    new Rectangle(2700, getHeight() - STONE_HEIGHT - 100, 2700 + STONE_WIDTH, getHeight() - 100), fill);
            obstacles[43] = new GameObject(
                    new Rectangle(2700, getHeight() - STONE_HEIGHT, 2700 + STONE_WIDTH, getHeight()), fill);

            obstacles[40] = new GameObject(
                    new Rectangle(2700, getHeight() - STONE_HEIGHT - 300, 2700 + STONE_WIDTH, getHeight() - 300),
                    stoneTile);
            obstacles[41] = new GameObject(
                    new Rectangle(2700, getHeight() - STONE_HEIGHT - 200, 2700 + STONE_WIDTH, getHeight() - 200), fill);
            obstacles[42] = new GameObject(
                    new Rectangle(2700, getHeight() - STONE_HEIGHT - 100, 2700 + STONE_WIDTH, getHeight() - 100), fill);
            obstacles[43] = new GameObject(
                    new Rectangle(2700, getHeight() - STONE_HEIGHT, 2700 + STONE_WIDTH, getHeight()), fill);

            obstacles[44] = new GameObject(
                    new Rectangle(2800, getHeight() - STONE_HEIGHT - 300, 2800 + STONE_WIDTH, getHeight() - 300),
                    stoneTile);
            obstacles[45] = new GameObject(
                    new Rectangle(2800, getHeight() - STONE_HEIGHT - 200, 2800 + STONE_WIDTH, getHeight() - 200), fill);
            obstacles[46] = new GameObject(
                    new Rectangle(2800, getHeight() - STONE_HEIGHT - 100, 2800 + STONE_WIDTH, getHeight() - 100), fill);
            obstacles[47] = new GameObject(
                    new Rectangle(2800, getHeight() - STONE_HEIGHT, 2800 + STONE_WIDTH, getHeight()), fill);

            obstacles[48] = new GameObject(
                    new Rectangle(2900, getHeight() - STONE_HEIGHT - 300, 2900 + STONE_WIDTH, getHeight() - 300),
                    stoneTile);
            obstacles[49] = new GameObject(
                    new Rectangle(2900, getHeight() - STONE_HEIGHT - 200, 2900 + STONE_WIDTH, getHeight() - 200), fill);
            obstacles[50] = new GameObject(
                    new Rectangle(2900, getHeight() - STONE_HEIGHT - 100, 2900 + STONE_WIDTH, getHeight() - 100), fill);
            obstacles[51] = new GameObject(
                    new Rectangle(2900, getHeight() - STONE_HEIGHT, 2900 + STONE_WIDTH, getHeight()), fill);

            obstacles[52] = new GameObject(
                    new Rectangle(3000, getHeight() - STONE_HEIGHT - 300, 3000 + STONE_WIDTH, getHeight() - 300),
                    stoneTile);
            obstacles[53] = new GameObject(
                    new Rectangle(3000, getHeight() - STONE_HEIGHT - 200, 3000 + STONE_WIDTH, getHeight() - 200), fill);
            obstacles[54] = new GameObject(
                    new Rectangle(3000, getHeight() - STONE_HEIGHT - 100, 3000 + STONE_WIDTH, getHeight() - 100), fill);
            obstacles[55] = new GameObject(
                    new Rectangle(3000, getHeight() - STONE_HEIGHT, 3000 + STONE_WIDTH, getHeight()), fill);

            obstacles[56] = new GameObject(
                    new Rectangle(3100, getHeight() - STONE_HEIGHT - 300, 3100 + STONE_WIDTH, getHeight() - 300),
                    stoneTile);
            obstacles[57] = new GameObject(
                    new Rectangle(3100, getHeight() - STONE_HEIGHT - 200, 3100 + STONE_WIDTH, getHeight() - 200), fill);
            obstacles[58] = new GameObject(
                    new Rectangle(3100, getHeight() - STONE_HEIGHT - 100, 3100 + STONE_WIDTH, getHeight() - 100), fill);
            obstacles[59] = new GameObject(
                    new Rectangle(3100, getHeight() - STONE_HEIGHT, 3100 + STONE_WIDTH, getHeight()), fill);

            obstacles[60] = new GameObject(
                    new Rectangle(3200, getHeight() - STONE_HEIGHT - 300, 3200 + STONE_WIDTH, getHeight() - 300),
                    stoneTile);
            obstacles[61] = new GameObject(
                    new Rectangle(3200, getHeight() - STONE_HEIGHT - 200, 3200 + STONE_WIDTH, getHeight() - 200), fill);
            obstacles[62] = new GameObject(
                    new Rectangle(3200, getHeight() - STONE_HEIGHT - 100, 3200 + STONE_WIDTH, getHeight() - 100), fill);
            obstacles[63] = new GameObject(
                    new Rectangle(3200, getHeight() - STONE_HEIGHT, 3200 + STONE_WIDTH, getHeight()), fill);
            firstDrawImage = false;

            obstacles[64] = new GameObject(
                    new Rectangle(3300, getHeight() - STONE_HEIGHT - 300, 3300 + STONE_WIDTH, getHeight() - 300), stoneTile);
            obstacles[65] = new GameObject(
                    new Rectangle(3300, getHeight() - STONE_HEIGHT - 200, 3300 + STONE_WIDTH, getHeight() - 200), fill);
            obstacles[66] = new GameObject(
                new Rectangle(3300, getHeight() - treasureChest_HEIGHT-70, 3300 + treasureChest_WIDTH, getHeight()-70), redtreasureChest);
            firstDrawImage = false;
            obstacles[66].hitBox.y2+=80;

            obstacles[67] = new GameObject(
                    new Rectangle(3400, getHeight() - STONE_HEIGHT - 300, 3400 + STONE_WIDTH, getHeight() - 300), stoneTile);
            obstacles[68] = new GameObject(
                    new Rectangle(3400, getHeight() - STONE_HEIGHT - 200, 3400 + STONE_WIDTH, getHeight() - 200), fill);
            // obstacles[69] = new GameObject(
            // new Rectangle(3400, getHeight() - STONE_HEIGHT, 3400 + STONE_WIDTH,
            // getHeight()), fill);
            // firstDrawImage = false;

            obstacles[70] = new GameObject(
                    new Rectangle(3500, getHeight() - STONE_HEIGHT - 300, 3500 + STONE_WIDTH, getHeight() - 300), stoneTile);
            obstacles[71] = new GameObject(
                    new Rectangle(3500, getHeight() - STONE_HEIGHT - 200, 3500 + STONE_WIDTH, getHeight() - 200), fill);
            // obstacles[72] = new GameObject(
            // new Rectangle(3500, getHeight() - STONE_HEIGHT, 3500 + STONE_WIDTH,
            // getHeight()), fill);
            // firstDrawImage = false;

            obstacles[73] = new GameObject(
                    new Rectangle(3600, getHeight() - STONE_HEIGHT - 200, 3600 + STONE_WIDTH, getHeight() - 200), stoneTile);
            // obstacles[74] = new GameObject(
            // new Rectangle(3600, getHeight() - STONE_HEIGHT, 3600 + STONE_WIDTH,
            // getHeight()), fill);

            obstacles[75] = new GameObject(
                    new Rectangle(3700, getHeight() - STONE_HEIGHT - 200, 3700 + STONE_WIDTH, getHeight() - 200), stoneTile);
            // obstacles[76] = new GameObject(
            // new Rectangle(3700, getHeight() - STONE_HEIGHT, 3700 + STONE_WIDTH,
            // getHeight()), fill);

            obstacles[77] = new GameObject(
                    new Rectangle(3800, getHeight() - STONE_HEIGHT - 200, 3800 + STONE_WIDTH, getHeight() - 200), stoneTile);
            // obstacles[78] = new GameObject(new Rectangle(3800, getHeight() - STONE_HEIGHT, 3800 + STONE_WIDTH, getHeight()), fill);

            obstacles[79] = new GameObject(
                    new Rectangle(3900, getHeight() - STONE_HEIGHT - 200, 3900 + STONE_WIDTH, getHeight() - 200), stoneTile);
            // obstacles[80] = new GameObject(
            // new Rectangle(3900, getHeight() - STONE_HEIGHT, 3900 + STONE_WIDTH,
            // getHeight()), fill);

            obstacles[81] = new GameObject(
                    new Rectangle(4000, getHeight() - STONE_HEIGHT - 200, 4000 + STONE_WIDTH, getHeight() - 200), stoneTile);
            // obstacles[82] = new GameObject(
            // new Rectangle(4000, getHeight() - STONE_HEIGHT, 4000 + STONE_WIDTH,
            // getHeight()), fill);


            obstacles[83] = new GameObject(new Rectangle(4600, getHeight() - STONE_HEIGHT, 4600 + STONE_WIDTH, getHeight()), fill);
            // obstacles[84] = new GameObject(new Rectangle(4700, getHeight() - STONE_HEIGHT, 4700 + STONE_WIDTH, getHeight()), fill);
            // obstacles[85] = new GameObject(new Rectangle(4800, getHeight() - STONE_HEIGHT, 4800 + STONE_WIDTH, getHeight()), fill);
            // obstacles[86] = new GameObject(new Rectangle(4900, getHeight() - STONE_HEIGHT, 4900 + STONE_WIDTH, getHeight()), fill);
            
            // obstacles[87] = new GameObject(new Rectangle(5000, getHeight() - STONE_HEIGHT - 400, 5000 + STONE_WIDTH, getHeight() - 400), stoneImageFlip);
            obstacles[88] = new GameObject(new Rectangle(5000, getHeight() - STONE_HEIGHT, 5000 + STONE_WIDTH, getHeight()), fill);
            obstacles[89] = new GameObject(new Rectangle(5100, getHeight() - STONE_HEIGHT, 5100 + STONE_WIDTH, getHeight()), fill);
            obstacles[89] = new GameObject(new Rectangle(5500, getHeight() - STONE_HEIGHT, 5500 + STONE_WIDTH, getHeight()), fill);
            // obstacles[89] = new GameObject(new Rectangle(5600, getHeight() - STONE_HEIGHT, 5600 + STONE_WIDTH, getHeight()), fill);
            // obstacles[90] = new GameObject(new Rectangle(5600, getHeight() - STONE_HEIGHT-100, 5600 + STONE_WIDTH, getHeight() - 100), fill);


            // obstacles[91] = new GameObject(new Rectangle(5300, getHeight() - STONE_HEIGHT - 300, 5300 + STONE_WIDTH, getHeight() - 300), stoneImageFlip);
            // obstacles[92] = new GameObject(new Rectangle(5300, getHeight() - STONE_HEIGHT - 200, 5300 + STONE_WIDTH, getHeight() - 200), fill);
            // obstacles[93] = new GameObject(new Rectangle(5400, getHeight() - STONE_HEIGHT - 200, 5400 + STONE_WIDTH, getHeight() - 200), fill);
            // obstacles[94] = new GameObject(new Rectangle(5500, getHeight() - STONE_HEIGHT - 200, 5500 + STONE_WIDTH, getHeight() - 200), fill);
            // obstacles[95] = new GameObject(new Rectangle(5600, getHeight() - STONE_HEIGHT - 200, 5600 + STONE_WIDTH, getHeight() - 200), fill);
            
            
            firstDrawImage = false;
        }
        requestFocus();

        // Draw background
        if (player.outerBox.x1 > movingFrameLimit) {
            
            surpassedPixels = player.outerBox.x1 - movingFrameLimit;  //the amt surpassed
            //switches between 2 images
            g.drawImage(bufferedImages[index], 0 - surpassedPixels, 0, this); //get rid of width and heigh to avoid scaling
            g.drawImage(bufferedImages[index + 1], getWidth() - surpassedPixels, 0, this);
            if (surpassedPixels > getWidth()) { //if player travels the frame distance
                
                surpassedPixels = 0; //reset surpassed
                 index++;  
                movingFrameLimit += getWidth();
            }
        } else
            g.drawImage(bufferedImages[0], 0, 0, getWidth(), getHeight(), this);

        // Draw player

        if (jump) {
            playerImage = new ImageIcon("res/0" + jumpCount + "_Jump.png").getImage();
        } else
            playerImage = new ImageIcon("res/0" + count + "_Walk.png").getImage();

        int playerDrawPosition = player.outerBox.x1;
        if (player.outerBox.x1 > frameLimit)
            playerDrawPosition = frameLimit;


        if(player.outerBox.x1<=5400)
        {
            Image drawImage = playerImage;
            if (!jump && !leftKeyPressed)
                drawImage = flipImage(drawImage);
            
            g.drawImage(drawImage, playerDrawPosition, player.outerBox.y1, PLAYER_WIDTH, PLAYER_HEIGHT, this);

        }

        // if(flipPlayerImage){
        //     PLAYER_ICON_WIDTH=200;
        //     PLAYER_ICON_HEIGHT=200;
        //     // System.out.println("flipplayerimage if statement");
        //     if(player.outerBox.x1<=5400) g.drawImage(playerImage, playerDrawPosition, player.outerBox.y1, PLAYER_WIDTH, PLAYER_HEIGHT,
        //                         this);
        // }
        
        // if (jump){
        //     if(player.outerBox.x1<=5400) g.drawImage(playerImage, playerDrawPosition, player.outerBox.y1, PLAYER_WIDTH, PLAYER_HEIGHT, this);
        // }
        // else{
        //     //System.out.println(" NOT NOT NOT flipplayerimage if statement");
        //     if(!flipPlayerImage && player.outerBox.x1<=5400) g.drawImage(flipImage(playerImage), playerDrawPosition, player.outerBox.y1, PLAYER_WIDTH, PLAYER_HEIGHT,
        //             this);
        // }

        drawObstacles(g);

        if (jumpCount < 8) {
            jumpCount++;
        } else {
            jumpCount = 0;
            //updateAfterJump();


        int dropPosition = windowHeight;

        for (int i = 0; i < obstacles.length; i++) {
            if (player.isXIntersect(obstacles[i])) {
                if (!flipPlayerImage && dropPosition > obstacles[i].outerBox.y1 && player.outerBox.y1<obstacles[i].outerBox.y1) {
                    dropPosition = obstacles[i].outerBox.y1;
                }
            
                    
            }
        }
        player.move(player.outerBox.x1, dropPosition - PLAYER_HEIGHT);


            jump = false;
        }
        count = (count + 1) % 7; // cycle through player images

        if (drawFrame) {
            drawFrame = false;
            timer.start();
        }

        Image objectsToFind = new ImageIcon("res/treasureNotFound.png").getImage();
        Image found = new ImageIcon("res/treasureIcon.png").getImage();
        Image circle = new ImageIcon("res/glowingCircle.png").getImage();
        if(circleCount<=15) circleCount++;
        if(!Level2Panel.treasureChestGained) g.drawImage(objectsToFind, 1200, 0, 200, 200, this);
        else {
            g.drawImage(found, 1200, 0, 200, 200, this);
            if(circleCount%3==0) g.drawImage(circle, 1200, 0, 200, 200, this);
        }
    }

    // handles what to do if a key is typed
    public void keyTyped(KeyEvent e) {
    }

    // handles what to do if a key is pressed
    public void keyPressed(KeyEvent e) {
        // System.out.println("player.outerBox.x1 " + player.outerBox.x1 + " player.outerBox.y1 " + player.outerBox.y1);
        // if(player.outerBox.x1>=3120 && player.outerBox.x1<=4000 && player.outerBox.y1 >=472)
        // {
        //      flipPlayerImage = true;
        // }
        // else flipPlayerImage = false;

        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            leftKeyPressed = true;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            rightKeyPressed = true;
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            // System.out.println("player.outerBox.x1: " + player.outerBox.x1);
            // System.out.println("player.outerBox.y1: " + player.outerBox.y1);
            // if(!(player.outerBox.x1>=3300 && player.outerBox.x1<=4000 && player.outerBox.y1 >=672)){
            //     upKeyPressed = true;
            //     jump = true;
            // }
            upKeyPressed = true;
            jump = true;

        }
        updatePlayer();
    }

    // handles what to do if a key is released
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            rightKeyPressed = false;
        if (e.getKeyCode() == KeyEvent.VK_UP)
            upKeyPressed = false;
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            leftKeyPressed = false;
    }

    // updates the player's posittion based on whatever key is pressed
    public void updatePlayer() {
        // First check for collision
        boolean collided;
        collided = false;
        //GameObject tempPlayer = new GameObject(player.outerBox, player.hitBox.x2-player.hitBox.x1, player.hitBox.y2-player.hitBox.y1);
        GameObject tempPlayer = new GameObject(new Rectangle(player.outerBox.x1, player.outerBox.y1, player.outerBox.x2, player.outerBox.y2),
        PLAYER_ICON_WIDTH, PLAYER_ICON_HEIGHT);
        // if(Math.abs(player.outerBox.x2 - obstacles[36].outerBox.x1) < 50) playerSpeed = 30;
        // else playerSpeed = 20;

        // Move up temp player to new location
        if (upKeyPressed)
            tempPlayer.move(tempPlayer.outerBox.x1, tempPlayer.outerBox.y1 - jumpSpeed);

        // Move right temp player to new location
        if (rightKeyPressed)
            tempPlayer.move(tempPlayer.outerBox.x1 + playerSpeed, tempPlayer.outerBox.y1);

        // Move left temp player to new location
        if (leftKeyPressed)
            tempPlayer.move(tempPlayer.outerBox.x1 - playerSpeed, tempPlayer.outerBox.y1);

        for (int i = 0; i < obstacles.length; i++) {
            if (i == 66)
            {
                // System.out.println("tempPlayer.hitbox.x1: " + tempPlayer.hitBox.x1);
                // System.out.println("tempPlayer.hitbox.y1: " + tempPlayer.hitBox.y1);
                // System.out.println("tempPlayer.hitbox.x2: " + tempPlayer.hitBox.x2);
                // System.out.println("tempPlayer.hitbox.y2: " + tempPlayer.hitBox.y2);
                // System.out.println("obstacles[66].hitbox.x1: " + obstacles[66].hitBox.x1);
                // System.out.println("obstacles[66].hitBox.y1: " + obstacles[66].hitBox.y1);
                // System.out.println("obstacles[66].hitBox.x2: " + obstacles[66].hitBox.x2);
                // System.out.println("obstacles[66].hitBox.y2: " + obstacles[66].hitBox.y2);

                // System.out.println("xintersect: " + tempPlayer.isXIntersect(obstacles[i]));
                // System.out.println("yintersect: " + tempPlayer.isYIntersect(obstacles[i]));

            }




            if (tempPlayer.isIntersect(obstacles[i])) {
                // System.out.println("player.outerBox.x1: " + player.outerBox.x1);
                // System.out.println("player.outerBox.y1: " + player.outerBox.y1);
                // System.out.println("player.outerBox.x2: " + player.outerBox.x2);
                // System.out.println("player.outerBox.y2: " + player.outerBox.y2);

                

                collided = true;
                if(i==66) {
                    Level2Panel.treasureChestGained=true;
                }
            }
        }

        if (!collided) {
            player.move(tempPlayer.outerBox.x1, tempPlayer.outerBox.y1);

            if (tempPlayer.outerBox.x1 >= frameLimit) {
                if (leftKeyPressed) {
                    visibleMinX -= playerSpeed;
                    visibleMaxX -= playerSpeed;
                }
                if (rightKeyPressed) {
                    visibleMinX += playerSpeed;
                    visibleMaxX += playerSpeed;
                }
            }
        }
    }
}

// this panel is shown if the player dies
   class DeathScreen2 extends JPanel implements MouseListener{

    //constructor just adds mouselistener
    public DeathScreen2(){
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
HomePage.level12Unlocked=true;
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
    //HomePage.cl.show(HomePage.mainPanel, "homePagePanel");
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