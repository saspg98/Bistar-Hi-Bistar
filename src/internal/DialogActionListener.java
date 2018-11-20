/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal;

import UI.MainForm;
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
import static custom.components.ModifyBookingDialogPanel.B_CALCULATE;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import verifyingTools.Verify;

/**
 *
 * @author Sarthak
 */
public class DialogActionListener implements ActionListener {

    GuestRoomDialogPanel guest;
    ModifyBookingDialogPanel book;
    FinalDialogPanel fin;
    MainForm mf;

    public DialogActionListener(GuestRoomDialogPanel guest, ModifyBookingDialogPanel book, FinalDialogPanel fin) {
        this.guest = guest;
        this.book = book;
        this.fin = fin;

        this.guest.addActionListener(this);
        this.book.addActionListener(this);
        this.fin.addActionListener(this);
    }

    public void setMf(MainForm mf) {
        this.mf = mf;
    }

   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            
            case B_CALCULATE:
                if (book.updateBooking()) {
                    book.getBooking().print();
                    Booking tempBooking = book.getBooking();
                    int tempNewPrice = Helper.calculatePrice(tempBooking);
                    book.getBooking().setPrice(tempNewPrice);
                    book.updateNewPrice(tempNewPrice);
                    book.setUpdate();
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Check out date should be after check in date", "Warning", JOptionPane.ERROR_MESSAGE);
                }
break;
            case B_UPDATE:
                Booking newR = book.getBooking(); //get from ModifyBookingPanel
                if( Helper.modifyBooking(newR)){
                    
                    JOptionPane.showMessageDialog(null, "Booking has been updated with same booking reference.","Booking Updated",JOptionPane.PLAIN_MESSAGE);
                    
                }else{
                    
                    JOptionPane.showMessageDialog(null,"Change the booking constraints","Booking cannot be updated.",JOptionPane.ERROR_MESSAGE);
                }
                 mf.refreshConfirmedBookings();
                ((JDialog) SwingUtilities.getAncestorOfClass(JDialog.class, book)).dispose();//Add null check!
                 book.setCalulate();
                System.out.println("DO NULL CHECK");
                break;
                
            case B_CANCEL:
                //dispose dialogBox(create public method in MainForm)
                ((JDialog) SwingUtilities.getAncestorOfClass(JDialog.class, book)).dispose();//Add null check!
                System.out.println("DO NULL CHECK");
                break;
                
            case G_UPDATE:
                //update booking object>refresh details>dispose dialog
                Booking temp = guest.getThisBooking();
                temp.setNumPeople(guest.getGuests());
                temp.setNumRooms(guest.getRooms());
                temp.setRoomType(guest.getRoomType());
    
                temp.setWaitlist(!Helper.checkBookingPossibility(temp));
                System.out.println("Warning refresh required!");
                //TODO: change this to refresh ui from Screen Manager!!
                guest.getMainFormReference().refreshHotelDetailsUI();
                ((JDialog) SwingUtilities.getAncestorOfClass(JDialog.class, guest)).dispose();//Add null check!
                System.out.println("DO NULL CHECK");
                break;
                
            case G_CANCEL:
                //dispose dialog

                ((JDialog) SwingUtilities.getAncestorOfClass(JDialog.class, guest)).dispose();//Add null check!
                System.out.println("DO NULL CHECK");
                break;

            case F_CONF:
                //create booking object>>add to database>>display booking reference>> dispose dialog
                String a = "NA",
                 p = "NA";

                a = fin.getAdharCardNumber();
                p = fin.getPanCardNumber();

                try {
                    if (a.equals("NA") && Verify.isValidPinCode(p) || p.equals("NA") && Verify.isValidAdhar(a)) {
                        System.err.println("adhaar is " + a + ", pan is " + p);
                        long ref = Helper.newBooking(fin.getBookingDetails());
                        if (ref > 0) {
                            JOptionPane.showMessageDialog(null,
                                    "Congratulations on your booking! Your booking reference is #" + ref, "Booking Confirmed- EzyBook", JOptionPane.PLAIN_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "There was some problem in the server. Please try again later", "Booking Confirmed- EzyBook", JOptionPane.PLAIN_MESSAGE);
                        }

                        ((JDialog) SwingUtilities.getAncestorOfClass(JDialog.class, fin)).dispose();//Add null check!
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a vaild Adhaar or Pan number",
                                "Invalid Pan or Adhaar number", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException numberFormatException) {
                    JOptionPane.showMessageDialog(null, "Please enter a vaild Adhaar or Pan number",
                            "Invalid Pan or Adhaar number", JOptionPane.ERROR_MESSAGE);

                }

                break;
                
            case F_CANCEL:

                ((JDialog) SwingUtilities.getAncestorOfClass(JDialog.class, fin)).dispose();//Add null check!
                System.out.println("DO NULL CHECK");
                break;
        }

    }

}
