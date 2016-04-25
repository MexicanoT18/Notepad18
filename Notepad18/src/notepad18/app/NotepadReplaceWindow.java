/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad18.app;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import java.util.*;

/**
 *
 * @author Gabriel Brito
 */
public class NotepadReplaceWindow extends JFrame implements ActionListener{
    
    private int HEIGHT = 200;
    private int WIDTH = 300;
    
    private JButton find;
    private JButton replace;
    
    private JTextField findText;
    private JTextField replaceText;
    
    private NotepadWindow notepadWindow;
    
    int aux = 0;
    boolean next = false;
    
    public NotepadReplaceWindow(NotepadWindow window) {
       this.setSize(WIDTH, HEIGHT);
       notepadWindow = window;
       
       JFrame frame = new JFrame();
       JPanel panel = new JPanel();
       panel.setBackground(Color.darkGray);
       JPanel main = new JPanel();
       JPanel buttons = new JPanel();
       buttons.setLayout(new GridLayout(4,1));
       find = new JButton("Find");
       find.addActionListener(this);
       buttons.add(find);
       replace = new JButton("Replace");
       replace.addActionListener(this);
       buttons.add(replace);
       panel.setSize(300,300);
       panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
       
       FlowLayout fl1 = new FlowLayout();
       JPanel panel1 = new JPanel();
       panel1.setLayout(fl1);
       JLabel find = new JLabel("Find: ");
       findText = new JTextField(15);
       panel1.add(find);
       panel1.add(findText);
       
       FlowLayout fl2 = new FlowLayout();
       JPanel panel2 = new JPanel();
       panel2.setLayout(fl2);
       JLabel replaceFor = new JLabel("Replace for: ");
       replaceText = new JTextField(15);
       panel2.add(replaceFor);
       panel2.add(replaceText);
       
       GridBagLayout layout = new GridBagLayout();
       
       GridBagConstraints cons = new GridBagConstraints();
       
       panel.add(panel1);
       panel.add(panel2);
       main.add(panel);
       main.add(buttons);
       this.add(main);
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == this.find){
            int lenText, lenLookFor, pos;
            
            String text = notepadWindow.getTextArea().getText();
            NotepadTextArea display = notepadWindow.getTextArea();
            String lookFor = findText.getText();
            
            lenText = text.length();
            lenLookFor = lookFor.length();
            
            JTextArea a = new JTextArea(12,10);
            //Varre o texto em busca das ocorrencias em lookFor
            pos = 1;
            if(next == false){
                aux = 0;
            }
            pos = text.indexOf(lookFor, aux);
            System.out.println("pos = "+Integer.toString(pos)+", aux = "+Integer.toString(aux)+", next = "+Boolean.toString(next));
            if(pos > 0){
                display.requestFocus();
                display.select(pos, pos+lenLookFor);
                aux = pos+lenLookFor+1;
                next = true;
            }else{
                display.requestFocus();
                display.select(0, 0);
                next = false;
                aux = 0;
                pos = 1;
            }
            
            //notepadWindow.getTextArea().setText("find");
        }
        else if(event.getSource() == this.replace){
            String text = notepadWindow.getTextArea().getText();
            String lookFor = findText.getText();
            String replaceFor = replaceText.getText();
            text = text.replace(lookFor, replaceFor);
            notepadWindow.getTextArea().setText(text);
            //notepadWindow.getTextArea().setText("replace");
        }
    }
}
