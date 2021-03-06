package com.AmazonS3.FileUploadDownloadAWSS3.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

@Service
public class FileStore {
    @Autowired
    AmazonS3 s3;

    public void save(String path, String fileName, Optional<Map<String,String >> optionalMetaData, InputStream inputStream){
        ObjectMetadata metadata = new ObjectMetadata();
        optionalMetaData.ifPresent(map->{
            if(!map.isEmpty()){
                map.forEach(metadata::addUserMetadata);
            }
        });
        try {
            s3.putObject(path, fileName, inputStream, metadata);
        }catch (AmazonServiceException ex){
            throw  new IllegalStateException("Failed to Store File In s3",ex);
        }

    }

    public byte[] download(String fullPath,String key) {
        S3Object object =s3.getObject(fullPath,key);
        S3ObjectInputStream inputStream = object.getObjectContent();
        try {
            return IOUtils.toByteArray(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
