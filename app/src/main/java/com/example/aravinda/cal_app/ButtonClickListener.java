package com.example.aravinda.cal_app;

import android.view.View;
import android.widget.Button;

/**
 * Created by Aravinda on 01-Jul-15.
 */
public class ButtonClickListener implements View.OnClickListener {
    private float numberBF;
    private String operation;

    @Override
    public void onClick(View v) {
        MainActivity main = new MainActivity();

        switch (v.getId()){
            case R.id.clral: //function clea all
                main.display.setText("0");
                numberBF = 0;
                operation = "";
                break;
            case R.id.plus: //function add
                calMath("+");
                break;
            case R.id.min: //function add
                calMath("-");
                break;
            case R.id.mul: //function add
                calMath("x");
                break;
            case R.id.devi: //function add
                calMath("/");
                break;
            case R.id.eql:
                result();
                break;
            default:
                String numb = ((Button)  v).getText().toString();
                getKeyboard(numb);
                break;
        }

    }

    private void getKeyboard(String numb) {
        MainActivity main = new MainActivity();
        String disCurrent = main.display.getText().toString();
        disCurrent += numb;
        main.display.setText(disCurrent);
    }

    private void result() {
        MainActivity main = new MainActivity();
        float numberAF = Float.parseFloat(main.display.getText().toString());
        float result = 0;

        if (operation.equals("+")){
            result = numberBF + numberAF;
        }
        if (operation.equals("-")){
            result = numberBF - numberAF;
        }
        if (operation.equals("x")){
            result = numberBF * numberAF;
        }
        if (operation.equals("/")){
            result = numberBF / numberAF;
        }
        if (operation.equals("%")){
            result = numberBF % numberAF;
        }
        if (operation.equals("!")){
            result = numberBF+ numberAF;
        }
        if (operation.equals(".")){
            result = numberBF+ numberAF;
        }
        main.display.setText(String.valueOf(result));
    }

    private void calMath(String s) {
        MainActivity main = new MainActivity();
        numberBF = Float.parseFloat(main.display.getText().toString());
        operation = s;
        main.display.setText("0");

    }


}