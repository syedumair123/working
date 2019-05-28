package com.example.mymosque.Adapter;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LinksArrayList {
    @SerializedName("links")
    private ArrayList<Links> getLinkList;
    public ArrayList<Links> getGetLinkList(){
        return getLinkList;
    }
}
