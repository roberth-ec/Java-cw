import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckDVD extends JFrame
                  implements ActionListener {
    JTextField trackNo = new JTextField(4);
    TextArea information = new TextArea(6, 50);
    JButton list = new JButton("List All DVD");
    JButton check = new JButton("Check DVD");
    public CheckDVD() {
        setLayout(new BorderLayout());
        setBounds(100, 100, 400, 200);
        setTitle("Check DVD");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel top = new JPanel();
        top.add(new JLabel("Enter DVD Number:"));
        top.add(trackNo);
        top.add(check);
        top.add(list);
        list.addActionListener(this);
        check.addActionListener(this);
        add("North", top);
        JPanel middle = new JPanel();
        information.setText(LibraryData.listAll());
        middle.add(information);
        add("Center", middle);

        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == list) {
            information.setText(LibraryData.listAll());
        } else {
            String key = trackNo.getText();
            String name = LibraryData.getName(key);
            if (name == null) {
                information.setText("Write the instructions");
            } else {
                information.setText(name + " - " + LibraryData.getArtist(key));
                information.append("\nRating: " + stars(LibraryData.getRating(key)));
                information.append("\n No of Rentals: " + LibraryData.getPlayCount(key));
            }
        }
    }

    private String stars(int rating) {
        String stars = "";
        for (int i = 0; i < rating; ++i) {
            stars += "*";
        }
        return stars;
    }
}
