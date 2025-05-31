
package services;

import com.google.gson.Gson;
import dto.ProdutoDTO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ProdutoService {
    
    private static String URLWEBSERVICE = "http://localhost:8080/api/produto";
    private static int SUCESSO = 200;
    
    public static ProdutoDTO buscaId(Long id) throws Exception {
        
        try {
            
        URL url = new URL("http://localhost:8080/api/produto/" + id);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setRequestMethod("GET");
        conexao.setRequestProperty("Content-Type", "application/json");

        if (conexao.getResponseCode() != 200) {
            throw new RuntimeException("Produto não encontrado: " + conexao.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        StringBuilder json = new StringBuilder();
        String linha;

        while ((linha = br.readLine()) != null) {
            json.append(linha);
        }

        return new Gson().fromJson(json.toString(), ProdutoDTO.class);

    } catch (Exception e) {
        
        throw new Exception("Erro ao buscar produto: " + e.getMessage());
        
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
