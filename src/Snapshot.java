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


    public Snapshot(int id, Date date, String comment) {
        this.id = id;
        this.timestamp = date.getTime();
        this.comment = comment;
    }
}
