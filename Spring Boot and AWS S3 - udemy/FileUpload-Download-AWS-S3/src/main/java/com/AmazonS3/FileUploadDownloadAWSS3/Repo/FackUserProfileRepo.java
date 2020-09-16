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
        userProfileList.add(new UserProfile(UUID.fromString("b1aea7be-a0c7-44fd-b5c4-a4a97e55b6da"),"Nilesh_Kadam",null));
        userProfileList.add(new UserProfile(UUID.fromString("fdd957ea-3379-4c1a-849f-8e74021b50da"),"Harshu_Kadam",null));
    }

    public List<UserProfile> getUserProfiles(){
        return userProfileList;
    }
}
