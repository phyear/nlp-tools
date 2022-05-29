package com.code.land.nlptools.app.services;

import java.util.List;

/**
 * @author zhaotianxin
 * @date 2022/5/28 21:29
 */
public interface HanlpService {

    List<String> extractKeyword(String content, Integer keyNumber);
}
