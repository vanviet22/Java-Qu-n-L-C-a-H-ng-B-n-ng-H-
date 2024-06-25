package DTO;

import java.time.LocalDateTime;

public class PhieuNhap_DTO {
    private String maPN;
    private String maNV;
    private String maNCC;
    private int soLuong;
    private LocalDateTime ngayLap;
    private double tongTien;
    public String getMaPN() {
        return maPN;
    }
    public int getSoLuong(){
        return soLuong;
    }
    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }
    public String getMaNV() {
        return maNV;
    }
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    public void setSoLuong(int sl)
    {
        this.soLuong=sl;
    }
    public String getMaNCC() {
        return maNCC;
    }
    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }
    public LocalDateTime getNgayLap() {
        return ngayLap;
    }
    public void setNgayLap(LocalDateTime ngayLap) {
        this.ngayLap = ngayLap;
    }
    public double getTongTien() {
        return tongTien;
    }
    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
}
