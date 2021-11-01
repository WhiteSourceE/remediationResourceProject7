package utils;

public class UserData {
  private String userId;
  private String name;

  public UserData(String userId, String name) {
    this.userId = userId;
    this.name = name;
  }

  public UserData() {
  }

  public String getUserId() {
    return userId;
  }

  public String getName() {
    return name;
  }

  public UserData setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public UserData setName(String name) {
    this.name = name;
    return this;
  }

  public String getNormalizedUserId(String userId) {
    return "id_" + userId;
  }
}
