package sample;

import javafx.geometry.Pos;

import java.io.Serializable;

public class obstacle_copy extends  Position implements Serializable {


        String type;
        double speed;
        int number;
        boolean is_dotted;
        double y ;
        double translate;



}
   class rewards_copy extends Position  implements Serializable{
                boolean used;
                double speed;
                double y;

        }


class switch_copy  implements  Serializable{
        boolean used;
        double speed;
        double y;

}
