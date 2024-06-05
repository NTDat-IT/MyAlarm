package com.example.myalarm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class AddAlarm_Laplai_Activity extends AppCompatActivity {

    Toolbar toolbarLaplai;
    CheckBox checkBoxt2, checkBoxtCn, checkBoxt3, checkBoxt4, checkBoxt5, checkBoxt6, checkBoxt7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Thiết lập layout trước
        setContentView(R.layout.activity_add_alarm_laplai);



        // Ánh xạ các view
        anhxa();
        checkBoxt2.setChecked(false);
        checkBoxt3.setChecked(false);
        checkBoxt4.setChecked(false);
        checkBoxt5.setChecked(false);
        checkBoxt6.setChecked(false);
        checkBoxt7.setChecked(false);
        checkBoxtCn.setChecked(false);

        // Thiết lập toolbar
        toolbarLaplai = findViewById(R.id.ToolbarAddAlarm_laplai);
        setSupportActionBar(toolbarLaplai);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false); // Ẩn tiêu đề mặc định
        }

        ImageView ivBack = findViewById(R.id.iv_back);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = checkNgayDuocChon();
                String luachon;

                if (count == 1) {
                    if (checkBoxt2.isChecked()) luachon = "Mỗi thứ hai";
                    else if (checkBoxt3.isChecked()) luachon = "Mỗi thứ ba";
                    else if (checkBoxt4.isChecked()) luachon = "Mỗi thứ bốn";
                    else if (checkBoxt5.isChecked()) luachon = "Mỗi thứ năm";
                    else if (checkBoxt6.isChecked()) luachon = "Mỗi thứ sáu";
                    else if (checkBoxt7.isChecked()) luachon = "Mỗi thứ bảy";
                    else if (checkBoxtCn.isChecked()) luachon = "Mỗi chủ nhật";
                    else luachon = "";
                } else {
                    if (count < 7 && count > 1) {
                        luachon = "Vài ngày";
                    } else {
                        luachon = "Mỗi ngày";
                    }
                }

                // Tạo một Intent để chứa dữ liệu trả về
                Intent resultIntent = new Intent();

                // Thêm dữ liệu vào Intent. Sử dụng khóa thống nhất "lap lai"
                resultIntent.putExtra("lap lai", luachon);

                // Thiết lập kết quả trả về với RESULT_OK và Intent chứa dữ liệu
                setResult(Activity.RESULT_OK, resultIntent);

                // Kết thúc Activity hiện tại và quay lại Activity trước đó
                finish();
            }
        });
    }

    private void anhxa() {
        checkBoxt2 = findViewById(R.id.Cb_t2);
        checkBoxt3 = findViewById(R.id.Cb_t3);
        checkBoxt4 = findViewById(R.id.Cb_t4);
        checkBoxt5 = findViewById(R.id.Cb_t5);
        checkBoxt6 = findViewById(R.id.Cb_t6);
        checkBoxt7 = findViewById(R.id.Cb_t7);
        checkBoxtCn = findViewById(R.id.Cb_cn);
    }

    private int checkNgayDuocChon() {
        int count = 0;
        if (checkBoxt2.isChecked()) count++;
        if (checkBoxt3.isChecked()) count++;
        if (checkBoxt4.isChecked()) count++;
        if (checkBoxt5.isChecked()) count++;
        if (checkBoxt6.isChecked()) count++;
        if (checkBoxt7.isChecked()) count++;
        if (checkBoxtCn.isChecked()) count++;
        return count;
    }
}
