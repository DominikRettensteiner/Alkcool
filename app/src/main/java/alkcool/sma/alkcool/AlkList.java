package alkcool.sma.alkcool;

import java.util.ArrayList;
import java.util.Collections;

public class AlkList {
    public static ArrayList<Alk> list= new ArrayList<Alk>();

    public AlkList(){
        if(list.isEmpty()){
            list.add(new Alk("Bier", 5.0));
            list.add(new Alk("Wein", 12.0));
            list.add(new Alk("Spritzer", 6.0));
            list.add(new Alk("Most", 7));
            list.add(new Alk("gespritzter Most", 3.5));
            list.add(new Alk("Jägermeister", 35));
            list.add(new Alk("Wodka", 37.5));
            list.add(new Alk("Rum", 38));
            list.add(new Alk("Rum", 80));
            list.add(new Alk("Tequila", 38));
        }
    }

    public static void sort(){
        Collections.sort(list);
    }

    public boolean contains(String name, double percent){
        for(Alk a : list){
            if(a.alkName.equals(name)){
                if(a.percent == percent){
                    return true;
                }
            }
        }
        return false;
    }

    public static ArrayList<String> getStringList(){
        ArrayList<String> newList = new ArrayList<String>();
        for(Alk a : list){
            newList.add(a.alkName+"("+a.percent+"%)");
        }
        return newList;
    }

    public static String getString(int index){
        return list.get(index).alkName + "("+list.get(index).percent+"%)";
    }
}
