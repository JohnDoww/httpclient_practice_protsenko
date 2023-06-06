import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.Test;
import utils.Links;
import utils.Pet_Info;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import static javax.swing.UIManager.get;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class StoreTest {

    Links links = new Links();
    Gson gson= new Gson();
    Pet_Info petInfo = new Pet_Info();

    @Test
    public void checkInventar() throws IOException {
        HttpGet httpGet = new HttpGet(links.GET_INVENTORY());
        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute(httpGet);
        assertEquals(SC_OK, httpResponse.getStatusLine().getStatusCode());
    }

    @Test
    public void createPet() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(links.GET_CREATE_PET());

        HttpEntity stringEntity = new StringEntity(petInfo.inputJson,ContentType.APPLICATION_JSON);
        httpPost.setEntity(stringEntity);

        CloseableHttpResponse response = HttpClientBuilder.create().build().execute(httpPost);

        assertEquals(SC_OK, response.getStatusLine().getStatusCode());
    }
/*
 - create pet - input data for all fields (use randomiser to fill in), remember ID, check respose must be 200
- find created pet - use id, check respose must be 200
 - delete pet - check respose must be 200
- find created pet - use id, check respose must be 404
 */
}
