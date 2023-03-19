package com.flikendo.F_Data_Storage.Beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Date: 03-16-2023
 * Author: Flikendo
 *
 * AppConfig class. This class contains all beans for Spring Boot
 */
@Configuration
public class AppConfig {
    /**
     * FuelStationBean object creation in Spring Boot context
     *
     * @return FuelStationBean's instance
     */
    @Bean
    FuelStationBean fuelStationBean() {
        return new FuelStationBean();
    }
}
