public class User {


    private String email;
    private String password;

    public User(String email, String pass) {
        this.email = email;
        this.password = pass;
    }

    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }
}
