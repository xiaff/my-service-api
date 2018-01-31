package me.xiaff.service.repository;

import me.xiaff.service.entity.ProxyOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProxyOrderRepo extends JpaRepository<ProxyOrder, Long> {
}
