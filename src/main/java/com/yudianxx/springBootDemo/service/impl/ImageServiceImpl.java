package com.yudianxx.springBootDemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yudianxx.springBootDemo.mapper.image.CollectiomMapper;
import com.yudianxx.springBootDemo.mapper.image.ImageHandleMapper;
import com.yudianxx.springBootDemo.mapper.image.ModelMapper;
import com.yudianxx.springBootDemo.model.image.Image;
import com.yudianxx.springBootDemo.model.image.ImageCollection;
import com.yudianxx.springBootDemo.model.image.Model;
import com.yudianxx.springBootDemo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageHandleMapper imageHandleMapper;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CollectiomMapper collectiomMapper;


    @Override
    public String findModelIdByName(String name) {
        Model model = modelMapper.selectOne(new QueryWrapper<Model>().eq("name", name));
        if (model == null) {
            return null;
        }
        return model.getId() + "";
    }

    @Override
    public void insertModel(Model model) {
        modelMapper.insert(model);
    }

    @Override
    public String findCollectionIdByCollectioonName(String collectionName) {
        ImageCollection collection = collectiomMapper.selectOne(new LambdaQueryWrapper<ImageCollection>().eq(ImageCollection::getName, collectionName));
        if (collection == null) {
            return null;
        }
        return collection.getId() + "";
    }

    @Override
    public void insertCollection(ImageCollection collection) {
        collectiomMapper.insert(collection);
    }

    @Override
    public void insertImage(Image image) {
        imageHandleMapper.insert(image);
    }
}
