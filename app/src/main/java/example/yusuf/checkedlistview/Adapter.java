package example.yusuf.checkedlistview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Yusuf on 2016/10/22.
 */

public class Adapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<Item> list;

    public Adapter(Context context, ArrayList<Item> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        if (list == null)
            return 0;
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.item_layout, null);
            convertView.setId(position);
            Log.i("convertView", "null\tposition_" + position + "\tconvertView" + convertView.getId());
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            Log.i("convertView", "position_" + position + "\tconvertView" + convertView.getId());
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(list.get(position).getName());
        viewHolder.isChecked.setChecked(list.get(position).isChecked());

        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                list.remove(position);
                notifyDataSetChanged();
                return false;
            }
        });
        return convertView;
    }

    public class ViewHolder {
        public TextView title;
        public CheckBox isChecked;

        public ViewHolder(View view) {
            title = (TextView) view.findViewById(R.id.title);
            isChecked = (CheckBox) view.findViewById(R.id.is_checked);
        }
    }
}
