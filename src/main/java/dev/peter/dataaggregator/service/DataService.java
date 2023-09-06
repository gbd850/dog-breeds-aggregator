package dev.peter.dataaggregator.service;

import dev.peter.dataaggregator.dto.DataResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.List;

@Service
public class DataService {
    public List<DataResponse> fetchData(/*List<String> filters*/) {
        //TODO fetch data from api
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://dog-breeds2.p.rapidapi.com/dog_breeds"))
//                .header("X-RapidAPI-Key", "49ff0941bbmsha963dcd0964c181p10a44ajsn508b93f28735")
//                .header("X-RapidAPI-Host", "dog-breeds2.p.rapidapi.com")
//                .method("GET", HttpRequest.BodyPublishers.noBody())
//                .build();
        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        headers.add("X-RapidAPI-Key", "49ff0941bbmsha963dcd0964c181p10a44ajsn508b93f28735");
        headers.add("X-RapidAPI-Host", "dog-breeds2.p.rapidapi.com");
        headers.setContentType(MediaType.APPLICATION_XML);
        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<List> response = restTemplate.exchange(
                "https://dog-breeds2.p.rapidapi.com/dog_breeds", HttpMethod.GET, request, List.class);

        List<DataResponse> data = response.getBody();

        return data;

    }
}
