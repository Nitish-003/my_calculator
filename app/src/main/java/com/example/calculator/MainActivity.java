package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtInp, txtOut;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn00, btnClear, btn1Del, btnAdd, btnSub, btnMul, btnDiv, btnEqual, btnPercent, btnDot;

    float a=0,b=0, result=0;

    int operation = 0;
    //float result2 =0, c=0,d=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInp = findViewById(R.id.textInput);
        txtOut = findViewById(R.id.textOutput);
        btn0 = findViewById(R.id.btnZero);
        btn1 = findViewById(R.id.btnOne);
        btn2 = findViewById(R.id.btnTwo);
        btn3 = findViewById(R.id.btnThree);
        btn4 = findViewById(R.id.btnFour);
        btn5 = findViewById(R.id.btnFive);
        btn6 = findViewById(R.id.btnSix);
        btn7 = findViewById(R.id.btnSeven);
        btn8 = findViewById(R.id.btnEight);
        btn9 = findViewById(R.id.btnNine);
        btn00 = findViewById(R.id.btnDoubleZero);
        btnClear = findViewById(R.id.btnClear);
        btn1Del = findViewById(R.id.btnRemove);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnEqual = findViewById(R.id.btnEqual);
        btnPercent = findViewById(R.id.btnPercent);
        btnDot = findViewById(R.id.btnDot);



        btn1.setOnClickListener(view -> {

            String in = txtInp.getText().toString();
            String v = in + "1";
            txtInp.setText(v);


        });

        btn2.setOnClickListener(view -> {
            String in = txtInp.getText().toString();
            String v = in + "2";
            txtInp.setText(v);

        });

        btn3.setOnClickListener(view -> {
            String in = txtInp.getText().toString();
            String v = in + "3";
            txtInp.setText(v);

        });

        btn4.setOnClickListener(view -> {
            String in = txtInp.getText().toString();
            String v = in + "4";
            txtInp.setText(v);

        });

        btn5.setOnClickListener(view -> {
            String in = txtInp.getText().toString();
            String v = in + "5";
            txtInp.setText(v);
        });

        btn6.setOnClickListener(view -> {
            String in = txtInp.getText().toString();
            String v = in + "6";
            txtInp.setText(v);

        });

        btn7.setOnClickListener(view -> {
            String in = txtInp.getText().toString();
            String v = in + "7";
            txtInp.setText(v);

        });

        btn8.setOnClickListener(view -> {
            String in = txtInp.getText().toString();
            String v = in + "8";
            txtInp.setText(v);

        });

        btn9.setOnClickListener(view -> {
            String in = txtInp.getText().toString();
            String v = in + "9";
            txtInp.setText(v);

        });

        btn0.setOnClickListener(view -> {
            if (txtInp.getText().length() != 0){
                String in = txtInp.getText().toString();
                String v = in + "0";
                txtInp.setText(v);
            }

        });

        btn00.setOnClickListener(view -> {
            if (txtInp.getText().length() != 0){
                String in = txtInp.getText().toString();
                String v = in + "00";
                txtInp.setText(v);
            }

        });

        //Operation = 0 No operation
        //Operation = 1 Add
        //Operation = 2 Sub
        //Operation = 3 Div
        //Operation = 4 Mul
        //Operation = 5 Percent

        btnAdd.setOnClickListener(view -> {
            if(a == 0) {
                if (txtInp.getText().length() != 0 & operation == 0) {
                    operation = 1;
                    a = (float) Double.parseDouble(txtInp.getText().toString());
                    txtInp.setText("");
                }
            }
            else {
                operation = 1;
                Calculation();
                txtInp.setText("");
            }
        });

        btnSub.setOnClickListener(view -> {
            if(a == 0) {
                if (txtInp.getText().length() != 0 & operation == 0) {
                    operation = 2;
                    a = (float) Double.parseDouble(txtInp.getText().toString());
                    txtInp.setText("");
                }
            }
            else {
                operation = 2;
                Calculation();
                txtInp.setText("");
            }
        });

        btnMul.setOnClickListener(view -> {
            if(a == 0) {
                if (txtInp.getText().length() != 0 & operation == 0) {
                    operation = 4;
                    a = (float) Double.parseDouble(txtInp.getText().toString());
                    txtInp.setText("");
                }
            }
            else {
                operation = 4;
                Calculation();
                txtInp.setText("");
            }
        });

        btnDiv.setOnClickListener(view -> {
            if(a == 0) {
                if (txtInp.getText().length() != 0 & operation == 0) {
                    operation = 3;
                    a = (float) Double.parseDouble(txtInp.getText().toString());
                    txtInp.setText("");
                }
            }
            else {
                operation = 3;
                Calculation();
                txtInp.setText("");
            }
        });

        btnPercent.setOnClickListener(view -> {
            if(a == 0) {
                if (txtInp.getText().length() != 0 & operation == 0) {
                    operation = 5;
                    a = (float) Double.parseDouble(txtInp.getText().toString());
                    txtInp.setText("");
                }
            }
            else {
                operation = 5;
                Calculation();
                txtInp.setText("");
            }
        });

        btnEqual.setOnClickListener(view -> {
            Calculation();
            Toast.makeText(this, "Equal Pressed", Toast.LENGTH_SHORT).show();
            operation = 0;
            txtInp.setText("");
        });

        btnClear.setOnClickListener(view -> {
            a=0;
            b=0;
            result = 0;
            txtInp.setText("");
            txtOut.setText("");
        });

        btn1Del.setOnClickListener(view -> {
            String text = txtInp.getText().toString();
            if(text.length() !=0) {
                text = text.substring(0, text.length() - 1);
                txtInp.setText(text);
            }
            else if(text.length() == 1) {
                txtInp.setText("");
            }
        });
    }

    //Operation = 0 No operation
    //Operation = 1 Add
    //Operation = 2 Sub
    //Operation = 3 Div
    //Operation = 4 Mul
    //Operation = 5 Percent

    public void Calculation() {
        if(txtInp.getText().length() != 0) {
            b = (float) Double.parseDouble(txtInp.getText().toString());
            if (operation == 1) {
                result = a + b;
            } else if (operation == 2) {
                result = a - b;
            } else if (operation == 3) {
                result = a / b;
            } else if (operation == 4) {
                result = a * b;
            } else if (operation == 5) {
                result = b/a;
            }
            a = result;
            String te = String.valueOf(result);
            if (te.endsWith(".0"))
                te = te.substring(0,te.length() -2);
            txtOut.setText(te);
        }

    }

}