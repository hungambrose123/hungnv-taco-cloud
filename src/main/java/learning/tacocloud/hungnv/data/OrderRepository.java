package learning.tacocloud.hungnv.data;

import learning.tacocloud.hungnv.entity.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
}
