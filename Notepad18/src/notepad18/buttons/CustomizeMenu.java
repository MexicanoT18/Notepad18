/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad18.buttons;

import java.awt.AWTException;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;
import notepad18.app.NotepadWindow;

/**
 *
 * @author Gabriela
 */
public class CustomizeMenu extends Menu implements ActionListener {
    
    private Menu background = new Menu();
    private Menu fontsize = new Menu();
    private Menu fontcolor = new Menu();
    private MenuItem reset = new MenuItem();
    
    private MenuItem whitebg = new MenuItem();
    private MenuItem blackbg = new MenuItem();
    

    private MenuItem font14 = new MenuItem();
    private MenuItem font16 = new MenuItem();
    private MenuItem font18 = new MenuItem();
    private MenuItem font20 = new MenuItem();
    private MenuItem font22 = new MenuItem();
    
    private MenuItem redtext = new MenuItem();
    private MenuItem orangetext = new MenuItem();
    private MenuItem yellowtext = new MenuItem();
    private MenuItem greentext = new MenuItem();
    private MenuItem cyantext = new MenuItem();
    private MenuItem bluetext = new MenuItem();
    private MenuItem purpletext = new MenuItem();
    private MenuItem whitetext = new MenuItem();
    private MenuItem blacktext = new MenuItem();
    
    
    private NotepadMenu notepadMenu;
    private NotepadWindow notepadWindow;
    
    public void initialize(NotepadMenu menu){
        
        this.setLabel("Customize");
        
        this.notepadMenu = menu;
        this.notepadWindow = menu.getNotepadWindow();
        
        background.setLabel("Backgroung Color");
        background.addActionListener(this);
        this.add(background);
        
        fontsize.setLabel("Font Size");
        fontsize.addActionListener(this);
        this.add(fontsize);
        
        fontcolor.setLabel("Font Color");
        fontcolor.addActionListener(this);
        this.add(fontcolor);
        
        reset.setLabel("Reset");
        reset.addActionListener(this);
        this.add(reset);
        
        whitebg.setLabel("White");
        whitebg.addActionListener(this);
        background.add(whitebg);
        
        blackbg.setLabel("Black");
        blackbg.addActionListener(this);
        background.add(blackbg);
        
        font14.setLabel("14");
        font14.addActionListener(this);
        fontsize.add(font14);
        
        font16.setLabel("16");
        font16.addActionListener(this);
        fontsize.add(font16);
        
        font18.setLabel("18");
        font18.addActionListener(this);
        fontsize.add(font18);
        
        font20.setLabel("20");
        font20.addActionListener(this);
        fontsize.add(font20);
        
        font22.setLabel("22");
        font22.addActionListener(this);
        fontsize.add(font22);
        
        redtext.setLabel("Red");
        redtext.addActionListener(this);
        fontcolor.add(redtext);
        
        orangetext.setLabel("Orange");
        orangetext.addActionListener(this);
        fontcolor.add(orangetext);
        
        yellowtext.setLabel("Yellow");
        yellowtext.addActionListener(this);
        fontcolor.add(yellowtext);
        
        greentext.setLabel("Green");
        greentext.addActionListener(this);
        fontcolor.add(greentext);
        
        cyantext.setLabel("Cyan");
        cyantext.addActionListener(this);
        fontcolor.add(cyantext);
        
        bluetext.setLabel("Blue");
        bluetext.addActionListener(this);
        fontcolor.add(bluetext);
        
        purpletext.setLabel("Purple");
        purpletext.addActionListener(this);
        fontcolor.add(purpletext);
        
        whitetext.setLabel("White");
        whitetext.addActionListener(this);
        fontcolor.add(whitetext);
        
        blacktext.setLabel("Black");
        blacktext.addActionListener(this);
        fontcolor.add(blacktext);
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        if (event.getSource() == this.background){
            
        }
        else if (event.getSource() == this.whitebg){
            notepadWindow.whiteBackground();
        }
        else if (event.getSource() == this.blackbg){
            notepadWindow.blackBackground();
        }
        else if (event.getSource() == this.fontsize){
            
        }
        else if (event.getSource() == this.font14){
            notepadWindow.Font14();
        }
        else if (event.getSource() == this.font16){
            notepadWindow.Font16();
        }
        else if (event.getSource() == this.font18){
            notepadWindow.Font18();
        }
        else if (event.getSource() == this.font20){
            notepadWindow.Font20();
        }
        else if (event.getSource() == this.font22){
            notepadWindow.Font22();
        }
        else if (event.getSource() == this.fontcolor){
            
        }
        else if (event.getSource() == this.redtext){
            notepadWindow.redFont();
        }
        else if (event.getSource() == this.orangetext){
            notepadWindow.orangeFont();
        }
        else if (event.getSource() == this.yellowtext){
            notepadWindow.yellowFont();
        }
        else if (event.getSource() == this.greentext){
            notepadWindow.greenFont();
        }
        else if (event.getSource() == this.cyantext){
            notepadWindow.cyanFont();
        }
        else if (event.getSource() == this.bluetext){
            notepadWindow.blueFont();
        }
        else if (event.getSource() == this.purpletext){
            notepadWindow.purpleFont();
        }
        else if (event.getSource() == this.whitetext){
            notepadWindow.whiteFont();
        }
        else if (event.getSource() == this.blacktext){
            notepadWindow.blackFont();
        }
        else if (event.getSource() == this.reset){
            notepadWindow.customizationReset();
        }
    }
}