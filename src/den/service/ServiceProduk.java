package den.service;

import den.model.ModelProduk;
import java.util.List;

public interface ServiceProduk {
    
    void tambahData (ModelProduk model);
    void perbaruiData (ModelProduk model);
    void hapusData (ModelProduk model);
    
    List<ModelProduk> tampilData();
    List<ModelProduk> pencarianData(String id);
    
}
