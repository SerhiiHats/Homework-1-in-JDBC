import DBConnect.DBConnect;

import java.sql.*;

/**
 * Дополнительное задание
 * Задание
 * Создать базу данных в Workbench и подключить к IntelijIdea и создать тестовую таблицу.
 * Заполнить ее данными с помощью запросов MySQL в IntelijIdea.
 * Используя JDBC написать пример выполнения всех запросов.
 **/

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DBConnect.getConnection()) {
            try (Statement statement = connection.createStatement()) {
//                statement.executeUpdate("DROP TABLE customer");
//                statement.execute("CREATE TABLE customer(id_cust INT AUTO_INCREMENT PRIMARY KEY, last_name_cust VARCHAR(50), first_name_cust VARCHAR(50), phone_cust VARCHAR(15), email_cust VARCHAR(255), created_cust DATE)");
//                System.out.println("1. Созданa таблицa \"customer\".");
                System.out.println("1. Заполняем таблицу \"customer\" строками данных.");
                statement.execute("INSERT INTO customer (last_name_cust, first_name_cust, phone_cust, email_cust, created_cust) VALUES ('Капущу', 'Дмитро', '+38(067)8787214', 'veter1817@gmail.com', curdate())");
                statement.execute("INSERT INTO customer (last_name_cust, first_name_cust, phone_cust, email_cust, created_cust) VALUES ('Назаров', 'Вадим', '+38(068)9785411', 'yuristolgamileticho@ukr.net', curdate())");
                statement.execute("INSERT INTO customer (last_name_cust, first_name_cust, phone_cust, email_cust, created_cust) VALUES ('Крамаренко', 'Златослава', '+38(073)7772147', 'krafinright@ukr.net', curdate())");
                statement.execute("INSERT INTO customer (last_name_cust, first_name_cust, phone_cust, email_cust, created_cust) VALUES ('Степаненко', 'Олександр', '+38(067)5054278', 'incon17step@incon.com.ua', curdate())");
                statement.execute("INSERT INTO customer (last_name_cust, first_name_cust, phone_cust, email_cust, created_cust) VALUES ('Бурлаку', 'Іван', '+38(067)6568741', 'ivan.b.vich@gmail.com', curdate())");
                statement.execute("INSERT INTO customer (last_name_cust, first_name_cust, phone_cust, email_cust, created_cust) VALUES ('Ізотова', 'Оксана', '+38(068)4204217','regioki@ukr.net', curdate())");
                statement.execute("INSERT INTO customer (last_name_cust, first_name_cust, phone_cust, email_cust, created_cust) VALUES ('Хмельниченко', 'Олег', '+38(067)7273051', 'hmilnenko_ol@ukr.net', curdate())");
                System.out.println("     1.1. Tаблица была заполнена");

                System.out.println("2. Делаем полную выборку из таблицы \"customer\" , данные выводим в консоль");
                ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String lname = resultSet.getString(2);
                    String fname = resultSet.getString(3);
                    String phone = resultSet.getString(4);
                    String email = resultSet.getString(5);
                    Date date = resultSet.getDate(6);
                    System.out.println("    : id = " + id + " " + lname + " " + fname + " " + phone + " " + email + " " + date);
                }

                System.out.println("3. Делаем выборку из таблицы \"customer\" , где пользователь 'Вадим'");
                ResultSet rs = statement.executeQuery("SELECT * FROM customer WHERE first_name_cust = 'Вадим'");
                while (rs.next()) {
                    System.out.println("    : id = " + rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
                            + rs.getString(4) + " " + rs.getString(5) + " " + rs.getDate(6));
                }

                System.out.println("4. Получаем \"id\" пользователя 'Оксана'");
                rs = statement.executeQuery("SELECT id_cust, first_name_cust FROM customer WHERE first_name_cust = 'Оксана'");
                while (rs.next()) {
//                    System.out.println("    : id = " + rs.getInt(1) + " " + rs.getString(2));
                    System.out.println("    : id = " + rs.getInt("id_cust") + " " + rs.getString("first_name_cust"));
                }

                System.out.println("5. Получаем \"phone\" и \"email\" пользователя с \"id\" = 5");
                rs = statement.executeQuery("SELECT id_cust, phone_cust, email_cust FROM customer WHERE id_cust = 5");
                while (rs.next()) {
                    System.out.println("    : id = " + rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
                }

                System.out.println("6. Изменяем \"phone\" и \"email\" у пользователя с \"id\" = 5 : на на +38(067)7777777 и на vanya_ukrainian@ukr.net");
                statement.execute("UPDATE customer SET phone_cust = '+38(067)7777777', email_cust = 'vanya_ukrainian@ukr.net'  WHERE id_cust = 5");
                System.out.println("    6.1. Изменения прошло.");

                System.out.println("7. Проверяем изменения \"phone\" и \"email\" пользователя с \"id\" = 5");
                rs = statement.executeQuery("SELECT id_cust, phone_cust, email_cust FROM customer WHERE id_cust = 5");
                while (rs.next()) {
                    System.out.println("    : id = " + rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
                }

                System.out.println("8. Получаем количество записей в таблице \"customer\" ");
                rs = statement.executeQuery("SELECT COUNT(*) AS total_cust FROM customer");
                while (rs.next()) {
                    System.out.println("    : всего записей = " + rs.getInt(1));
                }

                System.out.println("9. Удалим пользователей в таблице \"customer\" с \"id\" = 2 и 4");
                statement.execute("DELETE FROM customer WHERE id_cust = 2");
                statement.execute("DELETE FROM customer WHERE id_cust = 4");
                System.out.println("    9.1. Удаление прошло.");

                System.out.println("10. Повторно делаем выборку из таблицы \"customer\", данные выводим в консоль");
                rs = statement.executeQuery("SELECT * FROM customer");
                while (rs.next()) {
                    System.out.println("    : id = " + rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
                            + rs.getString(4) + " " + rs.getString(5) + " " + rs.getDate(6));
                }

                System.out.println("11. Повторно получаем количество записей в таблице \"customer\" ");
                rs = statement.executeQuery("SELECT COUNT(*) AS total_cust FROM customer");
                while (rs.next()) {
                    System.out.println("    : всего записей = " + rs.getInt(1));
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
