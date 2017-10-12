/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Experience;

import Experience.gui.ExpList;
import java.io.IOException;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 * @author lenovo
 */
public class Midlet extends MIDlet {

    public Display disp = Display.getDisplay(this); 
    public Image[] img = new Image[5];

    public static Midlet INSTANCE = null;

    public void startApp() {
        INSTANCE = this;
        disp.setCurrent(new ExpList());

        try {
            for (int i=0;i<5;i++){
            img[i] = Image.createImage("Experience/pics/star.png");}
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}
