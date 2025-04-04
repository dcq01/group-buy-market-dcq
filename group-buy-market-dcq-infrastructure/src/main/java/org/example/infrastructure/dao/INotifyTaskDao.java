package org.example.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.dao.po.NotifyTask;

import java.util.List;

@Mapper
public interface INotifyTaskDao {
    void insert(NotifyTask notifyTask);

    List<NotifyTask> queryUnExecutedNotifyTaskList();

    NotifyTask queryUnExecutedNotifyTaskByTeamId(String teamId);

    Integer updateNotifyTaskStatusSuccess(String teamId);

    Integer updateNotifyTaskStatusError(String teamId);

    Integer updateNotifyTaskStatusRetry(String teamId);
}
