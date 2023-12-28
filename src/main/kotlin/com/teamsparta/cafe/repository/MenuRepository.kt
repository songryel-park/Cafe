package com.teamsparta.cafe.repository

import com.teamsparta.cafe.entity.Menu
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MenuRepository: JpaRepository<Menu, Long>