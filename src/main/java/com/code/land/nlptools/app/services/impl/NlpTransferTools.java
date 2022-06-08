package com.code.land.nlptools.app.services.impl;

import com.code.land.nlptools.app.services.NlpService;
import com.code.land.nlptools.infra.enums.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;

/**
 * @author zhaotianxin
 * @date 2022/6/8 16:37
 */
@Component
public class NlpTransferTools {

    @Autowired
    private ApplicationContext applicationContext;

    private NlpService chooseProduct(String type) {
        if (ObjectUtils.isEmpty(type)) {
            type = ProductType.HANLP.getType();
        }
        Map<String, NlpService> productMap = applicationContext.getBeansOfType(NlpService.class);
        return productMap.get(type);
    }

    public List<String> extractKeyword(String content, Integer keyNumber, String productType) {
        NlpService nlpService = chooseProduct(productType);
        return nlpService.extractKeyword(content, keyNumber);
    }

    public List<String> extractSummary(String content, Integer size, String productType) {
        NlpService nlpService = chooseProduct(productType);
        return nlpService.extractSummary(content, size);
    }
}
