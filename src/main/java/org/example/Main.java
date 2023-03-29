package org.example;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //conexao HTTP  e buscar top 100 filmes
        String url = "https://imdb-top-100-movies.p.rapidapi.com/";
        var cliente = HttpClient.newHttpClient();
        URI uri = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder(uri).header("X-RapidAPI-Key", "b333e64e34mshb492ced04127023p18eda9jsndd31bfc696cb")
                .header("X-RapidAPI-Host", "imdb-top-100-movies.p.rapidapi.com").GET().build();
        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getFactory();
        JsonParser parser = factory.createParser(body);
        JsonNode filmes = mapper.readTree(parser);
        //exibir
        filmes.forEach(filme -> {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("rating"));
            System.out.println(filme.get("image"));
        });
        StickerGenerator generator = new StickerGenerator();
        generator.generate();
    }
}