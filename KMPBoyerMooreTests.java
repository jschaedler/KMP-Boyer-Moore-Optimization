import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * This is a basic set of unit tests for displaying the enhanced efficiency of the optimized
 * algorithms. Both tests display that the new algorithm has increased efficiency over Boyer-Moore
 * and KMP by showing that the optimized algorithm performs less comparisons than each algorithms worst
 * case.
 *
 *
 */
public class KMPBoyerMooreTests {

    private static final int TIMEOUT = 200;



    private List<Integer> emptyList;

    private CharacterComparator comparator;



    @Test(timeout = TIMEOUT)
    public void testKMPWorstCase() {
        /*
            pattern: aaa
            text: aabaabaabaab
            indices: -
            KMP total comparison: 18
            Optimized total comparisons: 6


         */
        String worstPattern = "aaa";
        String kmpWorstText = "aabaabaabaab";
        assertEquals(emptyList,
                Algorithm.KMPBoyerMoore(worstPattern, kmpWorstText, comparator));
        assertTrue("Did not use the comparator.",
                comparator.getComparisonCount() != 0);
        assertEquals("Comparison count was " + comparator.getComparisonCount()
                + ". Should be 6.", 6, comparator.getComparisonCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreWorstCase() {
        /*
            pattern: baa
            text: aaaaaaaaaaaa
            indices: -
            BoyerMoore total comparison: 27
            Optimized total comparisons: 22


         */
        String bmWorstPattern = "baa";
        String bmWorstText = "aaaaaaaaaaaa";
        assertEquals(emptyList,
                Algorithm.KMPBoyerMoore(bmWorstPattern, bmWorstText, comparator));
        assertTrue("Did not use the comparator.",
                comparator.getComparisonCount() != 0);
        assertEquals("Comparison count was " + comparator.getComparisonCount()
                + ". Should be 22.", 22, comparator.getComparisonCount());
    }

}
