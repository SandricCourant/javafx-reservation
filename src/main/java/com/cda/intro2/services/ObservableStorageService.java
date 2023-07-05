package com.cda.intro2.services;

import javafx.collections.ObservableList;

public interface ObservableStorageService {
    ObservableList<String> getList(String name);
    void add(String name, String value);
    void set(String name, int index,String newValue);
    void remove(String name, int index);
}
