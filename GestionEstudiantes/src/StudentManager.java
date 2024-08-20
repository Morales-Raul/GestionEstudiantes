import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public interface StudentManager {
    void addStudent(Student student);
    void removeStudent(int id);
    Student findStudent(int id) throws StudentNotFoundException;
    List<Student> getAllStudents();
}