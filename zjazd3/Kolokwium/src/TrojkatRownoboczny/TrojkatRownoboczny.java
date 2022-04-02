package TrojkatRownoboczny;


import TrojkatRownoramienny.TrojkatRownoramienny;

public class TrojkatRownoboczny extends TrojkatRownoramienny {

    private double podstawa;

    public TrojkatRownoboczny(double podstawa, double podstawa2) {
        super();
        this.podstawa = podstawa;
    }

    public TrojkatRownoboczny(double podstawa) {
        this.podstawa = podstawa;
    }


    public double wysokosc(){
        return (int) ((this.podstawa * Math.sqrt(3) / 2.));
    }

    public double wysokosc(double mnoznik){
        return (int) ((this.podstawa * Math.sqrt(3) / 2.) * mnoznik);
    }

}
