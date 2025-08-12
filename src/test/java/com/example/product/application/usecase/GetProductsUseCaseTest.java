package com.example.product.application.usecase;

import com.example.product.DataSource;
import com.example.product.InMemoryProductRepository;
import com.example.product.application.model.Product;
import com.example.product.application.model.ProductresponsetDTO;
import com.example.product.application.model.ProductQueryCommand;
import com.example.product.application.model.discount.*;
import com.example.product.application.model.port.out.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GetProductsUseCaseTest {

  private ProductRepository<Product> repository;
  private DiscountService discountService;
  private GetProductsUseCase getProductsUseCase;

  List<Product> products = DataSource.getProducts();

  @BeforeEach
  void setup() {
    repository = new InMemoryProductRepository();
    discountService =
        new ProductDiscountService(
            List.of(
                new ElectronicsDiscountStrategy(),
                new HomeKitchenDiscountStrategy(),
                new SkuEndingInFiveDiscountStrategy()));
    getProductsUseCase = new GetProductsUseCase(repository, discountService);
  }

  @Test
  void execute_returnAllProducts() {
    ProductQueryCommand productQueryCommand = new ProductQueryCommand.Builder().build();
    List<ProductresponsetDTO> productresponsetDTOS =
        getProductsUseCase.execute(productQueryCommand);

    Assertions.assertEquals(products.size(), productresponsetDTOS.size());

    compareExpectedListWithActual(products.size(), products, productresponsetDTOS);
  }

  @Test
  void execute_returnProductsByCategory_whenElectronics_Successfully() {
    ProductQueryCommand productQueryCommand =
        new ProductQueryCommand.Builder().categoryFilter("Electronics").build();

    List<ProductresponsetDTO> productresponsetDTOS =
        getProductsUseCase.execute(productQueryCommand);
    List<Product> filteredProduct =
        products.stream()
            .filter(p1 -> "electronics".equals(p1.getCategory().toLowerCase()))
            .collect(Collectors.toList());

    Assertions.assertEquals(filteredProduct.size(), productresponsetDTOS.size());
    compareExpectedListWithActual(
        productresponsetDTOS.size(), filteredProduct, productresponsetDTOS);
  }

  @Test
  void execute_returnProductsByCategory_whenClothing_Successfully() {
    ProductQueryCommand productQueryCommand =
        new ProductQueryCommand.Builder().categoryFilter("Clothing").build();

    List<ProductresponsetDTO> productresponsetDTOS =
        getProductsUseCase.execute(productQueryCommand);
    List<Product> filteredProduct =
        products.stream()
            .filter(p1 -> "clothing".equals(p1.getCategory().toLowerCase()))
            .collect(Collectors.toList());

    Assertions.assertEquals(filteredProduct.size(), productresponsetDTOS.size());
    compareExpectedListWithActual(
        productresponsetDTOS.size(), filteredProduct, productresponsetDTOS);
  }

  @Test
  void execute_returnProductsByCategory_whenAccessories_Successfully() {
    ProductQueryCommand productQueryCommand =
        new ProductQueryCommand.Builder().categoryFilter("Accessories").build();

    List<ProductresponsetDTO> productresponsetDTOS =
        getProductsUseCase.execute(productQueryCommand);
    List<Product> filteredProduct =
        products.stream()
            .filter(p1 -> "accessories".equals(p1.getCategory().toLowerCase()))
            .collect(Collectors.toList());

    Assertions.assertEquals(filteredProduct.size(), productresponsetDTOS.size());
    compareExpectedListWithActual(
        productresponsetDTOS.size(), filteredProduct, productresponsetDTOS);
  }

  @Test
  void execute_returnProductsByCategory_whenSports_Successfully() {
    ProductQueryCommand productQueryCommand =
        new ProductQueryCommand.Builder().categoryFilter("Sports").build();

    List<ProductresponsetDTO> productresponsetDTOS =
        getProductsUseCase.execute(productQueryCommand);
    List<Product> filteredProduct =
        products.stream()
            .filter(p1 -> "sports".equals(p1.getCategory().toLowerCase()))
            .collect(Collectors.toList());

    Assertions.assertEquals(filteredProduct.size(), productresponsetDTOS.size());
    compareExpectedListWithActual(
        productresponsetDTOS.size(), filteredProduct, productresponsetDTOS);
  }

  @Test
  void execute_returnProductsByCategory_whenStationery_Successfully() {
    ProductQueryCommand productQueryCommand =
        new ProductQueryCommand.Builder().categoryFilter("Stationery").build();

    List<ProductresponsetDTO> productresponsetDTOS =
        getProductsUseCase.execute(productQueryCommand);
    List<Product> filteredProduct =
        products.stream()
            .filter(p1 -> "stationery".equals(p1.getCategory().toLowerCase()))
            .collect(Collectors.toList());

    Assertions.assertEquals(filteredProduct.size(), productresponsetDTOS.size());
    compareExpectedListWithActual(
        productresponsetDTOS.size(), filteredProduct, productresponsetDTOS);
  }

  @Test
  void execute_returnProductsByCategory_whenFootwear_Successfully() {
    ProductQueryCommand productQueryCommand =
        new ProductQueryCommand.Builder().categoryFilter("Footwear").build();

    List<ProductresponsetDTO> productresponsetDTOS =
        getProductsUseCase.execute(productQueryCommand);
    List<Product> filteredProduct =
        products.stream()
            .filter(p1 -> "footwear".equals(p1.getCategory().toLowerCase()))
            .collect(Collectors.toList());

    Assertions.assertEquals(filteredProduct.size(), productresponsetDTOS.size());
    compareExpectedListWithActual(
        productresponsetDTOS.size(), filteredProduct, productresponsetDTOS);
  }

  @Test
  void execute_returnProductsByCategory_whenHomeAppliances_Successfully() {
    ProductQueryCommand productQueryCommand =
        new ProductQueryCommand.Builder().categoryFilter("Home Appliances").build();

    List<ProductresponsetDTO> productresponsetDTOS =
        getProductsUseCase.execute(productQueryCommand);
    List<Product> filteredProduct =
        products.stream()
            .filter(p1 -> "home appliances".equals(p1.getCategory().toLowerCase()))
            .collect(Collectors.toList());

    Assertions.assertEquals(filteredProduct.size(), productresponsetDTOS.size());
    compareExpectedListWithActual(
        productresponsetDTOS.size(), filteredProduct, productresponsetDTOS);
  }

  @Test
  void execute_returnProductsByCategory_whenHomeAndKitchen_Successfully() {
    ProductQueryCommand productQueryCommand =
        new ProductQueryCommand.Builder().categoryFilter("Home & Kitchen").build();

    List<ProductresponsetDTO> productresponsetDTOS =
        getProductsUseCase.execute(productQueryCommand);
    List<Product> filteredProduct =
        products.stream()
            .filter(p1 -> "home & kitchen".equals(p1.getCategory().toLowerCase()))
            .collect(Collectors.toList());

    Assertions.assertEquals(filteredProduct.size(), productresponsetDTOS.size());
    compareExpectedListWithActual(
        productresponsetDTOS.size(), filteredProduct, productresponsetDTOS);
  }

  @Test
  void execute_returnProductsByCategory_whenCategoryNotPresent_returnsEmpty() {
    ProductQueryCommand productQueryCommand =
        new ProductQueryCommand.Builder().categoryFilter("FakeCategoty").build();

    List<ProductresponsetDTO> productresponsetDTOS =
        getProductsUseCase.execute(productQueryCommand);
    List<Product> filteredProduct =
        products.stream()
            .filter(p1 -> "FakeCategoty".equals(p1.getCategory().toLowerCase()))
            .collect(Collectors.toList());

    Assertions.assertEquals(0, productresponsetDTOS.size());
    Assertions.assertEquals(0, filteredProduct.size());
  }

  @Test
  void execute_returnProductsByCategoryAndOrderByPriceDesc_whenElectronics_Successfully() {
    ProductQueryCommand productQueryCommand =
        new ProductQueryCommand.Builder()
            .categoryFilter("Electronics")
            .sortField("price")
            .sortDirection("DESC")
            .build();

    List<ProductresponsetDTO> productresponsetDTOS =
        getProductsUseCase.execute(productQueryCommand);
    List<Product> filteredProduct =
        products.stream()
            .filter(p1 -> "electronics".equalsIgnoreCase(p1.getCategory()))
            .sorted(Comparator.comparing(Product::getPrice).reversed())
            .collect(Collectors.toList());

    Assertions.assertEquals(filteredProduct.size(), productresponsetDTOS.size());
    compareExpectedListWithActual(
        productresponsetDTOS.size(), filteredProduct, productresponsetDTOS);
  }

  @Test
  void execute_returnProductsByCategoryAndOrderByPriceAsc_whenElectronics_Successfully() {
    ProductQueryCommand productQueryCommand =
        new ProductQueryCommand.Builder()
            .categoryFilter("electronics")
            .sortField("PRice")
            .sortDirection("asc")
            .build();

    List<ProductresponsetDTO> productresponsetDTOS =
        getProductsUseCase.execute(productQueryCommand);
    List<Product> filteredProduct =
        products.stream()
            .filter(p1 -> "electronics".equalsIgnoreCase(p1.getCategory()))
            .sorted(Comparator.comparing(Product::getPrice))
            .collect(Collectors.toList());

    Assertions.assertEquals(filteredProduct.size(), productresponsetDTOS.size());
    compareExpectedListWithActual(
        productresponsetDTOS.size(), filteredProduct, productresponsetDTOS);
  }

  @Test
  void execute_whenOrderByFieldIsNotExists_throwException() {

    IllegalArgumentException ex =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              ProductQueryCommand productQueryCommand =
                  new ProductQueryCommand.Builder()
                      .categoryFilter("e1lectronics")
                      .sortField("fake_field")
                      .sortDirection("asc")
                      .build();
            });
  }

  private static void compareExpectedListWithActual(
      int size, List<Product> expected, List<ProductresponsetDTO> actual) {
    for (int i = 0; i < size; i++) {
      Product p = expected.get(i);
      ProductresponsetDTO dto = actual.get(i);
      Assertions.assertEquals(dto.sku(), p.getSku());
      Assertions.assertEquals(dto.originalPrice(), p.getPrice());
      Assertions.assertEquals(dto.description(), p.getDescription());
      Assertions.assertEquals(dto.category(), p.getCategory());
    }
  }
}
