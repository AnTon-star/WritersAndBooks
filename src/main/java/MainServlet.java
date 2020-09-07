import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/hello")
public class MainServlet extends HttpServlet {


    @Override
     public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        QueryManager queryManager = new QueryManager();
        String book = queryManager.search(req.getParameter("writer_name").toLowerCase());



        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("Our book name is " + book);
        printWriter.close();
    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QueryManager queryManager = new QueryManager();
        String writer = queryManager.drop(request.getParameter("delete_writer_name").toLowerCase());
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.write("Writer " + writer);
        printWriter.close();


    }
    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost works");
        QueryManager queryManager = new QueryManager();
        String writer = queryManager.create(request.getParameter("add_writer_name").toLowerCase());
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.write("Writer name is add " + writer);
        printWriter.close();
    }





}
