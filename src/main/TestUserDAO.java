/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dao.UserDAO;
import model.User;
import java.util.List;

public class TestUserDAO {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();

        // ===== TEST SELECT =====
        System.out.println("===== TEST SELECT =====");
        List<User> list = dao.getAll();
        for (User u : list) {
            System.out.println("ID: " + u.getId()
                + " | Username: " + u.getUsername()
                + " | Role: " + u.getRole());
        }

        // ===== TEST LOGIN BERHASIL =====
        System.out.println("\n===== TEST LOGIN BERHASIL =====");
        User login = dao.login("admin", "admin123");
        if (login != null) {
            System.out.println("Login berhasil! Role: " + login.getRole());
        } else {
            System.out.println("Login gagal!");
        }

        // ===== TEST LOGIN GAGAL =====
        System.out.println("\n===== TEST LOGIN GAGAL =====");
        User loginGagal = dao.login("admin", "salah123");
        if (loginGagal != null) {
            System.out.println("Login berhasil!");
        } else {
            System.out.println("Login gagal! Username/password salah.");
        }

        // ===== TEST INSERT =====
System.out.println("\n===== TEST INSERT =====");
User baru = new User(0, "petugas_baru", "pass123", "petugas");  // ganti username
System.out.println("Insert berhasil: " + dao.insert(baru));

// ===== TEST UPDATE =====
System.out.println("\n===== TEST UPDATE =====");
User update = new User(2, "petugas1", "passwordbaru", "petugas");  // pakai ID 2
System.out.println("Update berhasil: " + dao.update(update));

// ===== TEST DELETE =====
System.out.println("\n===== TEST DELETE =====");
System.out.println("Delete berhasil: " + dao.delete(2));  // hapus ID 2
    }
}
