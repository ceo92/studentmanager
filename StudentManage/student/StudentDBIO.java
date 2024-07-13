package student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lib.ObjectDBIO;

public abstract class StudentDBIO extends ObjectDBIO implements StudentIO {

  public ArrayList<Student> getStudentList() {
    ArrayList<Student>  stulist = new ArrayList<Student>();
    String query = "SELECT *  FROM STUDENT";
    ResultSet rs = null;

    try {
      rs = super.execute(query, rs);
      while (rs.next()) {
        int sno = rs.getInt(1);
        String name = rs.getString(2);
        int korea = rs.getInt(3);
        int english = rs.getInt(4);
        int math = rs.getInt(5);
        int sci = rs.getInt(6);
        int total = rs.getInt("total");
        double average = rs.getDouble("average");
        String grade = rs.getString("grade");
        Student student = new Student(sno,name,korea,english,math,sci,total,average,grade);
        stulist.add(student);
      }
      rs.close();
      super.close();
    }catch (SQLException e){
      System.err.println(e.getMessage());
    }
  return stulist;
  }

  public ArrayList<Student> searchStudent(String sno) {
    ArrayList<Student> searchStudnet = new ArrayList<Student>();
    return searchStudnet;
  }


  public ArrayList<Student> getSortedStudent() {
      ArrayList<Student> sortStudnet = new ArrayList<Student>();

      return sortStudnet;
  }

  public boolean insertStudent(Student student){

    String name = student.getName();
    int kor = student.getRecord()[0];
    int eng = student.getRecord()[1];
    int math = student.getRecord()[2];
    int sci = student.getRecord()[3];
    int total = student.getTotal();
    double avg = student.getAverage();
    String grade = student.getGrade();

    String query = "INSERT INTO student VALUES ('" +
                     name + "', '" +
                       kor + "', '" +
                          eng + "', '" +
                             math + "', '" +
                                sci + "', '" +
                                  total + "', '" +
                                     avg + "', '" +
                                         grade + "')";
    super.execute(query);
    return true;
  }
}
