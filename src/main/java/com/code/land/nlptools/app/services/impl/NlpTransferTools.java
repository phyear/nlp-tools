package com.code.land.nlptools.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import com.code.land.nlptools.api.vo.*;
import com.code.land.nlptools.app.services.*;
import com.code.land.nlptools.infra.enums.*;

/**
 * @author zhaotianxin
 * @date 2022/6/8 16:37
 */
@Component
public class NlpTransferTools {

    private static final List<NlpClassificationVO> nlpClassificationVOS = new ArrayList<>();

    private static final List<ModelTypeVO> modelTypeVOS = new ArrayList<>();


    @Autowired
    private ApplicationContext applicationContext;

    static {
        modelTypeVOS.add(ModelTypeVO.buildModelType(1L, "Hanlp", "hanlp"));

        nlpClassificationVOS.add(NlpClassificationVO.build(1L, "关键词抽取", "extractKeyword", Arrays.asList("hanlp")));
        nlpClassificationVOS.add(NlpClassificationVO.build(2L, "汉字转拼音", "convertToPinyin", Arrays.asList("hanlp")));
        nlpClassificationVOS.add(NlpClassificationVO.build(3L, "提取摘要", "extractSummary", Arrays.asList("hanlp")));

    }

    private NlpService chooseProduct(String type) {
        if (ObjectUtils.isEmpty(type)) {
            type = ProductType.HANLP.getType();
        }
        Map<String, NlpService> productMap = applicationContext.getBeansOfType(NlpService.class);
        return productMap.get(type);
    }

    public List<String> extractKeyword(String content,
                                       Integer keyNumber,
                                       String productType) {
        NlpService nlpService = chooseProduct(productType);
        return nlpService.extractKeyword(content, keyNumber);
    }

    public List<String> extractSummary(String content,
                                       Integer size,
                                       String productType) {
        NlpService nlpService = chooseProduct(productType);
        return nlpService.extractSummary(content, size);
    }

    public String convertToPinyin(String content,
                                  String productType,
                                  boolean remainNone) {
        NlpService nlpService = chooseProduct(productType);
        return nlpService.convertToPinyin(content, remainNone);
    }

    public List<String> extractPeopleName(String content,
                                          String productType) {
        NlpService nlpService = chooseProduct(productType);
        return nlpService.extractPeopleName(content);
    }

    public List<NlpClassificationVO> listClassifications() {
        return nlpClassificationVOS;
    }

    public List<ModelTypeVO> listModelType(String code) {
        Map<String, ModelTypeVO> modelTypeVOMap = modelTypeVOS.stream().collect(Collectors.toMap(ModelTypeVO::getCode, Function.identity()));
        List<ModelTypeVO> modelType = new ArrayList<>();
        for (NlpClassificationVO nlpClassificationVO : nlpClassificationVOS) {
            if (!Objects.equals(nlpClassificationVO, code)) {
                break;
            }
            List<String> modelCode = nlpClassificationVO.getModelCode();
            for (String modelCodeNumber : modelCode) {
                ModelTypeVO modelTypeVO = modelTypeVOMap.get(modelCodeNumber);
                modelType.add(modelTypeVO);
            }
        }
        return modelType;
    }
}
