package com.boku.dao.impl;

import com.boku.dao.IInputProvider;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "inMemoryInputProvider")
public class InMemoryInputProvider implements IInputProvider {

  private Map<String, String> productItems;

  @Override
  public Map<String, String> fetchInput() {
    productItems = new HashMap<>();
    populateProductItems("book", "BookProduct");
    populateProductItems("music CD", "MiscellaneousProduct");
    populateProductItems("chocolate bar", "FoodProduct");
    populateProductItems("imported box of chocolates", "FoodProduct");
    populateProductItems("box of imported chocolates", "FoodProduct");
    populateProductItems("imported bottle of perfume", "MiscellaneousProduct");
    populateProductItems("bottle of perfume", "MiscellaneousProduct");
    populateProductItems("packet of headache pills", "MedicalProduct");
    return productItems;
  }

  public void populateProductItems(String productItem, String productCategory) {
    productItems.put(productItem, productCategory);
  }
}
