package com.tutorial.objectstream;

public class ObjectStreamTest {

    /**
     * Java Bean
     * ● Saat kita membuat program Java, kita sering membuat data dalam bentuk Java Bean (class dengan getter dan setter)
     * ● Pada kasus kita ingin menyimpan data object tersebut ke file, jika kita menggunakan Input/Output Stream,
     *   maka akan sangat menyulitkan, karena kita harus lakukan secara manual, dan melakukan konversi secara manual
     * ● Object Stream, fitur nya dimana kita bisa menyimpan/membaca data Java Object dari file
     *
     * Serializable (interface kosong), sebagai penanda
     * ● Salah satu syarat ketika ingin membuat Java Bean Class yang bisa disimpan kedalam file hasil objectnya, kita harus membuat Java Bean Class turunan dari interface Serializable
     * ● https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/Serializable.html
     * ● Setelah itu, kita harus memberi tahu versi dari class tersebut dengan menggunakan static attribute static final long serialVersionUID, dimana berisikan versi dari Java Class nya
     * ● Setiap kita melakukan perubahan di class nya, misal menambahkan attribute, menghapus attribute, maka kita harus mengubah versi nya, agar tidak terjadi masalah ketika melakukan Object Stream
     */

}
