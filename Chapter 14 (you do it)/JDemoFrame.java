//JDemoFrame.java
//10/7/2024
//Alexander Cox
import javax.swing.*;
public class JDemoFrame{
    public static void main(String[] args) {
        JFrame aFrame = new JFrame("This is a frame");
        final int WIDTH = 300;
        final int HEIGHT = 250;
        aFrame.setSize(WIDTH,HEIGHT);
        aFrame.setVisible(true);
    }
}