package utils;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.User;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utils {

    public static List<User> users;

    /**
     * Method to parse JSON String into Java Object using Jackson Parser.
     *
     */
    public static void JSONtoUserList() {

        // this is the key object to convert JSON to Java
        ObjectMapper mapper = new ObjectMapper();
        //users = new ArrayList<>();
        try {
            users = Arrays.asList(mapper.readValue(Paths.get("src/test/resources/datafiles/Users.json").toFile(), User[].class));
            users.forEach(System.out::println);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static User getUserFromList(int userId){
        boolean found = false;
        User user = null;
        for(User iUser : users) {
            if (iUser.getId() == userId) {
                found = true;
                user = iUser;
            }
        }

        return user;
    }

    public static void wait(int sec) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.wait(sec);
    }
}
