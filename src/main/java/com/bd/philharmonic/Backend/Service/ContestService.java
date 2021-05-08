package com.bd.philharmonic.Backend.Service;

import com.bd.philharmonic.Backend.Entity.Concert;
import com.bd.philharmonic.Backend.Entity.Contest;
import com.bd.philharmonic.Backend.Repository.ContestRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContestService {

    private final ContestRepository contestRepository;

    public ContestService(ContestRepository contestRepository) {
        this.contestRepository = contestRepository;
    }

    public List<Contest> findAll(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return contestRepository.findAll();
        } else {
            return contestRepository.search(filterText);
        }
    }

    public List<String> getContestPrizewinners(String param) {
        return contestRepository.getContestPrizewinners(param);
    }

    public void save(Contest contest) {
        if (contest == null){
            return;
        }
        contestRepository.save(contest);
    }

    public void delete(Contest contest) {
        contestRepository.delete(contest);
    }

}
