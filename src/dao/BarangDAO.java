package dao;

import config.KoneksiDB;
import model.Barang;
import java.sql.*;
import java.util.*;

public class BarangDAO {

    public List<Barang> getAll() {
        List<Barang> list = new ArrayList<>();

        try {
            Connection c = KoneksiDB.getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM barang");

            while (rs.next()) {
                list.add(new Barang(
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getInt("stok")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean insert(Barang b) {
        try {
            Connection c = KoneksiDB.getConnection();
            String sql = "INSERT INTO barang (nama, stok) VALUES (?, ?)";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, b.getNama());
            ps.setInt(2, b.getStok());

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Barang b) {
        try {
            Connection c = KoneksiDB.getConnection();
            String sql = "UPDATE barang SET nama=?, stok=? WHERE id=?";
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, b.getNama());
            ps.setInt(2, b.getStok());
            ps.setInt(3, b.getId());

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            Connection c = KoneksiDB.getConnection();
            String sql = "DELETE FROM barang WHERE id=?";
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}