package alkcool.sma.alkcool;

import java.util.Random;

public class Player implements Comparable{
    public String playerName;
    public int points;

    public Player(String name){
        playerName = name;
        points = 0;
    }

    @Override
    public int compareTo(Object o) {
        Player p = (Player)o;
        return p.points - this.points;
    }
}
