/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.KoneksiDB;
import model.Transaksi;
import java.sql.*;
import java.util.*;

public class TransaksiDAO {

    private Connection conn;

    public TransaksiDAO() {
        this.conn = KoneksiDB.getConnection();
    }

    // ===== CREATE — Tambah transaksi peminjaman baru =====
    public boolean insert(Transaksi t) {
        String sql = "INSERT INTO transaksi (id_barang, nama_peminjam, tanggal_pinjam, status) "
                   + "VALUES (?, ?, ?, 'dipinjam')";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, t.getIdBarang());
            ps.setString(2, t.getNamaPeminjam());
            ps.setString(3, t.getTanggalPinjam());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ===== READ — Ambil semua transaksi =====
    public List<Transaksi> getAll() {
        List<Transaksi> list = new ArrayList<>();
        String sql = "SELECT * FROM transaksi ORDER BY id ASC";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Transaksi t = new Transaksi();
                t.setId(rs.getInt("id"));
                t.setIdBarang(rs.getInt("id_barang"));
                t.setNamaPeminjam(rs.getString("nama_peminjam"));
                t.setTanggalPinjam(rs.getString("tanggal_pinjam"));
                t.setTanggalKembali(rs.getString("tanggal_kembali"));
                t.setStatus(rs.getString("status"));
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // ===== READ — Ambil transaksi yang masih dipinjam =====
    public List<Transaksi> getDipinjam() {
        List<Transaksi> list = new ArrayList<>();
        String sql = "SELECT * FROM transaksi WHERE status = 'dipinjam'";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Transaksi t = new Transaksi();
                t.setId(rs.getInt("id"));
                t.setIdBarang(rs.getInt("id_barang"));
                t.setNamaPeminjam(rs.getString("nama_peminjam"));
                t.setTanggalPinjam(rs.getString("tanggal_pinjam"));
                t.setTanggalKembali(rs.getString("tanggal_kembali"));
                t.setStatus(rs.getString("status"));
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // ===== UPDATE — Tandai barang sudah dikembalikan =====
    public boolean kembalikan(int id, String tanggalKembali) {
        String sql = "UPDATE transaksi SET status='dikembalikan', tanggal_kembali=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tanggalKembali);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ===== DELETE — Hapus transaksi =====
    public boolean delete(int id) {
        String sql = "DELETE FROM transaksi WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}