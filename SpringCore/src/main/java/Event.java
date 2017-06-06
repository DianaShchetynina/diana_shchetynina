import java.text.DateFormat;
import java.util.Date;

public class Event {
    private final DateFormat dateFormat;
    private int id = (int) Math.random();
    private String msg;
    private Date date;


    public void setMsg(String msg) {
        this.msg = msg;
    }


    public Event(Date date, DateFormat df) {
        this.date = date;
        dateFormat = df;
    }

    public int getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + dateFormat.format(date) +
                '}';
    }
}
