package com.code.land.nlptools.infra.enums;

/**
 * @author zhaotianxin
 * @date 2022/6/8 16:47
 */
public enum ProductType {
    HANLP("hanlp");

    private String type;

    ProductType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
