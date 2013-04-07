
public class Snapshot {

    public String getCommentar() {
        return commentar;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public int getId() {
        return id;
    }

    private int id;
    private int timestamp;
    private String commentar;


    public Snapshot(int id, int timestamp, String commentar) {
        this.id = id;
        this.timestamp = timestamp;
        this.commentar = commentar;
    }
}
