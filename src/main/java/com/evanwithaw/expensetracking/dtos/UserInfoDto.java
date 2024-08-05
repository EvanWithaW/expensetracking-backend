package com.evanwithaw.expensetracking.dtos;

public class UserInfoDto {

        private String name;

        public UserInfoDto(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
}
