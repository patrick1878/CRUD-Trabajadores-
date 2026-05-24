import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String[]> estudiantes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n===== CRUD ESTUDIANTES =====");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Listar estudiantes");
            System.out.println("3. Actualizar estudiante");
            System.out.println("4. Eliminar estudiante");
            System.out.println("0. Salir");
            System.out.print("Elije una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: agregar(); break;
                case 2: listar(); break;
                case 3: actualizar(); break;
                case 4: eliminar(); break;
                case 0: System.out.println("Hasta luego!"); break;
                default: System.out.println("Opcion invalida");
            }
        }while (opcion != 0);
    }

    static void agregar() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Edad: ");
        String edad = sc.nextLine();
        System.out.print("Nota: ");
        String nota = sc.nextLine();
        estudiantes.add(new String[]{nombre, edad, nota});
        System.out.println("Estudiantes agregado!");
    }

    static void listar() {
         if(estudiantes.isEmpty()) {
             System.out.println("No hay estudiantes.");
             return;
         }
         System.out.println("\nNº  Nombre      Edad  Nota");
         System.out.println("----------------------");
         for (int i = 0; i < estudiantes.size(); i++) {
             String[] e = estudiantes.get(i);
             System.out.println((i+1) + ".  " + e[0] + "  |  " + e[1] + "  |  " + e[2]);
         }
    }

    static void actualizar ()  {
        listar();
        if (estudiantes.isEmpty()) return;
        System.out.print("Numero a actualizar: ");
        int pos = sc.nextInt() - 1;
        sc.nextLine();
        if (pos < 0 || pos >= estudiantes.size()) {
            System.out.println("Numero invalido.");
            return;
        }
        System.out.print("Nuevo Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Nueva Edad: ");
        String edad = sc.nextLine();
        System.out.print("Nueva Nota: ");
        String nota  = sc.nextLine();
        estudiantes.set(pos, new String[]{nombre, edad, nota});
        System.out.println("Estudiantes actualizado!");
    }

    static void eliminar() {
        listar();
        if (estudiantes.isEmpty()) return;
        System.out.print("Numero a eliminar: ");
        int pos =sc.nextInt() -1;
        sc.nextLine();
        if (pos < 0 || pos >= estudiantes.size()) {
            System.out.println("Numero invalido.");
            return;
        }
        System.out.println("Eliminado: " + estudiantes.get(pos)[0]);
        estudiantes.remove(pos);
    }
}
git add .
git commit -m "Subiendo CRUD java"
git push origin main