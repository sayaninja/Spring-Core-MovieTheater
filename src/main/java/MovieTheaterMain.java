import com.spring.movie.theater.dao.local.EventDaoImpl;
import com.spring.movie.theater.dao.local.UserDaoImpl;
import com.spring.movie.theater.domain.Auditorium;
import com.spring.movie.theater.domain.Event;
import com.spring.movie.theater.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.TreeSet;

@AllArgsConstructor
public class MovieTheaterMain {

    /**
     * User mode can either be admin or customer,
     * If in admin mode, needs to enter password: admin
     */
    //private String userMode = "customer";
    private UserDaoImpl localUserDao;
    private EventDaoImpl localEventDao;

    public void saveUser(User user) {
        localUserDao.save(user);
    }

    public void saveEvent(Event event) {
        localEventDao.save(event);
    }
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/spring.xml");
        MovieTheaterMain movieTheaterMain = (MovieTheaterMain) context.getBean("main");
        Auditorium auditorium = (Auditorium) context.getBean("aud1");
        System.out.println("Welcome to movie theater console assistant!");
        System.out.println("Please choose user mode: \n 1) Customer\n 2) Admin");

        System.out.println("Please choose from following options");
        System.out.println(" 1) View auditoriums\n 2) Manage events\n 3) Manage users\n 4) Book tickets");

        User user = User.builder()
                .firstName("John")
                .lastName("Smith")
                .email("john@gmail.com")
                .build();
        movieTheaterMain.saveUser(user);

        Event event = Event.builder()
                .name("SuperBowl")
                .basePrice(100.0)
                .airDates(new TreeSet<>())
                .build();

        movieTheaterMain.saveEvent(event);
    }
}
