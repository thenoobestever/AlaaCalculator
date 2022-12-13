package Frame;

import javax.swing.*;
import java.awt.*;

public class Frame {
    JFrame frame;
    JTextField textField;
    JButton[] numbers = new JButton[10];
    JButton[] functions = new JButton[14];
    JButton add, sub, mul, div, sign;
    JButton square, inverse, squareRoot, percent;
    JButton dec, equ, del, clr, undo;
    JPanel panel;

    Font myFont = new Font("Sans Serif", Font.PLAIN, 30);
    Font myFont2 = new Font("Courier", Font.PLAIN, 27);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public Frame(){
        frame = new JFrame("Calculator");
        frame.setSize(600,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 90, 480, 80);
        textField.setFont(myFont);
        textField.setEditable(false);

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
            functions[i].setFont(myFont2);
            functions[i].setBorder(null);
            functions[i].setBackground(new Color(200,200,200));
        }
        for (int i = 0; i < 10; i++){
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].setFont(myFont);
            numbers[i].setBorder(null);
            numbers[i].setBackground(Color.white);
        }

        panel = new JPanel();
        panel.setBounds(50, 200, 480,480);
        panel.setLayout(new GridLayout(6,4,5,5));
        panel.setBackground(new Color(211,211,211));
        makePanel();

        frame.add(panel);
        frame.add(textField);
        frame.setVisible(true);
    }
    private void makePanel(){
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
}
