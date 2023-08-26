/*
 *  @ (#) Order.java      1.0 26/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise02;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Lớp Order là toàn thể được hợp thành từ OrderDetail (quan hệ Composition)
 * @author: tungpt
 * @version: 1.0
 * @since: August 26, 2023
 */
public class Order {
    private int orderID;
    private Date orderDate;
    private List<OrderDetail> lineTitems;

    public Order(int orderID, Date orderDate) {
        this.orderID = orderID;
        setOrderDate(orderDate);
        lineTitems = new ArrayList<>();
    }

    public void addLineItem(Product product, int quantity) {
        OrderDetail orderDetail = new OrderDetail(product, quantity);
        this.lineTitems.add(orderDetail);
    }

    public double calcTotalCharge() {
        double sum = 0.0;
        for (OrderDetail orderDetail: this.lineTitems) {
            sum += orderDetail.calcTotalPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        String record;
        String headerLine = String.format("%-5s | %-10s | %-25s | %15s | %15s | %20s",
                "STT", "Mã SP", "Mô tả", "Đơn giá", "Số lượng", "Thành tiền"
        );
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        record = "Mã hoá đơn: " + String.valueOf(getOrderID())
                + "\nNgày lập hoá đơn: " + simpleDateFormat.format(getOrderDate())
                + "\n" + headerLine + "\n";
        for (int i = 0; i < this.lineTitems.size(); i++) {
            record += String.format("%-5d | ", i + 1) + this.lineTitems.get(i) + "\n";
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,##0 VND");
        record += "Tồng tiền thanh toán: " + decimalFormat.format(calcTotalCharge());
        return record;
    }

    public int getOrderID() {
        return orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
