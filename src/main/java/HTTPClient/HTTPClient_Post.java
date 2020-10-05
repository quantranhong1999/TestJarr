package HTTPClient;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HTTPClient_Post {
    public static final String POST_URL = "http://203.171.20.94:8012/api/AccessControl/GetUserInfor";

    public static void postFormWithJson() throws Exception {
            // Tao http client
            CloseableHttpClient httpClient = HttpClients.createDefault();
            StringEntity jsonEntity = new StringEntity("{\"deviceId\":\"8a0fc66a61a959f6\", \"qrCodeId\": \"a652d57094b7590b0dea115b156c07098abdea87\", \"qrCodeValue\":\"P22498244182551944\"}",
                    ContentType.APPLICATION_JSON);
            HttpPost httpPost = new HttpPost(POST_URL);
            httpPost.setEntity(jsonEntity);
            try {
                // Thuc thi gui Post request va lay ve response body de xu ly
                CloseableHttpResponse response = httpClient.execute(httpPost);
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode != 200)
                {
                    throw new RuntimeException("Failed with HTTP error code : " + statusCode);
                }
                // Xu ly va boc tach data
                String apiOutput = EntityUtils.toString(response.getEntity());
                JsonParser jp = new JsonParser(); //Su dung gson
                JsonObject jsonObject = jp.parse(apiOutput).getAsJsonObject();
                System.out.println("code: " + jsonObject.get("code"));
                System.out.println("direction: " + jsonObject.get("direction"));
                System.out.println("userId: " +jsonObject.get("userId"));
            } catch (Exception e){
                System.out.println("Get Data Failed!");
                e.printStackTrace();
            }
            finally {
                // Dong connection
                httpClient.close();
            }
        }
    public static void main(String[] args) throws Exception {
        postFormWithJson();
    }
}
