package course.examples.newboston;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by Molham on 1/2/2016.
 */
public class Receive extends Activity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener{

    TextView tv;
    RadioGroup rg;
    Button b;
    Intent i;
    String postback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receive);
        init();
        Bundle receiveBundle = getIntent().getExtras();
        tv.setText(receiveBundle.getString("text"));
    }

    private void init() {
        tv = (TextView)findViewById(R.id.tvReceive);
        rg = (RadioGroup)findViewById(R.id.rgReceive);
        b = (Button)findViewById(R.id.bReceive);
        b.setOnClickListener(this);
        rg.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        bundle.putString("text",postback);
//        i =  new Intent(Receive.this,Send.class);
        i = new Intent();
        i.putExtras(bundle);
        setResult(RESULT_OK,i);
        finish();
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId)
        {
            case R.id.rbOption1:
                postback = "we will improve it in the future";
                break;
            case R.id.rbOption2:
                postback = "Thanks for your feedback";
                break;
            case R.id.rbOption3:
                postback = "We are glad to hear that";
                break;
        }


    }
}
