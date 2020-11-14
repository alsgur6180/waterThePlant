package kr.ac.konkuk.watertheplant;

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
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<SampleData> plantDataList;
    MyAdapter myAdapter;
    EditText editDelete;
    EditText editName;
    EditText editSummer;
    EditText editWinter;
//    RadioButton plant1;
//    RadioButton plant2;
//    RadioButton plant3;
    Button add;
    Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.InitializeMovieData();
        listView = (ListView)findViewById(R.id.listView);
        editDelete = (EditText)findViewById(R.id.edit_delete);
        editName = (EditText)findViewById(R.id.edit_name);
        editSummer = (EditText)findViewById(R.id.edit_summer);
        editWinter = (EditText)findViewById(R.id.edit_winter);
//        plant1 = (RadioButton)findViewById(R.id.radioButton_plant1);
//        plant2 = (RadioButton)findViewById(R.id.radioButton_plant2);
//        plant3 = (RadioButton)findViewById(R.id.radioButton_plant3);

        add = (Button)findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View arg0) {
                String name = editName.getText().toString();
                String summer = editSummer.getText().toString();
                String winter = editWinter.getText().toString();
                plantDataList.add(new SampleData(R.drawable.plant1,name,summer,winter));
                myAdapter = new MyAdapter(MainActivity.this, plantDataList);

                listView.setAdapter(myAdapter);
            }
        });
        delete = (Button)findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View arg0) {
                int deleteIndex = Integer.parseInt(editDelete.getText().toString());
                plantDataList.remove(deleteIndex);
                myAdapter = new MyAdapter(MainActivity.this, plantDataList);

                listView.setAdapter(myAdapter);
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

        plantDataList.add(new SampleData(R.drawable.plant1, "관음죽","여름 3일","겨울 7일"));
        plantDataList.add(new SampleData(R.drawable.plant2, "몬스테라","여름 2일","겨울 5일"));
        plantDataList.add(new SampleData(R.drawable.plant3, "율마","여름 매일","겨울 8일"));
    }


}