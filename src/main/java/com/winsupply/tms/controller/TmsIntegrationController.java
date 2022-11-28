package com.winsupply.tms.controller;

import com.winsupply.tms.contracts.GetQuoteRequestBody;
import com.winsupply.tms.contracts.GetQuoteResponseBody;
import com.winsupply.tms.curri.model.CurriGetQuoteRequest;
import com.winsupply.tms.service.TmsService;
import com.winsupply.tms.service.TmsWinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TmsIntegrationController {

    @Autowired
    TmsService tmsService;

    @Autowired
    TmsWinService tmsWinService;

    @PostMapping("/getDeliveryQuote")
    public List<GetQuoteResponseBody> getDeliveryQuote(@RequestParam String appName,
                                                       @RequestBody GetQuoteRequestBody requestBody){
        return tmsWinService.getDeliveryQuote(appName, requestBody);
    }

    @PostMapping("/getDeliveryQuotes")
    public String getDeliveryQuotes(@RequestBody CurriGetQuoteRequest data){
        return tmsService.getDeliveryOptions(data);
    }
}
