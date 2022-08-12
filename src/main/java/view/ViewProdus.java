package view;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;

public class ViewProdus extends JFrame{
        private JTextField textField;
        private JTextField textField_1;
        private JTextField textField_2,textField_3;
        private JTable table;
        private JFrame FrameAfisareTabela;
        private JButton adaugareProdus, ediaterProdus,stergereProdus,veziProduse;
        private JLabel id,numep,cantitate, lblNewLabel;
        public ViewProdus() {
            this.setBounds(100, 100, 1100, 600);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.getContentPane().setLayout(null);

             id = new JLabel("ID");
            id.setFont(new Font("Tahoma", Font.PLAIN, 18));
            id.setBounds(27, 105, 45, 13);
            this.getContentPane().add(id);

             numep = new JLabel("Nume produs");
            numep.setFont(new Font("Tahoma", Font.PLAIN, 18));
            numep.setBounds(27, 160, 108, 13);
            this.getContentPane().add(numep);

             cantitate = new JLabel("Cantitate");
            cantitate.setFont(new Font("Tahoma", Font.PLAIN, 18));
            cantitate.setBounds(27, 229, 74, 13);
            this.getContentPane().add(cantitate);

            textField = new JTextField();
            textField.setBounds(111, 102, 96, 19);
            this.getContentPane().add(textField);
            textField.setColumns(10);

            textField_1 = new JTextField();
            textField_1.setBounds(145, 160, 96, 19);
            this.getContentPane().add(textField_1);
            textField_1.setColumns(10);

            textField_2 = new JTextField();
            textField_2.setBounds(124, 229, 96, 19);
            this.getContentPane().add(textField_2);
            textField_2.setColumns(10);

             adaugareProdus = new JButton("Adaugare produs");
            adaugareProdus.setFont(new Font("Tahoma", Font.PLAIN, 16));
            adaugareProdus.setBounds(419, 89, 190, 29);
            this.getContentPane().add(adaugareProdus);

             ediaterProdus = new JButton("Editare produs");
            ediaterProdus.setFont(new Font("Tahoma", Font.PLAIN, 16));
            ediaterProdus.setBounds(424, 149, 185, 29);
            this.getContentPane().add(ediaterProdus);

             stergereProdus = new JButton("Stergere produs");
            stergereProdus.setFont(new Font("Tahoma", Font.PLAIN, 16));
            stergereProdus.setBounds(419, 215, 190, 27);
            this.getContentPane().add(stergereProdus);

             veziProduse = new JButton("Vezi toate produsele");
            veziProduse.setFont(new Font("Tahoma", Font.PLAIN, 16));
            veziProduse.setBounds(725, 115, 242, 65);
            this.getContentPane().add(veziProduse);

            JLabel lblNewLabel = new JLabel("Pret");
            lblNewLabel.setBounds(27, 58, 45, 13);
            this.getContentPane().add(lblNewLabel);

            textField_3 = new JTextField();
            textField_3.setBounds(111, 55, 96, 19);
            this.getContentPane().add(textField_3);
            textField_3.setColumns(10);

            table = new JTable();
            table.setBounds(27, 298, 1012, 257);
            this.getContentPane().add(table);
            this.setVisible(true);
        }
    public void addAdaugare1Listener(ActionListener action) {
        adaugareProdus.addActionListener(action);
    }
    public void addEditare1Listener(ActionListener action) {
        ediaterProdus.addActionListener(action);
    }
    public void addStergere1Listener(ActionListener action) {
        stergereProdus.addActionListener(action);
    }
    public void addVezi1Listener(ActionListener action) {
        veziProduse.addActionListener(action);
    }
    public String getTextIdProdus(){
            return textField.getText();
    }
    public String getTextNumeProdus(){
            return textField_1.getText();
    }
    public String getTextCantitateProdus(){
            return textField_2.getText();
    }
    public String getTextPretProdus(){
        return textField_3.getText();
    }
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
