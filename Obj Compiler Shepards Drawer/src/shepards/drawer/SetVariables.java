/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shepards.drawer;

/**
 *
 * @author rxiao
 */
public class SetVariables {
    public final int checkdist, gridsize, compdist;
    
    public SetVariables(String name){
        switch(name){
            case "ACPL":{
                checkdist = 3;
                gridsize = 7;
                compdist = 3;
                break;
            }
            case "ACPR":{
                checkdist = 3;
                gridsize = 7;
                compdist = 3;
                break;
            }
            case "DACL":{
                checkdist = 3;
                gridsize = 7;
                compdist = 3;
                break;
            }
            case "DACR":{
                checkdist = 3;
                gridsize = 7;
                compdist = 3;
                break;
            }
            case "ECTL":{
                checkdist = 4;
                gridsize = 9;
                compdist = 4;
                break;
            }
            case "ECTR":{
                checkdist = 4;
                gridsize = 9;
                compdist = 4;
                break;
            }
            case "G":{
                checkdist = 3;
                gridsize = 7;
                compdist = 4;
                break;
            }
            case "GN":{
                checkdist = 4;
                gridsize = 9;
                compdist = 3;
                break;
            }
            case "GOL":{
                checkdist = 3;
                gridsize = 7;
                compdist = 3;
                break;
            }
            case "GOR":{
                checkdist = 3;
                gridsize = 7;
                compdist = 3;
                break;
            }
            case "LI":{
                checkdist = 3;
                gridsize = 7;
                compdist = 3;
                break;
            }
            case "LS":{
                checkdist = 3;
                gridsize = 7;
                compdist = 3;
                break;
            }
            case "M":{
                checkdist = 4;
                gridsize = 9;
                compdist = 3;
                break;
            }
            case "MIOL":{
                checkdist = 2;
                gridsize = 5;
                compdist = 3;
                break;
            }
            case "MIOR":{
                checkdist = 2;
                gridsize = 5;
                compdist = 3;
                break;
            }
            case "MLS":{
                checkdist = 3;
                gridsize = 7;
                compdist = 3;
                break;
            }
            case "MSOL":{
                checkdist = 2;
                gridsize = 5;
                compdist = 3;
                break;
            }
            case "MSOR":{
                checkdist = 2;
                gridsize = 5;
                compdist = 3;
                break;
            }
            case "N":{
                checkdist = 3;
                gridsize = 7;
                compdist = 3;
                break;
            }
            case "PG":{
                checkdist = 4;
                gridsize = 9;
                compdist = 3;
                break;
            }
            case "SN":{
                checkdist = 3;
                gridsize = 7;
                compdist = 3;
                break;
            }
            case "ZL":{
                checkdist = 4;
                gridsize = 9;
                compdist = 3;
                break;
            }
            case "ZR":{
                checkdist = 4;
                gridsize = 9;
                compdist = 3;
                break;
            }
            default:{
                checkdist = 0;
                gridsize = 0;
                compdist = 0;
                break;
            }
        }
    }
}
