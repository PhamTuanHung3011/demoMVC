package service;

import dao.ProductDao;
import model.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
   ProductDao productDao = new ProductDao();
    public static List<Product> products;

    {
        try {
            products = productDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public List<Product> findAll() {
        try {
            products = productDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void createProduct(Product product) {
        products.add(product);
        productDao.createProduct(product);
    }

    public void delete(int index) {
        productDao.deleteProduct(products.get(index).getId());
        try {
            products = productDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // loi lien quan den EditProductServlet
    public void update(int index, Product product) {
        productDao.updateProduct(index, product);
        try {
            products = productDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int findIndexById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
