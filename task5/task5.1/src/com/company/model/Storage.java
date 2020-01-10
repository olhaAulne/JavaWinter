package com.company.model;

import com.company.view.IOtherStrings;

import java.util.LinkedList;
import java.util.List;

import static com.company.controller.Internationalization.RESOURCE;

public enum Storage implements IOtherStrings {
    INSTANCE;

    List<Journal> journal = new LinkedList<>();

    public void addNewEntry(Journal newest) {
        journal.add(newest);
    }

    public List<Journal> getJournal() {
        if(journal.isEmpty()){
            System.out.println(RESOURCE.getValue(STORAGE_NO_RECORDS));
            return journal;
        }
        return journal;
    }

}
