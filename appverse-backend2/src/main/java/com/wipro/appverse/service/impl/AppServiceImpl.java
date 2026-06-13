package com.wipro.appverse.service.impl;
import com.wipro.appverse.entity.App;
import com.wipro.appverse.repository.AppRepository;
import com.wipro.appverse.service.AppService;
import com.wipro.appverse.exception.AppAlreadyExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class AppServiceImpl implements AppService {
	@Autowired
    private AppRepository appRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger =
            LoggerFactory.getLogger(AppServiceImpl.class);
    @Override
    public App saveApp(App app) {
    	logger.info("Attempting to save app: {}", app.getName());

        boolean exists = appRepository.existsByNameIgnoreCase(app.getName());

        if (exists) {   // ✅ THIS WAS MISSING
            logger.error("App already exists: {}", app.getName());
            throw new AppAlreadyExistsException("App already exists with this name");
        }

        App savedApp = appRepository.save(app);

        logger.info("App saved successfully: {}", savedApp.getName());

        return savedApp;
    }
    @Override
    public List<App> getAllApps() {

        logger.info("Fetching all apps");

        List<App> apps = appRepository.findAll();

        if (apps.isEmpty()) {
            logger.warn("No apps found, returning sample data");

            App a1 = new App();
            a1.setName("Food App");
            a1.setCategory("Food");

            App a2 = new App();
            a2.setName("Music App");
            a2.setCategory("Music");

            return List.of(a1, a2);
        }

        return apps;
    }

    

    @Override
    public void deleteApp(Long id) {
        logger.warn("Deleting app with id: {}", id);
        appRepository.deleteById(id);
    }

    @Override
    public List<App> recommendApps(String category) {
        logger.info("Fetching apps for category: {}", category);
        return appRepository.findByCategory(category);
    }

    @Override
    public List<?> getMicroRecommendations(String category) {

        String url = "http://localhost:8082/recommend/" + category;

        logger.info("Calling recommendation microservice for: {}", category);

        return restTemplate.getForObject(url, List.class);
    }
}


    

