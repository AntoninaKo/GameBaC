import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Okno extends JFrame {
    private int popyt = 0;
    private JTable table;
    private JTextField text;
    private JTextArea info;
    private JButton but;
    private JButton butg;
    private String f = "Here is the 4-digit number.\n You should guess the number,\n using tip, where is written\n how many bulls, and cows you have.";
    private String gen = "";
    private Object[][] data;
    private Object[] header = {"N", "Number", "Bulls", "Cows"};
    private String pol;
    private int kol, buk = 0, kor = 0;
    private int b, k;

     public Okno(){
         super("Bulls and Cows");
         setLayout(new FlowLayout());
         info = new JTextArea(f);
         info.setSize(230, 10);
         info.setEditable(false);
         add(info);

         butg = new JButton("To puzzle the number");
         add(butg);
         butg.addActionListener(
                 new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         boolean frog = true;
                         do {
                             Random r = new Random();
                             kol = 1000 + r.nextInt(8999);
                             gen = Integer.toString(kol);
                             for(int i = 0; i < 4; i++){
                                 for(int j = 1; j < 4; j++){
                                     if((i != j) && (gen.charAt(i) == gen.charAt(j))){
                                         frog = false;
                                         break;
                                     }else{
                                         frog = true;
                                     }
                                 }if(!frog){
                                     break;}
                             }
                         }
                         while(!frog);
                         but.setEnabled(true);
                         System.out.println(kol);
                     }
                 }
         );

         text = new JTextField("", 7);
         text.addKeyListener(
                 new KeyAdapter() {
                     @Override
                     public void keyTyped(KeyEvent e) {
                         char h = e.getKeyChar();
                         if ((((h < '0')||(h >'9')) && (h != KeyEvent.VK_BACK_SPACE))){
                             e.consume(); }
                     }
                 }
         );
         add(text);

         but = new JButton("Check");
         but.setEnabled(false);
         add(but);

         knopka knp = new knopka();
         but.addActionListener(knp);

         table = new JTable(10, 4);
         table.setEnabled(false);

         add(table);
     }

     private class knopka implements ActionListener{
         public void actionPerformed(ActionEvent e){
             b = CountBulls();
             k = CountCows();
             popyt++;
            if (b == 4){
                JOptionPane.showMessageDialog(null, "You won!");
                popyt = 0;
                buk = 0;
                kor = 0;
                but.setEnabled(false);
            }
            else if(popyt<=10){
                JOptionPane.showMessageDialog(null, "You have " + buk + " bulls and "+ kor +" cows");
            }
            else {
                JOptionPane.showMessageDialog(null, "You lose...");
            }
         }

         public int CountBulls(){
             buk = 0;
             pol = text.getText();
             for(int i = 0; i < 4; i++){
                 for(int j = 0; j < 4; j++){
                     if ((i == j) && (pol.charAt(i) == gen.charAt(j)))
                     {
                         buk++;
                     }
                 }
             }
             return buk;
         }
         public int CountCows(){
             kor = 0;
             pol = text.getText();
             for(int i = 0; i < 4; i++){
                 for(int j = 0; j < 4; j++){
                     if((i != j) && (pol.charAt(i) == gen.charAt(j))){
                         kor++;
                     }
                 }
             }
             return kor;
         }
     }
}