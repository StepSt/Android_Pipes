package com.example.admin.pipes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Locale;


public class Calc extends AppCompatActivity {

    String[] data = {"Круглые трубы", "Прямоугольные трубы"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setPrompt("Тип расчета");
        spinner.setSelection(0);
        final FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        final FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.frameLayout2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
                switch (position)
                {
                    case 0:
                        frameLayout.setVisibility(view.VISIBLE);
                        frameLayout2.setVisibility(view.GONE);
                        break;
                    case 1:
                        frameLayout2.setVisibility(view.VISIBLE);
                        frameLayout.setVisibility(view.GONE);
                        break;
                }
                // показываем позиция нажатого элемента
                Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                Toast.makeText(Calc.this, getString(R.string.action_settings), Toast.LENGTH_LONG).show();
                Intent intent_setting = new Intent(this, Setting.class);
                startActivity(intent_setting);
                break;
            case R.id.action_calk:
                Toast.makeText(Calc.this, getString(R.string.action_item1), Toast.LENGTH_LONG).show();
                Intent intent_calk = new Intent(this, Calc.class);
                startActivity(intent_calk);
                break;
            case R.id.action_about:
                Toast.makeText(Calc.this, getString(R.string.action_item2), Toast.LENGTH_LONG).show();
                Intent intent_about = new Intent(this, About.class);
                startActivity(intent_about);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void Clic_Result (View view)
    {
        EditText edit_D = (EditText) findViewById(R.id.edit_D);
        EditText edit_S = (EditText) findViewById(R.id.edit_S);
        EditText edit_L = (EditText) findViewById(R.id.edit_L);
        Double res_pM = ((Double.parseDouble(edit_D.getText().toString()) - Double.parseDouble(edit_S.getText().toString()))*Double.parseDouble(edit_S.getText().toString()))/40.55;
        TextView text_pM = (TextView) findViewById(R.id.text_pM);
        text_pM.setText(String.format( Locale.US, "%.2f", res_pM));
        Double res_M = res_pM*Double.parseDouble(edit_L.getText().toString());
        TextView text_M = (TextView) findViewById(R.id.text_M);
        text_M.setText(String.format( Locale.US, "%.2f", res_M));
    }
    public  void Clic_Result_p (View view)
    {
        EditText edit_A = (EditText) findViewById(R.id.edit_A);
        EditText edit_B = (EditText) findViewById(R.id.edit_B);
        EditText edit_S_p = (EditText) findViewById(R.id.edit_S_p);
        EditText edit_L_p = (EditText) findViewById(R.id.edit_L_p);
        //0.0157 * S * (A + B - 2.86 * S) * L
        Double res_pM_p = 0.0157*Double.parseDouble(edit_S_p.getText().toString())*(Double.parseDouble(edit_A.getText().toString())+Double.parseDouble(edit_B.getText().toString())- 2.86*Double.parseDouble(edit_S_p.getText().toString()));
        TextView text_pM_p = (TextView) findViewById(R.id.text_pM_p);
        text_pM_p.setText(String.format( Locale.US, "%.2f", res_pM_p));
        Double res_M_p = res_pM_p*Double.parseDouble(edit_L_p.getText().toString());
        TextView text_M_p = (TextView) findViewById(R.id.text_M_p);
        text_M_p.setText(String.format( Locale.US, "%.2f", res_M_p));
    }
}
