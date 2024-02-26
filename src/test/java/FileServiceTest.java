import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileServiceTest {
    private final FileService fileService = new FileService();
    private final SequenceFinder finder = new SequenceFinder();
    private final List<String> list =
            Arrays.asList("1", "2", "5", "4", "3", "9", "8", "7", "6", "10", "11", "12", "13", "14");

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
    void findMaxValue() {
        long expected = 14L;
        long result = fileService.findMaxValue(list);
        assertEquals(expected, result);
    }

    @Test
    void findMinValue() {
        long expected = 1L;
        long result = fileService.findMinValue(list);
        assertEquals(expected, result);
    }

    @Test
    void findMedian() {
        long expected = 7L;
        long result = fileService.findMedian(list);
        assertEquals(expected, result);
    }

    @Test
    void findAverage() {
        long expected = 7L;
        long result = fileService.findAverage(list);
        assertEquals(expected, result);
    }
}