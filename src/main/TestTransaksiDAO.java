/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dao.TransaksiDAO;
import model.Transaksi;
import java.util.List;

public class TestTransaksiDAO {
    public static void main(String[] args) {
        TransaksiDAO dao = new TransaksiDAO();

        // ===== TEST 1: SELECT semua transaksi =====
        System.out.println("===== TEST SELECT SEMUA =====");
        List<Transaksi> list = dao.getAll();
        for (Transaksi t : list) {
            System.out.println("ID: " + t.getId()
                + " | Barang ID: " + t.getIdBarang()
                + " | Peminjam: " + t.getNamaPeminjam()
                + " | Tgl Pinjam: " + t.getTanggalPinjam()
                + " | Status: " + t.getStatus());
        }

        // ===== TEST 2: INSERT transaksi baru =====
        System.out.println("\n===== TEST INSERT =====");
        Transaksi baru = new Transaksi();
        baru.setIdBarang(4);
        baru.setNamaPeminjam("Andini");
        baru.setTanggalPinjam("2025-05-10");
        boolean insert = dao.insert(baru);
        System.out.println("Insert berhasil: " + insert);

        // ===== TEST 3: SELECT yang masih dipinjam =====
        System.out.println("\n===== TEST SELECT DIPINJAM =====");
        List<Transaksi> dipinjam = dao.getDipinjam();
        for (Transaksi t : dipinjam) {
            System.out.println("ID: " + t.getId()
                + " | Peminjam: " + t.getNamaPeminjam()
                + " | Status: " + t.getStatus());
        }

        // ===== TEST 4: UPDATE — kembalikan barang =====
        System.out.println("\n===== TEST KEMBALIKAN BARANG =====");
        boolean kembali = dao.kembalikan(3, "2025-05-10");
        System.out.println("Kembalikan berhasil: " + kembali);

        // ===== TEST 5: CEK setelah dikembalikan =====
        System.out.println("\n===== CEK SETELAH DIKEMBALIKAN =====");
        list = dao.getAll();
        for (Transaksi t : list) {
            System.out.println("ID: " + t.getId()
                + " | Peminjam: " + t.getNamaPeminjam()
                + " | Status: " + t.getStatus());
        }

        // ===== TEST 6: DELETE =====
        System.out.println("\n===== TEST DELETE =====");
        boolean del = dao.delete(1);
        System.out.println("Delete berhasil: " + del);

        System.out.println("\n===== SEMUA TEST TRANSAKSI SELESAI =====");
    }
}