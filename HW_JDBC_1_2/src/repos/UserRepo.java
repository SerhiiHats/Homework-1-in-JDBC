package repos;

import models.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    private final Connection connection;

    public UserRepo(Connection connection) {
        this.connection = connection;
    }

    public Boolean getUpdateCustomer(String sglRequest){
        try (Statement statement = connection.createStatement()){
            return statement.execute(sglRequest);

        } catch (SQLException e) {
           e.printStackTrace();
        }
        return true;
    }

    public List<Customer> getCustomer(String sqlRequest){
        List<Customer> listCustomers = new ArrayList<>();
        try (Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(sqlRequest);
            while (rs.next()) {
                Customer customer = new Customer(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getDate(6));
                listCustomers.add(customer);
            }
            return listCustomers;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCustomers;
    }
}
