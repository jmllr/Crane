import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: jf
 * Date: 07.04.13
 * Time: 13:33
 * To change this template use File | Settings | File Templates.
 */
public class SnapshotTest {

    @Test
    public void testCreation(){
        Snapshot s = new Snapshot(5, new Date(),  "test comment");
        assertEquals(5, s.getId());
        assertEquals("test comment", s.getComment());
        assertTrue(new Date().getTime() - s.getTimestamp() < 2);
    }

}
