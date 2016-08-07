package com.ats_school.rycyclerview;

/**
 * Created by macbookpro on 2/7/16.
 */
public class DictionaryItem {
    String word;
    String difinition;

    public DictionaryItem(String word, String difinition) {
        this.word = word;
        this.difinition = difinition;
    }

    public String getWord() {
        return word;
    }

    public String getDifinition() {
        return difinition;
    }
}
