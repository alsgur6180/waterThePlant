package kr.ac.konkuk.watertheplanttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import kr.ac.konkuk.watertheplanttest.Add;
import kr.ac.konkuk.watertheplanttest.MyAdapter;
import kr.ac.konkuk.watertheplanttest.R;
import kr.ac.konkuk.watertheplanttest.SampleData;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<SampleData> plantDataList;
    MyAdapter myAdapter;


    Button add;
    Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.InitializeMovieData();
        listView = (ListView)findViewById(R.id.listView);

        add = (Button)findViewById(R.id.to_add);
        add.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, Add.class);
                startActivityForResult(intent,1);

            }
        });
        delete = (Button)findViewById(R.id.to_delete);
        delete.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, Delete.class);
                startActivityForResult(intent, 2);


            }
        });


        myAdapter = new MyAdapter(this, plantDataList);

        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Toast.makeText(getApplicationContext(),
                        myAdapter.getItem(position).getPlantName(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    public void InitializeMovieData()
    {
        plantDataList = new ArrayList<SampleData>();

        plantDataList.add(new SampleData(R.drawable.plant1, "관음죽 예시","여름 3일","겨울 7일"));
        plantDataList.add(new SampleData(R.drawable.plant2, "몬스테라 예시","여름 2일","겨울 5일"));
        plantDataList.add(new SampleData(R.drawable.plant3, "율마 예시","여름 매일","겨울 8일"));
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //requestCode는 GET_STRING이고 resultCode는 RESULT_OK, RESULT_CANCELED로 설정, data에 문자열 정보가 담겨있음
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {//값확인
            if (resultCode == RESULT_OK) {//값확인
                ArrayList<String> list = (ArrayList<String>) data.getSerializableExtra("INPUT_TEXT");//data로부터 list 받아옴

                String name = list.get(0);
                String summer = list.get(1);
                String winter = list.get(2);
                plantDataList.add(new SampleData(R.drawable.plant1,name,summer,winter));
                myAdapter = new MyAdapter(MainActivity.this, plantDataList);

                listView.setAdapter(myAdapter);
            }
        }
        else if (requestCode ==2){
            if(resultCode == RESULT_OK){
                int deleteIndex = Integer.parseInt(data.getStringExtra("INPUT_TEXT"));
                plantDataList.remove(deleteIndex);
                myAdapter = new MyAdapter(MainActivity.this, plantDataList);

                listView.setAdapter(myAdapter);
            }
        }
    }

}