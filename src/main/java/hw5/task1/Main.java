package hw5.task1;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Files.newDirectoryStream;

/*
Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий) во вновь созданную папку ./backup
 */
public class Main {
    public static void main(String[] args) {
        try {
            Files.createDirectory(Path.of("./backup"));
            DirectoryStream<Path> directoryStream = newDirectoryStream(Path.of("."));
            for (Path file : directoryStream) {
                if (Files.isDirectory(file)) {
                    continue;
                }
                Files.copy(file, Path.of("./backup/" + file.toString()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
