/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import custom.components.HotelListItemPanel;
import custom.components.PastBookingListPanel;
import internal.Booking;
import internal.HotelDesc;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Sarthak
 */
public class UIMethods {
    final static int UNDERLINE_OFF=-1;
    final static Color defaultPanelButtonColor = new Color(59,35,59);
    
    
    private static final Color defaultButtonColor = new Color(59,35,59);
    private static final Color pressedButtonColor = new Color(36,119,119);
    private static final Color hoverButtonColor = new Color(45,27,45);
    
    private static final Color defaultButtonFontColor = new Color(191,191,191);
    private static final Color pressedButtonFontColor = new Color(250,250,250);
    
    
    private static final Font defaultButtonFont = new Font("Lato", Font.PLAIN, 24);
    private static final Font pressedButtonFont = new Font("Lato Black", Font.PLAIN, 24);
    
    
    private static final String STAR = "\u2605";
    private static final String EMPTY_STAR = "\u2606";
 
    public static void underline(JLabel label){
        Font font = label.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        label.setFont(font.deriveFont(attributes));
    }
    
    public static void removeUnderline(JLabel label){
        Font font = label.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
        attributes.put(TextAttribute.UNDERLINE, UNDERLINE_OFF);
        label.setFont(font.deriveFont(attributes));
    }

    public static void resetPanelButtons() {
        //implement using an array of panel buttons, i.e. labels and panels
    }

    public static void setSelectedPanelButton(JPanel panelButton, JLabel label) {
        panelButton.setBackground(pressedButtonColor);
        label.setForeground(pressedButtonFontColor);
        label.setFont(pressedButtonFont);
    }
    
    public static void setHoveredPanelButton(JPanel panelButton,boolean b) {
        if(b)
            panelButton.setBackground(hoverButtonColor);
        else 
            panelButton.setBackground(defaultButtonColor);
    }
    
    
    public static String getRatingString(int stars){
        StringBuilder s = new StringBuilder();
        System.err.println("Number of stars are "+stars);
        for(int i=0;i<stars;i++)
            s.append(STAR);
        for(int i=stars;i<5;i++)
            s.append(EMPTY_STAR);
        
        return s.toString();
    }
    
    public static String getStarString(){
        return STAR;
    }
    
    public static String getEmptyStarString(){
        return EMPTY_STAR;
    }
    
    
    public static PastBookingListPanel[] createBookingListPanels(Booking[] items, String type, ActionListener actionListener){
        PastBookingListPanel[] itemPanels = new PastBookingListPanel[items.length];
        for(int i=0;i<items.length;i++){
            itemPanels[i] = new PastBookingListPanel(items[i], type, actionListener);
        }
        return itemPanels;
    }

    public static HotelListItemPanel[] createHotelListItemPanels(ArrayList<HotelDesc> hotels, MouseListener m,double priceConstraint ,boolean showAll ){
        
        Iterator itr = hotels.iterator(); 
        while (itr.hasNext()) 
        { 
            HotelDesc hotel= (HotelDesc)itr.next();
            if(!hotel.isHotelAvailable())
                itr.remove();//remove hotel if no rooms are available at all
            else if(hotel.getPrices()[3]>priceConstraint){
                itr.remove();//remove hotel if the least expensive room is more expensive than the max price
            }
        } 
        
        
        HotelListItemPanel[] resultList = new HotelListItemPanel[hotels.size()];
        for (int i = 0; i < hotels.size(); i++) {
      
            resultList[i] = new HotelListItemPanel(hotels.get(i), m,priceConstraint,showAll);
        }
        
        return resultList;
    }
}
