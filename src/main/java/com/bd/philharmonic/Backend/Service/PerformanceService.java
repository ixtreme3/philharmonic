package com.bd.philharmonic.Backend.Service;

import com.bd.philharmonic.Backend.Entity.Performance;
import com.bd.philharmonic.Backend.Repository.PerformanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceService {

    private final PerformanceRepository performanceRepository;

    public PerformanceService(PerformanceRepository performanceRepository) {
        this.performanceRepository = performanceRepository;
    }

    public List<Performance> findAll(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return performanceRepository.findAll();
        } else {
            return performanceRepository.search(filterText);
        }
    }

    public void save(Performance performance) {
        if (performance == null){
            return;
        }
        performanceRepository.save(performance);
    }

    public void delete(Performance performance) {
        performanceRepository.delete(performance);
    }

}
