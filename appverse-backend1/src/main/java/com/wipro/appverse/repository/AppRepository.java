package com.wipro.appverse.repository;

import com.wipro.appverse.entity.App;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AppRepository extends JpaRepository<App, Long> {
	boolean existsByNameIgnoreCase(String name);
    List<App> findByCategory(String category);
    
}