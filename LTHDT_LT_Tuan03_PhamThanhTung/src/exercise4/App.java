/*
 *  @ (#) App.java      1.0 22/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package exercise4;

/**
 * Chương trình bài tập 4 tuần 03
 * @author: tungpt
 * @version: 1.0
 * @since: August 22, 2023
 */
public class App {
    public static void main(String[] args) {
        AmDunNuoc amDunNuoc1 = new AmDunNuoc("HD9306", "Philips",1500 ,
                AmDunNuoc.INOX, 590000.0, 1800);
        AmDunNuoc amDunNuoc2 = new AmDunNuoc("SHD1330", "Sunhouse",1700,
                AmDunNuoc.THUY_TINH, 490000.0, 1850);
        AmDunNuoc amDunNuoc3 = new AmDunNuoc("NC-K101WRA", "Panasonic",1700,
                AmDunNuoc.NHUA, 690000.0, 2200);

        System.out.println(amDunNuoc1);
        System.out.println(amDunNuoc2);
        System.out.println(amDunNuoc3);

        System.out.println("Ấm nước 2 thực hiện:");
        amDunNuoc2.chua();
        amDunNuoc2.dun();
        amDunNuoc2.tat();

        System.out.println();
        QuatMay quatMay1 = new QuatMay("BD230", "Senko", QuatMay.HOP, 5, 239000.0, 28);
        QuatMay quatMay2 = new QuatMay("VY539790", "Asia", QuatMay.DUNG, 5, 694000.0, 55);
        QuatMay quatMay3 = new QuatMay("F-WSA20(H)VN", "Toshiba", QuatMay.TREO, 3, 990000.0, 55);

        System.out.println(quatMay1);
        System.out.println(quatMay2);
        System.out.println(quatMay3);

        System.out.println("Quạt máy 3 thực hiện:");
        quatMay3.quat(QuatMay.MODE2);
        quatMay3.chuyenMuc(QuatMay.MODE3);
        quatMay3.tat();

    }
}
