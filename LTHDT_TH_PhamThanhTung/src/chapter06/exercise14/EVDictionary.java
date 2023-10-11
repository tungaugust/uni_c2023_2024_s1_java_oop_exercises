/*
 *  @ (#) EVDictionary.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter06.exercise14;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */
public class EVDictionary {
    private Map<String, EVWordClass> dict;

    public EVDictionary() {
        this.dict = new HashMap<>();
    }

    public boolean addWord(EVWordClass word) {
        return dict.put(word.getWord().toLowerCase(), word) == null ? true : false;
    }

    public EVWordClass lookup(String word) {
        return dict.get(word);
    }
//    public String toString()
//    {
//        String ret = "";
//        for(EVWordClass w:dic.values())
//            ret += w.toString()+"\n";
//        return ret;
//    }

    @Override
    public String toString() {
        return this.dict.entrySet().stream()
                .map(o -> o.getValue().toString())
                .collect(Collectors.joining("\n"));
    }
}
