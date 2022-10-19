package com.example.demo.service;

import com.example.demo.entities.Media;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface IMediaService {
    public List<Media> list();

    public Optional<Media> getOne(int id);
    public void save(Media imagen);
    public void delete(int id);
    public boolean exists(int id);
}
