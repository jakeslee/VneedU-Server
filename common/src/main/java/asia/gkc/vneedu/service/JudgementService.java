package asia.gkc.vneedu.service;

import asia.gkc.vneedu.model.Judgement;
import asia.gkc.vneedu.model.Order;

/**
 * File Name: JudgementService.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @since 5/12/16 9:28 AM
 */

public interface JudgementService extends IService<Judgement> {
    /**
     * 评价订单
     *
     * @param judgement 评价
     * @param order 订单
     * @return
     */
    boolean judgeOrder(Judgement judgement, Order order);
}
