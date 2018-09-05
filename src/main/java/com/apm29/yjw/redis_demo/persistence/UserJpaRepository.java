package com.apm29.yjw.redis_demo.persistence;
import com.apm29.yjw.redis_demo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserJpaRepository extends JpaRepository<User,Long> ,JpaSpecificationExecutor {
    User findByUserName(String userName);

    @Override
    Page<User> findAll(Pageable pageable);

    User findByUserNameIs(String userName);

}
