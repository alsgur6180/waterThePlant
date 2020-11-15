package kr.ac.konkuk.watertheplanttest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Delete extends AppCompatActivity {

    EditText edit_delete;
    Button delete;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);
        edit_delete = (EditText)findViewById(R.id.edit_delete);
        delete = (Button)findViewById(R.id.delete);

        delete.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();//인텐트 객체 만듬
                intent.putExtra("INPUT_TEXT", edit_delete.getText().toString());//INPUT_TEXT라는 이름에 list 담음
                setResult(RESULT_OK, intent);//result code 를 RESULT_OK로 설정하고 intent 설정
                finish();
            }
        });
    }
}
