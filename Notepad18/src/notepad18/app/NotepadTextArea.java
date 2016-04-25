/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad18.app;

import java.awt.Font;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.text.html.*;

/**
 *
 * @author Lucas
 * 
 * Trabalha com tudo relacionado ao texto. É um objeto TextArea.
 * 
 */
public class NotepadTextArea extends JTextPane{
    
    boolean inProgress = false;
    
    public NotepadTextArea(){
        super();
        //super("", 0,0, JTextArea.SCROLLBARS_VERTICAL_ONLY);
        
        this.setFont(new Font("Times New Roman", Font.BOLD, 12));
        
    }
    
    public void append (String s){
        setText (getText() + s);
    }
    
    public void initListener() {
        getDocument().addDocumentListener(new DocumentListener(){
            public void insertUpdate(DocumentEvent docEv) {
                final DocumentEvent e=docEv;
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        if (e.getDocument() instanceof HTMLDocument
                                && e.getOffset()>0
                                && e.getLength()==1
                                && !inProgress) {
                            try {

                                HTMLDocument doc = (HTMLDocument)e.getDocument();
                                String text = doc.getText(e.getOffset(), e.getLength());
                                
                                if (text.charAt(0)==' ' || text.charAt(0)=='\n' || text.charAt(0)=='\t') {
                                    int start = Utilities.getWordStart(NotepadTextArea.this, e.getOffset()-1);
                                    text=doc.getText(start, e.getOffset()-start);
                                    
                                    if (text.startsWith("www")) {
                                        inProgress=true;
                                        HTMLEditorKit kit=(HTMLEditorKit)getEditorKit();
                                        
                                        SimpleAttributeSet sas = new SimpleAttributeSet();
                                        sas.addAttribute("EASTER", "EGG");
                                        doc.setCharacterAttributes(start, text.length(), sas, false);
 
                                        Element elem=doc.getCharacterElement(start);
                                        String html = "<a href=\"http://" + text + "\">" + text + "</a>";
                                        doc.setOuterHTML(elem, html);
                                        inProgress=false;
                                    }
                                }
                                
                            } catch (Exception exc) {
                                exc.printStackTrace();
                            }
                        }
                    }
                });
            }
            
            public void removeUpdate(DocumentEvent e) {
            }
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }
    
}
