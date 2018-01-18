package com.example.v_chzha4.overtimeview;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private int        year;
    private int        month;
    private int        day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        datePicker = (DatePicker)findViewById(R.id.datepicker);

        initData();
        //countovertime();
    }

    public void initData(){
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

       datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                day = dayOfMonth;
                addovertime(datePicker);
                //Toast.makeText(MainActivity.this, year + "年" + (monthOfYear+1) + "月" + dayOfMonth + "日", Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void enterWage(View v){
        Toast.makeText(this, "输入本月基本工资", Toast.LENGTH_SHORT).show();
        wageDialog(this);
    }
    public void overtime(View v){

        Toast.makeText(this, "加班小时数", Toast.LENGTH_SHORT).show();
    }

    public static void wageDialog(Context context){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context) ;
        dialogBuilder.create() ;
        LayoutInflater inflater = LayoutInflater.from(context) ;
        View view = inflater.inflate(R.layout.wagelayout, null) ;
        dialogBuilder.setView(view) ;
        dialogBuilder.show() ;
    }
    public void addovertime(View view){
        LayoutInflater inflater = getLayoutInflater();
        View view1= inflater.inflate(R.layout.dialog_layout,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this) ;
        //builder.setTitle("添加工时");
        builder.setView(view1);
        builder.create().show();
    }
    public void  countovertime() {
        final RadioButton g1 = (RadioButton) findViewById(R.id.G1);
        final RadioButton g2 = (RadioButton) findViewById(R.id.G2);
        final RadioButton g3 = (RadioButton) findViewById(R.id.G3);
        Button confime = (Button) findViewById(R.id.confime);
        confime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float g1Count = 0;
                float g2Count = 0;
                float g3Count = 0;
                EditText editText = (EditText) findViewById(R.id.edit1);
                final float count = Float.valueOf(editText.getText().toString());
                if (g1.isChecked()) {
                    g1Count += count;
                    String str1 = String.valueOf(g1Count);
                    Toast.makeText(MainActivity.this, str1, Toast.LENGTH_SHORT).show();
                    System.out.println(g1Count);
                } else if (g2.isChecked()) {
                    g2Count += count;
                    System.out.println(g2Count);
                } else if (g3.isChecked()) {
                    g3Count += count;
                    System.out.println(g3Count);
                }
            }
        });
    }

}
