package course.examples.newboston;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Molham on 1/1/2016.
 */
public class Menu extends ListActivity {
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.basic_menu,menu);
        return true;
    }

    String items[] = {"MainActivity","Grafity","Email","UsingCamera","Send"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_list_item_1,items));
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        try {
            Class ourClass = Class.forName("course.examples.newboston."+items[position]);
            startActivity( new Intent(Menu.this,ourClass));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
        }

    }


}
