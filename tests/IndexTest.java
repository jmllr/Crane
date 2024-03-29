import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: jf
 * Date: 04.04.13
 * Time: 23:19
 * To change this template use File | Settings | File Templates.
 */
public class IndexTest {

    @Test
    public void testAddSnapshot(){
        Index i = new Index("tests/index.xml");
        Snapshot s = new Snapshot(new Date(), "tra-la-la");

        int id = i.addSnapshot(s);

        assertTrue(id >= 0);

        int id2 = i.addSnapshot(s);

        assertTrue(id2 == id + 1);

        

    }
    
    public void testGetSnapshot() {
        Index i = new Index("tests/index.xml");
        Snapshot s2 = new Snapshot(new Date(), "schönes Wetter heute");

        int id3 = i.addSnapshot(s2);
        Snapshot snapshot = i.getSnapshot(id3);
        int id4 = snapshot.getId();
        assertEquals(id3, id4);


    }

}
