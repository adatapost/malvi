package in.model;

import in.abc.U;
import in.json.JSONArray;
import in.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by kvprajapati on 8/16/2017.
 */
public class CategryBao {
    private static final String url = U.URL + "/category-controller.php";

    public static boolean add(Category category) {
        String data = String.format("category_name=%s&cmd=%s",
                category.getCategoryName(), "add");
        String result = U.post(url, data);

        JSONObject object = new JSONObject(result);
        return object.getBoolean("status");
    }

    public static boolean update(Category category) {
        String data = String.format("category_name=%s&category_id=%d&cmd=%s",
                category.getCategoryName(),
                category.getCategoryId(),
                "update");
        String result = U.post(url, data);

        JSONObject object = new JSONObject(result);
        return object.getBoolean("status");
    }

    public static boolean delete(Category category) {
        String data = String.format("category_id=%d&cmd=%s",
                category.getCategoryId()
                , "delete");
        String result = U.post(url, data);

        JSONObject object = new JSONObject(result);
        return object.getBoolean("status");
    }

    public static ArrayList<Category> gets() {
        ArrayList<Category> list = new ArrayList<>();

        String data = String.format("cmd=%s",
                "rows");
        System.out.println(url);
        String result = U.post(url, data);
        JSONObject object = new JSONObject(result);
        JSONArray array = object.getJSONArray("data");

        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);
            Category c = new Category(obj.getInt("category_id"), obj.getString("category_name"));
            list.add(c);
        }
        return list;
    }

    public static Category get(Category category) {
        ArrayList<Category> list = new ArrayList<>();

        String data = String.format("category_id=%d&cmd=%s",
                category.getCategoryId(),
                "rows");
        String result = U.post(url, data);
        JSONObject object = new JSONObject(result);
        JSONObject obj = object.getJSONObject("data");
        Category c = new Category(obj.getInt("category_id"), obj.getString("category_name"));
        return c;
    }
}
