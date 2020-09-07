import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.util.Scanner;

public class Metod {
    public static void main(String[] argv) {
        Scanner in = new Scanner(System.in);

        QueryManager queryManager = new QueryManager();
        queryManager.search(in.next());
        queryManager.drop(in.next());
        queryManager.create(in.next());


        in.close();

    }


}
