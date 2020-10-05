package SubCommand;

import HTTPClient.HTTPClient_Post;
import picocli.CommandLine;

@CommandLine.Command(name = "get")
public class GitGet implements Runnable{

    private HTTPClient_Post httpClientPost;

    @Override
    public void run() {
        try {
            httpClientPost.postFormWithJson();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
