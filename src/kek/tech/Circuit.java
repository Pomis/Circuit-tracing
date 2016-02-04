package kek.tech;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by romanismagilov on 04.02.16.
 */
public class Circuit {
    Detail[] details;

    {
        details = new Detail[]{new Detail(), new Detail()};
    }

    public void initiate() {

        readCoordinates();
        readConnections();
        System.out.print("Микропроцессор                             Память\n"+details[0]);
    }



    private void readCoordinates() {

        String csvFile = "coordinates.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] separatedLine = line.split(cvsSplitBy);
                details[Integer.parseInt(separatedLine[1]) - 1].pins.add(
                        new Pin(
                                Float.parseFloat(separatedLine[2].replace(',', '.')), //X
                                Float.parseFloat(separatedLine[3].replace(',', '.')), //Y
                                Byte.parseByte(separatedLine[0])                      //Number
                        )
                );
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Запарсено!");

    }

    private void readConnections(){
        String csvFile = "connect.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] separatedLine = line.split(cvsSplitBy);
                int start = Integer.parseInt(separatedLine[0]);     // Индекс пина на первой детали
                int finish = Integer.parseInt(separatedLine[1]);    // Индекс пина на второй детали

                // Заполняем поле "connection" у каждого пина
                details[0].pins.get(start-1).connection = details[1].pins.get(finish-1);
                details[1].pins.get(finish-1).connection = details[1].pins.get(start-1);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Запарсено!");
    }
}
