package course.examples.newboston;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Created by Molham on 1/1/2016.
 */
public class Grafity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grafity);

        final Button b = (Button)findViewById(R.id.bStart);
        final ToggleButton tb = (ToggleButton)findViewById(R.id.tbSwitch);
        final EditText et = (EditText)findViewById(R.id.edCommand);
        final TextView tv = (TextView) findViewById(R.id.tvTesting);

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    et.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }else {
                    et.setInputType(InputType.TYPE_CLASS_TEXT );
                }
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textValue = et.getText().toString();
                if(textValue.toLowerCase().contentEquals("right")){

                }else if(textValue.toLowerCase().contentEquals("right")){
                    tv.setGravity(android.view.Gravity.RIGHT);
                }else if(textValue.toLowerCase().contentEquals("left")){
                    tv.setGravity(android.view.Gravity.LEFT);
                }else if(textValue.toLowerCase().contentEquals("center")){
                    tv.setGravity(android.view.Gravity.CENTER);
                }else if(textValue.toLowerCase().contentEquals("blue")){
                    tv.setTextColor(Color.BLUE);
                }else if(textValue.toLowerCase().contentEquals("red")){
                    tv.setTextColor(Color.RED);
                }else if(textValue.toLowerCase().contentEquals("green")){
                    tv.setTextColor(Color.GREEN);
                }
            }
        });
    }
}
