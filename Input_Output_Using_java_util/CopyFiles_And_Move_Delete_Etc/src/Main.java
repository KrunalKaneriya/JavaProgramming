import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) {


	    try {

//			Path sourceFile = FileSystems.getDefault().getPath("Example","File1.txt");
//			Path copyFile = FileSystems.getDefault().getPath("Example","File1.txt");
//			Files.copy(sourceFile,copyFile, StandardCopyOption.REPLACE_EXISTING);
//
//
//	    	sourceFile = FileSystems.getDefault().getPath("Example","Dir1");
//	    	copyFile = FileSystems.getDefault().getPath("Example","Dir4");
//	        Files.copy(sourceFile,copyFile, StandardCopyOption.REPLACE_EXISTING);

//			Path fileToMove = FileSystems.getDefault().getPath("Example","File1.txt");
//			Path fileToMoveDestination = FileSystems.getDefault().getPath("Example","Dir1","File1.txt");

//			Path fileToMove = FileSystems.getDefault().getPath("Example","File1.txt");
//			Path fileToMoveDestination = FileSystems.getDefault().getPath("Example","File1.txt");
//			Files.move(fileToMove,fileToMoveDestination);

//			Path fileToDelete = FileSystems.getDefault().getPath("Example","Dir1","File1_Copy.txt");
//			Files.delete(fileToDelete);

//			Path fileToCreate = FileSystems.getDefault().getPath("Example","File2.txt");
//			Files.createFile(fileToCreate);

//            Path fileToCreate = FileSystems.getDefault().getPath("Example","Dir4");
//            Files.createDirectory(fileToCreate);

//            Path dirToCreate = FileSystems.getDefault().getPath("Example","Dir2\\Dir3\\Dir4\\Dir5\\Dir6");
//            Path dirToCreate = FileSystems.getDefault().getPath("Example\\Dir2\\Dir3\\Dir4\\Dir5\\Dir6\\Dir7");
//            Files.createDirectories(dirToCreate);

            Path filePath = FileSystems.getDefault().getPath("Example\\Dir1\\File1.txt");
            long size = Files.size(filePath);
            System.out.println("The Size of File is " + size);
            System.out.println("Last Modified Date: " + Files.getLastModifiedTime(filePath));

            BasicFileAttributes attributes = Files.readAttributes(filePath,BasicFileAttributes.class);
            System.out.println("Size: " + attributes.size());
            System.out.println("Last Modified: " + attributes.lastAccessTime());
            System.out.println("Creation Time: " + attributes.creationTime());
            System.out.println("Is Directory: " + attributes.isDirectory());
            System.out.println("Is Regular File: " + attributes.isRegularFile());
        } catch (IOException e) {
	        e.printStackTrace();
        }
    }
}
