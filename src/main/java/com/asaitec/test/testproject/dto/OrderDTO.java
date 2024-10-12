package com.asaitec.test.testproject.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class OrderDTO {
	    
	private LocalDateTime date;
    private String clientName;
    private String description;
    private List<OrderLineDTO> orderLines;

}
