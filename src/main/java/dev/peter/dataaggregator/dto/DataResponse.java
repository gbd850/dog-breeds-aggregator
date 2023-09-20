package dev.peter.dataaggregator.dto;

import dev.peter.dataaggregator.model.MetaData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataResponse {
    private int id;
    private String breed;
    private String origin;
    private MetaData meta;

}
