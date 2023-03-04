import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[12];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton, equButton, delButton, clrButton, negButton,sqButton, recButton, sqrtButton;
    JPanel panel;
    JRadioButton onRadioButton = new JRadioButton("on");
    JRadioButton offRadioButton = new JRadioButton("off");

    Font myFont = new Font("Arial",Font.BOLD,25);

    double num1=0,num2=0,result=0;
    char operator; //hold +-x/ characters

    Calculator(){

        //initialise frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null); //use no layout manager
        frame.getContentPane().setBackground(Color.black);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false); //cannot type anything in the text box

        onRadioButton.setBounds(50, 80, 60, 40);
        onRadioButton.setSelected(true);
        onRadioButton.setFont(new Font("Arial", Font.BOLD, 14));
        onRadioButton.setBackground(Color.black);
        onRadioButton.setForeground(Color.white);
        frame.add(onRadioButton);

        offRadioButton.setBounds(50, 110, 60, 40);
        offRadioButton.setSelected(false);
        offRadioButton.setFont(new Font("Arial", Font.BOLD, 14));
        offRadioButton.setBackground(Color.black);
        offRadioButton.setForeground(Color.white);
        frame.add(offRadioButton);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(onRadioButton);
        buttonGroup.add(offRadioButton);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("X");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("C");
        negButton = new JButton("( - )");
        sqButton = new JButton("x\u00B2 ");
        recButton = new JButton("1/x");
        sqrtButton = new JButton("\u221A");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = sqButton;
        functionButtons[10] = recButton;
        functionButtons[11] = sqrtButton;

        for(int i =0;i<12;i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(new Font("Arial", Font.BOLD, 15));
            functionButtons[i].setFocusable(false);
        }

        for(int i =0;i<10;i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        onRadioButton.addActionListener(this);
        offRadioButton.addActionListener(this);

        negButton.setBounds(282,90,65,50);
        negButton.setBackground(Color.orange);
        negButton.setForeground(Color.black);

        delButton.setBounds(205,90,65,50);
        delButton.setBackground(Color.red);
        delButton.setForeground(Color.white);

        clrButton.setBounds(130,90,65,50);
        clrButton.setBackground(Color.red);
        clrButton.setForeground(Color.white);

        sqButton.setBounds(50,150,65,50);
        sqrtButton.setBounds(130,150,65,50);
        recButton.setBounds(205,150,65,50);
        addButton.setBackground(Color.orange);
        addButton.setForeground(Color.black);
        subButton.setBackground(Color.orange);
        subButton.setForeground(Color.black);
        mulButton.setBackground(Color.orange);
        mulButton.setForeground(Color.black);
        divButton.setBackground(Color.orange);
        divButton.setForeground(Color.black);

        panel = new JPanel();
        panel.setBounds(50, 150, 300, 300);
        panel.setLayout(new GridLayout(5,4,10,10));
        panel.setBackground(Color.black);
        panel.add(sqButton);
        panel.add(recButton);
        panel.add(sqrtButton);
        panel.add(divButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(mulButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(addButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(negButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator(); //create object for calculator class
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textfield.getText());

            switch (operator) {
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
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textfield.setText("");
        }
        if (e.getSource() == delButton) {
            String string = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textfield.getText()); //convert string to double
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        }

        if(e.getSource() == sqButton){
            num1 = Double.parseDouble(textfield.getText());
            double square = Math.pow(num1, 2);
            String string = Double.toString(square);
            if (string.endsWith(".0")) {
                textfield.setText(string.replace(".0", ""));
            } else {
                textfield.setText(string);
            }
        }

        if(e.getSource() == sqrtButton){
            num1 = Double.parseDouble(textfield.getText());
            double sqrt = Math.sqrt(num1);
            textfield.setText(String.valueOf(sqrt));
        }

        if (e.getSource() == recButton) {
            num1 = Double.parseDouble(textfield.getText());
            double reciprocal = 1 / num1;
            String string = Double.toString(reciprocal);
            if (string.endsWith(".0")) {
                textfield.setText(string.replace(".0", ""));
            } else {
                textfield.setText(string);
            }
        }

        if (e.getSource() == onRadioButton) {
            enable();//Calling enable() function
        } else if (e.getSource() == offRadioButton) {
            disable();//Calling disable function
        }
    }
        /*
        try {
            if (e.getSource() == negButton) {
                double num = Double.parseDouble(textfield.getText());
                if (num >= 0) {
                    double resultneg = num * -1;
                    textfield.setText(resultneg + "");
                } else {
                    double resultpos = num * -1;
                    textfield.setText(resultpos + "");
                }
            }
        }

        catch (NumberFormatException num) {

            System.out.println(
                    "NumberFormatException occurred");
        } */

    public void enable() {
         onRadioButton.setEnabled(false);
         offRadioButton.setEnabled(true);
         textfield.setEnabled(true);
         for (int i = 0; i < 12; i++) {
            functionButtons[i].setEnabled(true);
         }
         for (int i = 0; i < 10; i++) {
            numberButtons[i].setEnabled(true);
         }
    }

    public void disable() {
         onRadioButton.setEnabled(true);
         offRadioButton.setEnabled(false);
         textfield.setEnabled(false);
         for (int i = 0; i < 12; i++) {
             functionButtons[i].setEnabled(false);
         }
         for (int i = 0; i < 10; i++) {
             numberButtons[i].setEnabled(false);
         }
    }
}
