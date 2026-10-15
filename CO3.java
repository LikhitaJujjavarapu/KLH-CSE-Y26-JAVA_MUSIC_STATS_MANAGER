import java.util.Scanner;
public class CO3
 {
    public void DisplaySongs(String a[], int n)
    {
        System.out.println("Playlist");
        for (int i = 0; i < n; i++) 
    {
         System.out.println (a[i]);
    }
    }

    static int Songcount(int n) 
    {
        int c=0;
        for(int i=0;i<n;i++)
        { 
            c++;
        }
        return c;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Songs=");
        int n = sc.nextInt();
        sc.nextLine();
        String a[] = new String[n];
        for (int i = 0; i < n; i++) 
    {
            System.out.print("Enter Songs=");
            a[i] = sc.nextLine();
    } 
        displaySongs(a, n);
        System.out.println("Total songs are= " + Songcount(n));
    }
 }
    