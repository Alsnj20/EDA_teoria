
public class Ubicacion {
    private String calle;
    private String numero;
    private String distrito;
    private String departamento;

    public Ubicacion(String calle, String numero, String distrito, String departamento) {
        this.calle = calle;
        this.numero = numero;
        this.distrito = distrito;
        this.departamento = departamento;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCalle() {
        return calle;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }
}

