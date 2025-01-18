package com.algaier.MeterReading.Model;

public class Update {
    private String latestVersion;
    private String downloadUrl;

    public Update() {

    }

    public String getLatestVersion() {
        return latestVersion;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setLatestVersion(String latestVersion) {
        this.latestVersion = latestVersion;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    @Override
    public String toString() {
        return "Update{" +
                "latestVersion='" + latestVersion + '\'' +
                ", downloadUrl='" + downloadUrl + '\'' +
                '}';
    }
}

