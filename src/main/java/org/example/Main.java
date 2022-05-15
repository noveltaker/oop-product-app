package org.example;

import org.example.dto.OrderDTO;
import org.example.dto.ProductDTO;
import org.example.service.input.Input;
import org.example.service.input.StringInput;
import org.example.service.load.CsvLoader;
import org.example.service.load.Load;
import org.example.service.work.base.Work;
import org.example.service.work.base.MainBaseWorker;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    Load loader = new CsvLoader();

    List<ProductDTO> products = loader.getData();

    List<OrderDTO> orders = new ArrayList<>();

    Input<String> input = new StringInput();

    Work worker = new MainBaseWorker(products, orders, input);

    worker.work();
  }
}
