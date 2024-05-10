package den.service;

import den.model.ModelPenjualan;
import java.util.List;

public interface ServicePenjualan {
    
    void tambahData     (ModelPenjualan model);
    
    
    List<ModelPenjualan> tampilData();
    List<ModelPenjualan> pencarianData(String id);
    
    String noTransaksi();
}
