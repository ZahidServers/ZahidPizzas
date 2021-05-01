/*
 * This project is under Zahid MZIWA Personal Open License V2.
 * You can Use/Edit/Redistribute this software but can not 
 * redistribute it commercially, this software is intellectual
 * property of Mr. Mohammed Zahid Imtiyaz Wadiwale and Abhishekh Gajula.
 * The code blocks written by Abhishek is mentioned by using comments rest code is by Zahid
 * The code by utilised by both is also commented.
 */
package ZahidPizzas;
//imports here
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.image.BufferedImage;//Required by Both Zahid and Abhishek part of code
import java.io.File;//Required by Both Zahid and Abhishek part of code
import java.io.IOException;//Required by Both Zahid and Abhishek part of code
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;//Required by Both Zahid and Abhishek part of code
//imports by Abhishek
import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.Copies;
import javax.print.event.*;
import java.io.FileInputStream;//Required by Both Zahid and Abhishek part of code
import java.io.FileNotFoundException;//Required by Both Zahid and Abhishek part of code
//imports by Abhishek ends
public class ZahidPizzas extends javax.swing.JFrame {

    public ZahidPizzas() {
        initComponents();
    }
    DefaultTableModel model;
    String item;
    int price;
    Connection con;
    PreparedStatement pst;
    PreparedStatement pst1;

    private void initComponents() {
        //Creating Labels,Textfieds,buttons, radio buttons and a spinner

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblsmall = new javax.swing.JRadioButton();
        lblmedium = new javax.swing.JRadioButton();
        lbllarge = new javax.swing.JRadioButton();
        lbljumbo = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtpay = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtbal = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtqty = new javax.swing.JSpinner();
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        //Setting Close Operation

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //Giving Title
        setTitle("Zahid Pizzas by Mohammed Zahid Wadiwale 42 and Abhishek Gajula 48");

        //Setting Background Colors , Foregrounds, font, text, etc for widgets
        jPanel1.setBackground(java.awt.Color.orange);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Snap ITC", 3, 24));
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Zahid Pizzas");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Best Parità e Quattro in Town");

        //Creating Group layouts for jPanels and setting their horizontal, vertical positions and all other properties
        //Also this block contains code for setting properties of other widgets which are passed into these jPanels

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(300, 300, 300))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(291, 291, 291))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(235, 231, 231));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblsmall.setBackground(new java.awt.Color(235, 231, 231));
        buttonGroup1.add(lblsmall);
        lblsmall.setFont(new java.awt.Font("Tahoma", 1, 14));
        lblsmall.setText("Small (8 inch)");
        lblsmall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblsmallActionPerformed(evt);
            }
        });

        lblmedium.setBackground(new java.awt.Color(235, 231, 231));
        buttonGroup1.add(lblmedium);
        lblmedium.setFont(new java.awt.Font("Tahoma", 1, 14));
        lblmedium.setText("Medium (12 inch)");
        lblmedium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblmediumActionPerformed(evt);
            }
        });

        lbllarge.setBackground(new java.awt.Color(235, 231, 231));
        buttonGroup1.add(lbllarge);
        lbllarge.setFont(new java.awt.Font("Tahoma", 1, 14));
        lbllarge.setText("Large (16 inch)");

        lbljumbo.setBackground(new java.awt.Color(235, 231, 231));
        buttonGroup1.add(lbljumbo);
        lbljumbo.setFont(new java.awt.Font("Tahoma", 1, 14));
        lbljumbo.setText("Jumbo (20 inch)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblsmall)
                    .addComponent(lblmedium)
                    .addComponent(lbllarge)
                    .addComponent(lbljumbo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblsmall)
                .addGap(18, 18, 18)
                .addComponent(lblmedium)
                .addGap(18, 18, 18)
                .addComponent(lbllarge)
                .addGap(18, 18, 18)
                .addComponent(lbljumbo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Price", "Qty", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel3.setBackground(new java.awt.Color(235, 231, 231));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel4.setText("Payment:");

        txtpay.setFont(new java.awt.Font("Tahoma", 3, 14));
        txtpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { ///Initially added bt not required
                txtpayActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel5.setText("Balance:");

        txtbal.setFont(new java.awt.Font("Tahoma", 3, 14));

        txttotal.setFont(new java.awt.Font("Tahoma", 3, 14));
        txttotal.addActionListener(new java.awt.event.ActionListener() {///Initially added bt not required
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel6.setText("Total:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtpay)
                    .addComponent(txtbal)
                    .addComponent(txttotal, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpay, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbal, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jPanel4.setBackground(new java.awt.Color(235, 231, 231));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel3.setText("Qty:");

        txtqty.setFont(new java.awt.Font("Tahoma", 1, 14));

        jButton5.setText("About");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(235, 231, 231));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        //In this block i have set up Buttons Text and created their event listners calling their respective functions

        jButton3.setText("Remove");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Print Invoice");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        //Creating Group layouts for jPanels and setting their horizontal, vertical positions and all other properties

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }

    private void lblsmallActionPerformed(java.awt.event.ActionEvent evt) {
        // Not Required Anymore
    }

    private void lblmediumActionPerformed(java.awt.event.ActionEvent evt) {
        // Not Required Anymore
    }

    private void txtpayActionPerformed(java.awt.event.ActionEvent evt) {
        // Not Required Anymore
    }
    //Sales Method is the function which connects to mysql add everything to the database takes the screenshot and save it.
    //After saving the screenshot it displays popup sales completed and then the it contains all the methods for printing the saved screenshot.
    public void sales(){
        int lastid=0;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zahidpizzas","root","");
                String total=txttotal.getText();
                String bal=txtbal.getText();
                String pay=txtpay.getText();
                String query="insert into sales(subtotal,pay,balance)values(?,?,?)";
                pst=con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                pst.setString(1, total);
                pst.setString(2, pay);
                pst.setString(3, bal);
                pst.executeUpdate();
                ResultSet rs=pst.getGeneratedKeys();
                if(rs.next()){
                    lastid=rs.getInt(1);
                }
                int row=jTable1.getRowCount();
                String query1="insert into sales_product(sales_id,prodname,price,qty,total)values(?,?,?,?,?)";
                pst1=con.prepareStatement(query1);
                String prodname="";
                int price;
                int qty;
                int tot=0;
                for(int i=0;i<jTable1.getRowCount();i++){
                    prodname=(String)jTable1.getValueAt(i, 0);
                    price=(int)jTable1.getValueAt(i, 1);
                    qty=(int)jTable1.getValueAt(i, 2);
                    tot=(int)jTable1.getValueAt(i, 3);
                    pst1.setInt(1, lastid);
                    pst1.setString(2, prodname);
                    pst1.setInt(3, price);
                    pst1.setInt(4, qty);
                    pst1.setInt(5, tot);
                    pst1.executeUpdate();
                }
                try {
                    //Delay is added to get proper screenshot as i was getting screenshot without balance
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ZahidPizzas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String format = "PNG";
                    String fileName = "PartialScreenshot." + format;
                    BufferedImage screenFullImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
                    this.paint(screenFullImage.getGraphics());
                    ImageIO.write(screenFullImage, format, new File(fileName));
                    
                } catch (IOException ex) {
                    System.err.println(ex);
                }
                JOptionPane.showMessageDialog(this, "Sales Completed");
                //This is part of code written by Abhishek Gajula it starts here
                PrintService ps=PrintServiceLookup.lookupDefaultPrintService();
                DocPrintJob job=ps.createPrintJob();
                job.addPrintJobListener(new PrintJobAdapter() {
                public void printDataTransferCompleted(PrintJobEvent event){
                   System.out.println("data transfer complete");
                }
                public void printJobNoMoreEvents(PrintJobEvent event){
                      System.out.println("received no more events");
                   }
                });
                FileInputStream fis;
                try {
                    try {
                        fis = new FileInputStream("PartialScreenshot.PNG");
                        Doc doc=new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
                        // Doc doc=new SimpleDoc(fis, DocFlavor.INPUT_STREAM.PNG, null);
                        PrintRequestAttributeSet attrib=new HashPrintRequestAttributeSet();
                        attrib.add(new Copies(1));
                        job.print(doc, attrib);
                    } catch (PrintException ex) {
                        Logger.getLogger(ZahidPizzas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ZahidPizzas.class.getName()).log(Level.SEVERE, null, ex);
                }
                //The Code Written By Abhishek Gajula ends here
            } catch (SQLException ex) {
                Logger.getLogger(ZahidPizzas.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ZahidPizzas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //Add button method the function called on clicking add button get selected item add it to jTable and updates the total price
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if(lblsmall.isSelected() == true){
            item="Small(8)";
            price=280;
        }
        else if(lblmedium.isSelected() == true){
            item="Medium(12)";
            price=360;
        }
        else if(lbllarge.isSelected() == true){
            item="Large(16)";
            price=480;
        }
        else if(lbljumbo.isSelected() == true){
            item="Jumbo(20)";
            price=560;
        }
        int qty=Integer.parseInt(txtqty.getValue().toString());
        int tot=qty*price;
        model=(DefaultTableModel)jTable1.getModel();
        model.addRow(new Object[]{
            item,price,qty,tot
        });
        int sum=0;
        for(int a=0;a<jTable1.getRowCount(); a++){
            sum=sum+Integer.parseInt(jTable1.getValueAt(a, 3).toString());
        }
        txttotal.setText(Integer.toString(sum));
    }

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {
        // Not Required Anymore
    }
    //Remove button method the method call when remove button is clicked for removing the selected column for jTable and updating the total value
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        model.removeRow(jTable1.getSelectedRow());
        int sum=0;
        for(int a=0;a<jTable1.getRowCount(); a++){
            sum=sum+Integer.parseInt(jTable1.getValueAt(a, 3).toString());
        }
        txttotal.setText(Integer.toString(sum));
    }

    //Clear button method the function call when clear button is clicked for Clearing all Textfilds setting spinner value to 0 and clearing the selection of radio buttons group
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        txttotal.setText("");
        txtpay.setText("");
        txtbal.setText("");
        txtqty.setValue(0);
        buttonGroup1.clearSelection();
    }

    //Print button Method the function called when print button is clicked to set the balance and call sales method
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int tot=Integer.parseInt(txttotal.getText());
            int pay=Integer.parseInt(txtpay.getText());
            int bal=pay-tot;
            txtbal.setText(String.valueOf(bal));
            //Delay is added to get proper screenshot as i was getting screenshot without balance
            TimeUnit.SECONDS.sleep(2);
            sales();
        } catch (InterruptedException ex) {
            Logger.getLogger(ZahidPizzas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Abiout button method called when aboout is clicked to display the popup and show auhor and contributors in project
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this,"Created By Mohammed Zahid Wadiwale and Abhishek Gajula\nAuthor1:Mohammed Zahid Wadiwale\nAuthor2:Abhishek Gajula","About",JOptionPane.INFORMATION_MESSAGE);
    }
    public static void main(String args[]) {
        //Setting up Swing UI Manager
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ZahidPizzas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ZahidPizzas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ZahidPizzas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ZahidPizzas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //Invoking AWT to run the class
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ZahidPizzas().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton lbljumbo;
    private javax.swing.JRadioButton lbllarge;
    private javax.swing.JRadioButton lblmedium;
    private javax.swing.JRadioButton lblsmall;
    private javax.swing.JTextField txtbal;
    private javax.swing.JTextField txtpay;
    private javax.swing.JSpinner txtqty;
    private javax.swing.JTextField txttotal;
}
