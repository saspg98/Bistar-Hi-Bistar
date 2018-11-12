/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal;

import custom.components.GuestRoomDialogPanel;
import custom.components.ModifyBookingDialogPanel;
import static custom.components.ModifyBookingDialogPanel.D_UPDATE;
import static custom.components.ModifyBookingDialogPanel.D_CANCEL;
import static custom.components.GuestRoomDialogPanel.G_UPDATE;
import static custom.components.GuestRoomDialogPanel.G_CANCEL;
import static custom.components.PastBookingListPanel.P_CANCEL;
import static custom.components.PastBookingListPanel.P_UPDATE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Sarthak
 */
public class DialogActionListener implements ActionListener {
    
    GuestRoomDialogPanel guest;
    ModifyBookingDialogPanel date;

    public DialogActionListener(GuestRoomDialogPanel date, ModifyBookingDialogPanel guestRoom) {
        this.guest = date;
        this.date = guestRoom;
        
        this.guest.setActionListener(this);
        this.date.setActionListener(this);
    }


    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       switch(e.getActionCommand()){
           case D_UPDATE:
               //update details in database>refresh mainForm>dispose dialog
               break;
            case D_CANCEL:
                //dispose dialogBox(create public method in MainForm)
               break;
            case G_UPDATE:
                //update booking object>refresh details>dispose dialog
               break;
            case G_CANCEL:
                //dispose dialog
               break;
       }
        
    }
    
}
