package Servlets;
import II_Functions.IICreate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestGetUpClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		IICreate II = new IICreate(new int[] {3,4,5,4,2});
//		String res = II.getResult(new double[] {0,1,0});
//		System.out.println(res);
//		
//		PrintWriter file = new PrintWriter("C:\\Users\\я\\eclipse-workspace\\workspace\\MathAndDataSciensTools.web\\src\\main\\java\\II_Functions\\Binder.txt", "UTF-8");
//		file.println(res);
//		file.close();
		
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        // Process request here if needed

        response.getWriter().write("Hello from Servlet!");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
