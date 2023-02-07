package curso.miniapi.S4_MiniApi2.interfaces;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public interface RequestHandler {

    public abstract String handleRequest(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException;

}