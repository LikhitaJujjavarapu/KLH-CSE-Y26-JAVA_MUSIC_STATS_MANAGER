
import java.util.*;
import java.io.*;

public class CO5
 {
    public static void main(String[] args) throws Exception
     {

        ArrayList<String> songs = new ArrayList<>();

        songs.add("Perfect");
        songs.add("Believer");
        songs.add("Shape of You");

        Scanner sc = new Scanner(System.in);

        // Search
        System.out.println("Enter the song you want to search:");
        String a = sc.nextLine();

        int i = 0;
        boolean found = false;

        while (i < songs.size()) 
            {
            String s = songs.get(i);

            if (s.equalsIgnoreCase(a))
                {
                System.out.println("Song Found: " + s);
                found = true;
            }

            i++;
        }

        if (!found) 
            {
            System.out.println("Song not found!");
        }

        // Sort
        Collections.sort(songs);

        System.out.println("\nSorted Songs:");

        int sort = 0;

        while (sort < songs.size())
             {
            String p = songs.get(sort);
            System.out.println("Sorted playlist = " + p);
            sort++;
        }

        // Save to file
        FileWriter f = new FileWriter("songs.txt");

        int file = 0;

        while (file < songs.size())
             {
            String e = songs.get(file);
            f.write(e + "\n");
            file++;
        }

        f.close();

        System.out.println("Songs saved successfully!");

        sc.close();
    }
}
