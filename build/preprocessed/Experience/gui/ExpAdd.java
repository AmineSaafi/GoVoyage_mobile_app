/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Experience.gui;

import Experience.Midlet;
import Experience.dao.ExperienceDAO;
import Experience.entities.Experience;
import java.io.IOException;
import java.util.TimeZone;
import javax.microedition.lcdui.*;

/**
 *
 * @author lenovo
 */
public class ExpAdd extends Form implements CommandListener, Runnable {
    
    TextField tf_title = new TextField("Title", "", 50, TextField.ANY);
    TextField tf_dest = new TextField("Destination", "", 50, TextField.ANY);
    
    //TextField tf_date = new TextField("Date", "", 50, TextField.ANY);
    
    DateField df = new DateField("Date", DateField.DATE_TIME);
    String[] note = {"1","2","3","4","5"};
    ChoiceGroup cg = new ChoiceGroup("Note" , ChoiceGroup.POPUP, note, Midlet.INSTANCE.img);
    TextField tf_desc = new TextField("Description", "", 50, TextField.ANY);
    

    Command cmdAdd = new Command("Confirm", Command.SCREEN, 0);
    Command cmdBack = new Command("Back", Command.EXIT, 0);

    public ExpAdd() {
        super("Experience");

        append(tf_title);
        append(tf_dest);
        //append(tf_date);
        append(df);
        append(cg);
        append(tf_desc);
        addCommand(cmdAdd);
        addCommand(cmdBack);
        setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdBack) {
            Midlet.INSTANCE.disp.setCurrent(new ExpList());
        }
        if (c == cmdAdd) {
            Thread th = new Thread(this);
            th.start();
        }

    }

    public void run() {
        String title = tf_title.getString();
        String dest = tf_dest.getString();
        //String date = tf_date.getString();
        String date = df.getDate().toString();
        String date1 = date.replace(' ', '-');       
        
        int note = cg.getSelectedIndex();
        String desc = tf_desc.getString();
        
        boolean result = new ExperienceDAO().insert(new Experience(title, dest, date1,note, desc));
        Alert alert = new Alert("Result");
        if (result) {
            alert.setType(AlertType.CONFIRMATION);
            alert.setString("Experience Successfully Added!");
            Midlet.INSTANCE.disp.setCurrent(alert,new ExpList());
        } else {
            alert.setType(AlertType.ERROR);
            alert.setString("ERROR!");
            Midlet.INSTANCE.disp.setCurrent(alert);
        }
    }
    
}
