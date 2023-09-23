package dev.peter.dataaggregator.controller;

import dev.peter.dataaggregator.dto.DataFormat;
import dev.peter.dataaggregator.dto.DataResponse;
import dev.peter.dataaggregator.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("aggregate")
public class DataController {

    @Autowired
    private DataService dataService;
    @GetMapping
    public List<DataFormat> retriveData(@RequestParam("filters") List<String> filters) {
        return dataService.fetchData(filters);
    }
}
