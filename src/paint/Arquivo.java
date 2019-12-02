/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author calga
 */
public abstract class Arquivo {
    File file;
    String[] recentes;
    int cont;
    
    public abstract void abrir(GraphicsContext g);
    public abstract void salvar(GraphicsContext g, Image image);
    
    //grava no arquivo txt os arquivos abertos recentemente
    public void gravarRecente(String[] recentes, int cont) throws IOException {
        FileWriter arq = new FileWriter("recentes.txt");     
        PrintWriter gravarArq = new PrintWriter(arq);
        
        for(int i=0; i < recentes.length; i++){
            gravarArq.println(recentes[i]);
        }
        gravarArq.close();
    }
}
