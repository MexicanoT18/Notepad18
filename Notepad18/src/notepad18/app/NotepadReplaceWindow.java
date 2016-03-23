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

/**
 *
 * @author Gabriel Brito
 */
public class NotepadReplaceWindow extends JFrame{
    
    private int HEIGHT = 200;
    private int WIDTH = 300;
    
    public NotepadReplaceWindow() {
       this.setSize(WIDTH, HEIGHT);
       
       JFrame frame = new JFrame();
       JPanel panel = new JPanel();
       panel.setBackground(Color.darkGray);
       JPanel main = new JPanel();
       JPanel buttons = new JPanel();
       buttons.setLayout(new GridLayout(4,1));
       buttons.add(new JButton("Button 1"));
       buttons.add(new JButton("Button 2"));
       buttons.add(new JButton("Button 3"));
       buttons.add(new JButton("Button 4"));
       panel.setSize(300,300);
       panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
       
       FlowLayout fl1 = new FlowLayout();
       JPanel panel1 = new JPanel();
       panel1.setLayout(fl1);
       JLabel find = new JLabel("Find: ");
       JTextField findText = new JTextField(15);
       panel1.add(find);
       panel1.add(findText);
       
       FlowLayout fl2 = new FlowLayout();
       JPanel panel2 = new JPanel();
       panel2.setLayout(fl2);
       JLabel replaceFor = new JLabel("Replace for: ");
       JTextField replaceText = new JTextField(15);
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
    
}
