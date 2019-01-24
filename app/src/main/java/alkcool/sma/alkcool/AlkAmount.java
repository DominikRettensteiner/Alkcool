package alkcool.sma.alkcool;

public class AlkAmount {
    public Alk alk;
    public Amount amount;
    public int anzahl;

    public AlkAmount(Alk _alk, Amount _amount, int _anzahl) {
        alk = _alk;
        amount = _amount;
        anzahl = _anzahl;
    }

    public Alk getAlk() {
        return alk;
    }

    public void setAlk(Alk _alk) {
        alk = _alk;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount _amount) {
        amount = _amount;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int _anzahl) {
        anzahl = _anzahl;
    }
}
