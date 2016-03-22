/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad18;

import notepad18.app.NotepadWindow;

/**
 *
 * @author Lucas
 */
public class NotepadApp {

    /**
     * @param args the command line arguments
     */
    
    static NotepadWindow notepadWindow;
    
    public static void main(String[] args) {
        
        notepadWindow = new NotepadWindow();
        notepadWindow.setVisible(true);
        
    }
    
}
