 
import java.util.*;

public class CO6
 {
    public static void main(String[] args)
     {
        ArrayList<String> songs = new ArrayList<>();

        songs.add("Perfect");
        songs.add("Believer");
        songs.add("Perfect");
        songs.add("Shape of You");

        System.out.println("All Songs:");
        songs.forEach(s -> System.out.println(s));

        System.out.println("\nTotal Plays: " + songs.size());

        System.out.println("\nUnique Songs:");
        songs.stream()
             .distinct()
             .forEach(s -> System.out.println(s));

        System.out.println("\nPerfect Plays:");
        long count = songs.stream()
            .filter(s -> s.equals("Perfect"))
            .count();

        System.out.println(count);
    }
}
