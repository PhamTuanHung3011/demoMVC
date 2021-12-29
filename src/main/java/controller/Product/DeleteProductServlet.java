package controller.Product;

import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/deletePd")
public class DeleteProductServlet extends HttpServlet {
    ProductService productService = new ProductService();
    RequestDispatcher requestDispatcher;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action.equals("delete")) {
            int index = Integer.parseInt(req.getParameter("index"));
            productService.delete(index);
            req.setAttribute("products",productService.findAll());
            requestDispatcher = req.getRequestDispatcher("/views/ProductView.jsp");
            requestDispatcher.forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
