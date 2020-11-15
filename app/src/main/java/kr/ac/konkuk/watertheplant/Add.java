package kr.ac.konkuk.watertheplanttest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Add extends AppCompatActivity {
    EditText plantName;
    EditText summer;
    EditText winter;
    Button add;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        ArrayList<String> list = new ArrayList<String>();//인텐트로 값을 넣어 보낼 리스트 선언
        plantName = (EditText) findViewById(R.id.edit_name);
        summer = (EditText) findViewById(R.id.edit_summer);
        winter = (EditText) findViewById(R.id.edit_winter);
        add = (Button)findViewById(R.id.add);

        String name = plantName.getText().toString();
        String summer_cycle = summer.getText().toString();
        String winter_cycle = winter.getText().toString();

        add.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();//인텐트 객체 만듬
                list.add(plantName.getText().toString());//리스트에 에디트 입력값 추가
                list.add(summer.getText().toString());//리스트에 text값 추가
                list.add(winter.getText().toString());//리스트에 text값 추가
                intent.putExtra("INPUT_TEXT", list);//INPUT_TEXT라는 이름에 list 담음
                setResult(RESULT_OK, intent);//result code 를 RESULT_OK로 설정하고 intent 설정
                finish();

            }
        });
    }
}
