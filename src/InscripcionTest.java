import java.util.ArrayList;
import java.util.Scanner;

public class InscripcionTest {
    public static void main(String[] args) {
        ArrayList<Inscripcion> inscripciones=new ArrayList<>();
        Scanner sc=new Scanner(System.in);

        int op;
        do {
            System.out.println("MENU DE OPCIONES");
            System.out.println("1. Inscribir");
            System.out.println("2. Abonar");
            System.out.println("3. Listar inscritos");
            System.out.println("4. Salir");
            System.out.println("");
            System.out.println("Ingrese su opción: ");
            op=sc.nextInt();
            String nombre, fecha;
            int evento, monto;
            Inscripcion inscripcion;
            switch (op){
                case 1:
                    System.out.println("Ingrese los datos para la inscripción");
                    inscripcion = leerInscripcion(sc);
                    inscripciones.add(inscripcion);
                    break;
                case 2:
                    System.out.println("Ingrese los datos para el abono");
                    inscripcion= leerInscripcion(sc);
                    for (Inscripcion inscrip : inscripciones) {
                        if(inscrip.equals(inscripcion)){
                            System.out.println("Ingrese monto del abono:");
                            monto=sc.nextInt();
                            if(inscrip.abona(monto)){
                                System.out.println("Abono realizado exitosamente");
                            }else{
                                System.out.println("Error: El monto a abonar sobrepasa el saldo pendiente");
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("LISTADO DE INSCRIPCIONES");
                    System.out.printf("%-16s %-12s %12s %10s %n", "Nombre asistente", "Tipo evento", "Fecha evento", "Saldo ($)");
                    for (Inscripcion ins : inscripciones) {
                        System.out.printf("%-16s %-12s %12s %,10d %n",ins.getNombreAsistente(), ins.getEvent(), ins.getFecha(), ins.getSaldo());
                    }
                    break;
                case 4:
                    System.out.println("Gracias por usar el sistema. Adios");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }while(op!=4);
    }

    private static Inscripcion leerInscripcion(Scanner sc) {
        TipoEvento[] eventos={TipoEvento.CHARLA, TipoEvento.SEMINARIO, TipoEvento.CONGRESO};
        int evento;
        String fecha;
        Inscripcion inscripcion;
        String nombre;
        System.out.println("Nombre asistente: ");
        nombre= sc.next();
        System.out.println("tipo de evento[1)charla, 2)seminario, 3)congreso] : ");
        evento= sc.nextInt();
        System.out.println("fecha (dd-mm-dd): ");
        fecha= sc.next();
        inscripcion=new Inscripcion(nombre, eventos[evento-1], fecha);
        return inscripcion;
    }
}
