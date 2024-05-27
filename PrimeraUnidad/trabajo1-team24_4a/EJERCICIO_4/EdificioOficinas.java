
public class EdificioOficinas extends Edificio {
    private int numOficinas;

    public EdificioOficinas(double superficie, int numOficinas, Ubicacion ubicacion) {
        super(superficie, ubicacion);
        this.numOficinas = numOficinas;
    }

    public int getNumOficinas() {
        return numOficinas;
    }

    @Override
    public double getSuperficie() {
        return superficie;
    }
}
