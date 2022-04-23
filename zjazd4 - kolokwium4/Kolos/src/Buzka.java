import java.util.Objects;

public class Buzka implements PrzedstawiaEmocje, Rysowalny {

    public char eq;

    public Buzka(char c) {
        this.eq = c;
    }

    @Override
    public void draw() {
        System.out.println(":-" + this.eq);
    }

    @Override
    public String toString() {
        return ":-"+this.eq;
    }

    @Override
    public boolean czySieUsmiecha() {
        if(this.eq == ')'){
            return true;
        }
        return false;
    }

    @Override
    public void przestanSieUsmiechac() {
        this.eq = '(';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buzka buzka = (Buzka) o;
        return eq == buzka.eq;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eq);
    }
}
