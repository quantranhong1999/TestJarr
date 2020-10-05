import HTTPClient.HTTPClientGet;
import HTTPClient.HTTPClient_Post;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import picocli.CommandLine;

import java.io.IOException;

@CommandLine.Command(
        name = "hello",
        description = "Say hello"
)
public class Hello implements Runnable{

    public static void main(String[] args) {
        CommandLine.run(new Hello(), args);
    }

    @Override
    public void run() {
        try {
            HTTPClientGet.getSomething("http://127.0.0.1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
