import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.Scanner;

public class DataSaver {
        public static void main(String[] args) {
            Scanner sca = new Scanner(System.in);
            ArrayList<String> recs = new ArrayList<>();

            String rec1 = "";
            int rec2 = 0;
            String rec3 = "";
            int rec4 = 0;

            boolean doneAdd = false;

            String prompt1 = "Enter name [first, last]";
            String prompt2 = "Enter id number";
            String prompt3 = "Enter email address";
            String prompt4 = "Enter birth year";


                rec1 = SafeInput.getNonZeroLenString(sca, prompt1);
                rec2 = SafeInput.getInt(sca, prompt2);
                rec3 = SafeInput.getNonZeroLenString(sca, prompt3);
                rec4 = SafeInput.getInt(sca, prompt4);



            File workingDirectory = new File (System.getProperty("user.dir"));
            Path file = Paths.get (workingDirectory.getPath() + "\\src\\data.txt");

            try {
                OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

                for (String rec : recs) {
                    writer.write(rec, 0, rec.length());
                    writer.newLine();
                }
                writer.close();
                System.out.println("Data file written");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            SafeInput.getNonZeroLenString(sca, prompt1);
        }
    }
