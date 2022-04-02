package TrojkatRownoramienny;

public class TrojkatRownoramienny {

    private double podstawa;
    private double ramie;

    public TrojkatRownoramienny(double podstawa, double ramie) {
        this.podstawa = podstawa;
        this.ramie = ramie;
//        System.out.println(podstawa);
    }

    public TrojkatRownoramienny() {

    }

    public double wysokosc(){
        return Math.sqrt((this.ramie * this.ramie) - (this.podstawa * this.podstawa / 4.));
    }
    public double wysokosc(double mnoz){
        return (Math.sqrt((this.ramie * this.ramie) - (this.podstawa * this.podstawa / 4.)) * mnoz);
    }

}
