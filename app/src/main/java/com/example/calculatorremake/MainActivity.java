package com.example.calculatorremake;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import nguyenvanquan7826.com.Balan;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int[] idBtn ={
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6,
            R.id.btn7, R.id.btn8, R.id.btn9,
            R.id.btnCong, R.id.btnTru, R.id.btnNhan, R.id.btnChia,
            R.id.btnCham, R.id.btnNgoac1, R.id.btnNgoac2, R.id.btnC, R.id.btnBang

    };
    TextView txt1, txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_calculator_remake);
        connectView();



    }
    //tao ra ham init de tro lai moi khi thuc hien phep tinh moi
    void init(){
        txt1.setText("|");
        txt2.setText("0");
    }

    void connectView(){
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        for (int i = 0; i<idBtn.length; i++){
            findViewById(idBtn[i]).setOnClickListener(this);
        }
        init();
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        //check btn neu la btn dang so, neu la btn dang tinh toan thi chi hien text con la txt dang C hay = thi phai xu ly
        for (int i=0; i<idBtn.length -2; i++){ //-2 o day la tru di C va =
            if (id == idBtn[i]) {
                String text = ((Button) findViewById(id)).getText().toString();

                // clear char | on top
                if (txt1.getText().toString().trim().equals("|")) {
                    txt1.setText("");
                }

                txt1.append(text);
                return;
            }
        }

        // tinh toan
        if (id == R.id.btnC) {
            init();
            return;
        }

        // tinh toan
        if (id == R.id.btnBang) {
            tinhToan();
        }


    }
    void tinhToan(){
        String math = txt1.getText().toString().trim();
        if (math.length() > 0) {
            Balan balan = new Balan();
            String result = balan.valueMath(math) + "";
            String error = balan.getError();

            // check error
            if (error != null) {
                txt2.setText(error);
            } else { // show result
                txt2.setText(result);
            }
        }
    }

}