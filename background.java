import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class background extends JFrame
{
JButton b1;
JLabel l1;
    public background()
    {
    setTitle("Background Color for JFrame");
    setSize(400,400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    }
}

/*
    One way
    -----------------
    setLayout(new BorderLayout());
    JLabel background=new JLabel(new ImageIcon("C:\\Users\\Computer\\Downloads\\colorful design.png"));
    add(background);
    background.setLayout(new FlowLayout());
    l1=new JLabel("Here is a button");
    b1=new JButton("I am a button");
    background.add(l1);
    background.add(b1);
*/