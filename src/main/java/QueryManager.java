import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryManager {


    public String search(String writersName) {
        Connection connection = null;
        connection = Parameters.connect();
        String bookName = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT b.books_name FROM writers INNER JOIN writers_books on writers.id_writers = writers_books.id_writers inner join books b on writers_books.id_books = b.id_books where writers.writers_name = '" + writersName.toLowerCase() + "'");
            while (resultSet.next()) {
                bookName = bookName + " " + resultSet.getString(1);
                System.out.println("autor name = " + writersName);
                System.out.println(" Book name = " + bookName);
            }
            connection.close();

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }

        return bookName;

    }

    public String drop(String dropWriters) {
        Connection connection = null;
        connection = Parameters.connect();

        try {
            Statement statement = connection.createStatement();
            String query = "DELETE  FROM writers WHERE writers_name = '" + dropWriters.toLowerCase() + "'";
            statement.executeUpdate(query);
            System.out.println("Added name");
            connection.close();


        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
       return dropWriters.toLowerCase() + " delete";
    }

    public String create(String createWriters) {
        Connection connection = null;
        connection = Parameters.connect();
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO writers(id_writers, writers_name) VALUES (8, '" + createWriters.toLowerCase() + "')";

            statement.executeUpdate(query);
            System.out.println("Added name");
            connection.close();

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }

        return createWriters;
    }
}
