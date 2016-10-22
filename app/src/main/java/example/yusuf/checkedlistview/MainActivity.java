package example.yusuf.checkedlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ListView listView;
    TextView allCheck;
    TextView allUnCheck;
    Adapter adapter;
    ArrayList<Item> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        allCheck = (TextView) findViewById(R.id.all_check);
        allUnCheck = (TextView) findViewById(R.id.all_uncheck);
        list = initList();
        adapter = new Adapter(getBaseContext(), list);
        listView.setAdapter(adapter);
        allCheck.setOnClickListener(this);
        allUnCheck.setOnClickListener(this);

    }

    private ArrayList<Item> initList() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Item("name_" + i, false));
        }
        return list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.all_check:
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setChecked(true);
                }
                adapter.notifyDataSetChanged();
                break;
            case R.id.all_uncheck:
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setChecked(false);
                }
                adapter.notifyDataSetChanged();
                break;
        }
    }

}
