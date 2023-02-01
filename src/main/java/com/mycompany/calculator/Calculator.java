/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author USER
 */
public class Calculator implements ActionListener{
    
    //declare the GUI components that we intend to use
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,delButton,equalButton,clearButton;
    JPanel panel;
    double num1=0,num2=0,result=0;
    char operator;
    
    //the constructor for the calculator. Create the calc object
    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.setLayout(null);
        
        //textfield for the calculator
        textfield = new JTextField();//textfield
        textfield.setBounds(50,25,350,40);
        textfield.setEditable(false);
        
        
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        delButton = new JButton("delete");
        clearButton = new JButton("clear");
        equalButton = new JButton("=");
        
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = delButton;
        functionButtons[6] = clearButton;
        functionButtons[7] = equalButton;
                
        //we need to add action listener to our function buttons
        for(int i=0;i<8;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFocusable(false);
        }
        
        //instantiate and add action listeners to the numbers button
        for(int i=0;i<10;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
        }
        
        //dictate positions for the clear and delete buttons
        delButton.setBounds(50,400,145,50);
        clearButton.setBounds(205,400, 145, 50);
        
        //instantiating and setting bounds for the panel
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));//set rows and columns
        //panel.setBackground(Color.BLACK);
        
        //first row
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        
        //second row
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        
        //third row
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        
        //final row
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divButton);
        
        //add components to the frame
        frame.add(textfield);
        frame.add(delButton);
        frame.add(clearButton);
        frame.add(panel);
        
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        //run the calc!
        Calculator calc = new Calculator();
    }
    
    //add functionality to the calc buttons
    @Override
    public void actionPerformed(ActionEvent e){
        //number buttons
        for(int i=0;i<10;i++){
            //if number button clicked show text in the textfield
            if(e.getSource() == numberButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        //add decimal point
        if(e.getSource()==decButton){
            textfield.setText(textfield.getText().concat("."));
            
        }
        //functionality to add button
        if(e.getSource()==addButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
            
        }
        if(e.getSource()==subButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
            
        }
        if(e.getSource()==mulButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
            
        }
        if(e.getSource()==divButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
            
        }
        if(e.getSource()==equalButton){
            num2 = Double.parseDouble(textfield.getText());
            
            switch(operator){
                case '+' -> result=num1+num2;
                case '-' -> result=num1-num2;
                case '*' -> result=num1*num2;
                case '/' -> result=num1/num2;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
            
        }
        if(e.getSource()==clearButton){
            textfield.setText("");
        }
        if(e.getSource()==delButton){
            String content = textfield.getText();
            textfield.setText("");
            for(int i=0;i<content.length()-1;i++){
                textfield.setText(textfield.getText()+content.charAt(i));
            }
        }
    
    }
}
