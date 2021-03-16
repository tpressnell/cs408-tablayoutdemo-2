package edu.jsu.mcis.cs408.tablayoutdemo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.math.BigDecimal;

public class Calculator {

    private Fragment parent;
    private BigDecimal lValue;
    private BigDecimal rValue;
    private BigDecimal answer;
    private StringBuilder inputBuffer;
    private StringBuilder displayBuffer;
    private boolean secondOperand;
    private boolean decimalUsed;
    private boolean equalsHit;
    private String operator;

    public Calculator(Fragment parent) {
        try {
            this.parent = parent;
            inputBuffer = new StringBuilder();
            displayBuffer = new StringBuilder();
            answer = new BigDecimal(0);
        }
        catch(Exception e){
            displayBuffer = new StringBuilder("Press C to reset: Constructor");
        }
    }


    public void process(String button) {

        try {
            if (button.equals(parent.getResources().getString(R.string.btnClear))) {
                inputBuffer = new StringBuilder();
                decimalUsed = false;
                this.clearDisplay();
            } else if (button.equals(parent.getResources().getString(R.string.btnSign))) {
                lValue = new BigDecimal(inputBuffer.toString());
                lValue = lValue.negate();
                displayBuffer = new StringBuilder(lValue.toString());
                inputBuffer = new StringBuilder();

            } else if (button.equals(parent.getResources().getString(R.string.btnDecimal))) {
                if (decimalUsed == false) {
                    inputBuffer.append(button);
                    displayBuffer.append(button);
                    decimalUsed = true;
                }

            } else if (button.equals(parent.getResources().getString(R.string.btnSquareRoot))) {
                lValue = new BigDecimal(inputBuffer.toString());
                double dValue = Double.parseDouble(lValue.toString());
                double sqRoot = Math.pow(dValue, .5);
                lValue = new BigDecimal(sqRoot);
                displayBuffer = new StringBuilder(lValue.toString());
                inputBuffer = new StringBuilder();
            } else if (button.equals(parent.getResources().getString(R.string.btnDivide))) {
                if (secondOperand == true) {
                    rValue = new BigDecimal(inputBuffer.toString());
                    answer = this.solve();
                    inputBuffer = new StringBuilder();
                    lValue = answer;
                    rValue = new BigDecimal(0);
                    this.clearDisplay();
                    operator = button;
                    decimalUsed = false;
                } else {
                    operator = button;
                    this.clearDisplay();
                    lValue = new BigDecimal(inputBuffer.toString());
                    secondOperand = true;
                    inputBuffer = new StringBuilder();
                }
            } else if (button.equals(parent.getResources().getString(R.string.btnPercent))) {
                if (secondOperand == true) {
                    rValue = new BigDecimal(inputBuffer.toString());
                    answer = this.solve();
                    inputBuffer = new StringBuilder();
                    lValue = answer;
                    rValue = new BigDecimal(0);
                    this.clearDisplay();
                    operator = button;
                    decimalUsed = false;
                } else {
                    operator = button;
                    this.clearDisplay();
                    lValue = new BigDecimal(inputBuffer.toString());
                    secondOperand = true;
                    inputBuffer = new StringBuilder();
                }
            } else if (button.equals(parent.getResources().getString(R.string.btnMultiply))) {
                if (secondOperand == true) {
                    rValue = new BigDecimal(inputBuffer.toString());
                    answer = this.solve();
                    inputBuffer = new StringBuilder();
                    lValue = answer;
                    rValue = new BigDecimal(0);
                    this.clearDisplay();
                    operator = button;
                    decimalUsed = false;
                } else {
                    operator = button;
                    this.clearDisplay();
                    lValue = new BigDecimal(inputBuffer.toString());
                    secondOperand = true;
                    inputBuffer = new StringBuilder();
                }
            } else if (button.equals(parent.getResources().getString(R.string.btnMinus))) {
                if (secondOperand == true) {
                    rValue = new BigDecimal(inputBuffer.toString());
                    answer = this.solve();
                    inputBuffer = new StringBuilder();
                    lValue = answer;
                    rValue = new BigDecimal(0);
                    this.clearDisplay();
                    operator = button;
                    decimalUsed = false;

                } else {
                    operator = button;
                    this.clearDisplay();
                    lValue = new BigDecimal(inputBuffer.toString());
                    secondOperand = true;
                    inputBuffer = new StringBuilder();
                }
            } else if (button.equals(parent.getResources().getString(R.string.btnPlus))) {

                if (secondOperand == true) {
                    rValue = new BigDecimal(inputBuffer.toString());
                    answer = this.solve();
                    inputBuffer = new StringBuilder();
                    lValue = answer;
                    rValue = new BigDecimal(0);
                    this.clearDisplay();
                    operator = button;
                    decimalUsed = false;
                } else {
                    operator = button;
                    this.clearDisplay();
                    lValue = new BigDecimal(inputBuffer.toString());
                    secondOperand = true;
                    inputBuffer = new StringBuilder();

                }

            } else if (button.equals(parent.getResources().getString(R.string.btnEquals))) {
                rValue = new BigDecimal(inputBuffer.toString());
                answer = this.solve();
                displayBuffer = new StringBuilder(answer.toString());
                inputBuffer = new StringBuilder();
                lValue = new BigDecimal(0);
                rValue = new BigDecimal(0);
                secondOperand = false;
                decimalUsed = false;
                equalsHit = true;

            } else if (button.equals(parent.getResources().getString(R.string.btn0))) {
                if(equalsHit == true){
                    displayBuffer = new StringBuilder();
                    equalsHit = false;
                }
                inputBuffer.append(button);
                displayBuffer.append(button);
            } else if (button.equals(parent.getResources().getString(R.string.btn1))) {
                if(equalsHit == true){
                    displayBuffer = new StringBuilder();
                    equalsHit = false;
                }
                inputBuffer.append(button);
                displayBuffer.append(button);
            } else if (button.equals(parent.getResources().getString(R.string.btn2))) {
                if(equalsHit == true){
                    displayBuffer = new StringBuilder();
                    equalsHit = false;
                }
                inputBuffer.append(button);
                displayBuffer.append(button);
            } else if (button.equals(parent.getResources().getString(R.string.btn3))) {
                if(equalsHit == true){
                    displayBuffer = new StringBuilder();
                    equalsHit = false;
                }
                inputBuffer.append(button);
                displayBuffer.append(button);
            } else if (button.equals(parent.getResources().getString(R.string.btn4))) {
                if(equalsHit == true){
                    displayBuffer = new StringBuilder();
                    equalsHit = false;
                }
                inputBuffer.append(button);
                displayBuffer.append(button);
            } else if (button.equals(parent.getResources().getString(R.string.btn5))) {
                if(equalsHit == true){
                    displayBuffer = new StringBuilder();
                    equalsHit = false;
                }
                inputBuffer.append(button);
                displayBuffer.append(button);
            } else if (button.equals(parent.getResources().getString(R.string.btn6))) {
                if(equalsHit == true){
                    displayBuffer = new StringBuilder();
                    equalsHit = false;
                }
                inputBuffer.append(button);
                displayBuffer.append(button);
            } else if (button.equals(parent.getResources().getString(R.string.btn7))) {
                if(equalsHit == true){
                    displayBuffer = new StringBuilder();
                    equalsHit = false;
                }
                inputBuffer.append(button);
                displayBuffer.append(button);
            } else if (button.equals(parent.getResources().getString(R.string.btn8))) {
                if(equalsHit == true){
                    displayBuffer = new StringBuilder();
                    equalsHit = false;
                }
                inputBuffer.append(button);
                displayBuffer.append(button);
            } else if (button.equals(parent.getResources().getString(R.string.btn9))) {
                if(equalsHit == true){
                    displayBuffer = new StringBuilder();
                    equalsHit = false;
                }
                inputBuffer.append(button);
                displayBuffer.append(button);
            }
        }
        catch (Exception e){
            displayBuffer = new StringBuilder("Press C to reset");
        }
    }

    public String getDisplay() {
        return displayBuffer.toString();
    }

    public void clearDisplay() {
        displayBuffer = new StringBuilder();
    }

    public BigDecimal solve() {
        if (operator.equals(parent.getResources().getString(R.string.btnDivide))) {
            return lValue.divide(rValue);
        }
        else if (operator.equals(parent.getResources().getString(R.string.btnPercent))) {
            return lValue.remainder(rValue);
        }
        else if (operator.equals(parent.getResources().getString(R.string.btnMultiply))) {
            return lValue.multiply(rValue);
        }
        else if (operator.equals(parent.getResources().getString(R.string.btnMinus))) {
            return lValue.subtract(rValue);
        }
        else if (operator.equals(parent.getResources().getString(R.string.btnPlus))){
            return lValue.add(rValue);
        }

        return null;
    }
}
