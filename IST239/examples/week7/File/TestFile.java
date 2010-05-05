import java.io.File;

public class TestFile {

    public static void main(String[] sa) {
        File file = new File("myFile.txt");
        System.out.println("Does it exist? " + file.exists());
        System.out.println("The file has " + file.length() + " bytes");
        System.out.println("Can it be read? " + file.exists());
        System.out.println("Can you write to it? " + file.canWrite());
        System.out.println("Is it a directory? " + file.isDirectory());
        System.out.println("Is it a file? " + file.isFile());
        System.out.println("Is it absolute? " + file.isAbsolute());
        System.out.println("Is it hidden? " + file.isHidden());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Last modified on: " + new
                java.util.Date(file.lastModified()));
    }
}
