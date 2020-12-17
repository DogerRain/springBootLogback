package com.yudianxx.springBootDemo.controller;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.tiia.v20190529.TiiaClient;
import com.tencentcloudapi.tiia.v20190529.models.ImageModerationResponse;
import com.yudianxx.springBootDemo.model.User;
import com.yudianxx.springBootDemo.model.image.Image;
import com.yudianxx.springBootDemo.model.image.ImageCollection;
import com.yudianxx.springBootDemo.model.image.Model;
import com.yudianxx.springBootDemo.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/image")
@Slf4j
public class ImageController {


    @Autowired
    ImageService imageService;

    @RequestMapping("/upload")
    public void handle(@RequestBody User user) {
        log.info("进入");
//        go("E:\\projet\\springBootLogback");
        String FileUrl = "T:\\meitulu";
//        String FileUrl = "G:\\python_workplace\\meitulu\\meitulu\\COSER\\1";
//        go(FileUrl);
    }

    public void go(String fileSrc) {
        File f1 = new File(fileSrc);

        if (f1.isFile()) {
            upload(f1);
        }

        File[] fs1 = f1.listFiles();//列出所有文件和子目录

        for (File file : fs1) {
            if (file.isDirectory()) {
                go(file + "");
            }
            if (file.isFile()) {
                upload(file);
            }
        }
    }

    private void upload(File file) {
//                文件名称
        String fileName = file.getName();
        //                集合
        String colletionName = file.getParent().substring((file.getParent().lastIndexOf("\\") + 1));
//                名字
        String modelName = file.getParentFile().getParent().substring((file.getParentFile().getParent().lastIndexOf("\\") + 1));
        //上传到腾讯云
//        String url = "1";
        log.info("当前模特名字：{},图集：{}.图片，名称：{}", modelName, colletionName, fileName);
        String url = uploadFileToCloud(file + "");
        log.info("图片上传到腾讯云成功，路径：{}", url);
        if (StringUtils.isNotBlank(url)) {
            //腾讯云鉴黄
//            String suggestion = "PASS";
            String suggestion = porn(url);
            log.info("鉴黄成功，返回结果：{}", suggestion);

            //                    写库
//                    1.模特名
            String modelId = imageService.findModelIdByName(modelName);
            if (StringUtils.isBlank(modelId)) {
                Model model = Model.builder().name(modelName).build();
                imageService.insertModel(model);
                modelId = imageService.findModelIdByName(modelName);
            }
//                    2.集合
            String collectionId = imageService.findCollectionIdByCollectioonName(colletionName);
            if (StringUtils.isBlank(collectionId)) {
                ImageCollection collection = ImageCollection.builder()
                        .name(colletionName)
                        .build();
                imageService.insertCollection(collection);
                collectionId = imageService.findCollectionIdByCollectioonName(colletionName);
            }
//                    3. 图片
            //先查id，真的是sb设计了....

            Image image = Image.builder()
                    .title(fileName)
                    .collection(collectionId)
                    .modelId(modelId)
                    .imageLink(url)
                    .suggestion(suggestion)
                    .status("1")
                    .createTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                    .category("1")
                    .build();
            imageService.insertImage(image);
        }

    }

    public String uploadFileToCloud(String file) {
        String secretId = "AKIDfFfPtqiBUaTBoA5Cva2av97pIacUl0qS";
        String secretKey = "b2Lgz9LAwdClEj3CF7tTo8E5FRSHrWx8";
        try {
            COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
            Region region = new Region("ap-guangzhou");
            ClientConfig clientConfig = new ClientConfig(region);
            COSClient cosClient = new COSClient(cred, clientConfig);
            File uploadFile = new File(file);
            String bucketName = "images-1253198264";
            String key = new Date().getTime() + "";
            key += file.substring(file.lastIndexOf("."));
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, uploadFile);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            System.out.println("putObjectResult+");
//            腾讯云外链
            String url = "https://images-1253198264.cos.ap-guangzhou.myqcloud.com/";
            url = url + key;
            return url;
        } catch (CosServiceException serverException) {
            serverException.printStackTrace();
        } catch (CosClientException clientException) {
            clientException.printStackTrace();
        }
        return null;
    }

    public String porn(String fileUrl) {

        try {
            Credential cred = new Credential("AKIDfFfPtqiBUaTBoA5Cva2av97pIacUl0qS", "b2Lgz9LAwdClEj3CF7tTo8E5FRSHrWx8");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("tiia.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            TiiaClient client = new TiiaClient(cred, "ap-guangzhou", clientProfile);
//            String params = "{\"Scenes\":[\"PORN\"],\"ImageUrl\":\"https://images-1253198264.cos.ap-guangzhou.myqcloud.com/1576746760049.png\"}";
            String params = "{\"Scenes\":[\"PORN\"],\"ImageUrl\":\"" + fileUrl + "\"}";
            com.tencentcloudapi.tiia.v20190529.models.ImageModerationRequest req = com.tencentcloudapi.tiia.v20190529.models.ImageModerationRequest.fromJsonString(params, com.tencentcloudapi.tiia.v20190529.models.ImageModerationRequest.class);
            ImageModerationResponse resp = client.ImageModeration(req);
            String suggestion = resp.getSuggestion();
            return suggestion;
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
        return null;
    }

}
