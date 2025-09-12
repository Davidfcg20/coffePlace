package com.dbc.coffeePlaces.persistence.profiles.repositories;

import com.dbc.coffeePlaces.persistence.profiles.entities.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProfileRepositoryI extends CrudRepository<Profile, Integer>, PagingAndSortingRepository<Profile, Integer> {
}
