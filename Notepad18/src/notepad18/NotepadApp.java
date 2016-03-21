/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad18;

import notepad18.app.MainWindow;

/**
 *
 * @author Lucas
 */
public class NotepadApp {

    /**
     * @param args the command line arguments
     */
    
    static MainWindow mainWindow;
    
    public static void main(String[] args) {
        
        mainWindow = new MainWindow();
        mainWindow.setVisible(true);
        
    }
    
}
