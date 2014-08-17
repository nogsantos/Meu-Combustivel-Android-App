package nogsantos.br.meucombustivel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.inputmethodservice.InputMethodService;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
         * Values
         */
        final EditText objVlGasolina = (EditText) findViewById(R.id.vlGasolina);
        final TextView objTxtResult  = (TextView) findViewById(R.id.txtResult);
        final GridLayout gridResult  = (GridLayout) findViewById(R.id.gridResult);
        /*
         * Buttons
         */
        final Button objBtCalcular = (Button) findViewById(R.id.btCalcular);
        final Button objBtLimpar   = (Button) findViewById(R.id.btLimpar);
        /*
         * Listeners
         */
        objBtCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (objVlGasolina.getText().toString().trim().length() > 0){
                    Double vl         = new Double(objVlGasolina.getText().toString());
                    Calcular calcular = new Calcular(vl);
                    objTxtResult.setText(calcular.gasolina());
                    objBtLimpar.setVisibility(objBtLimpar.VISIBLE);
                    gridResult.setVisibility(GridLayout.VISIBLE);
                }else{
                    Toast.makeText(getApplicationContext(),R.string.value_undefined,Toast.LENGTH_SHORT).show();
                }
                objVlGasolina.requestFocus();
            }
        });

        objBtLimpar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                objVlGasolina.setText("");
                gridResult.setVisibility(GridLayout.INVISIBLE);
                objBtLimpar.setVisibility(Button.INVISIBLE);
                objVlGasolina.requestFocus();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
            switch (item.getItemId()){
                case R.id.Settings:
                    Intent objSettings = new Intent(this,Settings.class);
                    startActivity(objSettings);
                    break;
                case R.id.About:
                    Intent objAbout = new Intent(this,About.class);
                    startActivity(objAbout);
                    break;
            }
        return super.onOptionsItemSelected(item);
    }
}
