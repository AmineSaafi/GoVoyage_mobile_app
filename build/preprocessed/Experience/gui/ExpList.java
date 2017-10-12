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
import Experience.gui.*;

/**
 *
 * @author lenovo
 */
public class ExpList extends List implements CommandListener,Runnable{
    
   
    Command cmdAdd = new Command("Add", Command.SCREEN, 0);
    Command cmdDel = new Command("Delete", Command.SCREEN, 0);
    Command cmdMod = new Command("Modify", Command.SCREEN, 0);
    Command cmdExit = new Command("Exit", Command.EXIT, 0);

    public ExpList() {
        super("Experiences's List", List.IMPLICIT);
        addCommand(cmdAdd);
        addCommand(cmdDel);
        addCommand(cmdMod);
        addCommand(cmdExit);
        setCommandListener(this);
        Thread th = new Thread(this);
        th.start();
        
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdAdd) {
            Midlet.INSTANCE.disp.setCurrent(new ExpAdd());
        }
        if (c == cmdExit) {
            Midlet.INSTANCE.notifyDestroyed();
        }
        if (c == cmdDel) {
            
            
            Midlet.INSTANCE.disp.setCurrent(new ExpDel());
        }
        if (c == cmdMod) {
            Midlet.INSTANCE.disp.setCurrent(new ExpMod());
        }
    }

    public void run() {
        Experience[] experiences = new ExperienceDAO().select();
        if (experiences.length > 0) {
            for (int i = 0; i < experiences.length; i++) {
                append(experiences[i].getTitle() + " - " + experiences[i].getNote()+ " - " +experiences[i].getDescription()+ " \n " + experiences[i].getDestination()+ " On : " + experiences[i].getDate()+"\n------------------------------------------", null);
            }
        }
    }
    
}
