package sample;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Mangment implements Serializable {
    static int i=0;
    public static void save_game(Serializable data,String filename) throws Exception{
        try(ObjectOutputStream oo=new ObjectOutputStream(Files.newOutputStream(Paths.get(filename)))){
            oo.writeObject(data);
            i++;
            System.out.println("You have saved game:"+i);
        }

    }
    public static Object load_game(String filename) throws Exception{
        try(ObjectInputStream oo=new ObjectInputStream(Files.newInputStream(Paths.get(filename)))){

            return oo.readObject();

        }


    }
    public static void save_game_score(Serializable data) throws Exception{
        try(ObjectOutputStream oo=new ObjectOutputStream(Files.newOutputStream(Paths.get("highscore")))){
            oo.writeObject(data);
        }

    }
    public static Object load_game_score() throws Exception{
        try(ObjectInputStream oo=new ObjectInputStream(Files.newInputStream(Paths.get("highscore")))){
            return oo.readObject();

        }


    }
    public static void save_game_star(Serializable data) throws Exception{
        try(ObjectOutputStream oo=new ObjectOutputStream(Files.newOutputStream(Paths.get("star")))){
            oo.writeObject(data);
        }

    }
    public static Object load_game_star() throws Exception{
        try(ObjectInputStream oo=new ObjectInputStream(Files.newInputStream(Paths.get("star")))){
            return oo.readObject();

        }


    }

    public static void save_game_save(Serializable data) throws Exception{
        try(ObjectOutputStream oo=new ObjectOutputStream(Files.newOutputStream(Paths.get("savedd")))){
            oo.writeObject(data);
        }

    }
    public static Object load_game_save() throws Exception{
        try(ObjectInputStream oo=new ObjectInputStream(Files.newInputStream(Paths.get("savedd")))){
            return oo.readObject();

        }


    }


}
