/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal;

import custom.components.GuestRoomDialogPanel;
import custom.components.ModifyBookingDialogPanel;
import static custom.components.GuestRoomDialogPanel.G_UPDATE;
import static custom.components.GuestRoomDialogPanel.G_CANCEL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static custom.components.ModifyBookingDialogPanel.B_UPDATE;
import static custom.components.ModifyBookingDialogPanel.B_CANCEL;

/**
 *
 * @author Sarthak
 */
public class DialogActionListener implements ActionListener {
    
    GuestRoomDialogPanel guest;
    ModifyBookingDialogPanel book;

    public DialogActionListener(GuestRoomDialogPanel date, ModifyBookingDialogPanel guestRoom) {
        this.guest = date;
        this.book = guestRoom;
        
        this.guest.setActionListener(this);
        this.book.setActionListener(this);
    }


    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       switch(e.getActionCommand()){
           case B_UPDATE:
               BookedRooms old =book.getBooking();
               BookedRooms newR;//get from ModifyBookingPanel
               break;
            case B_CANCEL:
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
