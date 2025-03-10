import java.io.*;

// Student class implementing Serializable
class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private double gpa;

    // Constructor
    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    // Display Student Details
    public void display() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("GPA: " + gpa);
    }
}

public class StudentFileSerialization {

    // Method to serialize a Student object and write raw bytes to a text file
    public static void serializeStudent(Student student, String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(student);
            System.out.println("Student object serialized successfully!");

        } catch (IOException e) {
            System.out.println("Error: IOException occurred - " + e.getMessage());
        }
    }

    // Method to read and print byte data from the file
    public static void printByteData(String filename) {
        try (FileInputStream fis = new FileInputStream(filename)) {
            System.out.println("\nByte data from the file:");
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print(data + " ");  // Printing byte values
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error: Unable to read file - " + e.getMessage());
        }
    }

    // Method to deserialize a Student object from the file
    public static Student deserializeStudent(String filename) {
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            return (Student) ois.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: IOException occurred - " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found - " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        String filename = "C:\\mini_projects\\my.txt";  // File to store serialized data

        // Creating a Student object
        Student student1 = new Student(101, "Alice Johnson", 3.8);

        // Serializing Student object to file
        serializeStudent(student1, filename);

        // Printing byte data from the file
        printByteData(filename);

        // Deserializing Student object from file
        Student deserializedStudent = deserializeStudent(filename);

        // Display deserialized Student details
        if (deserializedStudent != null) {
            System.out.println("\nDeserialized Student Details:");
            deserializedStudent.display();
        }
    }
}
