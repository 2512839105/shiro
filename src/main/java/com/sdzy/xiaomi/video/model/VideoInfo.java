package com.sdzy.xiaomi.video.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author charlin
 * @since 2018-07-17
 */
@TableName("videoInfo")
public class VideoInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("videoId")
    private String videoId;
    /**
     * 标题
     */
    private String title;
    private String category;
    private Integer sort;
    
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	private String storeType;
	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}
	/**
     * 简介
     */
    private String introduc;
    /**
     * 链接
     */
    private String link;
    /**
     * 上传时间
     */
    @TableField("uploadDate")
    private Date uploadDate;
    /**
     * 是否可观看 0否 1是
     */
    private Integer status;


    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduc() {
        return introduc;
    }

    public void setIntroduc(String introduc) {
        this.introduc = introduc;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "VideoInfo{" +
        ", videoId=" + videoId +
        ", title=" + title +
        ", introduc=" + introduc +
        ", category="+ category+
        ", sort="+sort+
        ", link=" + link +
        ", uploadDate=" + uploadDate +
        ", status=" + status +
        "}";
    }
}
