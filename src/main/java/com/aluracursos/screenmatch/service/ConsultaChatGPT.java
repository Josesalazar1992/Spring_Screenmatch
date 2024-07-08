package com.aluracursos.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {

    public static String obtenerTraduccion(String texto){
        OpenAiService service = new OpenAiService("TU-API-KEY");

        CompletionRequest requesicion = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduce a espanol el siguiente texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var respuesta = service.createCompletion(requesicion);
        return respuesta.getChoices().get(0).getText();
    }

}
