import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class NewCopyFiles extends SimpleFileVisitor<Path> {
    private Path sourceRoot;
    private Path targetRoot;


    public NewCopyFiles(Path sourcePath, Path destinationRoot) {
        this.sourceRoot = sourcePath;
        this.targetRoot = destinationRoot;
    }


    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
//        Path relativizedPath = sourceRoot.relativize(dir);
//        System.out.println("The relativized Directory Path is " + relativizedPath.toAbsolutePath());
//        Path resolvedPath = destinationRoot.resolve(relativizedPath);
//        System.out.println("The Absoulte Path Of Directory is " + resolvedPath.toAbsolutePath());
//
//        try {
//            Files.copy(dir,resolvedPath, StandardCopyOption.REPLACE_EXISTING);
//        }
//        catch (IOException e) {
//            e.getMessage();
//            return FileVisitResult.SKIP_SUBTREE;
//        }
//        return FileVisitResult.CONTINUE;
//    }

        System.out.println("Now visiting" + dir);
        Path relativizedPath = sourceRoot.relativize(dir);
        System.out.println("The Relativized Directory Path is: " + relativizedPath.normalize() + " && " + relativizedPath.normalize().toAbsolutePath());
        Path copyDir = targetRoot.resolve(relativizedPath);
        System.out.println("The Resolved Directory Path is: " + copyDir);
        try {
            Files.copy(dir,copyDir, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.getMessage();
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//        Path relativizedPath = sourceRoot.relativize(file);
//        System.out.println("The Relativized Path For File is: " + relativizedPath.toAbsolutePath());
//        Path resolvedPath = destinationRoot.resolve(relativizedPath);
//        System.out.println("The Resolved Path For File is " + resolvedPath.toAbsolutePath());
//
//        try {
//            Files.copy(file,resolvedPath,StandardCopyOption.REPLACE_EXISTING);
//        }
//        catch (IOException e) {
//            e.getMessage();
//
//        }
//        return FileVisitResult.CONTINUE;
//    }

        Path relativizedPath = sourceRoot.relativize(file);
        System.out.println("The Relativized File Path is: " + relativizedPath);
        Path copyDir = targetRoot.resolve(relativizedPath);
        System.out.println("The Resolved File Path is: " + copyDir);
        try {
            Files.copy(file,copyDir,StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.getMessage();
        }
        return FileVisitResult.CONTINUE;
    }
}
