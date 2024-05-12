import java.sql.*;

public class CustomersJDBC {

    private static PreparedStatement statement = null;
    private static Connection connection = null;
    private static String url = "jdbc:mysql://localhost:3306/coffeeshop";
    private static String dbName = "root";
    private static String password = "";

    //testing
    public static void main(String[] args) {
        try {
            // CRUD operations
            deleteAllCustomers();
            ///*
            addCustomer("Jennie", "Kim", 28, "jennie.kim@gmail.com");
            addCustomer("Rose", "Park", 27, "rose.park@gmail.com");
            selectCustomers();
            addCustomer("Nayeon", "Im", 28, "jihyo.park@gmail.com");
            updateCustomer(3, "Nayeon", "Im", 28, "nayeon.im@gmail.com");
            deleteCustomer(1);
            selectCustomers();
             //*/
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    //setting connection method
    public static void setDbConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,dbName, password);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //adding data method
    private static void addCustomer(String firstName, String secondName, int age, String email) throws SQLException {
        String queryStatement = "INSERT INTO customers (first_name, second_name, age, email) VALUES (?, ?, ?, ?)";
        try{
            setDbConnection();
            statement = connection.prepareStatement(queryStatement);
            statement.setString(1, firstName);
            statement.setString(2, secondName);
            statement.setInt(3, age);
            statement.setString(4, email);
            statement.executeUpdate();
            System.out.println("Customer " + firstName + " " + secondName + " added.");

            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    //updating existing customer's data
    private static void updateCustomer(long customerID, String firstName, String secondName, int age, String email) throws SQLException {
        String queryStatement = "UPDATE customers SET first_name = (?), second_name = (?), age = (?), email = (?) WHERE customer_id = (?)";
        try{
            setDbConnection();
            statement = connection.prepareStatement(queryStatement);
            statement.setString(1, firstName);
            statement.setString(2, secondName);
            statement.setInt(3, age);
            statement.setString(4, email);
            statement.setLong(5, customerID);
            statement.executeUpdate();
            System.out.println("Customer's data with ID " + customerID + " is updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    //deleting existing customer's data
    private static void deleteCustomer(long customerID) throws SQLException {
        String queryStatement = "DELETE FROM customers WHERE customer_id = (?)";
        try{
            setDbConnection();
            statement = connection.prepareStatement(queryStatement);
            statement.setLong(1,customerID);
            statement.executeUpdate();
            System.out.println("Customer with ID " + customerID + " is deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    //selecting customer
    private static void selectCustomers() throws SQLException {
        String queryStatement = "SELECT * FROM customers";
        try{
            setDbConnection();
            statement = connection.prepareStatement(queryStatement);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Customer Table's content: ");
            while(resultSet.next()){
                long customerID = resultSet.getLong("customer_id");
                String firstName = resultSet.getString("first_name");
                String secondName = resultSet.getString("second_name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                System.out.print(customerID + " " + firstName + " " + secondName + " " + age + " " + email + "\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    private static void deleteAllCustomers() throws SQLException {
        String queryStatement = "DELETE FROM customers";
        String queryStatement2 = "ALTER TABLE customers AUTO_INCREMENT=1";
        try{
            setDbConnection();
            statement = connection.prepareStatement(queryStatement);
            statement.executeUpdate();
            statement = connection.prepareStatement(queryStatement2);
            statement.executeUpdate();
            System.out.println("All customers deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }


}
