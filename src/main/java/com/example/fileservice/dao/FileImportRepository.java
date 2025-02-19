package com.example.fileservice.dao;

import com.example.fileservice.models.FileImportRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileImportRepository extends JpaRepository<FileImportRecord, Integer> {

}
