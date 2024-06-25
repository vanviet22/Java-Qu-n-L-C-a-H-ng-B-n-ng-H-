package DTO;

import java.time.LocalDateTime;

public class CTKM_DTO {
    private String maCT;
    private String tenCT;
    private LocalDateTime ngayBD;
    private LocalDateTime ngayKT;
    public String getMaCT() {
        return maCT;
    }
    public void setMaCT(String maCT) {
        this.maCT = maCT;
    }
    public String getTenCT() {
        return tenCT;
    }
    public void setTenCT(String tenCT) {
        this.tenCT = tenCT;
    }
    public LocalDateTime getNgayBD() {
        return ngayBD;
    }
    public void setNgayBD(LocalDateTime ngayBD) {
        this.ngayBD = ngayBD;
    }
    public LocalDateTime getNgayKT() {
        return ngayKT;
    }
    public void setNgayKT(LocalDateTime ngayKT) {
        this.ngayKT = ngayKT;
    }
    
}
