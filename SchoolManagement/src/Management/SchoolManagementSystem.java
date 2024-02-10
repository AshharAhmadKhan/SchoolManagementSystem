package Management;
import java.util.*;
class Student
{
private String id;
private String n;
private int a;
private String g;
public Student(String id,String n,int a,String g)
{
this.id = id;
this.n = n;
this.a = a;
this.g = g;
}
public String getId() 
{
return id;
}
public String getName()
{
return n;
}
public int getAge() 
{
return a;
}
public String getGrade()
{
return g;
}
public String toString()
{
return "Student ID: "+id+", Name: "+n+", Age: "+a+", Grade: "+g;
}
}
class Course 
{
private String cId;
private String cN;
private List<Student> students;
public Course(String cId, String cN)
{
this.cId = cId;
this.cN = cN;
this.students = new ArrayList<>();
}
public String getCourseId() 
{
return cId;
}
public String getCourseName()
{
return cN;
}
public List<Student> getStudents()
{
return students;
}
public void enrollStudent(Student student) 
{
students.add(student);
}
public String toString()
{
return "Course ID: "+cId+", Course Name: "+cN+", Enrolled Students: "+students.size();
}
}
public class SchoolManagementSystem
{
private Map<String, Student> students;
private Map<String, Course> courses;
public SchoolManagementSystem()
{
students = new HashMap<>();
courses = new HashMap<>();
}
public void addStudent(String id,String n,int a,String g)
{
Student student = new Student(id,n,a,g);
students.put(id,student);
System.out.println("Student added successfully!");
}
public void addCourse(String cId,String cN)
{
Course course = new Course(cId,cN);
courses.put(cId,course);
System.out.println("Course added successfully!");
}
public void enrollStudent(String sId, String cId)
{
Student student = students.get(sId);
Course course = courses.get(cId);
if (student != null && course != null) {
course.enrollStudent(student);
System.out.println("Student enrolled in the course successfully!");
} else {
System.out.println("Student or course not found.");
}
}
public void displayStudents()
{
System.out.println("\nStudents:");
for (Student student : students.values()) {
System.out.println(student);
}
}
public void displayCourses() 
{
System.out.println("\nCourses:");
for (Course course : courses.values()) {
System.out.println(course);
}
}
public static void main(String[] args)
{
SchoolManagementSystem sms = new SchoolManagementSystem();
Scanner ob = new Scanner(System.in);
System.out.println("\nSchool Management System Menu:");
System.out.println("1. Add Student");
System.out.println("2. Add Course");
System.out.println("3. Enroll Student");
System.out.println("4. Display Students");
System.out.println("5. Display Courses");
System.out.println("6. Exit");
System.out.print("Enter your choice: ");
int ch = ob.nextInt();
ob.nextLine(); // Consume newline
switch (ch) 
{
case 1:
System.out.print("Enter student ID: ");
String id = ob.nextLine();
System.out.print("Enter student name: ");
String n = ob.nextLine();
System.out.print("Enter student age: ");
int a = ob.nextInt();
ob.nextLine(); // Consume newline
System.out.print("Enter student grade: ");
String g = ob.nextLine();
sms.addStudent(id,n,a,g);
break;
case 2:
System.out.print("Enter course ID: ");
String cId = ob.nextLine();
System.out.print("Enter course name: ");
String cN = ob.nextLine();
sms.addCourse(cId,cN);
break;
case 3:
System.out.print("Enter student ID: ");
String sId = ob.nextLine();
System.out.print("Enter course ID: ");
String cIdE = ob.nextLine();
sms.enrollStudent(sId,cIdE);
break;
case 4:
sms.displayStudents();
break;
case 5:
sms.displayCourses();
break;
case 6:
System.out.println("Exiting...");
ob.close();
System.exit(0);
default:
System.out.println("Invalid choice. Please try again.");
}
}
}
