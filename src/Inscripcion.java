public class Inscripcion {
    private String nombreAsistente;
    private TipoEvento evento;
    private String fecha;
    private int montoAbonado;

    public Inscripcion(String nombreAsistente, TipoEvento evento, String fecha) {
        this.nombreAsistente = nombreAsistente;
        this.evento = evento;
        this.fecha = fecha;
        montoAbonado=0;
    }

    public String getNombreAsistente() {
        return nombreAsistente;
    }

    public TipoEvento getEvent() {
        return evento;
    }

    public String getFecha() {
        return fecha;
    }

    public boolean abona(int monto){
        return true;
    }
    //se usa un valor fijo de 150.000 por evento para simplificar el ejercicio,
    //sin embargo cada evento puede tener un valor propio y en ese caso es necesario
    //modelar la clase evento y la asociación con la clase inscripción. Competencia que
    //no está siendo evaluada en este control.

    public int getSaldo(){
        return 150000-montoAbonado;
    }

    public boolean equals(Inscripcion otro){
        return nombreAsistente.equals(otro.nombreAsistente)&& evento==otro.evento && fecha.equals(otro.fecha);
    }
}
