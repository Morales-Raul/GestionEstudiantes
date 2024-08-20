import java.util.List;

public class Main {
    public static void main(String[] args) {

        StudentManager studentManager = new StudentManagerImpl();

        studentManager.addStudent(new Student(1, "Raúl", 21));
        studentManager.addStudent(new Student(2, "Alisson", 30));
        studentManager.addStudent(new Student(3, "Keisy", 22));
        studentManager.addStudent(new Student(4, "Michael", 25));
        studentManager.addStudent(new Student(5, "Sheili", 22));


        System.out.println("Lista de estudiantes orden ascendente:");
        List<Student> allStudents = studentManager.getAllStudents();
        allStudents.forEach(System.out::println);

        try {
            Student student = studentManager.findStudent(3);
            System.out.println("\nEstudiante encontrado: " + student);
        } catch (StudentNotFoundException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("\nEstudiantes mayores a 21 años:");
        allStudents.stream()
                .filter(s -> s.getAge() > 21)
                .forEach(System.out::println);


        System.out.println("\nEstudiantes ordenados alfabeticamente:");
        allStudents.stream()
                .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
                .forEach(System.out::println);

        studentManager.removeStudent(2);
        System.out.println("\nLista de estudiantes después de eliminar al estudiante con ID 2:");
        studentManager.getAllStudents().forEach(System.out::println);
    }
}