/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
/**
 *
 * @author Jasmine
 */
public class FlowerShop extends JFrame{
    static FlowerShop frame;
    private JPanel contentPane;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                        frame = new FlowerShop();
                        frame.setVisible(true);
                } catch (Exception e) {
                        e.printStackTrace();
                }
            }
        });
    }
    
    public FlowerShop(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 371);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        JLabel lblAdminSection = new JLabel("FIORE FLOWERSHOP");
        lblAdminSection.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblAdminSection.setForeground(Color.GRAY);
        contentPane.add(lblAdminSection);
        
        JButton btnCatalog = new JButton("Catalog");
            btnCatalog.setFont(new Font("Tahoma", Font.PLAIN, 15));
            btnCatalog.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                //Catalog.main(new String[]{});
                frame.dispose();
                }
            });
        contentPane.add(btnCatalog);
        
        JButton btnOrder = new JButton("New Order");
            btnOrder.setFont(new Font("Tahoma", Font.PLAIN, 15));
            btnOrder.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                //NewOrder.main(new String[]{});
                frame.dispose();
                }
            });
        contentPane.add(btnOrder);
        
        JButton btnNewCust = new JButton("Add Corporate Customer");
            btnNewCust.setFont(new Font("Tahoma", Font.PLAIN, 15));
            btnNewCust.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                //NewCust.main(new String[]{});
                frame.dispose();
                }
            });
        contentPane.add(btnNewCust);
        
        JButton btnPickUp = new JButton("Pick Up List");
            btnPickUp.setFont(new Font("Tahoma", Font.PLAIN, 15));
            btnPickUp.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                //.main(new String[]{});
                frame.dispose();
                }
            });
        contentPane.add(btnPickUp);
        
        JButton btnDelivery = new JButton("Delivery List");
            btnDelivery.setFont(new Font("Tahoma", Font.PLAIN, 15));
            btnDelivery.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                //.main(new String[]{});
                frame.dispose();
                }
            });
        contentPane.add(btnDelivery);
    }
    
}
