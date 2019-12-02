/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.ferramentas;

import paint.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author calga
 */
public class Borracha {
    public void apagar(double x, double y, double size, GraphicsContext g){
        g.setFill(Color.WHITE);
        g.fillRect(x, y, size, size);
    }
}
