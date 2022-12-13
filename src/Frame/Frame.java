package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Frame implements ActionListener {
    private JFrame frame;
    private JTextField textField;
    private JButton[] numbers = new JButton[10];
    private JButton[] functions = new JButton[14];
    private JButton add, sub, mul, div, sign;
    private JButton square, inverse, squareRoot, percent;
    private JButton dec, equ, del, clr, undo;
    private JPanel panel;

    private Font myFont = new Font("Sans Serif", Font.PLAIN, 30);
    private Font myFont2 = new Font("Courier", Font.PLAIN, 27);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public Frame(){
        prepareGUI();
        prepareTextField();
        assignButtons();
        functionButtons();
        makePanel();

        frame.add(panel);
        frame.add(textField);
        frame.setVisible(true);
    }

    private void functionButtons() {
        functions[0] = add;
        functions[1] = sub;
        functions[2] = mul;
        functions[3] = div;
        functions[4] = dec;
        functions[5] = equ;
        functions[6] = sign;
        functions[7] = del;
        functions[8] = clr;
        functions[9] = square;
        functions[10] = squareRoot;
        functions[11] = inverse;
        functions[12] = percent;
        functions[13] = undo;

        for (int i = 0; i < 14; i++){
            functions[i].addActionListener(this);
            functions[i].setFont(myFont2);
            functions[i].setBorder(null);
            functions[i].setBackground(new Color(200,200,200));
        }
        for (int i = 0; i < 10; i++){
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(myFont);
            numbers[i].setBorder(null);
            numbers[i].setBackground(Color.white);
        }
    }
    private void assignButtons() {
        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("\u00D7");
        div = new JButton("/");

        dec = new JButton(".");
        equ = new JButton("=");
        sign = new JButton("+/-");
        del = new JButton("CE");

        clr = new JButton("C");
        square = new JButton("\u00D7\u00B2");
        inverse = new JButton("\u00B9/\u00D7");
        squareRoot = new JButton("\u221A\u00D7");

        percent = new JButton("\u0025");
        undo = new JButton("<<");

    }
    private void prepareTextField() {
        textField = new JTextField();
        textField.setBounds(50, 90, 480, 80);
        textField.setFont(myFont);
        textField.setEditable(false);
    }
    private void prepareGUI(){
        frame = new JFrame("Calculator");
        frame.setSize(600,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
    }
    private void makePanel(){
        panel = new JPanel();
        panel.setBounds(50, 200, 480,480);
        panel.setLayout(new GridLayout(6,4,5,5));
        panel.setBackground(new Color(211,211,211));

        panel.add(percent);
        panel.add(del);
        panel.add(clr);
        panel.add(undo);
        panel.add(inverse);
        panel.add(square);
        panel.add(squareRoot);
        panel.add(div);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(mul);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(sub);
        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(add);
        panel.add(sign);
        panel.add(numbers[0]);
        panel.add(dec);
        panel.add(equ);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++)
            if (e.getSource() == numbers[i])
                textField.setText(textField.getText().
                        concat(String.valueOf(i)));

        if (e.getSource() == dec)
            textField.setText(textField.getText().concat("."));

        if (e.getSource() == add){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == sub){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mul){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == div){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == square){
            num1 = Double.parseDouble(textField.getText());
            num1 *= num1;
            textField.setText(String.valueOf(num1));
        }
        if (e.getSource() == squareRoot){
            num1 = Double.parseDouble(textField.getText());
            num1 = Math.sqrt(num1);
            textField.setText(String.valueOf(num1));
        }
        if (e.getSource() == percent){
            num1 = Double.parseDouble(textField.getText());
            num1 /= 100;
            textField.setText(String.valueOf(num1));
        }
        if (e.getSource() == inverse){
            num1 = Double.parseDouble(textField.getText());
            num1 = 1 / num1;
            textField.setText(String.valueOf(num1));
        }
        if (e.getSource() == equ){
            num2 = Double.parseDouble(textField.getText());

            switch(operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clr)
            textField.setText("");
        if (e.getSource() == undo){
            String str = textField.getText();
            textField.setText("");
            for (int i =0; i < str.length() - 1; i++)
                textField.setText(textField.getText() + str.charAt(i));
        }
        if (e.getSource() == sign){
            Double value = Double.parseDouble(textField.getText());
            value *= -1;
            textField.setText(String.valueOf(value));
        }
        if (e.getSource() == del){
            textField.setText("");
        }

    }
}
