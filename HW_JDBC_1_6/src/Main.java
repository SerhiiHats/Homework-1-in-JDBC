import DBConnect.DBConnect;
import color.Color;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DBConnect.getConnection()) {
            final String sqlSelectAll = "SELECT * FROM debtor"; // выборка всех должников
            final String sqlSelectMoreSum = "SELECT * FROM debtor WHERE duty > ?"; // выборка должников долг которых больше определенной суммы
            final String sqlSelectEquals = "SELECT * FROM debtor WHERE duty = ?"; // выборка должников долг которых равен сумме
            final String sqlSelectRange = "SELECT * FROM debtor WHERE duty BETWEEN ? AND ?"; // выборка должников долг которых находится в диапозоне сумме
            final String sqlSelectBeginLastName = "SELECT * FROM debtor WHERE l_name LIKE ? '%'"; // выборка должников фамилия который начинается на любую букву или набор букв
            final String sqlSelectRangLastName = "SELECT * FROM debtor WHERE l_name LIKE '%' ? '%'"; // выборка должников в фамилии которых есть словосочетание или любой набор букв
            // выборка должников которые имеют непогашеный долг свыше - х - лет (  > 3 лет - потенциально проблемные должники)
            final String sqlSelectDutyLotTime = "SELECT * FROM debtor AS d WHERE timestampdiff(year, agreement_date, CURDATE()) > ? AND duty != 0";
            final String sqlSelectDutyLotTimeSortDate = "SELECT * FROM debtor AS d WHERE timestampdiff(year, agreement_date, CURDATE()) > ? AND duty != 0 ORDER BY agreement_date";
            final String sqlSelectMaxDutyLotTimeLimit = "SELECT * FROM debtor AS d WHERE timestampdiff(year, agreement_date, CURDATE()) > ? AND duty != 0 ORDER BY duty DESC LIMIT ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectAll);
            System.out.println(Color.GREEN + "№ 1. Выборка всех должников" + Color.YELLOW);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                getPrint(rs);
            }
            System.out.println(Color.GREEN + "№ 2. Выборка должников долг которых больше определенной суммы (>100000 грн.)" + Color.BLUE);
            preparedStatement = connection.prepareStatement(sqlSelectMoreSum);
            preparedStatement.setInt(1, 100000);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                getPrint(rs);
            }

            System.out.println(Color.GREEN + "№ 3. Выборка должников долг которых погашен (сумма долга = 0 грн.)" + Color.DEFAULT);
            preparedStatement = connection.prepareStatement(sqlSelectEquals);
            preparedStatement.setInt(1, 0);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                getPrint(rs);
            }

            System.out.println(Color.GREEN + "№ 4. Выборка должников долг которых в диапозоне сум (долг > 40000 и < 100000 грн.)" + Color.BIRUZOVII);
            preparedStatement = connection.prepareStatement(sqlSelectRange);
            preparedStatement.setInt(1, 40000);
            preparedStatement.setInt(2, 100000);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                getPrint(rs);
            }

            System.out.println(Color.GREEN + "№ 5. Выборка должников фамилия который начинается на указанную букву или набор букв (Ба%)" + Color.YELLOW);
            preparedStatement = connection.prepareStatement(sqlSelectBeginLastName);
            preparedStatement.setString(1, "Ба%");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                getPrint(rs);
            }

            System.out.println(Color.GREEN + "№ 6. Выборка должников в фамилии которых есть словосочетание или любой набор букв (%ра%)" + Color.PING);
            preparedStatement = connection.prepareStatement(sqlSelectRangLastName);
            preparedStatement.setString(1, "ра%");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                getPrint(rs);
            }

            System.out.println(Color.GREEN + "№ 7. Выборка должников которые имеют непогашенный долг свыше - х - лет (  > 3 лет - потенциально проблемные должники)" + Color.RED);
            preparedStatement = connection.prepareStatement(sqlSelectDutyLotTime);
            preparedStatement.setInt(1, 3);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                getPrint(rs);
            }

            System.out.println(Color.GREEN + "№ 8. Выборка должников как в примере выше но отсортированных по дате оформления займа долг свыше - х - лет (  > 3 лет - потенциально проблемные должники)" + Color.DEFAULT);
            preparedStatement = connection.prepareStatement(sqlSelectDutyLotTimeSortDate);
            preparedStatement.setInt(1, 3);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                getPrint(rs);
            }

            System.out.println(Color.GREEN + "№ 9. Выборка x- кол-ва самых крупных должников, долг свыше х-лет отсортированы по спаданию сум долга ( 3шт.сам.крупных и долг > 3 лет - максимально проблемные должники)" + Color.BIRUZOVII);
            preparedStatement = connection.prepareStatement(sqlSelectMaxDutyLotTimeLimit);
            preparedStatement.setInt(1, 3);
            preparedStatement.setInt(2, 3);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                getPrint(rs);
            }

            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void getPrint(ResultSet rs) throws SQLException {
        System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
                + rs.getString(3) + " " + rs.getString(4) + " " + rs.getDouble(5) +
                " " + rs.getString(6) + " " + rs.getString(7) + " " + rs.getDate(8));
    }
}
