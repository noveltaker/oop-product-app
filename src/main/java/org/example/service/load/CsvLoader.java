package org.example.service.load;

import org.example.dto.ProductDTO;
import org.example.service.load.data.CommaData;
import org.example.service.load.data.Data;
import org.example.service.load.data.DoubleQuotationData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CsvLoader implements Load {

  @Override
  public List<ProductDTO> getData() {

    List<ProductDTO> products = new ArrayList<>();

    URL value = getClass().getClassLoader().getResource("items_.csv");

    String path = value.getPath();

    try (BufferedReader br = new BufferedReader(new FileReader(path))) {

      String line;

      br.readLine();

      while ((line = br.readLine()) != null) {

        int notFormatIndex = line.indexOf("\"");

        String[] values = line.split(",");

        Data data = notFormatIndex > -1 ? new DoubleQuotationData() : new CommaData();

        products.add(data.created(values));
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return products;
  }
}
