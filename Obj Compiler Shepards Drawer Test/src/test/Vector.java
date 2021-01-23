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
public class Vector {
    private double x;
    private double y;
    private double z;
    private int index;
    
    public Vector(double x, double y, double z, int index){
        this.x = x;
        this.y = y;
        this.z = z;
        this.index = index;
    }
    
    public int getindex(){
        return index;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public double getZ(){
        return z;
    }
}
