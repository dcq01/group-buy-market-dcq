package org.example.api;

import org.example.api.dto.LockMarketPayOrderRequestDTO;
import org.example.api.dto.LockMarketPayOrderResponseDTO;
import org.example.api.dto.SettlementMarketPayOrderRequestDTO;
import org.example.api.dto.SettlementMarketPayOrderResponseDTO;
import org.example.api.response.Response;

public interface IMarketTradeService {

    Response<LockMarketPayOrderResponseDTO> lockMarketPayOrder(LockMarketPayOrderRequestDTO lockMarketPayOrderRequestDTO);

    Response<SettlementMarketPayOrderResponseDTO> settlementMarketPayOrder(SettlementMarketPayOrderRequestDTO settlementMarketPayOrderRequestDTO);

}
