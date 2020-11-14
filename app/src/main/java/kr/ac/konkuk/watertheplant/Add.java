package kr.ac.konkuk.watertheplant;

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

public class Add extends AppCompatActivity {
    TextView plantName;
    TextView wateringCycleSummer;
    TextView wateringCycleWinter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        plantName = (TextView)findViewById(R.id.plantName_add);
        wateringCycleSummer = (TextView)findViewById(R.id.wateringCycleSummer_add);
        wateringCycleWinter = (TextView)findViewById(R.id.wateringCycleWinter_add);

    }
}
