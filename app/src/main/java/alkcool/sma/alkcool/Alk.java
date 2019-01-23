package alkcool.sma.alkcool;

public class Alk implements Comparable{
    public String alkName;
    public double percent;

    public Alk(String name, double p){
        alkName = name;
        percent = p;
    }

    @Override
    public int compareTo(Object o) {
        Alk a = (Alk)o;
        return alkName.compareTo(a.alkName);
    }
}
