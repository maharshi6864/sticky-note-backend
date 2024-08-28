package com.stickynotes.sticky.note.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sticky_note_vo")
public class StickyNoteVo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "bgColor")
    private String bgColor;

    @Column(name = "positionX")
    private String positionX;

    @Column(name = "positionY")
    private String positionY;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
