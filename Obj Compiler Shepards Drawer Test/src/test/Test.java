/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author rxiao
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        ArrayList<String> people = new ArrayList<String>();
        people.add("84471");
        people.add("123592");
        people.add("204542");
        people.add("304494");
        people.add("305426");
        people.add("307094");
        people.add("307275");
        people.add("307873");
        people.add("308059");
        people.add("308256");
        people.add("309576");
        people.add("310162");
        people.add("312797");
        people.add("314601");
        people.add("317157");
        people.add("319043");
        people.add("319611");
        people.add("320182");
        people.add("320411");
        people.add("321233");
        people.add("321294");
        people.add("323478");
        people.add("323691");
        people.add("324536");
        people.add("324728");
        people.add("325276");
        people.add("325321");
        people.add("454385");
        people.add("546051");
        people.add("588944");
        people.add("599995");
        people.add("609510");
        people.add("762372");
        people.add("767880");
        people.add("812207");
        //people.add("26792 D");
        people.add("26792");
        //people.add("192641 B");
        people.add("192641");
        //people.add("316137 flag");
        people.add("316137");
        //people.add("460042 E");
        people.add("460042");
        
        String username = System.getProperty("user.name");
        String picdir = "C:\\Users\\" + username + "\\Desktop\\New folder";
        
        for(int index = 0; index < people.size(); index ++){
            String name = people.get(index);
            String directory = "C:\\Users\\" + username + "\\Desktop\\ManualLandmark-JW_1\\"  + name;
            String objdir = directory + "\\" + name + ".obj";
            String selptdir = directory + "\\" + name + " SEL.obj";
            ObjReader obj = new ObjReader(objdir);
            ObjReader selobj = new ObjReader(selptdir);
            
            ArrayList<SelPt> selpts = new ArrayList<SelPt>(selobj.compileVertices().size());
            for(int i = 0; i < selobj.compileVertices().size(); i ++){
                Vertex pose = selobj.compileVertices().get(i);
                Vertex closest = null;
                double dist = Double.POSITIVE_INFINITY;
                for(int j = 0; j < obj.compileVertices().size(); j++){
                    if(-1 < pose.getX() - obj.compileVertices().get(j).getX() || pose.getX() - obj.compileVertices().get(j).getX() < 1){
                        if(-1 < pose.getY() - obj.compileVertices().get(j).getY() || pose.getY() - obj.compileVertices().get(j).getY() < 1){
                            if(-1 < pose.getZ() - obj.compileVertices().get(j).getZ() || pose.getZ() - obj.compileVertices().get(j).getZ() < 1){
                                Vertex potential = obj.compileVertices().get(j);
                                double distance = Math.sqrt(Math.pow(pose.getX() - potential.getX(),2) + Math.pow(pose.getY() - potential.getY(),2) + Math.pow(pose.getZ() - potential.getZ(),2));
                                if(distance < dist){
                                    closest = potential;
                                    dist = distance;
                                }
                            }
                        }
                    }
                }
                String pt_name = selobj.compileVertices().get(i).getname();
                Variables v = new Variables(pt_name);
                selpts.add(new SelPt(pt_name, closest.getindex(), v.checkdist(), v.gridsize()));
            }
            PointCompiler pointcompiler = new PointCompiler(obj.compileVertices(), obj.compileVectors(), obj.compileFacets());
            pointcompiler.setneighbors(selpts);
            ImgCompiler shepardsmath = new ImgCompiler(pointcompiler.compileneighbors());
            shepardsmath.runShepardsMethod(0.5, pointcompiler.compileneighbors(), selpts);
            
            ImgWriter writer1 = new ImgWriter(name, picdir, selpts);
            System.out.println(name + " Set 1 Complete");
            ImgWriter writer2 = new ImgWriter(name, directory, selpts);
            System.out.println(name + " Set 2 Complete");
        }
    }
}
