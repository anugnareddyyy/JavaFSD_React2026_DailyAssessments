package com.wipro.appverse.service.impl;

/*
 * Implements business logic for App operations.
 */

import com.wipro.appverse.entity.App;
import com.wipro.appverse.repository.AppRepository;
import com.wipro.appverse.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    @Autowired
    private AppRepository repo;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<App> getAllApps() {
        return repo.findAll();
    }

    @Override
    public App saveApp(App app) {

        boolean exists = repo.existsByNameIgnoreCase(app.getName());

        if (exists) {
            throw new RuntimeException("App with this name already exists ✅");
        }

        return repo.save(app);
    }
    @Override
    public void deleteApp(Long id) {
        repo.deleteById(id);
    }

    //  AI Recommendation Logic (Monolith)
    @Override
    public List<App> recommendApps(String category) {
        return repo.findByCategory(category);
    }

    
    /*
     * Calls external Recommendation Microservice using RestTemplate.
     * Demonstrates microservice communication in the application.
     */
    @Override
    public List<?> getMicroRecommendations(String category) {

        String url = "http://localhost:8082/recommend/" + category;

        return restTemplate.getForObject(url, List.class);
    }
   
  

}
