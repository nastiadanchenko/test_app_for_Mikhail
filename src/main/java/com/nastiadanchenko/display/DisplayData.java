package com.nastiadanchenko.display;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DisplayData extends JFrame implements ActionListener {
    private JButton button;
    private JFrame f;

    private Connection con;
    private Statement st;

    private String columnsName[] = {"Product name", "Category name", "Price"};
    private String data[][] = new String[8][3];
    private static JTable table;

    private final String url = "jdbc:h2:tcp://localhost:9092/mem:product"; //?autoReconnect=true&useSSL=false";
    private final String user = "sa";
    private final String password = "sa";

    public DisplayData() throws HeadlessException {


        button = new JButton("Submit");
        button.setBounds(90, 90, 100, 50);
        button.addActionListener(this);

        setTitle("Fetching Products Info From DataBase");
        setLayout(null);
        setVisible(true);
        setBounds(300, 200, 300, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        add(button);
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            showTableData();
        }
    }

    private void showTableData() {
        f = new JFrame("Database Search Result");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setBounds(300, 200, 300, 200);

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnsName);
        table = new JTable(model);
        table.setShowGrid(true);
        table.setShowVerticalLines(true);
        table.setFillsViewportHeight(true);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JPanel panel = new JPanel();
        panel.add(scroll);


        String query = "SELECT PRODUCTS.NAME, CATEGORIES.NAME , PRODUCTS.PRICE\n" +
                " FROM PRODUCTS INNER JOIN CATEGORIES ON PRODUCTS.CATEGORY_ID = CATEGORIES.ID ORDER BY CATEGORIES.NAME";

        try {
            ResultSet res = st.executeQuery(query);
            int i = 0;
            while (res.next()) {
                String productName = res.getString("PRODUCTS.NAME");
                String categoryName = res.getString("CATEGORIES.NAME");
                String price = res.getString("PRICE");
                model.addRow(new Object[]{productName, categoryName, price});
                i++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        f.add(scroll);
        f.setVisible(true);
        f.setSize(400, 300);

    }
}
