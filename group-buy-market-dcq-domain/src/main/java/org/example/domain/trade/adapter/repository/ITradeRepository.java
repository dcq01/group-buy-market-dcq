package org.example.domain.trade.adapter.repository;

import org.example.domain.trade.model.aggregate.GroupBuyOrderAggregate;
import org.example.domain.trade.model.aggregate.GroupBuyTeamSettlementAggregate;
import org.example.domain.trade.model.entity.GroupBuyActivityEntity;
import org.example.domain.trade.model.entity.GroupBuyTeamEntity;
import org.example.domain.trade.model.entity.MarketPayOrderEntity;
import org.example.domain.trade.model.entity.NotifyTaskEntity;
import org.example.domain.trade.model.valobj.GroupBuyProgressVO;

import java.util.List;

public interface ITradeRepository {
    MarketPayOrderEntity queryNoPayMarketPayOrderByOutTradeNo(String userId, String outTradeNo);

    GroupBuyProgressVO queryGroupBuyProgress(String teamId);

    MarketPayOrderEntity lockMarketPayOrder(GroupBuyOrderAggregate groupBuyOrderAggregate);

    GroupBuyActivityEntity queryGroupBuyActivityByActivityId(Long activityId);

    Integer queryOrderCountByActivityId(Long activityId, String userId);

    GroupBuyTeamEntity queryGroupBuyTeamByTeamId(String teamId);

    void settlementMarketPayOrder(GroupBuyTeamSettlementAggregate groupBuyTeamSettlementAggregate);

    boolean isSCBlackIntercept(String source, String channel);

    List<NotifyTaskEntity> queryUnExecutedNotifyTaskList();

    Integer updateNotifyTaskStatusSuccess(String teamId);

    Integer updateNotifyTaskStatusError(String teamId);

    Integer updateNotifyTaskStatusRetry(String teamId);

    List<NotifyTaskEntity> queryUnExecutedNotifyTaskList(String teamId);
}
