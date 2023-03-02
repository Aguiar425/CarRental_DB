import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CarRepository {

    List<Car> cars;

    public CarRepository() {
        this.cars = new LinkedList<>();
    }

    void createCar() throws SQLException, IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Statement statement = Main.getConnection().createStatement();
        System.out.println("Insert brand");
        String brand = input.readLine();
        System.out.println("Insert motor");
        String motor= input.readLine();
        System.out.println("Insert manufactured_date (YYYY-MM-DD)");
        Date date = Date.valueOf(input.readLine());
        System.out.println("Insert price for hour");
        int price = Integer.parseInt(input.readLine());
        System.out.println("Insert  the license plate");
        String licensePlate = input.readLine();

        // CREATING A QUERY
        String query = "INSERT INTO cars(brand, motor, manufactured_date, price_for_hour, license_plate) " +
                        "VALUES ( '" + brand + "', '" + motor + "', '" + date + "', " + price + ",'" + licensePlate + "');";

        //String query = "INSERT INTO clients(name, birth_date, email) VALUES ( " + name + ", " + birthdate + ", " + email + ");";

        // EXECUTING THE QUERY
        statement.executeUpdate(query);

        this.cars.add(new Car(brand,motor,date,price,licensePlate));
    }

    void getCar() throws SQLException, IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        // SELECT * FROM cars WHERE id = ?
        Connection connection = Main.getConnection();
        // CREATING A STATEMENT
        Statement statement = connection.createStatement();

        System.out.println("Insert the id you are looking for");
        int id = Integer.parseInt(input.readLine());
        String query = "SELECT * FROM cars WHERE id = " + id;

        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        System.out.println("ID: " + resultSet.getInt("id") + "\nBrand: " + resultSet.getString("brand") + "\nMotor: " + resultSet.getString("motor"));
    }

    void updateCar() throws SQLException, IOException {
        // UPDATE Customers SET name = ?, phone_number = ?, email = ? WHERE id = ?
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        // SELECT * FROM Customers WHERE id = ?
        Connection connection = Main.getConnection();
        // CREATING A STATEMENT
        Statement statement = connection.createStatement();

        System.out.println("Insert the id you want to update");
        int id = Integer.parseInt(input.readLine());

        System.out.println("Insert the NEW brand");
        String brand = input.readLine();

        System.out.println("Insert the NEW motor");
        String motor = input.readLine();

        System.out.println("Insert the NEW date (YYYY-MM-DD)");
        Date date = Date.valueOf(input.readLine());

        System.out.println("Insert the NEW price");
        int price = Integer.parseInt(input.readLine());

        System.out.println("Insert the NEW license plate");
        String licensePlate = input.readLine();

        String query = "UPDATE cars SET brand = '" + brand + "', motor = '" + motor + "', " +
                "manufactured_date = '" + date + "', price_for_hour = " + price + ", license_plate = '" + licensePlate +"' WHERE id = " + id;

        statement.execute(query);
        System.out.println("SUCCESSFUL CAR UPDATE! \n by Fil -2023");
    }

    void deleteCar(int id) throws SQLException {
        // DELETE FROM Customers WHERE id = ?

        // SELECT * FROM Customers WHERE id = ?
        Connection connection = Main.getConnection();
        // CREATING A STATEMENT
        Statement statement = connection.createStatement();

        String query = "DELETE FROM cars WHERE id = " + id;

        statement.execute(query);
        System.out.println("Car deleted!");
    }

    public List<Car> getCars() throws SQLException {

        Connection connection = Main.getConnection();
        // CREATING A STATEMENT
        Statement statement = connection.createStatement();

        // CREATING A QUERY
        String query = "SELECT * FROM cars";

        // EXECUTING THE QUERY
        ResultSet resultSet = statement.executeQuery(query);

        // DEALING WITH THE RESULTS
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String brand = resultSet.getString("brand");
            String motor = resultSet.getString("motor");
            Date date = resultSet.getDate("manufactured_date");
            int price = resultSet.getInt("price_for_hour");
            String licensePlate = resultSet.getString("license_plate");

            this.cars.add(new Car(brand,motor,date,price,licensePlate));
        }
        return this.cars;
    }
}

