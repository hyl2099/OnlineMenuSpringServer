package com.lisa.onlineMenu.documents.menu;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String path;    // 路径
    private Date uploadTime;
    //@Lob 通常与@Basic同时使用，提高访问速度
    //实际上是存储了路径，然后从路径读取byte文件返回到前段，没有用到。
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name=" photo", columnDefinition="longblob", nullable=true)
    private byte[] photo;
    private String image;
    private String remark;

    public Picture(String path, Date uploadTime, byte[] photo, String image, String remark) {
        this.path = path;
        this.uploadTime = uploadTime;
        this.photo = photo;
        this.image = image;
        this.remark = remark;
    }

    public Picture(Picture p) {
        this.path = p.path;
        this.uploadTime = p.uploadTime;
        this.photo = p.photo;
        this.image = p.image;
        this.remark = p.remark;
    }

    public Picture() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
