package kswe2018;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;

@WebServlet(value="/helloWorld", name="helloWorldServlet")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // declaring object of "OWM" class
        OWM owm = new OWM("dfd4717f4530e9a87fbe30376af1ff38");

        // getting current weather data for the "London" city
        CurrentWeather cwd;
        try {
            cwd = owm.currentWeatherByCityName("Bochum");
            resp.setStatus(200);
            resp.setHeader("Content-Type", "application/json");
            resp.getWriter().print("Temperature: " + cwd.getMainData().getTempMax()
                            + "/" + cwd.getMainData().getTempMin() + "\'K");
            
        } catch (APIException ex) {
            Logger.getLogger(HelloWorldServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        
    }

}
