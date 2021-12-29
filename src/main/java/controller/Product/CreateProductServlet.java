package controller.Product;

import dao.ProductDao;
import model.Product;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/createPd")
public class CreateProductServlet extends HttpServlet {
    ProductDao productDao = new ProductDao();
    ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        requestDispatcher = req.getRequestDispatcher("/views/CreateProduct.jsp");
        requestDispatcher.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("create")) {
            String name = request.getParameter("name");
            String img = request.getParameter("img");
            double price = Double.parseDouble(request.getParameter("price"));
            Product product = new Product(name,img,price);
            int id = productDao.createProduct(product);
            product.setId(id);
            request.setAttribute("products", productService.findAll());
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("views/ProductView.jsp");
            requestDispatcher.forward(request,response);
        }


    }
}
