package learning.tacocloud.hungnv.data;

import learning.tacocloud.hungnv.entity.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
