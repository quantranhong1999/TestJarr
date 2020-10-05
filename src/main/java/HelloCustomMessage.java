import java.util.List;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@CommandLine.Command
public class HelloCustomMessage implements Runnable {

    @Parameters
    private List<String> messages;

    @Option(names = { "-p", "--prefix" })
    private String prefix;

    public void run() {
        if (messages == null || messages.size() < 1) {
            System.out.printf("%sHello, Picocli%n", prefix == null ? "" : prefix);
        } else {
            for (String msg : messages) {
                System.out.printf("%s%s%n", prefix == null ? "" : prefix, msg);
            }
        }
    }

    public static void main(String[] args) {
        CommandLine.run(new HelloCustomMessage(), args);
    }

}