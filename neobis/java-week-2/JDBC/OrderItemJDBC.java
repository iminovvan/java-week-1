import java.sql.*;


public class OrderItemJDBC {
    private static PreparedStatement statement = null;
    private static Connection connection = null;
    private static String url = "jdbc:mysql://localhost:3306/coffeeshop";
    private static String dbName = "root";
    private static String password = "";

    public static void main(String[] args) throws SQLException {
        try{
            //testing
            deleteAllOrderItems();
            addOrderItem(1,1,2);
            selectOrderItem();
            deleteOrderItem(1);
            selectOrderItem();

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
    //connection
    public static void setDbConnection() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,dbName, password);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //CRUD operations
    public static void addOrderItem(long orderID, long coffeeID, int quantity) throws SQLException {

        String queryStatement = "INSERT INTO OrderItem (order_id, coffee_id, quantity) VALUES (?,?,?)";
        try{
            setDbConnection();
            statement = connection.prepareStatement(queryStatement);
            statement.setLong(1, orderID);
            statement.setLong(2, coffeeID);
            statement.setInt(3, quantity);
            statement.executeUpdate();
            System.out.println("The order item with order ID " + orderID + " is added.");
        } catch (Exception e){
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

    public static void updateOrderItem(long orderItemID, long orderID, long coffeeID, int quantity) throws SQLException {
        String queryStatement = "UPDATE orderItem SET order_id = (?), coffee_id = (?), quantity = (?) WHERE order_item_id = (?)";
        try{
            setDbConnection();
            statement = connection.prepareStatement(queryStatement);
            statement.setLong(1, orderID);
            statement.setLong(2, coffeeID);
            statement.setInt(3, quantity);
            statement.setLong(4, orderItemID);
            statement.executeUpdate();
            System.out.println("Order Item with ID " + orderItemID + " is updated.");
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

    public static void deleteOrderItem(long orderItemID) throws SQLException {
        String queryStatement = "DELETE FROM orderItem WHERE order_item_id = (?)";
        try {
            setDbConnection();
            statement = connection.prepareStatement(queryStatement);
            statement.setLong(1, orderItemID);
            statement.executeUpdate();
            System.out.println("Order item with ID " + orderItemID + " is deleted." );
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

    public static void deleteAllOrderItems() throws SQLException {
        String queryStatement = "DELETE FROM orderItem";
        String queryStatement2 = "ALTER TABLE orderItem AUTO_INCREMENT=1";
        try{
            setDbConnection();
            statement = connection.prepareStatement(queryStatement);
            statement.executeUpdate();
            statement = connection.prepareStatement(queryStatement2);
            statement.executeUpdate();
            System.out.println("All order items deleted.");
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

    public static void selectOrderItem() throws SQLException {
        String queryStatement = "SELECT * FROM orderItem";
        try {
            setDbConnection();
            statement = connection.prepareStatement(queryStatement);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Order Item Table's content: ");
            while(resultSet.next()){
                long orderItemID = resultSet.getLong("order_item_id");
                long orderID = resultSet.getLong("order_id");
                long coffeeID = resultSet.getLong("coffee_id");
                int quantity = resultSet.getInt("quantity");
                System.out.print(orderItemID + " " + orderID + " " + coffeeID +  " " + quantity + "\n");
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

