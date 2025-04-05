package org.example.api;

import org.example.api.dto.GoodsMarketRequestDTO;
import org.example.api.dto.GoodsMarketResponseDTO;
import org.example.api.response.Response;

public interface IMarketIndexService {

    Response<GoodsMarketResponseDTO> queryGroupBuyMarketConfig(GoodsMarketRequestDTO goodsMarketRequestDTO);

}
