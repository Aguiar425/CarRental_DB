import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ClientRepository {

    List<Client> clients;

    public ClientRepository() {
        this.clients = new LinkedList<>();
    }

    void createClient() throws SQLException, IOException {
        // INSERT INTO Customers (name, phone_number, email) VALUES (?,?,?)

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Statement statement = Main.getConnection().createStatement();
        System.out.println("Insert name");
        String name = input.readLine();
        System.out.println("Insert birthdate (YYYY-MM-DD) ");
        Date birthdate = Date.valueOf(input.readLine());
        System.out.println("Insert your email");
        String email = input.readLine();

        // CREATIING A QUERY
        String query = "INSERT INTO clients(name, birth_date, email) VALUES ( '" + name + "', '" + birthdate + "', '" + email + "');";
        //String query = "INSERT INTO clients(name, birth_date, email) VALUES ( " + name + ", " + birthdate + ", " + email + ");";

        // EXECUTING THE QUERY
        statement.executeUpdate(query);

        this.clients.add(new Client(name, birthdate, email));
    }

    void getClient() throws SQLException, IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        // SELECT * FROM Customers WHERE id = ?
        Connection connection = Main.getConnection();
        // CREATING A STATEMENT
        Statement statement = connection.createStatement();

        System.out.println("Insert the id you are  looking for");
        int id = Integer.parseInt(input.readLine());
        String query = "SELECT * FROM clients WHERE id = " + id;

        ResultSet resultSet = statement.executeQuery(query);
        System.out.println(resultSet);
        resultSet.next();
        System.out.println("ID: " + resultSet.getInt("id") + "\nName: " + resultSet.getString("name"));
    }

    Client updateClient(Client client) {
        // UPDATE Customers SET name = ?, phone_number = ?, email = ? WHERE id = ?
        return null;
    }

    void deleteClient(int id) {
        // DELETE FROM Customers WHERE id = ?
    }

    public List<Client> getClients() throws SQLException {

        Connection connection = Main.getConnection();
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

            this.clients.add(new Client(name, birthDate, email));

        }
        return this.clients;
    }
}
