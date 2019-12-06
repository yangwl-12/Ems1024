package com.yang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Emp implements Serializable {
    private String ee_id;
    private String ee_name;
    private Double ee_salary;
    private Integer ee_age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ee_date;
}
