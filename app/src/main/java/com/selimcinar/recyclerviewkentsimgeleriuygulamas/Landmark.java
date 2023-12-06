package com.selimcinar.recyclerviewkentsimgeleriuygulamas;

import java.io.Serializable;

public class Landmark implements Serializable {
    String name ;
    String country;

    String details;
    int image;

    public  Landmark(String name ,String country,String details,int image){
        this.name=name;
        this.country=country;
        this.image=image;
        this.details=details;

    }
}
