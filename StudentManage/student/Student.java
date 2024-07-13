package student;

public class Student {

  private int sno;
  private String name;
  private int[] record = new int[4];  //학생의 각 과목 점수 저장
  private int total; //과목 총합
  private double average; //과목 평균
  private String grade;
  private int rank = -1;

  static enum GRADE {A, B, C, D, F};



  public Student(String name, int korea, int english, int math, int sci) {
    // 인스턴스 멤버의 초기화 
    this.name = name;
    this.record[0] = korea;
    this.record[1] = english;
    this.record[2] = math;
    this.record[3] = sci;    //for 이용하여 초기화 진행 리팩토링 해주세요! 

    this.makeScores();
  }

  public Student(int sno, String name, int korea, int english, int math, int sci, int total, double average,String grade) {
    this.sno = sno;
    this.name = name;
    this.record[0] = korea;
    this.record[1] = english;
    this.record[2] = math;
    this.record[3] = sci;
    this.total = total;
    this.average = average;
    this.grade = grade;
  }


  private void makeScores() { //총합 및 평균 계산
    for (int score : record) {
      this.total += score;
    }
    this.average = (double) this.total / record.length;
            this.makeGrade();
  }

  private void makeGrade() { //각 점수에 따라 grade 값 초기화
    //enum GRADE 를 기준으로 학점 매기기
    int base = (int) average / 10;
    switch (base) {
      case 10, 9 -> grade = GRADE.A.toString();
      case 8 -> grade = GRADE.B.toString();
      case 7 -> grade = GRADE.C.toString();
      case 6 -> grade = GRADE.D.toString();
      default -> grade = GRADE.F.toString();  //thanks 현아
    }
  }
//getter
  public int getSno() {
    return sno;
  }

  public String getName() {
    return name;
  }

  public int[] getRecord() {
    return record;
  }

  public int getTotal() {
    return total;
  }

  public int getRank() {
    return rank;
  }

  public String getGrade() {
    return grade;
  }

  public double getAverage() {
    return average;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }
}
