/*
 *  @ (#) GenericStats.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter06.exercise11;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */
public class GenericStats <T extends Number>{
    T[] nums;

    public GenericStats(T[] nums) {
        this.nums = nums;
    }
    double average(){
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }
    boolean sameAvg(GenericStats<?> obj) {
        if (average() == obj.average()) {
            return true;
        }
        return false;
    }
}
