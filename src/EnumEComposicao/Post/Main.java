package EnumEComposicao.Post;
import EnumEComposicao.Post.Entities.Comment;
import EnumEComposicao.Post.Entities.Post;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime data1 = LocalDateTime.parse("21/06/2018 13:05:44", formato);
        String title1 = "Traveling to new Zeeland";
        String content1 = "I'm going to visit this wonderful country!";
        Integer likes1 = 12;

        LocalDateTime data2 = LocalDateTime.parse("28/07/2018 23:14:19", formato);
        String title2 = "Good night guys";
        String content2 = "see you tomorrow";
        Integer likes2 = 5;

        Post postOne = new Post(data1, title1, content1, likes1);
        Post postTwo = new Post(data2, title2, content2, likes2);

        Comment commentOnePostOne = new Comment("Have a nice trip");
        Comment commentTwoPostOne = new Comment("Wow that's awesome!");
        Comment commentOnePostTwo = new Comment("Good night");
        Comment commentTwoPostTwo = new Comment("May the force be with you");

        postOne.addComment(commentOnePostOne);
        postOne.addComment(commentTwoPostOne);
        postTwo.addComment(commentOnePostTwo);
        postTwo.addComment(commentTwoPostTwo);

        System.out.println(postOne);
        System.out.println("----------------");
        System.out.println(postTwo);
    }
}
