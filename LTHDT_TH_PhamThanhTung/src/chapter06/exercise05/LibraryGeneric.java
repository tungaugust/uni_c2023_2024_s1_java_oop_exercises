/*
 *  @ (#) LibraryGeneric.java      1.0 11/10/2023
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
public class LibraryGeneric<E extends Media> {
    private List<E> resources = new ArrayList<E>();
    public void addMedia(E media) {
        resources.add(media);
    }
    public E retrieveLast(){
        int size = resources.size();
        if (size > 0){
            return resources.get(size - 1);
        }
        return null;
    }
}
