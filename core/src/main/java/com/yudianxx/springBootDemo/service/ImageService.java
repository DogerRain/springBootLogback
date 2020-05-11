package com.yudianxx.springBootDemo.service;

import com.yudianxx.springBootDemo.model.image.Image;
import com.yudianxx.springBootDemo.model.image.ImageCollection;
import com.yudianxx.springBootDemo.model.image.Model;

public interface ImageService {

   String findModelIdByName(String name);

   void insertModel(Model model);

   String findCollectionIdByCollectioonName(String collectionId);

   void insertCollection(ImageCollection collection);

   void insertImage(Image image);

}
