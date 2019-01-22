package alkcool.sma.alkcool;

import java.util.ArrayList;
import java.util.Collections;

public class PlayerList {
    public static ArrayList<Player> list;

    public PlayerList(){
        list = new ArrayList<Player>();
    }

    public void sort(){
        Collections.sort(list);
    }

    public static ArrayList<String> getNameList(){
        ArrayList<String> newList = new ArrayList<String>();
        for(Player p : list){
            newList.add(p.playerName);
        }
        return newList;
    }

    public boolean contains(String name){
        for(Player p : list){
            if(p.playerName.equals(name)){
                return true;
            }
        }
        return false;
    }
}
