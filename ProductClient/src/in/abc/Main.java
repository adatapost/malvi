package in.abc;

import in.json.JSONArray;
import in.json.JSONObject;
import in.model.Category;
import in.model.CategryBao;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Category c = new Category();
        c.setCategoryName("Keyboard");
        CategryBao.add(c);

        c.setCategoryId(2);
        c.setCategoryName("Drawing Pencil");
        CategryBao.update(c);


        ArrayList<Category> cats= CategryBao.gets();
        for(Category c1: cats) {
            System.out.println(c1);
        }
    }
    public static void main1(String[] args) {
        // String result = U.post("category-controller.php","category_name=Mouse&cmd=add");
        //System.out.println(result);

        String result = U.post("category-controller.php","cmd=rows");
        System.out.println(result);
        JSONObject object = new  JSONObject(result);
        JSONArray array = object.getJSONArray("data");

        for(int i=0;i<array.length();i++) {
            JSONObject obj = array.getJSONObject(i);
            System.out.println( obj.getInt("category_id") + " "  + obj.getString("category_name"));
        }
    }
}
