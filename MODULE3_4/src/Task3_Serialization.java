import java.io.*;

// --------- Student Class ---------
class Student implements Serializable {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Student: " + id + ", " + name + ", Age: " + age;
    }
}

// --------- Course Class ---------
class Course implements Serializable {
    private String courseCode;
    private String courseName;
    private String instructor;

    public Course(String code, String name, String instructor) {
        this.courseCode = code;
        this.courseName = name;
        this.instructor = instructor;
    }

    public String toString() {
        return "Course: " + courseCode + " - " + courseName + " by " + instructor;
    }
}

// --------- Enrollment Class ---------
class Enrollment implements Serializable {
    private Student student;
    private Course course;
    private String enrollmentDate;

    public Enrollment(Student student, Course course, String date) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = date;
    }

    public String toString() {
        return student + "\n" + course + "\nEnrolled on: " + enrollmentDate;
    }
}

// --------- Main Class ---------
public class Task3_Serialization {
    public static void main(String[] args) {
        Student student = new Student(101, "Alice", 21);
        Course course = new Course("CS101", "Intro to Programming", "Dr. Smith");
        Enrollment enrollment = new Enrollment(student, course, "2025-09-06");

        // Serialize to file
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("enrollments.ser"))) {
            out.writeObject(enrollment);
            System.out.println("Enrollment serialized to enrollments.ser");
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }

        // Deserialize from file
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("enrollments.ser"))) {
            Enrollment loaded = (Enrollment) in.readObject();
            System.out.println("\nDeserialized Enrollment:");
            System.out.println(loaded);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
    }
}



