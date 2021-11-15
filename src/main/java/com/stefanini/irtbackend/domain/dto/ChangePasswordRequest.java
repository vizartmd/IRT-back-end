package com.stefanini.irtbackend.domain.dto;

public class ChangePasswordRequest {
    private String newPassword;
    private String newPasswordConfirmation;

    public ChangePasswordRequest(String newPassword, String newPasswordConfirmation) {
        this.newPassword = newPassword;
        this.newPasswordConfirmation = newPasswordConfirmation;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPasswordConfirmation() {
        return newPasswordConfirmation;
    }

    public void setNewPasswordConfirmation(String newPasswordConfirmation) {
        this.newPasswordConfirmation = newPasswordConfirmation;
    }
}
