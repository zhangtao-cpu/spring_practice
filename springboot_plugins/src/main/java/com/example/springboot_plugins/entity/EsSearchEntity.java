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
 * @Description 操作es的实体类 注意indexName为索引名称，为属性title制定了分词器
 * @Author zhangtao
 * @Date 2024/6/28 18:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(indexName = "es_search")
public class EsSearchEntity implements Serializable {
    @Id
    private Long id;

    @Field(name="data_id",type = FieldType.Text)
    private String dataId;
    @Field(name="title", searchAnalyzer = "ik_smart", analyzer = "ik_max_word",type = FieldType.Text)
    private String title;
    @Field(name="type",type = FieldType.Keyword)
    private String type;
    @Field(name="en_type",type = FieldType.Keyword)
    private String enType;
    @Field(name="cus_number",type = FieldType.Keyword)
    private String cusNumber;
}
