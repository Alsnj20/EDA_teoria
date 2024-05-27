public abstract class Edificio {
    protected double superficie;
    protected Ubicacion ubicacion;

    public Edificio(double superficie, Ubicacion ubicacion) {
        this.superficie = superficie;
        this.ubicacion = ubicacion;
    }

    public abstract double getSuperficie();

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
}
