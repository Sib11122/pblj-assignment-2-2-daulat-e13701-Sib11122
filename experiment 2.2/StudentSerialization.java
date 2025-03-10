// Create a Java program to serialize and deserialize a Student object. The program should:
// Serialize a Student object (containing id, name, and GPA) and save it to a file.
// Deserialize the object from the file and display the student details.
// Handle FileNotFoundException, IOException, and ClassNotFoundException using exception handling.
//  Create a Java program to serialize and deserialize a Student object. The program should:
// Serialize a Student object (containing id, name, and GPA) and save it to a file.
// Deserialize the object from the file and display the student details.
// Handle FileNotFoundException, IOException, and ClassNotFoundException using exception handling.
// Create a Java program to serialize and deserialize a Student object. The program should:
// Serialize a Student object (containing id, name, and GPA) and save it to a file.
// Deserialize the object from the file and display the student details.
// Handle FileNotFoundException, IOException, and ClassNotFoundException using exception handling.

 
 import java.io.*;

// Student class must implement Serializable
class Student implements Serializable {
    private static final long serialVersionUID = 1L; // Ensures compatibility across versions

    private int id;
    private String name;
    private double gpa;

    // Constructor
    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    // Display method
    public void display() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("GPA: " + gpa);
    }
}

public class StudentSerialization {

    // Method to serialize the Student object
    public static void serializeStudent(Student student, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(student);
            System.out.println("Student object serialized successfully!");
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
        }
    }

    // Method to deserialize the Student object
    public static Student deserializeStudent(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Student) ois.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        } catch (IOException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Class not found.");
        }
        return null; // Return null if deserialization fails
    }

    public static void main(String[] args) {
        String filename = "studentData.ser";

        // Creating a Student object
        Student student = new Student(101, "Sehajdeep", 3.9);

        // Serialization
        serializeStudent(student, filename);

        // Deserialization
        Student deserializedStudent = deserializeStudent(filename);

        if (deserializedStudent != null) {
            System.out.println("\nDeserialized Student Details:");
            deserializedStudent.display();
        } else {
            System.out.println("Deserialization failed.");
}
}
}
