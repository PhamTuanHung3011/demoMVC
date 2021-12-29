package dao;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private Connection connection = ConnectMySql.getConnection();

    public List<Product> getAll() throws SQLException {
        String sqlGetAll = "SELECT * FROM product";
        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlGetAll);
            List<Product> productList = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String img = resultSet.getString("img");
                double price = resultSet.getDouble("price");

                productList.add(new Product(id, name, img, price));
            }
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int createProduct(Product product) {
        String sqlCreate = "INSERT INTO product (`name`, `img`, `price`) VALUES ( ?, ?, ?)";
        int id=-1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreate);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getImg());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.execute();
            String select = "SELECT id FROM product WHERE name = ? and img = ? and price = ? ";
            PreparedStatement pS = connection.prepareStatement(select);
            pS.setString( 1, product.getName());
            pS.setString(2,product.getImg());
            pS.setDouble(3,product.getPrice());
            ResultSet rs = pS.executeQuery();
            id = rs.getInt("id");
        }
        catch (Exception e){
           e.printStackTrace();
        }
        return id;
    }

    public void deleteProduct(int id) {
        String sqlDelete = "delete from product where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        // dang bi loi index và id
    public void updateProduct(int index, Product product) {
        String sqlUpdate = "update product set name = ? , img = ? , price = ? where id=? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sqlUpdate);

            ps.setString(1, product.getName());
            ps.setString(2, product.getImg());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getId());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}