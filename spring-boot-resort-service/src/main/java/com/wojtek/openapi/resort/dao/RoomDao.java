package com.wojtek.openapi.resort.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomDao extends JpaRepository<RoomEty, Long> {
    RoomEty findRoomEtyByName(String name);
}
