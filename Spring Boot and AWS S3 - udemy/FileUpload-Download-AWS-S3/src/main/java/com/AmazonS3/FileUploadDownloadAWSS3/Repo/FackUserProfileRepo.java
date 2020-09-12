package com.AmazonS3.FileUploadDownloadAWSS3.Repo;

import com.AmazonS3.FileUploadDownloadAWSS3.profile.UserProfile;
import com.amazonaws.services.dynamodbv2.xspec.S;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FackUserProfileRepo {
    private static  final List<UserProfile> userProfileList = new ArrayList<>();

    static {
        userProfileList.add(new UserProfile(UUID.randomUUID(),"Nilesh_Kadam",null));
        userProfileList.add(new UserProfile(UUID.randomUUID(),"Harshu_Kadam",null));
    }

    private List<UserProfile> getUserProfiles(){
        return userProfileList;
    }
}
