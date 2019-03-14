package com.imooc.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


/**
 * 类目
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory {
    //类目id
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer categoryId;
    //类目名字
    private String categoryName;
    //类目编号
    private Integer categoryType;
    //创建时间
    private Date createTime = new Date();
    //修改时间
    private Date updateTime = new Date();

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public ProductCategory() {

    }
    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
