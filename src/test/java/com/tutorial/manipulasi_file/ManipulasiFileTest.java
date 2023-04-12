package com.tutorial.manipulasi_file;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ManipulasiFileTest {

    /**
     * Manipulasi File
     * ● Seperti yang dijelaskan di awal, membuat File atau Path bukan berarti file otomatis terbuat, itu hanya object di Java, bukan representasi nyata di File System
     * ● Namun dengan menggunakan class Files, --> kita bisa melakukan manipulasi file seperti membuat, menghapus atau membacanya
     * Manipulasi File
     * Method                       Keterangan
     * Files.createFile(path)       Membuat file
     * Files.delete(path) /
     * Files.deleteIfExists(path)   Menghapus file / jika ada
     * Files.copy(source, target)   Menyalin file
     * Files.move(source, target)   Memindahkan file
     *
     */

    @Test
    void testCreatefileManipulation() throws IOException {

        // Schema kita buat file lalu setelah itu kita langsung di hapus

        Path path = Path.of("files.txt"); // interface Path // static Path of(String first, String... more) // untuk mengakses file sejak java versi 7
        Files.createFile(path); // static Path createFile(Path path, FileAttribute<?>... attrs) // Membuat file
        Assertions.assertTrue(Files.exists(path)); // class Files // object yang bisa digunakan oleh interface Path supaya bisa di manfaatkan oleh Path dengan versi terbaru

        Files.deleteIfExists(path); // static boolean deleteIfExists(Path path) // Menghapus file jika ada
        Assertions.assertFalse(Files.exists(path));



    }




}
