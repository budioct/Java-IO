package com.tutorial.openoption;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OpenOptionTest {

    /**
     * Open Option
     * ● Saat kita membuat IO Stream menggunakan class Files, terdapat parameter diakhirnya yaitu OpenOption
     * ● OpenOption merupakan opsi tambahan yang ingin kita lakukan pada proses IO Stream
     * ● OpenOption merupakan sebuah interface, implementasinya kita bisa menggunakan enum StandardOpenOption
     * ● https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/nio/file/OpenOption.html
     * ● https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/nio/file/StandardOpenOption.html
     */

    @Test
    void testAppendWithOpenOption(){
        Path path = Path.of("append.txt"); // interface Path // static Path of(String first, String... more) // untuk mengakses file sejak java versi 7
        // Writer try with resource. supaya close() otomatis
        // static BufferedWriter newBufferedWriter(Path path, OpenOption... options) // Membuka atau membuat file untuk ditulis, mengembalikan BufferedWriter yang dapat digunakan untuk menulis teks ke file dengan cara yang efisien.
        // StandardOpenOption.CREATE // Buat file baru jika belum ada.
        // StandardOpenOption.APPEND // Jika file dibuka untuk akses WRITE maka byte akan ditulis di akhir file, bukan di awal.
        try(Writer stream = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND)){
            stream.write("hello bro\n"); // void write(String str) // Menulis text dari larik string yang ditentukan ke aliran output ini.
            stream.flush(); // void flush() // eksekusi output dengan memaksa semua text yang di buffer untuk ditulis
        }catch (IOException e){
            Assertions.fail(e);
        }
    }


}
