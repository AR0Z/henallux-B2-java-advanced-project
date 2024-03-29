package View.ComboBox;

import Controller.ApplicationController;
import Exceptions.ConnectionException;
import Exceptions.GetAllSuppliersException;
import Model.Supplier;

import javax.swing.*;
import java.util.ArrayList;

public class ComboBoxSupplier extends JComboBox {
    ArrayList<Supplier> suppliers;
    ApplicationController controller;

    public ComboBoxSupplier() {
        try {
            controller = new ApplicationController();
        } catch (ConnectionException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        update();
    }

    public void update() {
        if (getItemCount() > 0)
            removeAllItems();
        try {
            suppliers = controller.getAllSuppliers();
            addItem("Choisir un fournisseur");
            for (Supplier supplier : suppliers) {
                addItem(supplier.getName() + " (" + supplier.getId() + ")");
            }
        } catch (GetAllSuppliersException e) {
            JOptionPane.showMessageDialog(null, "Erreur : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int getId() {
        return suppliers.get(this.getSelectedIndex() - 1).getId();
    }
}
