package view;

import businessLogic.ClientDAO;
import businessLogic.ProductsDAO;
import dataAccess.Connection1;
import model.Client;
import model.Products;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

    private String numep;
    private String numec;
    private String address;
    private int idc;
    private int idp;
    private int cantitate;
    private int pret;
    private View view;
    private ViewProdus viewProdus;
    private ViewOrder viewOrder;
    public Controller(View view, ViewProdus viewProdus,ViewOrder viewOrder) {
        this.view = view;
        this.view.addAdaugareListener(new AdaugareListener());
        this.view.addEditareListener(new EditareListener());
        this.view.addStergereListener(new StergereListener());
        this.view.addVeziListener(new VeziListener());
        this.viewProdus=viewProdus;
        this.viewProdus.addAdaugare1Listener(new addAdaugare1Listener());
        this.viewProdus.addEditare1Listener(new addEditare1Listener());
        this.viewProdus.addStergere1Listener(new addStergere1Listener());
        this.viewProdus.addVezi1Listener(new addVezi1Listener());
        this.viewOrder=viewOrder;
        this.viewOrder.addComandaListener(new addComandaListener());
    }


    class AdaugareListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
                idc = Integer.parseInt(view.getTextIdClient());
                numec=view.getTextClient();
                address=view.getTextAdresa();
                Client c=new Client(idc,numec,address);
                ClientDAO ddd=new ClientDAO();
                ddd.insert(c);
        }
    }
    class EditareListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            numec=view.getTextClient();
            idc = Integer.parseInt(view.getTextIdClient());
            address=view.getTextAdresa();Client c1=new Client(idc,numec,address);
            ClientDAO ddd=new ClientDAO();
            ddd.update(c1);System.out.println("am editat clientul");
        }
    }
    class StergereListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            numec=view.getTextClient();
            idc = Integer.parseInt(view.getTextIdClient()); address=view.getTextAdresa();
            Client c1=new Client(idc,numec,address);
            ClientDAO ddd=new ClientDAO();
            ddd.delete(c1);System.out.println("am sters clientul");
        }
    }
    class VeziListener implements ActionListener {
        @Override

        public void actionPerformed(ActionEvent e) {
            Connection dbConnection = Connection1.getConnection();
             String updateStatementString = "SELECT * FROM client";
            PreparedStatement updateStatement = null;
            Object[][] data=new Object[100][100];
            try {
                Statement statement =dbConnection.createStatement();
            try {
                updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
               // ResultSet rs = updateStatement.getGeneratedKeys();
                 int i=0;
                ResultSet rs=statement.executeQuery(updateStatementString);
                while (rs.next()) {System.out.println("aaa");
                    int id = rs.getInt("id");
                    String numec = rs.getString("numec");
                    String address = rs.getString("address");
                    data[i][0]=id;
                    data[i][1]=numec;
                    data[i][2]=address;i++;
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
            String[] columnNames={"id","numec","address"};
            view.setTextJTable(data, columnNames);

        }
    }
    class addAdaugare1Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            idp = Integer.parseInt(viewProdus.getTextIdProdus());
            numep=viewProdus.getTextNumeProdus();
            cantitate=Integer.parseInt(viewProdus.getTextCantitateProdus());
            pret=Integer.parseInt(viewProdus.getTextPretProdus());System.out.println("aaa");
            Products p=new Products(idp,numep,cantitate,pret);
            ProductsDAO ddd=new ProductsDAO();
            ddd.insert(p);
        }
    }
    class addEditare1Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            numep=viewProdus.getTextNumeProdus();
            idp = Integer.parseInt(viewProdus.getTextIdProdus());
            cantitate=Integer.parseInt(viewProdus.getTextCantitateProdus());
            pret=Integer.parseInt(viewProdus.getTextPretProdus());
           Products p1=new Products(idp,numep,cantitate,pret);
            ProductsDAO ddd=new ProductsDAO();
            ddd.update(p1);System.out.println("am editat produsul");
        }
    }
    class addStergere1Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            numep=viewProdus.getTextNumeProdus();
            idp = Integer.parseInt(viewProdus.getTextIdProdus());
            cantitate=Integer.parseInt(viewProdus.getTextCantitateProdus());
            pret=Integer.parseInt(viewProdus.getTextPretProdus());
            Products p2=new Products(idp,numep,cantitate,pret);
            ProductsDAO ddd=new ProductsDAO();
            ddd.delete(p2);System.out.println("am sters producus");
        }
    }
    class addVezi1Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Connection dbConnection = Connection1.getConnection();
            String updateStatementString = "SELECT * FROM products";
            PreparedStatement updateStatement = null;
            Object[][] data=new Object[100][100];
            try {
                Statement statement =dbConnection.createStatement();
                try {
                    updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
                    int i=0;
                    ResultSet rs=statement.executeQuery(updateStatementString);
                    while (rs.next()) {System.out.println("aaa");
                        int id = rs.getInt("id");
                        String numep = rs.getString("numep");
                        int cantitate = rs.getInt("cantitate");
                        int pret = rs.getInt("pret");
                        data[i][0]=id;
                        data[i][1]=numep;
                        data[i][2]=cantitate;
                        data[i][3]=pret;i++;
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
            String[] columnNames={"id","numep","cantitate","pret"};
            viewProdus.setTextJTable(data, columnNames);

        }
        }
    class addComandaListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            //private static final String updateStatementString = "UPDATE client"
                   // + " set idc=?,numec=?,address=?"+"where idc=?";
            Connection dbConnection = Connection1.getConnection();
            String updateStatementString = "SELECT pret,cantitate FROM products where numep =?";
            String schimbareStatementString = "UPDATE products SET cantitate = ? WHERE numep =?";
            PreparedStatement updateStatement = null;
            PreparedStatement schimbareStatement=null;
            Object[][] data=new Object[100][100];
            //Statement statement =dbConnection.createStatement();
          //  try {
            //    updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
             //   int i=0;
             //   ResultSet rs=statement.executeQuery(updateStatementString);
            try {
                Statement statement =dbConnection.createStatement();
                try {
                    updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
                    updateStatement.setString(1, viewOrder.getTextNumeProdusOrdin());
                    System.out.println(updateStatementString);
                   // updateStatement=dbConnection.
                    updateStatement.executeQuery();//aici e baiul
                    //ResultSet rs = updateStatement.getGeneratedKeys();
                    // ResultSet rs=updateStatement.executeUpdate();//are ceva bai aici
                     ResultSet rs=updateStatement.executeQuery();

                    if(rs.next()) {
                        int pr = rs.getInt("pret");
                        int cantitate = rs.getInt("cantitate");//aflam cantitatea

                        if (Integer.parseInt(viewOrder.getTextCantitateOrdin()) < cantitate) {System.out.println("ccc");
                            int g =cantitate- Integer.parseInt(viewOrder.getTextCantitateOrdin()) ;
                            schimbareStatement = dbConnection.prepareStatement(schimbareStatementString, Statement.RETURN_GENERATED_KEYS);
                            schimbareStatement.setInt(1, g);
                            schimbareStatement.setString(2, viewOrder.getTextNumeProdusOrdin());
                           // ResultSet rs1 = schimbareStatement.executeUpdate(schimbareStatementString);
                             int z=pr*Integer.parseInt(viewOrder.getTextCantitateOrdin());
                            schimbareStatement.executeUpdate();
                            ResultSet rs1 = schimbareStatement.getGeneratedKeys();
                            System.out.println("fff");
                            FileWriter fw = null;
                            try {
                                fw = new FileWriter("fisier.txt");
                                 fw.write("Clientul " + viewOrder.getTextNumeClientOrdin() + " a cumparat " + viewOrder.getTextNumeProdusOrdin() +" in cantitate de " + viewOrder.getTextCantitateOrdin() + ". Totalul e:" + z+" lei");
                                 fw.close();
                                 JOptionPane.showMessageDialog(viewOrder,  "in cantitate de " + viewOrder.getTextCantitateOrdin() + ". Totalul e:" + z);

                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }


                        }
                    }
                    else JOptionPane.showMessageDialog(viewOrder,"nu avem atata cantitate");


                }
                catch(Exception em) {
                        em.printStackTrace(System.out);

                } finally {
                    Connection1.close(updateStatement);
                    Connection1.close(dbConnection);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}


