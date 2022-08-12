package view;
import dataAccess.Connection1;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewOrder extends JFrame{
        private JLabel selectareProdus,selectareClient,introducetiCantitate;
        private  JComboBox comboBox,comboBox_1;
        private JTextField textField;
        private JButton comanda;
    public ViewOrder() {

            this.setBounds(100, 100, 1173, 617);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.getContentPane().setLayout(null);

             selectareProdus = new JLabel("Selectare produs");
            selectareProdus.setFont(new Font("Tahoma", Font.PLAIN, 16));
            selectareProdus.setBounds(28, 31, 134, 59);
            this.getContentPane().add(selectareProdus);

             selectareClient = new JLabel("Selectare client:");
            selectareClient.setFont(new Font("Tahoma", Font.PLAIN, 16));
            selectareClient.setBounds(432, 31, 127, 59);
            this.getContentPane().add(selectareClient);

            introducetiCantitate = new JLabel("Introduceti Cantitate:");
            introducetiCantitate.setFont(new Font("Tahoma", Font.PLAIN, 16));
            introducetiCantitate.setBounds(834, 31, 154, 59);
            this.getContentPane().add(introducetiCantitate);

             comboBox = new JComboBox();
             comboBox.setBounds(28, 110, 154, 21);
        Connection dbConnection1 = Connection1.getConnection();
        String updateStatementString1 = "SELECT * FROM products";
        PreparedStatement updateStatement1 = null;
        try {
            Statement statement =dbConnection1.createStatement();
            try {
                updateStatement1 = dbConnection1.prepareStatement(updateStatementString1, Statement.RETURN_GENERATED_KEYS);
                int i=0;
                ResultSet rs=statement.executeQuery(updateStatementString1);
                while (rs.next()) {System.out.println("aaa");
                    int id = rs.getInt("id");
                    String numep = rs.getString("numep");
                    int cantitate = rs.getInt("cantitate");
                    int pret = rs.getInt("pret");
                   comboBox.addItem(numep);
                }
            } catch (SQLException ex) {
                System.out.println("eroare");
            } finally {
                Connection1.close(updateStatement1);
                Connection1.close(dbConnection1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            this.getContentPane().add(comboBox);

            comboBox_1 = new JComboBox();
            comboBox_1.setBounds(405, 110, 154, 21);
        Connection dbConnection = Connection1.getConnection();
        String updateStatementString = "SELECT * FROM client";
        PreparedStatement updateStatement = null;
        try {
            Statement statement =dbConnection.createStatement();
            try {
                updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
                // ResultSet rs = updateStatement.getGeneratedKeys();
                int i=0;
                ResultSet rs=statement.executeQuery(updateStatementString);
                while (rs.next()) {System.out.println("aaa");
                    int id = rs.getInt("id");
                    String numec1 = rs.getString("numec");
                    String address = rs.getString("address");
                    comboBox_1.addItem(numec1);
                }
            } catch (SQLException ex) {
                System.out.println("eroare");
            } finally {
                Connection1.close(updateStatement);
                Connection1.close(dbConnection);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            this.getContentPane().add(comboBox_1);

            textField = new JTextField();
            textField.setBounds(863, 122, 96, 19);
            this.getContentPane().add(textField);
            textField.setColumns(10);

            comanda = new JButton("Comanda");
            comanda.setFont(new Font("Tahoma", Font.PLAIN, 16));
            comanda.setBounds(859, 229, 145, 54);
            this.getContentPane().add(comanda);
            this.setVisible(true);
        }
    public String getTextNumeProdusOrdin(){
        return comboBox.getSelectedItem().toString();
    }
    public String getTextNumeClientOrdin(){
        return comboBox_1.getSelectedItem().toString();
    }
    public String getTextCantitateOrdin(){
        return textField.getText();
    }
    public void addComandaListener(ActionListener action) {
        comanda.addActionListener(action);
    }
}
