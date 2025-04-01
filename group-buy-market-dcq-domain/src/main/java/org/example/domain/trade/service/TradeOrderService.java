package org.example.domain.trade.service;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.trade.adapter.repository.ITradeRepository;
import org.example.domain.trade.model.aggregate.GroupBuyOrderAggregate;
import org.example.domain.trade.model.entity.MarketPayOrderEntity;
import org.example.domain.trade.model.entity.PayActivityEntity;
import org.example.domain.trade.model.entity.PayDiscountEntity;
import org.example.domain.trade.model.entity.UserEntity;
import org.example.domain.trade.model.valobj.GroupBuyProgressVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class TradeOrderService implements ITradeOrderService {

    @Resource
    private ITradeRepository tradeRepository;

    @Override
    public MarketPayOrderEntity queryNoPayMarketPayOrderByOutTradeNo(String userId, String outTradeNo) {
        return tradeRepository.queryNoPayMarketPayOrderByOutTradeNo(userId, outTradeNo);
    }

    @Override
    public GroupBuyProgressVO queryGroupBuyProgress(String teamId) {
        return tradeRepository.queryGroupBuyProgress(teamId);
    }

    @Override
    public MarketPayOrderEntity lockMarketPayOrder(UserEntity userEntity, PayActivityEntity payActivityEntity, PayDiscountEntity payDiscountEntity) {
        GroupBuyOrderAggregate groupBuyOrderAggregate = GroupBuyOrderAggregate.builder()
                .userEntity(userEntity)
                .payActivityEntity(payActivityEntity)
                .payDiscountEntity(payDiscountEntity)
                .build();

        return tradeRepository.lockMarketPayOrder(groupBuyOrderAggregate);
    }
}
