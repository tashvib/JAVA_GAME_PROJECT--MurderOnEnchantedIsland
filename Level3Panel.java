/* 
    Tashvi Bansal (Period 5)
    Level3Panel.java
    05/27/23
    This class contains level3 of the game
*/

import java.awt.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.event.SwingPropertyChangeSupport;

import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

//This class contains all the JPanels, methods, classes, logic needed to play Level2 (it's unfinished though)
class Level3Panel extends JPanel implements MouseListener {
    static CardLayout level3mainCL;
    static JPanel level3MainPanel;
    DeathScreen3 deathScreen;

    // constructor for this class sets the layout and adds the quit button to the
    // top using borderLayout
    public Level3Panel() {
        setLayout(new BorderLayout());
        // add(northPanel(), BorderLayout.NORTH);
        // add(northPanel(), BorderLayout.NORTH);
        level3mainCL = new CardLayout();
        level3MainPanel = new JPanel();
        // level2MainPanel.setBackground(Color.RED);
        add(level3MainPanel, BorderLayout.CENTER);
        level3MainPanel.setLayout(level3mainCL);
        level3MainPanel.add(new Transition1(), "transition1");
        deathScreen = new DeathScreen3();
        level3MainPanel.add(new Part2(), "part2");
        level3MainPanel.add(deathScreen, "panel3");
        level3mainCL.show(level3MainPanel, "transition1");
    }

    // class that contains all the story explanation
    class Transition1 extends JPanel {
        CardLayout transition1CL;
        boolean showingLastPanel;

        // constructor for class that contains all the story explanation
        // adds ALL the plot explanation panels
        public Transition1() {
            showingLastPanel = false;
            transition1CL = new CardLayout();
            setLayout(transition1CL);
            add(new Transition1Panel0(), "pan0");
            add(new Transition1Panel1(), "pan1");
            add(new Transition1Panel2(), "pan2");
            add(new Transition1Panel3(), "pan3");
            add(new Transition1Panel4(), "pan4");
            add(new Transition1Panel5(), "pan5");
            add(new Transition1Panel6(), "pan6");
            add(new IfChestNotGained(), "pan7");
            if(!Level2Panel.treasureChestGained){        
                transition1CL.show(this, "pan7");
            }
            else transition1CL.show(this, "pan0");

        }

        //what will happen if the user did not obtain treasure chest in level 2
        class IfChestNotGained extends JPanel implements KeyListener{
            IfChestNotGained(){
                addKeyListener(this);
            }
            @Override
            protected void paintComponent(Graphics g) {
                // TODO Auto-generated method stub
                super.paintComponent(g);
                Image uhoh = new ImageIcon("UhOh.png").getImage();
                g.drawImage(uhoh, 0,0,getWidth(), getHeight(), this);
                Image shocked = new ImageIcon("Shocked.gif").getImage();
                //g.drawImage(shocked, 0,580,498, 263, this);
                requestFocus();
            }
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
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
                    }
            }
            public void keyTyped(KeyEvent e){

            }
            public void keyReleased(KeyEvent e){

            }
        }

        //what happens if the player didn't obtain the treasure chest in level2
        class Transition1Panel0 extends JPanel implements MouseListener, ActionListener {
            int paintCount = 0;
            boolean playGif;
            boolean drawEquipped = false;
            Timer tt;

            // constructs the next/upcoming panel
            public Transition1Panel0() {
                showingLastPanel = false;
                setLayout(new BorderLayout());
                add(new Transition2ButtonPanel(), BorderLayout.SOUTH);
                addMouseListener(this);
                tt = new Timer(100, this);
                tt.start();
            }

            // paints the bg image that contains the graphics for plot explanantion
            @Override
            protected void paintComponent(Graphics g) {
                // TODO Auto-generated method stub
                super.paintComponent(g);
                Image story = new ImageIcon("platformerBg1.png").getImage();
                g.drawImage(story, 0, 0, 1400, 860, this);
                Image open = new ImageIcon("OpenChest.png").getImage();
                Image treasure1 = new ImageIcon("treasure1v2.png").getImage();
                if (!playGif) {
                    g.drawImage(treasure1, 300, 100, 800, 800, this);
                    g.drawImage(open, 550, 423, 300, 100, this);
                }
                Image treasureGIF = new ImageIcon("treasure.gif").getImage();
                Image blankWood = new ImageIcon("blankWood.png").getImage();
                Image unequipped = new ImageIcon("unequipped.png").getImage();
                Image equipped = new ImageIcon("equipped.png").getImage();
                if (playGif) {
                    g.drawImage(treasureGIF, 300, 100, 800, 800, this);
                }
                if (playGif) {
                    paintCount++;
                    if (paintCount >= 25) {
                        g.drawImage(blankWood, 50, 80, 1150, 700, this);
                        if (!drawEquipped)
                            g.drawImage(unequipped, 50, 80, 1150, 700, this);
                        else
                            g.drawImage(equipped, 50, 80, 1150, 700, this);
                    }
                }

            }

            // actionPerformed method to controll animations via timer
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }

            // mouseClicked determines what to do if mouse is clicked
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getX() >= 442 && e.getX() <= 820 && e.getY() >= 474 && e.getY() <= 615 && playGif) {
                    drawEquipped = true;
                }
                if (e.getX() <= 798 && e.getX() >= 582 && e.getY() >= 435 && e.getY() <= 510 && !playGif) {
                    playGif = true;
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

        // first plot explanation panel
        class Transition1Panel1 extends JPanel {

            // constructs the next/upcoming panel
            public Transition1Panel1() {
                showingLastPanel = false;
                setLayout(new BorderLayout());
                add(new Transition2ButtonPanel(), BorderLayout.SOUTH);
            }

            // paints the bg image that contains the graphics for plot explanantion
            @Override
            protected void paintComponent(Graphics g) {
                // TODO Auto-generated method stub
                super.paintComponent(g);
                Image story = new ImageIcon("story1.png").getImage();
                g.drawImage(story, 0, 0, 1400, 860, this);
            }
        }

        // second plot explanation panel
        class Transition1Panel2 extends JPanel {
            // constructs the next/upcoming panel
            public Transition1Panel2() {
                showingLastPanel = false;
                setLayout(new BorderLayout());
                add(new Transition2ButtonPanel(), BorderLayout.SOUTH);

            }

            // paints the bg image that contains the graphics for plot explanantion
            @Override
            protected void paintComponent(Graphics g) {
                // TODO Auto-generated method stub
                super.paintComponent(g);
                Image story = new ImageIcon("story2.png").getImage();
                g.drawImage(story, 0, 0, 1400, 860, this);
            }
        }

        // third plot explanation panel
        class Transition1Panel3 extends JPanel implements ActionListener {
            int count = 5;

            // constructs the next/upcoming panel
            public Transition1Panel3() {
                showingLastPanel = false;
                setLayout(new BorderLayout());
                add(new Transition2ButtonPanel(), BorderLayout.SOUTH);
                Timer tt = new Timer(300, this);
                tt.start();
            }

            // paints the bg image that contains the graphics for plot explanantion
            @Override
            protected void paintComponent(Graphics g) {
                // TODO Auto-generated method stub
                super.paintComponent(g);
                if (count > 0)
                    count--;
                Image story = new ImageIcon("story3.png").getImage();
                g.drawImage(story, 0, 0, 1400, 860, this);
                Image demonTransformation = new ImageIcon("0" + count + "_Attack_4.png").getImage();
                g.drawImage(demonTransformation, 730, 210, 386 + 100, 315 + 100, this);
            }

            // actionperformed method that aids in updating the graphics
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        }

        // fourth plot explanation panel
        class Transition1Panel4 extends JPanel {

            // constructs the next/upcoming panel
            public Transition1Panel4() {
                showingLastPanel = false;
                setLayout(new BorderLayout());
                add(new Transition2ButtonPanel(), BorderLayout.SOUTH);

            }

            // paints the bg image that contains the graphics for plot explanantion
            @Override
            protected void paintComponent(Graphics g) {
                // TODO Auto-generated method stub
                super.paintComponent(g);
                Image story = new ImageIcon("story4.png").getImage();
                g.drawImage(story, 0, 0, 1400, 860, this);
            }
        }

        // fifth plot explanation panel
        class Transition1Panel5 extends JPanel {

            // constructs the next/upcoming panel
            public Transition1Panel5() {
                showingLastPanel = false;
                setLayout(new BorderLayout());
                add(new Transition2ButtonPanel(), BorderLayout.SOUTH);

            }

            // paints the bg image that contains the graphics for plot explanantion
            @Override
            protected void paintComponent(Graphics g) {
                // TODO Auto-generated method stub
                super.paintComponent(g);
                Image story = new ImageIcon("story5.png").getImage();
                g.drawImage(story, 0, 0, 1400, 860, this);
            }
        }

        // sixth plot explanation panel
        class Transition1Panel6 extends JPanel implements MouseListener {

            // constructs the next/upcoming panel
            public Transition1Panel6() {
                showingLastPanel = false;
                addMouseListener(this);
                setLayout(new BorderLayout());
                // add(new Transition2ButtonPanel(), BorderLayout.SOUTH);
                showingLastPanel = true;
            }

            // paints the bg image that contains the graphics for plot explanantion
            @Override
            protected void paintComponent(Graphics g) {
                // TODO Auto-generated method stub
                super.paintComponent(g);
                Image story = new ImageIcon("story7.png").getImage();
                g.drawImage(story, 0, 0, 1400, 860, this);
                Image nextArrButton = new ImageIcon("NextArrowButton.png").getImage();
                g.drawImage(nextArrButton, 1250, 760, 150, 100, this);
            }

            // mousePressed determines what to do if mouse is clicked
            public void mousePressed(MouseEvent e) {
            }

            // mouseClicked determines what to do if mouse is clicked
            public void mouseClicked(MouseEvent e) {
                if (e.getX() >= 1250 && e.getX() <= 1400 && e.getY() <= 820 && e.getY() >= 760) {
                    Level3Panel.level3MainPanel.add(new Challenge1(), "challenge1");
                    Level3Panel.level3mainCL.show(Level3Panel.level3MainPanel, "challenge1");
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
                Image nextArrButton = new ImageIcon("NextArrowButton.png").getImage();
                g.drawImage(nextArrButton, 1250, 100, 150, 100, this);
            }

            // mousePressed determines what to do if mouse is pressed
            public void mousePressed(MouseEvent e) {
                if (e.getX() >= 1250 && e.getX() <= 1400 && e.getY() <= 200 && e.getY() >= 100) {
                    // if(showingLastPanel){
                    // Level3Panel.level3MainPanel.add(new Challenge1(), "challenge1");
                    // Level3Panel.level3mainCL.show(Level3Panel.level3MainPanel, "challenge1");
                    // }
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

    // the first challlegen of level3 (all logic + graphics)
    //player has to figure out how to stop attackers from spawing
    class Challenge1 extends JPanel implements KeyListener, ActionListener {
        // Character class defines the properties of ALL the characters (e.g. ogres +
        // player(girl))

        // defines what a character is (similar logic to level1)
        //attackers & player are defined by the Character class
        class Character {
            int X;
            int Y;
            int steps;
            int attackingCount;
            int runningCount;
            boolean attackerAttack;
            double health;
            boolean faceLeft;

            // the character constructor initializes the properties of the character
            public Character(int _X, int _Y, int _count, int _steps, double _health) {
                X = _X; // an x pos is passed into the constructor and sets the x value of the character
                        // to that value
                Y = _Y; // an y pos is passed into the constructor and sets the y value of the character
                        // to that value
                steps = _steps; // how many pixels the character moves for each step
                attackingCount = _count; // animation frame count (so like for the "warrior" ogre there are 4 animation
                                         // panels)
                runningCount = _count;
                attackerAttack = false;
                health = _health;
                faceLeft = false;
            }
        }

        int girlIconWidth = 200; // width of ANY character icon
        int girlIconHeight = 200;// height of ANY character icon
        int iconWidth = 200; // width of ANY character icon
        int iconHeight = 200;// height of ANY character icon
        int windowWidth = 0; // Challenge 2 panel width (currently assigned to an incorrect value but in the
                             // paintcomponet it will be assigned to the proper width)
        int windowHeight = 0;// Challenge 2 panel height (currently assigned to an incorrect value but in the
                             // paintcomponet it will be assigned to the proper height)
        Character girl = new Character(0, 0, 0, 20, 6);
        Character attacker1 = new Character(0, 0, 0, 3, 6);
        private Timer timer;
        boolean changeRight;
        boolean changeLeft;
        int countToCreateNewAttacker;
        boolean drawImage = false;
        boolean firstPaint = true;
        boolean spacePressed = false;
        int powerUpCount=0;
        boolean stationary = true;
        boolean obtained=false;
        boolean drawPressSpaceToAttack = true;
        int waitCounter = 0;
        int timeOnRightButton;
        int timeOnLeftButton;
        boolean stopSpawning = false;
        boolean girlFacingRight = false;
        ArrayList<Character> attackers = new ArrayList<Character>(); //array *list* because infinite amount of attackers

        ArrayList<Heart> heartArr = new ArrayList<Heart>();

        // Challenge 2 constructor adds the mouselistener, keylistener, sets the layout,
        // and adds timer
        public Challenge1() {
            setBackground(Color.PINK);
            addKeyListener(this);
            setLayout(null); // TODO why we need null layout?
            timer = new Timer(100, this); // call actionPerformed() every 50 milliseconds
            timer.start();
        }

        // the UpdateAttacker method updates the attacker (the ghosts) positions by
        // literally returning a Character obj to place on the panel
        public Character UpdateAttacker(Character _attacker) {
            double dx = girl.X - _attacker.X;
            double dy = girl.Y - _attacker.Y;
            double distance = Math.sqrt(dx * dx + dy * dy); // hypotenuse using pythagorean theorem

            // trigonometry to calculate how the ogre should move to attack the player
            double direction = Math.atan2(dy, dx); // inverse tan to calculate the angle of elevation from attacker to
                                                   // player
            double dxNew = _attacker.steps * Math.cos(direction);
            double dyNew = _attacker.steps * Math.sin(direction);

            if (dxNew < 0)
                _attacker.faceLeft = true;
            else
                _attacker.faceLeft = false;
            // Update character position
            if (distance > 30.0) {
                _attacker.X += dxNew;
                _attacker.Y += dyNew;
            }

            // //if (distance > 120.0 && girl.health<6) girl.health+=0.005;
            // if (Math.abs(xPosPowerUp - (girl.X + 80)) < 20 && Math.abs(yPosPowerUp -
            // (girl.Y + 137)) < 20) {
            // girl.health+=0.05;
            // }
            // if (Math.abs(xPosPowerUp - (girl.X + 80)) < 20 && Math.abs(yPosPowerUp - (girl.Y + 137)) < 20 && girl.health<6) {
            //     girl.health+=0.05;
            // }
for(int i = 0; i<heartArr.size(); i++){
                if (Math.abs(heartArr.get(i).xPosPowerUp - (girl.X + 80)) < 20 && Math.abs(heartArr.get(i).yPosPowerUp - (girl.Y + 137)) < 20 && girl.health<6 && heartArr.get(i).alive) {
                    girl.health+=0.1;
                    heartArr.get(i).obtained=true;
                }
            }

            // this is saying that if the distance between any one of the ogre's and the
            // player is less than 30
            // the player's lives will decrease
            if ((distance <= 30.0) && !firstPaint) {
                _attacker.attackerAttack = true;
                if (_attacker.health > 0) {
                    girl.health -= 0.05; // why does she just randomly die?
                }
                if (spacePressed) {
                    _attacker.health -= 0.30;
                }
            } else
                _attacker.attackerAttack = false;

            if (girl.health <= 0) {
                level3mainCL.show(Level3Panel.level3MainPanel, "panel3");
                try {
                    // Load the sound clip from a file
                    Clip clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(new File("girlScream.wav")));

                    // Play the sound clip
                    clip.start();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            return _attacker;

        }

        // this actionPerformed method calls update attacker every 100 milliseconds (bc
        // of the timer)
        @Override
        public void actionPerformed(ActionEvent e) {
            timer.stop();
            powerUpCount++;
            countToCreateNewAttacker++;
            attacker1 = UpdateAttacker(attacker1);
            drawImage = true;
            //stopSpawning is controlled in paintcomponet and relies on whether or not the player is stepping on both the right and left pad
            if (countToCreateNewAttacker % 50 == 0 && !stopSpawning) { // every 5 secnods (50 calls = 5 seconds)
                attackers.add(new Character(600, 406, 0, 6, 6));
                //Character(x,y,count(for switching panels),speed/steps, health)
            }
            for (int x = 0; x < attackers.size(); x++) {
                attackers.set(x, UpdateAttacker(attackers.get(x)));
                //update EACH attacker
            }
            int xOffset = 90;
            int yOffset = 100;
            //checking if girl's position fits on the right button
            if (girl.X >= 1281 - xOffset && girl.X <= 1381 - xOffset && girl.Y >= 487 - yOffset && girl.Y <= 570 - yOffset) {
                timeOnRightButton++;//if so we start increasing the counter that counts the amt of time on the right button
            } else
                timeOnRightButton = 0;


            //checking if girl's position fits on the left button
            if (girl.X >= 0 - xOffset && girl.X <= 100 - xOffset && girl.Y >= 487 - yOffset
                    && girl.Y <= 570 - yOffset) {
                timeOnLeftButton++;//if so we start increasing the counter that counts the amt of time on the left button
            } else
                timeOnLeftButton = 0;
            if (timeOnLeftButton == 50)
                changeLeft = true;
            if (timeOnRightButton == 50)
                changeRight = true;

                // powerUpCount++;
                // if (powerUpCount == 200)
                //     powerUpCount = 0;
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
                heart = new ImageIcon("powerUpHeart.png").getImage();
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

        // paintcomponent draws the visual components of the challenge
        public void paintComponent(Graphics g) {
            // level3mainCL.show(Level3Panel.this, "panel6");
            super.paintComponent(g);
            Image bgBothDark = new ImageIcon("story8.png").getImage();
            Image bgRightBright = new ImageIcon("RightBright.png").getImage();
            Image rightCloseLeftOpen = new ImageIcon("RightCloseLeftOpen.png").getImage();
            Image rightOpenLeftClose = new ImageIcon("RightOpenLeftClose.png").getImage();
            Image rightCloseLeftClose = new ImageIcon("RightCloseLeftClose.png").getImage();
            Image rightOpenLeftOpen = new ImageIcon("RightOpenLeftOpen.png").getImage();
            Image bgLeftBright = new ImageIcon("LeftBright.png").getImage();
            Image bgBothBright = new ImageIcon("BothBright.png").getImage();
            Image half = new ImageIcon("HalfBoardedBg.png").getImage();
            Image full = new ImageIcon("FullBoardedBg.png").getImage();
Image blankMiddleToCoverOld = new ImageIcon("BlankBackground.png").getImage();
            if (changeRight && !changeLeft){
                g.drawImage(bgRightBright, 0, 0, 1400, 870, this);
                g.drawImage(blankMiddleToCoverOld, 0, 0, 1400, 860, this);
                g.drawImage(rightCloseLeftOpen, 500, 400, (int)(616/1.5), (int)(405/1.5), this);
            }
            else if (changeLeft && !changeRight){
                g.drawImage(bgLeftBright, 0, 0, 1400, 870, this);
                g.drawImage(blankMiddleToCoverOld, 0, 0, 1400, 860, this);
                g.drawImage(rightOpenLeftClose, 500, 400, (int)(616/1.5), (int)(405/1.5), this);
            }
            else if (changeLeft && changeRight) {
                stopSpawning = true;
                g.drawImage(full, 0, 0, 1400, 870, this);
                g.drawImage(blankMiddleToCoverOld, 0, 0, 1400, 860, this);
                g.drawImage(rightCloseLeftClose, 500, 400, (int)(616/1.5), (int)(405/1.5), this);
            } else{
                g.drawImage(bgBothDark, 0, 0, 1400, 870, this);
                g.drawImage(blankMiddleToCoverOld, 0, 0, 1400, 860, this);
                g.drawImage(rightOpenLeftOpen, 500, 400, (int)(616/1.5), (int)(405/1.5), this);
            }
            if (firstPaint) {

                firstPaint = false;
                windowWidth = getWidth();
                windowHeight = getHeight();
                girl.X = (windowWidth) / 2 - iconWidth;
                girl.Y = (windowHeight) / 2 - iconHeight;
            }

            if (drawImage) {
                Image healthbar;
                Image girlImage;

                healthbar = new ImageIcon("0" + (int) (7 - girl.health - 1) + "_healthbar.png").getImage();
                g.drawImage(healthbar, 1100, 0, 300, 100, this);

                // if the girl is not stationary (i.e. the user pressed the arrow keys so she
                // should be walking)
                if (!stationary) {
                    girlImage = new ImageIcon("0" + girl.attackingCount + "_Walk.png").getImage();
                    stationary = true;
                } else
                    girlImage = new ImageIcon("00_Walk.png").getImage();
                // g.drawImage(girlImage, girl.X, girl.Y, 300, 300, this);

                if (spacePressed) {
                    girlImage = new ImageIcon("cast" + girl.attackingCount + ".png").getImage();
                    if (girl.attackingCount == 6)
                        spacePressed = false;
                }
                if (girlFacingRight) {
                    BufferedImage flippedImage = flipImage(girlImage);
                    g.drawImage(flippedImage, girl.X, girl.Y, iconWidth, iconHeight, this);
                } else {
                    g.drawImage(girlImage, girl.X, girl.Y, iconWidth, iconHeight, this);
                }

                Image attackImage;

                for (int i = 0; i < attackers.size(); i++) {
                    if (attackers.get(i).health > 0) {
                        if (attackers.get(i).attackerAttack)
                            attackImage = new ImageIcon("0" + attackers.get(i).attackingCount + "_Attack_3.png")
                                    .getImage();
                        // otherwise draw the running sequence
                        else
                            attackImage = new ImageIcon("0" + attackers.get(i).runningCount + "_GhostRun.png")
                                    .getImage();

                        Image healthImage = new ImageIcon(
                                "0" + (int) (7 - attackers.get(i).health - 1) + "_healthbar2.png").getImage();
                        g.drawImage(healthImage, attackers.get(i).X + 10, attackers.get(i).Y - 10, iconWidth - 40,
                                iconHeight - 70, this);

                        if (attackers.get(i).faceLeft) {
                            BufferedImage attackFlippedImage = flipImage(attackImage);
                            g.drawImage(attackFlippedImage, attackers.get(i).X, attackers.get(i).Y, iconWidth,
                                    iconHeight, this);
                        } else
                            g.drawImage(attackImage, attackers.get(i).X, attackers.get(i).Y, iconWidth, iconHeight,
                                    this);

                    }
                }

                drawImage = false;
                // if(girl.count<=7) girl.count++;
                // else girl.count=0;
                girl.attackingCount = (girl.attackingCount + 1) % 7; // cycle through frames

                for (int x = 0; x < attackers.size(); x++) {
                    Character temp = attackers.get(x);
                    temp.attackingCount = (temp.attackingCount + 1) % 7;
                    temp.runningCount = (temp.runningCount + 1) % 5;
                    attackers.set(x, temp);
                }

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

            // Image heart = new ImageIcon("powerUpHeart.png").getImage();
            // if(powerUpCount==0){
            //     xPosPowerUp = (int)(Math.random()*1000+100);
            //     yPosPowerUp = (int)(Math.random()*500+100);
            // }
            // if(powerUpCount<=90 && powerUpCount>=0) {
            //     if(!obtained)g.drawImage(heart, xPosPowerUp, yPosPowerUp, 30, 30, this);
            // }
            // if(powerUpCount<=110 && powerUpCount>=90) {
            //     if(powerUpCount%4==0) g.drawImage(heart, xPosPowerUp, yPosPowerUp, 30, 30, this);
            // }
            if (stopSpawning) {
                int everyAttackerIsDead = 0;
                for (int k = 0; k < attackers.size(); k++) {
                    if (attackers.get(k).health > 0)
                        everyAttackerIsDead++;
                }
                Image howDare = new ImageIcon("HowDareYou.png").getImage();
                if (everyAttackerIsDead == 0) {

                    Level3Panel.level3mainCL.show(Level3Panel.level3MainPanel, "part2");
                    // Image unleash = new ImageIcon("unleash.png").getImage();
                    // g.drawImage(unleash, 0, 0, 1400, 860, this);
                }
            }

        }

        // this keypressed method determines what to do if any of the arrow keys are
        // pressed
        public void keyPressed(KeyEvent e) {
            drawPressSpaceToAttack = false;
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                girl.attackingCount = 0;
                spacePressed = true;
            }

            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                girl.X -= girl.steps; // minus the amount of pixels to the girl's x pos to move left
                stationary = false;
                girlFacingRight = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                girl.X += girl.steps; // add the amount of pixels to the girl's x pos to move left
                stationary = false;
                girlFacingRight = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                girl.Y += girl.steps;
                stationary = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                girl.Y -= girl.steps;
                stationary = false;
            }

            if (girl.X >= getWidth() - 120)
                girl.X = getWidth() - 120;
            if (girl.Y >= getHeight() - 200)
                girl.Y = getHeight() - 200;
            if (girl.Y <= -80)
                girl.Y = -80;
            if (girl.X <= -80)
                girl.X = -80;
        }

        // determines what happens if a key is released
        public void keyReleased(KeyEvent e) {
        }

        // determines what happens if a key is typed
        public void keyTyped(KeyEvent e) {
        }

    }

    // this class is a continuation of prior challenge class
    // i wanted to add some plot explanation between the two so i just created a
    // separate class
    class Part2 extends JPanel {
        int timesActionPerformedWasCalled = 0;
        boolean drawNext = false;
        CardLayout part2Cl;
        JPanel part2Panel;
        int girlXAfterAttackerDies = 0;
        int girlYAfterAttackerDies = 0;
        int attackerXAfterAttackerDies = 0;
        int attackerYAfterAttackerDies = 0;

        // constructs the necessary panels needed for the second part of the challenge
        // this includes a plot explanation panel
        public Part2() {
            part2Cl = new CardLayout();
            setLayout(part2Cl);
            add(new Panel1(), "pan1");
            add(new ActualPart2(), "pan2");
            part2Cl.show(this, "pan1");
        }

        // this is the plot explanation panel
        class Panel1 extends JPanel implements MouseListener {

            // constructor just adds the mouselistener
            public Panel1() {
                addMouseListener(this);
            }

            // draws the necessary graphcis to help the user understnad the plot
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image bg = new ImageIcon("unleash.png").getImage();
                // else bg = new ImageIcon("EmptyBattlefield.png").getImage();
                Image rightCloseLeftClose = new ImageIcon("RightCloseLeftClose.png").getImage();
                Image blankMiddleToCoverOld = new ImageIcon("OtherBlankBackground.png").getImage();
                g.drawImage(bg, 0, 0, 1400, 860, this);
               g.drawImage(blankMiddleToCoverOld, 0, 0, 1400, 860, this);
                g.drawImage(rightCloseLeftClose, 500, 400, (int)(616/1.5), (int)(405/1.5), this);
                Image nextArrButton = new ImageIcon("NextArrowButton.png").getImage();
                g.drawImage(nextArrButton, 1250, 760, 150, 100, this);
            }

            // mousePressed determines what to do if mouse is pressed (goes to next panel in
            // cardlayout)
            public void mousePressed(MouseEvent e) {
                if (e.getX() >= 1250 && e.getX() <= 1400 && e.getY() <= 760 + 200 && e.getY() >= 760) {
                    part2Cl.show(Part2.this, "pan2");
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

        
        // second challenge of level 3, you are fighting the "boss" villain
        //many different weapons
        class ActualPart2 extends JPanel implements ActionListener, KeyListener {

            int count = 0;
            int audioCount;

            // Character class defines the properties of ALL the characters (e.g. ogres +
            // player(girl))
            class Character {
                int X;
                int Y;
                int steps;
                int count;
                boolean attackerAttack;
                double health;
                boolean faceLeft;

                // the character constructor initializes the properties of the character
                public Character(int _X, int _Y, int _count, int _steps, double _health) {
                    X = _X; // an x pos is passed into the constructor and sets the x value of the character
                            // to that value
                    Y = _Y; // an y pos is passed into the constructor and sets the y value of the character
                            // to that value
                    steps = _steps; // how many pixels the character moves for each step
                    count = _count; // animation frame count (so like for the "warrior" ogre there are 4 animation
                                    // panels)
                    attackerAttack = false;
                    health = _health;
                    faceLeft = false;
                }
            }

            int girlIconWidth = 200; // width of ANY character icon
            int girlIconHeight = 200;// height of ANY character icon
            int iconWidth = 200; // width of ANY character icon
            int iconHeight = 200;// height of ANY character icon
            int windowWidth = 0; // Challenge 2 panel width (currently assigned to an incorrect value but in the
                                 // paintcomponet it will be assigned to the proper width)
            int windowHeight = 0;// Challenge 2 panel height (currently assigned to an incorrect value but in the
                                 // paintcomponet it will be assigned to the proper height)
            Character girl = new Character(0, 0, 0, 20, 6);
            Character attacker1 = new Character(0, 0, 0, 9, 6);
            private Timer timer;
            int numTimesBloodSpatter;
            int numTimesBloodSpatter2;
            int numTimesBloodSpatter3;
            boolean drawImage = false;
            boolean firstPaint = true;
            boolean spacePressed = false;
            boolean stationary = true;
            boolean attacker1Dead = false;
            boolean drawPressSpaceToAttack = true;
            int potionAnimationCount = 0;
            int waitCounter = 0;
            boolean drawDaggerAttacker=false;
            int yDaggerIncrement=0;
            int yDaggerDecrement=0;

            // Bomb class defines the properties of a bomb
            // there are 3 bombs so more effective to have a class
            class Bomb {
                int xPos = 0;
                int yPos = 0;
                int timesBombBeenDropped = 0;
                boolean detonate = false;
                boolean selected = false;
                boolean drawn = false;
                int count = 0;
                boolean dropBomb = false;
            }

            Bomb bomb1 = new Bomb();
            Bomb bomb2 = new Bomb();
            Bomb bomb3 = new Bomb();
            boolean daggerFacingRight = false;
            boolean daggerSelected = false;
            boolean throwDagger = false;
            int timesDaggerBeenThrown = 0;
            int daggerXPos = 0;
            int daggerYPos = 0;
            boolean playDaggerCast = false;

            int sickleNum=0;

            ArrayList<Dagger> daggers = new ArrayList<Dagger>();
            ArrayList<Dagger> daggersForAttacker = new ArrayList<Dagger>();
            ArrayList<Dagger> daggersForAttacker2 = new ArrayList<Dagger>();
            ArrayList<Dagger> daggersForAttacker3 = new ArrayList<Dagger>();
            int throwDaggerWaitCount = 0;
            boolean potion1Selected = false;
            boolean potion2Selected = false;
            boolean drawPotionDrinkingAnimation = false;
            boolean whipSelected = false;

            int xPosGlowBox = 415;

            boolean shiftBoxRight = false;
            boolean shiftBoxLeft = false;
            boolean girlFacingRight = false;
            int healthBarScaleFactor = 5;
            boolean attackerFacingRight = false;
            int spacePressedCounter = 0;

            int timesCalled=0;
            boolean potion1HasBeenDranken = false;
            boolean potion2HasBeenDranken = false;

            // Challenge 2 constructor adds the mouselistener, keylistener, sets the layout,
            // and adds timer
            public ActualPart2() {
                addKeyListener(this);
                setLayout(null);

                timer = new Timer(100, this); // call actionPerformed() every 50 milliseconds
                timer.start();
            }

            // gets distance between an obj (it's x and y pos are passed in) and the "boss"
            // villain
            public double getDistance(int xPos, int yPos, Character _attacker) {
                double dx = xPos - _attacker.X;
                double dy = yPos - _attacker.Y;
                double distance = Math.sqrt(dx * dx + dy * dy); // hypotenuse using pythagorean theorem
                return distance;
            }
            public double getDistanceDagger(int xPos, int yPos, Character _attacker) {
                double dx = xPos - (_attacker.X+50);
                double dy = yPos -( _attacker.Y+50);
                double distance = Math.sqrt(dx * dx + dy * dy); // hypotenuse using pythagorean theorem
                return distance;
            }
            // the UpdateAttacker method updates the attacker (the ogres) positions by
            // literally returning a Character obj to place on the panel
            public Character UpdateAttacker(Character _attacker) {
               //_attacker.health -= 0.3;
                double dx = girl.X - _attacker.X;
                double dy = girl.Y - _attacker.Y;
                double distance = Math.sqrt(dx * dx + dy * dy); // hypotenuse using pythagorean theorem

                // trigonometry to calculate how the ogre should move to attack the player
                double direction = Math.atan2(dy, dx); // inverse tan to calculate the angle of elevation from attacker
                                                       // to player
                double dxNew = _attacker.steps * Math.cos(direction);
                double dyNew = _attacker.steps * Math.sin(direction);

                if (dxNew < 0)
                    _attacker.faceLeft = true;
                else
                    _attacker.faceLeft = false;
                // _attacker.health+=0.01;
                if ((getDistance(bomb1.xPos, bomb1.yPos, _attacker) <= 158.0) && bomb1.detonate) {
                    _attacker.health -= 0.12;
                    if (bomb1.count >= 9)
                        bomb1.detonate = false;
                }

                if ((getDistance(bomb2.xPos, bomb2.yPos, _attacker) <= 158.0) && bomb2.detonate) {
                    _attacker.health -= 0.12;
                    if (bomb2.count >= 9)
                        bomb2.detonate = false;
                }

                if ((getDistance(bomb3.xPos, bomb3.yPos, _attacker) <= 158.0) && bomb3.detonate) {
                    _attacker.health -= 0.12;
                    if (bomb3.count >= 9)
                        bomb3.detonate = false;
                }

                for (int x = 0; x < daggers.size(); x++) {
                    if ((getDistanceDagger(daggers.get(x).daggerXPos, daggers.get(x).daggerYPos, attacker1) <= 158.0)
                            && daggers.get(x).alive) {
                        _attacker.health -= 0.2;
                        System.out.println("daggersAlve" + x+"    " + daggers.get(x).alive);
                        daggers.get(x).alive = false;

                    }
                }

                for (int x = 0; x < daggersForAttacker.size(); x++) {
                    System.out.println("alive: " + daggersForAttacker.get(x).alive);
                    System.out.println("xPos: " + daggersForAttacker.get(x).daggerXPos);
                    System.out.println("yPos: " + daggersForAttacker.get(x).daggerYPos);
                    System.out.println("girlx : " + girl.X + "    girl.Y: " + girl.Y);
                    System.out.println("distance: " + getDistanceDagger(daggersForAttacker.get(x).daggerXPos, daggersForAttacker.get(x).daggerYPos, girl));
                    
                    if ((getDistanceDagger(daggersForAttacker.get(x).daggerXPos, daggersForAttacker.get(x).daggerYPos, girl) <= 50.0)
                            && daggersForAttacker.get(x).alive) {
                        girl.health -= 1;
                        daggersForAttacker.get(x).alive = false;

                    }
                }
                for (int x = 0; x < daggersForAttacker2.size(); x++) {
                    if ((getDistanceDagger(daggersForAttacker2.get(x).daggerXPos, daggersForAttacker2.get(x).daggerYPos, girl) <= 50.0)
                            && daggersForAttacker2.get(x).alive) {
                        girl.health -= 1;
                        daggersForAttacker2.get(x).alive = false;

                    }
                }
                for (int x = 0; x < daggersForAttacker3.size(); x++) {
                    System.out.println("alive: " + daggersForAttacker3.get(x).alive);
                    System.out.println("xPos: " + daggersForAttacker3.get(x).daggerXPos);
                    System.out.println("yPos: " + daggersForAttacker3.get(x).daggerYPos);
                    System.out.println("girlx : " + girl.X + "    girl.Y: " + girl.Y);
                    System.out.println("distance: " + getDistanceDagger(daggersForAttacker3.get(x).daggerXPos, daggersForAttacker3.get(x).daggerYPos, girl));
                    
                    if ((getDistanceDagger(daggersForAttacker3.get(x).daggerXPos, daggersForAttacker3.get(x).daggerYPos, girl) <= 55.0)
                            && daggersForAttacker3.get(x).alive) {
                        girl.health -= 1;
                        daggersForAttacker3.get(x).alive = false;

                    }
                }
                // Update character position
                if (distance > 30.0) {
                    _attacker.X += dxNew;
                    _attacker.Y += dyNew;
                }

                // if (distance > 120.0 && girl.health<6) girl.health+=0.005;
                
                //activates the increase of health if the player selects and drinks potion
                if (drawPotionDrinkingAnimation)
                    girl.health = 6;
                // this is saying that if the distance between any one of the ogre's and the
                // player is less than 30
                // the player's lives will decrease
                if ((distance <= 30.0) && !firstPaint) {
                    audioCount++;
                    boolean playAudio = false;
                    _attacker.attackerAttack = true;
                    if (_attacker.health > 0) {
                        girl.health -= 0.10;
                    }
                    //what happens if player selects the whip and then clicks space (to activate the whip)
                    if (spacePressed && whipSelected) {
                        _attacker.health -= 0.08; //significant damage
                        //hard bc you have to go up close to the attacker
                    }

                    if (audioCount % 3 == 0 && playAudio) {
                        // try {
                        // // Load the sound clip from a file
                        // Clip clip = AudioSystem.getClip();
                        // clip.open(AudioSystem.getAudioInputStream(new File("oof.wav")));

                        // // Play the sound clip
                        // clip.start();
                        // } catch (Exception ex) {
                        // ex.printStackTrace();
                        // }
                    }
                    // if(_attacker.health==24) drawHB1 = true;
                } else
                    _attacker.attackerAttack = false;

                if (girl.health <= 0) {
                    level3mainCL.show(Level3Panel.level3MainPanel, "panel3");
                    try {
                        // Load the sound clip from a file
                        Clip clip = AudioSystem.getClip();
                        clip.open(AudioSystem.getAudioInputStream(new File("girlScream.wav")));

                        // Play the sound clip
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

                if (_attacker.health <= 0) {
                    girlXAfterAttackerDies = girl.X;
                    girlYAfterAttackerDies = girl.Y;
                    attackerXAfterAttackerDies = _attacker.X;
                    attackerYAfterAttackerDies = _attacker.Y;

                    Part2.this.add(new End(), "pan3");
                    part2Cl.show(Part2.this, "pan3");
                }

                return _attacker;

            }

            // this actionPerformed method calls update attacker every 100 milliseconds (bc
            // of the timer)
            @Override
            public void actionPerformed(ActionEvent e) {

                count++;
                if(count%100==0) {
                    timesCalled++;
                    drawDaggerAttacker=true;
                       daggersForAttacker.add(new Dagger());
                       daggersForAttacker2.add(new Dagger());
                       daggersForAttacker3.add(new Dagger());
                }
                
                else drawDaggerAttacker=false;
                //daggersForAttacker.add(new Dagger());
                timer.stop();
                attacker1 = UpdateAttacker(attacker1);
                    
                drawImage = true;
                repaint();
            }

            // Dagger class defines how a dagger should behave when thrown
            class Dagger {

                boolean daggerFacingRight = false;
                boolean daggerSelected = false;
                boolean throwDagger = false;
                int timesDaggerBeenThrown = 0;
                int daggerXPos = 0;
                int daggerYPos = 0;
                boolean alive = true;

                // draw method acts as a paint componet
                // draws the actions of the dagger based on what the user does
                public void draw(Graphics g) {
                    Image dagger = new ImageIcon("dagger.png").getImage();
                    if (throwDagger) {
                        timesDaggerBeenThrown++;
                        if (timesDaggerBeenThrown == 1) {
                            System.out.println("timesDaggerBeenThrown: " + timesDaggerBeenThrown);
                            daggerXPos = girl.X + 40;
                            daggerYPos = girl.Y + 90;
                            if (!girlFacingRight)
                                daggerFacingRight = false;
                            if (girlFacingRight)
                                daggerFacingRight = true;
                        }
                        //System.out.println("daggerFacingRight: " + daggerFacingRight);
                        if (!daggerFacingRight) {
                            
                            System.out.println("Before !daggerFacingRight: " + daggerXPos);
                            daggerXPos -= 20;
                            dagger = flipImage(dagger);
                            System.out.println("!daggerFacingRight: " + daggerXPos);
                        } else{
                            System.out.println("Before daggerFacingRight: " + daggerXPos);
                            daggerXPos += 20;
                            System.out.println("daggerFacingRight: akhsdhkjsd " + daggerXPos);
                        }
                        g.drawImage(dagger, daggerXPos, daggerYPos, 60, 60, null);
                        if (daggerXPos <= 0 || daggerXPos >= 1400) {
                            alive = false;
                            throwDagger = false;
                        }

                    }
                }
                public void drawAttackerDagger(Graphics g, int addX, int addY, String sickleImgTitle){
                    Image dagger = new ImageIcon("sickle.gif").getImage();
                    //if (throwDagger) {
                        System.out.println("drawingDagger");
                        timesDaggerBeenThrown++;
                        if (timesDaggerBeenThrown == 1) {

                            daggerXPos = attacker1.X + 40;
                            daggerYPos = attacker1.Y + 90;
                            System.out.println("inside drawing dagger");
                            if (attacker1.faceLeft)
                                daggerFacingRight = false;
                            if (!attacker1.faceLeft)
                                daggerFacingRight = true;
                        }
                        if (!daggerFacingRight) {
                            daggerXPos -= addX;
                            dagger = flipImage(dagger);
                            daggerYPos+=addY;
                        } else{
                            daggerXPos += addX;
                            daggerYPos+=addY;
                        }

                        
                        // g.setColor(Color.BLUE);
                        // g.fillRect(daggerXPos, daggerYPos, 60, 60);
                        g.drawImage(dagger, daggerXPos, daggerYPos, 60, 60, null);
                        if (daggerXPos <= 0 || daggerXPos >= 1400) {
                            alive = false;
                            //throwDagger = false;
                        }

                   // }
                }
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

            // paintcomponent draws the visual components of the challenge
            public void paintComponent(Graphics g) {
                // Image forestEnchanted = new ImageIcon("ForestLevel1Bg.png").getImage();
                Image pressSpaceToAttack = new ImageIcon("PressSpaceToAttack.png").getImage();
                // g.drawImage(forestEnchanted, 0, 0, 1400, 870, this);

                Image bg = new ImageIcon("EmptyBattlefield.png").getImage();
                g.drawImage(bg, 0, 0, 1400, 860, this);
                Image rightCloseLeftClose = new ImageIcon("RightCloseLeftClose.png").getImage();
                Image blankMiddleToCoverOld = new ImageIcon("BlankBackground.png").getImage();
                g.drawImage(blankMiddleToCoverOld, 0, 0, 1400, 860, this);
                g.drawImage(rightCloseLeftClose, 500, 400, (int)(616/1.5), (int)(405/1.5), this);
                Image toolbar = new ImageIcon("toolbar.png").getImage();
                g.drawImage(toolbar, 400, 750, 90 * 7 + 30, 100, this);
                Image whipIcon = new ImageIcon("whipIcon.png").getImage();
                g.drawImage(whipIcon, 430, 760, 70, 70, this);
                Image bombIcon = new ImageIcon("bombIcon.png").getImage();
                if (bomb1.timesBombBeenDropped <= 0) {
                    g.drawImage(bombIcon, 520, 760, 70, 70, this);
                }
                if (bomb2.timesBombBeenDropped <= 0)
                    g.drawImage(bombIcon, 610, 760, 70, 70, this);
                if (bomb3.timesBombBeenDropped <= 0)
                    g.drawImage(bombIcon, 700, 760, 70, 70, this);
                Image daggerIcon = new ImageIcon("daggerIcon.png").getImage();
                g.drawImage(daggerIcon, 790, 760, 70, 70, this);
                Image potionIcon = new ImageIcon("potionIcon.png").getImage();
                if (!potion1HasBeenDranken)
                    g.drawImage(potionIcon, 880, 770, 60, 60, this);
                if (!potion2HasBeenDranken)
                    g.drawImage(potionIcon, 970, 770, 60, 60, this);

                Image glowBox = new ImageIcon("RedGlowingBox.png").getImage();
                if (shiftBoxRight && xPosGlowBox <= 865) {
                    xPosGlowBox += 90;
                    shiftBoxRight = false;
                }
                if (shiftBoxLeft && xPosGlowBox >= 505) {
                    xPosGlowBox -= 90;
                    shiftBoxLeft = false;
                }
                if (xPosGlowBox == 415)
                    whipSelected = true;
                else
                    whipSelected = false;
                if (xPosGlowBox == 415 + 90)
                    bomb1.selected = true;
                else
                    bomb1.selected = false;
                if (xPosGlowBox == 415 + 180)
                    bomb2.selected = true;
                else
                    bomb2.selected = false;
                if (xPosGlowBox == 415 + 270)
                    bomb3.selected = true;
                else
                    bomb3.selected = false;
                if (xPosGlowBox == 415 + 360)
                    daggerSelected = true;
                else
                    daggerSelected = false;
                if (xPosGlowBox == 415 + 450)
                    potion1Selected = true;
                else
                    potion1Selected = false;
                if (xPosGlowBox == 415 + 540)
                    potion2Selected = true;
                else
                    potion2Selected = false;


                    System.out.println("paintcomponet");
                for (int x = 0; x < daggers.size(); x++) {
                    if (daggers.get(x).alive){
                        System.out.println("x index dagger inside : " + x);
                        System.out.println("xPos: " + daggers.get(x).daggerXPos);
                        System.out.println("yPos: " + daggers.get(x).daggerYPos);
                        daggers.get(x).draw(g);
                    }
                    System.out.println("x index dagger outisde : " + x);
                }
                for (int x = 0; x < daggersForAttacker.size(); x++) {
                    if (daggersForAttacker.get(x).alive){
                        if(sickleNum<=3) sickleNum++;
                        else sickleNum=0;
                       // daggersForAttacker.get(x).drawAttackerDagger(g, 20, -100);
                        daggersForAttacker.get(x).drawAttackerDagger(g, 20, 0, ("sickle" + sickleNum + ".png"));
                        // daggersForAttacker.get(x).drawAttackerDagger(g, 20, 100);
                    }
                }
                for (int x = 0; x < daggersForAttacker2.size(); x++) {
                    if (daggersForAttacker2.get(x).alive){
                        daggersForAttacker2.get(x).drawAttackerDagger(g, 20, -10, ("sickle" + sickleNum + ".png"));
                        //daggersForAttacker.get(x).drawAttackerDagger(g, 20, 0);
                        // daggersForAttacker.get(x).drawAttackerDagger(g, 20, 100);
                    }
                }
                for (int x = 0; x < daggersForAttacker3.size(); x++) {
                    if (daggersForAttacker3.get(x).alive){
                        //daggersForAttacker2.get(x).drawAttackerDagger(g, 20, -10);
                        //daggersForAttacker.get(x).drawAttackerDagger(g, 20, 0);
                        daggersForAttacker3.get(x).drawAttackerDagger(g, 20, 10, ("sickle" + sickleNum + ".png"));
                    }
                }
                // if(throwDagger){
                // timesDaggerBeenThrown++;
                // if(timesDaggerBeenThrown==1){
                // daggerXPos=girl.X+40;
                // daggerYPos=girl.Y+90;
                // if(!girlFacingRight) daggerFacingRight=false;
                // if(girlFacingRight) daggerFacingRight=true;
                // }
                // if(!daggerFacingRight) {
                // daggerXPos-=20;
                // dagger = flipImage(dagger);
                // }
                // else daggerXPos+=20;
                // g.drawImage(dagger, daggerXPos, daggerYPos,60,60,this );
                // if(daggerXPos<=0 || daggerXPos>=1400) throwDagger=false;

                // }

                if (bomb1.detonate) {
                    Image bombImg = new ImageIcon("bombExplosion" + bomb1.count + ".png").getImage();
                    g.drawImage(bombImg, bomb1.xPos, bomb1.yPos, 120, 80, this);
                } else if (bomb1.dropBomb == true && bomb1.count == 0) {
                    bomb1.timesBombBeenDropped++;
                    int yOffset = 90;
                    int xOffset = 40;
                    Image bombImg = new ImageIcon("bomb.png").getImage();
                    if (bomb1.timesBombBeenDropped == 1) {
                        bomb1.xPos = girl.X + xOffset;
                        bomb1.yPos = girl.Y + yOffset;
                    }
                    g.drawImage(bombImg, bomb1.xPos, bomb1.yPos, 120, 80, this);
                }
                if (bomb2.detonate) {
                    Image bombImg = new ImageIcon("bombExplosion" + bomb2.count + ".png").getImage();
                    g.drawImage(bombImg, bomb2.xPos, bomb2.yPos, 120, 80, this);
                } else if (bomb2.dropBomb == true && bomb2.count == 0) {
                    bomb2.timesBombBeenDropped++;
                    int yOffset = 90;
                    int xOffset = 40;
                    Image bombImg = new ImageIcon("bomb.png").getImage();
                    if (bomb2.timesBombBeenDropped == 1) {
                        bomb2.xPos = girl.X + xOffset;
                        bomb2.yPos = girl.Y + yOffset;
                    }
                    g.drawImage(bombImg, bomb2.xPos, bomb2.yPos, 120, 80, this);
                }
                if (bomb3.detonate) {
                    Image bombImg = new ImageIcon("bombExplosion" + bomb3.count + ".png").getImage();
                    g.drawImage(bombImg, bomb3.xPos, bomb3.yPos, 120, 80, this);
                } else if (bomb3.dropBomb == true && bomb3.count == 0) {
                    bomb3.timesBombBeenDropped++;
                    int yOffset = 90;
                    int xOffset = 40;
                    Image bombImg = new ImageIcon("bomb.png").getImage();
                    if (bomb3.timesBombBeenDropped == 1) {
                        bomb3.xPos = girl.X + xOffset;
                        bomb3.yPos = girl.Y + yOffset;
                    }
                    g.drawImage(bombImg, bomb3.xPos, bomb3.yPos, 120, 80, this);
                }

                if (bomb1.selected || bomb2.selected || bomb3.selected) {
                    Image pressSToDrop = new ImageIcon("PressSToDrop.png").getImage();

                    Image detonate = new ImageIcon("Detonate.png").getImage();
                    if (bomb1.selected && bomb1.timesBombBeenDropped > 0) {
                        g.drawImage(detonate, 500, 730, 90, 40, this);
                    } else if (bomb2.selected && bomb2.timesBombBeenDropped > 0) {
                        g.drawImage(detonate, 590, 730, 90, 40, this);
                    } else if (bomb3.selected && bomb3.timesBombBeenDropped > 0) {
                        g.drawImage(detonate, 680, 730, 90, 40, this);
                    } else
                        g.drawImage(pressSToDrop, 500, 700, 200, 70, this);

                }
                g.drawImage(glowBox, xPosGlowBox, 760, 90, 85, this);
                if (firstPaint) {
                    firstPaint = false;
                    windowWidth = getWidth();
                    windowHeight = getHeight();
                    girl.X = (windowWidth) / 2 - iconWidth;
                    girl.Y = (windowHeight) / 2 - iconHeight;
                }

                if (drawImage) {
                    Image healthbar;
                    Image girlImage;

                    healthbar = new ImageIcon("0" + (int) (7 - girl.health - 1) + "_healthbar.png").getImage();
                    g.drawImage(healthbar, 1100, 0, 300, 100, this);
                    if (spacePressed) {

                        if (whipSelected) {
                            girlImage = new ImageIcon("0" + girl.count + "_whipAttack_2.png").getImage();
                            girlImage = flipImage(girlImage);
                        } else {
                            girlImage = new ImageIcon("cast" + girl.count + ".png").getImage();
                        }

                        if (girl.count == 6)
                            spacePressed = false;
                    } else if (playDaggerCast) {
                        girlImage = new ImageIcon("cast" + girl.count + "Dagger.png").getImage();
                        if (girl.count >= 6)
                            playDaggerCast = false;
                    }
                    // if the girl is not stationary (i.e. the user pressed the arrow keys so she
                    // should be walking)
                    else if (!stationary) {
                        girlImage = new ImageIcon("0" + girl.count + "_Walk.png").getImage();
                        stationary = true;
                    } else
                        girlImage = new ImageIcon("00_Walk.png").getImage();
                    // g.drawImage(girlImage, girl.X, girl.Y, 300, 300, this);

                    if (drawPotionDrinkingAnimation) {
                        if (potionAnimationCount <= 7)
                            potionAnimationCount++;
                        else
                            drawPotionDrinkingAnimation = false;
                        girlImage = new ImageIcon("0" + potionAnimationCount + "_DrinkingPotion.png").getImage();
                    }
                    if (girlFacingRight) {
                        BufferedImage flippedImage = flipImage(girlImage);
                        g.drawImage(flippedImage, girl.X, girl.Y, iconWidth, iconHeight, this);
                    } else {
                        g.drawImage(girlImage, girl.X, girl.Y, iconWidth, iconHeight, this);
                    }

                    Image attackImage;

                    if (attacker1.health > 0) { // if the attacker is still alive
                        // if the "attackerAttack" of the attacker1 obj is true then draw the attack
                        // sequence
                        if (attacker1.attackerAttack) {
                            attackImage = new ImageIcon("0" + attacker1.count + "_Attack_4.png").getImage();
                            attackImage = flipImage(attackImage);
                        }
                        // otherwise draw the running sequence
                        else
                            attackImage = new ImageIcon("0" + attacker1.count + "_girlRun.png").getImage();

                        Image healthImage = new ImageIcon("0" + (int) (7 - attacker1.health - 1) + "_healthbar2.png")
                                .getImage();
                        g.drawImage(healthImage, attacker1.X + 10, attacker1.Y - 10, iconWidth - 40, iconHeight - 70,
                                this);

                        if (attacker1.faceLeft) {
                            BufferedImage attackFlippedImage = flipImage(attackImage);
                            if (attacker1.attackerAttack)
                                g.drawImage(attackFlippedImage, attacker1.X, attacker1.Y, iconWidth + 70,
                                        iconHeight + 70, this);
                            else
                                g.drawImage(attackFlippedImage, attacker1.X, attacker1.Y, iconWidth, iconHeight, this);
                        } else if (attacker1.attackerAttack)
                            g.drawImage(attackImage, attacker1.X, attacker1.Y, iconWidth + 70, iconHeight + 70, this);
                        else
                            g.drawImage(attackImage, attacker1.X, attacker1.Y, iconWidth, iconHeight, this);
                    }
                    // if all the ogres are dead
                    if (attacker1Dead) {
                        waitCounter++;
                        if (waitCounter == 15) {
                        }
                    }

                    drawImage = false;
                    // if(girl.count<=7) girl.count++;
                    // else girl.count=0;
                    girl.count = (girl.count + 1) % 7; // cycle through frames
                    if (bomb1.count <= 9 && bomb1.detonate) {
                        bomb1.count++;
                    }
                    if (bomb2.count <= 9 && bomb2.detonate) {
                        bomb2.count++;
                    }
                    if (bomb3.count <= 9 && bomb3.detonate) {
                        bomb3.count++;
                    }
                    attacker1.count = (attacker1.count + 1) % 4; // cycle through frames

                    timer.start();
                }
                requestFocus();

            }

            // this keypressed method determines what to do if any of the arrow keys are
            // pressed
            public void keyPressed(KeyEvent e) {
                drawPressSpaceToAttack = false;
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    shiftBoxRight = false;
                    shiftBoxLeft = true;
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    if (bomb1.selected)
                        bomb1.dropBomb = true;
                    if (bomb2.selected)
                        bomb2.dropBomb = true;
                    if (bomb3.selected)
                        bomb3.dropBomb = true;
                    if (daggerSelected) {
                        throwDaggerWaitCount++;
                        if (throwDaggerWaitCount % 2 == 0 || throwDaggerWaitCount == 1) {
                            playDaggerCast = true;
                            Dagger dagger = new Dagger();
                            System.out.println("addDagger");
                            daggers.add(dagger);
                            dagger.throwDagger = true;
                            timesDaggerBeenThrown = 0;
                        }
                    }
                    if (potion1Selected && !potion2Selected && !potion1HasBeenDranken) {
                        potionAnimationCount = 0;
                        drawPotionDrinkingAnimation = true;
                        potion1HasBeenDranken = true;
                    }
                    if (potion2Selected && !potion1Selected && !potion2HasBeenDranken) {
                        potionAnimationCount = 0;
                        drawPotionDrinkingAnimation = true;
                        potion2HasBeenDranken = true;
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                    shiftBoxRight = true;
                    shiftBoxLeft = false;
                } else if (e.getKeyCode() == KeyEvent.VK_W) {
                    // );
                    if (bomb1.selected && bomb1.timesBombBeenDropped > 0) {
                        bomb1.detonate = true;
                    }
                    if (bomb2.selected && bomb2.timesBombBeenDropped > 0)
                        bomb2.detonate = true;
                    if (bomb3.selected && bomb3.timesBombBeenDropped > 0)
                        bomb3.detonate = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    girl.count = 0;
                    spacePressed = true;
                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    girl.X -= girl.steps; // minus the amount of pixels to the girl's x pos to move left
                    stationary = false;
                    girlFacingRight = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    girl.X += girl.steps; // add the amount of pixels to the girl's x pos to move left
                    stationary = false;
                    girlFacingRight = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    girl.Y += girl.steps;
                    stationary = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    girl.Y -= girl.steps;
                    stationary = false;
                }

                girl.X = Math.min(windowWidth - iconWidth, Math.max(0, girl.X));
                girl.Y = Math.min(windowHeight - iconHeight, Math.max(0, girl.Y));
            }

            // determines what happens if a key is released
            public void keyReleased(KeyEvent e) {
            }

            // determines what happens if a key is typed
            public void keyTyped(KeyEvent e) {
            }

        }

        //Ending scene panel
        //draws the ending scene of level 3
        //i.e. what happens if the main boss villain is killed / player win condition
        class End extends JPanel implements ActionListener, KeyListener {
            int dyingAnimationCount = 0;
            int count = 0;
            boolean showScene1 = false;
            boolean showScene2 = false;
            boolean showScene3 = false;
            boolean showScene4 = false;
            boolean showScene5 = false;
            boolean showPortal = false;
            int girlWalkCount = 0;
            boolean keyPressed = false;
            boolean movingRight = false;
            Timer tt;
            int girlDyingImgWidth=200;
            int attackerDyingImgHeight=200;
            boolean makeImgBigger=false;
            int widthIncCount=0;
            boolean playExplosion=false;
            int playExplosionCount=1;

            //constructor for end panel
            //starts timer
            public End() {
                setBackground(Color.PINK);
                addKeyListener(this);
                tt = new Timer(200, this);
                tt.start();
                setFocusable(true);
            }

            //draws the visual component of the end scene
            //it also transfers to the next panel if the player "steps into" the portal
            @Override
            protected void paintComponent(Graphics g) {
                // TODO Auto-generated method stub
                super.paintComponent(g);
                if (girlXAfterAttackerDies >= 900 && girlXAfterAttackerDies <= 1400 && girlYAfterAttackerDies >= 436
                        && girlYAfterAttackerDies <= 540 && showPortal) {

                    try {
                        level3MainPanel.add(new Transition2(), "transition2");
                    } catch (UnsupportedAudioFileException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (LineUnavailableException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    level3mainCL.show(level3MainPanel, "transition2");
                }
                Image bg = new ImageIcon("EmptyBattlefield.png").getImage();
                Image rightCloseLeftClose = new ImageIcon("RightCloseLeftClose.png").getImage();
                Image blankMiddleToCoverOld = new ImageIcon("OtherBlankBackground.png").getImage();
                g.drawImage(bg, 0, 0, 1400, 860, this);
               g.drawImage(blankMiddleToCoverOld, 0, 0, 1400, 860, this);
               g.drawImage(rightCloseLeftClose, 500, 400, (int)(616/1.5), (int)(405/1.5), this);
                Image girlImage = new ImageIcon("0" + girlWalkCount + "_Walk.png").getImage();
                if (movingRight)
                    girlImage = flipImage(girlImage);
                g.drawImage(girlImage, girlXAfterAttackerDies, girlYAfterAttackerDies, 200, 200, this);
                Image attackerImage = new ImageIcon("0" + (dyingAnimationCount) + "_AttackerDead.png").getImage();
                Image explosionImage = new ImageIcon("Explosion_" + (playExplosionCount) + ".png").getImage();
                if(makeImgBigger ) {
                    widthIncCount+=50;
                }
                g.drawImage(attackerImage, attackerXAfterAttackerDies, attackerYAfterAttackerDies, girlDyingImgWidth+widthIncCount, attackerDyingImgHeight+widthIncCount, this);
                Image endingScene1 = new ImageIcon("EndingScene1.png").getImage();
                if (showScene1){
                    g.drawImage(endingScene1, attackerXAfterAttackerDies + 90, attackerYAfterAttackerDies - 70, 768 / 3,
                            672 / 3, this);
                }
                if (showScene2) {
                    g.drawImage(explosionImage, -500, -500, 768*3, 672*3, this);
                }
                if(showScene3){

                }
                    // Image endingScene2 = new ImageIcon("EndingScene2.png").getImage();
                // if (showScene2)
                //     g.drawImage(endingScene2, attackerXAfterAttackerDies + 90, attackerYAfterAttackerDies - 70, 768 / 3,
                //             672 / 3, this);
                Image endingScene3 = new ImageIcon("EndingScene3.png").getImage();
                if (showScene4)
                    g.drawImage(endingScene3, girlXAfterAttackerDies + 110, girlYAfterAttackerDies - 90, 768 / 3,
                            672 / 3, this);
                Image endingScene4 = new ImageIcon("EndingScene4.png").getImage();
                if (showScene5)
                    g.drawImage(endingScene4, girlXAfterAttackerDies + 110, girlYAfterAttackerDies - 90, 768 / 3,
                            672 / 3, this);
                Image portal = new ImageIcon("GroundPortal.png").getImage();
                if (showPortal) {
                    g.drawImage(portal, 900, 300, 500, 500, this);
                }
                requestFocus();
            }

            //actionPerformed method to control what imgs are showing in paintcomponent
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                // if (count <= 39 && count >= 30){
                //     dyingAnimationCount++;
                //     makeImgBigger=true;
                // }
                if (count >= 0 && count <= 20)
                    showScene1 = true;
                else
                    showScene1 = false;

                if(count>=20 && count<=30) {
                    showScene2=true;
                    playExplosionCount++;
                }
                else showScene2=false;
                if(count>=25 && count<=35){
                    showScene3=true;
                    makeImgBigger=true;
                }else {
                    showScene3=false;
                    makeImgBigger=false;
                }
                if(count>=30 && count<=40) dyingAnimationCount++;
                if(count>=38 && count<=48) showScene4=true;
                else showScene4=false;
                if(count>=48 && count<=54) showScene5=true;
                else showScene5=false;
                if(count>=52) showPortal=true;
                // if (count <= 39 && count >= 29) {
                //     showScene3 = true;
                // } else
                //     showScene3 = false;
                // if (count >= 39 && count <= 49)
                //     showScene4 = true;
                // else
                //     showScene4 = false;
                if (count >= 49) {
                    showPortal = true;
                    if (girlWalkCount <= 6 && keyPressed)
                        girlWalkCount++;
                    else
                        girlWalkCount = 0;
                } else
                    showPortal = false;

                    
                repaint();
            }

            // determines what to do if key is pressed
            public void keyPressed(KeyEvent e) {
                keyPressed = true;
                if (showPortal) {
                    tt.setDelay(80);
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        girlXAfterAttackerDies += 10;
                        movingRight = true;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        girlXAfterAttackerDies -= 10;
                        movingRight = false;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_UP) {
                        girlYAfterAttackerDies -= 10;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                        girlYAfterAttackerDies += 10;
                    }
                }
            }

            // determines what to do if key is typed
            public void keyTyped(KeyEvent e) {
            }

            // determines what to do if key is released
            public void keyReleased(KeyEvent e) {
                keyPressed = false;
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
        }
    }

    // second ending scene panel
    // handles the audio
    // what happens when the player steps inot the portal
    class Transition2 extends JPanel implements ActionListener{
        Clip clip2;
        int count=0;
        Timer tt;
        // constructor for ending scene
        public Transition2() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
            //File audioFile = new File("HomeScreenAudio.wav");
            HomePage.clip.stop();
            try {
                // Load the sound clip from a file
                Clip clip2 = AudioSystem.getClip();
                clip2.open(AudioSystem.getAudioInputStream(new File("WinMusic.wav")));

                // Play the sound clip
                clip2.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            tt = new Timer(100, this);
            tt.start();
        }

        //paintcomponent draws the haunted library gif and confetti
        public void paintComponent(Graphics g) {
            Image backToHauntedLibrary = new ImageIcon("HauntedLibraryAfter.gif").getImage();
            g.drawImage(backToHauntedLibrary, 0, 0, 1400, 860, this);
            Image confetti = new ImageIcon("confetti.gif").getImage();
            if(count==100){
                g.drawImage(confetti, 0, 0, 600, 600, this);
                g.drawImage(confetti, 600, 0, 600, 600, this);
                g.drawImage(confetti, 1200, 0, 600, 600, this);
                tt.stop();
            }

        }

        //actionperformed is called every 100 milliseconds
        //count is incremented
        //repaint is called
        @Override
        public void actionPerformed(ActionEvent e) {
            count++;
            repaint();
        }
    }

    // determines what happens if mouse is clicked within quit label's boundaries
    public void mouseClicked(MouseEvent e) {
        HomePage.cl.show(HomePage.mainPanel, "homePagePanel");
        try {
            // Load the sound clip from a file
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("ButtonClick.wav")));

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

    // this panel is shown if the player dies
    class DeathScreen3 extends JPanel implements MouseListener {

        // constructor just adds mouselistener
        public DeathScreen3() {
            addMouseListener(this);
        }

        // paintcomponent draws all the visual components of deathscreen
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Image bg = new ImageIcon("red.gif").getImage();
            g.drawImage(bg, 0, 0, 1400, 900, this);
            Image youdied = new ImageIcon("YouDied.png").getImage();
            g.drawImage(youdied, 0, 0, 1400, 900, this);
        }

        // mousePRessed determines what to do if mouse is pressed
        public void mousePressed(MouseEvent e) {

        }

        // mouseClicked determines what to do if mouse is clicked
        public void mouseClicked(MouseEvent e) {
            if (e.getX() >= 395 && e.getX() <= 1054 && e.getY() >= 465 && e.getY() <= 692) {
                HomePage.level123Unlocked=true;
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
            clip.open(AudioSystem.getAudioInputStream(new File("ButtonClick.wav")));
    
            // Play the sound clip
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
                //HomePage.cl.show(HomePage.mainPanel, "homePagePanel");
                try {
                    // Load the sound clip from a file
                    Clip clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(new File("ButtonClick.wav")));

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