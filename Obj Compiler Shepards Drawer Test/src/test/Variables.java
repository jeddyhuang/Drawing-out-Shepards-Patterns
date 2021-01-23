/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author rxiao
 */
public class Variables {
    private int checkdist;
    private int gridsize;
    
    public Variables(String name){
        switch(name){
            case "ACPL":{
                checkdist = 3;
                gridsize = 7;
                break;
            }
            case "ACPR":{
                checkdist = 3;
                gridsize = 7;
                break;
            }
            case "DACL":{
                checkdist = 3;
                gridsize = 7;
                break;
            }
            case "DACR":{
                checkdist = 3;
                gridsize = 7;
                break;
            }
            case "ECTL":{
                checkdist = 4;
                gridsize = 9;
                break;
            }
            case "ECTR":{
                checkdist = 4;
                gridsize = 9;
                break;
            }
            case "G":{
                checkdist = 3;
                gridsize = 7;
                break;
            }
            case "GN":{
                checkdist = 4;
                gridsize = 9;
                break;
            }
            case "GOL":{
                checkdist = 3;
                gridsize = 7;
                break;
            }
            case "GOR":{
                checkdist = 3;
                gridsize = 7;
                break;
            }
            case "LI":{
                checkdist = 3;
                gridsize = 7;
                break;
            }
            case "LS":{
                checkdist = 3;
                gridsize = 7;
                break;
            }
            case "M":{
                checkdist = 4;
                gridsize = 9;
                break;
            }
            case "MIOL":{
                checkdist = 2;
                gridsize = 5;
                break;
            }
            case "MIOR":{
                checkdist = 2;
                gridsize = 5;
                break;
            }
            case "MLS":{
                checkdist = 3;
                gridsize = 7;
                break;
            }
            case "MSOL":{
                checkdist = 2;
                gridsize = 5;
                break;
            }
            case "MSOR":{
                checkdist = 2;
                gridsize = 5;
                break;
            }
            case "N":{
                checkdist = 3;
                gridsize = 7;
                break;
            }
            case "PG":{
                checkdist = 4;
                gridsize = 9;
                break;
            }
            case "SN":{
                checkdist = 3;
                gridsize = 7;
                break;
            }
            case "ZL":{
                checkdist = 4;
                gridsize = 9;
                break;
            }
            case "ZR":{
                checkdist = 4;
                gridsize = 9;
                break;
            }
            default:{
                checkdist = 0;
                gridsize = 0;
                break;
            }
        }
    }
    
    public int checkdist(){
        return checkdist;
    }
    
    public int gridsize(){
        return gridsize;
    }
}
