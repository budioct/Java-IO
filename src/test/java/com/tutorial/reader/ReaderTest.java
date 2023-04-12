package com.tutorial.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReaderTest {

    /**
     * Reader
     * ● Reader adalah Input Stream untuk membaca resource berupa text
     * ● Dengan menggunakan Reader, kita bisa melakukan konversi otomatis dari numeric data menjadi character data
     * ● Untuk membaca data per character, kita bisa menggunakan method read()
     * ● Sedangkan untuk membaca langsung beberapa character, kita bisa gunakan method read(char[])
     * ● Cara penggunaannya mirip dengan InputStream
     * ● https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/Reader.html
     */


    // Reader Read
    @Test
    void testReader() {

        Path path = Path.of("output.txt"); // interface Path // static Path of(String first, String... more) // untuk mengakses file sejak java versi 7
        // OutputStream try with resource. supaya close() otomatis
        // static BufferedReader newBufferedReader(Path path) // Membuka file untuk dibaca, mengembalikan BufferedReader yang dapat digunakan untuk membaca teks dari file dengan cara yang efisien.
        try (Reader reader = Files.newBufferedReader(path)) {
            StringBuilder builder = new StringBuilder(); // StringBuilder // buffer
            int data;
            // (int read() return yang akan ditampung var data) != -1
            while ((data = reader.read()) != -1) {
                builder.append((char) data); // StringBuilder append(char c) // membaca setiap char dari file yang diakses interface Path
            }
            System.out.println(builder.toString());
        } catch (IOException e) {
            Assertions.fail(e);
        }

    }

    // Reader Read Chars (lebih cepat)
    @Test
    void testReaderChars() {
        Path path = Path.of("output.txt"); // interface Path // static Path of(String first, String... more) // untuk mengakses file sejak java versi 7
        // OutputStream try with resource. supaya close() otomatis
        // static BufferedReader newBufferedReader(Path path) // Membuka file untuk dibaca, mengembalikan BufferedReader yang dapat digunakan untuk membaca teks dari file dengan cara yang efisien.
        try (Reader reader = Files.newBufferedReader(path)) {
            StringBuilder builder = new StringBuilder(); // StringBuilder // sebagai buffer data
            char[] buffer = new char[1024]; // buffer
            int length;
            // (int read(byte b[]) return yang akan ditampung var length) != -1
            while ((length = reader.read(buffer)) != -1) {
                builder.append(buffer, 0, length); // StringBuilder append(String str) // String(byte[] bytes, int offset, int length) // / membaca setiap char dari file yang di akses
            }
            System.out.println(builder.toString());
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }


}
