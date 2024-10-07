//JDemoFrameThatCloses.java
//10/7/2024
//Alexander Cox
import javax.swing.*;
public class JDemoFrameThatCloses{
    public static void main(String[] args) {
        JFrame aFrame = new JFrame("This is a frame");
        final int WIDTH = 300;
        final int HEIGHT = 250;
        aFrame.setSize(WIDTH,HEIGHT);
        aFrame.setVisible(true);
        aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}