package dev.peter.dataaggregator.service;

import dev.peter.dataaggregator.dto.DataFormat;
import dev.peter.dataaggregator.dto.DataResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DataService {
    public List<DataFormat> fetchData(List<String> filters) {
        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        headers.add("X-RapidAPI-Key", "49ff0941bbmsha963dcd0964c181p10a44ajsn508b93f28735");
        headers.add("X-RapidAPI-Host", "dog-breeds2.p.rapidapi.com");
        headers.setContentType(MediaType.APPLICATION_XML);
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<DataResponse[]> response = restTemplate
                .exchange("https://dog-breeds2.p.rapidapi.com/dog_breeds", HttpMethod.GET, request, DataResponse[].class);

        List<DataResponse> data = Arrays.asList(response.getBody());

        String selectedBreed = filters.get(0);
        String selectedOrigin = filters.get(1);

        Predicate<DataResponse> breedFilter = (e) -> true;
        Predicate<DataResponse> originFilter = (e) -> true;

        if (!selectedBreed.equals("All")) {
            breedFilter = (e) -> e.getBreed().equals(selectedBreed);
        }
        if (!selectedOrigin.equals("All")) {
            originFilter = (e) -> e.getOrigin().equals(selectedOrigin);
        }

        //debug filter list check
        log.info(filters.toString());

        return data.stream()
                .filter(breedFilter)
                .filter(originFilter)
                .map(d -> DataFormat.builder()
                        .id(d.getId())
                        .breed(d.getBreed())
                        .origin(d.getOrigin())
                        .coat(d.getMeta().getCoat())
                        .breed_status(d.getMeta().getBreed_status())
                        .build())
                .collect(Collectors.toList());

    }
}
