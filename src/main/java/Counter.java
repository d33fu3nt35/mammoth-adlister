import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Counter", urlPatterns = "/count")
public class Counter extends HttpServlet {

    private int Counter = 0;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter output = res.getWriter();

        Counter++;
        output.println("You viewed this page " + Counter + " times!");

    }

}