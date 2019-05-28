package com.example.mymosque.Adapter;

import com.google.gson.annotations.SerializedName;

public class Dua {
    @SerializedName("d_id")
    private int d_id;
    private String name;
    private String file_path;
    private String file_name;
    private String duration;
private String timestamp;

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public void setDiscriptionArbic(String discriptionArbic) {
        this.discriptionArbic = discriptionArbic;
    }

    private String discription;
private String discriptionArbic;
public Dua(){}
    public Dua(int d_id,String name,String file_path,String file_name,String duration ,String timestamp,String discription,String discriptionArbic){

        this.d_id=d_id;
        this.name=name;
        this.file_path=file_path;
        this.file_name=file_name;
        this.duration=duration;
        this.timestamp=timestamp;
        this.discription=discription;
        this.discriptionArbic=discriptionArbic;
    }

    public int getD_id() {
        return d_id;
    }

    public String getname() {
        return name;
    }

    public String getFile_path() {
        return file_path;
    }

    public String getFile_name() {
        return file_name;
    }

    public String getDuration() {
        return duration;
    }

    public String getTimestamp() {
        return timestamp;
    }
    public String getDiscription(){
        return discription;
    }
    public String getDiscriptionArbic() {
        return discriptionArbic;
    }

}