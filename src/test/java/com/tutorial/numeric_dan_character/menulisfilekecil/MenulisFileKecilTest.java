package com.tutorial.numeric_dan_character.menulisfilekecil;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MenulisFileKecilTest {

    /**
     * Menulis File Kecil
     * ● Pada kasus jika kita ingin menulis file dengan ukuran kecil, kita bisa menggunakan class Files
     * ● Terdapat banyak method yang bisa kita gunakan pada kasus sederhana untuk membuat file dengan ukuran kecil
     * ● Files.write(path, bytes) untuk menulis file dengan data bytes[]
     * ● Files.writeString(path, string) untuk menulis file dengan data String
     */

    @Test
    void testCreateWriteSmallFile() throws IOException {

        Path path1 = Path.of("small1.txt"); // interface Path // static Path of(String first, String... more) // untuk mengakses file sejak java versi 7
        byte[] bytes = "Hello World".getBytes(); // byte[] getBytes() // mengambil character dengan return byte[]
        Files.write(path1, bytes); // static Path write(Path path, byte[] bytes, OpenOption... options) // menulisa ke dalam isi file Path

        Path path2 = Path.of("small2.txt");
        Files.writeString(path2, "Hello World 2"); // static Path writeString(Path path, CharSequence csq, OpenOption... options) // // menulisa ke dalam isi file Path

    }


}
