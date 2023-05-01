package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BuyerEmailController")
public class BuyerEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuyerEmailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Brand 	= request.getParameter("carBrand");
		String Model 	= request.getParameter("carModel");
		String Colour 	= request.getParameter("carColour");
		String Year 	= request.getParameter("carYear");
		String message = "   Car Brand:              "+ Brand+"\n"+
						 "   Car Model:              "+ Model+"\n"+
						 "   Car year model:       "+ Year+"\n"+
						 "   Car Colour:             "+ Colour+"\n";
		request.setAttribute("carSpecs", message);
		request.getRequestDispatcher("buycarlanding.jsp").forward(request, response);
	}
}
