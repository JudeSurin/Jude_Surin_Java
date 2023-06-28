

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class ChatterbookController {
    private List<User> userList;

    public ChatterbookController() {
        // Creating User instances and setting chatterPosts
        User luis = new User("Luis");
        User sue = new User("Sue");
        User timothy = new User("Timothy");
        User george = new User("George");
        User arturo = new User("Arturo");
        User mariella = new User("Mariella");
        User paolo = new User("Paolo");
        User tri = new User("Tri");
        User jane = new User("Jane");
        User carol = new User("Carol");
        User carl = new User("Carl");

        // Setting chatterPosts for each user
        luis.setChatterPosts(Arrays.asList(new ChatterPost("Hey! This is my first post!"), new ChatterPost("Anybody want to be friends?")));
        sue.setChatterPosts(Arrays.asList(new ChatterPost("I'm bored"), new ChatterPost("Who wants to hang?")));
        timothy.setChatterPosts(Arrays.asList(new ChatterPost("My life is awesome!"), new ChatterPost("Click here to buy my vegan shakes!")));
        george.setChatterPosts(Arrays.asList(new ChatterPost("I like pigs."), new ChatterPost("I love lamp.")));
        arturo.setChatterPosts(Arrays.asList(new ChatterPost("My cat is so cute"), new ChatterPost("My kitten is purr-fect.")));
        mariella.setChatterPosts(Collections.singletonList(new ChatterPost("I'll never post again")));
        paolo.setChatterPosts(Arrays.asList(new ChatterPost("Have you ever heard of the band Nirvana?"), new ChatterPost("Pearl Jam 4 Life")));
        tri.setChatterPosts(Arrays.asList(new ChatterPost("You definitely grew up in the 90s if you get these 10 references."), new ChatterPost("I don't get this generation? Everyone expects a participation trophy.")));
        jane.setChatterPosts(Arrays.asList(new ChatterPost("I just wrecked my dad's car. He's going to kill me!"), new ChatterPost("Grounded.... for 5 months :( ")));
        carol.setChatterPosts(Collections.singletonList(new ChatterPost("Does anyone have some imodium?")));
        carl.setChatterPosts(Arrays.asList(new ChatterPost("My roommate is awful!!!!"), new ChatterPost("Anyone know a room for rent in Hyde Park?")));

        // Populating userList
        userList = Arrays.asList(luis, sue, timothy, george, arturo, mariella, paolo, tri, jane, carol, carl);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userList;
    }

    @GetMapping("/users/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userList.stream()
                .filter(user -> user.getName().equals(username))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/users/{username}/chatterPosts")
    public List<ChatterPost> getChatterPostsByUsername(@PathVariable String username) {
        User user = getUserByUsername(username);
        return (user != null) ? user.getChatterPosts() : null;
    }

    // User class implementation
    private static class User {
        private String name;
        private List<ChatterPost> chatterPosts;

        public User(String name) {
            this.name = name;
            this.chatterPosts = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public List<ChatterPost> getChatterPosts() {
            return chatterPosts;
        }

        public void setChatterPosts(List<ChatterPost> chatterPosts) {
            this.chatterPosts = chatterPosts;
        }
    }

    // ChatterPost class implementation
    private static class ChatterPost {
        private String message;

        public ChatterPost(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}


