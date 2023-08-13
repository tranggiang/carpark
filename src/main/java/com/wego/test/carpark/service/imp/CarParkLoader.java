package com.wego.test.carpark.service.imp;

import com.wego.test.carpark.model.CarPark;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarParkLoader {

    public static List<CarPark> loadCarPark() throws FileNotFoundException {

        File file = ResourceUtils.getFile("classpath:HDBCarparkInformation.csv");

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            List<CSVRecord> csvRecords = csvParser.getRecords();
            List<CarPark> carParks = new ArrayList(csvRecords.size());

            for (CSVRecord csvRecord : csvRecords) {
                CarPark carPark = new CarPark(csvRecord.get("car_park_no"), csvRecord.get("address"),
                        Double.parseDouble(csvRecord.get("x_coord")), Double.parseDouble(csvRecord.get("y_coord")),
                        csvRecord.get("car_park_type"), csvRecord.get("type_of_parking_system"),
                        csvRecord.get("short_term_parking"), csvRecord.get("free_parking"),
                        csvRecord.get("night_parking"), Integer.parseInt(csvRecord.get("car_park_decks")),
                        Double.parseDouble(csvRecord.get("gantry_height")),
                        Boolean.parseBoolean(csvRecord.get("car_park_basement")));

                carParks.add(carPark);
            }

            return carParks;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
