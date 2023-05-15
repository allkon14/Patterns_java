package org.example;

import java.util.Date;
import java.util.List;
import java.util.TreeMap;

public class Patient {
    private int ID;
    private String name, surname, patronymic;
    private Date birthday;
    private TreeMap<Date, List<Visit>> visits;
    private TreeMap<Date, String> vacs;

    public Patient(){}
    public Patient(int ID, String name, String surname, String patronymic,
                   Date birthday, TreeMap<Date, List<Visit>> visits, TreeMap<Date, String> vac){
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.visits = visits;
        this.vacs = vac;
    }
    public Patient(int ID, String name, String surname, String patronymic,
                   Date birthday){
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
    }
    public int getID(){
        return ID;
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getPatronymic(){
        return patronymic;
    }
    public Date getBirthday(){
        return birthday;
    }
    public TreeMap getVisits(){
        return visits;
    }

    public TreeMap getVacs(){
        return vacs;
    }

    public void setID(int ID){
        this.ID = ID;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setPatronymic(String patronymic){
        this.patronymic = patronymic;
    }
    public void addVisit(Date date,List<Visit> visit){
        visits.put(date, visit);
    }
    public void addVac(Date date, String name_vac){
        vacs.put(date, name_vac);
    }
    @Override
    public String toString()
    {
        return "Patient{" +
                "id='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic=" + patronymic + '\'' +
                ", birthday=" + birthday + '\'' +
                ", visits=" + visits.keySet() + '\'' +
                ", vacs=" + vacs.keySet() + '\'' +
                '}';
    }

}
