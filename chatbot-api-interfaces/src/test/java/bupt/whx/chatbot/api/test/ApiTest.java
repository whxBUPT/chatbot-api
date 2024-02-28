package bupt.whx.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * ClassName:ApiTest
 * Package:bupt.whx.chatbot.api.test
 * Description:  单元测试
 *
 * @Author whx
 * @Create 2024/2/28 12:52
 * @Version 1.0
 */
public class ApiTest {

    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get=new HttpGet("https://api.zsxq.com/v2/topics/811185825524112/comments?sort=asc&count=30&with_sticky=true");

        get.addHeader("cookie","zsxq_access_token=75C7900F-9BFD-7B7C-3762-F33638E0E3A3_A8F740116C6D063A; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22585144584255254%22%2C%22first_id%22%3A%2218dd66e14dabc2-0c1c29dbe66f64-26001b51-2073600-18dd66e14db17ca%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThkZDY2ZTE0ZGFiYzItMGMxYzI5ZGJlNjZmNjQtMjYwMDFiNTEtMjA3MzYwMC0xOGRkNjZlMTRkYjE3Y2EiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI1ODUxNDQ1ODQyNTUyNTQifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22585144584255254%22%7D%2C%22%24device_id%22%3A%2218dd66e14dabc2-0c1c29dbe66f64-26001b51-2073600-18dd66e14db17ca%22%7D; abtest_env=product; zsxqsessionid=ef7f6185934f325ea69e6680f711dd3f");
        get.addHeader("Content-Type","application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post=new HttpPost("https://api.zsxq.com/v2/topics/811185825524112/comments");
        post.addHeader("cookie","zsxq_access_token=75C7900F-9BFD-7B7C-3762-F33638E0E3A3_A8F740116C6D063A; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22585144584255254%22%2C%22first_id%22%3A%2218dd66e14dabc2-0c1c29dbe66f64-26001b51-2073600-18dd66e14db17ca%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThkZDY2ZTE0ZGFiYzItMGMxYzI5ZGJlNjZmNjQtMjYwMDFiNTEtMjA3MzYwMC0xOGRkNjZlMTRkYjE3Y2EiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI1ODUxNDQ1ODQyNTUyNTQifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22585144584255254%22%7D%2C%22%24device_id%22%3A%2218dd66e14dabc2-0c1c29dbe66f64-26001b51-2073600-18dd66e14db17ca%22%7D; abtest_env=product; zsxqsessionid=ef7f6185934f325ea69e6680f711dd3f");
        post.addHeader("Content-Type","application/json;charset=utf8");

        String paramJson="{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"回答777\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";

        StringEntity entity = new StringEntity(paramJson, ContentType.create("text/json","UTF-8"));
        post.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(post);

        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
