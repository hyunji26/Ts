package model.domain;

public class Student {
   
    private String studentId;
    private String password;

    
   public Student(String studentId,String password) {
      super();
      this.studentId = studentId;
      this.password = password;
   }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    //비밀번호
    public boolean matchPassword(String password) {
      if (password == null) {
         return false;
      }
      return this.password.equals(password);
   }
   
   public boolean isSameUser(String userid) {
        return this.studentId.equals(userid);
    }
}