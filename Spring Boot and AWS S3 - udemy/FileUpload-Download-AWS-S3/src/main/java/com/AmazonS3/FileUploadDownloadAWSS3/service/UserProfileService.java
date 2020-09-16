package com.AmazonS3.FileUploadDownloadAWSS3.service;

import com.AmazonS3.FileUploadDownloadAWSS3.Repo.FackUserProfileRepo;
import com.AmazonS3.FileUploadDownloadAWSS3.config.AmazonConfiguration;
import com.AmazonS3.FileUploadDownloadAWSS3.profile.UserProfile;
import com.amazonaws.services.dynamodbv2.xspec.S;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.DataTruncation;
import java.text.Format;
import java.util.*;

@Service
public class UserProfileService {
    @Autowired
    private FackUserProfileRepo fackUserProfileRepo;

    @Autowired
    AmazonConfiguration amazonConfiguration;

    @Autowired
    FileStore fileStore;

    public List<UserProfile> getUsers(){
        return fackUserProfileRepo.getUserProfiles();
    }

    public void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {
        if(file.isEmpty()){
            throw new IllegalStateException("Can not upload Empty File ["+file.getName() +":"+file.getSize()+"]");
        }

        UserProfile user = getUserProfileByProfileId(userProfileId);

        Map<String,String> metaData = new HashMap<>();
        metaData.put("Content-type",file.getContentType());
        metaData.put("Content-Length",String.valueOf(file.getSize()));
        String path = String.format("%s/%s",amazonConfiguration.getS3Value("BucketName"),userProfileId);
        String fileName = String.format("%s-%s",file.getName(),UUID.randomUUID());

        try {
            fileStore.save(path,fileName, Optional.of(metaData),file.getInputStream());
            user.setUserPofileImageLink(fileName);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private UserProfile getUserProfileByProfileId(UUID userProfileId){
        UserProfile user = getUsers().stream()
                .filter(userPro -> userPro.getUserProfileId().equals(userProfileId))
                .findFirst()
                .orElseThrow(() ->new IllegalStateException("user profile not found"));
        return user;
    }

    public byte[] downloadUserProfileFile(UUID userProfileId) {
        UserProfile user = getUserProfileByProfileId(userProfileId);
        String path = String.format("%s/%s",amazonConfiguration.getS3Value("BucketName"),userProfileId);
        return user.getUserPofileImageLink().map(key -> fileStore.download(path,key)).orElse(new byte[0]);
    }
}
