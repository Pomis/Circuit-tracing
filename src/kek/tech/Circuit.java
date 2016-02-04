package kek.tech;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

/**
 * Created by romanismagilov on 04.02.16.
 */
public class Circuit {
    Detail[] details;

    {
        details = new Detail[]{new Detail(), new Detail()};
    }

    public void initiate() {

        readCSV();
        System.out.print("Первая деталька\n"+details[0]);
        System.out.print("\nВторая деталька\n"+details[1]);
    }



    private void readCSV() {

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
}
