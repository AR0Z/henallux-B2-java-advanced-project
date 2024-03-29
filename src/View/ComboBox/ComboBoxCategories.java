package View.ComboBox;

import Controller.ApplicationController;
import Exceptions.ConnectionException;
import Exceptions.GetAllCategoriesException;
import Model.Category;

import javax.swing.*;
import java.util.ArrayList;

public class ComboBoxCategories extends JComboBox {
    ArrayList<Category> categories;
    ApplicationController controller;

    public ComboBoxCategories() {
        try {
            controller = new ApplicationController();
        } catch (ConnectionException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        update();
    }

    public void update() {
        if (this.getItemCount() > 0)
            this.removeAllItems();
        try {
            categories = controller.getAllCategories();
            this.addItem("Choisir une catégorie");
            for (Category category : categories) {
                this.addItem(category.getLabel() + " (" + category.getId() + ")");
            }
        } catch (GetAllCategoriesException e) {
            JOptionPane.showMessageDialog(null, "Erreur : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int getId() {
        return categories.get(this.getSelectedIndex() - 1).getId();
    }
}
