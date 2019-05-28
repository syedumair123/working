package com.example.mymosque.Adapter;

import com.google.gson.annotations.SerializedName;

public class Links {
    @SerializedName("first")
    private String first;
    private String last;
    private String prev;
    private String next;


    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }


}
