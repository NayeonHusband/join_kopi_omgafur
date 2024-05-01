package den.service;

import den.model.ModelKategori;
import java.util.List;

public interface ServiceKategori {
    
    void tambahData (ModelKategori model);
    void perbaruiData (ModelKategori model);
    void hapusData (ModelKategori model);
    
    List<ModelKategori> tampilData();
    List<ModelKategori> pencarianData(String id);
    
    boolean validasiNamaKategori (ModelKategori model);
    
    
    
}
