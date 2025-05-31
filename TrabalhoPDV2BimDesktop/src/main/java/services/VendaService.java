
package services;

import com.google.gson.Gson;
import dto.VendaDTO;
import dto.VendaRequestDTO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class VendaService {
    
    private static String URLWEBSERVICE = "http://localhost:8080/api/vendas";
    private static int SUCESSO = 200;
    
    public static boolean realizarVenda(VendaDTO venda) throws Exception{
        
        try{
            URL url = new URL(URLWEBSERVICE);
            HttpURLConnection conexao = (HttpURLConnection)url.openConnection();
            
            conexao.setRequestMethod("POST");
            conexao.setRequestProperty("Content-Type", "application/json");
            conexao.setDoOutput(true);
            
            Gson gson = new Gson(); 
            String json = gson.toJson(venda);
            
            try(OutputStream os = conexao.getOutputStream()){
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            
            int status = conexao.getResponseCode();
            return status == SUCESSO || status == 201;
            
        }catch (Exception ex){
            throw new Exception("Erro ao retornar venda! "  + ex);
        }
        
    }
    
    public static void enviarVendaParaAPI(VendaRequestDTO venda) throws Exception {
        
        URL url = new URL("http://localhost:8080/api/vendas");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        String json = new Gson().toJson(venda);

        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes());
        os.flush();
        os.close();

        int responseCode = conn.getResponseCode();
        if (responseCode != 200 && responseCode != 201) {
            throw new Exception("Erro ao enviar venda para API. Código: " + responseCode);
        }

        conn.disconnect();
    }
    
}
