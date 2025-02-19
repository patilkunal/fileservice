package com.example.fileservice.service;

import com.example.fileservice.dao.FileImportRepository;
import com.example.fileservice.models.FileImportRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FileImportService {

    private final FileImportRepository dao;

    @Value("${fileimport.types}")
    private String[] types;

    public FileImportService(FileImportRepository dao) {
        this.dao = dao;
    }

    public void saveImportRecord(FileImportRecord rec) {
        dao.save(rec);
    }

    public FileImportRecord getImportRecord(int id) {
        return dao.findById(id).orElse(null);
    }

    @Async
    @Scheduled(fixedRate = 30000, initialDelay = 30000)
    public void scheduleImport() {
        System.out.println("I am running the file import " + (new Date()) + " : " + Thread.currentThread().getName());
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}