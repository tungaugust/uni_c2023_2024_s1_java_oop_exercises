/*
 *  @ (#) AmDunNuoc.java      1.0 22/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package exercise4;

/**
 * Lớp ấm đun nước
 * @author: tungpt
 * @version: 1.0
 * @since: August 22, 2023
 */
public class AmDunNuoc {
    public static final String THUY_TINH = "ruột bình thuỷ tinh";
    public static final String INOX = "ruột bình inox";
    public static final String NHUA = "ruột bình nhựa";
    String maSanPham;
    String hang;
    int dungTich;   // ml (1000 ml = 1l)
    String ruotBinh;
    double gia;
    int congSuat;

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        if (maSanPham.equals("")) {
            throw new RuntimeException("Mã sản phẩm không được để rỗng");
        }
        this.maSanPham = maSanPham;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        if (hang.equals("")){
            hang = "hãng chưa xác định";
        }
        this.hang = hang;
    }

    public int getDungTich() {
        return dungTich;
    }

    public void setDungTich(int dungTich) {
        if (dungTich < 0){
            dungTich = 0;
        }
        this.dungTich = dungTich;
    }

    public String getRuotBinh() {
        return ruotBinh;
    }

    public void setRuotBinh(String ruotBinh) {
        if (!ruotBinh.equals(NHUA)
                && !ruotBinh.equals(INOX)
                && !ruotBinh.equals(THUY_TINH)
        ) {
            ruotBinh = "ruột bình chưa xác định";
        }
        this.ruotBinh = ruotBinh;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        if (gia < 0) {
            gia = 0;
        }
        this.gia = gia;
    }

    public int getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(int congSuat) {
        if (congSuat < 0) {
            congSuat = 0;
        }
        this.congSuat = congSuat;
    }

    public void dun(){
        System.out.println("Hành động đun nước.");
        System.out.println("Sau 10 giây.");
        tat();
    }

    public void tat(){
        System.out.println("Hành động tắt đun nước.");
    }

    public void chua(){
        System.out.println("Hành động chứa nước.");
    }

    public AmDunNuoc(String maSanPham, String hang, int dungTich, String ruotBinh, double gia, int congSuat) {
        setMaSanPham(maSanPham);
        setHang(hang);
        setGia(gia);
        setDungTich(dungTich);
        setRuotBinh(ruotBinh);
        setGia(gia);
        setCongSuat(congSuat);
    }

    @Override
    public String toString() {
        return "AmDunNuoc[" +
                "Mã sản phẩm='" + maSanPham + '\'' +
                ", Hãng='" + hang + '\'' +
                ", Dung tích=" + dungTich + " ml" +
                ", Chất liệu ruột bình='" + ruotBinh + '\'' +
                ", Giá=" + gia + " VND" +
                ", Công suất=" + congSuat + " W" +
                ']';
    }
}
