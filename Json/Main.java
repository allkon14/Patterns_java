package org.example;
import java.util.*;
//
//import org.json.JSONArray;
//import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.SerializationFeature;

//
//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Patient> patients = new ArrayList<>();
        {
            TreeMap<Date, List<Visit>> vis0 = new TreeMap<>();
            TreeMap<Date, String> vac0 = new TreeMap<>();
            List<Visit> lvis = new ArrayList<>(Arrays.asList(new Visit("X-ray", 500, "Popov S. A."), new Visit("Heart Specialist", 1000, "Zubova I. V.")));
            vac0.put(new GregorianCalendar(2021, Calendar.MAY, 20).getTime(), "Masles");
            vis0.put(new GregorianCalendar(2019, Calendar.MARCH, 20, 15, 10).getTime(), lvis);
            patients.add(new Patient(99403, "Ivan", "Ivanov", "Ivanovish", new GregorianCalendar(1980, Calendar.MAY, 17).getTime(), vis0, vac0));
        }
        {
            TreeMap<Date, List<Visit>> vis1 = new TreeMap<>();
            TreeMap<Date, String> vac1 = new TreeMap<>();
            List<Visit> lvis1 = new ArrayList<>(Arrays.asList(new Visit("X-ray", 0, "Popov S. A.")));
            vac1.put(new GregorianCalendar(2020, Calendar.MARCH, 18).getTime(), "Sputnic");
            vis1.put(new GregorianCalendar(2020, Calendar.AUGUST, 14, 12, 00).getTime(), lvis1);
            patients.add(new Patient(6372293, "Maria", "Popova", "Ivanovna", new GregorianCalendar(1992, Calendar.OCTOBER, 10).getTime(), vis1, vac1));
        }
        {
            TreeMap<Date, List<Visit>> vis2 = new TreeMap<>();
            TreeMap<Date, String> vac2 = new TreeMap<>();
            List<Visit> lvis2 = new ArrayList<>();
            vac2.put(new GregorianCalendar(2020, Calendar.MARCH, 18).getTime(), "Sputnic");
            vac2.put(new GregorianCalendar(2021, Calendar.MAY, 20).getTime(), "Masles");
            vac2.put(new GregorianCalendar(2022, Calendar.MAY, 20).getTime(), "Chikenpox");
            vis2.put(new GregorianCalendar(2020, Calendar.AUGUST, 14, 8, 45).getTime(), lvis2);
            patients.add(new Patient(5173645, "Petr", "Koh", "Arcadevish", new GregorianCalendar(2004, Calendar.OCTOBER, 1).getTime(), vis2, vac2));
        }


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(new File("patients.json"), patients);

        String result = objectMapper.writeValueAsString(patients);
        System.out.println(result);

        byte[] jsonData = Files.readAllBytes(Paths.get("patients.json"));
        ObjectMapper mapperBack = new ObjectMapper();
        Patient[] resultBack = mapperBack.readValue(jsonData, Patient[].class);
        for (Patient patient :resultBack)
            System.out.println(patient);




















/*

        hm0.put( new GregorianCalendar(2019, Calendar.MARCH, 20, 15,10).getTime(), ls);
        clients.add(new HaircutMan("01","Denis",
                "Kochetkov", "Alexeevich",
                new GregorianCalendar(1997, Calendar.FEBRUARY, 11).getTime(), hm0));

        TreeMap<Date, List<Service>> hm1 = new TreeMap<>();
        ls = new ArrayList<>(Arrays.asList(new Service("mask",500,"clay"), new Service("haircut",1500)));
        hm1.put( new GregorianCalendar(2023, Calendar.FEBRUARY, 1,12,0).getTime(), ls);
        ls = new ArrayList<>(Arrays.asList(new Service("mask",700,"black"), new Service("haircut",2000)));
        hm1.put( new GregorianCalendar(2023, Calendar.MARCH, 1,12,0).getTime(), ls);
        List<Service> ls1 = new ArrayList<>(Arrays.asList(new Service("mask",500,"clay"), new Service("haircut",1000)));
        clients.add(new HaircutMan("02","Danil",
                "Grishin", "Alexandrovich",
                new GregorianCalendar(2001, Calendar.JANUARY, 17).getTime(), hm1));
 */
    }
}