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
import notepad18.app.NotepadWindow;
import notepad18.app.NotepadReplaceWindow;

/**
 *
 * @author Lucas
 */
public class EditMenu extends Menu implements ActionListener{
    
    private MenuItem undo = new MenuItem();
    private MenuItem redo = new MenuItem();
    private MenuItem cut = new MenuItem();
    private MenuItem copy = new MenuItem();
    private MenuItem paste = new MenuItem();
    private MenuItem replace = new MenuItem();
    
    private NotepadMenu notepadMenu;
    private NotepadWindow notepadWindow;
    
    public void initialize(NotepadMenu menu){
        
        this.setLabel("Edit");
        
        this.notepadMenu = menu;
        this.notepadWindow = menu.getNotepadWindow();
        
        undo.setLabel("Undo");
        undo.addActionListener(this);
        this.add(undo);
        
        redo.setLabel("Redo");
        redo.addActionListener(this);
        this.add(redo);
        
        cut.setLabel("Cut");
        cut.addActionListener(this);
        this.add(cut);
        
        copy.setLabel("Copy");
        copy.addActionListener(this);
        this.add(copy);
        
        paste.setLabel("Paste");
        paste.addActionListener(this);
        this.add(paste);
        
        replace.setLabel("Replace");
        replace.addActionListener(this);
        this.add(replace);
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        if (event.getSource() == this.undo){
            try{
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_Z);
            } catch (AWTException e){
                System.out.println("Failed to create robot");
            }
        }
        
        else if (event.getSource() == this.redo){
            try{
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_Y);
            } catch (AWTException e){
                System.out.println("Failed to create robot");
            }
        }
        
        else if (event.getSource() == this.cut){
            try{
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_X);
            } catch (AWTException e){
                System.out.println("Failed to create robot");
            }
        }
        
        else if (event.getSource() == this.copy){
            try{
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_C);
            } catch (AWTException e){
                System.out.println("Failed to create robot");
            }
        }
        
        else if (event.getSource() == this.paste){
            try{
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
            } catch (AWTException e){
                System.out.println("Failed to create robot");
            }
        }
        
        else if(event.getSource() == this.replace){
            NotepadReplaceWindow windReplace = new NotepadReplaceWindow(this.notepadWindow);
            windReplace.setVisible(true);
        }
    }
    
}
