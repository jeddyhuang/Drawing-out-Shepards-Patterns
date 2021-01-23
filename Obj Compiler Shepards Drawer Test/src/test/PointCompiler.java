/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author lenovo
 */
public class PointCompiler {
    private ArrayList<Vertex> vertices;
    private ArrayList<Vector> vectors;
    private ArrayList<Facet> facets;
    private ArrayList<ArrayList<Vertex>> allvneighbors;
    private ArrayList<ArrayList<Facet>> allfneighbors;
    private ArrayList<ArrayList<Vertex>> neighbors;
    
    public PointCompiler(ArrayList<Vertex> vertices, ArrayList<Vector> vectors, ArrayList<Facet> facets){
        this.vertices = vertices;
        this.vectors = vectors;
        this.facets = facets;
        this.setallvn();
    }
    
    public void setallvn(){
        allvneighbors = new ArrayList<ArrayList<Vertex>>(vertices.size());
        for(int i = 0; i < vertices.size(); i ++){
            allvneighbors.add(new ArrayList<Vertex>());
            allvneighbors.get(i).add(vertices.get(i));
            HashSet<Vertex> values = new HashSet<Vertex>();
            for(int j = 0; j < facets.size(); j ++){
                if(facets.get(j).contains(vertices.get(i))){
                    Vertex[] hold = facets.get(j).neighboring(vertices.get(i));
                    if(!values.contains(hold[0])){
                        allvneighbors.get(i).add(hold[0]);
                        values.add(hold[0]);
                    }
                    if(!values.contains(hold[1])){
                        allvneighbors.get(i).add(hold[1]);
                        values.add(hold[1]);
                    }
                }
            }
        }
    }
    
    public void setneighbors(ArrayList<SelPt> SetPoints){
        neighbors = new ArrayList<ArrayList<Vertex>>(SetPoints.size());
        for(int i = 0; i < SetPoints.size(); i ++){
            neighbors.add(new ArrayList<Vertex>());
            neighbors.get(i).add(vertices.get(SetPoints.get(i).getindex()-1));
            if(SetPoints.get(i).getcheckdist() > 0){
                for(int j = 1; j < allvneighbors.get(SetPoints.get(i).getindex()-1).size(); j ++){
                    neighbors.get(i).add(allvneighbors.get(SetPoints.get(i).getindex()-1).get(j));
                }
            }
            if(SetPoints.get(i).getcheckdist() > 1){
                HashSet<Vertex> values = new HashSet<Vertex>();
                for(int j = 0; j < neighbors.get(i).size(); j ++){
                    values.add(neighbors.get(i).get(j));
                }
                for(int r = 1; r < SetPoints.get(i).getcheckdist(); r ++){
                    int size = neighbors.get(i).size();
                    for(int j = 1; j < size; j ++){
                        for(int k = 1; k < allvneighbors.get(neighbors.get(i).get(j).getindex()-1).size(); k ++){
                            if(!values.contains(allvneighbors.get(neighbors.get(i).get(j).getindex()-1).get(k))){
                                neighbors.get(i).add(allvneighbors.get(neighbors.get(i).get(j).getindex()-1).get(k));
                                values.add(allvneighbors.get(neighbors.get(i).get(j).getindex()-1).get(k));
                            }
                        }
                    }
                }
            }
        }
    }
    
    public ArrayList<Vertex> compileVertex(){
        return vertices;
    }
    
    public ArrayList<Vector> compileVector(){
        return vectors;
    }
    
    public ArrayList<Facet> compileFacet(){
        return facets;
    }
    
    public ArrayList<ArrayList<Vertex>> compileneighbors(){
        return neighbors;
    }
}