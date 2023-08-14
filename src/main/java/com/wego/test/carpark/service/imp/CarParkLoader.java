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

    public static final String CAR_PARK_NO = "car_park_no";
    public static final String ADDRESS = "address";
    public static final String X_COORD = "x_coord";
    public static final String Y_COORD = "y_coord";
    public static final String CAR_PARK_TYPE = "car_park_type";
    public static final String TYPE_OF_PARKING_SYSTEM = "type_of_parking_system";
    public static final String SHORT_TERM_PARKING = "short_term_parking";
    public static final String FREE_PARKING = "free_parking";
    public static final String NIGHT_PARKING = "night_parking";
    public static final String CAR_PARK_DECKS = "car_park_decks";
    public static final String GANTRY_HEIGHT = "gantry_height";
    public static final String CAR_PARK_BASEMENT = "car_park_basement";


    public static List<CarPark> loadCarPark() throws FileNotFoundException {

        File file = ResourceUtils.getFile("classpath:HDBCarparkInformation.csv");

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            List<CSVRecord> csvRecords = csvParser.getRecords();
            List<CarPark> carParks = new ArrayList(csvRecords.size());

            for (CSVRecord csvRecord : csvRecords) {
                CarPark carPark = new CarPark(csvRecord.get(CAR_PARK_NO), csvRecord.get(ADDRESS),
                        Double.parseDouble(csvRecord.get(X_COORD)), Double.parseDouble(csvRecord.get(Y_COORD)),
                        csvRecord.get(CAR_PARK_TYPE), csvRecord.get(TYPE_OF_PARKING_SYSTEM),
                        csvRecord.get(SHORT_TERM_PARKING), csvRecord.get(FREE_PARKING),
                        csvRecord.get(NIGHT_PARKING), Integer.parseInt(csvRecord.get(CAR_PARK_DECKS)),
                        Double.parseDouble(csvRecord.get(GANTRY_HEIGHT)),
                        Boolean.parseBoolean(csvRecord.get(CAR_PARK_BASEMENT)));

                carParks.add(carPark);
            }

            return carParks;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
