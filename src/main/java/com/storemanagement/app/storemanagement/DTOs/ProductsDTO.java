package com.storemanagement.app.storemanagement.DTOs;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDTO {

        private String category;
        private String name;
        private Long price;

}
