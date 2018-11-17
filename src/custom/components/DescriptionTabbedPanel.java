/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custom.components;

import internal.Rating;
import java.awt.Dimension;
import javax.swing.JLabel;

/**
 *
 * @author Sarthak
 */
public class DescriptionTabbedPanel extends javax.swing.JPanel {

    /**
     * Creates new form DescriptionTabbedPanel
     */
    public DescriptionTabbedPanel() {
        initComponents();
        //Changing Size of the Tabs!
        JLabel lab = new JLabel("Description");
        lab.setPreferredSize(new Dimension(200, 30));
        lab.setFont(new java.awt.Font("Lato Black", 0, 36)); // NOI18N
        jTabbedPane1.setTabComponentAt(0, lab);  // tab index, jLabel
        
        JLabel lab2 = new JLabel();
        lab2.setPreferredSize(new Dimension(200, 30));
        lab2.setFont(new java.awt.Font("Lato Black", 0, 36)); // NOI18N
        lab2.setText("Amenities");
        jTabbedPane1.setTabComponentAt(1, lab2);
        
        JLabel lab3 = new JLabel();
        lab3.setPreferredSize(new Dimension(200, 30));
        lab3.setFont(new java.awt.Font("Lato Black", 0, 36)); // NOI18N
        lab3.setText("Reviews");
        jTabbedPane1.setTabComponentAt(2, lab3);

    }

    public void setDescription(String des, String amen, Rating rating) {
        descriptionTextArea.setText(des);
        amenitiesTA.setText(amen);
        //add support for rating
        //dummy
        
        
        overallRatingLabel.setText("Rating("+String.format("%,.1f",rating.getOverallRating())+")");
        ratingDistributionLabel.setText("Excellent("+rating.getExcellentCount()+
                "),Very Good("+rating.getVeryGoodCount()+
                "),Average("+rating.getAverageCount()+
                "),Poor("+rating.getPoorCount()+
                "),Terrible("+rating.getTerribleCount()+")");
       
        jTabbedPane1.setSelectedIndex(0);
    }
    
    public void setSelectedTab(int i){
        jTabbedPane1.setSelectedIndex(i);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTabbedPane1 = new javax.swing.JTabbedPane();
        descriptionLabelContainerPanel = new javax.swing.JPanel();
        descriptionScrollPane = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        amenitiesPanel = new javax.swing.JPanel();
        amenitiesTAScrollPane = new javax.swing.JScrollPane();
        amenitiesTA = new javax.swing.JTextArea();
        reviewsTabPanel = new javax.swing.JPanel();
        reviewsPanel = new javax.swing.JPanel();
        ratingDistributionLabel = new javax.swing.JLabel();
        overallRatingLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(25, 25, 25));
        setLayout(new java.awt.GridBagLayout());

        jTabbedPane1.setBackground(new java.awt.Color(25, 25, 25));

        descriptionLabelContainerPanel.setBackground(new java.awt.Color(25, 25, 25));
        descriptionLabelContainerPanel.setLayout(new java.awt.GridBagLayout());

        descriptionScrollPane.setBackground(new java.awt.Color(25, 25, 25));
        descriptionScrollPane.setBorder(null);
        descriptionScrollPane.setForeground(new java.awt.Color(255, 255, 255));

        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(new java.awt.Color(25, 25, 25));
        descriptionTextArea.setColumns(20);
        descriptionTextArea.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        descriptionTextArea.setForeground(new java.awt.Color(255, 255, 255));
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setRows(5);
        descriptionTextArea.setTabSize(4);
        descriptionTextArea.setText("The InterContinental Mauritius Resort Balaclava Fort is located on one of the most pristine stretches of beach overlooking Balaclava, Mauritius. Offering 210 well-appointed rooms including 10 presidential suites, 40 family-type, 20 Jacuzzi rooms and 140 Deluxe rooms. Facilities include: 3 bars, 5 restaurants, 2 swimming pools ( all heated in winter ), 8 massage rooms, a unique private island, Planet Trekkers kids club, recreational activities, tennis court, 4 meeting rooms & 1 ballroom.");
        descriptionTextArea.setWrapStyleWord(true);
        descriptionScrollPane.setViewportView(descriptionTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 10, 0, 0);
        descriptionLabelContainerPanel.add(descriptionScrollPane, gridBagConstraints);

        jTabbedPane1.addTab("Description", descriptionLabelContainerPanel);

        amenitiesPanel.setBackground(new java.awt.Color(25, 25, 25));
        amenitiesPanel.setLayout(new java.awt.GridBagLayout());

        amenitiesTAScrollPane.setBorder(null);
        amenitiesTAScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        amenitiesTA.setEditable(false);
        amenitiesTA.setBackground(new java.awt.Color(25, 25, 25));
        amenitiesTA.setColumns(20);
        amenitiesTA.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        amenitiesTA.setForeground(new java.awt.Color(188, 188, 188));
        amenitiesTA.setLineWrap(true);
        amenitiesTA.setRows(5);
        amenitiesTA.setText("Business Centre with Internet Access\nFitness Centre with Gym / Workout Room\nFree High Speed Internet (WiFi)\nChildren Activities (Kid / Family Friendly)\nWheelchair Access\nSpa\nPool\nRoom Service");
        amenitiesTA.setWrapStyleWord(true);
        amenitiesTA.setBorder(null);
        amenitiesTAScrollPane.setViewportView(amenitiesTA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 3.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 10, 0, 0);
        amenitiesPanel.add(amenitiesTAScrollPane, gridBagConstraints);

        jTabbedPane1.addTab("Amenities", amenitiesPanel);

        reviewsTabPanel.setBackground(new java.awt.Color(25, 25, 25));

        reviewsPanel.setBackground(new java.awt.Color(25, 25, 25));
        reviewsPanel.setForeground(new java.awt.Color(255, 255, 255));
        reviewsPanel.setLayout(new java.awt.GridBagLayout());

        ratingDistributionLabel.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        ratingDistributionLabel.setForeground(new java.awt.Color(255, 255, 255));
        ratingDistributionLabel.setText("Excellent(3),Good(2),Poor(18),Average(87)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        reviewsPanel.add(ratingDistributionLabel, gridBagConstraints);

        overallRatingLabel.setFont(new java.awt.Font("Lato Black", 0, 72)); // NOI18N
        overallRatingLabel.setForeground(new java.awt.Color(255, 255, 255));
        overallRatingLabel.setText("Rating(4.3)");
        overallRatingLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 2.0;
        reviewsPanel.add(overallRatingLabel, gridBagConstraints);

        javax.swing.GroupLayout reviewsTabPanelLayout = new javax.swing.GroupLayout(reviewsTabPanel);
        reviewsTabPanel.setLayout(reviewsTabPanelLayout);
        reviewsTabPanelLayout.setHorizontalGroup(
            reviewsTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reviewsTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reviewsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1364, Short.MAX_VALUE)
                .addContainerGap())
        );
        reviewsTabPanelLayout.setVerticalGroup(
            reviewsTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reviewsTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reviewsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(255, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reviews", reviewsTabPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jTabbedPane1, gridBagConstraints);
        jTabbedPane1.getAccessibleContext().setAccessibleName("Reviews");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel amenitiesPanel;
    private javax.swing.JTextArea amenitiesTA;
    private javax.swing.JScrollPane amenitiesTAScrollPane;
    private javax.swing.JPanel descriptionLabelContainerPanel;
    private javax.swing.JScrollPane descriptionScrollPane;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel overallRatingLabel;
    private javax.swing.JLabel ratingDistributionLabel;
    private javax.swing.JPanel reviewsPanel;
    private javax.swing.JPanel reviewsTabPanel;
    // End of variables declaration//GEN-END:variables
}
