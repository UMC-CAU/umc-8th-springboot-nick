package umc.spring.repository;

import org.springframework.data.repository.CrudRepository;
import umc.spring.domain.Store;

public interface StoreRepository extends CrudRepository<Store, Long>, StoreRepositoryCustom {
}
