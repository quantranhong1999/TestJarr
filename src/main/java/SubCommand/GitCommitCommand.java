package SubCommand;

import picocli.CommandLine;
@CommandLine.Command (
        name = "commit"
)
public class GitCommitCommand implements Runnable{

    @CommandLine.Option(names = {"-m", "--message"}, split = " ")
    private String messages[];

    @Override
    public void run() {
        System.out.println("Commititing smth");
        if (messages != null) {
            for (String message:
                 messages) {
                System.out.println(message);
            }
        }
    }
}
