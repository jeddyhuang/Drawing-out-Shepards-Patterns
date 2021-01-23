/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;

/**
 *
 * @author Jerry
 */
public class SelPt {
    private String name;
    private int index;
    private int checkdist;
    private int gridsize;
    private Img[][] image;
    
    public SelPt(String name, int index, int checkdist, int gridsize){
        this.name = name;
        this.index = index;
        this.checkdist = checkdist;
        this.gridsize = gridsize;
    }
    
    public void setimage(Img[][] image){
        this.image = image;
    }
    
    public Img[][] getimage(){
        return image;
    }
    
    public String getname(){
        return name;
    }
    
    public int getindex(){
        return index;
    }
    
    public int getcheckdist(){
        return checkdist;
    }
    
    public int getgridsize(){
        return gridsize;
    }
}
