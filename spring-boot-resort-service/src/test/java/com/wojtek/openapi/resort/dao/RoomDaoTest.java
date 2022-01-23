package com.wojtek.openapi.resort.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class RoomDaoTest {

    @Autowired
    private RoomDao roomDao;

    @BeforeEach
    public void before() {
        this.roomDao.deleteAll();
    }

    @Test
    public void saveRoomTest() {
        this.roomDao.save(createRoom("room1"));
        this.roomDao.save(createRoom("room2"));
        this.roomDao.save(createRoom("room3"));

        List<RoomEty> rooms = this.roomDao.findAll();

        assertThat(rooms).extracting(RoomEty::getName).contains("room1", "room2", "room3");
    }

    @Test
    public void deleteRoomTest() {
        RoomEty room1 = createRoom("room1");
        RoomEty room2 = createRoom("room2");
        RoomEty room3 = createRoom("room3");

        this.roomDao.save(room1);
        this.roomDao.save(room2);
        this.roomDao.save(room3);
        this.roomDao.delete(room1);

        List<RoomEty> rooms = this.roomDao.findAll();

        assertThat(rooms).extracting(RoomEty::getName).contains("room2", "room3");
    }

    @Test
    public void findByNameTest() {
        this.roomDao.save(createRoom("room1"));
        this.roomDao.save(createRoom("room2"));
        this.roomDao.save(createRoom("room3"));

        RoomEty room = this.roomDao.findRoomEtyByName("room2");

        assertThat(room.getName()).isEqualTo("room2");
    }

    private RoomEty createRoom(String name) {
        RoomEty room = new RoomEty();
        room.setName(name);
        return room;
    }
}