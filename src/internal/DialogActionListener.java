/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal;

import bridge.Helper;
import custom.components.FinalDialogPanel;
import static custom.components.FinalDialogPanel.F_CANCEL;
import static custom.components.FinalDialogPanel.F_CONF;
import custom.components.GuestRoomDialogPanel;
import custom.components.ModifyBookingDialogPanel;
import static custom.components.GuestRoomDialogPanel.G_UPDATE;
import static custom.components.GuestRoomDialogPanel.G_CANCEL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static custom.components.ModifyBookingDialogPanel.B_UPDATE;
import static custom.components.ModifyBookingDialogPanel.B_CANCEL;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Sarthak
 */
public class DialogActionListener implements ActionListener {
    
    GuestRoomDialogPanel guest;
    ModifyBookingDialogPanel book;
    FinalDialogPanel fin;

    public DialogActionListener(GuestRoomDialogPanel guest, ModifyBookingDialogPanel book, FinalDialogPanel fin) {
        this.guest = guest;
        this.book = book;
        this.fin = fin;
        
        this.guest.addActionListener(this);
        this.book.addActionListener(this);
        this.fin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       switch(e.getActionCommand()){
           case B_UPDATE:
               Booking old =book.getBooking();
               Booking newR;//get from ModifyBookingPanel
                
               ((JDialog)SwingUtilities.getAncestorOfClass(JDialog.class, book)).dispose();//Add null check!
               System.out.println("DO NULL CHECK");
               break;
            case B_CANCEL:
                //dispose dialogBox(create public method in MainForm)
               ((JDialog)SwingUtilities.getAncestorOfClass(JDialog.class, book)).dispose();//Add null check!
               System.out.println("DO NULL CHECK");
               break;
            case G_UPDATE:
                //update booking object>refresh details>dispose dialog
                Booking temp = guest.getThisBooking();
                temp.setNumPeople(guest.getGuests());
                temp.setNumRooms(guest.getRooms());
                temp.setRoomType(guest.getRoomType());
                //TODO! Check if new Booking can be confirmed or should be watilisted
                //Helper.checkWaitList(temp);
                System.out.println("Warning refresh required!");
                //TODO: change this to refresh ui from Screen Manager!!
                guest.getMainFormReference().refreshHotelDetailsUI();
                ((JDialog)SwingUtilities.getAncestorOfClass(JDialog.class, guest)).dispose();//Add null check!
               System.out.println("DO NULL CHECK");
               break;
            case G_CANCEL:
                //dispose dialog
                
               ((JDialog)SwingUtilities.getAncestorOfClass(JDialog.class, guest)).dispose();//Add null check!
               System.out.println("DO NULL CHECK");
               break;
               
               
            case F_CONF:
                //create booking object>>add to database>>display booking reference>> dispose dialog
                
                //replace with actual method
                long ref = Helper.updateBooking(fin.getBookingDetails());
                if(ref>0)
                JOptionPane.showMessageDialog(null, 
                        "Congratulations on your booking! Your booking reference is #" + ref, "Booking Confirmed- EzyBook", JOptionPane.PLAIN_MESSAGE);
                
                else 
                JOptionPane.showMessageDialog(null, 
                        "There was some problem in the server. Please try again later", "Booking Confirmed- EzyBook", JOptionPane.PLAIN_MESSAGE);
                
                
               ((JDialog)SwingUtilities.getAncestorOfClass(JDialog.class, fin)).dispose();//Add null check!
               System.out.println("DO NULL CHECK");
               break;
            case F_CANCEL:

               ((JDialog)SwingUtilities.getAncestorOfClass(JDialog.class, fin)).dispose();//Add null check!
               System.out.println("DO NULL CHECK");
               break;
       }
        
    }
    
}
