package com.egen.tracker;
/**This is the API module to the car-tracker
 *
 * Example to Execute HTTP Commands
 *
 * For Vehicles Data
 * PUT : https://localhost:8080/vehicles
 * GET : https://localhost:8080/vehicles/
 * GET : https://localhost:8080/vehicles/{enter vin number} to get data using VIN number
 *
 * For Readings
 * POST : https://localhost:8080/readings
 * GET : https://localhost:8080/readings
 * GET : https://localhost:8080/readings/{enter vin number} to get data using VIN number
 *
 * For Alerts
 * GET : https://localhost:8080/alerts
 * GET : https://localhost:8080/vin/{enter vin number} to get readings for particular vhicles
 * GET : https://localhost:8080/Priority/{Priority} to get readings based on Priorities
 *  Ex : https://localhost:8080/Priority/HIGH ->  gives high alerts readings
 *
 * @author  Kush Shah
 * @version 1.0.0
 *
 * */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan (basePackages = {"com.egen.tracker"})
@EnableWebMvc
public class Application
{
}
