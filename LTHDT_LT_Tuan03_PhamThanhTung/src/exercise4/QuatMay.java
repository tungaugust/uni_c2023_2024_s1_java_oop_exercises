/*
 *  @ (#) QuatMay.java      1.0 22/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package exercise4;

/**
 * Lớp quạt máy
 * @author: tungpt
 * @version: 1.0
 * @since: August 22, 2023
 */
public class QuatMay {
    public static final String DUNG = "quạt đứng";
    public static final String HOP = "quạt hộp";
    public static final String TREO = "quạt treo tường";
    public static final String MODE1 = "công tắc ở mode 1";
    public static final String MODE2 = "công tắc ở mode 2";
    public static final String MODE3 = "công tắc ở mode 3";

    String maSanPham;
    String hang;
    String loai;
    int soCanh;
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

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        if (!loai.equals(DUNG)
                && !loai.equals(HOP)
                && !loai.equals(TREO)
        ) {
            loai = "loại quạt chưa xác định";
        }
        this.loai = loai;
    }

    public int getSoCanh() {
        return soCanh;
    }

    public void setSoCanh(int soCanh) {
        if (soCanh < 3) {
            soCanh = 3;
        }
        this.soCanh = soCanh;
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
        if (congSuat < 0){
            congSuat = 0;
        }
        this.congSuat = congSuat;
    }

    public QuatMay(String maSanPham, String hang, String loai, int soCanh, double gia, int congSuat) {
        setMaSanPham(maSanPham);
        setHang(hang);
        setLoai(loai);
        setSoCanh(soCanh);
        setGia(gia);
        setCongSuat(congSuat);
    }

    public void quat(){
        System.out.println("Hành động quạt ở mức 1.");
    }
    public void quat(String mode){
        switch (mode){
            case MODE1:
                System.out.println("Hành động quạt ở mức 1.");
                break;
            case MODE2:
                System.out.println("Hành động quạt ở mức 2.");
                break;
            case MODE3:
                System.out.println("Hành động quạt ở mức 3.");
                break;
            default:
                quat();
                break;
        }
    }

    public void tat(){
        System.out.println("Hành động dừng (tắt) quạt.");
    }

    public void chuyenMuc(String mode){
        quat(mode);
    }

    @Override
    public String toString() {
        return "QuatMay[" +
                "Mã sản phẩm='" + maSanPham + '\'' +
                ", Hãng='" + hang + '\'' +
                ", Loại='" + loai + '\'' +
                ", Số cánh quạt=" + soCanh +
                ", Giá=" + gia + " VND" +
                ", Công suất=" + congSuat + " W" +
                ']';
    }
}
