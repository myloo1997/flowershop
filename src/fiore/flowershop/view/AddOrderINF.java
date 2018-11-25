/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiore.flowershop.view;

import fiore.flowershop.controller.CustomerController;
import fiore.flowershop.controller.ProductController;
import fiore.flowershop.model.Customer;
import fiore.flowershop.model.Product;
import fiore.flowershop.util.Queue;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jasmine
 */
public class AddOrderINF extends javax.swing.JInternalFrame {

    ProductController productController;
    CustomerController custController;
    
    public AddOrderINF() {
        initComponents();
        productController = new ProductController();
        custController = new CustomerController();
        catalog();
        getCompanies();
        orderTbl.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType()==TableModelEvent.INSERT||e.getType()==TableModelEvent.DELETE || e.getType()==TableModelEvent.UPDATE) {
                    int total = 0;
                    DefaultTableModel model = (DefaultTableModel)orderTbl.getModel();
                    if(orderTbl.getRowCount() > 0){
                        for(int row = 0; row < orderTbl.getRowCount(); row++){
                            double amount = (Double) model.getValueAt(row, 4);
                            total += amount;
                        }
                    }else{
                        total = 0;
                    }
                    amountLbl.setText(Double.toString(total));
                }
                
            }
        });
        chgQty();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        typeBtnGrp = new javax.swing.ButtonGroup();
        collectBtnGrp = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        custPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        consumerRB = new javax.swing.JRadioButton();
        corporateRB = new javax.swing.JRadioButton();
        consumerPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nameJTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        icJTF = new javax.swing.JTextField();
        corporatePanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        companyCMB = new javax.swing.JComboBox<>();
        limiterrorLbl = new javax.swing.JLabel();
        catalogPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        catalogTbl = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        orderTbl = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        amountLbl = new javax.swing.JLabel();
        removeBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        pickUpRB = new javax.swing.JRadioButton();
        deliveryRB = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        deliverPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        addressJTA = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        checkoutBtn = new javax.swing.JButton();

        setResizable(true);
        setTitle("New Order");
        setPreferredSize(new java.awt.Dimension(750, 500));

        custPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Customer Details");

        jLabel2.setText("Customer Type:");

        typeBtnGrp.add(consumerRB);
        consumerRB.setSelected(true);
        consumerRB.setText("Consumer");
        consumerRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consumerRBActionPerformed(evt);
            }
        });

        typeBtnGrp.add(corporateRB);
        corporateRB.setText("Corporate");
        corporateRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                corporateRBActionPerformed(evt);
            }
        });

        consumerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Customer Name:");

        jLabel4.setText("Customer IC No.:");

        javax.swing.GroupLayout consumerPanelLayout = new javax.swing.GroupLayout(consumerPanel);
        consumerPanel.setLayout(consumerPanelLayout);
        consumerPanelLayout.setHorizontalGroup(
            consumerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consumerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(consumerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(consumerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icJTF, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(nameJTF))
                .addContainerGap())
        );
        consumerPanelLayout.setVerticalGroup(
            consumerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consumerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(consumerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nameJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(consumerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(icJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        corporatePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Company Name:");

        companyCMB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--select company--" }));
        companyCMB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyCMBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout corporatePanelLayout = new javax.swing.GroupLayout(corporatePanel);
        corporatePanel.setLayout(corporatePanelLayout);
        corporatePanelLayout.setHorizontalGroup(
            corporatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(corporatePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(corporatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(limiterrorLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(corporatePanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(companyCMB, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        corporatePanelLayout.setVerticalGroup(
            corporatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(corporatePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(corporatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(companyCMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(limiterrorLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout custPanelLayout = new javax.swing.GroupLayout(custPanel);
        custPanel.setLayout(custPanelLayout);
        custPanelLayout.setHorizontalGroup(
            custPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(custPanelLayout.createSequentialGroup()
                .addGroup(custPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(custPanelLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(consumerRB)
                        .addGap(10, 10, 10)
                        .addComponent(corporateRB))
                    .addGroup(custPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(custPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(custPanelLayout.createSequentialGroup()
                                .addComponent(consumerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(corporatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        custPanelLayout.setVerticalGroup(
            custPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(custPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(custPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(consumerRB)
                    .addComponent(corporateRB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(custPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(corporatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(consumerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        catalogPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Catalog - Choose Order Items");

        catalogTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Product Type", "Price (RM)", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(catalogTbl);

        addBtn.setText("Add to Order List");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout catalogPanelLayout = new javax.swing.GroupLayout(catalogPanel);
        catalogPanel.setLayout(catalogPanelLayout);
        catalogPanelLayout.setHorizontalGroup(
            catalogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(catalogPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(catalogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addBtn)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        catalogPanelLayout.setVerticalGroup(
            catalogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(catalogPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addBtn)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Order List");

        orderTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Unit Price (RM)", "Qty Ordered", "Amount (RM)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        orderTbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(orderTbl);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Total Amount");

        amountLbl.setText("0");

        removeBtn.setText("Remove from Order List");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(removeBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(amountLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(208, 208, 208))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(amountLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeBtn))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Order Collection");

        collectBtnGrp.add(pickUpRB);
        pickUpRB.setSelected(true);
        pickUpRB.setText("Pick up");
        pickUpRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickUpRBActionPerformed(evt);
            }
        });

        collectBtnGrp.add(deliveryRB);
        deliveryRB.setText("Delivery");
        deliveryRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliveryRBActionPerformed(evt);
            }
        });

        jLabel9.setText("Choose method of collection:");

        addressJTA.setColumns(20);
        addressJTA.setLineWrap(true);
        addressJTA.setRows(5);
        jScrollPane4.setViewportView(addressJTA);

        jLabel10.setText("Delivery Address:");

        javax.swing.GroupLayout deliverPanelLayout = new javax.swing.GroupLayout(deliverPanel);
        deliverPanel.setLayout(deliverPanelLayout);
        deliverPanelLayout.setHorizontalGroup(
            deliverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deliverPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        deliverPanelLayout.setVerticalGroup(
            deliverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deliverPanelLayout.createSequentialGroup()
                .addGroup(deliverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(pickUpRB))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(deliveryRB)
                        .addGap(18, 18, 18)
                        .addComponent(deliverPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(pickUpRB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deliveryRB)
                    .addComponent(deliverPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        checkoutBtn.setText("CHECKOUT");
        checkoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(custPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(catalogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(checkoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(custPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(catalogPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(checkoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consumerRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consumerRBActionPerformed
        // TODO add your handling code here:
        consumerPanel.setVisible(true);
        corporatePanel.setVisible(false);
    }//GEN-LAST:event_consumerRBActionPerformed

    private void corporateRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_corporateRBActionPerformed
        // TODO add your handling code here:
        consumerPanel.setVisible(false);
        corporatePanel.setVisible(true);
    }//GEN-LAST:event_corporateRBActionPerformed

    private void companyCMBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyCMBActionPerformed
        // TODO add your handling code here:
        Customer cust = (Customer) companyCMB.getSelectedItem();
        int ok = custController.checkCreditLimit(cust.getCustomerID());
        //check credit limit
    }//GEN-LAST:event_companyCMBActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        int r = catalogTbl.getSelectedRow();
        int q = 0;
        String stock = (String) catalogTbl.getModel().getValueAt(r, 4);
        
        if(stock.equals("In Stock")){
            q = 1;
        }
        
        if(q != 0){
            DefaultTableModel model = (DefaultTableModel)orderTbl.getModel();
            String[] stuff = new String[4];
            for(int col = 0; col < 4; col++){
                int row = catalogTbl.getSelectedRow();
                String value = catalogTbl.getModel().getValueAt(row, col).toString();
                stuff[col] = value;
            }
            String productID = stuff[0];
            String name = stuff[1];
            double price = Double.parseDouble(stuff[3]);
            int quantity = 1;
            double amount = (price * quantity) * 100 / 100.0;
            model.addRow(new Object[]{productID, name,  price, quantity, amount});
            
        }else{
            JOptionPane.showMessageDialog(this, "Product Out Of Stock!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void pickUpRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickUpRBActionPerformed
        // TODO add your handling code here:
        deliverPanel.setVisible(false);
        
    }//GEN-LAST:event_pickUpRBActionPerformed

    private void deliveryRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliveryRBActionPerformed
        // TODO add your handling code here:
        deliverPanel.setVisible(true);
    }//GEN-LAST:event_deliveryRBActionPerformed

    private void checkoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkoutBtnActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)orderTbl.getModel();
        model.removeRow(orderTbl.getSelectedRow());
    }//GEN-LAST:event_removeBtnActionPerformed

    private void getCompanies(){
        corporatePanel.setVisible(false);
        
        Queue<Customer> customers = custController.getCorporateCustomers();
        Customer customerArr[] = customers.getQueue(Customer.class);
        for(Customer c : customerArr){
            
            DefaultComboBoxModel<Customer> model = (DefaultComboBoxModel)companyCMB.getModel();
            model.addElement(c);
            
        }
    }
    
    private void catalog(){
        Queue<Product> products = productController.getAllProducts();
        Product productArr[] = products.getQueue(Product.class);
        String stocked = "";
        for(Product p : productArr){
            DefaultTableModel model = (DefaultTableModel)catalogTbl.getModel();
            if(p.getStocked() == 1){
                stocked = "In Stock";
            }else{
                
                stocked = "Out of Stock";
                
            }
            model.addRow(new Object[]{p.getProductID(), p.getProductName(), p.getTypeName(),p.getPrice(), stocked});
        }
    }
    
    private void chgQty(){
        orderTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = catalogTbl.rowAtPoint(evt.getPoint());
                int col = catalogTbl.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    
                    int r = orderTbl.getSelectedRow();
                    int qty = Integer.parseInt(orderTbl.getModel().getValueAt(r, 3).toString());
                    double price = Double.parseDouble(orderTbl.getModel().getValueAt(r, 2).toString());
                    double amount = (price * qty) * 100 / 100.0;
                    orderTbl.getModel().setValueAt(amount, r, 4);
                    
                }
            }
        }); //only updates after mouseclick on same element again - fix this
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTextArea addressJTA;
    private javax.swing.JLabel amountLbl;
    private javax.swing.JPanel catalogPanel;
    private javax.swing.JTable catalogTbl;
    private javax.swing.JButton checkoutBtn;
    private javax.swing.ButtonGroup collectBtnGrp;
    private javax.swing.JComboBox<String> companyCMB;
    private javax.swing.JPanel consumerPanel;
    private javax.swing.JRadioButton consumerRB;
    private javax.swing.JPanel corporatePanel;
    private javax.swing.JRadioButton corporateRB;
    private javax.swing.JPanel custPanel;
    private javax.swing.JPanel deliverPanel;
    private javax.swing.JRadioButton deliveryRB;
    private javax.swing.JTextField icJTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel limiterrorLbl;
    private javax.swing.JTextField nameJTF;
    private javax.swing.JTable orderTbl;
    private javax.swing.JRadioButton pickUpRB;
    private javax.swing.JButton removeBtn;
    private javax.swing.ButtonGroup typeBtnGrp;
    // End of variables declaration//GEN-END:variables
}