package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class FeedParser {
    public List<Feed> parseFeeds(String filename) {
        Gson gson = new Gson();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            Type feedListType = new TypeToken<List<Feed>>() {}.getType();
            return gson.fromJson(br, feedListType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
