import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
//        Path directory = FileSystems.getDefault().getPath("FileTree");
//        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
//            @Override
//            public boolean accept(Path entry) throws IOException {
//                return Files.isRegularFile(entry);
//            }
//        };
//
////        DirectoryStream.Filter<Path>filter = p -> Files.isRegularFile(p);
//
//        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {
//            for (Path file : contents) {
//                System.out.println(file.getFileName());
//            }
//        } catch (IOException | DirectoryIteratorException e) {
//            e.getMessage();
//        }
//
//        String separator = File.separator;
//        System.out.println(separator);
//        separator = FileSystems.getDefault().getSeparator();
//        System.out.println(separator);
//        Path tempPath = FileSystems.getDefault().getPath("D:\\Downloads");
//
//
//        try {
//            Path tempFile = Files.createTempFile(tempPath, "myapp", ".appext");
//            System.out.println("Temporary File Path: " + tempFile.toAbsolutePath());
//        } catch (IOException e) {
//            e.getMessage();
//        }
//
//        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
//        for (FileStore store : stores) {
//            System.out.println("Disk name And Disk Letter: " + store);
//            System.out.println("Disk name: " + store.name());
//        }
//
//        System.out.println("*********************************************************");
//        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
//        for (Path path : rootPaths) {
//            System.out.println(path);
//        }
//
//
//        System.out.println("----Walking The File Tree----");
//        Path dir2Path = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
//
//        try {
//            Files.walkFileTree(dir2Path,new PrintNames());
//        } catch (IOException e) {
//            e.getMessage();
//        }
//
//        System.out.println("---Copy Dir2 to Dir4/Dir2Copy---");
////        Path dir2Path = FileSystems.getDefault().getPath("FileTree"+File.separator+"Dir2");
//        Path copyPath = FileSystems.getDefault().getPath("FileTree");
//        //FileTree\Dir4\Dir2Copy
//
//        try {
//            Files.walkFileTree(dir2Path,new CopyFiles(dir2Path,copyPath));
//        } catch (IOException e) {
//            e.getMessage();
//        }

        Path sourceRoot = FileSystems.getDefault().getPath("FileTree"+ File.separator + "Dir2"+ File.separator + "Dir3");
        Path targetRoot = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir3");

        try {
            Files.walkFileTree(sourceRoot,new NewCopyFiles(sourceRoot,targetRoot));
        } catch (IOException e ){
            e.getMessage();
        }
    }

}


