package com.study.point.entities;


/* import java.math.BigDecimal;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat; */
/**
 * Product entity.
 */
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MySearchBetween {
	
    private String classe;
    private String name;
	
}
