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
            str+=("pin " + pin.number + "; X: " + pin.x + "; Y:" + pin.y + "\n");
        });
        return str;
    }


}
