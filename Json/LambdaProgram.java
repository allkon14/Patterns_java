package org.example;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static java.lang.Math.max;

public class LambdaProgram {
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

        {
            TreeMap<Date, List<Visit>> vis2 = new TreeMap<>();
            TreeMap<Date, String> vac2 = new TreeMap<>();
            List<Visit> lvis2 = new ArrayList<>(Arrays.asList(new Visit("Heart Specialist", 1000, "Zubova I. V.")));
            vac2.put(new GregorianCalendar(2021, Calendar.MARCH, 18).getTime(), "Masles");
            vac2.put(new GregorianCalendar(2020, Calendar.MAY, 20).getTime(), "Sputnic");
            vac2.put(new GregorianCalendar(2021, Calendar.MAY, 20).getTime(), "Sputnic");
            vis2.put(new GregorianCalendar(2021, Calendar.AUGUST, 14, 18, 45).getTime(), lvis2);
            patients.add(new Patient(746638, "Petra", "Kohovish", "Popovna", new GregorianCalendar(2000, Calendar.APRIL, 1).getTime(), vis2, vac2));
        }

        {
            TreeMap<Date, List<Visit>> vis2 = new TreeMap<>();
            TreeMap<Date, String> vac2 = new TreeMap<>();
            List<Visit> lvis2 = new ArrayList<>(Arrays.asList(new Visit("X-ray", 500, "Popov S. A."), new Visit("Heart Specialist", 1000, "Zubova I. V."), new Visit("Brain Specialist", 10000, "Zubovish I. V.")));

            vac2.put(new GregorianCalendar(2021, Calendar.MAY, 20).getTime(), "Masles");
            vac2.put(new GregorianCalendar(2022, Calendar.MAY, 20).getTime(), "Chikenpox");
            vis2.put(new GregorianCalendar(2022, Calendar.AUGUST, 14, 11, 45).getTime(), lvis2);
            patients.add(new Patient(87346823, "Anna", "Popova", "Sergeevna", new GregorianCalendar(2002, Calendar.OCTOBER, 10).getTime(), vis2, vac2));
        }
        {
            TreeMap<Date, List<Visit>> vis0 = new TreeMap<>();
            TreeMap<Date, String> vac0 = new TreeMap<>();
            List<Visit> lvis = new ArrayList<>(Arrays.asList(new Visit("X-ray", 500, "Popov S. A."), new Visit("Brain Specialist", 10000, "Zubova I. V.")));
            vac0.put(new GregorianCalendar(2021, Calendar.MAY, 20).getTime(), "Masles");
            vac0.put(new GregorianCalendar(2022, Calendar.MAY, 20).getTime(), "Chikenpox");
            vac0.put(new GregorianCalendar(2022, Calendar.MAY, 20).getTime(), "Masles");
            vis0.put(new GregorianCalendar(2020, Calendar.MARCH, 20, 15, 00).getTime(), lvis);
            patients.add(new Patient(5546, "Fedor", "Ivanov", "Ivanovish", new GregorianCalendar(1989, Calendar.MAY, 31).getTime(), vis0, vac0));
        }


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(new File("patients.json"), patients);

        String result = objectMapper.writeValueAsString(patients);
        System.out.println(result);

        byte[] jsonData = Files.readAllBytes(Paths.get("patients.json"));
        ObjectMapper mapperBack = new ObjectMapper();
        Patient[] resultBack = mapperBack.readValue(jsonData, Patient[].class);
        for (Patient patient : resultBack)
            System.out.println(patient);


        System.out.println('\n');

// Вывести пациента с максимальным количеством вакцинаций
        var quer = patients.stream().max(Comparator.comparingInt(Patient::NumVacs)).get();
        System.out.println(quer.toString());

// Вывести список пациентов, у которых день рождения в текущем месяце
        Calendar calendarNext = new GregorianCalendar();
        var PBDayInThisMonth = patients.stream()
                .filter(c -> c.getBirthday().getMonth() == calendarNext.getTime().getMonth())
                .collect(Collectors.toList());
        System.out.println(PBDayInThisMonth.toString());

// Вывести список пациентов с имененм Анна
        var PWithName = patients.stream()
                .filter(c -> c.getName().equals("Anna"))
                .collect(Collectors.toList());
        System.out.println(PWithName.toString());
 // Вывести список пациентов, у которых день рождения меньше, чем через две недели от текущей даты
        Date curDate = new Date();
        var PBDayInTwoWeeks = patients.stream()
                .filter(c -> check(curDate, c.getBirthday()))
                .collect(Collectors.toList());
        System.out.println(PBDayInTwoWeeks.toString());


    }

    static public Boolean check(Date d1, Date d2) {
        d1.setYear(d2.getYear());
        long diffInMillies = d2.getTime() - d1.getTime();

        return ((int) (diffInMillies / (24 * 60 * 60 * 1000)) <= 14);
    }
}



