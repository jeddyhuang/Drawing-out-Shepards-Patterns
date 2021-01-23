/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Jerry
 */
public class Img {
    private int r;
    private int g;
    private int b;
    private int p;
    private double pw;
    
    public Img(double dp){
        r = 255;
        g = 255;
        b = 255;
        pw = dp;
        if(dp > 0 ){
            g = (int)(255 - 1280 * Math.abs(pw));
            r = (int)(255 - 1280 * Math.abs(pw));
            if(g < 0) g = 0;
            if(r < 0) r = 0;
        } else if(dp < 0){
            g = (int)(255 - 1280 * Math.abs(pw));
            b = (int)(255 - 1280 * Math.abs(pw));
            if(g < 0) g = 0;
            if(b < 0) b = 0;
        }
        p = (b<<16) | (g<<8) | r;
    }
    
    public int getr(){
        return r;
    }
    
    public int getg(){
        return g;
    }
    
    public int getb(){
        return b;
    }
    
    public int getp(){
        return p;
    }
    
    public double getpw(){
        return pw;
    }
}
