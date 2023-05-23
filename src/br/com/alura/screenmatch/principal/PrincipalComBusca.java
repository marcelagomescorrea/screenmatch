package br.com.alura.screenmatch.principal;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.screenmatch.excecao.ErroDeConversaoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

        while(!busca.equalsIgnoreCase("sair")) {

            System.out.println("\nDigite um filme para busca ou sair para finalizar: ");
            busca = leitura.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }
            String query = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=6bc7b3ab";            

            try {

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(query))
                    .build();

                HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();

                TituloOmdb tituloOmdb = gson.fromJson(json, TituloOmdb.class);            
                Titulo titulo = new Titulo(tituloOmdb);
                System.out.println(titulo);
                titulos.add(titulo);                

            } catch (NumberFormatException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (ErroDeConversaoException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }        
        leitura.close();
        System.out.println(titulos);

        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();

        System.out.println("Fim");
    }
}

