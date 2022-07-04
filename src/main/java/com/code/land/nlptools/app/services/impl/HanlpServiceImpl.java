package com.code.land.nlptools.app.services.impl;

import com.code.land.nlptools.app.services.NlpService;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.seg.common.Term;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public String convertToPinyin(String content, boolean remainNone) {
        return HanLP.convertToPinyinString(content, "", remainNone);
    }

    @Override
    public List<String> extractPeopleName(String content) {
        Nature nameNature = Nature.fromString("nr");
        List<Term> seg = HanLP.newSegment().enableNameRecognize(true).seg(content);
        List<String> result = new ArrayList<>();
        for (Term term : seg) {
            if (nameNature == term.nature) {
                result.add(term.word);
            }
        }
        return result;
    }
}
