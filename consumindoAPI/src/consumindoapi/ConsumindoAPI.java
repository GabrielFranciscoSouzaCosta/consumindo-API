package consumindoapi;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
public class ConsumindoAPI {

    public static void main(String[] args) throws IOException  {
        HttpClient client;
        client = HttpClientBuilder.create().build();
        HttpGet request =  new HttpGet("http://www.mocky.io/v2/598b16291100004705515ec5");
        HttpResponse response = client.execute(request);
                
        BufferedReader rd =  new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
        String line;
        StringBuilder result =  new StringBuilder();
        
        while((line = rd.readLine()) != null ){
            result.append(line);    
        }
        
        Gson json = new Gson();
        Type listType = new TypeToken<List<Cliente>>() {}.getType();
        ArrayList<Cliente> clientes = json.fromJson(result.toString(), listType);
        
        clientes.forEach((cli) -> {
            System.out.println(cli.nome);
        });
   
    }
    
}
