package com.travel.agency.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.agency.base.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
