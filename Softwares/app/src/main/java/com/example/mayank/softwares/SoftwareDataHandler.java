package com.example.mayank.softwares;

/**
 * Created by mayank on 02-07-2016.
 */
public class SoftwareDataHandler  {
    private String sno;
    private  String name;
    private int image;



    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public SoftwareDataHandler(String sno, String name, int image) {
       this.setSno(sno);
        this.setName(name);
        this.setImage(image);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }
}
