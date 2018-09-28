package view;

import org.hibernate.Session;

import controller.HibernateUtil;
import controller.LoginController;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application{
	@Override
    public void start (Stage stagePrim) throws Exception {
    	LoginController lgn = new LoginController();
    	lgn.start(stagePrim);
    	Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }
    public static void main( String[] args )
    {
    	launch(args);
    }
}