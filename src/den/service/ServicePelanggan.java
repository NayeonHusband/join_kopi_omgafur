package den.service;

import den.model.ModelPelanggan;
import java.util.List;

public interface ServicePelanggan {
    void tambahData     (ModelPelanggan model);
    void perbaruiData   (ModelPelanggan model);
    void hapusData      (ModelPelanggan model);
    
    List<ModelPelanggan> tampilData();
    List<ModelPelanggan> pencarianData(String id);
    List<ModelPelanggan> ambilPelanggan();
}
