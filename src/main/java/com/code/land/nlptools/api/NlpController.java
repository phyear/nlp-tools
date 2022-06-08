package com.code.land.nlptools.api;

import com.code.land.nlptools.app.services.impl.NlpTransferTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zhaotianxin
 * @date 2022/5/28 21:27
 */
@Controller
@RequestMapping("/v1/nlp")
public class NlpController {

    @Autowired
    private NlpTransferTools nlpTransferTools;

    @PostMapping(value = "/extract_keyword")
    public ResponseEntity<List<String>> importProblem(@RequestParam String content,
                                                      @RequestParam Integer keywordNumber,
                                                      @RequestParam(required = false) String productType) {
        return new ResponseEntity(nlpTransferTools.extractKeyword(content, keywordNumber, productType), HttpStatus.OK);
    }
}
