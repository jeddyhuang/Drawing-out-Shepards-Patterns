/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class ImgCompiler {
    private ArrayList<ArrayList<Double>> displacements;
    
    public ImgCompiler(ArrayList<ArrayList<Vertex>> neighbors){
        displacements = new ArrayList<ArrayList<Double>>(neighbors.size());
        for(int i = 0; i < neighbors.size(); i ++){
            displacements.add(new ArrayList<Double>(neighbors.get(i).size()));
            double ovnx = 0, ovny = 0, ovnz = 0;
            ovnx = neighbors.get(i).get(0).getvector().getX();
            ovny = neighbors.get(i).get(0).getvector().getY();
            ovnz = neighbors.get(i).get(0).getvector().getZ();
            double ovx = 0, ovy = 0, ovz = 0;
            ovx = neighbors.get(i).get(0).getX();
            ovy = neighbors.get(i).get(0).getY();
            ovz = neighbors.get(i).get(0).getZ();
            for(int j = 0; j < neighbors.get(i).size(); j ++){
                double nvx = 0, nvy = 0, nvz = 0;
                nvx = neighbors.get(i).get(j).getX();
                nvy = neighbors.get(i).get(j).getY();
                nvz = neighbors.get(i).get(j).getZ();
                double dvx = 0, dvy = 0, dvz = 0;
                dvx = nvx - ovx;
                dvy = nvy - ovy;
                dvz = nvz - ovz;
                double dp = ((ovnx * dvx) + (ovny * dvy) + (ovnz * dvz));
                displacements.get(i).add(dp);
            }
        }
    }
    
    public void runShepardsMethod(double imglimit, ArrayList<ArrayList<Vertex>> neighbors, ArrayList<SelPt> setpoints){
        int weightxp = 2;
        for(int i = 0; i < setpoints.size(); i ++){
            int imgsize = setpoints.get(i).getgridsize();
            int mid = (int)(imgsize / 2);
            Img[][] pix = new Img[imgsize][imgsize];
            Vertex vy = this.yvertex(neighbors.get(i).get(0).getvector());
            Vertex vx = this.xvertex(vy, neighbors.get(i).get(0).getvector());
            for(int y = 0; y < imgsize; y ++) for(int x = 0; x < imgsize; x ++){
                double my = imglimit * (mid - y);
                double mx = imglimit * (x - mid);
                
                double xcoord = 0, ycoord = 0, zcoord = 0;
                xcoord = neighbors.get(i).get(0).getX() + (my * vy.getX()) + (mx * vx.getX());
                ycoord = neighbors.get(i).get(0).getY() + (my * vy.getY()) + (mx * vx.getY());
                zcoord = neighbors.get(i).get(0).getZ() + (my * vy.getZ()) + (mx * vx.getZ());
                
                double tdis = 0;
                double tweight = 0;
                double[] ddis = new double[displacements.get(i).size()];
                double[] dweight = new double[displacements.get(i).size()];
                double finalv = 0;
                
                for(int j = 0; j < displacements.get(i).size(); j ++){
                    double px = 0, py = 0, pz = 0;
                    px = xcoord - neighbors.get(i).get(j).getX();
                    py = ycoord - neighbors.get(i).get(j).getY();
                    pz = zcoord - neighbors.get(i).get(j).getZ();
                    double dis = Math.sqrt(Math.pow(py, 2) + Math.pow(px, 2) + Math.pow(pz, 2));
                    ddis[j] = dis;
                    tdis += Math.pow(dis, -weightxp);
                }
                for(int j = 0; j < displacements.get(i).size(); j ++){
                    double sdis = Math.pow(ddis[j], -weightxp);
                    dweight[j] = (sdis / tdis);
                    tweight += (sdis / tdis);
                }
                for(int j = 0; j < displacements.get(i).size(); j ++){
                    finalv += ((dweight[j] / tweight) * (displacements.get(i).get(j)));
                }
                Img newpix = new Img(finalv);
                pix[y][x] = newpix;
            }
            setpoints.get(i).setimage(pix);
        }
    }
    
    public Vertex yvertex(Vector normal){
        double x = 0, y = 1, z = 0;
        double dp = normal.getY();
        
        double nx = 0, ny = 0, nz = 0;
        nx = dp * normal.getX();
        ny = dp * normal.getY();
        nz = dp * normal.getZ();
        
        double fx = 0, fy = 0, fz = 0;
        fx = x - nx;
        fy = y - ny;
        fz = z - nz;
        
        double dis = Math.sqrt(Math.pow(fx, 2) + Math.pow(fy, 2) + Math.pow(fz, 2));
        fx /= dis;
        fy /= dis;
        fz /= dis;
        
        return new Vertex(fx, fy, fz);
    }
    
    public Vertex xvertex(Vertex basevector, Vector crossvector){
        double x = 0, y = 0, z = 0;
        x = (basevector.getY() * crossvector.getZ()) - (basevector.getZ() * crossvector.getY());
        y = (basevector.getZ() * crossvector.getX()) - (basevector.getX() * crossvector.getZ());
        z = (basevector.getX() * crossvector.getY()) - (basevector.getY() * crossvector.getX());
        
        double dis = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
        x /= dis;
        y /= dis;
        z /= dis;
        
        return new Vertex(x, y, z);
    }
}
