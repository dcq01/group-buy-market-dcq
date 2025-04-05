package org.example.api.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SettlementMarketPayOrderRequestDTO {

    private String source;
    private String channel;
    private String userId;
    private String outTradeNo;
    private Date outTradeTime;

}
