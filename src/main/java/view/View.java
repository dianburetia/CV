package view;

import javax.swing.*;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
public class View extends JFrame{

        private JTextField textField;
        private JTextField textField_1;
        private JTable table;
        private JLabel id;
        private JLabel nume;
        private JTextField textField_2;
        private JLabel lblNewLabel;
    private JButton buttonAdaugare;
    private JButton buttonStergere;
    private JButton buttonEditare;
    private JButton btnAfisareListaDe;
    private JFrame FrameAfisareTabela;
        public  View() {

            this.setBounds(100, 100, 1071, 668);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.getContentPane().setLayout(null);

             id = new JLabel("ID:");
            id.setFont(new Font("Tahoma", Font.PLAIN, 18));
            id.setBounds(28, 54, 55, 22);
            this.getContentPane().add(id);

             nume = new JLabel("Nume:");
            nume.setFont(new Font("Tahoma", Font.PLAIN, 18));
            nume.setBounds(22, 99, 73, 33);
            this.getContentPane().add(nume);

            textField = new JTextField();
            textField.setBounds(120, 59, 96, 19);
            this.getContentPane().add(textField);
            textField.setColumns(10);

            textField_1 = new JTextField();
            textField_1.setBounds(120, 109, 96, 19);
            this.getContentPane().add(textField_1);
            textField_1.setColumns(10);

             buttonAdaugare = new JButton("Adaugare client");
            buttonAdaugare.setFont(new Font("Tahoma", Font.PLAIN, 18));
            buttonAdaugare.setBounds(346, 53, 199, 25);
            this.getContentPane().add(buttonAdaugare);

             buttonStergere = new JButton("Stergere client");
            buttonStergere.setFont(new Font("Tahoma", Font.PLAIN, 18));
            buttonStergere.setBounds(346, 108, 199, 25);
            this.getContentPane().add(buttonStergere);

           buttonEditare = new JButton("Editare client");
            buttonEditare.setFont(new Font("Tahoma", Font.PLAIN, 18));
            buttonEditare.setBounds(57, 157, 199, 25);
            this.getContentPane().add(buttonEditare);

             btnAfisareListaDe = new JButton("Afisare lista de clienti");
            btnAfisareListaDe.setFont(new Font("Tahoma", Font.PLAIN, 18));
            btnAfisareListaDe.setBounds(728, 157, 230, 25);
            this.getContentPane().add(btnAfisareListaDe);
            textField_2 = new JTextField();
            textField_2.setBounds(862, 59, 96, 19);
            this.getContentPane().add(textField_2);
            textField_2.setColumns(10);

             lblNewLabel = new JLabel("Adresa:");
            lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
            lblNewLabel.setBounds(701, 62, 85, 13);
            this.getContentPane().add(lblNewLabel);
            this.setVisible(true);

        }
    public void addAdaugareListener(ActionListener action) {
        buttonAdaugare.addActionListener(action);
    }
    public void addEditareListener(ActionListener action) {
        buttonEditare.addActionListener(action);
    }
    public void addStergereListener(ActionListener action) {
        buttonStergere.addActionListener(action);
    }
    public void addVeziListener(ActionListener action) {
        btnAfisareListaDe.addActionListener(action);
    }
    public String getTextIdClient(){
        return textField.getText();
    }
    public String getTextClient(){
        return textField_1.getText();
    }
    public String getTextAdresa(){return textField_2.getText();}
    public void setTextJTable(Object[][] data,Object column[]){
        FrameAfisareTabela = new JFrame();
        FrameAfisareTabela.setTitle("Afisare tabel");
        table = new JTable(data, column);
        table.setBounds(57, 620, 880, -363);
        this.getContentPane().add(table);
        this.setVisible(true);
        JScrollPane sp = new JScrollPane(table);
        FrameAfisareTabela.add(sp);
        FrameAfisareTabela.setSize(500, 200);
        FrameAfisareTabela.setVisible(true);


    }
}
