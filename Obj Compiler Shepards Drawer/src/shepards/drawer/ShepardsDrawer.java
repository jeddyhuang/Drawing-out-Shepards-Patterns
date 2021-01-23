/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shepards.drawer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author rxiao
 */
public class ShepardsDrawer {
    private static final int THREADS = 96;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        JFileChooser selobjs = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        selobjs.setDialogTitle("Select the .obj Files to Generate Patterns From:");
        selobjs.setMultiSelectionEnabled(true);
        selobjs.setAcceptAllFileFilterUsed(false);
        selobjs.addChoosableFileFilter(new FileNameExtensionFilter(".obj Files", "obj"));
        if(selobjs.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) System.exit(0);
        
        JFileChooser selobjpatts = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        selobjpatts.setDialogTitle("Select the .obj Pattern Files:");
        selobjpatts.setMultiSelectionEnabled(true);
        selobjpatts.setAcceptAllFileFilterUsed(false);
        selobjpatts.addChoosableFileFilter(new FileNameExtensionFilter(".obj Files", "obj"));
        if(selobjpatts.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) System.exit(0);
        
        JFileChooser targetfolder = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        targetfolder.setDialogTitle("Where to Save your Files:");
        targetfolder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(targetfolder.showSaveDialog(null) != JFileChooser.APPROVE_OPTION) System.exit(0);
        
        int[] nums = IntStream.range(0, selobjpatts.getSelectedFiles().length).toArray();
        
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);
        for(int token : nums){
            executor.execute(()->{
                try {
                    ObjReader objpoints = new ObjReader(selobjs.getSelectedFiles()[token].getPath());
                    ObjReader objpatterns = new ObjReader(selobjpatts.getSelectedFiles()[token].getPath());
                    objpatterns.alphabetizeVertices();
                    PointCompiler ptcomp = new PointCompiler(objpoints, objpatterns);
                    ptcomp.setallNeighbors();
                    ptcomp.setRegions();
                    ptcomp.setNeighbors();
                    ImgCompiler imgcomp = new ImgCompiler(ptcomp);
                    imgcomp.runShepardsMethod(0.75);
                    ImgWriter writer = new ImgWriter(targetfolder.getSelectedFile().getPath(), imgcomp);
                } catch (Exception e){}
            });
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        
        JOptionPane.showMessageDialog(null, "Patterns Generated", "Complete", JOptionPane.INFORMATION_MESSAGE);
    }
}