package com.revature.models;

import java.util.Objects;

public class ReimbursementStatus {
    private int statusId;
    private String reimbStatus;

    public ReimbursementStatus() {
    }

    public ReimbursementStatus(int statusId, String reimbStatus) {
        this.statusId = statusId;
        this.reimbStatus = reimbStatus;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getReimbStatus() {
        return reimbStatus;
    }

    public void setReimbStatus(String reimbStatus) {
        this.reimbStatus = reimbStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReimbursementStatus)) return false;
        ReimbursementStatus that = (ReimbursementStatus) o;
        return getStatusId() == that.getStatusId() && Objects.equals(getReimbStatus(), that.getReimbStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatusId(), getReimbStatus());
    }

    @Override
    public String toString() {
        return "ReimbursementStatus{" +
                "statusId=" + statusId +
                ", reimbStatus='" + reimbStatus + '\'' +
                '}';
    }
}
