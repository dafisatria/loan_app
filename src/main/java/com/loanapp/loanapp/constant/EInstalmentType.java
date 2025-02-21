package com.loanapp.loanapp.constant;

import lombok.Getter;

@Getter
public enum EInstalmentType {
    ONE_MONTH("ONE_MONTH"),
    THREE_MONTHS("THREE_MONTHS"),
    SIXTH_MONTHS("SIXTH_MONTHS"),
    NINE_MONTHS("NINE_MONTHS"),
    TWELVE_MONTHS("TWELVE_MONTHS");

    private final String description;
    EInstalmentType(String description){
        this.description=description;
    }

    public static EInstalmentType findByDescription(String description){
        for(EInstalmentType role: values()){
            if (role.description.equalsIgnoreCase(description)){
                return role;
            }
        }
        return null;
    }
}
