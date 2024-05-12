import java.sql.*;

public class OrdersJDBC {

    private static PreparedStatement statement = null;
    private static Connection connection = null;
    private static String url = "jdbc:mysql://localhost:3306/coffeeshop";
    private static String dbName = "root";
    private static String password = "";

    //testing
    public static void main(String[] args) {
        try {
            // CRUD operations
            deleteAllOrders();
            addOrder(1);
            addOrder(2);
            updateOrder(2, 3);
            addOrder(3);
            selectOrders();
            deleteOrder(2);
            deleteOrder(3);
            selectOrders();
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
    private static void addOrder(long customerID) throws SQLException {
        String queryStatement = "INSERT INTO orders (customer_id) VALUES (?)";
        try{
            setDbConnection();
            statement = connection.prepareStatement(queryStatement);
            statement.setLong(1, customerID);
            System.out.println("Order for the customer with ID " + customerID + " added.");

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

    private static void updateOrder(long orderID, long customerID) throws SQLException {
        String queryStatement = "UPDATE orders SET customer_id = (?) WHERE order_id = (?)";
        try{
            setDbConnection();
            statement = connection.prepareStatement(queryStatement);
            statement.setLong(1, customerID);
            statement.setLong(2, orderID);
            statement.executeUpdate();
            System.out.println("The order with ID " + orderID + " is updated.");

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

    private static void deleteOrder(long orderID) throws SQLException {
        String queryStatement = "DELETE FROM orders WHERE order_id = (?)";
        try{
            setDbConnection();
            statement = connection.prepareStatement(queryStatement);
            statement.setLong(1, orderID);
            statement.executeUpdate();
            System.out.println("Order with ID " + orderID + " is deleted.");
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


    private static void deleteAllOrders() throws SQLException {
        String queryStatement = "DELETE FROM orders";
        String queryStatement2 = "ALTER TABLE orders AUTO_INCREMENT=1";
        try{
            setDbConnection();
            statement = connection.prepareStatement(queryStatement);
            statement.executeUpdate();
            statement = connection.prepareStatement(queryStatement2);
            statement.executeUpdate();
            System.out.println("All orders deleted.");
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

    public static void selectOrders() throws SQLException {
        String queryStatement = "SELECT * FROM orders";
        try {
            setDbConnection();
            statement = connection.prepareStatement(queryStatement);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Order Table's content: ");
            while(resultSet.next()){
                long orderID = resultSet.getLong("order_id");
                long customerID = resultSet.getLong("customer_id");
                System.out.print(orderID + " " + customerID + "\n");
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }


}