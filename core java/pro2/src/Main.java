public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        // Insert a student
        Student student = new Student(1, "Alice", 20);
        dao.insertStudent(student);

        // Update the same student
        student.setName("Alice Johnson");
        student.setAge(21);
        dao.updateStudent(student);
    }
}
