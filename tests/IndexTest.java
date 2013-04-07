import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: jf
 * Date: 04.04.13
 * Time: 23:19
 * To change this template use File | Settings | File Templates.
 */
public class IndexTest {

    @Test
    public void testAdd(){
        Index i = new Index();
        assertEquals(5, i.add(2, 3));
    }

}
