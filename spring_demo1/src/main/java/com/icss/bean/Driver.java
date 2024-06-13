package com.icss.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    private int id;
    private int age;
    private String name;
    private Car car1;
}
