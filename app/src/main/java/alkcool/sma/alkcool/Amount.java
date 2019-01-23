package alkcool.sma.alkcool;

public class Amount implements Comparable{
    public String AmountName;
    public int milliliter;

    public Amount(String name, int ml){
        AmountName = name;
        milliliter = ml;
    }

    @Override
    public int compareTo(Object o) {
        Amount a = (Amount)o;
        return milliliter - a.milliliter;
    }
}
