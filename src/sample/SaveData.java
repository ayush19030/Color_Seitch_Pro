package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class SaveData implements Serializable {
    private static final long serialVersionUID= 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public ArrayList<obstacle_copy> getObstacles() {
        return obstacles;
    }

    public void setObstacles(ArrayList<obstacle_copy> obstacles) {
        this.obstacles = obstacles;
    }

    public ArrayList<switch_copy> getSwitchColors() {
        return switchColors;
    }

    public void setSwitchColors(ArrayList<switch_copy> switchColors) {
        this.switchColors = switchColors;
    }

    public ArrayList<rewards_copy> getRewards() {
        return rewards;
    }

    public void setRewards(ArrayList<rewards_copy> rewards) {
        this.rewards = rewards;
    }

    public double getCor() {
        return cor;
    }

    public void setCor(double cor) {
        this.cor = cor;
    }

    public int getSrt() {
        return srt;
    }

    public void setSrt(int srt) {
        this.srt = srt;
    }

    private Ball ball;
    private  ArrayList<obstacle_copy> obstacles;
    private  ArrayList<switch_copy> switchColors;
    private ArrayList<rewards_copy> rewards;
    private    double cor;
private int srt;

    public void feed_data(Ball ball,ArrayList<obstacle_copy> obstacles, ArrayList<switch_copy> switchColor,ArrayList<rewards_copy> reward, double uy, int ty){
        this.ball=ball;
        this.switchColors=switchColor;
        this.rewards=reward;
        cor=uy;
        this.obstacles=obstacles;
        srt=ty;
    }
//    public void Seedata(Obstacle[] ob)
//    {
//        System.out.println("Inside see data");
//        for(int i=0;i<3;i++)
//        {
//            System.out.println("X: "+ob[i].getXcord()+" Y: "+ob[i].getYcord());
//        }
//    }
}




