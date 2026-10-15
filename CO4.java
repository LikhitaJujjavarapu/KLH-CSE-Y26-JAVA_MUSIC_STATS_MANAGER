class Song 
{
     String name;
    Song(String n)
     {
       this.name = n;
    }

    void display() 
    {
        System.out.println(name);
    }
}

public class CO4
{
    public static void main(String[] args)
     {
        try 
        {
            Song s1 = new Song("Perfect");
            Song s2 = new Song("Believer");

            System.out.println("My Playlist:");
            s1.display();
            s2.display();

           // int a = 10 / 0;

        }
         catch (Exception e)
         {
            System.out.println("An error occurred!");
        }
    }
}