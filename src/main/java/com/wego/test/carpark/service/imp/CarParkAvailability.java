package com.wego.test.carpark.service.imp;

import com.wego.test.carpark.model.CarparkData;
import com.wego.test.carpark.model.CarparkInfo;
import com.wego.test.carpark.model.Item;
import com.wego.test.carpark.model.Root;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

public class CarParkAvailability {

    public static final String URL = "https://api.data.gov.sg/v1/transport/carpark-availability";

    public static List<CarparkInfo> getParkingAvailability() {

        try {
            RestTemplate restTemplate = new RestTemplate();
            Root root = restTemplate.getForObject(URL, Root.class);
            Item items = root.getItems().get(0);
            List<CarparkData> carParkData = items.getCarpark_data();
            return carParkData.stream().flatMap(c -> c.getCarpark_info().stream()).collect(Collectors.toList());

        } catch (RestClientException e) {
            throw new RuntimeException("Unable to parse data ", e);
        }


    }
}
