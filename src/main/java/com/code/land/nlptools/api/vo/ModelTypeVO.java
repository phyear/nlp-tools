package com.code.land.nlptools.api.vo;

/**
 * @author zhaotianxin
 * @date 2022/6/10 11:29
 */
public class ModelTypeVO {

    private Long id;

    private String code;

    private String name;

    public ModelTypeVO() {
    }

    public ModelTypeVO(Long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public static ModelTypeVO buildModelType(Long id, String name, String code) {
        return new ModelTypeVO(id, name, code);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
