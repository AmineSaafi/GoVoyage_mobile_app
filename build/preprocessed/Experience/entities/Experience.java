/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Experience.entities;

/**
 *
 * @author lenovo
 */
public class Experience {
    
    private int id;
    private String title;
    private String destination;
    private String date;
    private int note;
    private String description;
    
    public Experience() {
    }
    
    public Experience(String title, String destination, String date,int note,String description) {
        this.title = title;
        this.destination = destination;
        this.date = date;
        this.note= note;
        this.description=description;
    }

    public Experience(int id, String title, String destination, String date,int note,String description) {
        this.title = title;
        this.destination = destination;
        this.date = date;
        this.note= note;
        this.description=description;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
