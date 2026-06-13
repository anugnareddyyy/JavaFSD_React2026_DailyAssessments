package com.wipro.appverse.service;
import com.wipro.appverse.entity.App;
import java.util.List;

public interface AppService {
	 // REQUIRED FOR DELETE

    void deleteApp(Long id);

    List<App> getAllApps();

    App saveApp(App app);

    List<App> recommendApps(String category);

    List<?> getMicroRecommendations(String category);
}


