package com.tutorial.manipulasi_directory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ManipulasiDirectoryTest {

    /**
     * Manipulasi Directory
     * ● Directory atau Folder juga bisa dimanipulasi menggunakan class Files
     * Manipulasi Directory
     * Method                           Keterangan
     * Files.createDirectories(path)    Membuat banyak directory jika tidak ada
     * Files.createDirectory(path)      Membuat satu directory
     * Files.newDirectoryStream(path)   Membaca semua isi file di directory
     * Files.isDirectory(path)          Mengecek apakah path sebuah directory
     */

    @Test
    void testCreateDirectoryManipulation() throws IOException {

        // Schema kita buat file lalu setelah itu kita langsung di hapus

        Path path = Path.of("contoh"); // interface Path // static Path of(String first, String... more) // untuk mengakses file sejak java versi 7
        Files.createDirectory(path); // static Path createDirectory(Path dir, FileAttribute<?>... attrs) // Membuat satu directory
        Assertions.assertTrue(Files.isDirectory(path));
        Assertions.assertTrue(Files.exists(path));

        Files.deleteIfExists(path); // static boolean deleteIfExists(Path path) // Menghapus directory jika ada
        Assertions.assertFalse(Files.exists(path));

    }


}
