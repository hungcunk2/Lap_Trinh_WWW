package iuh.fit.se.baitapchuong3.dao;

import iuh.fit.se.baitapchuong3.model.Dienthoai;
import java.util.List;

/**
 * @author DAILOC
 */

public interface DienthoaiDAO {
    List<Dienthoai> getAll();
    boolean addDienthoai(Dienthoai dt);
    boolean deleteDienthoai(String maDT);
    List<Dienthoai> getBySupplier(String maNCC);
}
