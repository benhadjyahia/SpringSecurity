package com.example.demo.Playload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class mediaResponse {
    private String fileName;
    private String downloadURL;
    private String fileType;
    private long fileSize;
}
