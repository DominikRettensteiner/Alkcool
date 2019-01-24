package alkcool.sma.alkcool;

import java.util.ArrayList;
import java.util.Collections;

public class MealList {
    public static ArrayList<Meal> list= new ArrayList<Meal>();

    public MealList(){
        if(list.isEmpty()){
            list.add(new Meal("Schnitzel", -2));
            list.add(new Meal("Jägerschnitzel", -2));
            list.add(new Meal("Cordon Bleu", -3));
            list.add(new Meal("Schweinsbraten", -2));
            list.add(new Meal("Fleischknödel", -3));
            list.add(new Meal("Backhendlsalat", -2));
            list.add(new Meal("Vitalsalat", -1));
        }
    }

    public static void sort(){
        Collections.sort(list);
    }

    public boolean contains(String name, double points){
        for(Meal m : list){
            if(m.mealName.equals(name)){
                if(m.points == points){
                    return true;
                }
            }
        }
        return false;
    }

    public static ArrayList<String> getStringList(){
        ArrayList<String> newList = new ArrayList<String>();
        for(Meal m : list){
            newList.add(m.mealName+"("+m.points+" Punkte)");
        }
        return newList;
    }

    public static String getString(int index){
        return list.get(index).mealName + "("+list.get(index).points+" Punkte)";
    }
}
