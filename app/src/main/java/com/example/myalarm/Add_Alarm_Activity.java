package com.example.myalarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Add_Alarm_Activity extends AppCompatActivity {

    private TextView tv_Huy;
    private TextView tv_Laplai;
    private TextView btn_nhan;
    private TextView btn_Ambao;

    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);

        anhxa();
        tv_Huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_Laplai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Add_Alarm_Activity.this, AddAlarm_Laplai_Activity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        btn_nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Add_Alarm_Activity.this, NhanBaoThuc_Activity.class);
                startActivity(intent);
            }
        });
        btn_Ambao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Add_Alarm_Activity.this, AmBao_BaoThuc_Activity.class);
                startActivity(intent);
            }
        });
    }

    private void anhxa() {
        tv_Huy = findViewById(R.id.tv_Huy);
        tv_Laplai = findViewById(R.id.tv_Laplai);
        btn_nhan = findViewById(R.id.btn_nhan);
        btn_Ambao = findViewById(R.id.btnAmBao);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                String lapLai = data.getStringExtra("lap lai");
                tv_Laplai.setText(lapLai);
            }
        }
    }
}
