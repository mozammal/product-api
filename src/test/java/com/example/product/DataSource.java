package com.example.product;

import com.example.product.application.model.Product;

import java.math.BigDecimal;
import java.util.List;

public final class DataSource {

  private DataSource() {
    throw new AssertionError();
  }

  private static final List<Product> products =
      List.of(
          new Product(
              "SKU0001",
              BigDecimal.valueOf(19.99),
              "Wireless Mouse with ergonomic design",
              "Electronics"),
          new Product(
              "SKU0002",
              BigDecimal.valueOf(499.00),
              "4K Ultra HD Smart TV, 55 inches",
              "Electronics"),
          new Product(
              "SKU0003",
              BigDecimal.valueOf(29.50),
              "Stainless Steel Water Bottle, 1L",
              "Home & Kitchen"),
          new Product(
              "SKU0004", BigDecimal.valueOf(15.00), "Cotton T-Shirt, Unisex, Size M", "Clothing"),
          new Product(
              "SKU0005",
              BigDecimal.valueOf(120.00),
              "Noise-Cancelling Over-Ear Headphones",
              "Electronics"),
          new Product("SKU0006", BigDecimal.valueOf(9.99), "USB-C to USB Adapter", "Electronics"),
          new Product(
              "SKU0007",
              BigDecimal.valueOf(75.00),
              "Leather Wallet with RFID Protection",
              "Accessories"),
          new Product(
              "SKU0008", BigDecimal.valueOf(35.00), "Yoga Mat with Non-Slip Surface", "Sports"),
          new Product(
              "SKU0009",
              BigDecimal.valueOf(220.00),
              "Smartwatch with Heart Rate Monitor",
              "Electronics"),
          new Product(
              "SKU0010", BigDecimal.valueOf(12.50), "Ceramic Coffee Mug, 350ml", "Home & Kitchen"),
          new Product(
              "SKU0011", BigDecimal.valueOf(60.00), "Bluetooth Portable Speaker", "Electronics"),
          new Product(
              "SKU0012",
              BigDecimal.valueOf(85.00),
              "Backpack with Laptop Compartment",
              "Accessories"),
          new Product(
              "SKU0013",
              BigDecimal.valueOf(18.00),
              "Stainless Steel Cutlery Set, 24 Pieces",
              "Home & Kitchen"),
          new Product(
              "SKU0014",
              BigDecimal.valueOf(250.00),
              "Electric Guitar Starter Pack",
              "Musical Instr."),
          new Product(
              "SKU0015", BigDecimal.valueOf(42.00), "Running Shoes, Men's Size 42", "Footwear"),
          new Product(
              "SKU0016",
              BigDecimal.valueOf(27.99),
              "Digital Bathroom Scale with Body Fat Analyzer",
              "Home Appliances"),
          new Product(
              "SKU0017", BigDecimal.valueOf(14.99), "Set of 6 Organic Cotton Socks", "Clothing"),
          new Product(
              "SKU0018",
              BigDecimal.valueOf(300.00),
              "DSLR Camera with 18-55mm Lens",
              "Electronics"),
          new Product(
              "SKU0019",
              BigDecimal.valueOf(8.99),
              "Hardcover Notebook, A5, 200 Pages",
              "Stationery"),
          new Product(
              "SKU0020",
              BigDecimal.valueOf(65.00),
              "Microwave Oven, 20L Capacity",
              "Home Appliances"),
          new Product(
              "SKU0021",
              BigDecimal.valueOf(23.50),
              "LED Desk Lamp with Adjustable Brightness",
              "Home & Kitchen"),
          new Product(
              "SKU0022",
              BigDecimal.valueOf(19.00),
              "Wireless Charger Pad for Smartphones",
              "Electronics"),
          new Product(
              "SKU0023",
              BigDecimal.valueOf(55.00),
              "Men's Quartz Analog Watch with Leather Strap",
              "Accessories"),
          new Product(
              "SKU0024",
              BigDecimal.valueOf(30.00),
              "Wooden Chess Set with Folding Board",
              "Toys & Games"),
          new Product(
              "SKU0025",
              BigDecimal.valueOf(99.00),
              "Home Security Camera with Night Vision",
              "Electronics"),
          new Product(
              "SKU0026",
              BigDecimal.valueOf(16.50),
              "Aromatherapy Essential Oil Diffuser",
              "Home & Kitchen"),
          new Product(
              "SKU0027",
              BigDecimal.valueOf(40.00),
              "Professional Blender with 2L Jar",
              "Home Appliances"),
          new Product(
              "SKU0028", BigDecimal.valueOf(22.00), "Kids' Educational Tablet Toy", "Toys & Games"),
          new Product(
              "SKU0029",
              BigDecimal.valueOf(110.00),
              "Mechanical Gaming Keyboard with RGB Lighting",
              "Electronics"),
          new Product(
              "SKU0030",
              BigDecimal.valueOf(7.50),
              "Pack of 10 Ballpoint Pens, Blue Ink",
              "Stationery"));

  public static List<Product> getProducts() {
    return products;
  }
}
