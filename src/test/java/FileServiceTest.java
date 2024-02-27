import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.LongSummaryStatistics;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileServiceTest {
    private final FileService fileService = new FileService();
    private final SequenceFinder finder = new SequenceFinder();
    private final List<String> list =
            Arrays.asList("1", "2", "5", "4", "3", "9", "8", "7", "6", "10", "11", "12", "13", "14");
//    private List<String> list = Arrays.asList("1", "2", "3","4");
    @Test
    void findAscendingSequence() {
        List<String> expected = Arrays.asList("6", "10", "11", "12", "13", "14");
        List<String> result = fileService.findAscendingSequence(list, finder);
        assertEquals(expected, result);
    }

    @Test
    void findDescendingSequence() {
        List<String> expected = Arrays.asList("9", "8", "7", "6");
        List<String> result = fileService.findDescendingSequence(list, finder);
        assertEquals(expected, result);
    }

    @Test
    void getStatistics() {
        long expectedMax = 14L;
        long expectedMin = 1L;
        double expectedAve = 7.5;
        LongSummaryStatistics statistics = fileService.getStatistics(list);
        assertEquals(expectedMax, statistics.getMax());
        assertEquals(expectedMin, statistics.getMin());
        assertEquals(expectedAve, statistics.getAverage());
    }

    @Test
    void findMedian() {
        double expected = 7.5;
        double median = fileService.findMedian(list);
        assertEquals(expected, median);
    }
}