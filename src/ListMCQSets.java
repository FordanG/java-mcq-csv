import java.io.File;


public class ListMCQSets {
/*
*   @param directory the file folder giving the base location of the MCQ Sets/Questionnaires
*   @param extension the file extension you want to extract from the folder of MCQ Sets/Questionnaires
*   @param files this stores all the files gathered from the directory inside an array -
*/
    private String directory;
    private String extension;
    private File[] files;

//    Constructor for listing MCQ Sets from the folder
    public ListMCQSets(String directory, String extension){
        this.directory = directory;
        this.extension = extension;
    }

//    This returns the array of files in the directory specified and filters the files accordingly with the extension set
    public File[] getMCQSets() {
        // Create a file object
        File file = new File(directory);

        // Get all the names of the files present in the given directory that has the given extension
        this.files = file.listFiles((dir, filename) -> filename.toLowerCase().endsWith(extension));
        return files;
    }

//    Displays the MCQ Set Menu for the users
    public void displayMenu(){
        try {
            System.out.println("The following tests are available:");

            // Display the names of the files without their extensions
            for (int i = 0; i < files.length; i++) {
                System.out.print("\t" + (i+1) + " - ");
                System.out.println(removeFileExtension(files[i].getName(),true));
            }
            Styles.printDivider();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

//    removes the file extension from the names in the files
    public static String removeFileExtension(String filename, boolean removeAllExtensions) {
        if (filename == null || filename.isEmpty()) {
            return filename;
        }
        String extPattern = "(?<!^)[.]" + (removeAllExtensions ? ".*" : "[^.]*$");
        return filename.replaceAll(extPattern, "");
    }
}
