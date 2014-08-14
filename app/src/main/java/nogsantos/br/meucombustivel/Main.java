package nogsantos.br.meucombustivel;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
         * Focus
         */
        findViewById(R.id.vlGasolina).requestFocus();
        /*
         * Values
         */
        final EditText objVlGasolina = (EditText) findViewById(R.id.vlGasolina);
        final TextView objTxtResult  = (TextView) findViewById(R.id.txtResult);
        /*
         * Button
         */
        final Button objBotao = (Button) findViewById(R.id.btCalcular);
        objBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (objVlGasolina.getText().toString().trim().length() > 0){
                    Double vl         = new Double(objVlGasolina.getText().toString());
                    Calcular calcular = new Calcular(vl);
                    objTxtResult.setText(calcular.gasolina());
                }else{
                    Toast.makeText(getApplicationContext(),"Valor indefinido!",Toast.LENGTH_SHORT).show();
                }
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
