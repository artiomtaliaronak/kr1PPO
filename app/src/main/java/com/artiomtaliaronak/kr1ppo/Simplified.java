package com.artiomtaliaronak.kr1ppo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class Simplified extends Fragment {

    View root;
    private TextView previousExpression;
    private EditText display;
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonDot, buttonLb, buttonRb;
    private Button  buttonPlus, buttonMinus, buttonMultiply, buttonDivide;
    private Button buttonC, buttonBackspace, buttonEquals;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_simplified, container, false);

        previousExpression = root.findViewById(R.id.previousExpressionView);
        display = root.findViewById(R.id.displayEditText);
        display.setShowSoftInputOnFocus(false);

        button0 = root.findViewById(R.id.button0);
        button1 = root.findViewById(R.id.button1);
        button2 = root.findViewById(R.id.button2);
        button3 = root.findViewById(R.id.button3);
        button4 = root.findViewById(R.id.button4);
        button5 = root.findViewById(R.id.button5);
        button6 = root.findViewById(R.id.button6);
        button7 = root.findViewById(R.id.button7);
        button8 = root.findViewById(R.id.button8);
        button9 = root.findViewById(R.id.button9);
        buttonDot = root.findViewById(R.id.buttonDot);
        buttonLb = root.findViewById(R.id.buttonLb);
        buttonRb = root.findViewById(R.id.buttonRb);
        buttonPlus = root.findViewById(R.id.buttonPlus);
        buttonMinus = root.findViewById(R.id.buttonMinus);
        buttonMultiply = root.findViewById(R.id.buttonMultiply);
        buttonDivide = root.findViewById(R.id.buttonDivide);
        buttonC = root.findViewById(R.id.buttonC);
        buttonBackspace = root.findViewById(R.id.buttonBackspace);
        buttonEquals = root.findViewById(R.id.buttonEquals);

        button0.setOnClickListener(v -> updateText("0"));
        button1.setOnClickListener(v -> updateText("1"));
        button2.setOnClickListener(v -> updateText("2"));
        button3.setOnClickListener(v -> updateText("3"));
        button4.setOnClickListener(v -> updateText("4"));
        button5.setOnClickListener(v -> updateText("5"));
        button6.setOnClickListener(v -> updateText("6"));
        button7.setOnClickListener(v -> updateText("7"));
        button8.setOnClickListener(v -> updateText("8"));
        button9.setOnClickListener(v -> updateText("9"));
        buttonDot.setOnClickListener(v -> updateText("."));
        buttonLb.setOnClickListener(v -> updateText("("));
        buttonRb.setOnClickListener(v -> updateText(")"));
        buttonPlus.setOnClickListener(v -> updateText("+"));
        buttonMinus.setOnClickListener(v -> updateText("-"));
        buttonMultiply.setOnClickListener(v -> updateText("*"));
        buttonDivide.setOnClickListener(v -> updateText("/"));
        buttonC.setOnClickListener(v -> display.setText(""));

        buttonBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cursorPos = display.getSelectionStart();
                int len = display.getText().length();
                if ( cursorPos > 0 && len > 0 ){
                    SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
                    selection.replace(cursorPos - 1, cursorPos, "");
                    display.setText(selection);
                    display.setSelection(cursorPos-1);
                }
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input;
                input = display.getText().toString();
                previousExpression.setText(input);

                Expression expression = new Expression(input);
                String result = String.valueOf(expression.calculate());

                display.setText(result);
                display.setSelection(result.length());
            }
        });

        return root;
    }

    public void updateText(String newSymbol){
        String expression;
        String leftPart, rightPart;
        int cursorPos;

        expression = display.getText().toString();
        cursorPos = display.getSelectionStart();
        leftPart = expression.substring(0, cursorPos);
        rightPart = expression.substring(cursorPos);

        display.setText(String.format("%s%s%s", leftPart, newSymbol, rightPart));
        display.setSelection(cursorPos + newSymbol.length());
    }

}