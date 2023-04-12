package com.tutorial.writer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterTest {

    /**
     * Writer
     * ● Writer merupakan base Interface yang digunakan untuk menulis ke Resource untuk data text
     * ● https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/Writer.html
     *
     * Menulis Data
     * ● Untuk menulis data di Writer, kita bisa gunakan method dengan awalan write()
     * ● Kita bisa mengirim data dalam bentuk char int, char[] atau String pada method write()
     */

    @Test
    void testWriter(){
        Path path = Path.of("writer.txt"); // interface Path // static Path of(String first, String... more) // untuk mengakses file sejak java versi 7
        // Writer try with resource. supaya close() otomatis
        // static BufferedWriter newBufferedWriter(Path path, OpenOption... options) // Membuka atau membuat file untuk ditulis, mengembalikan BufferedWriter yang dapat digunakan untuk menulis teks ke file dengan cara yang efisien.
        try(Writer stream = Files.newBufferedWriter(path)){
            for (int i = 0; i < 100; i++){
                stream.write("hello World\n"); // void write(String str) // Menulis text dari larik string yang ditentukan ke aliran output ini.
                stream.flush(); // void flush() // eksekusi output dengan memaksa semua text yang di buffer untuk ditulis
            }
        }catch (IOException e){
            Assertions.fail(e);
        }
    }

}
