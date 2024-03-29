package DataAccess;

import Exceptions.ConnectionException;
import Exceptions.GetAllSuppliersException;
import Model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class SupplierDBAccess implements SupplierDAO {

    private Connection connection;
    public SupplierDBAccess() throws ConnectionException {
        connection = SingletonConnexion.getInstance();
    }
    @Override
    public ArrayList<Supplier> getAllSuppliers() throws GetAllSuppliersException {
        ArrayList<Supplier> suppliers = new ArrayList<>();
        try {
            String sqlInstruction = "select * from supplier;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            ResultSet data = preparedStatement.executeQuery();
            Supplier supplier;
            while (data.next()) {
                supplier = new Supplier(data.getInt("id"), data.getString("label"), data.getString("phone"), data.getString("email"), data.getString("street_and_number"), data.getInt("locality_id"));
                suppliers.add(supplier);
            }
        } catch (SQLException e) {
            throw new GetAllSuppliersException();
        }
        return suppliers;
    }
}