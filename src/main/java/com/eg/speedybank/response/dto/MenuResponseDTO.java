package com.eg.speedybank.response.dto;

public class MenuResponseDTO {
    private String menuName;
    private String menuUrl;

    public MenuResponseDTO(String menuName, String menuUrl) {
        this.menuName = menuName;
        this.menuUrl = menuUrl;
    }

    public String getMenuName() {return menuName;}
    public void setMenuName(String menuName) {this.menuName = menuName;}
    public String getMenuUrl() {return menuUrl;}
    public void setMenuUrl(String menuUrl) {this.menuUrl = menuUrl;}
}
