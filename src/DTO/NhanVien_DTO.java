package DTO;

import java.time.LocalDateTime;

public class NhanVien_DTO  {
    private String maNV;
    private String chucvu;
    private String ho;
    private String ten;
    private String dc;
    private String sdt;
    private LocalDateTime ngaysinh;
    private String gt;
    private float luong;
    public NhanVien_DTO(){}
    public String getMaNV() {
        return maNV;
    }
    public String getChucvu() {
        return chucvu;
    }
    public float getLuong() {
        return luong;
    }
    public String getHo() {
        return ho;
    }
    public String getTen() {
        return ten;
    }
    public String getDc() {
        return dc;
    }
    public String getSdt() {
        return sdt;
    }
    public String getGt() {
        return gt;
    }
    public LocalDateTime getNgaySinh()
    {
        return ngaysinh;
    }
    public void setNgaySinh(LocalDateTime ns)
    {
        this.ngaysinh=ns;
    }
    public void setHo(String ho) {
        this.ho = ho;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public void setDc(String dc) {
        this.dc = dc;
    }
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public void setGt(String gt) {
        this.gt = gt;
    }
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }
    public void setLuong(float luong) {
        this.luong = luong;
    }
    
}

