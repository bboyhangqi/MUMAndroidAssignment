package app.mumandroidassignment.lesson4.byjava;

/**
 * Created by CodingHome on 4/5/18.
 */

public class User {

    public User(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    private String firstname;
    private String lastname;
    private String email;
    private String password;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if(obj instanceof User){
            User user = (User)obj;
            if(email.equals(user.email)&&password.equals(user.password))
                return true;
        }
        return false;
    }
}
