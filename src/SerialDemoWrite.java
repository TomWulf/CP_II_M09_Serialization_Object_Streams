import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SerialDemoWrite
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

        ArrayList<Person> folks = new ArrayList<>();

        Person sally = new Person("00000001","Sally", "Williams", 2005);
        System.out.println(sally);
        folks.add(sally);

        Person fred = new Person("00000002","Fred", "Williams", 2010);
        System.out.println(fred);
        folks.add(fred);

        Person homer = new Person("00000003","Homer", "Simpson", 1975);
        System.out.println(homer);
        folks.add(homer);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path path = Paths.get(workingDirectory.getPath() + "\\src\\PersonData.bin");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path.toFile())))
        {
            out.writeObject(folks);
        }
        catch (IOException e)
        {
           e.printStackTrace();
        }


    }
}