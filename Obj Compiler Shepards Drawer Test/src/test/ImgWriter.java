/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author lenovo
 */
public class ImgWriter {
    public ImgWriter(String name, String directory, ArrayList<SelPt> selpt) throws IOException{
        for(int i = 0; i < selpt.size(); i ++){
            int imgsize = selpt.get(i).getgridsize();
            String title = selpt.get(i).getname() + " " + name + ".png";
            String path = directory + "\\" + title;
            int width = imgsize * 16, height = imgsize * 16;
            BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for(int y = 0; y < imgsize; y ++) for(int x = 0; x < imgsize; x ++){
                for(int h = 0; h < 16; h ++) for(int w = 0; w < 16; w ++){
                    img.setRGB(x*16 + w, y*16 + h, selpt.get(i).getimage()[y][x].getp());
                }
            }
            File f = new File(path);
            ImageIO.write(img, "png", f);
        }
    }
}
