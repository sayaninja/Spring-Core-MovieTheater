import com.spring.movie.theater.dao.local.LocalUserDao;
import com.spring.movie.theater.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@AllArgsConstructor
public class MovieTheaterMain {
    private LocalUserDao localUserDao;

    public void saveUser(User user) {
        localUserDao.save(user);
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/spring.xml");
        MovieTheaterMain movieTheaterMain = (MovieTheaterMain) context.getBean("main");

        User user = User.builder()
                .firstName("John")
                .lastName("Smith")
                .email("john@gmail.com")
                .build();

        movieTheaterMain.saveUser(user);
        movieTheaterMain.saveUser(user);
    }
}
