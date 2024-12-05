public class Main {
    public static void main(String[] args) {
        String filename = "example.txt";
        String directory = ".";

        FileOperations.createFile(filename);
        FileOperations.writeFile(filename, "Hello, this is a test file!");
        FileOperations.readFile(filename);
        FileOperations.searchFile(directory, filename);
        FileOperations.viewFileMetadata(filename);
        FileOperations.deleteFile(filename);
        FileOperations.searchFile(directory,filename);
    }
}
