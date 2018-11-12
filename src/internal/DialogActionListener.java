/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal;

import custom.components.GuestRoomDialogPanel;
import custom.components.ModifyDateDialogPanel;

import static custom.components.ModifyDateDialogPanel.D_UPDATE;
import static custom.components.ModifyDateDialogPanel.D_CANCEL;
import static custom.components.GuestRoomDialogPanel.G_UPDATE;
import static custom.components.GuestRoomDialogPanel.G_CANCEL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author Sarthak
 */
public class DialogActionListener implements ActionListener {
    
    GuestRoomDialogPanel guest;
    ModifyDateDialogPanel date;

    public DialogActionListener(GuestRoomDialogPanel date, ModifyDateDialogPanel guestRoom) {
        this.guest = date;
        this.date = guestRoom;
        
        this.guest.setActionListener(this);
        this.date.setActionListener(this);
    }


    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       switch(e.getActionCommand()){
           case D_UPDATE:
               break;
            case D_CANCEL:
               break;
            case G_UPDATE:
               break;
            case G_CANCEL:
               break;
       }
        
    }
    
}
