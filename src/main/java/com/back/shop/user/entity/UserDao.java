package com.back.shop.user.entity;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static com.back.shop.user.entity.QUser.user;
import static com.back.shop.order.entity.QOrder.order;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Tuple> getUsers(Long offset, Long size, String name, String email) {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        return jpaQueryFactory.query()
                .select(user, order)
                .from(user)
                .leftJoin(order).on(order.id.eq(
                        JPAExpressions
                                .select(order.id.max())
                                .from(order)
                                .where(order.userId.eq(user.id))
                ))
                .where(user.name.contains(name)
                        .or(user.email.contains(email)))
                .offset(offset)
                .limit(size)
                .fetch();
    }
}
