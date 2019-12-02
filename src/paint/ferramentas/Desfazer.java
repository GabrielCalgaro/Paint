/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.ferramentas;

import paint.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author calga
 */
public class Desfazer {
    public void desfazer(GraphicsContext g, Image buffer){
        g.drawImage(buffer, 0, 0);
    }
}
