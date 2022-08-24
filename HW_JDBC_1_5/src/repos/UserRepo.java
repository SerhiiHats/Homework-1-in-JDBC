package repos;

import models.EmployeeManager;
import models.EmployeeMarried;
import models.EmployeePhone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    private final Connection connection;

    public UserRepo(Connection connection) {
        this.connection = connection;
    }

    public List<EmployeePhone> getListEmployeePhone() {
        List<EmployeePhone> listEmployeePhone = new ArrayList<>();
        final String sqlRequest = "SELECT e.l_name_emp, e.f_name_emp, e.m_name_emp, phone_emp, d.address_des FROM employees AS e\n" +
                "INNER JOIN description_employee AS d\n" +
                "ON e.id_emp = d.id_emp";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EmployeePhone employeePhone = new EmployeePhone(resultSet.getString(1),
                        resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5));
                listEmployeePhone.add(employeePhone);
            }
            return listEmployeePhone;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listEmployeePhone;
    }

    public List<EmployeeMarried> getListEmployeeMarried() {
        List<EmployeeMarried> listEmployeeMarried = new ArrayList<>();
        final String sqlRequest = "SELECT e.l_name_emp, e.f_name_emp, e.m_name_emp, d.married_des, d.birthday_des, e.phone_emp FROM employees AS e\n" +
                " INNER JOIN description_employee AS d ON e.id_emp = d.id_emp\n" +
                " WHERE d.married_des = 'not married'";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EmployeeMarried employeeMarried = new EmployeeMarried(resultSet.getString(1),
                        resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getDate(5), resultSet.getString(6));
                listEmployeeMarried.add(employeeMarried);
            }
            return listEmployeeMarried;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listEmployeeMarried;
    }

    public List<EmployeeManager> getEmployeeManager() {
        List<EmployeeManager> employeeManagerList = new ArrayList<>();
        final String sqlRequest = "SELECT e.l_name_emp, e.f_name_emp, e.m_name_emp, p.title_pos, d.birthday_des, e.phone_emp FROM employees AS e\n" +
                " INNER JOIN position_employee AS p\n" +
                " ON e.id_emp = p.id_emp\n" +
                " INNER JOIN description_employee AS d\n" +
                " ON e.id_emp = d.id_emp\n" +
                " WHERE p.title_pos = 'менеджер'";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EmployeeManager employeeManager = new EmployeeManager(resultSet.getString(1),
                        resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getDate(5), resultSet.getString(6));
                employeeManagerList.add(employeeManager);
            }
            return employeeManagerList;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeManagerList;
    }

}
