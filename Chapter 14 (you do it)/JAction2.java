//JAction2.java
//10/7/2024
//AlexanderCox
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JAction2 extends JFrame implements ActionListener{
    JLabel label = new JLabel("Name?");
    JTextField field = new JTextField(12);
    JButton button = new JButton("OK");
    


public JAction2(){
    super("Action");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new FlowLayout());
    add(label);
    add(field);
    add(button);
    button.addActionListener(this);
    field.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        
        Object source = e.getSource();
        if(source == button)
            label.setText("You clicked the Button");
        else
            label.setText("You pressed Enter");
        
    }
    public static void main(String[] args) {
        JAction2 aFrame = new JAction2();
        final int WIDTH = 250;
        final int HEIGHT = 150;
        aFrame.setSize(WIDTH,HEIGHT);
        aFrame.setVisible(true);
    }
}