import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        ClientRepository clientRepository = new ClientRepository();
        CarRepository carRepository = new CarRepository();

        try {
            clientRepository.getClients().forEach(System.out::println);
            carRepository.getCars().forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        //clientRepository.createClient();
        //clientRepository.getClient();

        //clientRepository.updateClient();
        //clientRepository.deleteClient(3);

        //carRepository.getCars();
        //carRepository.createCar();
        //carRepository.getCar();
        //carRepository.updateCar();

    }

    public static Connection getConnection() {

        String dbURL = "jdbc:mysql://localhost:3306/Car_Rental2";
        String username = "root";
        String password = "teste";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException ex) {
            System.out.println("Connection failed: " + ex.getMessage());
        }

        return connection;
    }
}