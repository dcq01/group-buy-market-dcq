package org.example.domain.trade.adapter.repository;

import org.example.domain.trade.model.aggregate.GroupBuyOrderAggregate;
import org.example.domain.trade.model.entity.MarketPayOrderEntity;
import org.example.domain.trade.model.valobj.GroupBuyProgressVO;

public interface ITradeRepository {
    MarketPayOrderEntity queryNoPayMarketPayOrderByOutTradeNo(String userId, String outTradeNo);

    GroupBuyProgressVO queryGroupBuyProgress(String teamId);

    MarketPayOrderEntity lockMarketPayOrder(GroupBuyOrderAggregate groupBuyOrderAggregate);
}
