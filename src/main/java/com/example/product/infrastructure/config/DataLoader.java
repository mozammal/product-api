package com.example.product.infrastructure.config;

import com.example.product.application.model.Product;
import com.example.product.application.model.port.out.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

  private final ProductRepository<Product> repository;

  public DataLoader(ProductRepository<Product> repository) {
    this.repository = repository;
  }

  @Override
  public void run(String... args) throws Exception {
    List<Product> products =
        List.of(
            new Product(
                "SKU0001",
                new BigDecimal("19.99"),
                "Wireless Mouse with ergonomic design",
                "Electronics"),
            new Product(
                "SKU0002",
                new BigDecimal("499.00"),
                "4K Ultra HD Smart TV, 55 inches",
                "Electronics"),
            new Product(
                "SKU0003",
                new BigDecimal("29.50"),
                "Stainless Steel Water Bottle, 1L",
                "Home & Kitchen"),
            new Product(
                "SKU0004", new BigDecimal("15.00"), "Cotton T-Shirt, Unisex, Size M", "Clothing"),
            new Product(
                "SKU0005",
                new BigDecimal("120.00"),
                "Noise-Cancelling Over-Ear Headphones",
                "Electronics"),
            new Product("SKU0006", new BigDecimal("9.99"), "USB-C to USB Adapter", "Electronics"),
            new Product(
                "SKU0007",
                new BigDecimal("75.00"),
                "Leather Wallet with RFID Protection",
                "Accessories"),
            new Product(
                "SKU0008", new BigDecimal("35.00"), "Yoga Mat with Non-Slip Surface", "Sports"),
            new Product(
                "SKU0009",
                new BigDecimal("220.00"),
                "Smartwatch with Heart Rate Monitor",
                "Electronics"),
            new Product(
                "SKU0010", new BigDecimal("12.50"), "Ceramic Coffee Mug, 350ml", "Home & Kitchen"),
            new Product(
                "SKU0011", new BigDecimal("60.00"), "Bluetooth Portable Speaker", "Electronics"),
            new Product(
                "SKU0012",
                new BigDecimal("85.00"),
                "Backpack with Laptop Compartment",
                "Accessories"),
            new Product(
                "SKU0013",
                new BigDecimal("18.00"),
                "Stainless Steel Cutlery Set, 24 Pieces",
                "Home & Kitchen"),
            new Product(
                "SKU0014",
                new BigDecimal("250.00"),
                "Electric Guitar Starter Pack",
                "Musical Instr."),
            new Product(
                "SKU0015", new BigDecimal("42.00"), "Running Shoes, Men's Size 42", "Footwear"),
            new Product(
                "SKU0016",
                new BigDecimal("27.99"),
                "Digital Bathroom Scale with Body Fat Analyzer",
                "Home Appliances"),
            new Product(
                "SKU0017", new BigDecimal("14.99"), "Set of 6 Organic Cotton Socks", "Clothing"),
            new Product(
                "SKU0018",
                new BigDecimal("300.00"),
                "DSLR Camera with 18-55mm Lens",
                "Electronics"),
            new Product(
                "SKU0019",
                new BigDecimal("8.99"),
                "Hardcover Notebook, A5, 200 Pages",
                "Stationery"),
            new Product(
                "SKU0020",
                new BigDecimal("65.00"),
                "Microwave Oven, 20L Capacity",
                "Home Appliances"),
            new Product(
                "SKU0021",
                new BigDecimal("23.50"),
                "LED Desk Lamp with Adjustable Brightness",
                "Home & Kitchen"),
            new Product(
                "SKU0022",
                new BigDecimal("19.00"),
                "Wireless Charger Pad for Smartphones",
                "Electronics"),
            new Product(
                "SKU0023",
                new BigDecimal("55.00"),
                "Men's Quartz Analog Watch with Leather Strap",
                "Accessories"),
            new Product(
                "SKU0024",
                new BigDecimal("30.00"),
                "Wooden Chess Set with Folding Board",
                "Toys & Games"),
            new Product(
                "SKU0025",
                new BigDecimal("99.00"),
                "Home Security Camera with Night Vision",
                "Electronics"),
            new Product(
                "SKU0026",
                new BigDecimal("16.50"),
                "Aromatherapy Essential Oil Diffuser",
                "Home & Kitchen"),
            new Product(
                "SKU0027",
                new BigDecimal("40.00"),
                "Professional Blender with 2L Jar",
                "Home Appliances"),
            new Product(
                "SKU0028", new BigDecimal("22.00"), "Kids' Educational Tablet Toy", "Toys & Games"),
            new Product(
                "SKU0029",
                new BigDecimal("110.00"),
                "Mechanical Gaming Keyboard with RGB Lighting",
                "Electronics"),
            new Product(
                "SKU0030",
                new BigDecimal("7.50"),
                "Pack of 10 Ballpoint Pens, Blue Ink",
                "Stationery"));

    repository.saveAll(products);
  }
}
