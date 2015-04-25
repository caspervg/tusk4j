package net.caspervg.tusk4j.bean.input;

public class UserInput {
    private String username;
    private String password;
    private String email;

    public UserInput(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public UserInput(String username, String password) {
        this(username, password, null);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
