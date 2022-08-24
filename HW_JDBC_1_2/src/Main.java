import DBConnect.DBConnect;
import models.Customer;
import repos.UserRepo;
import services.ReadRequest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int count = 1;
        try(Connection connection = DBConnect.getConnection()) {
            List<String> listRequest = new ArrayList<>();
            listRequest = new ReadRequest().getListRequest();
            UserRepo userRepo = new UserRepo(connection);

            for (String sqlRequest : listRequest){
                if (userRepo.getUpdateCustomer(sqlRequest)) {
                    List<Customer> listCustomers = userRepo.getCustomer(sqlRequest);
                    System.out.println(count++ + ". Выполнен запрос : " + sqlRequest);
                    System.out.println("    Результат:");
                    for (Customer customer : listCustomers) {
                        System.out.println("    : " + customer);
                    }
                } else {
                    System.out.println(count++ + ". Выполнен запрос : " + sqlRequest);
                    System.out.println("    Результат: true");
                }
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
