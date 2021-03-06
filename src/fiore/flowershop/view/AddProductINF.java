/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiore.flowershop.view;

import fiore.flowershop.controller.ProductController;
import fiore.flowershop.model.Product;
import javax.swing.JOptionPane;

/**
 *
 * @author Jasmine
 */
public class AddProductINF extends javax.swing.JInternalFrame {
    ProductController productController;
    
    public AddProductINF() {
        initComponents();
        productController = new ProductController();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        productNameJL = new javax.swing.JLabel();
        productTypeJL = new javax.swing.JLabel();
        typeCMB = new javax.swing.JComboBox<>();
        productNameTF = new javax.swing.JTextField();
        priceJL = new javax.swing.JLabel();
        priceTF = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Add Product");

        productNameJL.setText("Product Name:");

        productTypeJL.setText("Product Type:");

        typeCMB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fresh Flower", "Bouquet" }));

        priceJL.setText("Price");

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        resetBtn.setText("Reset");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(saveBtn)
                        .addGap(18, 18, 18)
                        .addComponent(resetBtn))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(productNameJL)
                            .addGap(18, 18, 18)
                            .addComponent(productNameTF))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(productTypeJL)
                                .addComponent(priceJL))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(priceTF, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(typeCMB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(301, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productNameJL)
                    .addComponent(productNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productTypeJL)
                    .addComponent(typeCMB, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceJL)
                    .addComponent(priceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(resetBtn))
                .addContainerGap(246, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        
        String name = productNameTF.getText();
        String price = priceTF.getText();
        String productType = (String) typeCMB.getSelectedItem();
        int ok = 1;
        
        String err = "";
        if(name.equals("") || price.equals("")){
            ok = 0;
            err += "All fields must be filled.";
        }
        
        if(!price.equals("")){
            try{
                double value = Double.parseDouble(price);
            }catch(Exception e){
                ok = 0;
                err += " Price must contain only numbers.";
            }
        }
        
        if(ok == 1){
            Product p = new Product();
            p.setTypeName(productType);
            p.setProductName(name);
            p.setPrice(Double.parseDouble(price));
            p.setStocked(1);

            String result = productController.addProduct(p);

            if(result.equals("success")){
                JOptionPane.showMessageDialog(this, name + "  added Successfully ", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, err, "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_saveBtnActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        productNameTF.setText("");
        priceTF.setText("");
        typeCMB.setSelectedIndex(0);
    }//GEN-LAST:event_resetBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel priceJL;
    private javax.swing.JTextField priceTF;
    private javax.swing.JLabel productNameJL;
    private javax.swing.JTextField productNameTF;
    private javax.swing.JLabel productTypeJL;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JComboBox<String> typeCMB;
    // End of variables declaration//GEN-END:variables
}
