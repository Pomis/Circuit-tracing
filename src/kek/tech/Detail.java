package kek.tech;

import java.util.ArrayList;

/**
 * Created by romanismagilov on 04.02.16.
 */
public class Detail {
    ArrayList<Pin> pins;
    String str = "";

    {
        pins = new ArrayList<>();
    }

    @Override
    public String toString() {

        pins.forEach((pin) -> {
            String proc = "pin#" + pin.number + "; X: " + pin.x + "; Y:" + pin.y+ ". ";
            String mem = "pin#" + pin.connection.number + "; X: " + pin.connection.x + "; Y:" + pin.connection.y +"\n";
            String connect = "o";
            // Не обращайте внимания, мне просто очень захотелось это сделать
            int kek = 40-proc.length();
            for (int i = 0; i<kek; i++){
                connect+="-";
            }
            connect+="o ";
            str+=proc+connect+mem;
        });
        return str;
    }


}
