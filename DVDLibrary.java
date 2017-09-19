import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DVDLibrary extends JFrame
        implements ActionListener {

    JButton check = new JButton("Check DVD");
    JButton playlist = new JButton("Add DVD");
    JButton update = new JButton("Update DVD");
    JButton quit = new JButton("Exit");

    
    public static void main(String[] args) {
        new DVDLibrary();
    }

    public DVDLibrary() {
        
        setLayout(new BorderLayout());
        setSize(450, 100);
        setTitle("DVD Library System");

        // close application only by clicking the quit button
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        JPanel top = new JPanel();
        top.add(new JLabel("Select an option by clicking one of the buttons below"));
        add("North", top);

        JPanel bottom = new JPanel();
        bottom.add(check);
        check.addActionListener(this);
        bottom.add(playlist);
        playlist.addActionListener(this);
        bottom.add(update);
        update.addActionListener(this);
        bottom.add(quit);
        quit.addActionListener(this);
        add("South", bottom);

        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == check) {
            new CheckDVD();
            //Createplaylist
        }
        if (e.getSource() == playlist) {
            new AddDVD();

        }
        if (e.getSource() == update) {
            new Update();

        } else if (e.getSource() == quit) {
            LibraryData.close();
            System.exit(0);
        }
    }
 }
