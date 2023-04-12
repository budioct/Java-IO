package com.tutorial.printstream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class PrintStreamTest {

    /**
     * Print Stream
     * ● Salah satu turunan dari Output Stream yang sering kita gunakan secara tidak sadar adalah Print Stream
     * ● Print Stream adalah Output Stream yang bisa menerima berbagai jenis data, dan secara otomatis melakukan konversi ke numeric data yang dibutuhkan oleh Output Stream
     * ● Saat kita menggunakan System.out, itu sebenarnya adalah object dari Print Stream
     * ● https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/PrintStream.html
     */

    @Test
    void testPrintStream() {
        PrintStream stream = System.out; // final class System // final PrintStream out = null

        stream.println("hello world");
        stream.println("hello world");
        stream.println("hello world");
    }

    @Test
    void testPrintStreamFile() {
        Path path = Path.of("print.txt"); // interface Path // static Path of(String first, String... more) // untuk mengakses file sejak java versi 7
        // OutputStream try with resource. supaya close() otomatis
        // static OutputStream newOutputStream(Path path, OpenOption... options) // Membuka atau membuat file, mengembalikan aliran keluaran yang dapat digunakan untuk menulis byte ke file.
        // class PrintStream // Output Stream yang bisa menerima berbagai jenis data, otomatis konversi ke numeric
        try (OutputStream outputStream = Files.newOutputStream(path);
             PrintStream stream = new PrintStream(outputStream)) {
            stream.println("hello world");
            stream.println("hello world");
            stream.println("hello world");
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

}
