package com.code.land.nlptools.api.v1;

import com.code.land.nlptools.api.vo.*;
import com.code.land.nlptools.app.services.impl.NlpTransferTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value = "/classifications")
    public ResponseEntity<List<NlpClassificationVO>> listClassifications() {
        return new ResponseEntity(nlpTransferTools.listClassifications(), HttpStatus.OK);
    }


    @GetMapping(value = "/model_type")
    public ResponseEntity<List<ModelTypeVO>> listModelType(@RequestParam String code) {
        return new ResponseEntity(nlpTransferTools.listModelType(code), HttpStatus.OK);
    }

    @PostMapping(value = "/extract_keyword")
    public ResponseEntity<List<String>> importProblem(@RequestParam String content,
                                                      @RequestParam Integer keywordNumber,
                                                      @RequestParam(required = false) String productType) {
        return new ResponseEntity(nlpTransferTools.extractKeyword(content, keywordNumber, productType), HttpStatus.OK);
    }


}
