package kr.ac.konkuk.watertheplant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<SampleData> plantDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.InitializeMovieData();


        Button add = (Button)findViewById(R.id.add);
        Button modify = (Button)findViewById(R.id.modify);
        Button delete = (Button)findViewById(R.id.delete);


        ListView listView = (ListView)findViewById(R.id.listView);
        final MyAdapter myAdapter = new MyAdapter(this, plantDataList);

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