import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOperations {

    public static void createFile(String filename){
        try{
            File file = new File(filename);
            if(file.createNewFile()){
                System.out.println("File " + filename + "created");
            } else {
                System.out.println("File " + filename + " already exists");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while creating the file: " + filename);
            e.printStackTrace();
        }
    }
}