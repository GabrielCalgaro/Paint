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
public interface Desenhavel {
   void desenhar(ColorPicker paletadecores, double x, double y, double lastx, double lasty, double size, GraphicsContext g);
}
