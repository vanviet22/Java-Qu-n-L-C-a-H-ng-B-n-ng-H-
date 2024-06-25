package DTO;

import java.time.LocalDateTime;

public class HoaDon_DTO {
    private String maHD;
    private String maKH;
    private String maNV;
    private String maKM;
    private LocalDateTime ngayLap;
    private float tienGiam;
    private double tongTien;
    public String getMaHD() {
        return maHD;
    }
    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }
    public String getMaKH() {
        return maKH;
    }
    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }
    public String getMaNV() {
        return maNV;
    }
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    public String getMaKM() {
        return maKM;
    }
    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }
    public LocalDateTime getNgayLap() {
        return ngayLap;
    }
    public void setNgayLap(LocalDateTime ngayLap) {
        this.ngayLap = ngayLap;
    }
    public Float getTienGiam() {
        return tienGiam;
    }
    public void setTienGiam(Float tienGiam) {
        this.tienGiam = tienGiam;
    }
    public double getTongTien() {
        return tongTien;
    }
    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
}
