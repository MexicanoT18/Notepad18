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
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLDocument;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import notepad18.app.NotepadTextArea;
import notepad18.app.NotepadWindow;
import notepad18.app.NotepadReplaceWindow;

/**
 *
 * @author Lucas
 */
public class EditMenu extends Menu implements ActionListener{
    
    private MenuItem undo = new MenuItem();
    private UndoManager undoManager = new UndoManager();
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
        
        HTMLDocument doc;
        doc = (HTMLDocument)notepadWindow.getTextArea().getDocument();
        doc.addUndoableEditListener(new UndoableEditListener() {
           public void undoableEditHappened (UndoableEditEvent e){
               undoManager.addEdit(e.getEdit());
           } 
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        if (event.getSource() == this.undo){
            try{
                if (undoManager.canUndo()){
                    undoManager.undo();
                }
            } catch (CannotUndoException e){
                System.out.println("Failed to undo");
            }
        }
        
        else if (event.getSource() == this.redo){
            try{
                if (undoManager.canRedo()){
                    undoManager.redo();
                }
            } catch (CannotUndoException e){
                System.out.println("Failed to redo");
            }
        }
        
        else if (event.getSource() == this.cut){
            try{
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_X);
                robot.keyRelease(KeyEvent.VK_CONTROL);
            } catch (AWTException e){
                System.out.println("Failed to create robot");
            }
        }
        
        else if (event.getSource() == this.copy){
            try{
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_C);
                robot.keyRelease(KeyEvent.VK_CONTROL);
            } catch (AWTException e){
                System.out.println("Failed to create robot");
            }
        }
        
        else if (event.getSource() == this.paste){
            try{
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
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
