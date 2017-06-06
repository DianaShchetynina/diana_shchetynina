
public class Client {
    public Client(Integer id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    private int id;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    private String greeting;
    private String fullName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
