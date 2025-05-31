
package services;

import com.google.gson.Gson;
import dto.ClienteDTO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClienteService {
 
    private static String URLWEBSERVICE = "http://localhost:8080/api/clientes";
    private static int SUCESSO = 200;
    
    public static ClienteDTO buscaId(Long id) throws Exception {
        
        try {
        URL url = new URL("http://localhost:8080/api/clientes/" + id);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setRequestMethod("GET");
        conexao.setRequestProperty("Content-Type", "application/json");

        if (conexao.getResponseCode() != 200) {
            throw new RuntimeException("Cliente não encontrado: " + conexao.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        StringBuilder json = new StringBuilder();
        String linha;

        while ((linha = br.readLine()) != null) {
            json.append(linha);
        }

        return new Gson().fromJson(json.toString(), ClienteDTO.class);

    } catch (Exception e) {
        throw new Exception("Erro ao buscar cliente: " + e.getMessage());
    }
}
    
    public static String converteJsonString(BufferedReader buffereadReader) throws IOException{
        String resposta = "";
        String jsonString = "";
        
        while((resposta = buffereadReader.readLine()) != null){
            jsonString += resposta;
        }
        
        return jsonString;
        
    }
    
    
    
}
