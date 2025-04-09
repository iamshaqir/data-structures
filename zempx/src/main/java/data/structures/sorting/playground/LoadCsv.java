package com.ms.data.structures.sorting.playground;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadCsv {

    private static final List<OnlineRetail> ONLINE_RETAIL_LIST = new ArrayList<>();
    private static final String COMMA_DELIMITER = ",";

    public static void loadcsv(String dirUrl) {
        try (BufferedReader br = new BufferedReader(new FileReader(dirUrl))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] lineArray = line.split(COMMA_DELIMITER);
                try {
                    loadRetailList(lineArray);
                } catch (NumberFormatException nfe) {
                    System.err.println("Number format exception: " + nfe.getMessage());
                } catch (ArrayIndexOutOfBoundsException ae) {
                    System.err.println("Data missing for aset record: " + ae.getMessage());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static void loadRetailList(String[] lineArray) {
        OnlineRetail onlineRetail = OnlineRetail.builder()
                .invoiceNo(Integer.parseInt(lineArray[0]))
                .stockCode(lineArray[1])
                .description(lineArray[2])
                .quantity(Integer.parseInt(lineArray[3]))
                .invoiceData(lineArray[4])
                .unitPrice(Double.parseDouble(lineArray[5]))
                .customerID(lineArray[6])
                .country(lineArray[7])
                .build();
        ONLINE_RETAIL_LIST.add(onlineRetail);
    }

    public static List<OnlineRetail> getOnlineRetailList() {
        return ONLINE_RETAIL_LIST;
    }
}
