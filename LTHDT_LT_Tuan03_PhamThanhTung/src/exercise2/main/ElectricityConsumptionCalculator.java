/*
 *  @ (#) ElectricityConsumptionCalculator.java      1.0 21/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package exercise2.main;

import java.util.Scanner;

/**
 * Chương trình tính lượng điện tiêu thụ
 * @author: tungpt
 * @version: 1.0
 * @since: August 21, 2023
 */
public class ElectricityConsumptionCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chỉ số điện tháng trước và tháng này.");
        System.out.print("Chỉ số điện tháng trước: ");
        int oldQuantity = Integer.valueOf(scanner.nextLine().trim());
        System.out.print("Chỉ số điện tháng này: ");
        int newQuantity = Integer.valueOf(scanner.nextLine().trim());

        int consumedQuantity = newQuantity - oldQuantity;
        double amount = totalAmount(oldQuantity, newQuantity);
        System.out.printf("Tiền điện phải trả cho %d số điện là %,d nghìn VND.\n", consumedQuantity, (long) amount);
    }

    /**
     * Tính tổng tiền điện phải trả với 10% VAT
     * @param oldQuantity: số điện tháng trước (cũ)
     * @param newQuantity: số diện tháng này (mới)
     * @return thành tiền số tiền phải trả
     */
    public static double totalAmount(int oldQuantity, int newQuantity){
        int consumedQuantity = newQuantity - oldQuantity;
        if (consumedQuantity < 0) {
            throw new RuntimeException("Không thể thành tiền hoá đơn vì hiệu số âm.");
        }
        int levelQuantity = 0;
        double amount = 0.0;
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0: // 0-50: tiền đối đa = 86400
                    if (consumedQuantity > 50) {
                        levelQuantity = 50;
                        consumedQuantity -= 50;
                    } else {
                        levelQuantity = consumedQuantity;
                        consumedQuantity = 0;
                    }
                    amount += (double) levelQuantity * 1728;
                    break;
                case 1: // 51-100: tiền đối đa = 89300
                    if (consumedQuantity > 50) {
                        levelQuantity = 50;
                        consumedQuantity -= 50;
                    } else {
                        levelQuantity = consumedQuantity;
                        consumedQuantity = 0;
                    }
                    amount += (double) levelQuantity * 1786;
                    break;
                case 2: // 101-200: tiền đối đa = 207400
                    if (consumedQuantity > 100) {
                        levelQuantity = 100;
                        consumedQuantity -= 100;
                    } else {
                        levelQuantity = consumedQuantity;
                        consumedQuantity = 0;
                    }
                    amount += (double) levelQuantity * 2074;
                    break;
                case 3: // 201-300: tiền đối đa = 261200
                    if (consumedQuantity > 100) {
                        levelQuantity = 100;
                        consumedQuantity -= 100;
                    } else {
                        levelQuantity = consumedQuantity;
                        consumedQuantity = 0;
                    }
                    amount += (double) levelQuantity * 2612;
                    break;
                case 4: // 301-400: tiền đối đa = 291900
                    if (consumedQuantity > 100) {
                        levelQuantity = 100;
                        consumedQuantity -= 100;
                    } else {
                        levelQuantity = consumedQuantity;
                        consumedQuantity = 0;
                    }
                    amount += (double) levelQuantity * 2919;
                    break;
                case 5: // 401+
                    levelQuantity = consumedQuantity;
                    consumedQuantity = 0;
                    amount += (double) levelQuantity * 3015;
                    break;
                default: break;
            }
        }
        double VAT_RATE = 0.1;
        double totalVATAmount = amount * VAT_RATE;
        return Math.ceil(amount + totalVATAmount);
    }

    /**
     * Phương thức tính tiền điện
     * @param chiSoCu
     * @param chiSoMoi
     * @return số tiền phải chi trả
     */
    public static int getTienDien(int chiSoCu, int chiSoMoi){

        final double THUE = 0.1; // Thuế VAT

        int soKWh = chiSoMoi - chiSoCu; // Số kWh tiêu thụ
        int tienDien = getSoKWh(soKWh, 400, Integer.MAX_VALUE) * 3015
                + getSoKWh(soKWh, 300, 400) * 2919
                + getSoKWh(soKWh, 200, 300) * 2612
                + getSoKWh(soKWh, 100, 200) * 2074
                + getSoKWh(soKWh, 50, 100) * 1786
                + getSoKWh(soKWh, 0, 50) * 1728;

        return tienDien + (int)Math.ceil(tienDien * THUE);
    }

    public static int getSoKWh(int soKWh, int soDau, int soCuoi){

        if(soKWh < soDau)
            return 0;
        if(soKWh <= soCuoi)
            return soKWh - soDau;

        return soCuoi - soDau;
    }

}
