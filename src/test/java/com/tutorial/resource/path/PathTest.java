package com.tutorial.resource.path;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

public class PathTest {

    /**
     *  Path
     * ● Sejak Java 7, dikenalkan class Path yang bisa digunakan untuk mengakses resource sebagai pengganti class File
     * ● Path adalah sebuah interface, untuk membuat Path, kita bisa gunakan static method Path.of(pathname)
     * ● Path terdapat di package java.nio.file
     * ● https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/nio/file/Path.html
     *
     * Files
     * ● Path tidak memiliki banyak sekali method seperti di class File
     * ● Namun terdapat class Files yang bisa digunakan untuk mendapatkan informasi dari Path
     * ● https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/nio/file/Files.html
     *
     */

    @Test
    void testCreatePath(){
        Path path = Path.of("files.txt"); // interface Path // static Path of(String first, String... more) // untuk mengakses file sejak java versi 7

        Assertions.assertEquals("files.txt", path.toString()); // String toString() // get representasi Path
        Assertions.assertFalse(path.isAbsolute()); // boolean isAbsolute() // cek apakah ada file sesuai dengan Path
    }

    @Test
    void testCreateUsingFilesAsPath(){

        Path path = Path.of("pom.xml"); // interface Path // static Path of(String first, String... more) // untuk mengakses file sejak java versi 7

        Assertions.assertEquals("pom.xml", path.toString());
        Assertions.assertFalse(path.isAbsolute()); // boolean isAbsolute() // cek apakah ada file sesuai dengan Path
        Assertions.assertTrue(Files.exists(path)); // class Files // object yang bisa digunakan oleh interface Path supaya bisa di manfaatkan oleh Path dengan versi terbaru

    }



}
