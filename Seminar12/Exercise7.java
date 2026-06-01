import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise7 {

    private static final Pattern WORD_PATTERN = Pattern.compile("\\p{L}+");

    public static void main(String[] args) throws IOException {
        Path input = Path.of("input.txt");
        Path output = Path.of("output.txt");

        TreeSet<String> words = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        Matcher matcher = WORD_PATTERN.matcher(Files.readString(input, StandardCharsets.UTF_8));
        while (matcher.find()) {
            words.add(matcher.group().toLowerCase());
        }

        Files.write(output, words, StandardCharsets.UTF_8);
        System.out.println("U shkruan " + words.size() + " fjale ne " + output.toAbsolutePath());
    }
}

