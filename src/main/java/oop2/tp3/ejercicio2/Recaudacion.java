package oop2.tp3.ejercicio2;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Recaudacion {

    private static final int PERMALINK = 0;
    private static final int COMPANY_NAME = 1;
    private static final int NUMBER_EMPLOYEES = 2;
    private static final int CATEGORY = 3;
    private static final int CITY = 4;
    private static final int STATE = 5;
    private static final int FUNDED_DATE = 6;
    private static final int RAISED_AMOUNT = 7;
    private static final int RAISED_CURRENCY = 8;
    private static final int ROUND = 9;

    private final List<String[]> csvData;

    public Recaudacion() throws IOException {
        CsvReader reader = new CsvReader("src/main/resources/data.csv");
        this.csvData = reader.read();
    }

    public List<Map<String, String>> where(Map<String, String> options) {
        List<String[]> filteredData = csvData;

        for (Map.Entry<String, String> entry : options.entrySet()) {
            filteredData = filterByOption(filteredData, entry.getKey(), entry.getValue());
        }

        return filteredData.stream()
                .map(this::mapRow)
                .collect(Collectors.toList());
    }

    private List<String[]> filterByOption(List<String[]> data, String key, String value) {
        int columnIndex = switch (key) {
            case "company_name" -> COMPANY_NAME;
            case "city" -> CITY;
            case "state" -> STATE;
            case "round" -> ROUND;
            default -> throw new IllegalArgumentException("Clave de búsqueda inválida: " + key);
        };

        return data.stream()
                .filter(row -> row[columnIndex].equals(value))
                .collect(Collectors.toList());
    }

    private Map<String, String> mapRow(String[] row) {
        Map<String, String> mapped = new HashMap<>();
        mapped.put("permalink", row[PERMALINK]);
        mapped.put("company_name", row[COMPANY_NAME]);
        mapped.put("number_employees", row[NUMBER_EMPLOYEES]);
        mapped.put("category", row[CATEGORY]);
        mapped.put("city", row[CITY]);
        mapped.put("state", row[STATE]);
        mapped.put("funded_date", row[FUNDED_DATE]);
        mapped.put("raised_amount", row[RAISED_AMOUNT]);
        mapped.put("raised_currency", row[RAISED_CURRENCY]);
        mapped.put("round", row[ROUND]);
        return mapped;
    }
}
