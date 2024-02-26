import java.util.ArrayList;
import java.util.List;

public class SequenceFinder {
    public List<String> findLongestAscendingSequence(List<String> numbers) {
        List<String> currentSequence = new ArrayList<>();
        List<String> longestSequence = new ArrayList<>();

        for (String number : numbers) {
            if (currentSequence.isEmpty() || Integer.parseInt(number) > Integer.parseInt(currentSequence
                    .get(currentSequence.size() - 1))) {
                currentSequence.add(number);
                if (currentSequence.size() > longestSequence.size()) {
                    longestSequence.clear();
                    longestSequence.addAll(currentSequence);
                }
            } else {
                currentSequence.clear();
                currentSequence.add(number);
            }
        }
        return longestSequence;
    }

    public List<String> findLongestDescendingSequence(List<String> numbers) {
        List<String> currentSequence = new ArrayList<>();
        List<String> longestSequence = new ArrayList<>();

        for (String number : numbers) {
            if (currentSequence.isEmpty() || Integer.parseInt(number) < Integer.parseInt(currentSequence
                    .get(currentSequence.size() - 1))) {
                currentSequence.add(number);
                if (currentSequence.size() > longestSequence.size()) {
                    longestSequence.clear();
                    longestSequence.addAll(currentSequence);
                }
            } else {
                currentSequence.clear();
                currentSequence.add(number);
            }
        }
        return longestSequence;
    }
}
