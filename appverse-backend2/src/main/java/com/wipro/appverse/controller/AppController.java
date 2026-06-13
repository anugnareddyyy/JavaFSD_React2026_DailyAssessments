package com.wipro.appverse.controller;

/*
 * Handles REST APIs for App Marketplace.
 */

import com.wipro.appverse.entity.App;
import com.wipro.appverse.service.AppService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apps")
public class AppController {

    @Autowired
    private AppService service;

    /*
     * Get all apps
     */
    @GetMapping
    public List<App> getApps() {
        return service.getAllApps();
    }

    /*
     * Save new app
     */
    @PostMapping
    public App saveApp(@Valid @RequestBody App app) {
        return service.saveApp(app);
    }

    /*
     * Recommendation (Monolith logic)
     */
    @GetMapping("/recommend/{category}")
    public List<App> recommend(@PathVariable String category) {
        return service.recommendApps(category);
    }

    /*
     * Secured API (Used to test JWT Authentication)
     */
    @GetMapping("/secure-test")
    public String secureTest() {
        return "Secured API accessed successfully ✅";
    }

    /*
     * Fetch recommendations from microservice
     */
    @GetMapping("/micro-recommend/{category}")
    public List<?> getMicroRecommendations(@PathVariable String category) {
        return service.getMicroRecommendations(category);
    }
    //  DELETE API
    @DeleteMapping("/{id}")
    public String deleteApp(@PathVariable Long id) {
        service.deleteApp(id);
        return "App deleted successfully ✅";
    }
}