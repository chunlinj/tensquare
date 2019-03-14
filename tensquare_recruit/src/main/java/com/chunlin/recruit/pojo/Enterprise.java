package com.chunlin.recruit.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by  HASEE on 2018-12-10
 */
@Entity
@Data
@Table(name="tb_enterprise")
public class Enterprise {
    @Id
    private String id;
    private String name ;
    private String summary ;
    private String address ;
    private String labels;
    private String coordinate;
    private String ishot ;
    private String logo ;
    private Integer jobcount ;
    private String ur;
}
