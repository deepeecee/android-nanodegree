package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        JSONObject sandwichReader = new JSONObject(json);

        JSONObject names = sandwichReader.getJSONObject("name");
        String mainName = names.getString("mainName");

        JSONArray otherNames = names.getJSONArray("alsoKnownAs");
        List<String> alsoKnownAs = new ArrayList();
        for (int i = 0; i < otherNames.length(); i++) {
            alsoKnownAs.add(otherNames.getString(i));
        }

        String placeOfOrigin = sandwichReader.getString("placeOfOrigin");

        String description = sandwichReader.getString("description");

        String image = sandwichReader.getString("image");

        JSONArray ingredientsArray = sandwichReader.getJSONArray("ingredients");
        List<String> ingredients = new ArrayList();
        for (int i = 0; i < ingredientsArray.length(); i++) {
            ingredients.add(ingredientsArray.getString(i));
        }

        Sandwich sandwich = new Sandwich();
        sandwich.setMainName(mainName);
        sandwich.setAlsoKnownAs(alsoKnownAs);
        sandwich.setPlaceOfOrigin(placeOfOrigin);
        sandwich.setDescription(description);
        sandwich.setImage(image);
        sandwich.setIngredients(ingredients);

        return sandwich;
    }
}
