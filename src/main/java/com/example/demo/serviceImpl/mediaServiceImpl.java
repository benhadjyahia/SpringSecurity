package com.example.demo.serviceImpl;

import com.example.demo.Repository.mediaRepository;
import com.example.demo.entities.Media;
import com.example.demo.service.IMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class mediaServiceImpl implements IMediaService {
    @Autowired
    mediaRepository imagenRepository;
    @Override
    public List<Media> list(){
        return imagenRepository.findByOrderById();
    }
    @Override
    public Optional<Media> getOne(int id){
        return imagenRepository.findById(id);
    }
    @Override
    public void save(Media imagen){
        imagenRepository.save(imagen);
    }
    @Override
    public void delete(int id){
        imagenRepository.deleteById(id);
    }
    @Override
    public boolean exists(int id){
        return imagenRepository.existsById(id);
    }
}

