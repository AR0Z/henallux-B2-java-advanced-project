package View;

import Controller.ApplicationController;
import Exceptions.DBExceptions;
import Model.Customer;
import Model.Purchase;
import View.ComboBox.ComboBoxCustomers;
import View.TableModels.PurchasesByCustomerModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PurchasesByCustomerPanel extends JPanel {
    private ApplicationController controller;
    private ArrayList<Purchase> searchBoughtHistories;
    private ComboBoxCustomers comboBoxCustomers;
    private JPanel topPanel, centerPanel;
    JScrollPane scrollPane;
    JTable table;
    PurchasesByCustomerModel model;

    public PurchasesByCustomerPanel() {
        setLayout(new BorderLayout());

        topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Menu de recherche d'historique d'achat", SwingConstants.CENTER));
        controller = new ApplicationController();
        comboBoxCustomers = new ComboBoxCustomers();
        comboBoxCustomers.addActionListener(l -> {
            if (comboBoxCustomers.getSelectedIndex() >= 1) {
                try {
                    Customer customer = controller.getCustomerById(comboBoxCustomers.getId());
                    updateTable(customer);
                } catch (DBExceptions e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erreur : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }

            }
            ;
        });

        topPanel.add(comboBoxCustomers);
        add(topPanel, BorderLayout.NORTH);

        centerPanel = new JPanel(new FlowLayout());
        add(centerPanel, BorderLayout.CENTER);

        scrollPane = new JScrollPane();
        centerPanel.add(scrollPane);
    }

    public void updateTable(Customer customer) {

        try {
            searchBoughtHistories = controller.getBoughtHistory(customer.getId());
            if(table == null) {
                model = new PurchasesByCustomerModel(searchBoughtHistories);
                table = new JTable(model);

                table.setPreferredScrollableViewportSize(new Dimension(700, 300));
                table.setFillsViewportHeight(true);

                scrollPane.setViewportView(table);
                revalidate();
                repaint();
            }else{
                model.update(searchBoughtHistories);
            }
        } catch (DBExceptions e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}