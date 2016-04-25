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
    
    public void Font8(){
        textArea.setFont(new Font("Times New Roman", Font.BOLD, 8));
    }
    
    public void Font10(){
        textArea.setFont(new Font("Times New Roman", Font.BOLD, 10));
    }
    
    public void Font12(){
        textArea.setFont(new Font("Times New Roman", Font.BOLD, 12));
    }
    
    public void Font14(){
        textArea.setFont(new Font("Times New Roman", Font.BOLD, 14));
    }
    
    public void Font16(){
        textArea.setFont(new Font("Times New Roman", Font.BOLD, 16));
    }
    
    public void redFont(){
        textArea.setForeground(Color.red);
    }
    
    public void orangeFont(){
        textArea.setForeground(Color.orange);
    }
    
    public void yellowFont(){
        textArea.setForeground(Color.yellow);
    }
    
    public void greenFont(){
        textArea.setForeground(Color.green);
    }
    
    public void cyanFont(){
        textArea.setForeground(Color.cyan);
    }
    
    public void blueFont(){
        textArea.setForeground(Color.blue);
    }
    
    public void purpleFont(){
        textArea.setForeground(Color.magenta);
    }
    
    public void whiteFont(){
        textArea.setForeground(Color.white);
    }
    
    public void blackFont(){
        textArea.setForeground(Color.black);
    }
    
    public void customizationReset(){
        textArea.setBackground(Color.white);
        textArea.setFont(new Font("Times New Roman", Font.BOLD, 12));
        textArea.setForeground(Color.black);
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
