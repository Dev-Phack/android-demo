package dev_phack.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CalculatriceActivity extends AppCompatActivity {

    String oldNumber;
    String op = "+";
    TextView calcul;
    boolean isNewOp = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice);

        calcul = findViewById(R.id.calcul);
    }

    public void displayEvent(View view) {
        if (isNewOp) {
            calcul.setText("");
            isNewOp = false;
        }
        String display = calcul.getText().toString();

        switch (view.getId()) {
            case R.id.bu0:
                display += "0";
                break;
            case R.id.bu1:
                display += "1";
                break;
            case R.id.bu2:
                display += "2";
                break;
            case R.id.bu3:
                display += "3";
                break;
            case R.id.bu4:
                display += "4";
                break;
            case R.id.bu5:
                display += "5";
                break;
            case R.id.bu6:
                display += "6";
                break;
            case R.id.bu7:
                display += "7";
                break;
            case R.id.bu8:
                display += "8";
                break;
            case R.id.bu9:
                display += "9";
                break;
            case R.id.buDot:
                boolean haveDot = false;
                for (int i = 0; i < display.length(); i++) {
                    if (display.charAt(i) == '.') {
                        haveDot = true;
                    }
                }
                if (!haveDot) {
                    display += ".";
                }
                break;
            case R.id.buPlus:
                display += "+";
                break;
            case R.id.buMoins:
                display += "-";
                break;
            case R.id.buMultiply:
                display += "*";
                break;
            case R.id.buDivide:
                display += "/";
                break;
            case R.id.buPlusOuMoins:
                boolean haveMoins = false;
                for (int i = 0; i < display.length(); i++) {
                    if (display.charAt(i) == '-') {
                        haveMoins = true;
                    }
                }
                if (!haveMoins) {
                    display = "-" + display;
                }
                break;
            default:
                break;
        }

        calcul.setText(display);
    }

    public void ACEvent(View view) {
        calcul.setText("0");
        isNewOp = true;
    }

    public void operatorEvent(View view) {
        isNewOp = true;
        oldNumber = calcul.getText().toString();
        switch (view.getId()) {
            case R.id.buDivide:
                op = "/";
                break;
            case R.id.buMoins:
                op = "-";
                break;
            case R.id.buMultiply:
                op = "*";
                break;
            case R.id.buPlus:
                op = "+";
                break;

        }
    }

    public void equalEvent(View view) {
        String newNumber = calcul.getText().toString();
        double result = 0.0;
        switch (op) {
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
        }
        calcul.setText(result + "");
    }

    public void percentEvent(View view) {
        double no = Double.parseDouble(calcul.getText().toString()) / 100;
        calcul.setText(no + "");
        isNewOp = true;
    }

}