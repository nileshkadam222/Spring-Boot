package com.AmazonS3.FileUploadDownloadAWSS3.profile;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class UserProfile {

    private UUID userProfileId;
    private String username;
    private String userPofileImageLink;

    public UserProfile(UUID userProfileId, String username, String userPofileImageLink) {
        this.userProfileId = userProfileId;
        this.username = username;
        this.userPofileImageLink = userPofileImageLink;
    }

    public UUID getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(UUID userProfileId) {
        this.userProfileId = userProfileId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Optional<String> getUserPofileImageLink() {
        return Optional.ofNullable(userPofileImageLink);
    }

    public void setUserPofileImageLink(String userPofileImageLink) {
        this.userPofileImageLink = userPofileImageLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(userProfileId,that.userProfileId) &&
                Objects.equals(username,that.username) &&
                Objects.equals(userPofileImageLink,that.userPofileImageLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userProfileId, username, userPofileImageLink);
    }
}
