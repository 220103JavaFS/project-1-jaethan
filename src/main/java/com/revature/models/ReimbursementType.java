package com.revature.models;

import java.util.Objects;

public class ReimbursementType {
    private int typeId;
    private String reimbType;

    public ReimbursementType() {
    }

    public ReimbursementType(int typeId, String reimbType) {
        this.typeId = typeId;
        this.reimbType = reimbType;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getReimbType() {
        return reimbType;
    }

    public void setReimbType(String reimbType) {
        this.reimbType = reimbType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReimbursementType)) return false;
        ReimbursementType that = (ReimbursementType) o;
        return getTypeId() == that.getTypeId() && Objects.equals(getReimbType(), that.getReimbType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTypeId(), getReimbType());
    }

    @Override
    public String toString() {
        return "ReimbursementType{" +
                "typeId=" + typeId +
                ", reimbType='" + reimbType + '\'' +
                '}';
    }
}
