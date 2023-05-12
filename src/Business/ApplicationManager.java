package Business;

import DataAccess.*;
import Exceptions.DBExceptions;
import Model.*;

import java.util.ArrayList;

public class ApplicationManager {
    private ProductDBAccess productDBAccess;
    private CategorieDBAcces categorieDBAcces;
    private CustomerDBAcces customerDBAcces;

    private SupplierDBAccess supplierDBAccess;

    public ApplicationManager() {
        productDBAccess = new ProductDBAccess();
        categorieDBAcces = new CategorieDBAcces();
        customerDBAcces = new CustomerDBAcces();
        supplierDBAccess = new SupplierDBAccess();
    }

    // Product methods

    public void addProduct(Product product) throws DBExceptions {
        productDBAccess.addProduct(product);
    }

    public void editProduct(Product product) throws DBExceptions {
        productDBAccess.editProduct(product);
    }

    public void deleteProduct(int id) throws DBExceptions {
        productDBAccess.deleteProduct(id);
    }

    public Product getProductById(int id) throws DBExceptions {
        return productDBAccess.getProductById(id);
    }

    public ArrayList<Product> getAllProducts() throws DBExceptions {
        return productDBAccess.getAllProducts();
    }

    public ArrayList<CustomerByProduct> getCustomersWhoPurchasedProduct(int id) throws DBExceptions {
        return productDBAccess.getCustomersWhoPurchasedProduct(id);
    }

    public Boolean isArticleAvailableForDeleting(int id) throws DBExceptions {
        return productDBAccess.isArticleAvailableForDeleting(id);
    }

    // Category methods

    public Category getCategoryById(int id) throws DBExceptions {
        return categorieDBAcces.getCategoryById(id);
    }

    public ArrayList<Category> getAllCategories() throws DBExceptions {
        return categorieDBAcces.getAllCategories();
    }

    // Customer methods

    public Customer getCustomerById(int id) throws DBExceptions {
        return customerDBAcces.getCustomerById(id);
    }

    public ArrayList<Customer> getAllCustomers() throws DBExceptions {
        return customerDBAcces.getAllCustomers();
    }

    public ArrayList<SupplierByCategory> getSuppliersByCategory(int id) throws DBExceptions {
        return categorieDBAcces.getSuppliersByCategory(id);
    }

    public ArrayList<Purchase> getBoughtHistory(int id) throws DBExceptions {
        return customerDBAcces.getBoughtHistory(id);
    }

    // Supplier methods

    public ArrayList<Supplier> getAllSupplier() throws DBExceptions{
        return supplierDBAccess.getAllProducts();
    }
}
