/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import paint.ferramentas.Borracha;
import paint.ferramentas.Circulo;
import paint.ferramentas.Desfazer;
import paint.ferramentas.Linha;
import paint.ferramentas.Livre;
import paint.ferramentas.Refazer;
import paint.ferramentas.Retangulo;
import paint.ferramentas.Texto;

/**
 *
 * @author calga
 */
public class PaintFXMLController implements Initializable {
    
    private final int numeroDeBotoes = 8;
    
    private Button[] botoes;
    private Livre l;
    private Texto t;
    private Linha ln;
    private Retangulo r;
    private Circulo c;
    private Borracha b;
    private Desfazer undo;
    private Refazer redo;
    private Imagem img;
    private Image buffer, bufferRedo;
    private File file;
    
    @FXML
    private ColorPicker paletadecores;
    
    @FXML
    private Canvas tela;
    
    @FXML
    private Button livre, texto, linha, retangulo, circulo, borracha, desfazer, refazer;
    
    @FXML
    private TextField campotexto;
    
    GraphicsContext g;
    private double x, y, lastx, lasty;
    private double size = 10;
    
    private String ferramenta;

    public PaintFXMLController() {
        this.botoes = new Button[numeroDeBotoes];
        this.l = new Livre();
        this.t = new Texto();
        this.ln = new Linha();
        this.r = new Retangulo();
        this.c = new Circulo();
        this.b = new Borracha();
        this.img = new Imagem();
        this.undo = new Desfazer();
        this.redo = new Refazer();
    }
    
    
    @FXML
    private void onMousePressedListener(MouseEvent e){
        this.x = e.getX();
        this.y = e.getY();
        this.lastx = e.getX();
        this.lasty = e.getY();
        buffer = img.getImage(tela);
        
        //Caso o botão texto tenha sido pressionado, chama o método escrever para imprimir o texto na tela 
        switch(ferramenta){
            case "texto":
                t.escrever(paletadecores, x, y, g, campotexto);                  
            break;
        }
    }
    
    
    @FXML
    private void onMouseDraggedListener(MouseEvent e){
        this.x = e.getX();
        this.y = e.getY();
        
        switch(ferramenta){
            case "livre":
                l.desenhar(paletadecores, x, y, lastx, lasty, size, g);
            break;
            case "borracha":
                b.apagar(x, y, size, g);
            break;
        }
    }
    
    @FXML
    private void onMouseReleaseListener(MouseEvent e){
        this.x = e.getX();
        this.y = e.getY();
        
        switch(ferramenta){
            case "linha":               
                ln.desenhar(paletadecores, x, y, lastx, lasty, size, g);
            break;
            case "retangulo":
                r.desenhar(paletadecores, x, y, lastx, lasty, size, g);
            break;
            case "circulo":
                c.desenhar(paletadecores, x, y, lastx, lasty, size, g);
            break;
        }
    }
    
    @FXML
    private void selecionarBotao(ActionEvent e) {
        for(int i = 0; i < numeroDeBotoes; i++){
            if(e.getSource() == botoes[i]){
               ferramenta = botoes[i].getId();
            }          
        }
        
        switch(ferramenta){
            case "desfazer":
                bufferRedo = img.getImage(tela);
                undo.desfazer(g, buffer);
            break;
            case "refazer":
                redo.refazer(g, bufferRedo);
            break;
        }
    }
    
    
    @FXML
    public void abrir() {
        buffer = img.getImage(tela);
        img.abrir(g);
    }

    @FXML
    public void salvar() {
        img.salvar(g, img.getImage(tela));
    }
    
    @FXML
    public void mostrarRecentes() {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        g = tela.getGraphicsContext2D();
        
        //colore a tela de branco
        g.setFill(Color.WHITE);
        g.fillRect(1, 1, g.getCanvas().getWidth(), g.getCanvas().getHeight());
        buffer = img.getImage(tela);
        
        //inicializa vetor com os botoes
        botoes[0] = livre;
        botoes[1] = texto;
        botoes[2] = linha;
        botoes[3] = retangulo;
        botoes[4] = circulo;
        botoes[5] = borracha;
        botoes[6] = desfazer;
        botoes[7] = refazer;
    }   
}
