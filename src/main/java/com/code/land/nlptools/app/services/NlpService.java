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
     *
     * @param content
     * @param keyNumber
     * @return
     */
    default List<String> extractKeyword(String content, Integer keyNumber) {
        return new ArrayList<>();
    }

    /**
     * 抽取摘要
     *
     * @param content
     * @param size
     * @return
     */
    default List<String> extractSummary(String content, Integer size) {
        return new ArrayList<>();
    }

    /**
     * 汉字转拼音
     * @param content
     * @param remainNone 碰到不能转换的字符是否保留原字符 true 显示none false 原文显示
     * @return
     */
    default String convertToPinyin(String content, boolean remainNone) {return null; }

    /**
     * 抽取人名
     * @param content
     * @return
     */
    default List<String> extractPeopleName(String content) {return  new ArrayList<>(); }
}
