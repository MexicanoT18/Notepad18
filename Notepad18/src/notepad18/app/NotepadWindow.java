/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad18.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import notepad18.buttons.NotepadMenu;

/**
 *
 * @author Lucas
 * 
 * Esta é a classe principal do Notepad. Ela também é o objeto JFrame de todo o programa.
 * Guarda instâncias das classes:
 *      NotepadMenu: trabalha com tudo relacionado aos menus
 *      NotepadTextArea: trabalha com tudo relacionado à área do texto.
 * 
 */
public class NotepadWindow extends JFrame{
    
    int HEIGHT = 640;
    int WIDTH = 480;
    
    boolean changeCursor = true;
    
    private NotepadMenu menu = new NotepadMenu();
    private NotepadTextArea textArea = new NotepadTextArea(){
        public void setCursor (Cursor cursor){
            if (changeCursor)
                super.setCursor(cursor);
        }
    };
    private JScrollPane scrollArea;
    
    public NotepadWindow(){
        
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Notepad18");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        scrollArea = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.getContentPane().setLayout(new BorderLayout()); // the BorderLayout bit makes it fill it automatically
	this.getContentPane().add(scrollArea);
        
        textArea.setEditorKit(new MyHTMLEditorKit());
        textArea.setContentType("text/html");
        textArea.initListener();
        
        textArea.addHyperlinkListener(new HyperlinkListener(){
            public void hyperlinkUpdate(HyperlinkEvent e){
                
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
                    if (Desktop.isDesktopSupported()){
                        try{
                            Desktop.getDesktop().browse(e.getURL().toURI());
                        } catch (Exception exc){
                            exc.printStackTrace();
                        }
                    }
                }
                
            }
        });
        
        menu.initialize(this);
        this.setMenuBar(menu);
        
        customizationReset();
    }
    
    public NotepadTextArea getTextArea(){
        return textArea;
    }
    
    public void close(){
        this.dispose();
    }
    
    public void resetText(){
        textArea.setText(new String());
    }
      
    public void whiteBackground(){
        textArea.setBackground(Color.white);
    }
    
    public void blackBackground(){
        textArea.setBackground(Color.black);
    }
    
    public void Font14(){
        String bodyRule = "body { font-size: 14pt; }";
        ((HTMLDocument)textArea.getDocument()).getStyleSheet().addRule(bodyRule);
    }
    
    public void Font16(){
        String bodyRule = "body { font-size: 16pt; }";
        ((HTMLDocument)textArea.getDocument()).getStyleSheet().addRule(bodyRule);
    }
    
    public void Font18(){
        String bodyRule = "body { font-size: 18pt; }";
        ((HTMLDocument)textArea.getDocument()).getStyleSheet().addRule(bodyRule);
    }
    
    public void Font20(){
        String bodyRule = "body { font-size: 20pt; }";
        ((HTMLDocument)textArea.getDocument()).getStyleSheet().addRule(bodyRule);
    }
    
    public void Font22(){
        String bodyRule = "body { font-size: 22pt; }";
        ((HTMLDocument)textArea.getDocument()).getStyleSheet().addRule(bodyRule);
    }
    
    public void redFont(){
        String bodyRule = "body { color: \"red\" }";
        ((HTMLDocument)textArea.getDocument()).getStyleSheet().addRule(bodyRule);
    }
    
    public void orangeFont(){
        String bodyRule = "body { color: \"orange\" }";
        ((HTMLDocument)textArea.getDocument()).getStyleSheet().addRule(bodyRule);
    }
    
    public void yellowFont(){
        String bodyRule = "body { color: \"yellow\" }";
        ((HTMLDocument)textArea.getDocument()).getStyleSheet().addRule(bodyRule);
    }
    
    public void greenFont(){
        String bodyRule = "body { color: \"green\" }";
        ((HTMLDocument)textArea.getDocument()).getStyleSheet().addRule(bodyRule);
    }
    
    public void cyanFont(){
        String bodyRule = "body { color: \"#00ffff\" }";
        ((HTMLDocument)textArea.getDocument()).getStyleSheet().addRule(bodyRule);
    }
    
    public void blueFont(){
        String bodyRule = "body { color: \"blue\" }";
        ((HTMLDocument)textArea.getDocument()).getStyleSheet().addRule(bodyRule);
    }
    
    public void purpleFont(){
        String bodyRule = "body { color: \"purple\" }";
        ((HTMLDocument)textArea.getDocument()).getStyleSheet().addRule(bodyRule);
    }
    
    public void whiteFont(){
        String bodyRule = "body { color: \"white\" }";
        ((HTMLDocument)textArea.getDocument()).getStyleSheet().addRule(bodyRule);
    }
    
    public void blackFont(){
        String bodyRule = "body { color: \"black\" }";
        ((HTMLDocument)textArea.getDocument()).getStyleSheet().addRule(bodyRule);
    }
    
    public void customizationReset(){
        String bodyRule = "body { font-family: Times New Roman }";
        ((HTMLDocument)textArea.getDocument()).getStyleSheet().addRule(bodyRule);
        
        whiteBackground();
        Font18();
        blackFont();
    }
    
    private class MyHTMLEditorKit extends HTMLEditorKit{
        
        MyLinkController handler = new MyLinkController();
        
        public void install(JEditorPane editorPane){
            MouseListener[] mouseListeners = editorPane.getMouseListeners();
            MouseMotionListener[] mouseMotionListeners = editorPane.getMouseMotionListeners();
            
            super.install(editorPane);
            
            for (MouseListener ml: editorPane.getMouseListeners()){
                editorPane.removeMouseListener(ml);
            }
            
            for (MouseListener ml: mouseListeners){
                editorPane.addMouseListener(ml);
            }
            
            for (MouseMotionListener mml: editorPane.getMouseMotionListeners()){
                editorPane.removeMouseMotionListener(mml);
            }
            
            for (MouseMotionListener mml: mouseMotionListeners){
                editorPane.addMouseMotionListener(mml);
            }
            
            editorPane.addMouseListener(handler);
            editorPane.addMouseMotionListener(handler);
        }
        
    }
    
    private class MyLinkController extends HTMLEditorKit.LinkController{
        
        public void mouseClicked (MouseEvent e){
            JEditorPane editorPane = (JEditorPane) e.getSource();
            
            if (editorPane.isEditable() && SwingUtilities.isLeftMouseButton(e)){
                if (e.getClickCount()==1){
                    editorPane.setEditable(false);
                    super.mouseClicked(e);
                    editorPane.setEditable(true);
                }
            }
        }
        
        public void mouseMoved (MouseEvent e){
            JEditorPane editorPane = (JEditorPane) e.getSource();
            
            if (editorPane.isEditable()){
                changeCursor = false;
                editorPane.setEditable(false);
                changeCursor = true;
                
                super.mouseMoved(e);
                
                changeCursor = false;
                editorPane.setEditable(true);
                changeCursor = true;
            }
        }
        
    }
}
