package com.example.fileservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "fileimportqueue")
public class FileImportRecord {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "filename")
    private String filename;
    @Column(name = "filetype")
    private String filetype;
    @Column(name = "filecontent")
    private byte[] filecontent;
    @Column(name = "created_dt")
    private Date createdDate;

}
