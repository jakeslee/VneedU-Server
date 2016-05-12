package asia.gkc.vneedu.service.impl;

import asia.gkc.vneedu.model.Judgement;
import asia.gkc.vneedu.model.Order;
import asia.gkc.vneedu.service.JudgementService;
import org.springframework.stereotype.Service;

/**
 * File Name: JudgementServiceImpl.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @since 5/12/16 9:29 AM
 */

@Service
public class JudgementServiceImpl extends BaseService<Judgement> implements JudgementService {
    /**
     * 评价订单
     *
     * @param judgement 评价
     * @param order 订单
     * @return
     */
    @Override
    public boolean judgeOrder(Judgement judgement, Order order) {
        judgementMapper.insertSelective(judgement);
        orderMapper.updateByPrimaryKeySelective(order);
        return false;
    }
}
