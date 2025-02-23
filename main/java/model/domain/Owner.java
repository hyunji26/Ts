package model.domain;

public class Owner {
    private String name;
    private String password;
    private String ownerId;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    public boolean matchPassword(String password) {
      if (password == null) {
         return false;
      }
      return this.password.equals(password);
   }
   public Owner(String name, String password, String ownerId) {
      super();
      this.name = name;
      this.password = password;
      this.ownerId = ownerId;
   }
    

}