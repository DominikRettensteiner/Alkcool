package alkcool.sma.alkcool;

import java.util.ArrayList;
import java.util.Collections;

public class AmountList {
    public static ArrayList<Amount> list= new ArrayList<Amount>();

    public AmountList(){
        if(list.isEmpty()){
            list.add(new Amount("A Hoibe", 500));
            list.add(new Amount("A Seidl", 330));
            list.add(new Amount("A Viertl", 250));
            list.add(new Amount("A Achterl", 125));
            list.add(new Amount("A Dopplts", 40));
            list.add(new Amount("A Stamperl", 20));
        }
    }

    public static void sort(){
        Collections.sort(list);
    }

    public static ArrayList<String> getStringList(){
        ArrayList<String> newList = new ArrayList<String>();
        for(Amount a : list){
            newList.add(a.AmountName+"("+a.milliliter+"ml)");
        }
        return newList;
    }
}
