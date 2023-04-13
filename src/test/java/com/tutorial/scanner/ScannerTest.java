package com.tutorial.scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ScannerTest {

    /**
     * Scanner
     * ● Scanner adalah class mirip seperti PrintStream, namun khusus untuk membaca dari InputStream
     * ● Dengan menggunakan Scanner, kita bisa membaca dan melakukan konversi tipe data secara otomatis
     * ● Method dengan awalan next() digunakan untuk membaca data
     * ● Method dengan awalan has() digunakan untuk mengecek apakah masih ada data
     * ● https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Scanner.html
     *
     * Scanner Console
     * ● Scanner juga banyak digunakan untuk membaca input dari console
     * ● Dimana System.in merupakan tipe data InputStream, yang bisa kita gunakan sebagai input untuk Scanner
     */

    @Test
    void testScannerFile() {
        Path path = Path.of("print.txt"); // interface Path // static Path of(String first, String... more) // untuk mengakses file sejak java versi 7

        // InputStream try with resource. supaya close() otomatis
        // InputStream newInputStream(Path path, OpenOption... options) // Membuka file, mengembalikan aliran input untuk membaca dari file.
        // Scanner // hanya bisa Read Object InputSteram
        // Scanner(InputStream source) // scan data dari InputStream
        try (InputStream stream = Files.newInputStream(path);
             Scanner scanner = new Scanner(stream)) {

            // boolean hasNextLine() // membaca data sampai -1 // Mengembalikan nilai true jika ada baris lain di input pemindai ini.
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine(); // String nextLine() // Mengembalikan nilai true jika ada baris lain di input pemindai ini.
                System.out.println(line);
            }
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

}
