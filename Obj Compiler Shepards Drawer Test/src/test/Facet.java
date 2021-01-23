/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 *
 * @author Jerry
 */
public class Facet {
    private int index;
    private Vertex a;
    private int a1;
    private Vertex b;
    private int b2;
    private Vertex c;
    private int c3;
    
    public Facet(String vc1, String vc2, String vc3, int index, ArrayList<Vertex> vertices){
        this.index = index;
        StringTokenizer vertex1 = new StringTokenizer(vc1, "/");
        StringTokenizer vertex2 = new StringTokenizer(vc2, "/");
        StringTokenizer vertex3 = new StringTokenizer(vc3, "/");
        a1 = Integer.parseInt(vertex1.nextToken());
        b2 = Integer.parseInt(vertex2.nextToken());
        c3 = Integer.parseInt(vertex3.nextToken());
        a = vertices.get(a1-1);
        b = vertices.get(b2-1);
        c = vertices.get(c3-1);
    }
    
    public Vertex geta(){
        return a;
    }
    
    public Vertex getb(){
        return b;
    }
    
    public Vertex getc(){
        return c;
    }
    
    public int getindexa(){
        return a1;
    }
    
    public int getindexb(){
        return b2;
    }
    
    public int getindexc(){
        return c3;
    }
    
    public int getindex(){
        return index;
    }
    
    public boolean contains(Vertex v){
        if(Objects.equals(a, v)) return true;
        if(Objects.equals(b, v)) return true;
        if(Objects.equals(c, v)) return true;
        return false;
    }
    
    public Vertex[] neighboring(Vertex v){
        Vertex[] temp = new Vertex[2];
        if(Objects.equals(a, v)){
            temp[0] = b;
            temp[1] = c;
            return temp;
        } else if(Objects.equals(b, v)){
            temp[0] = a;
            temp[1] = c;
            return temp;
        } else if(Objects.equals(c, v)){
            temp[0] = a;
            temp[1] = b;
            return temp;
        }
        return null;
    }
}
