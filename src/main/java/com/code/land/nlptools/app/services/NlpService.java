package com.code.land.nlptools.app.services;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaotianxin
 * @date 2022/5/28 21:29
 */
public interface NlpService {

    /**
     * 抽取关键字
     * @param content
     * @param keyNumber
     * @return
     */
    default List<String> extractKeyword(String content, Integer keyNumber) {
        return new ArrayList<>();
    }

    /**
     * 抽取摘要
     * @param content
     * @param size
     * @return
     */
    default List<String> extractSummary(String content, Integer size) {
        return new ArrayList<>();
    }
}
