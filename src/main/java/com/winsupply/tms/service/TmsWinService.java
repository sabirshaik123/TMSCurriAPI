package com.winsupply.tms.service;

import com.winsupply.tms.contracts.GetQuoteRequestBody;
import com.winsupply.tms.contracts.GetQuoteResponseBody;
import com.winsupply.tms.curri.service.CurriClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TmsWinService {

    private TmsClientService getClientSevice(String appName){
        TmsClientService tmsClientService = null;
        switch (appName){
            case "curri":
                tmsClientService = new CurriClientService();
                break;
            case "uber":
                break;
        }
        return tmsClientService;
    }

    public List<GetQuoteResponseBody> getDeliveryQuote(String appName, GetQuoteRequestBody requestBody) {
        TmsClientService tmsClientService = getClientSevice(appName);
        if(tmsClientService == null){
            // TODO Exception
            return null;
        }else{
            return tmsClientService.getDeliveryQuote(requestBody);
        }
    }



}