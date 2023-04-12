package com.tutorial.numeric_dan_character.membacafilekecil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MembacaFileKecilTest {

    /**
     * Membaca File Kecil
     * ● Pada kasus jika kita ingin membaca file dengan ukuran kecil, kita bisa menggunakan class Files
     * ● Terdapat banyak method yang bisa kita gunakan pada kasus sederhana untuk membaca file dengan ukuran kecil
     *
     *   Note: Jangan membaca file ukuran besar dengan cara ini, karena akan menjadikan seluruh data di simpan di memory, yang bisa menyebabkan error OutOfMemory
     *
     * ● Files.readAllBytes(path) untuk membaca file menjadi data bytes[]
     * ● Files.readString(path) untuk membaca file menjadi data String
     */

    @Test
    void testCreateReadSmallFile() throws IOException {

        Path path1 = Path.of("small1.txt"); // interface Path // static Path of(String first, String... more) // untuk mengakses file sejak java versi 7
        byte[] bytes = Files.readAllBytes(path1); // static byte[] readAllBytes(Path path) //  membaca file menjadi data bytes[]
        String content1 = new String(bytes); // String(byte[] bytes) // conversi dari byte[] array ke String
        Assertions.assertEquals("Hello World", content1); // cek apakah ekpetasi sama dengan isi file

        Path path2 = Path.of("small2.txt");
        String content2 = Files.readString(path2); // static String readString(Path path) // conversi dari interface Path ke String
        Assertions.assertEquals("Hello World 2", content2);

    }

}
