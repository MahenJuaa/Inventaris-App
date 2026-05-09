/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Transaksi {
    private int id;
    private int idBarang;
    private String namaPeminjam;
    private String tanggalPinjam;
    private String tanggalKembali;
    private String status;

    // Constructor kosong
    public Transaksi() {}

    // Constructor lengkap
    public Transaksi(int id, int idBarang, String namaPeminjam,
                     String tanggalPinjam, String tanggalKembali, String status) {
        this.id             = id;
        this.idBarang       = idBarang;
        this.namaPeminjam   = namaPeminjam;
        this.tanggalPinjam  = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
        this.status         = status;
    }

    // Getter & Setter
    public int    getId()              { return id; }
    public void   setId(int id)        { this.id = id; }

    public int    getIdBarang()               { return idBarang; }
    public void   setIdBarang(int idBarang)   { this.idBarang = idBarang; }

    public String getNamaPeminjam()                    { return namaPeminjam; }
    public void   setNamaPeminjam(String namaPeminjam) { this.namaPeminjam = namaPeminjam; }

    public String getTanggalPinjam()                     { return tanggalPinjam; }
    public void   setTanggalPinjam(String tanggalPinjam) { this.tanggalPinjam = tanggalPinjam; }

    public String getTanggalKembali()                      { return tanggalKembali; }
    public void   setTanggalKembali(String tanggalKembali) { this.tanggalKembali = tanggalKembali; }

    public String getStatus()               { return status; }
    public void   setStatus(String status)  { this.status = status; }
}
