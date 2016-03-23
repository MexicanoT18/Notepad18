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
 * 
 * Administra todas as opções de menu: aqueles painéis do topo
 * com os nomes "File", etc...
 * 
 * Serve como intermédio para a comunicação entre esses menus e a classe principal
 * NotepadWindow.
 * 
 */
public class NotepadMenu extends MenuBar{
    
    FileMenu file = new FileMenu();
    EditMenu edit = new EditMenu();
    
    NotepadWindow notepadWindow;
    
    public void initialize(NotepadWindow window){
        
        this.notepadWindow = window;
        
        file.initialize(this);
        this.add(file);
        
        edit.initialize(this);
        this.add(edit);
        
    }
    
    public void close(){
        notepadWindow.close();
    }
    
    public NotepadWindow getNotepadWindow(){
        return notepadWindow;
    }
    
}
