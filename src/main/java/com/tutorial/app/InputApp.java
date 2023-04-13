package com.tutorial.app;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class InputApp {

    /**
     * Scanner Console
     * ● Scanner juga banyak digunakan untuk membaca input dari console
     * ● Dimana System.in merupakan tipe data InputStream, yang bisa kita gunakan sebagai input untuk Scanne
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = null;
        int length = 10;
        for (int i = 0; i < length; i++) {
            System.out.print("Masukan nama: ");
            name = scanner.nextLine();
            outputStream(name, length);
        }
        inputStream(name);
    }


    static void inputStream(String param) {
        Path path = Path.of("data.txt");

        try (InputStream stream = Files.newInputStream(path)) {
            StringBuilder builder = new StringBuilder();
            byte[] buffer = new byte[1024];
            int length;

            while ((length = stream.read(buffer)) != -1) {
                builder.append(new String(buffer, 0, length));
            }
            System.out.println(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void outputStream(String param, Integer loop) {
        Path path = Path.of("data.txt"); // interface Path // static Path of(String first, String... more) // untuk mengakses file sejak java versi 7
        // OutputStream try with resource. supaya close() otomatis
        // static OutputStream newOutputStream(Path path, OpenOption... options) // Membuka atau membuat file, mengembalikan aliran keluaran yang dapat digunakan untuk menulis byte ke file.
        try (OutputStream stream = Files.newOutputStream(path)) {
            for (int i = 0; i < loop; i++) {
                stream.write(("Hallo bro: " + param + "\n").getBytes()); // void write(byte b[]) // Menulis byte b.length dari larik byte yang ditentukan ke aliran output ini.
                stream.flush(); // void flush() // eksekusi output dengan memaksa semua byte yang di buffer untuk ditulis
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
