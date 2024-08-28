package com.stickynotes.sticky.note.dto;


public class StickyNoteDto {
    private int id;

    private String title;

    private String bgColor;

    private String positionX;

    private String positionY;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getPositionX() {
        return positionX;
    }

    public void setPositionX(String positionX) {
        this.positionX = positionX;
    }

    public String getPositionY() {
        return positionY;
    }

    public void setPositionY(String positionY) {
        this.positionY = positionY;
    }

    public StickyNoteDto(String title, Integer id, String positionX, String positionY, String bgColor) {
        this.title = title;
        this.id = id;
        this.positionX = positionX;
        this.positionY = positionY;
        this.bgColor = bgColor;
    }
}
