import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentManagerImpl implements StudentManager {
    private GenericList<Student> students = new GenericList<>();

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void removeStudent(int id) throws StudentNotFoundException {
        Student student = findStudent(id);
        students.remove(student);
    }

    @Override
    public Student findStudent(int id) throws StudentNotFoundException {
        return students.getAll().stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    }

    @Override
    public List<Student> getAllStudents() {
        return students.getAll();
    }

    public List<Student> getStudentsAboveAge(int age) {
        return students.getAll().stream()
                .filter(student -> student.getAge() > age)
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsSortedByName() {
        return students.getAll().stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsSortedByNameDesc() {
        return students.getAll().stream()
                .sorted(Comparator.comparing(Student::getName).reversed())
                .collect(Collectors.toList());
    }
}