/*
 *  @ (#) UncheckedException.java      1.0 25/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise01;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 25, 2023
 */
public class UncheckedException extends RuntimeException{
    public UncheckedException(int soGioThue){
        super(String.valueOf(soGioThue));
    }
}
