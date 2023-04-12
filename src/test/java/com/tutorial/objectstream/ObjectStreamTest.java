package com.tutorial.objectstream;

import com.tutorial.data.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

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
     *
     * Object Stream (otomatis konversi dari numeric ke object data Java Bean)
     * ● Untuk menyimpan data object, kita bisa menggunakan ObjectInputStream (membaca data)
     * ● https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/ObjectInputStream.html
     *
     * ● Dan untuk mengambil data object, kita bisa menggunakan ObjectOutputStream (menulis data)
     * ● https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/ObjectOutputStream.html
     *
     * Java Collection
     * ● Hampir semua class Java Collection seperti List, Set, Map merupakan turunan dari Serializable
     * ● Artinya kita bisa menyimpan data collection tersebut di file menggunakan Object Stream
     * ● Dengan syarat isi data nya adalah data Serializable juga
     */

    // object output stream
    @Test
    void testSavePerson() {
        Person person = new Person();
        person.setId("1");
        person.setName("budhi");

        // nama file akan menyimpan hasil setter object
        // hasil dari ObjectStream adalah binary.. jadi tidak akan bisa di buka oleh text editor
        Path path = Path.of("budhi.person"); // interface Path // static Path of(String first, String... more) // untuk mengakses file sejak java versi 7

        // OutputStream try with resource. supaya close() otomatis
        // static OutputStream newOutputStream(Path path, OpenOption... options) // Membuka atau membuat file, mengembalikan aliran keluaran yang dapat digunakan untuk menulis byte ke file.
        try (OutputStream stream = Files.newOutputStream(path)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream); // class ObjectOutputStream // object helper outputstream supaya bisa di konversi otomatis dari number ke object
            objectOutputStream.writeObject(person); // void writeObject(Object obj) // Tulis objek yang ditentukan ke ObjectOutputStream.
            objectOutputStream.flush(); // // void flush() // eksekusi output dengan memaksa semua text yang di buffer untuk ditulis
        } catch (IOException e) {
            Assertions.fail(e);
        }

    }

    // object input stream
    @Test
    void getPerson() {
        Path path = Path.of("budhi.person"); // interface Path // static Path of(String first, String... more) // untuk mengakses file sejak java versi 7

        // InputStream try with resource. supaya close() otomatis
        // InputStream newInputStream(Path path, OpenOption... options) // Membuka file, mengembalikan aliran input untuk membaca dari file.
        try (InputStream stream = Files.newInputStream(path)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(stream); // class ObjectInputStream // object helper outputstream supaya bisa di konversi otomatis dari number ke object
            Person person = (Person) objectInputStream.readObject(); // Membaca objek dari ObjectInputStream.

            // cek
            Assertions.assertNotNull(person);
            Assertions.assertEquals("1", person.getId());
            Assertions.assertEquals("budhi", person.getName());
        } catch (IOException e) {
            Assertions.fail(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        /**
         * Note: jika ada perubahan pada object dan versi dari naik.. seperti: public static final long serialVersionUID = 2L;
         * akan Error -> Caused by: java.io.InvalidClassException: com.tutorial.data.Person; local class incompatible: stream classdesc serialVersionUID = 1, local class serialVersionUID = 2
         * karena object yang mau di baca adalah versi 1, maka tiak boleh kita berbeda versi dengan file Path binary nya.. kita harus sesuaikan dengan versi file path binary nyaa!!!
         */

    }

}
