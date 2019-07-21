package me.zhengjie.modules.monitor.service;

import org.springframework.scheduling.annotation.Async;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Zheng Jie
 * @date 2018-12-13
 */
public interface VisitsService {

    /**
     * 提供给定时任务，每天0点执行
     */
    void save();

    /**
     * 新增记录
     *
     * @param request Request
     */
    @Async
    void count(HttpServletRequest request);

    /**
     * 获取数据
     *
     * @return 结果
     */
    Object get();

    /**
     * getChartData
     *
     * @return 结果
     */
    Object getChartData();
}
