package com.waiter.system.core.application.port;

import com.waiter.system.core.domain.Waiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaiterRepository extends JpaRepository<Waiter,Long> {
}
