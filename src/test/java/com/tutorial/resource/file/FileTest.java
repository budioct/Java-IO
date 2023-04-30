package com.tutorial.resource.file;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class FileTest {

    /**
     * File
     * ● File adalah cara lama mengakses file, walaupun sekarang direkomendasikan menggunakan Path, namun masih banyak yang menggunakan File
     * ● File direpresentasikan oleh class File
     * ● https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/File.html
     *
     * Absolute vs Relative Path Name
     * ● Saat kita membuat file, terdapat parameter pathname pada constructor nya
     * ● Kita bisa menggunakan Absolute atau Relative Path Name
     * ● Absolute artinya kita sebutkan file dari posisi awal folder, misal di Mac / Linux kita sebutkan misalnya : /Users/khannedy/folder/namafile.txt,
     *   atau di Windows kita sebutkan C:\home\khannedy\folder\namafile.txt
     * ● Relative artinya kita sebutkan file dari posisi kita menjalankan aplikasi. Misal jika folder project kita di /Users/khannedy/namaproject.
     *   Saat kita menggunakan path namafile.txt, artinya mengakses /Users/khanedy/namaproject/namafile.txt
     * ● Pada Relative, kita bisa gunakan .. untuk naik ke folder diatas nya, misal ../namafile.txt, artinya mengakses file /Users/khannedy/namafile.txt
     *
     */

    @Test
    void testCreateFile(){
        File file = new File("file.txt"); // class File adalah object untuk mengkases file

        Assertions.assertEquals("file.txt", file.getName()); // String getName() // mendapatkan nama file
        Assertions.assertFalse(file.exists()); // boolean exists() // cek apakah ada file dengan object tersebut
    }


}
