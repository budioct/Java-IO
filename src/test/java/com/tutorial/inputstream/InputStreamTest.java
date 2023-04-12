package com.tutorial.inputstream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class InputStreamTest {

    /**
     * Input Stream (membaca resource)
     * ● InputStream merupakan base Interface yang digunakan untuk membaca Resource
     * ● InputStream menggunakan numeric data, sehingga jika kita ingin membaca data text, kita harus konversi menjadi data numeric terlebih dahulu
     * ● Sangat disarankan menggunakan InputStream pada kasus data yang non Text, seperti gambar, video, dan lain-lain
     * ● Jika data Text, lebih disarankan menggunakan Reader karena bisa langsung menggunakan tipe data Character
     * ● https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/InputStream.html
     * <p>
     * Membaca Data
     * ● Untuk membaca data di InputStream, kita bisa gunakan method dengan awalan read()
     * ● Pada kasus data sedikit, kita bisa membaca dengan menggunakan method read(), namun pada kasus data yang banyak, agar lebih cepat, kita bisa
     * menggunakan method read(bytes) agar bisa membaca data sekaligus sebanyak panjang array bytes
     * <p>
     * ● *Jangan* gunakan readAllBytes() pada kasus data besar, karena akan disimpan seluruh datanya di memory
     * ● Method read() akan mengembalikan -1 jika sudah tidak ada data yang bisa dibaca lagi
     */

    // Pada kasus data sedikit, kita bisa membaca dengan menggunakan method read()
    @Test
    void testInputStreamRead() {
        Path path = Path.of("pom.xml");// interface Path // static Path of(String first, String... more) // untuk mengakses file sejak java versi 7

        // InputStream try with resource. supaya close() otomatis
        // InputStream newInputStream(Path path, OpenOption... options) // Membuka file, mengembalikan aliran input untuk membaca dari file.
        try (InputStream stream = Files.newInputStream(path)) {
            StringBuilder builder = new StringBuilder(); // StringBuilder // sebagai buffer data
            int data;
            // (int read() return yang akan ditampung var data) != -1
            while ((data = stream.read()) != -1) {
                builder.append((char) data); // StringBuilder append(char c) // membaca setiap char dari file yang diakses interface Path
            }
            System.out.println(builder.toString()); // print
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }



    // data yang banyak, agar lebih cepat, kita bisa menggunakan method read(bytes) agar bisa membaca data sekaligus sebanyak panjang array bytes
    @Test
    void testInputStreamReadByte() {
        Path path = Path.of("pom.xml");// interface Path // static Path of(String first, String... more) // untuk mengakses file sejak java versi 7

        // InputStream try with resource. supaya close() otomatis
        // InputStream newInputStream(Path path, OpenOption... options) // Membuka file, mengembalikan aliran input untuk membaca dari file.
        try (InputStream stream = Files.newInputStream(path)) {
            StringBuilder builder = new StringBuilder(); // StringBuilder // sebagai buffer data
            byte[] buffer = new byte[1024]; // buffer
            int length;
            // (int read(byte b[]) return yang akan ditampung var length) != -1
            while ((length = stream.read(buffer)) != -1) {
                builder.append(new String(buffer, 0, length)); // StringBuilder append(String str) // String(byte[] bytes, int offset, int length) // / membaca setiap char dari file yang di akses
            }
            System.out.println(builder.toString()); // print
        } catch (IOException e) {
            Assertions.fail(e);
        }

    }

}
