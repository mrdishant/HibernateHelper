public class Student {

    int rollno;
    String name;
    String cl;

    public Student(){

    }

    public Student(int rollno, String name, String cl) {
        this.rollno = rollno;
        this.name = name;
        this.cl = cl;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", cl='" + cl + '\'' +
                '}';
    }

}
