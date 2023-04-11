public class Proceso {
    private String id;
    private String cedula;
    private int tiempo;

    public Proceso(String id, String cedula, int tiempo) {
        this.id = id;
        this.cedula = cedula;
        this.tiempo = tiempo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Id : " + id + "\n" + "Cédula: " + cedula + "\n" + "Tiempo: " + tiempo + "\n";
    }
}
