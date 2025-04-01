package org.example.domain.activity.service.trial.node;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.activity.model.entity.MarketProductEntity;
import org.example.domain.activity.model.entity.TrialBalanceEntity;
import org.example.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import org.example.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import org.example.types.design.framework.tree.StrategyHandler;
import org.example.types.enums.ResponseCode;
import org.example.types.exception.AppException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class SwitchRoot extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {

    @Resource
    private MarketNode marketNode;

    @Override
    public TrialBalanceEntity doApply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {

        String userId = requestParameter.getUserId();

        if (repository.downgradeSwitch()) {
            throw new AppException(ResponseCode.E0003.getCode(), ResponseCode.E0003.getInfo());
        }

        if (!repository.cutRange(userId)) {
            throw new AppException(ResponseCode.E0004.getCode(), ResponseCode.E0004.getInfo());
        }


        return router(requestParameter, dynamicContext);
    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) {
        return marketNode;
    }
}
