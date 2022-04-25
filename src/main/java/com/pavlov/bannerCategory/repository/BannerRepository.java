package com.pavlov.bannerCategory.repository;

import com.pavlov.bannerCategory.entity.Banner;
import com.pavlov.bannerCategory.entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Repository
public interface BannerRepository extends SearchRepository<Banner, Integer> {

    @Override
    @Query("select b from Banner b " +
            "where lower(b.name) like :#{#substring} " +
            "and b.isDeleted = false")
    List<Banner> search(String substring);

    List<Banner> findDistinctByCategoriesInOrderByPriceDesc (List<Category> categories);

    @Query( "select b from Banner b "+
            "left join LogRecord lr on lr.banner.id = b.id " +
            "where b.isDeleted = false " +
            "and ((lr.userAgent = :#{#userAgent} " +
            "and lr.ipAddress = :#{#ipAddress} " +
            "and lr.requestTime < :#{#date}) " +
            "or (lr.userAgent = null " +
            "and lr.ipAddress = null " +
            "and lr.requestTime = null))" +
            "order by b.price desc")
    List<Banner> findBannersByUserAgentAndIpAndNewerThenDate(String userAgent,String ipAddress, LocalDateTime date);

    default List<Banner>findBannersByUserAgentAndIp(String userAgent, String ipAddress){
        return findBannersByUserAgentAndIpAndNewerThenDate( userAgent,ipAddress,LocalDateTime.now().minus(1, ChronoUnit.DAYS));
    }

    Optional<Banner> findByNameAndIsDeletedIsFalse(String name);
}
