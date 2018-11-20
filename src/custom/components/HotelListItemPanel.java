package custom.components;

import UI.UIMethods;
import com.sun.corba.se.impl.logging.ORBUtilSystemException;
import internal.HotelDesc;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Sarthak
 */
/* The Design:
 * Pretty straightforward, the hotel name, price range, image are clickable and will lead the user to the hotel confirmation page
 * where they can choose their room type and proceed to checkout, clicking on a room type will lead to the same screen with the option
 * already selected. See reviews will load a hotel review page where the user can write their own reviews
 */
public class HotelListItemPanel extends javax.swing.JPanel {

    /**
     * Creates new form HotelListItemPanel
     */
    public static final String CURRENCY = "\u20B9";
    private MouseListener mouseListener;
    private final HotelDesc hotel;
    private static final String UNAVAILABEL_STRING = "<font color='#787878'>(Unavailable)</font>";
    private JLabel[] roomLinks;

    public void setMouseEventListener(MouseListener m) {
        
        priceRangeLabel.addMouseListener(m);
        hotelNameLabel.addMouseListener(m);
        imageLabel.addMouseListener(m);
        
        mouseListener = m;
    }
 
    public HotelListItemPanel(HotelDesc des, MouseListener m, double priceConstraint,boolean showAll) {
        initComponents();
        hotel = des;
        ratingLabel.setText("");
        setMouseEventListener(m);
        
        
        hotelNameLabel.setText(des.getHotelName());
        priceRangeLabel.setText(des.getPriceRange());
        addressLabel.setText(des.getAddress());
        ratingLabel.setText(UIMethods.getRatingString((int)(des.getRating().getOverallRating())));
        if (des.getBufferedImage() != null) {
            Image img = des.getBufferedImage().getScaledInstance(550, -1, Image.SCALE_SMOOTH);
            ImageIcon imgIcon = new ImageIcon(img);
            imageLabel.setIcon(imgIcon);

        }
 
        setRoomTypesDisplay(des, showAll, priceConstraint);
    }

    public void setRoomTypesDisplay(HotelDesc des, boolean showAll, double priceConstraint) {
        
        int[] types = des.getNumOfRoomTypes();
        double[] prices = des.getPrices();
        roomLinks = new JLabel[prices.length];

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.WEST;

        for (int i = 0; i < HotelDesc.ROOM_TYPES.length; i++) {
            if(prices[i]>priceConstraint)
                continue;
            if (!showAll && types[i] <= 0) {
                continue;
            }
            if(types[i]>0)//room type is available
                 roomLinks[i] = new JLabel("<html>" + HotelDesc.ROOM_TYPES[i] + " - " + "<font color='#00c600'>" + CURRENCY + prices[i] + "</font>" + "</html>");
            else//room type is unavailable
                 roomLinks[i] = new JLabel("<html>" + HotelDesc.ROOM_TYPES[i] + " - " + "<font color='#00c600'>" + CURRENCY + prices[i] + "</font>" + UNAVAILABEL_STRING + "</html>");
            roomLinks[i].setFont(mainFont); // NOI18N
            roomLinks[i].setForeground(textColor);
            roomLinks[i].setSize(30,30);
            roomLinks[i].setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
            roomLinks[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            roomLinks[i].setBorder(BorderFactory.createEmptyBorder(0, 0, 1, 0));
            roomLinks[i].setName("underline");
            roomLinks[i].addMouseListener(mouseListener);
            roomListPanel.add(roomLinks[i], gbc);
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
        centerPanel = new javax.swing.JPanel();
        roomListPanel = new javax.swing.JPanel();
        addressLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(25, 25, 25));
        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        imageLabel.setForeground(new java.awt.Color(255, 255, 255));
        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hotel.jpg"))); // NOI18N
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
        ratingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ratingLabel.setText("Rating");

        priceRangeLabel.setFont(new java.awt.Font("Lato", 0, 30)); // NOI18N
        priceRangeLabel.setForeground(new java.awt.Color(0, 198, 0));
        priceRangeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceRangeLabel.setText("Rs.300-500");
        priceRangeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        priceRangeLabel.setName("underlineText"); // NOI18N

        centerPanel.setBackground(new java.awt.Color(25, 25, 25));
        centerPanel.setLayout(new java.awt.GridBagLayout());

        roomListPanel.setBackground(new java.awt.Color(25, 25, 25));
        roomListPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        centerPanel.add(roomListPanel, gridBagConstraints);

        addressLabel.setFont(new java.awt.Font("Lato", 0, 30)); // NOI18N
        addressLabel.setForeground(new java.awt.Color(255, 255, 255));
        addressLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addressLabel.setText("Address");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                    .addComponent(ratingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hotelNameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                    .addComponent(centerPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addressLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(priceRangeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(ratingLabel)
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hotelNameLabel)
                        .addGap(7, 7, 7)
                        .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceRangeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(centerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private static final Font mainFont = new Font("Lato", 0, 24);
    private static final Color textColor = new Color(255, 255, 255);
    private static final Color AVAILABLE_COLOR = new Color(0, 198, 0);
    private static final Color UNAVAILABLE_COLOR = new Color(127, 127, 127);


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JLabel hotelNameLabel;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel priceRangeLabel;
    private javax.swing.JLabel ratingLabel;
    private javax.swing.JPanel roomListPanel;
    // End of variables declaration//GEN-END:variables

    public HotelDesc getHotelDesc() {
        return hotel;
    }

}
