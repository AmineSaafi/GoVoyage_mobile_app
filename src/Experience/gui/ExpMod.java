/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Experience.gui;

import Experience.Midlet;
import Experience.dao.ExperienceDAO;
import javax.microedition.lcdui.*;

/**
 *
 * @author lenovo
 */
public class ExpMod extends Form implements CommandListener, Runnable{
    TextField sch_title = new TextField("Search by Title", "", 50, TextField.ANY);
    
    
    TextField tf_title = new TextField("New Title", "", 50, TextField.ANY);
    TextField tf_dest = new TextField("New Destination", "", 50, TextField.ANY);
    String[] note = {"1","2","3","4","5"};
    ChoiceGroup cg = new ChoiceGroup("New Note" , ChoiceGroup.POPUP, note, Midlet.INSTANCE.img);
    TextField tf_desc = new TextField("New Description", "", 50, TextField.ANY);

    Command cmdMod = new Command("Confirm", Command.SCREEN, 0);
    Command cmdBack = new Command("Back", Command.EXIT, 0);

    public ExpMod() {
        super("Experience");

        append(sch_title);
        append("\n------------------------------------------");
        append(tf_title);
        append(tf_dest);
        append(cg);
        append(tf_desc);
        
        addCommand(cmdMod);
        addCommand(cmdBack);
        setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdBack) {
            Midlet.INSTANCE.disp.setCurrent(new ExpList());
        }
        if (c == cmdMod) {
            Thread th = new Thread(this);
            th.start();
        }

    }

    public void run() {
        String old_title = sch_title.getString();
        String title = tf_title.getString();
        String dest = tf_dest.getString();
        int note = cg.getSelectedIndex();
        String desc = tf_desc.getString();
        
        boolean result = new ExperienceDAO().modify(old_title,title,dest,note,desc);
        Alert alert = new Alert("Result");
        if (result) {
            alert.setType(AlertType.CONFIRMATION);
            alert.setString("Experience Successfully Modified!");
            Midlet.INSTANCE.disp.setCurrent(alert,new ExpList());
        } else {
            alert.setType(AlertType.ERROR);
            alert.setString("ERROR!");
            Midlet.INSTANCE.disp.setCurrent(alert);
        }
    }
    
    

}
