package com.rs.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private String name;
    private int points;
    
    public boolean hasLessHundredPoints() {
        return this.points < 100;
    }
}
