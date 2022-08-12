import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

    public class View extends JFrame {

        private JFrame frame;
        private JTextField t1;
        private JTextField t2;
        private JTextField i1;
        //private File file;
        private JTextField i2;
        private JTextField nField;
        private JScrollPane sc;
        private JTextField qField;
        private JTextField TmaxSiluationField;
        private JTextArea rezultat;
        private JLabel titlu, n, q, lblNewLabel, label;
        private JButton generare;
        public  View() {
            this.setBounds(100, 100, 1079, 564);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.getContentPane().setLayout(null);

            titlu = new JLabel("Tema 2");
            titlu.setFont(new Font("Tahoma", Font.PLAIN, 25));
            titlu.setBounds(415, 30, 102, 46);
            this.getContentPane().add(titlu);

            n = new JLabel("N=");
            n.setFont(new Font("Tahoma", Font.PLAIN, 18));
            n.setBounds(45, 125, 31, 38);
            this.getContentPane().add(n);

            q = new JLabel("Q=");
            q.setFont(new Font("Tahoma", Font.PLAIN, 18));
            q.setBounds(45, 209, 31, 22);
            this.getContentPane().add(q);

            lblNewLabel = new JLabel("TmaxSimulation");
            lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
            lblNewLabel.setBounds(45, 266, 128, 52);
            this.getContentPane().add(lblNewLabel);

            t1 = new JTextField();
            t1.setFont(new Font("Tahoma", Font.PLAIN, 18));
            t1.setBounds(45, 345, 60, 38);
            this.getContentPane().add(t1);
            t1.setColumns(10);

            t2 = new JTextField();
            t2.setFont(new Font("Tahoma", Font.PLAIN, 18));
            t2.setColumns(10);
            t2.setBounds(137, 345, 60, 38);
            this.getContentPane().add(t2);

            i1 = new JTextField();
            i1.setFont(new Font("Tahoma", Font.PLAIN, 18));
            i1.setColumns(10);
            i1.setBounds(45, 411, 60, 38);
            this.getContentPane().add(i1);

            i2 = new JTextField();
            i2.setFont(new Font("Tahoma", Font.PLAIN, 18));
            i2.setColumns(10);
            i2.setBounds(137, 411, 60, 38);
            this.getContentPane().add(i2);

            nField = new JTextField();
            nField.setFont(new Font("Tahoma", Font.PLAIN, 18));
            nField.setColumns(10);
            nField.setBounds(113, 125, 60, 38);
            this.getContentPane().add(nField);

            qField = new JTextField();
            qField.setFont(new Font("Tahoma", Font.PLAIN, 18));
            qField.setColumns(10);
            qField.setBounds(113, 201, 60, 38);
            this.getContentPane().add(qField);

            TmaxSiluationField = new JTextField();
            TmaxSiluationField.setFont(new Font("Tahoma", Font.PLAIN, 18));
            TmaxSiluationField.setColumns(10);
            TmaxSiluationField.setBounds(221, 280, 60, 38);
            this.getContentPane().add(TmaxSiluationField);


            rezultat = new JTextArea();
            rezultat.setFont(new Font("Tahoma", Font.PLAIN, 18));
            rezultat.setBounds(478, 86, 515, 407);

            sc=new JScrollPane(rezultat);
            sc.setBounds(500, 86, 515, 407);
            rezultat.setAutoscrolls(true);
            rezultat.setColumns(10);
            sc.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

            this.add(sc);

            label = new JLabel("New label");
            label.setBounds(704, 239, 45, 13);
            this.getContentPane().add(label);

            generare = new JButton("Generare");
            generare.setFont(new Font("Tahoma", Font.PLAIN, 16));
            generare.setBounds(77, 496, 128, 21);
            this.getContentPane().add(generare);
            this.setVisible(true);

        }
        public void addGenerareListener(ActionListener action) {
            generare.addActionListener(action);
        }

        public void setText11(){
            nField.setText("");
        }
        public void setText12(){
            qField.setText("");
        }
        public void setText13(){
            TmaxSiluationField.setText("");
        }
        public void setText14(){
            t1.setText("");
        }
        public void setText15(){
            t2.setText("");
        }
        public void setText19(String c){
            rezultat.setText(c);
        }
        public void setText16(){
            i1.setText("");
        }
        public void setText17(){
            i2.setText("");
        }
        public String getText11(){
            return nField.getText();
        }
        public String getText12(){
            return qField.getText();
        }
        public String getText13(){
            return TmaxSiluationField.getText();
        }
        public String getText14(){
            return t1.getText();
        }
        public String getText15(){
            return t2.getText();
        }
        public String getText16(){
            return i1.getText();
        }
        public String getText17(){
            return i2.getText();
        }
       // public void setSC(String c){sc.setView;}
    }

