package com.example.v_chzha4.overtimeview;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
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
    }

    public void initData(){
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(MainActivity.this, year + "年" + (monthOfYear+1) + "月" + dayOfMonth + "日", Toast.LENGTH_SHORT).show();
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


}
