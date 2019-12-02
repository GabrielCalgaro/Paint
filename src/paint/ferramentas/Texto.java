/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.ferramentas;

import paint.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;

/**
 *
 * @author calga
 */
public class Texto {

   public void escrever(ColorPicker paletadecores, Double x, Double y, GraphicsContext g, TextField campotexto) {
        g.setFill(paletadecores.getValue());
        g.fillText(campotexto.getText(), x, y);
    }
}
