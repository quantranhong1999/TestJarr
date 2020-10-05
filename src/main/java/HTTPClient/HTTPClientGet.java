package HTTPClient;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class HTTPClientGet {
    public static void main(String[] args) throws ClientProtocolException, IOException {
        // code
    }
    public static void getSomething(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url); //"http://127.0.0.1"
        CloseableHttpClient client = HttpClients.createDefault();
        HttpResponse httpResponse = client.execute(httpGet);
        System.out.println("Protocol: " + httpResponse.getProtocolVersion());
        System.out.println("Status:" + httpResponse.getStatusLine().toString());
        System.out.println("Content type:" + httpResponse.getEntity().getContentType());
        System.out.println("Locale:" + httpResponse.getLocale());
        System.out.println("Headers:");
        for(Header header : httpResponse.getAllHeaders()) {
            System.out.println("          " + header.getName()+": " + header.getValue());
        }
        System.out.println("Content:");
        String content = IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8");
        System.out.println(content);
        client.close();
    }
}
