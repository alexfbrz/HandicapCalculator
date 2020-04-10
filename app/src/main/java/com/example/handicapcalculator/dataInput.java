package com.example.handicapcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class dataInput extends AppCompatActivity {

    Button calculateBtn;
    TextView valueDisplayTv;
    EditText t1S1, t1S2, t1S3, t1S4, t1S5, t2S1, t2S2, t2S3, t2S4, t2S5, handicapValue;
    int totalT1, totalT2, t1Score1, t1Score2, t1Score3, t1Score4, t1Score5, t2Score1, t2Score2, t2Score3, t2Score4, t2Score5,
            handicap;
    double handicapDouble, difference, aveT1, aveT2;
    String result, teamInfo, valueDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_data);

        t1S1=findViewById(R.id.T1S1);
        t1S2=findViewById(R.id.T1S2);
        t1S3=findViewById(R.id.T1S3);
        t1S4=findViewById(R.id.T1S4);
        t1S5=findViewById(R.id.T1S5);
        t2S1=findViewById(R.id.T2S1);
        t2S2=findViewById(R.id.T2S2);
        t2S3=findViewById(R.id.T2S3);
        t2S4=findViewById(R.id.T2S4);
        t2S5=findViewById(R.id.T2S5);
        handicapValue=findViewById(R.id.handicapValueTv);
        calculateBtn=findViewById(R.id.calculateButton);
        valueDisplayTv=findViewById(R.id.valueDisplayTV);



        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1Score1=Integer.parseInt(t1S1.getText().toString());
                t1Score2=Integer.parseInt(t1S2.getText().toString());
                t1Score3=Integer.parseInt(t1S3.getText().toString());
                t1Score4=Integer.parseInt(t1S4.getText().toString());
                t1Score5=Integer.parseInt(t1S5.getText().toString());

                totalT1= (t1Score1+t1Score2+t1Score3+t1Score4+t1Score5);

                t2Score1=Integer.parseInt(t2S1.getText().toString());
                t2Score2=Integer.parseInt(t2S2.getText().toString());
                t2Score3=Integer.parseInt(t2S3.getText().toString());
                t2Score4=Integer.parseInt(t2S4.getText().toString());
                t2Score5=Integer.parseInt(t2S5.getText().toString());

                totalT2= (t2Score1+t2Score2+t2Score3+t2Score4+t2Score5);

                if(totalT1>totalT2)
                {
                    calculation(totalT1, totalT2);
                    teamInfo = "Team 2 gets: ";
                    valueDisplay= teamInfo + calculation(totalT1, totalT2);
                    valueDisplayTv.setText(valueDisplay);
                }
                else
                {
                    calculation(totalT1, totalT2);
                    teamInfo = "Team 1 gets: ";
                    valueDisplay = teamInfo + calculation(totalT1, totalT2);
                    valueDisplayTv.setText(valueDisplay);
                }

            }
        });
    }

    public double calculation(double t1, double t2)
    {
        double total1=t1;
        double total2=t2;

        handicap=Integer.parseInt(handicapValue.getText().toString());
        handicapDouble=(double)handicap/100;

        if(total1>total2)
        {
            difference= (total1-total2)*handicapDouble;
        }
        else
            difference= (total2-total1)*handicapDouble;

        return difference;
    }

}
