package br.com.buscacep.principal;

import br.com.buscacep.modulos.Endereco;
import br.com.buscacep.modulos.EnderecoViaCep;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Gson gson = new Gson();

        System.out.print("Digite um CEP: ");
        String cep = scan.nextLine();

        String link = "https://viacep.com.br/ws/" + cep + "/json/";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(link))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();


            EnderecoViaCep meuEndereco = gson.fromJson(json, EnderecoViaCep.class);

            Endereco endereco = new Endereco(meuEndereco);

            System.out.println(endereco.getCep() + " " + endereco.getLogradouro());

            FileWriter file = new FileWriter("endereco.json");
            file.write(gson.toJson(endereco));
            file.close();


        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("Fim");



    }
}