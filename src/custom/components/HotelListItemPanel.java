package custom.components;

import UI.UIMethods;
import internal.HotelDesc;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 *
 * @author Sarthak
 */



/* The Design:
 * Pretty straightforward, the hotel name, price range, image are clickable and will lead the user to the hotel confirmation page
 * where they can choose their room type and proceed to checkout, clicking on a room type will lead to the same screen with the option
 * already selected. See reviews will load a hotel review page where the user can write their own reviews
 *
 * TODO: Fix bug:When a new line is added to the typeLabel, the size of the panel doesn't change, but it does when a new
 * line is added to the priceLabel
 */
public class HotelListItemPanel extends javax.swing.JPanel {

    /**
     * Creates new form HotelListItemPanel
     */
    
    private static final String CURRENCY = "\u20B9";
    private MouseListener mouseListener;
    private int index;
    private HotelDesc hotel;
    
    
    private JLabel[] roomLinks;
    
    
    public void setMouseEventListener(MouseListener m){
        //reviewLinkLabel.addMouseListener(m); //IMP! create a review page for this!
        priceRangeLabel.addMouseListener(m);
        hotelNameLabel.addMouseListener(m);
        imageLabel.addMouseListener(m);
        mouseListener = m;
    }
    
    
    
    //TODO: Main Constructor, merge with setDetails 
    public HotelListItemPanel(HotelDesc des,MouseListener m, int index, boolean showAll) {
        initComponents();
        hotel = des;
        ratingLabel.setText("");
        setMouseEventListener(m);
        this.index=index;

        
        setDetails(des, showAll);
    }
    
    public int getIndex(){
        return index;
    }
    //TODO: Merge with constructor!!
    public void setDetails(HotelDesc des, boolean showAll){
        hotelNameLabel.setText(des.getHotelName());
        priceRangeLabel.setText(des.getPriceRange());
        addressLabel.setText(des.getAddress());
        ratingLabel.setText(UIMethods.getRatingString(des.getStars()));
        if(des.isAvailable()){
            availabilityLabel.setForeground(AVAILABLE_COLOR);
            availabilityLabel.setText("Available");
        } else{
            availabilityLabel.setForeground(UNAVAILABLE_COLOR);
            availabilityLabel.setText("Unavailable");
        }
        int[] types = des.getRoomTypes();
        double[] prices = des.getPrices();
        roomLinks = new JLabel[prices.length];
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.WEST;
        

        
            for(int i=0;i<HotelDesc.ROOM_TYPES.length;i++){
                if(types[i]>0){
                    roomLinks[i] = new JLabel("<html>"+HotelDesc.ROOM_TYPES[i]+" - "+"<font color='#00c600'>"+CURRENCY+prices[i]+"</font>"+"</html>");
                    roomLinks[i].setFont(mainFont); // NOI18N
                    roomLinks[i].setForeground(textColor);
                    roomLinks[i].setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                    roomLinks[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    roomLinks[i].setBorder(BorderFactory.createEmptyBorder(0, 0, 1, 0));
                    roomLinks[i].setName("underline");

                    roomLinks[i].addMouseListener(mouseListener);
            
                    roomListPanel.add(roomLinks[i],gbc);
                } else if(showAll){
                    roomLinks[i] = new JLabel("<html>"+HotelDesc.ROOM_TYPES[i]+" - "+"<font color='#00c600'>"+CURRENCY+prices[i]+"</font>"+"<font color='#787878'>(Unavailable)</font>s</html>");
                    roomLinks[i].setFont(mainFont); // NOI18N
                    roomLinks[i].setForeground(textColor);
                    roomLinks[i].setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                    roomLinks[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    roomLinks[i].setBorder(BorderFactory.createEmptyBorder(0, 0, 1, 0));
                    roomLinks[i].setName("underline");

                    roomLinks[i].addMouseListener(mouseListener);
            
                    roomListPanel.add(roomLinks[i],gbc);
                    
                }
            }
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        imageLabel = new javax.swing.JLabel();
        hotelNameLabel = new javax.swing.JLabel();
        ratingLabel = new javax.swing.JLabel();
        priceRangeLabel = new javax.swing.JLabel();
        reviewLinkLabel = new javax.swing.JLabel();
        centerPanel = new javax.swing.JPanel();
        roomListPanel = new javax.swing.JPanel();
        addressLabel = new javax.swing.JLabel();
        availabilityLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(25, 25, 25));
        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        imageLabel.setForeground(new java.awt.Color(255, 255, 255));
        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hotel.jpg"))); // NOI18N
        imageLabel.setText("Image");
        imageLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        imageLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        imageLabel.setName("dontUnderline"); // NOI18N

        hotelNameLabel.setFont(new java.awt.Font("Lato Black", 0, 48)); // NOI18N
        hotelNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        hotelNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hotelNameLabel.setText("Hotel Transylvania");
        hotelNameLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hotelNameLabel.setName("dontUnderline"); // NOI18N

        ratingLabel.setFont(new java.awt.Font("FreeMono", 0, 36)); // NOI18N
        ratingLabel.setForeground(new java.awt.Color(255, 255, 0));
        ratingLabel.setText("Rating");

        priceRangeLabel.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        priceRangeLabel.setForeground(new java.awt.Color(0, 198, 0));
        priceRangeLabel.setText("Rs.300-500");
        priceRangeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        priceRangeLabel.setName("underline"); // NOI18N

        reviewLinkLabel.setBackground(new java.awt.Color(255, 255, 255));
        reviewLinkLabel.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        reviewLinkLabel.setForeground(new java.awt.Color(255, 255, 255));
        reviewLinkLabel.setText("See reviews");
        reviewLinkLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 1, 0));
        reviewLinkLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reviewLinkLabel.setName("underline"); // NOI18N

        centerPanel.setBackground(new java.awt.Color(25, 25, 25));
        centerPanel.setLayout(new java.awt.GridBagLayout());

        roomListPanel.setBackground(new java.awt.Color(25, 25, 25));
        roomListPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        centerPanel.add(roomListPanel, gridBagConstraints);

        addressLabel.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        addressLabel.setForeground(new java.awt.Color(255, 255, 255));
        addressLabel.setText("Address");

        availabilityLabel.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        availabilityLabel.setForeground(new java.awt.Color(0, 198, 0));
        availabilityLabel.setText("Available");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hotelNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ratingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(reviewLinkLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(priceRangeLabel))
                    .addComponent(centerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addressLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(availabilityLabel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hotelNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressLabel)
                            .addComponent(availabilityLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(centerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ratingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reviewLinkLabel)
                    .addComponent(priceRangeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private static final Font mainFont = new Font("Lato", 0, 24);
    private static final Color textColor = new Color(255, 255, 255);
    private static final Color AVAILABLE_COLOR = new Color(0,198,0);
    private static final Color UNAVAILABLE_COLOR = new Color(127,127,127);
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel availabilityLabel;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JLabel hotelNameLabel;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel priceRangeLabel;
    private javax.swing.JLabel ratingLabel;
    private javax.swing.JLabel reviewLinkLabel;
    private javax.swing.JPanel roomListPanel;
    // End of variables declaration//GEN-END:variables

    public HotelDesc getHotelDesc() {
        return hotel;
    }

    
}
