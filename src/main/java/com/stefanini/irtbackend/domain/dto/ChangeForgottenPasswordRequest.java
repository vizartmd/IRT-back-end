package com.stefanini.irtbackend.domain.dto;

public class ChangeForgottenPasswordRequest {
    private String email;
    private String verificationCode;
    private String newPassword;
    private String newPasswordConfirmation;

    public ChangeForgottenPasswordRequest(String email, String verificationCode, String newPassword, String newPasswordConfirmation) {
        this.email = email;
        this.verificationCode = verificationCode;
        this.newPassword = newPassword;
        this.newPasswordConfirmation = newPasswordConfirmation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
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
