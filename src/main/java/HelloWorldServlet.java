import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter output = res.getWriter();

        String aName = req.getParameter("name");  // if case is not present it will be NULL
        if ("daniel".equalsIgnoreCase(aName)) {
            output.println("<h1>Hello Daniel!</h1>".toUpperCase());

        } else if ("elijah".equalsIgnoreCase(aName)) {
            output.println("<h1>Hello Elijah!</h1>".toLowerCase());

        } else {
            output.printf("<h1>Hello %s!</h1>", aName);
        }
    }
}
