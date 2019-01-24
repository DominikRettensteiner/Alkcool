package alkcool.sma.alkcool;

public class Meal implements Comparable{
    public String mealName;
    public double points;

    public Meal(String name, double p){
        mealName = name;
        points = p;
    }

    @Override
    public int compareTo(Object o) {
        Meal a = (Meal)o;
        return mealName.compareTo(a.mealName);
    }
}
