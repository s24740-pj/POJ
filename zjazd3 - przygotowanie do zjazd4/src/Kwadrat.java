public class Kwadrat extends Prostokat implements MoznaWyznaczycPrzekatna {
    final int x;
    final int y;

    public Kwadrat(int x, int y) {
        super(x,y);
        this.x = x;
        this.y = y;
    }
    public Kwadrat(int x) {
        super(x,x);
        this.x = x;
        this.y = x;
    }

    @Override
    public String toString() {
        return "kwadrat";
    }
}
