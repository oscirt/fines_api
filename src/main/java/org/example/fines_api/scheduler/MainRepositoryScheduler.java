package org.example.fines_api.scheduler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.fines_api.service.ManageDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MainRepositoryScheduler {

    Logger logger = LogManager.getLogger();

    private final ManageDataService manageDataService;

    public MainRepositoryScheduler(ManageDataService manageDataService) {
        this.manageDataService = manageDataService;
    }

    @Scheduled(fixedRate = 10_000L)
    public void scheduleLogTask() {
        logger.info(String.format("All users: %s", manageDataService.getAllUsers()));
    }
}
