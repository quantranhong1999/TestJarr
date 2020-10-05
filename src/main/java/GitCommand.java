import SubCommand.GitAddCommand;
import SubCommand.GitCommitCommand;
import SubCommand.GitGet;
import picocli.CommandLine;

@CommandLine.Command(
        subcommands = {
                GitAddCommand.class,
                GitCommitCommand.class,
                GitGet.class
        }
)
public class GitCommand implements Runnable {
    @Override
    public void run() {
        System.out.println("The popular git command");
    }

    public static void main(String[] args) {
        CommandLine.run(new GitCommand(), args);

    }
}
