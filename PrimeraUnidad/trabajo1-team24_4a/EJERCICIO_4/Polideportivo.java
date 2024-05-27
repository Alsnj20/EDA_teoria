public class Polideportivo extends Edificio implements InstalacionDeportiva {
    private String tipoDeDeporte;
    private String nombre;

    public Polideportivo(double superficie, String tipoDeDeporte, String nombre, Ubicacion ubicacion) {
        super(superficie, ubicacion);
        this.tipoDeDeporte = tipoDeDeporte;
        this.nombre = nombre;
    }

    @Override
    public double getSuperficie() {
        return superficie;
    }

    @Override
    public String getTipoDeDeporte() {
        return tipoDeDeporte;
    }

    public String getNombre() {
        return nombre;
    }
}
