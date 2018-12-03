/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author andreamarin
 */

/*
    Singleton --> only one session is created through the entire lifecycle. 
    It can have multiple clients
*/
@Singleton 
@LocalBean
@WebListener
public class SessionManagerBean implements HttpSessionListener{
    private static int counter = 0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        counter++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        counter--;
    }
    
    public int getActiveSessionsCount(){
        return counter;
    }
}
