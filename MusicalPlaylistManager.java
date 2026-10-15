import java.util.*;
import java.io.*;

// CO4
class Song {
    String name, artist;
    double duration;
    int plays;

    Song(String name, String artist, double duration, int plays) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
        this.plays = plays;
    }

    void display()
     {
        System.out.println("Song: " + name);
        System.out.println("Artist: " + artist);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Plays: " + plays);
        System.out.println("Total Listening Time: "
                + (duration * plays) + " minutes");
        System.out.println();
    }
}

public class MusicalPlaylistManager {
//co3
    static void displaySongs(String a[], int n) {
        int i = 0;
        while (i < n) {
            System.out.println(a[i]);
            i++;
        }
    }

    // CO5
    static int songCount(int n) {
        int c = 0, i = 0;
        while (i < n) {
            c++;
            i++;
        }
        return c;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Song> songs = new ArrayList<>();
        int choice = 0;

        try {
            do {
                System.out.println("\n===== MUSIC PLAYLIST MANAGER =====");
                System.out.println("1. Add Song");
                System.out.println("2. Display Playlist");
                System.out.println("3. Search Song");
                System.out.println("4. Listening Statistics");
                System.out.println("5. Reset Statistics");
                System.out.println("6. Sort Songs");
                System.out.println("7. Unique Songs and Song Plays");
                System.out.println("8. Save Playlist to File");
                System.out.println("9. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();
                sc.nextLine();

                // CO2
                switch (choice) {

                    case 1:
                        System.out.print("Enter song name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter artist name: ");
                        String artist = sc.nextLine();

                        System.out.print("Enter duration in minutes: ");
                        double duration = sc.nextDouble();

                        System.out.print("Enter number of plays: ");
                        int plays = sc.nextInt();
                        sc.nextLine();

                        if (duration <= 0 || plays < 0) {
                            System.out.println("Invalid duration or plays!");
                        } else {
                            songs.add(new Song(name, artist, duration, plays));
                            System.out.println("Song added successfully!");
                        }
                        break;

                    case 2:
                        if (songs.size() == 0) {
                            System.out.println("Playlist is empty.");
                        } else {
                            System.out.println("\nYour Playlist:");

                            // CO3: Array
                            String a[] = new String[songs.size()];
                            int i = 0;

                            while (i < songs.size()) {
                                a[i] = songs.get(i).name;
                                i++;
                            }

                            displaySongs(a, songs.size());
                            System.out.println("Total Songs: "
                                    + songCount(songs.size()));

                            i = 0;
                            while (i < songs.size()) {
                                songs.get(i).display();
                                i++;
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter song to search: ");
                        String search = sc.nextLine();
                        boolean found = false;
                        int i = 0;

                        while (i < songs.size()) {
                            Song song = songs.get(i);

                            if (song.name.equalsIgnoreCase(search)) {
                                System.out.println("Song Found!");
                                song.display();
                                found = true;
                            }
                            i++;
                        }

                        if (!found) {
                            System.out.println("Song not found.");
                        }
                        break;

                    case 4:
                        int totalPlays = 0;
                        double totalTime = 0;
                        i = 0;

                        while (i < songs.size()) {
                            Song song = songs.get(i);
                            totalPlays += song.plays;
                            totalTime += song.duration * song.plays;
                            i++;
                        }

                        System.out.println("Total Songs: " + songs.size());
                        System.out.println("Total Plays: " + totalPlays);
                        System.out.println("Total Listening Time: "
                                + totalTime + " minutes");
                        break;

                    case 5:
                        i = 0;
                        while (i < songs.size()) {
                            songs.get(i).plays = 0;
                            i++;
                        }

                        System.out.println("Statistics reset successfully!");
                        break;

                    case 6:
                        Collections.sort(songs,
                                (s1, s2) -> s1.name.compareToIgnoreCase(s2.name));

                        System.out.println("Sorted Playlist:");
                        i = 0;

                        while (i < songs.size()) {
                            System.out.println(songs.get(i).name);
                            i++;
                        }
                        break;

                    case 7:
                        System.out.println("Unique Songs:");

                        songs.stream()
                                .map(s -> s.name)
                                .distinct()
                                .forEach(s -> System.out.println(s));

                        System.out.print("Enter song to count its plays: ");
                        String songName = sc.nextLine();

                        long count = songs.stream()
                                .filter(s -> s.name.equalsIgnoreCase(songName))
                                .mapToLong(s -> s.plays)
                                .sum();

                        System.out.println("Total plays of " + songName
                                + ": " + count);
                        break;

                    case 8:
                        FileWriter f = new FileWriter("songs.txt");
                        i = 0;

                        while (i < songs.size()) {
                            Song song = songs.get(i);
                            f.write(song.name + " - " + song.artist + " - " + song.duration+ " minutes - " + song.plays + " plays\n");
                            i++;
                        }

                        System.out.println("Playlist saved to songs.txt");
                        break;

                    case 9:
                        System.out.println(
                                "Thank you for using Music Playlist Manager!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } while (choice != 9);

        }
         catch (Exception e) 
         {
            System.out.println("An error occurred. Please check your input.");
        }

    }
}