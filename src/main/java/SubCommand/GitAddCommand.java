package SubCommand;

import picocli.CommandLine;

import java.nio.file.Path;
import java.util.List;

@CommandLine.Command(
        name = "add"
)

public class GitAddCommand implements Runnable {

    @CommandLine.Option(
            names = {"-A", "--all"}
    )
    private boolean allFiles;

    @CommandLine.Parameters
    private List<Path> files;

    @Override
    public void run() {
        if (allFiles) {
            System.out.println("Adding all files");
        } else {
            System.out.println("Adding some files");
        }
        if (files != null) {
            files.forEach(path -> System.out.println("Adding "+path));
        }
    }
}
