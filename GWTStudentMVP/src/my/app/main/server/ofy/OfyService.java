package my.app.main.server.ofy;



import my.app.main.server.entity.Mark;
import my.app.main.server.entity.Student;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;


public class OfyService {
    static {
        factory().register(Student.class);
        factory().register(Mark.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.begin();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}