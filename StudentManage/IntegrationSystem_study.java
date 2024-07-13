import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import student.Student;
import student.StudentManager;
import student.StudentOutput;

public class IntegrationSystem_study {

  static StudentManager studentManager = StudentManager.getInstance();

  //	 콘솔 입력 버퍼 생성
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    IntegrationSystem_study Instance = new IntegrationSystem_study();
    String buffer = null;

    while (true) {
      System.out.println("====== [ 메뉴를 선택 하세요 ] ======");
      System.out.println("1. 학생 관리 시스템");
      System.out.println("2. 시스템 종료");
      System.out.println("--------------------------------");

      int nSel = System.in.read() - 48;
      System.in.skip(System.in.available());

      switch (nSel) {

        case 1:
          while (true) {
            System.out.println("======= [ 학생 관리 시스템 ] =======");
            System.out.println("1. 학생 추가");
            System.out.println("2. 학생 전체 보기");
            System.out.println("3. 학생 검색");
            System.out.println("4. 학생 석차순으로 보기");
            System.out.println("5. 이전으로");
            System.out.println("--------------------------------");
            nSel = System.in.read() - 48;
            System.in.skip(System.in.available());
            switch (nSel) {
              case 1:
                Instance.insertStudent(); //학생 추가
                continue;
              case 2:
                Instance.getStudentList(); //학생 전체 보기
                continue;
              case 3:
                Instance.searchStudent(); // 학생 검색
                continue;
              case 4:
                Instance.sortedStudent(); // 학생 석차순으로 보기
                continue;
              case 5: //이전으로
                break;
              default:
                continue;
            }
            break;
          }
          continue;
        case 2:
          System.out.println("시스템을 종료합니다..");
          break;
        default:
          continue;
      }
      break;
    }
  }

  // 학생 삽입
  public void insertStudent() throws IOException {
    //학생 정보 입력기능 (학생 객체 생성(vo) 후 학생 정보 저장)
    System.out.println("학생 데이터를 입력하세요!! : (번호, 이름,국어,영어,수학,과학");
    System.out.println("입력 종료 : exit ");
    System.out.println("========================================================");

    String buffer = null;
    String num = null;
    String name = null;
    Student student = null;

    //라인입력 받아서 exit 가 아닐때까지 반복

      while (!(buffer = br.readLine()).equals("exit")) {
        // ssg  90 90 90 90
        //토큰 구분자를 등록해서 학생 객체 생성
        try {
        StringTokenizer st = new StringTokenizer(buffer, ",");

        if ((num = st.nextToken()) != null) {
          name = st.nextToken().trim();
          //성적을 토큰 단위로 읽어내서 저장
          int[] record = new int[4];
          record[0] = Integer.parseInt(st.nextToken().trim());
          record[1] = Integer.parseInt(st.nextToken().trim());
          record[2] = Integer.parseInt(st.nextToken().trim());
          record[3] = Integer.parseInt(st.nextToken().trim());

          //학생 객체(VO)에 각 데이터를 옮겨 답니다.
          student = new Student(name, record[0], record[1], record[2], record[3]);
          studentManager.insertStudent(student);
        }
      }
      catch(NoSuchElementException e){
        System.out.println("입력 형식에 알맞지 않은 입력입니다. 다시 입력해 주세요!");
        continue;
      } catch(NumberFormatException e){
        System.out.println("성적 입력은 숫자로만 입력이 가능합니다. 다시 입력해 주세요");
        continue;
      }
      System.out.println("학생 정보 입력이 완료되었습니다.");
    }
  }


  public void sortedStudent() {  //학생 석차 처리 기능

  }

  public void getStudentList() { //2번 메뉴 : 학생 전체 보기 기능

  }

  public void searchStudent() { //3번 메뉴: 학생의 학번으로 검색하여 정보 조회 기능

  }


}
