package controller.Product;

import model.Product;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/editPd")
public class EditProductServlet extends HttpServlet {
    ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        RequestDispatcher requestDispatcher;
        ProductService productService = new ProductService();

        if(action.equals("edit")) {
            int index = Integer.parseInt(request.getParameter("index"));
            Product product = productService.findAll().get(index);
            request.setAttribute("products", product);
            requestDispatcher = request.getRequestDispatcher("views/editProduct.jsp");
            requestDispatcher.forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        RequestDispatcher requestDispatcher;
        ProductService productService = new ProductService();

        if (action.equals("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String img = request.getParameter("img");
            double price = Double.parseDouble(request.getParameter("price"));
            int index = productService.findIndexById(id);
            Product product = new Product(id, name,img, price);
            productService.update(index, product);
            request.setAttribute("products", productService.findAll());
            requestDispatcher = request.getRequestDispatcher("views/ProductView.jsp");
            requestDispatcher.forward(request,response);
        }

    }
}
