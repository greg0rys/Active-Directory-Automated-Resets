package org.shenefelt;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserManager
{
    private final static ArrayList<User> users = new ArrayList<>();

    public UserManager()
    {
        readInUsers();
        resetPasswords();
        writeOutUsers();

    }


    private static void readInUsers()
    {
        String csvFile = "C:/scripts/passwords.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            List<String[]> records = reader.readAll();

            for (int i = 1; i < records.size(); i++)
            {
                User temp = new User();
                String[] row = records.get(i);

                System.out.println(temp);
                users.add(new User(row[0].trim(),
                                   row[1].trim(),
                                   Integer.parseInt(row[2].trim())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void writeOutUsers()
    {
        String csvFile = "C:/scripts/passwords.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
            // Write header
            writer.writeNext(new String[]{"username", "password", "employeeID"});

            // Write each user's data to CSV for PS read
            for (User u : users) {
                System.out.println(u);
                String[] row = {
                        u.getUsername(),
                        u.getPassword(),
                        String.valueOf(u.getAltID())
                };
                writer.writeNext(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * Run automated reset using template patter search to determine string
     */
    private void resetPasswords()
    {
        if(users.isEmpty())
            return;

        String agencyP = "Ag3ncy";
        String surveyorP = "Surv3yor";
        Random rand = new Random();

        for(User u : users)
        {
            int digits = rand.nextInt(1,9999);
            u.setPassword((u.getUsername().toUpperCase().indexOf('A') == - 1) ? surveyorP + digits : agencyP + digits);
        }

    }


}
