package tic.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tic.db.StepRepository;
import tic.model.Step;

@Service
public class StepServiceImpl implements StepService{

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StepRepository stepRepository;

    @Override
    public void saveStep(Step step){
        logger.info("LOG: Save step in Databases");
        stepRepository.save(step);
    }
}
