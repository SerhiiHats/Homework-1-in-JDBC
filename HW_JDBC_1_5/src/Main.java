import DBConnect.DBConnect;
import color.Color;
import models.EmployeeManager;
import models.EmployeeMarried;
import models.EmployeePhone;
import repos.UserRepo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Задание 5
 * Используя IntelijIdea и JDBC cделайте выборку при помощи JOIN’s для таких заданий:
 * 1) Получите контактные данные сотрудников (номера телефонов, место жительства).
 * 2) Получите информацию о дате рождения всех холостых сотрудников и их номера.
 * 3) Получите информацию обо всех менеджерах компании: дату рождения и номер телефона.
 **/

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DBConnect.getConnection()) {
            UserRepo userRepo = new UserRepo(connection);

            System.out.println(Color.GREEN + "-- 1) Получите контактные данные сотрудников (номера телефонов, место жительства) --" + Color.DEFAULT);
            List<EmployeePhone> employeePhoneList = userRepo.getListEmployeePhone();
            for (EmployeePhone ep : employeePhoneList) {
                System.out.println(ep);
            }

            System.out.println(Color.GREEN + "-- 2) Получите информацию о дате рождения всех холостых сотрудников и их номера --" + Color.DEFAULT);
            List<EmployeeMarried> employeeMarriedList = userRepo.getListEmployeeMarried();
            for (EmployeeMarried em : employeeMarriedList) {
                System.out.println(em);
            }

            System.out.println(Color.GREEN + "-- 3) Получите информацию обо всех менеджерах компании: дату рождения и номер телефона. --" + Color.DEFAULT);
            List<EmployeeManager> employeeManagerList = userRepo.getEmployeeManager();
            for (EmployeeManager manager : employeeManagerList) {
                System.out.println(manager);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
