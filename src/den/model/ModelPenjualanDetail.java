/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package den.model;
import java.util.Date;

public class ModelPenjualanDetail {

    public ModelPenjualan getModelPenjualan() {
        return modelPenjualan;
    }

    public void setModelPenjualan(ModelPenjualan modelPenjualan) {
        this.modelPenjualan = modelPenjualan;
    }

    public ModelProduk getModelProduk() {
        return modelProduk;
    }

    public void setModelProduk(ModelProduk modelProduk) {
        this.modelProduk = modelProduk;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    private ModelPenjualan modelPenjualan;
    private ModelProduk modelProduk;
    private int jumlah;
    private double subTotal;
  


}
