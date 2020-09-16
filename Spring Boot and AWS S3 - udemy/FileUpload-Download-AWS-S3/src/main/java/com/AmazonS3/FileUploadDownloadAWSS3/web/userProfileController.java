package com.AmazonS3.FileUploadDownloadAWSS3.web;

import com.AmazonS3.FileUploadDownloadAWSS3.profile.UserProfile;
import com.AmazonS3.FileUploadDownloadAWSS3.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/user-profile")
public class userProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping
    public List<UserProfile> getUsersProfile(){
        return userProfileService.getUsers();
    }

    @PostMapping(
            path = "{userProfileId}/image/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void  uploadUserProfileImage(@PathVariable("userProfileId") UUID userProfileId, @RequestParam("file")MultipartFile file){
        userProfileService.uploadUserProfileImage(userProfileId,file);
    }

    @GetMapping("{userProfileId}/image/download")
    public byte[] downloadUserProfile(@PathVariable("userProfileId")UUID userProfileId){
        return userProfileService.downloadUserProfileFile(userProfileId);
    }
}

