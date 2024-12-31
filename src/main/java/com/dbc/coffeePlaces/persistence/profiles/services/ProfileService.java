package com.dbc.coffeePlaces.persistence.profiles.services;

import com.dbc.coffeePlaces.persistence.profiles.entities.Profile;
import com.dbc.coffeePlaces.persistence.profiles.repositories.ProfileRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {
    private final ProfileRepositoryI profileRepositoryI;

    @Autowired
    public ProfileService(ProfileRepositoryI profileRepositoryI) {
        this.profileRepositoryI = profileRepositoryI;
    }

    public Optional<Profile> findOne(int id){
        return this.profileRepositoryI.findById(id);
    }

    public Page<Profile> findAll(int page, int elements){
        Pageable pageRequest = PageRequest.of(page, elements);
        return this.profileRepositoryI.findAll(pageRequest);
    }

    public Profile create(Profile profile){
        return this.profileRepositoryI.save(profile);
    }

    public Optional<Profile> update(Integer id, Profile payload){
        return this.findOne(id).map(profile ->  {
            profile.setUrl(payload.getUrl());
            profile.setCompany(payload.getCompany());
            return this.profileRepositoryI.save(profile);
        });
    }

    public void delete(int id){
        this.profileRepositoryI.deleteById(id);
    }

}
