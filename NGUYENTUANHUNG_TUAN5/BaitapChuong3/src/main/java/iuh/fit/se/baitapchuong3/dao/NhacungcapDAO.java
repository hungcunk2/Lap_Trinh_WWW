package iuh.fit.se.baitapchuong3.dao;

import iuh.fit.se.baitapchuong3.model.Nhacungcap;
import java.util.List;

/**
 * @author DAILOC
 */

public interface NhacungcapDAO {
    List<Nhacungcap> getAll();
    List<Nhacungcap> search(String keyword);
    Nhacungcap getById(String maNCC);
}
