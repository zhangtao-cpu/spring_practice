package com.example.springboot_plugins.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @Description
 * @Author zhangtao
 * @Date 2024/6/28 18:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(indexName = "idx_person")
public class EsIdxPersonEntity implements Serializable {

    @Id
    private String id;
    /**
     * 人员ID
     */
    @Field(name="person_id",type = FieldType.Text)
    private String personId;


    /**
     * 人员编号
     */
    @Field(name="person_no",type = FieldType.Text)
    private String personNo;

    @Field(name="person_name", searchAnalyzer = "search_pinyin_analyzer", analyzer = "pinyin_analyzer",type = FieldType.Text)
    private String personName;

    @Field(name="id_card",type = FieldType.Text)
    private String idCard;

    /**
     * 人员类型
     */
    @Field(name="person_type",type = FieldType.Integer)
    private Integer personType;

    @Field(name="cus_number",type = FieldType.Text)
    private String cusNumber;

}

