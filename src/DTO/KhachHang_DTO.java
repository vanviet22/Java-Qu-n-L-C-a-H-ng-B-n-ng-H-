package DTO;
public class KhachHang_DTO {
    private String maKH;
    private String ho;
    private String ten;
    private String dc;
    private String sdt;
    private String gt;
    private String trang_thai;
    public KhachHang_DTO(){}
    public String getMaKH() {
        return maKH;
    }
    public void setMaKH(String maKH) {
        this.maKH = maKH;
    };
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
    public String getTrang_thai() {
        return trang_thai;
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
    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    };
    
    
}