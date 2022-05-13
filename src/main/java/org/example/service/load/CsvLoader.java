package org.example.service.load;

import org.example.dto.ProductDTO;

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
        if (notFormatIndex > -1) {

          Long id = Long.valueOf(values[0]);

          String name =
              values[1].substring(1, values[1].length())
                  + values[2].substring(0, values[2].length() - 1);

          Integer amount = Integer.valueOf(values[3]);

          Integer count = Integer.valueOf(values[4]);

          products.add(ProductDTO.builder().id(id).name(name).amount(amount).count(count).build());

        } else {

          Long id = Long.valueOf(values[0]);

          String name = values[1];

          Integer amount = Integer.valueOf(values[2]);

          Integer count = Integer.valueOf(values[3]);

          products.add(ProductDTO.builder().id(id).name(name).amount(amount).count(count).build());
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return products;
  }
}
