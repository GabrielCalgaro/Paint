/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/**
 *
 * @author calga
 */
public class Imagem extends Arquivo{
    Image image;
    
    public Imagem(){
        this.recentes = new String[3];
    }
    public Image getImage(Canvas tela){
        image = tela.snapshot(null, null);
        return image;
    }
    
    //abre uma imagem jpg e grava seu caminho num arquivo txt
    @Override
    public void abrir(GraphicsContext g) {
        FileChooser fileChooser = new FileChooser();

        //filtro de extensao jpg
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterjpg);

        //abre dialogo de arquivo para encontrar a imagem a ser aberta
        file = fileChooser.showOpenDialog(null);
        
        //grava caminho do arquivo num txt
        try {
            recentes[cont] = file.getCanonicalPath();
            gravarRecente(recentes, cont);
        } catch (IOException ex) {
            Logger.getLogger(Imagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //verifica se atingiu o numero maximo de arquivos recentes a serem guardados
        if(cont < recentes.length - 1){
            cont++;
        }
        
        else{
            cont = 0;
        }                
        
        //exibe a imagem na tela
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            image = SwingFXUtils.toFXImage(bufferedImage, null);
            g.drawImage(image, 0, 0);
        } catch (IOException ex) {
            System.out.println("Falha ao abrir imagem: " + ex);
        }
    }
    
    //salva a imagem presente na tela num arquivo jpg
    @Override
    public void salvar(GraphicsContext g, Image image) {
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "jpg", new File("paint.jpg"));
        } catch (IOException e) {
            System.out.println("Erro ao tentar salvar imagem: " + e);
        }
    }
}
