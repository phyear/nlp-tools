package com.code.land.nlptools.app.services.impl;

import com.code.land.nlptools.app.services.NlpService;
import com.hankcs.hanlp.HanLP;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaotianxin
 * @date 2022/5/28 21:30
 */
@Service("hanlp")
public class HanlpServiceImpl implements NlpService {


    @Override
    public List<String> extractKeyword(String content, Integer keyNumber) {
        return HanLP.extractKeyword(content, keyNumber);
    }

    @Override
    public List<String> extractSummary(String content, Integer size) {
        return HanLP.extractSummary(content, size);
    }
}
