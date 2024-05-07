package den.service;

import den.model.ModelPenjualanDetail;
import java.util.List;

public interface ServicePenjualanDetail {
    
    void tambahData (ModelPenjualanDetail model);
    void sumTotal (ModelPenjualanDetail model);
    void hapusDataSementara();
    
    List<ModelPenjualanDetail> tampilData();
    List<ModelPenjualanDetail> pencarianData(String id);
}
