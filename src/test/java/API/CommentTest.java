package API;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import model.Comment;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CommentTest {

    private static Gson gson = new Gson();
    private static String body = "est rerum tempore vitae\n" +
            "sequi sint nihil reprehenderit dolor beatae ea dolores neque\n" +
            "fugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\n" +
            "qui aperiam non debitis possimus qui neque nisi nulla";

    @Test
    public static void getComment(){
        String url = "https://jsonplaceholder.typicode.com/posts/2";
        String response = RestAssured.given().when().get(url).asString();
        Comment comment = gson.fromJson(response, Comment.class);
        Assert.assertEquals(comment.getUserId(), new Integer(1));
        Assert.assertEquals(comment.getId(), new Integer(2));
        Assert.assertEquals(comment.getTitle(), "qui est esse");
        Assert.assertEquals(comment.getBody(), body);
    }
}
