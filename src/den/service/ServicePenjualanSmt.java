package den.service;

import den.model.ModelPenjualanSmt;
import java.util.List;

public interface ServicePenjualanSmt {
    
    void tambahData (ModelPenjualanSmt model);
    void perbaruiData (ModelPenjualanSmt model);
    void hapusData (ModelPenjualanSmt model);
    
    
    List<ModelPenjualanSmt> tampilData();
}
