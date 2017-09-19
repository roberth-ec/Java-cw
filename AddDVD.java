import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.*;


public class AddDVD extends JFrame
                  implements ActionListener {
    JTextField dvdNo = new JTextField(20);
      JButton PlaylistButton = new JButton("Add To Playlist");
      JButton PlayDvd  = new JButton("Play");
      JButton resetDVD = new JButton("Reset playlist");
      TextArea PlaylistInformation = new TextArea(6, 50);
    
         public AddDVD() {
      
        setLayout(new BorderLayout());
        setBounds(500, 500, 500, 500);
        setTitle("ADD DVD");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel top = new JPanel();
        top.add(new JLabel("Enter DVD No:"));
        top.add(dvdNo);
        top.add(PlaylistButton);
        PlaylistButton.addActionListener(this);
               
        setResizable(false);
        setVisible(true);
        add("North", top);
        
        JPanel middle = new JPanel();
        middle.add(PlaylistInformation);
        add("Center", middle);

        setResizable(false);
        setVisible(true);
        
         JPanel bottom = new JPanel();
       
        bottom.add(PlayDvd);
         bottom.add(resetDVD);
            PlayDvd.addActionListener(this);
             resetDVD.addActionListener(this);
        
        setResizable(false);
        setVisible(true);
        add("South", bottom);
    }
            
         
          public void actionPerformed(ActionEvent e) {
              
                        //create a map to store the playlist
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();
        int i = 0;
        //     ---------------------------------Play method----------------------------------------
        if (e.getSource() == PlayDvd) {

            String key = dvdNo.getText();
            String name = LibraryData.getName(key);
            //Call increse playcount from library data
            LibraryData.incrementPlayCount(key);

            if (name == null) {
                PlaylistInformation.setText("Write the instructions");
            } else {

                PlaylistInformation.setText(name + " - " + LibraryData.getArtist(key));
                PlaylistInformation.append("\n No of Rentals: " + LibraryData.getPlayCount(key));

            }

        }

        //   ---------------------------------Add method--------------------------------------------         
        if (e.getSource() == PlaylistButton) {

            String key = dvdNo.getText();
            String name = LibraryData.getName(key);
            //assigning  the film name to the ith location of the array.
            i++;
            map.put(i, name);

            for (int key2 : map.keySet()) {
                PlaylistInformation.append("\n" + map.get(key2));
            }

        }
        if (e.getSource() == resetDVD) {
            PlaylistInformation.setText(" ");
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
