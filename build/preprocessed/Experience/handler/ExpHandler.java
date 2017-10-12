/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Experience.handler;

import Experience.entities.Experience;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author lenovo
 */
public class ExpHandler extends DefaultHandler {

    private Vector ExperienceVector;

    public ExpHandler() {
        ExperienceVector = new Vector();
    }

    public Experience[] getExperience() {
        Experience[] personTab = new Experience[ExperienceVector.size()];
        ExperienceVector.copyInto(personTab);
        return personTab;
    }

    String selectedBalise = "";
    Experience seclectedExperience;

    public void startElement(String string, String string1, String qName, Attributes atrbts) throws SAXException {
        if (qName.equals("Experience")) {
            seclectedExperience = new Experience();
        } else if (qName.equals("IdExp")) {
            selectedBalise = "IdExp";
        } else if (qName.equals("Title")) {
            selectedBalise = "Title";
        } else if (qName.equals("Destination")) {
            selectedBalise = "Destination";
        } else if (qName.equals("Date")) {
            selectedBalise = "Date";
        } else if (qName.equals("Note")) {
            selectedBalise = "Note";
        } else if (qName.equals("Description")) {
            selectedBalise = "Description";
        }
    }

    public void endElement(String string, String string1, String qName) throws SAXException {
        if (qName.equals("Experience")) {

            ExperienceVector.addElement(seclectedExperience);
            seclectedExperience = null;
        } else if (qName.equals("IdExp")) {
            selectedBalise = "";
        } else if (qName.equals("Title")) {
            selectedBalise = "";
        } else if (qName.equals("Destination")) {
            selectedBalise = "";
        } else if (qName.equals("Date")) {
            selectedBalise = "";
        } else if (qName.equals("Note")) {
            selectedBalise = "";
        } else if (qName.equals("Description")) {
            selectedBalise = "";
        }

    }

    public void characters(char[] chars, int i, int i1) throws SAXException {
        if (seclectedExperience != null) {
            if (selectedBalise.equals("IdExp")) {
                seclectedExperience.setId(Integer.parseInt(new String(chars, i, i1)));
                //System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("Title")) {
                seclectedExperience.setTitle(new String(chars, i, i1));
                //System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("Destination")) {
                seclectedExperience.setDestination(new String(chars, i, i1));
                //System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("Date")) {
                seclectedExperience.setDate(new String(chars, i, i1));
               // System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("Note")) {
                seclectedExperience.setNote(Integer.parseInt(new String(chars, i, i1)));
                //System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("Description")) {
                seclectedExperience.setDescription(new String(chars, i, i1));
                //System.out.println(new String(chars, i, i1));
            }
        }
    }

}
