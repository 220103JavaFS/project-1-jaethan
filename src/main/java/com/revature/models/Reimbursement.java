package com.revature.models;

import java.util.Arrays;
import java.util.Objects;

public class Reimbursement {
    private int reimbId;
    private int reimbAmount;
    private long reimbSubmitted;
    private long reimbResolved;
    private String reimbDescription;
    private byte[] reimbReceipt;
    private Users reimbAuthor;
    private Users reimbResolver;
    private ReimbursementStatus reimbStatusId;
    private ReimbursementType reimbTypeId;

    public Reimbursement() {
    }

    public Reimbursement(int reimbId, int reimbAmount, long reimbSubmitted, long reimbResolved, String reimbDescription, byte[] reimbReceipt, Users reimbAuthor, Users reimbResolver, ReimbursementStatus reimbStatusId, ReimbursementType reimbTypeId) {
        this.reimbId = reimbId;
        this.reimbAmount = reimbAmount;
        this.reimbSubmitted = reimbSubmitted;
        this.reimbResolved = reimbResolved;
        this.reimbDescription = reimbDescription;
        this.reimbReceipt = reimbReceipt;
        this.reimbAuthor = reimbAuthor;
        this.reimbResolver = reimbResolver;
        this.reimbStatusId = reimbStatusId;
        this.reimbTypeId = reimbTypeId;
    }

    public int getReimbId() {
        return reimbId;
    }

    public void setReimbId(int reimbId) {
        this.reimbId = reimbId;
    }

    public int getReimbAmount() {
        return reimbAmount;
    }

    public void setReimbAmount(int reimbAmount) {
        this.reimbAmount = reimbAmount;
    }

    public long getReimbSubmitted() {
        return reimbSubmitted;
    }

    public void setReimbSubmitted(long reimbSubmitted) {
        this.reimbSubmitted = reimbSubmitted;
    }

    public long getReimbResolved() {
        return reimbResolved;
    }

    public void setReimbResolved(long reimbResolved) {
        this.reimbResolved = reimbResolved;
    }

    public String getReimbDescription() {
        return reimbDescription;
    }

    public void setReimbDescription(String reimbDescription) {
        this.reimbDescription = reimbDescription;
    }

    public byte[] getReimbReceipt() {
        return reimbReceipt;
    }

    public void setReimbReceipt(byte[] reimbReceipt) {
        this.reimbReceipt = reimbReceipt;
    }

    public Users getReimbAuthor() {
        return reimbAuthor;
    }

    public void setReimbAuthor(Users reimbAuthor) {
        this.reimbAuthor = reimbAuthor;
    }

    public Users getReimbResolver() {
        return reimbResolver;
    }

    public void setReimbResolver(Users reimbResolver) {
        this.reimbResolver = reimbResolver;
    }

    public ReimbursementStatus getReimbStatusId() {
        return reimbStatusId;
    }

    public void setReimbStatusId(ReimbursementStatus reimbStatusId) {
        this.reimbStatusId = reimbStatusId;
    }

    public ReimbursementType getReimbTypeId() {
        return reimbTypeId;
    }

    public void setReimbTypeId(ReimbursementType reimbTypeId) {
        this.reimbTypeId = reimbTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reimbursement)) return false;
        Reimbursement that = (Reimbursement) o;
        return getReimbId() == that.getReimbId() && getReimbAmount() == that.getReimbAmount() && getReimbSubmitted() == that.getReimbSubmitted() && getReimbResolved() == that.getReimbResolved() && Objects.equals(getReimbDescription(), that.getReimbDescription()) && Arrays.equals(getReimbReceipt(), that.getReimbReceipt()) && Objects.equals(getReimbAuthor(), that.getReimbAuthor()) && Objects.equals(getReimbResolver(), that.getReimbResolver()) && Objects.equals(getReimbStatusId(), that.getReimbStatusId()) && Objects.equals(getReimbTypeId(), that.getReimbTypeId());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getReimbId(), getReimbAmount(), getReimbSubmitted(), getReimbResolved(), getReimbDescription(), getReimbAuthor(), getReimbResolver(), getReimbStatusId(), getReimbTypeId());
        result = 31 * result + Arrays.hashCode(getReimbReceipt());
        return result;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbId=" + reimbId +
                ", reimbAmount=" + reimbAmount +
                ", reimbSubmitted=" + reimbSubmitted +
                ", reimbResolved=" + reimbResolved +
                ", reimbDescription='" + reimbDescription + '\'' +
                ", reimbReceipt=" + Arrays.toString(reimbReceipt) +
                ", reimbAuthor=" + reimbAuthor +
                ", reimbResolver=" + reimbResolver +
                ", reimbStatusId=" + reimbStatusId +
                ", reimbTypeId=" + reimbTypeId +
                '}';
    }
}