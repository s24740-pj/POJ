public class Usmiech extends Buzka implements Skalowalny {

    public Usmiech() {
        super(')');
    }

    @Override
    public void draw(int i) {
        if (i > 1)
            System.out.print(":-"+")".repeat(i));
        System.out.println();
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

}
