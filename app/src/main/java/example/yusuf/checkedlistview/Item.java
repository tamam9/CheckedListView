package example.yusuf.checkedlistview;

/**
 * Created by Yusuf on 2016/10/22.
 */

public class Item {
    String name="";
    boolean isChecked;

    public Item(String name, boolean isChecked) {
        this.name = name;
        this.isChecked = isChecked;
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
