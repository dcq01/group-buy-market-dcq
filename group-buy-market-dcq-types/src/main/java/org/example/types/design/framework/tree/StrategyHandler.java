package org.example.types.design.framework.tree;

/**
 * @author 咳咳
 * @description 策略处理器
 * @create 25-03-25 20:28
 */
public interface StrategyHandler<T, D, R> {

    StrategyHandler DEFAULT = (T, D) -> null;

    R apply(T requestParameter, D dynamicContext) throws Exception;
}
