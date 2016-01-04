package course.examples.newboston;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Molham on 1/2/2016.
 */
public class Send extends Activity implements View.OnClickListener {

    EditText et;
    Button b;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
        init();
    }

    private void init() {
        et = (EditText) findViewById(R.id.etSend);
        b= (Button) findViewById(R.id.bSend);
        tv = (TextView)findViewById(R.id.tvSend);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(Send.this,Receive.class );
        Bundle bundle = new Bundle();
        bundle.putString("text",et.getText().toString());
        i.putExtras(bundle);

        startActivityForResult(i, 0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            tv.setText(bundle.getString("text"));
        }
    }
}
