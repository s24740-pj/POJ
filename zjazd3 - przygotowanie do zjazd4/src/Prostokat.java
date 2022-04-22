import java.util.Objects;

public class Prostokat implements MoznaWyznaczycWysokosc, MoznaWyznaczycWielokrotnoscPrzekatnej {


    final int x;
    final int y;

    public Prostokat(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double przekatna() {
        return Math.sqrt((bok() * bok()) + (2. * bok() * podstawa() * Math.cos(katNachylenia()))
                + (podstawa() * podstawa()));
    }

    @Override
    public double wielokrotnoscPrzekatnej(double v) {
        return przekatna()*v;
    }

    public int wielokrotnoscPrzekatnej(int v) {
        return (int)przekatna()*v;
    }


    @Override
    public double wysokosc() {
        return bok();
    }

    @Override
    public double podstawa() {
        return x;
    }

    @Override
    public double katNachylenia() {
        return Math.PI / 2;
    }

    @Override
    public double bok() {
        return y;
    }

    @Override
    public String toString() {
        return "prostokat";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prostokat)) return false;
        Prostokat prostokat = (Prostokat) o;
        return x == prostokat.x && y == prostokat.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
