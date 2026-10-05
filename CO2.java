import java.util.Scanner;
public class CO2
 {
    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);
        int choice;
        int c=0;
       do{
            System.out.println("-----Music Listening Menu-----");
            System.out.println("1. Song Name.");
            System.out.println("2. Song Stats.");
            System.out.println("3. Reset Stats.");
            System.out.println("4. Exit.");
            System.out.print("Enter your choice=");
            choice=sc.nextInt();
            switch (choice) 
             {
                case 1:
                    c++;
                    System.out.println("Song Played Successfully.");
                    break;

                case 2:
                    if (c==0)
                        System.out.println("No songs played yet.");
                    else
                        System.out.println("Song listened " + c + " times.");
                    break;

                case 3:
                    c=0;
                    System.out.println("Resetted.");
                    break;

                case 4:
                    System.out.println("Thank You!for using MADHUR MUSIC APP!");
                    break;

                default:
                    System.out.println("Invalid Choice Entered.");
            }  
        } while (choice != 4);
    }
}



