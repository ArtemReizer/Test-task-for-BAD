import java.time.LocalTime;
import java.util.List;
import java.util.LongSummaryStatistics;

public class Main {
    public static void main(String[] args) {
        System.out.println(LocalTime.now());
        String fileName = "10m.txt";
        FileService fileService = new FileService();
        SequenceFinder sequenceFinder = new SequenceFinder();
        List<String> list = fileService.readFileToList(fileName);
        LongSummaryStatistics statistics = fileService.getStatistics(list);
        long maxValue = statistics.getMax();
        long minValue = statistics.getMin();
        long average = (long) statistics.getAverage();
        long median = fileService.findMedian(list);
        List<String> ascendingSequence = fileService.findAscendingSequence(list, sequenceFinder);
        List<String> descendingSequence = fileService.findDescendingSequence(list, sequenceFinder);
        System.out.printf("""
                                        
                        Info:
                        maxValue - %d
                        minValue - %d
                        median - %d
                        average - %d
                        longest ascending sequence - %s
                        longest descending sequence - %s
                                        
                        %n""", maxValue, minValue,median,average,
                ascendingSequence.toString(), descendingSequence.toString());
        System.out.println(LocalTime.now());
    }
}
