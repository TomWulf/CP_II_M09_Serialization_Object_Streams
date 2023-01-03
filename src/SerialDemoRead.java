import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SerialDemoRead
{
    public static void main(String[] args)
    {

        /*
            private String IDNum;
            private String firstName;
            private String lastName;
            private int YOB;
         */

        // Create the Person Object data for the demo

        ArrayList<Person> folks; // = new ArrayList<>();

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path path = Paths.get(workingDirectory.getPath() + "\\src\\PersonData.bin");

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path.toFile())))
        {
            folks = (ArrayList<Person>) in.readObject();
            for (Person p:folks)
            {
                System.out.println(p);
            }
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }



    }

}
