/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custom.components;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 *
 * @author Pranek
 */
public class DatePanel extends javax.swing.JPanel implements ItemListener {
    private int count=0;
    private LocalDate minDate;
    private LocalDate maxDate;
    private ArrayList<Integer> yearModel; 
    private boolean isChanging=false;
    /**
     * Creates new form Datepanel
     */
    public DatePanel() {
        
        initComponents();
        
        this.yearModel = new ArrayList<>();
        this.maxDate = LocalDate.now();
        this.minDate = LocalDate.of(1900, 1, 1);

    //"this" is passed in the constructor, check if it would cause problems
        
       
        
        dateCB.addItemListener(this);
        monthCB.addItemListener(this);
        yearCB.addItemListener(this);
        
        
       
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (yearCB.getSelectedIndex()>-1 && monthCB.getSelectedIndex()>-1 && dateCB.getSelectedIndex()>-1 
                && !isChanging && e.getStateChange() == ItemEvent.SELECTED) {
            
            //Checking basic calender constraints
            if (Integer.parseInt((String) dateCB.getSelectedItem()) > 28 && Month.valueOf((String) monthCB.getSelectedItem()).equals(Month.Feb)) {
                if (Integer.parseInt((String) yearCB.getSelectedItem()) % 4 == 0) {
                    dateCB.setSelectedIndex(dateCB.getItemCount() - 3);
                    
                } else {
                    dateCB.setSelectedIndex(dateCB.getItemCount() - 4);
                    
                }
            } else if (Integer.parseInt((String) dateCB.getSelectedItem()) > 30) {
                switch (Month.valueOf((String) monthCB.getSelectedItem())) {
                    case Apr:                                           //30 ke mahine
                    case Jun:
                    case Sep:
                    case Nov:
                        dateCB.setSelectedIndex(dateCB.getItemCount() - 2);//setting date = 30   
                }
            }
            System.out.println("getDate gives " + getDate()+ ", minDate is " + minDate + 
                    " , while getDate.isBefore is " +getDate().isBefore(minDate)  );
            //checking min and max date constraints
            if (getDate().isBefore(minDate)) {
                System.out.println("OOPS less than minDate");
                setDate(minDate);                
            } else
            if (getDate().isAfter(maxDate)) {
                setDate(maxDate);
            }
        }
    }


    
    private enum Month{//barebones enum for quickly getting int value of Month
        Jan(1),
        Feb(2),
        Mar(3),
        Apr(4),
        May(5),
        Jun(6),
        Jul(7),
        Aug(8),
        Sep(9),
        Oct(10),
        Nov(11),
        Dec(12);
    
        private final int value;
        private Month(int v){
            value =v;
        }
    
        public int getValue(){
            return value;
        }
    }
    
    public LocalDate getDate(){
       
       int dayOfMonth = Integer.parseInt((String) dateCB.getSelectedItem());
       int month = Month.valueOf((String) monthCB.getSelectedItem()).getValue();
       int year = Integer.parseInt((String)yearCB.getSelectedItem());
       
       return LocalDate.of(year,month,dayOfMonth);
    }
    
    public void setDate(LocalDate date){
        isChanging=true;
        dateCB.setSelectedIndex(date.getDayOfMonth()-1);
        monthCB.setSelectedIndex(date.getMonthValue()-1);

        yearCB.setSelectedIndex(yearModel.indexOf(date.getYear()));
        isChanging=false;        
    }

    public void setMinDate(LocalDate minDate) {
        this.minDate = minDate;
        //only changing model of JComboBox for yearCB
        if(this.minDate.isBefore(maxDate)){//only update model if it is possible
           updateYearModel();
        }
    }

    public void setMaxDate(LocalDate maxDate) {
        this.maxDate = maxDate;
         //only changing model of JComboBox for yearCB
        if(minDate.isBefore(this.maxDate)){//only update model if it is possible
           updateYearModel();
        }
    }
    
    private void updateYearModel(){
        System.out.println("Updating yearModel, maxDate is " + maxDate + ", minDate is "+minDate);
        yearCB.removeAllItems();
         yearModel.clear();
         isChanging=true;
         for(int i = minDate.getYear();i<=maxDate.getYear();i++){
            //System.out.println("Adding year "+ String.valueOf(i));
             yearCB.addItem(String.valueOf(i));
             yearModel.add(i);
             
                 
         }
        isChanging=false;
        setDate(minDate);
        System.out.println("Year Model Updated!");
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        dateCB = new javax.swing.JComboBox<>();
        monthCB = new javax.swing.JComboBox<>();
        yearCB = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(25, 25, 25));
        setLayout(new java.awt.GridBagLayout());

        dateCB.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        dateCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(dateCB, gridBagConstraints);

        monthCB.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        monthCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(monthCB, gridBagConstraints);

        yearCB.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        yearCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905", "1904", "1903", "1902", "1901", "1900" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(yearCB, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> dateCB;
    private javax.swing.JComboBox<String> monthCB;
    private javax.swing.JComboBox<String> yearCB;
    // End of variables declaration//GEN-END:variables
}
