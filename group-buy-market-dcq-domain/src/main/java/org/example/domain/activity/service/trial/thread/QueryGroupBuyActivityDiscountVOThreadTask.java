package org.example.domain.activity.service.trial.thread;

import org.example.domain.activity.adapter.repository.IActivityRepository;
import org.example.domain.activity.model.valobj.GroupBuyActivityDiscountVO;

import java.util.concurrent.Callable;

public class QueryGroupBuyActivityDiscountVOThreadTask implements Callable<GroupBuyActivityDiscountVO> {


    private final String source;
    private final String chanel;

    private final IActivityRepository repository;

    public QueryGroupBuyActivityDiscountVOThreadTask(String source, String chanel, IActivityRepository repository) {
        this.source = source;
        this.chanel = chanel;
        this.repository = repository;
    }

    @Override
    public GroupBuyActivityDiscountVO call() throws Exception {
        return repository.queryGroupBuyActivityDiscountVO(source, chanel);
    }
}
