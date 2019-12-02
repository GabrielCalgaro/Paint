/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.ferramentas;

import paint.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;

/**
 *
 * @author calga
 */
public class Linha implements Desenhavel{

    @Override
    public void desenhar(ColorPicker paletadecores, double x, double y, double lastx, double lasty, double size, GraphicsContext g) {
        g.setLineWidth(size);
        g.setStroke(paletadecores.getValue());
        g.strokeLine(lastx, lasty, x, y);
    }
    
}
