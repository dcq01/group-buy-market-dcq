package org.example.domain.trade.service.settlement.filter;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.trade.adapter.repository.ITradeRepository;
import org.example.domain.trade.model.entity.GroupBuyTeamEntity;
import org.example.domain.trade.model.entity.MarketPayOrderEntity;
import org.example.domain.trade.model.entity.TradeSettlementRuleCommandEntity;
import org.example.domain.trade.model.entity.TradeSettlementRuleFilterBackEntity;
import org.example.domain.trade.service.settlement.factory.TradeSettlementRuleFilterFactory;
import org.example.types.design.framework.link.model2.handler.ILogicHandler;
import org.example.types.enums.ResponseCode;
import org.example.types.exception.AppException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Slf4j
@Service
public class SettableRuleFilter implements ILogicHandler<TradeSettlementRuleCommandEntity, TradeSettlementRuleFilterFactory.DynamicContext, TradeSettlementRuleFilterBackEntity> {

    @Resource
    private ITradeRepository tradeRepository;

    @Override
    public TradeSettlementRuleFilterBackEntity apply(TradeSettlementRuleCommandEntity requestParameter, TradeSettlementRuleFilterFactory.DynamicContext dynamicContext) throws Exception {
        log.info("结算规则过滤-结算时间校验{} outTradeNo: {}", requestParameter.getUserId(), requestParameter.getOutTradeNo());

        MarketPayOrderEntity marketPayOrderEntity = dynamicContext.getMarketPayOrderEntity();
        // 2. 查询拼团信息
        GroupBuyTeamEntity groupBuyTeamEntity = tradeRepository.queryGroupBuyTeamByTeamId(marketPayOrderEntity.getTeamId());
        Date outTradeTime = requestParameter.getOutTradeTime();
        Date validStartTime = groupBuyTeamEntity.getValidStartTime();
        Date validEndTime = groupBuyTeamEntity.getValidEndTime();
        if (validEndTime.compareTo(outTradeTime) < 0) {
            throw new AppException(ResponseCode.E0106);
        }
        dynamicContext.setGroupBuyTeamEntity(groupBuyTeamEntity);
        return next(requestParameter, dynamicContext);
    }
}
