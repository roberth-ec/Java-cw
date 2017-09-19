import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Update  extends JFrame
                  implements ActionListener {
    JTextField DvdNumber = new JTextField(20);
    JTextField NewDvdRating = new JTextField(20);
      JButton UpdateButton  = new JButton("Click here to Update the new changes");
       TextArea PlaylistInformation = new TextArea(6, 50);
public Update () {
setLayout(new BorderLayout());
        setBounds(500, 500, 500, 500);
        setTitle("UPDATE DVD RATING");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel top = new JPanel();
        top.add(new JLabel("Enter DVD No:"));
        top.add(DvdNumber);       
        setResizable(false);
        setVisible(true);
        add("North", top);
        JPanel middle = new JPanel();
        middle.add( new JLabel ("Enter new DVD Rating"));
        middle.add (NewDvdRating);
        middle.add (PlaylistInformation);
        setResizable(false);
        setVisible(true);
        add("Center", middle);
        JPanel bottom = new JPanel();
        bottom.add(UpdateButton);
        UpdateButton.addActionListener(this);
        setResizable(false);
        setVisible(true);
        add("South", bottom);
    }

   public void actionPerformed(ActionEvent e) {
               if (e.getSource() == UpdateButton) {
            
            String key = DvdNumber.getText();
            String name = LibraryData.getName(key);
        //read the rating from the user interface and convert it to integer
        int Rating = Integer.parseInt(NewDvdRating.getText());
        LibraryData.setRating(key, Rating);
            if (name == null) {
                PlaylistInformation.setText("Write the instructions");
            } else {
                PlaylistInformation.setText(name + " - " + LibraryData.getArtist(key));
                PlaylistInformation.append("\nRating: " + stars(LibraryData.getRating(key)));
                PlaylistInformation.append("\n No of Rentals: " + LibraryData.getPlayCount(key));
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
