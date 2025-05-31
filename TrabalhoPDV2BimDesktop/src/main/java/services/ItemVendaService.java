package services;

import com.google.gson.Gson;
import dto.ItemVendaDTO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ItemVendaService {

    private static final String URLWEBSERVICE = "http://localhost:8080/api/vendas";
    private static final int SUCESSO = 200;

    public static ItemVendaDTO buscarPorId(Long id) throws Exception {
        try {
            URL url = new URL(URLWEBSERVICE + id);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != SUCESSO) {
                throw new RuntimeException("Erro ao buscar item");
            }

            BufferedReader resposta = new BufferedReader
                              (new InputStreamReader(conexao.getInputStream()));
            String json = ClienteService.converteJsonString(resposta);

            return new Gson().fromJson(json, ItemVendaDTO.class);

        } catch (Exception ex) {
            throw new Exception("Erro ao buscar item: " + ex.getMessage());
        }
    }
    
    public static boolean salvar(ItemVendaDTO item) throws Exception {
        
        Gson gson = new Gson();
        String json = gson.toJson(item);

        URL url = new URL(URLWEBSERVICE);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setRequestMethod("POST");
        conexao.setRequestProperty("Content-Type", "application/json");
        conexao.setDoOutput(true);

        try (OutputStream os = conexao.getOutputStream()) {
            
            os.write(json.getBytes());
            os.flush();
            
        }

        int responseCode = conexao.getResponseCode();
        return responseCode == 201 || responseCode == 200;
    }
    
}
