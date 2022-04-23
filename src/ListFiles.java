import java.io.File;


public class ListFiles {
    private String directory;
    private String extension;
    private File[] files;

    public ListFiles(String directory, String extension){
        this.directory = directory;
        this.extension = extension;
    }

    public File[] getFiles() {
        // Create a file object
        File file = new File(directory);

        // Get all the names of the files present in the given directory that has the given extension
        this.files = file.listFiles((dir, filename) -> filename.toLowerCase().endsWith(extension));
        return files;
    }

    public void displayFiles(){
        try {
            System.out.println("The following tests are available:");

            // Display the names of the files
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

    public static String removeFileExtension(String filename, boolean removeAllExtensions) {
        if (filename == null || filename.isEmpty()) {
            return filename;
        }

        String extPattern = "(?<!^)[.]" + (removeAllExtensions ? ".*" : "[^.]*$");
        return filename.replaceAll(extPattern, "");
    }
}
