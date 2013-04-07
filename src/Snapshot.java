import java.util.Date;

public class Snapshot {

    public String getComment() {
        return comment;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getId() {
        return id;
    }

    private int id;
    private long timestamp;
    private String comment;


    public Snapshot(Date date, String comment) {
        this.timestamp = date.getTime();
        this.comment = comment;
    }

    public Snapshot(int id, Date date, String comment) {
        this(date, comment);
        this.id = id;
    }
}
