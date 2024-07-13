package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentManager extends StudentDBIO{

  //싱글톤으로 객체를 생성한다.
  private static final StudentManager instance = new StudentManager();

  private StudentManager() {
  }

  public static StudentManager getInstance() {
    return instance;
  }

  public boolean insertStudent(Student student) {//학생 정보 입력기능 (학생 객체 생성(vo) 후 학생 정보 저장)
    String name = student.getName();
    double average = student.getAverage();

    String query = "";
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;


    try{
      con.setAutoCommit(false);

      pstmt = con.prepareStatement();
      rs = pstmt.executeQuery(query);

      con.commit();
    }catch (SQLException e1){
      try{
        con.rollback();
      }catch (SQLException e2){

      }
    }
    finally {

    }



    return false;
  }


  public ArrayList<Student> getSortedStudent() {  //학생 석차 처리 기능
    return new ArrayList<>();
  }

  //제너릭<> 을 이용하여 저장소에 Student 객체 만 저장하도록 (타입 제한)
  public ArrayList<Student> getStudentList() { //2번 메뉴 : 학생 전체 보기 기능

    return new ArrayList<>();
  }

  public ArrayList<Student> searchStudent(String sno) {
    //3번 메뉴: 학생의 학번으로 검색하여 정보 조회 기능
    return new ArrayList<>();
  }


}
