package den.model;

import java.util.Date;

public class ModelProduk {
    
    private int idproduk;
    private String namaProduk;
    private Double idKategori;
    private Long harga;
    private int stok;
    private int gram;
    private Double idSupplier;
    private String barcode;
    private Date expired;

    public int getIdproduk() {
        return idproduk;
    }

    public void setIdProduk(int idproduk) {
        this.idproduk = idproduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public Double getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(Double IdKategori) {
        this.idKategori = IdKategori;
    }

    public Long getHarga() {
        return harga;
    }

    public void setHarga(Long harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
    
    public int getGram() {
        return gram;
    }

    public void setGram(int gram) {
        this.gram = gram;
    }

    public String getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(String idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    
    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }
}