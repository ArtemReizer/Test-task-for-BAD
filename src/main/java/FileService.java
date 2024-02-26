import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.LongSummaryStatistics;

public class FileService {

    public List<String> readFileToList(String fileName) {
        File file = new File(fileName);
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }

    public List<String> findAscendingSequence(List<String> list, SequenceFinder finder) {
        return finder.findLongestAscendingSequence(list);
    }

    public List<String> findDescendingSequence(List<String> list, SequenceFinder finder) {
        return finder.findLongestDescendingSequence(list);
    }

    public LongSummaryStatistics getStatistics(List<String> list) {
        return list.stream()
                .mapToLong(Long::parseLong)
                .parallel()
                .summaryStatistics();
    }

    public long findMedian(List<String> list) {
        long size = list.size();
        return (long) list.stream()
                .parallel()
                .mapToLong(Long::parseLong)
                .sorted()
                .skip((long) (Math.ceil((double) size / 2)) - 1)
                .limit(2 - size % 2)
                .average()
                .orElseThrow(RuntimeException::new);
    }
}
