package view;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;

public class View extends JFrame{
        private JFrame frame;
        private JTextField textField,textField1;
        private JButton Adunare;
        private JButton Inmultire;
        private JButton Scadere;
        private  JLabel Title,pol2;
        private JButton Egal;
        private JButton Derivare;
        private JButton Integrare;
        private JButton Impartire;
        private JLabel Rezultat;
    private JLabel Introduceti;
    public  View() {
            this.setBounds(100, 100, 1079, 547);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.getContentPane().setLayout(null);

            Title = new JLabel("Calculator polinomial");
            Title.setFont(new Font("Tahoma", Font.PLAIN, 25));
            Title.setBounds(398, 23, 233, 46);
            this.getContentPane().add(Title);

            textField = new JTextField();
            textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
            textField.setBounds(36, 199, 255, 63);
            this.getContentPane().add(textField);
            textField.setColumns(10);

             Adunare = new JButton("Adunare");
            Adunare.setFont(new Font("Tahoma", Font.PLAIN, 16));
            Adunare.setBounds(516, 148, 115, 35);
            this.getContentPane().add(Adunare);

             Inmultire = new JButton("Inmultire");
            Inmultire.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Inmultire.setBounds(516, 227, 115, 35);
            this.getContentPane().add(Inmultire);

             Scadere = new JButton("Scadere");
            Scadere.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Scadere.setBounds(745, 148, 121, 35);
            this.getContentPane().add(Scadere);

             Impartire = new JButton("Impartire");
            Impartire.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Impartire.setBounds(751, 227, 115, 35);
            this.getContentPane().add(Impartire);

             Derivare = new JButton("Derivare");
            Derivare.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Derivare.setBounds(516, 313, 115, 36);
            this.getContentPane().add(Derivare);

             Integrare = new JButton("Integrare");
            Integrare.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Integrare.setBounds(750, 317, 110, 35);
            this.getContentPane().add(Integrare);

             Introduceti = new JLabel("Introduceti un polinom");
            Introduceti.setFont(new Font("Tahoma", Font.PLAIN, 14));
            Introduceti.setBounds(104, 126, 156, 36);
            this.getContentPane().add(Introduceti);

             Egal = new JButton("Egal");
            Egal.setFont(new Font("Tahoma", Font.PLAIN, 18));
            Egal.setBounds(624, 417, 134, 46);
            this.getContentPane().add(Egal);

            textField1 = new JTextField();
            textField1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            textField1.setBounds(46, 417, 245, 62);
            this.getContentPane().add(textField1);
            textField1.setColumns(10);

         pol2 = new JLabel("Introduceti al doilea polinom\r\n");
        pol2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        pol2.setBounds(46, 303, 215, 57);
        this.getContentPane().add(pol2);
        this.setVisible(true);
        }
    public void addAdunareListener(ActionListener action) {
        Adunare.addActionListener(action);
    }
    public void addInmultireListener(ActionListener action) {
        Inmultire.addActionListener(action);
    }
    public void addScadereListener(ActionListener action) {
        Scadere.addActionListener(action);
    }
    public void addImpartireListener(ActionListener action) {
        Impartire.addActionListener(action);
    }
    public void addDerivareListener(ActionListener action) {
        Derivare.addActionListener(action);
    }
    public void addIntegrareListener(ActionListener action) {
        Integrare.addActionListener(action);
    }
    public void addEgalListener(ActionListener action) {
        Egal.addActionListener(action);
    }
    public String getText11(){
            return textField.getText();
    }
    public void setText11(){
        textField.setText("");
    }
    public String getText22(){
        return textField1.getText();
    }
    public void setText22(){
        textField1.setText("");
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);

    }

}
