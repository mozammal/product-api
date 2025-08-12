package com.example.product.infrastructure.port.in;

import com.example.product.application.usecase.GetProductsUseCase;

import com.example.product.application.model.ProductresponsetDTO;
import com.example.product.application.model.ProductQueryCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ProductController {

  private final GetProductsUseCase getProductsUseCase;

  public ProductController(GetProductsUseCase getProductsUseCase) {
    this.getProductsUseCase = getProductsUseCase;
  }

  @Operation(
      summary = "List products",
      description = "Fetch products with optional filtering by category, sorting, and pagination.")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Products retrieved successfully",
            content =
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ProductresponsetDTO.class))),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid parameter: ",
            content = @Content),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content)
      })
  @GetMapping("/v1/products")
  public List<ProductresponsetDTO> list(
      @RequestParam(value = "category", required = false) String category,
      @RequestParam(value = "sort", defaultValue = "sku") String sort,
      @RequestParam(value = "order", defaultValue = "asc") String order) {

    ProductQueryCommand query =
        new ProductQueryCommand.Builder()
            .categoryFilter(category)
            .sortField(sort)
            .sortDirection(order)
            .build();
    return getProductsUseCase.execute(query);
  }
}
