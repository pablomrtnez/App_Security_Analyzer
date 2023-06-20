package com.example.appsecurityanalyzer.dto;

public class AppInfo {
    private String packageName;
    private String securityInfo;

    public AppInfo(String packageName, String securityInfo) {
        this.packageName = packageName;
        this.securityInfo = securityInfo;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getSecurityInfo() {
        return securityInfo;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setSecurityInfo(String securityInfo) {
        this.securityInfo = securityInfo;
    }
}
