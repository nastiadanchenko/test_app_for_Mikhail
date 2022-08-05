package com.nastiadanchenko;

import com.nastiadanchenko.entity.Category;
import com.nastiadanchenko.entity.Product;
import com.nastiadanchenko.repositories.CategoryRepository;
import com.nastiadanchenko.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

@AllArgsConstructor
@SpringBootApplication //(exclude={DataSourceAutoConfiguration.class})
public class App //implements ApplicationRunner
{
  //  private final ProductRepository productRepository;
  //  private CategoryRepository categoryRepository;
    public static void main( String[] args )
    {

        SpringApplication.run(App.class, args);
        System.setProperty("java.awt.headless", "false");
        try
        {
            String url = "jdbc:h2:tcp://localhost:9092/mem:product"; //?autoReconnect=true&useSSL=false";
            String user = "sa";
            String password = "sa";

            Connection con = DriverManager.getConnection(url, user, password);


//            String query = "SELECT * FROM CATEGORIES";
            String query =  "SELECT PRODUCTS.NAME, CATEGORIES.NAME , PRODUCTS.PRICE\n" +
            " FROM PRODUCTS INNER JOIN CATEGORIES ON PRODUCTS.CATEGORY_ID = CATEGORIES.ID";
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);

            String columns[] = { "Product name", "Category name", "Price" };
            String data[][] = new String[8][3];

            int i = 0;
            while (res.next()) {
//                String id = res.getString("ID");
                String productName = res.getString("PRODUCTS.NAME");
                String categoryName = res.getString("CATEGORIES.NAME");
                String price  = res.getString("Price");
//                data[i][0] = id + "";
                data[i][0] = productName;
                data[i][1] = categoryName;
                data[i][2] = price;
                i++;
            }

            DefaultTableModel model = new DefaultTableModel(data, columns);
            JTable table = new JTable(model);

//            JButton button = new JButton("submit");
//            button.setBounds(150, 150, 150, 20);
//            button.addActionListener(this);

            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            JScrollPane pane = new JScrollPane(table);
            JFrame f = new JFrame("Product table");
            JPanel panel = new JPanel();
            panel.add(pane);
            f.add(panel);
            f.setSize(500, 250);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        productRepository.save(new Product("Milk", 2.9, new Category("Food")));
//        productRepository.save(new Product("Meat", 10.9, new Category("Food")));
//        productRepository.save(new Product("Dress", 50.0, new Category("Clothes")));
//        productRepository.save(new Product("Jeans", 50.0, new Category("Clothes")));
//        System.out.println(productRepository.findAll());
//    }
}
