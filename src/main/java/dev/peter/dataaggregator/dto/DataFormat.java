package dev.peter.dataaggregator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataFormat {
    private int id;
    private String breed;
    private String origin;
    private String coat;
    //    private String other_names;
    private String breed_status;
}
