/* 
    Tashvi Bansal (Period 5)
    HomePage.java
    04/29/23
    This class contains the main frame of the game
*/

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

    //Main class contains the main frame of the entire game
public class Main {
    public static HomePage hp;
    public static JFrame mainFrame;
    //Everything else is added to HomePage
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, FontFormatException {
      createNewMain("Murder On Enchanted Island");
    }
    //Main constructor constructs JFrame and adds instance of HomePage to the JFrame
    public Main(String game) throws UnsupportedAudioFileException, IOException, LineUnavailableException, FontFormatException{
        mainFrame = new JFrame(game);
        mainFrame.setSize(1400,900);
        mainFrame.setResizable(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hp = new HomePage();
        mainFrame.add(hp); //HomePage holds the cardlayout of the entire game
        mainFrame.setVisible(true);
    }
    public static void createNewMain(String gameName) throws UnsupportedAudioFileException, IOException, LineUnavailableException, FontFormatException{
        Main mainWindow = new Main(gameName); //instance of Main
    }
}
