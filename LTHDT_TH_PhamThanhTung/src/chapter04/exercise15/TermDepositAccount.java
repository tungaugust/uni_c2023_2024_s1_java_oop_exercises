/*
 *  @ (#) TermDepositAccount.java      1.0 28/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise15;

/**
 * Lớp TermDepositAccount là lớp thể hiện tài khoản tiền gửi có kỳ hạn
 * số tiền lãi này không thể rút ra trước khi đáo hạn mà không gởi thông báo trước.
 * @author: tungpt
 * @version: 1.0
 * @since: August 28, 2023
 */
public class TermDepositAccount extends Savings {
    private int term;   // kỳ hạn, được tính bằng số tháng

    public TermDepositAccount(String accID, double balance, double intRate, int term) {
        super(accID, balance, intRate);
        setTerm(term);
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        if (term <= 0) {
            throw new IllegalArgumentException("Kỳ hạn là số tháng lớn hơn 0");
        }
        this.term = term;
    }

    @Override
    public void addInterestToBalance() {
        for (int i = 0; i < getTerm(); i++) {
            super.addInterestToBalance();
        }
    }
}
