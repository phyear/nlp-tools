package com.code.land.nlptools.api.vo;

import java.util.List;

/**
 * @author zhaotianxin
 * @date 2022/6/10 11:32
 */
public class NlpClassificationVO {

    private Long id;

    private String name;

    private String code;

    private List<String> modelCode;

    private List<ModelTypeVO> modelTypeVOS;

    public NlpClassificationVO() {
    }

    public NlpClassificationVO(Long id, String name, String code, List<String> modelCodes) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.modelCode = modelCodes;
    }

    public static NlpClassificationVO build(Long id, String name, String code, List<String> modelCodes) {
        return new NlpClassificationVO(id, name, code, modelCodes);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getModelCode() {
        return modelCode;
    }

    public void setModelCode(List<String> modelCode) {
        this.modelCode = modelCode;
    }

    public List<ModelTypeVO> getModelTypeVOS() {
        return modelTypeVOS;
    }

    public void setModelTypeVOS(List<ModelTypeVO> modelTypeVOS) {
        this.modelTypeVOS = modelTypeVOS;
    }
}
