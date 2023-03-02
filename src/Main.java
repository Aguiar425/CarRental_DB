import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        ClientRepository clientRepository = new ClientRepository();

        try {
            clientRepository.getClients().forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        //clientRepository.createClient();
        clientRepository.getClient();
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

    /*public static List<Client> getClients() throws SQLException {

        List<Client> clients = new LinkedList<>();

        Connection connection = getConnection();
        // CREATING A STATEMENT
        Statement statement = connection.createStatement();

        // CREATIING A QUERY
        String query = "SELECT * FROM clients";

        // EXECUTING THE QUERY
        ResultSet resultSet = statement.executeQuery(query);

        // DEALING WITH THE RESULTS
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Date birthDate = resultSet.getDate("birth_date");
            String email = resultSet.getString("email");

            clients.add(new Client(name, birthDate, email));

        }
        return clients;
    }*/
}