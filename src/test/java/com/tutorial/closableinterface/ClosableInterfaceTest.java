package com.tutorial.closableinterface;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ClosableInterfaceTest {

    /**
     * Closable Interface
     * ● Semua IO Stream di Java adalah turunan dari interface java.io.Closable, dimana terdapat method close() untuk menutup Resource yang sudah dibuka.
     * ● Hal ini agar tidak terjadi memory leak (kondisi dimana kita lupa menutup IO Stream sehingga data tidak bisa dihapus di memory oleh Java Garbage Collector)
     */

    @Test
    void testCloseIO() {
        Path path = Path.of("pom.xml"); // interface Path // static Path of(String first, String... more) // untuk mengakses file sejak java versi 7
        Path files = Path.of("files.txt"); // interface Path // static Path of(String first, String... more) // untuk mengakses file sejak java versi 7
        InputStream inputStream = null; // abstract class InputStream // untuk membaca data dari submer file
        try {
            inputStream = Files.newInputStream(path); // static InputStream newInputStream(Path path, OpenOption... options) // membaca file dari Path
            // lakukan apapun dengan input stream
            Files.createFile(files); // static Path createFile(Path path, FileAttribute<?>... attrs) // Membuat file
            Assertions.assertTrue(Files.exists(files)); // class Files // object yang bisa digunakan oleh interface Path supaya bisa di manfaatkan oleh Path dengan versi terbaru

            Files.deleteIfExists(files); // static boolean deleteIfExists(Path path) // Menghapus file jika ada
            Assertions.assertFalse(Files.exists(files));

        }catch (IOException exception){
            Assertions.fail(exception);
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close(); // void close() // menutup IO supaya tidak memory leak
                } catch (IOException e) {
                    Assertions.fail(e);
                }
            }
        }
    }

    /**
     * Try with Resource
     * ● Seperti yang sudah dibahas di materi Java OOP, Try di Java memiliki fitur yang bisa digunakan untuk menutup Resource Closable secara otomatis
     * ● Dengan begitu, kita tidak perlu lagi melakukan close() IO Resource secara manual lagi seperti pada kode sebelumnya
     */

    @Test
    void closeIOWithTryResource() {
        Path path = Path.of("pom.xml");
        try(InputStream inputStream = Files.newInputStream(path);
            InputStream inputStream2 = Files.newInputStream(path);
            InputStream inputStream3 = Files.newInputStream(path)) {
            // lakukan apapun dengan input stream
        }catch (IOException exception){
            Assertions.fail(exception);
        }
    }


}
