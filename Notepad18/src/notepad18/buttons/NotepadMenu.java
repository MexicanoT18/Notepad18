/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad18.buttons;

import java.awt.MenuBar;
import notepad18.app.NotepadWindow;

/**
 *
 * @author Lucas
 */
public class NotepadMenu extends MenuBar{
    
    FileMenu file = new FileMenu();
    NotepadWindow notepadWindow;
    
    public void initialize(NotepadWindow window){
        
        this.notepadWindow = window;
        
        file.initialize(this);
        this.add(file);
        
    }
    
    public void close(){
        notepadWindow.close();
    }
    
    public NotepadWindow getNotepadWindow(){
        return notepadWindow;
    }
    
}
