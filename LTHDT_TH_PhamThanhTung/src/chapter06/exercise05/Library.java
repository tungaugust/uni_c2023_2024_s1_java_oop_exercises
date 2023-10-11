/*
 *  @ (#) Library.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter06.exercise05;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */
public class Library {
    private List resources = new ArrayList();
    public void addMedia(Media media) {
        resources.add(media);
    }
    public Media retrieveLast(){
        int size = resources.size();
        if (size > 0){
            return (Media) resources.get(size - 1);
        }
        return null;
    }
}
interface Media {}
interface Book extends Media {}
interface Video extends Media {}
interface Newspaper extends Media {}
