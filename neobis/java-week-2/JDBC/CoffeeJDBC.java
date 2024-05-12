import java.sql.*;


public class CoffeeJDBC {
    private static PreparedStatement statement = null;
    private static Connection connection = null;
    private static String url = "jdbc:mysql://localhost:3306/coffeeshop";
    private static String dbName = "root";
    private static String password = "";

    public static void main(String[] args) throws SQLException {
        try{
            //testing
            deleteAllCoffee();
            ///*
            addCoffee("Americano", 350, 3.00, "Yes");
            addCoffee("Cappuccino", 400, 3.50, "No");
            addCoffee("Latte", 450, 4.50, "No");
            selectCoffee();
            updateCoffee(3, "Latte", 400, 4.00, "No");
            deleteCoffee(2);
            selectCoffee();

            //*/
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
    public static void addCoffee(String coffeeName, int volume, double price, String withIce) throws SQLException {

        String queryStatement = "INSERT INTO coffee (name_coffee, volume, price, with_ice) VALUES (?,?,?,?)";
        try{
            setDbConnection();
            statement = connection.prepareStatement(queryStatement);
            statement.setString(1, coffeeName);
            statement.setInt(2, volume);
            statement.setDouble(3, price);
            statement.setString(4, withIce);
            statement.executeUpdate();
            System.out.println("The coffee " + coffeeName + " is added.");
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

    public static void updateCoffee(long coffeeID, String coffeeName, int volume, double price, String withIce) throws SQLException {
        String queryStatement = "UPDATE coffee SET name_coffee = (?), volume = (?), price = (?), with_ice = (?) WHERE coffee_id = (?)";
        try{
            setDbConnection();
            statement = connection.prepareStatement(queryStatement);
            statement.setString(1, coffeeName);
            statement.setInt(2, volume);
            statement.setDouble(3, price);
            statement.setString(4, withIce);
            statement.setLong(5, coffeeID);
            statement.executeUpdate();
            System.out.println("Coffee with ID " + coffeeID + " is updated.");
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

    public static void deleteCoffee(long coffeeID) throws SQLException {
        String queryStatement = "DELETE FROM coffee WHERE coffee_id = (?)";
        try {
            setDbConnection();
            statement = connection.prepareStatement(queryStatement);
            statement.setLong(1, coffeeID);
            statement.executeUpdate();
            System.out.println("Coffee with ID " + coffeeID + " is deleted." );
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

    public static void deleteAllCoffee() throws SQLException {
        String queryStatement = "DELETE FROM coffee";
        String queryStatement2 = "ALTER TABLE coffee AUTO_INCREMENT=1";
        try{
            setDbConnection();
            statement = connection.prepareStatement(queryStatement);
            statement.executeUpdate();
            statement = connection.prepareStatement(queryStatement2);
            statement.executeUpdate();
            System.out.println("All coffee deleted.");
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

    public static void selectCoffee() throws SQLException {
        String queryStatement = "SELECT * FROM coffee";
        try {
            setDbConnection();
            statement = connection.prepareStatement(queryStatement);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Coffee Table's content: ");
            while(resultSet.next()){
                long coffeeID = resultSet.getLong("coffee_id");
                String coffeeName = resultSet.getString("name_coffee");
                int volume = resultSet.getInt("volume");
                double price = resultSet.getDouble("price");
                boolean withIce = resultSet.getBoolean("with_ice");
                System.out.print(coffeeID + " " + coffeeName + " " + volume + " " + price + " " + withIce + "\n");
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
