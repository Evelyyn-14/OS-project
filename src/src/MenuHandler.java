import java.util.Scanner;

public class MenuHandler {
    private String filename = null;
    private String directory = null;
    private Scanner scanner;

    public MenuHandler(){
        scanner = new Scanner(System.in);
    }

    public void displayMenu(){
        boolean exit = false;

        while(!exit){
            System.out.println("\nWelcome to the File Operations Menu");
            System.out.println("1. Set the working directory");
            System.out.println("2. Create a new File");
            System.out.println("3. Write to a file");
            System.out.println("4. Read a file");
            System.out.println("5. Search for a file");
            System.out.println("6. View file metadata");
            System.out.println("7. Delete a file");
            System.out.println("8. Exit");
            System.out.println("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1:
                    setDirectory();
                    break;
                case 2:
                    createFile();
                    break;
                case 3:
                    writeFile();
                    break;
                case 4:
                    readFile();
                    break;
                case 5:
                    searchFile();
                    break;
                case 6:
                    viewMetadata();
                    break;
                case 7:
                    deleteFile();
                    break;
                case 8:
                    exit = true;
                    System.out.println("Exiting Program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
    private void setDirectory(){
        System.out.print("Enter the working directory: ");
        directory = scanner.nextLine();
        if(directory == null || directory.isEmpty()){
            System.out.println("Invalid directory. Using default directory (current directory '.').");
            directory = ".";
        } else {
            System.out.println("Working directory set to: " + directory);
        }
    }

    private void createFile(){
        System.out.println("Enter the name of the file to create: ");
        filename = scanner.nextLine();
        FileOperations.createFile(filename);
        System.out.println("File created successfully.");
    }

    private void writeFile(){
        if(filename == null){
            System.out.println("No file selected. Create a new file first or specify a file.");
            System.out.println("Enter the filename");
            filename = scanner.nextLine();
        }
        System.out.println("Enter the content to write to the file: ");
        String content = scanner.nextLine();
        FileOperations.writeFile(filename, content);
        System.out.println("Content written to the file.");
    }

    private void readFile(){
        System.out.println("Enter the name of the file to read: ");
        String fileToRead = scanner.nextLine();
        while (fileToRead == null || fileToRead.isEmpty()){
            System.out.println("Invalid filename. Please enter a valid filename.");
            System.out.println("Enter the name of the file of the file to read: ");
            fileToRead = scanner.nextLine();
        }
        System.out.println("Reading file...");
        FileOperations.readFile(fileToRead);
    }

    private void searchFile(){
        System.out.println("Enter the directory to search in: ");
        String directory = scanner.nextLine();
        System.out.println("Enter the name of the file to search for: ");
        String fileToSearch = scanner.nextLine();

        if(directory.isEmpty()||fileToSearch.isEmpty()){
            System.out.println("Invalid input. Both directory and file name are required.");
            return;
        }
        System.out.println("Searching for the file...");
        FileOperations.searchFile(directory,fileToSearch);
    }

    private void viewMetadata(){
        System.out.println("Enter the name of the file to view metadata for:");
        String fileToView = scanner.nextLine();
        while(fileToView == null||fileToView.isEmpty()){
        System.out.println("Invalid filename. Please enter a valid file name.");
        System.out.print("Enter the name of the fie to view metadata for: ");
        fileToView = scanner.nextLine();
        }
        System.out.println("Viewing file metadata...");
        FileOperations.viewFileMetadata(fileToView);
    }

    private void deleteFile(){
        System.out.print("Enter the name of the file to delete: ");
        String fileToDelete = scanner.nextLine();
        if (fileToDelete == null || fileToDelete.isEmpty()){
            System.out.println("Invalid filename. Please enter a valid file name.");
            return;
        }
        System.out.print("Are you sure you want to delete this file? (Y/N): ");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("Y")){
            FileOperations.deleteFile(fileToDelete);
            System.out.println("File successfully deleted.");
        } else {
            System.out.println("File not deleted.");
        }
    }
}