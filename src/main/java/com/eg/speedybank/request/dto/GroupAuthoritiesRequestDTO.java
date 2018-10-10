package com.eg.speedybank.request.dto;

import java.util.List;

public class GroupAuthoritiesRequestDTO {
    private List<Long> userIds;
    private List<Long> authorityIds;

    public List<Long> getUserIds() {
        return userIds;
    }

    public List<Long> getAuthorityIds() {
        return authorityIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

    public void setAuthorityIds(List<Long> authorityIds) {
        this.authorityIds = authorityIds;
    }


}