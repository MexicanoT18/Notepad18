/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad18.buttons;

import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;
import notepad18.app.NotepadWindow;

/**
 *
 * @author Lucas
 * 
 * Menu File. Guarda as opções "Open", "Save" e "Close".
 * 
 */
public class FileMenu extends Menu implements ActionListener{
    
    private MenuItem openFile = new MenuItem();
    private MenuItem saveFile = new MenuItem();
    private MenuItem saveAsFile = new MenuItem();
    private MenuItem close = new MenuItem();
    private MenuItem newFile = new MenuItem();
    
    private NotepadMenu notepadMenu;
    private NotepadWindow notepadWindow;
    
    private JFileChooser save;
    
    public void initialize(NotepadMenu menu){
        
        this.setLabel("File");
        
        newFile.setLabel("New");
        newFile.addActionListener(this);
        newFile.setShortcut(new MenuShortcut(KeyEvent.VK_N, false));
        this.add(newFile);
        
        openFile.setLabel("Open...");
        openFile.addActionListener(this);
        openFile.setShortcut(new MenuShortcut(KeyEvent.VK_O, false));
        this.add(openFile);
        
        saveFile.setLabel("Save");
        saveFile.addActionListener(this);
        saveFile.setShortcut(new MenuShortcut(KeyEvent.VK_S, false));
        this.add(saveFile);
        
        saveAsFile.setLabel("Save As...");
        saveAsFile.addActionListener(this);
        this.add(saveAsFile);
        
        close.setLabel("Exit");
        close.addActionListener(this);
        close.setShortcut(new MenuShortcut(KeyEvent.VK_F4, false));
        this.add(close);
        
        this.notepadMenu = menu;
        this.notepadWindow = menu.getNotepadWindow();
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        
        if (event.getSource() == this.close){
            notepadMenu.close();
        }
        
        else if (event.getSource() == this.openFile) {
            JFileChooser open = new JFileChooser();
            int option = open.showOpenDialog(notepadMenu.getNotepadWindow());
            if (option == JFileChooser.APPROVE_OPTION) {
		notepadWindow.getTextArea().setText("");
		try {
                    Scanner scan = new Scanner(new FileReader(open.getSelectedFile().getPath()));
                    while (scan.hasNext()) notepadWindow.getTextArea().append(scan.nextLine() + "\n"); // append the line to the TextArea
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
		}
            }
	} 
        
	else if (event.getSource() == this.saveAsFile) {
            save = new JFileChooser();
            int option = save.showSaveDialog(notepadWindow);
            if (option == JFileChooser.APPROVE_OPTION) {
		try {
                    BufferedWriter out = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
                    String str = notepadWindow.getTextArea().getText();
                    for(int i=0; i<str.length(); i++){
                        if (str.charAt(i)=='\n'){
                            out.newLine();
                        }
                        else out.write(str.charAt(i));
                    }
                    //out.write(notepadWindow.getTextArea().getText());
                    out.close();
		} catch (Exception ex) {
                    System.out.println(ex.getMessage());
		}
            }
	}
        
        else if (event.getSource() == this.saveFile){
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
                String str = notepadWindow.getTextArea().getText();
                for(int i=0; i<str.length(); i++){
                    if (str.charAt(i)=='\n'){
                        out.newLine();
                    }
                    else out.write(str.charAt(i));
                }
                //out.write(notepadWindow.getTextArea().getText());
                out.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        else if(event.getSource() == this.newFile){
            notepadWindow.resetText();
        }
        
    }
    
}
