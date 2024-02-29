package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView exprField;
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnAC,btnPlusMinus,btnPercent,
            btnDiv,btnMul,btnMinus,btnPlus,btnEqual,btnDot,btnXpowN,btnLg,btnLn,btnFactorial;

    private double firstNumber;
    private double secondNumber;

    private String expression;

    private Operation currentOperation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.resultField);
        exprField = findViewById(R.id.exprField);


        btn0 = findViewById(R.id.button0);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);

        btnDot = findViewById(R.id.buttonDot);
        btnPlusMinus = findViewById(R.id.buttonPlusMinus);
        btnAC = findViewById(R.id.buttonAC);
        btnPlus = findViewById(R.id.buttonPlus);
        btnEqual = findViewById(R.id.buttonEqual);
        btnMinus = findViewById(R.id.buttonMinus);
        btnDiv = findViewById(R.id.buttonDivide);
        btnMul = findViewById(R.id.buttonMultiply);
        btnPercent = findViewById(R.id.buttonPercent);
        btnXpowN = findViewById(R.id.buttonXpowY);
        btnLg = findViewById(R.id.buttonLg);
        btnLn = findViewById(R.id.buttonLn);
        btnFactorial = findViewById(R.id.buttonFactorial);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = editText.getText().toString();
                if (startsWithZeroOrEmpty(expression) && expression.length() == 1){
                    expression = expression.substring(1);
                }
                expression = expression+"1";
                editText.setText(expression);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = editText.getText().toString();
                if (startsWithZeroOrEmpty(expression) && expression.length() == 1){
                    expression = expression.substring(1);
                }
                expression = expression+"2";
                editText.setText(expression);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = editText.getText().toString();
                if (startsWithZeroOrEmpty(expression) && expression.length() == 1){
                    expression = expression.substring(1);
                }
                expression = expression+"3";
                editText.setText(expression);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = editText.getText().toString();
                if (startsWithZeroOrEmpty(expression) && expression.length() == 1){
                    expression = expression.substring(1);
                }
                expression = expression+"4";
                editText.setText(expression);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = editText.getText().toString();
                if (startsWithZeroOrEmpty(expression) && expression.length() == 1){
                    expression = expression.substring(1);
                }
                expression = expression+"5";
                editText.setText(expression);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = editText.getText().toString();
                if (startsWithZeroOrEmpty(expression) && expression.length() == 1){
                    expression = expression.substring(1);
                }
                expression = expression+"6";
                editText.setText(expression);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = editText.getText().toString();
                if (startsWithZeroOrEmpty(expression) && expression.length() == 1){
                    expression = expression.substring(1);
                }
                expression = expression+"7";
                editText.setText(expression);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = editText.getText().toString();
                if (startsWithZeroOrEmpty(expression) && expression.length() == 1){
                    expression = expression.substring(1);
                }
                expression = expression+"8";
                editText.setText(expression);
            }
        });


        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = editText.getText().toString();
                if (startsWithZeroOrEmpty(expression) && expression.length() == 1){
                    expression = expression.substring(1);
                }
                expression = expression+"9";
                editText.setText(expression);
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = editText.getText().toString();
                if (startsWithZeroOrEmpty(expression) && expression.length() == 1){
                    expression = expression.substring(1);
                }
                expression = expression+"0";
                editText.setText(expression);
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = editText.getText().toString();
                if(!expression.contains(".")){
                    expression = expression+".";
                }
                else if(startsWithZeroOrEmpty(expression)){
                    expression = "0.";
                }
                editText.setText(expression);
            }
        });

        btnPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = editText.getText().toString();
                if(expression.equals("0")) {
                    return;
                }
                if(expression.startsWith("-")){
                    expression = expression.substring(1);
                }
                else{
                    expression= "-" + expression;
                }
                editText.setText(expression);
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("0");
                exprField.setText("");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Double.parseDouble(editText.getText().toString());
                expression = editText.getText().toString();
                expression = expression+"+";
                exprField.setText(expression);
                currentOperation = Operation.PLUS;
                editText.setText("0");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Double.parseDouble(editText.getText().toString());
                expression = editText.getText().toString();
                expression = expression+"-";
                exprField.setText(expression);
                currentOperation = Operation.MINUS;
                editText.setText("0");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Double.parseDouble(editText.getText().toString());
                expression = editText.getText().toString();
                expression = expression+"/";
                exprField.setText(expression);
                currentOperation = Operation.DIVIDE;
                editText.setText("0");
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Double.parseDouble(editText.getText().toString());
                expression = editText.getText().toString();
                expression = expression+"×";
                exprField.setText(expression);
                currentOperation = Operation.MULTIPLY;
                editText.setText("0");
            }
        });

        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Double.parseDouble(editText.getText().toString());
                double result = firstNumber/100;

                editText.setText(String.valueOf(result));
            }
        });

        btnFactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Double.parseDouble(editText.getText().toString());
                double result = factorial(firstNumber) ;
                expression = String.valueOf(firstNumber) + "!";
                exprField.setText(expression);
                editText.setText(String.valueOf(result));
            }
        });

        btnXpowN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Double.parseDouble(editText.getText().toString());
                expression = editText.getText().toString();
                expression = expression+"^";
                exprField.setText(expression);
                currentOperation = Operation.POW;
                editText.setText("0");
            }
        });

        btnLn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Double.parseDouble(editText.getText().toString());
                expression = "ln("+String.valueOf(firstNumber)+")";
                exprField.setText(expression);
                double result = Math.log(firstNumber);
                String formattedResult = String.format("%.6f", result);
                editText.setText(formattedResult);
            }
        });

        btnLg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Double.parseDouble(editText.getText().toString());
                expression = "lg("+String.valueOf(firstNumber)+")";
                exprField.setText(expression);
                double result = Math.log(firstNumber);
                editText.setText(String.valueOf(result));
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result;
                if(!(editText.getText().toString().isEmpty())){
                    secondNumber = Double.parseDouble(editText.getText().toString());
                    switch (currentOperation){
                        case PLUS:
                            result = firstNumber + secondNumber;
                            exprField.setText("");
                            editText.setText(result+"");
                            break;
                        case MINUS:
                            result = firstNumber - secondNumber;
                            exprField.setText("");
                            editText.setText(result + "");
                            break;
                        case DIVIDE:
                            if(secondNumber == 0){
                                exprField.setText("");
                                editText.setText("= Error.");
                                break;
                            }
                            result = firstNumber / secondNumber;
                            exprField.setText("");
                            editText.setText(result + "");
                            break;
                        case MULTIPLY:
                            result = firstNumber * secondNumber;
                            exprField.setText("");
                            editText.setText(result + "");
                            break;
                        case POW:
                            result = Math.pow(firstNumber,secondNumber);
                            exprField.setText("");
                            editText.setText(result + "");
                            break;
                        default:
                            editText.setText("0");
                            break;
                    }
                }

            }
        });

    }



    enum Operation
    {
        PLUS,
        MINUS,
        DIVIDE,
        MULTIPLY,
        POW
    }


    private boolean startsWithZeroOrEmpty(String number) {
        if (number.equals("")){
            return true;
        }
        return number.charAt(0) == '0';
    }


    private double factorial(double num){
        if(num == 0 || num == 1){
            return 1;
        }
        return num * factorial(num - 1);
    }

}