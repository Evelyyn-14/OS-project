import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOperations {

    public static void createFile(String filename) {
        try {
            File file = new File(filename);
            if (file.createNewFile()) {
                System.out.println("File '" + filename + "' created successfully.");
            } else {
                System.out.println("File '" + filename + "' already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    public static void writeFile(String filename, String content) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(content);
            writer.close();
            System.out.println("Content written to file '" + filename + "'.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public static void readFile(String filename) {
        try {
            File file = new File(filename);
            Scanner reader = new Scanner(file);
            System.out.println("Content of file '" + filename + "':");
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    public static void deleteFile(String filename) {
        File file = new File(filename);
        if (file.delete()) {
            System.out.println("File '" + filename + "' deleted successfully.");
        } else {
            System.out.println("Failed to delete file '" + filename + "'.");
        }
    }

    public static void searchFile(String directory, String filename) {
        File dir = new File(directory);
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            boolean found = false;
            if (files != null) {
                for (File file : files) {
                    if (file.getName().equalsIgnoreCase(filename)) {
                        System.out.println("File found: " + file.getAbsolutePath());
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                System.out.println("File '" + filename + "' not found in directory '" + directory + "'.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }
    }

    public static void viewFileMetadata(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            System.out.println("Metadata for file '" + filename + "':");
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Size: " + file.length() + " bytes");
            System.out.println("Readable: " + file.canRead());
            System.out.println("Writable: " + file.canWrite());
            System.out.println("Last Modified: " + file.lastModified());
        } else {
            System.out.println("File '" + filename + "' does not exist.");
        }
    }
}
