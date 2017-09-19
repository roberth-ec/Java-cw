import java.util.*;

public class LibraryData {

    private static class Item {

        Item(String n, String a, int r) {
            name = n;
            artist = a;
            rating = r;
        }

        // instance variables 
        private String name;
        private String artist;
        private int rating;
        private int playCount;

        public String toString() {
            return name + " - " + artist;
        }
    }

    // with a Map you use put to insert a key, value pair 
    // and get(key) to retrieve the value associated with a key
    // You don't need to understand how this works!
    private static Map<String, Item> library = new TreeMap<String, Item>();
    

    static {
        // if you want to have extra library items, put them in here
        // use the same style - keys should be 2 digit Strings
        library.put("01", new Item("12 Years a Slave", "Steve McQueen", 3));
        library.put("02", new Item("8 Mile", " Curtis Hanson", 1));
        library.put("03", new Item("Pirates of the Caribbean", " Jerry Bruckheimer", 2));
        library.put("04", new Item("The Godfather", "Francis Ford Coppola", 5));
        library.put("05", new Item("The Matrix", "Andy Wachowski", 4));
    }

    public static String listAll() {
        String output = "";
        Iterator iterator = library.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            Item item = library.get(key);
            output += key + " " + item.name + " - " + item.artist + "\n";
        }
        return output;
    }

    public static String getName(String key) {
        Item item = library.get(key);
        if (item == null) {
            return null; // null means no such item
        } else {
            return item.name;
        }
    }
 

    public static String getArtist(String key) {
        Item item = library.get(key);
        if (item == null) {
            return null; // null means no such item
        } else {
            return item.artist;
        }
    }

    public static int getRating(String key) {
        Item item = library.get(key);
        if (item == null) {
            return -1; // negative quantity means no such item
        } else {
            return item.rating;
        }
    }

    public static void setRating(String key, int rating) {
        Item item = library.get(key);
        if (item != null) {
            item.rating = rating;
        }
    }

    public static int getPlayCount(String key) {
        Item item = library.get(key);
        if (item == null) {
            return -1; // negative quantity means no such item
        } else {
            return item.playCount;
        }
    }

    public static void incrementPlayCount(String key) {
        Item item = library.get(key);
        if (item != null) {
            item.playCount += 1;
        }
    }

    public static void close() {
        // Does nothing for this static version.
        // Write a statement to close the database when you are using one
    }
}
