import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(LocalTime.now());
        String fileName = "10m.txt";
        FileService fileService = new FileService();
        SequenceFinder sequenceFinder = new SequenceFinder();
        List<String> list = fileService.readFileToList(fileName);
        long maxValue = fileService.findMaxValue(list);
        long minValue = fileService.findMinValue(list);
        long median = fileService.findMedian(list);
        long average = fileService.findAverage(list);
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
