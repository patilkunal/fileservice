package com.example.fileservice.controller;

import com.example.fileservice.models.FileImportRecord;
import com.example.fileservice.service.FileImportService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;

@RestController
@AllArgsConstructor
public class FileImportController {

    private final FileImportService fileImportService;

    @PostMapping("/import/{filetype}")
    public String importFile(@PathVariable("filetype") String filetype, MultipartFile file) throws IOException {
        FileImportRecord rec = new FileImportRecord();
        rec.setFilename(file.getOriginalFilename());
        rec.setFiletype(filetype);
        rec.setFilecontent(file.getBytes());
        fileImportService.saveImportRecord(rec);
        return "SUCCESS";
    }

    @GetMapping(path = "/export/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE )
    public @ResponseBody byte[] exportFile(@PathVariable("id") int id) throws IOException {
        FileImportRecord rec = fileImportService.getImportRecord(id);
        return rec.getFilecontent();
    }

    @GetMapping(path = "/export2/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE )
    public ResponseEntity<InputStreamResource> export2File(@PathVariable("id") int id) throws IOException {
        FileImportRecord rec = fileImportService.getImportRecord(id);
        InputStreamResource in = new InputStreamResource(new ByteArrayResource(rec.getFilecontent()));
        return ResponseEntity.ok(in);
    }

}
