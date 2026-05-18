package controller;

import dao.BarangDAO;
import model.Barang;
import java.util.List;

public class BarangController {

    private final BarangDAO dao = new BarangDAO();

    public List<Barang> getAll() {
        return dao.getAll();
    }

    public boolean insert(String nama, int stok) {
        return dao.insert(new Barang(0, nama, stok));
    }

    public boolean update(int id, String nama, int stok) {
        return dao.update(new Barang(id, nama, stok));
    }

    public boolean delete(int id) {
        return dao.delete(id);
    }
}