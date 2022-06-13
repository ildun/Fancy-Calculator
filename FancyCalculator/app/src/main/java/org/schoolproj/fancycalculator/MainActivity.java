package org.schoolproj.fancycalculator;

import static java.lang.StrictMath.abs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView hist_textView;
    private TextView result_textView;

    private StringBuilder resultStrBuilder = new StringBuilder("0");
    private Double containerNumber = null;
    private Double onScreenNumber = null;

    private boolean isDotPlaced = false;
    private boolean isErrorShowed = false;
    private OperationCode currentOperation = null;
    private DecimalFormat decimalFormat = new DecimalFormat("######.######");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hist_textView = findViewById(R.id.hist_textView);
        result_textView = findViewById(R.id.result_textView);
    }


    private enum OperationCode{
        ADD('+'), SUB('-'),
        MUL('*'), DIV('/'),
        PERCENT('%'), EQUAL('=');

        private final char operCode;
        OperationCode(char c) {
            operCode=c;
        }

        @Override
        public String toString() {
            return String.valueOf(operCode);
        }
    }

    public void onAddButtonClick(View view) {
        operationClick(OperationCode.ADD);
    }
    public void onSubButtonClick(View view) {
        operationClick(OperationCode.SUB);
    }
    public void onMulButtonClick(View view) {
        operationClick(OperationCode.MUL);
    }
    public void onDivButtonClick(View view) {
        operationClick(OperationCode.DIV);
    }
    public void onPercentButtonClick(View view) {
        operationClick(OperationCode.PERCENT);
    }
    public void onEqualButtonClick(View view) {
         
        operationClick(OperationCode.EQUAL);
        currentOperation = null;
        isDotPlaced = false;
        hist_textView.append( " " );
        containerNumber = onScreenNumber;
    }


    public void onAcButtonClick(View view) {
        resultStrBuilder.setLength(0);
        result_textView.setText("");
        hist_textView.setText("");
        containerNumber = null;
        onScreenNumber = null;
        isDotPlaced = false;
        currentOperation = null;
    }
    public void onDelButtonClick(View view) {
        if(!resultStrBuilder.toString().isEmpty()) {
            if(resultStrBuilder.charAt(resultStrBuilder.length()-1) == '.') isDotPlaced = false;
            resultStrBuilder.deleteCharAt(resultStrBuilder.length() - 1);
            result_textView.setText(resultStrBuilder.toString());
        }
    }


    public void onDigitButtonClick(View view) {
        String digitClicked = ((Button) view).getText().toString();

        if(resultStrBuilder.toString().equals("0") ||(!result_textView.getText().toString().isEmpty()
                && result_textView.getText().toString().charAt(0) == '=')){
            resultStrBuilder.setLength(0);
            resultStrBuilder.append(digitClicked);
            result_textView.setText(resultStrBuilder.toString());
        } else{
            resultStrBuilder.append(digitClicked);
            result_textView.append(digitClicked);
        }
    }

    public void onDotButtonClick(View view) {
         
        if(!resultStrBuilder.toString().isEmpty() && !isDotPlaced){
            isDotPlaced = true;
            resultStrBuilder.append(".");
            result_textView.append(".");
        }
    }

    private void operationClick(OperationCode operationCode) {
        try{
            checkedOperationClick(operationCode);
        }catch(ArithmeticException ae){
            Toast.makeText(getApplicationContext(),"Cannot / by 0", Toast.LENGTH_SHORT).show();
            onAcButtonClick(null);
        }
    }
    private void checkedOperationClick(OperationCode operationCode) {
         
        //check for unary minus
        if(resultStrBuilder.toString().equals("-")) return;
        if(resultStrBuilder.toString().isEmpty() && operationCode.toString().equals("-")) {
            resultStrBuilder.append("-");
            result_textView.setText("-");
            return;
        }
        //check for empty input
        if(resultStrBuilder.toString().isEmpty()){
            return;
        }

        //saving typed number
        onScreenNumber = Double.parseDouble(resultStrBuilder.toString());

        //handling "percent" case
        if(operationCode==OperationCode.PERCENT){
            if (containerNumber!=null){
                onScreenNumber= containerNumber*onScreenNumber/100;
            }else{
                onScreenNumber=onScreenNumber/100;
            }
            result_textView.setText("" + decimalFormat.format(onScreenNumber));
            resultStrBuilder.setLength(0);
            resultStrBuilder.append(decimalFormat.format(onScreenNumber));
            return;
        }

        //handling prev selected binary operation
        if(currentOperation != null){
            switch (currentOperation){
                case DIV:
                    if (abs(onScreenNumber)<1e-6) throw new ArithmeticException();
                    containerNumber /= onScreenNumber;
                    break;
                case MUL:
                    containerNumber *= onScreenNumber;
                    break;
                case ADD:
                    containerNumber += onScreenNumber;
                    break;
                case SUB:
                    containerNumber -= onScreenNumber;
                    break;
            }
        }else{//... or moving or saved number to a buffer
            containerNumber = onScreenNumber;
        }

        //handling "equal" case
        if(operationCode == OperationCode.EQUAL){
            hist_textView.append(" " + decimalFormat.format(onScreenNumber));
            currentOperation = null;
            isDotPlaced = false;
            result_textView.setText("=" + decimalFormat.format(containerNumber));
            onScreenNumber = containerNumber;
            resultStrBuilder.setLength(0);
            resultStrBuilder.append(decimalFormat.format(onScreenNumber));
            return;
        }

        hist_textView.setText("" + decimalFormat.format(containerNumber) + " " + operationCode);
        currentOperation = operationCode;
        isDotPlaced = false;
        result_textView.setText("");
        resultStrBuilder.setLength(0);
    }

}