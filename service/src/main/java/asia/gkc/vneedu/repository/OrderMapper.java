package asia.gkc.vneedu.repository;

import asia.gkc.vneedu.model.Order;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OrderMapper extends Mapper<Order> {
    /**
     * 通过用户ID获取订单
     *
     * @param uid 用户ID
     * @param status 状态（-2表示显示所有）
     * @param removed 是否显示移除的（0标识不显示,1标识显示所有）
     * @return
     */
    List<Order> getOrdersByUserId(@Param("uid") String uid,
                                  @Param("status") int status,
                                  @Param("removed") int removed);
}