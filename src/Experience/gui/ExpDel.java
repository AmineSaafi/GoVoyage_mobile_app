/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Experience.gui;

import Experience.Midlet;
import Experience.dao.ExperienceDAO;
import Experience.entities.Experience;
import javax.microedition.lcdui.*;

/**
 *
 * @author lenovo
 */
public class ExpDel extends Form implements CommandListener, Runnable{

    TextField sch_title = new TextField("Search by Title", "", 50, TextField.ANY);
    //TextField sch_dest = new TextField("Search Destination", "", 50, TextField.ANY); 

    Command cmdDel = new Command("Confirm", Command.SCREEN, 0);
    Command cmdBack = new Command("Back", Command.EXIT, 0);

    public ExpDel() {
        super("Experience");
        
        append(sch_title);
        //append(sch_dest);
        addCommand(cmdDel);
        addCommand(cmdBack);
        setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdBack) {
            Midlet.INSTANCE.disp.setCurrent(new ExpList());
        }
        if (c == cmdDel) {
            Thread th = new Thread(this);
            th.start();
        }

    }

    public void run() {
        String title = sch_title.getString();
        //String dest = sch_dest.getString();
        
        boolean result = new ExperienceDAO().delete(title);
        Alert alert = new Alert("Result");
        if (result) {
            alert.setType(AlertType.CONFIRMATION);
            alert.setString("Experience Successfully Deleted!");
            Midlet.INSTANCE.disp.setCurrent(alert,new ExpList());
        } else {
            alert.setType(AlertType.ERROR);
            alert.setString("ERROR!");
            Midlet.INSTANCE.disp.setCurrent(alert);
        }
    }
    
    
}
